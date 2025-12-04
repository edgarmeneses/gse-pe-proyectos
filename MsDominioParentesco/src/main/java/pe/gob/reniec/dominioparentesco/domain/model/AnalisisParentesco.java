package pe.gob.reniec.dominioparentesco.domain.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Aggregate Root - Representa un análisis completo de parentesco.
 * Encapsula todas las reglas de negocio del proceso de análisis.
 * 
 * Este es el núcleo del dominio y coordina:
 * - La identificación del ciudadano a analizar
 * - El descubrimiento y validación de vínculos
 * - Las inconsistencias encontradas
 * - El estado del análisis
 */
public class AnalisisParentesco {
    
    private final String idAnalisis;
    private final Ciudadano ciudadanoAnalizado;
    private final TipoVinculo tipoVinculoBuscado;
    private final int profundidadAnalisis;
    private EstadoAnalisis estado;
    private final List<Vinculo> vinculosEncontrados;
    private final List<DeteccionInconsistencia> inconsistencias;
    private final LocalDateTime fechaInicio;
    private LocalDateTime fechaFinalizacion;
    private final String usuarioSolicitante;
    private String observaciones;
    
    private AnalisisParentesco(String idAnalisis, Ciudadano ciudadanoAnalizado,
                              TipoVinculo tipoVinculoBuscado, int profundidadAnalisis,
                              String usuarioSolicitante) {
        this.idAnalisis = idAnalisis;
        this.ciudadanoAnalizado = Objects.requireNonNull(ciudadanoAnalizado, 
            "El ciudadano a analizar no puede ser nulo");
        this.tipoVinculoBuscado = Objects.requireNonNull(tipoVinculoBuscado,
            "El tipo de vínculo buscado no puede ser nulo");
        this.profundidadAnalisis = validarProfundidad(profundidadAnalisis);
        this.usuarioSolicitante = Objects.requireNonNull(usuarioSolicitante,
            "El usuario solicitante no puede ser nulo");
        this.estado = EstadoAnalisis.SOLICITADO;
        this.vinculosEncontrados = new ArrayList<>();
        this.inconsistencias = new ArrayList<>();
        this.fechaInicio = LocalDateTime.now();
    }
    
    /**
     * Factory method para iniciar un nuevo análisis de parentesco.
     */
    public static AnalisisParentesco iniciar(Ciudadano ciudadano, TipoVinculo tipoVinculo,
                                            int profundidad, String usuarioSolicitante) {
        return new AnalisisParentesco(null, ciudadano, tipoVinculo, 
                                     profundidad, usuarioSolicitante);
    }
    
    /**
     * Factory method para reconstruir un análisis desde persistencia.
     */
    public static AnalisisParentesco reconstruir(String idAnalisis, Ciudadano ciudadano,
                                                TipoVinculo tipoVinculo, int profundidad,
                                                EstadoAnalisis estado, List<Vinculo> vinculos,
                                                String usuarioSolicitante, LocalDateTime fechaInicio) {
        AnalisisParentesco analisis = new AnalisisParentesco(
            idAnalisis, ciudadano, tipoVinculo, profundidad, usuarioSolicitante);
        analisis.estado = estado;
        analisis.vinculosEncontrados.addAll(vinculos);
        return analisis;
    }
    
    private int validarProfundidad(int profundidad) {
        if (profundidad < 1 || profundidad > 4) {
            throw new IllegalArgumentException(
                "La profundidad del análisis debe estar entre 1 y 4 grados");
        }
        return profundidad;
    }
    
    /**
     * Inicia la ejecución del análisis.
     * Regla de negocio: Solo se puede iniciar si está en estado SOLICITADO.
     */
    public void iniciarEjecucion() {
        if (!estado.puedeTransicionarA(EstadoAnalisis.EN_PROCESO)) {
            throw new IllegalStateException(
                "No se puede iniciar el análisis desde el estado actual: " + estado);
        }
        this.estado = EstadoAnalisis.EN_PROCESO;
    }
    
    /**
     * Registra un vínculo encontrado durante el análisis.
     * Regla de negocio: Solo se pueden registrar vínculos durante la ejecución.
     */
    public void registrarVinculoEncontrado(Vinculo vinculo) {
        validarAnalisisEnProceso();
        
        Objects.requireNonNull(vinculo, "El vínculo no puede ser nulo");
        
        // Validar que el vínculo involucra al ciudadano analizado
        if (!vinculo.getOrigen().equals(ciudadanoAnalizado) && 
            !vinculo.getDestino().equals(ciudadanoAnalizado)) {
            throw new IllegalArgumentException(
                "El vínculo debe involucrar al ciudadano analizado");
        }
        
        // Validar que el vínculo no esté duplicado
        if (vinculosEncontrados.contains(vinculo)) {
            return; // Ignorar duplicados
        }
        
        // Validar coherencia del tipo de vínculo
        if (!esTipoVinculoCompatible(vinculo.getTipo())) {
            registrarInconsistencia(
                TipoInconsistencia.TIPO_VINCULO_INCOMPATIBLE,
                "Vínculo de tipo " + vinculo.getTipo().getDescripcion() + 
                " no corresponde con el análisis de " + tipoVinculoBuscado.getDescripcion(),
                List.of(vinculo.getOrigen(), vinculo.getDestino())
            );
        }
        
        vinculosEncontrados.add(vinculo);
    }
    
    private boolean esTipoVinculoCompatible(TipoVinculo tipoEncontrado) {
        // Si busco vínculos consanguíneos, solo acepto consanguíneos
        // Si busco vínculos de afinidad, solo acepto afinidad
        return tipoVinculoBuscado.getCategoria() == tipoEncontrado.getCategoria();
    }
    
    /**
     * Registra una inconsistencia detectada durante el análisis.
     */
    public void registrarInconsistencia(TipoInconsistencia tipo, String descripcion,
                                       List<Ciudadano> ciudadanosAfectados) {
        validarAnalisisEnProceso();
        
        DeteccionInconsistencia inconsistencia = new DeteccionInconsistencia(
            tipo, descripcion, ciudadanosAfectados, LocalDateTime.now());
        inconsistencias.add(inconsistencia);
    }
    
    /**
     * Completa el análisis exitosamente.
     * Regla de negocio: Un análisis se marca como completado cuando:
     * - Está en proceso
     * - Se han encontrado vínculos O se justifica su ausencia
     */
    public void completar() {
        validarAnalisisEnProceso();
        
        this.fechaFinalizacion = LocalDateTime.now();
        
        // Si hay inconsistencias críticas, completar con observaciones
        if (tieneInconsistenciasCriticas() || tieneVinculosConBajaConfianza()) {
            this.estado = EstadoAnalisis.COMPLETADO_CON_OBSERVACIONES;
        } else {
            this.estado = EstadoAnalisis.COMPLETADO;
        }
    }
    
    /**
     * Marca el análisis como fallido.
     */
    public void marcarComoFallido(String razon) {
        validarAnalisisEnProceso();
        
        if (!estado.puedeTransicionarA(EstadoAnalisis.FALLIDO)) {
            throw new IllegalStateException(
                "No se puede marcar como fallido desde el estado: " + estado);
        }
        
        this.estado = EstadoAnalisis.FALLIDO;
        this.observaciones = razon;
        this.fechaFinalizacion = LocalDateTime.now();
    }
    
    /**
     * Cancela el análisis.
     */
    public void cancelar(String razon) {
        if (!estado.puedeTransicionarA(EstadoAnalisis.CANCELADO)) {
            throw new IllegalStateException(
                "No se puede cancelar desde el estado: " + estado);
        }
        
        this.estado = EstadoAnalisis.CANCELADO;
        this.observaciones = razon;
        this.fechaFinalizacion = LocalDateTime.now();
    }
    
    private void validarAnalisisEnProceso() {
        if (estado != EstadoAnalisis.EN_PROCESO) {
            throw new IllegalStateException(
                "Esta operación solo puede realizarse cuando el análisis está en proceso");
        }
    }
    
    /**
     * Calcula estadísticas del análisis.
     */
    public EstadisticasAnalisis calcularEstadisticas() {
        long vinculosPrimerGrado = contarVinculosPorGrado(1);
        long vinculosSegundoGrado = contarVinculosPorGrado(2);
        long vinculosTercerGrado = contarVinculosPorGrado(3);
        long vinculosCuartoGrado = contarVinculosPorGrado(4);
        long vinculosConfiables = contarVinculosConfiables();
        long vinculosRequierenValidacion = contarVinculosQueRequierenValidacion();
        
        return new EstadisticasAnalisis(
            vinculosEncontrados.size(),
            (int) vinculosPrimerGrado,
            (int) vinculosSegundoGrado,
            (int) vinculosTercerGrado,
            (int) vinculosCuartoGrado,
            (int) vinculosConfiables,
            (int) vinculosRequierenValidacion,
            inconsistencias.size()
        );
    }
    
    private long contarVinculosPorGrado(int grado) {
        return vinculosEncontrados.stream()
            .filter(v -> v.getTipo().getGrado() == grado)
            .count();
    }
    
    private long contarVinculosConfiables() {
        return vinculosEncontrados.stream()
            .filter(Vinculo::esConfiable)
            .count();
    }
    
    private long contarVinculosQueRequierenValidacion() {
        return vinculosEncontrados.stream()
            .filter(Vinculo::requiereValidacionManual)
            .count();
    }
    
    private boolean tieneInconsistenciasCriticas() {
        return inconsistencias.stream()
            .anyMatch(DeteccionInconsistencia::esCritica);
    }
    
    private boolean tieneVinculosConBajaConfianza() {
        return vinculosEncontrados.stream()
            .anyMatch(v -> v.getNivelConfianza() == NivelConfianza.BAJO);
    }
    
    /**
     * Obtiene los vínculos encontrados por grado.
     */
    public List<Vinculo> obtenerVinculosPorGrado(int grado) {
        return vinculosEncontrados.stream()
            .filter(v -> v.getTipo().getGrado() == grado)
            .collect(Collectors.toList());
    }
    
    /**
     * Obtiene los vínculos que requieren validación manual.
     */
    public List<Vinculo> obtenerVinculosQueRequierenValidacion() {
        return vinculosEncontrados.stream()
            .filter(Vinculo::requiereValidacionManual)
            .collect(Collectors.toList());
    }
    
    public long calcularTiempoProcesamiento() {
        if (fechaFinalizacion == null) {
            return -1; // Análisis no finalizado
        }
        return java.time.Duration.between(fechaInicio, fechaFinalizacion).toMillis();
    }
    
    // Getters
    public String getIdAnalisis() { return idAnalisis; }
    public Ciudadano getCiudadanoAnalizado() { return ciudadanoAnalizado; }
    public TipoVinculo getTipoVinculoBuscado() { return tipoVinculoBuscado; }
    public int getProfundidadAnalisis() { return profundidadAnalisis; }
    public EstadoAnalisis getEstado() { return estado; }
    public List<Vinculo> getVinculosEncontrados() { 
        return Collections.unmodifiableList(vinculosEncontrados); 
    }
    public List<DeteccionInconsistencia> getInconsistencias() { 
        return Collections.unmodifiableList(inconsistencias); 
    }
    public LocalDateTime getFechaInicio() { return fechaInicio; }
    public LocalDateTime getFechaFinalizacion() { return fechaFinalizacion; }
    public String getUsuarioSolicitante() { return usuarioSolicitante; }
    public String getObservaciones() { return observaciones; }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnalisisParentesco that = (AnalisisParentesco) o;
        return Objects.equals(idAnalisis, that.idAnalisis);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(idAnalisis);
    }
    
    @Override
    public String toString() {
        return "AnalisisParentesco{" +
                "ciudadano=" + ciudadanoAnalizado.getNombreCompleto() +
                ", estado=" + estado +
                ", vínculos=" + vinculosEncontrados.size() +
                '}';
    }
}
