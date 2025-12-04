package pe.gob.reniec.datosparentesco.domain.model;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Aggregate Root - Representa un análisis de parentesco en el dominio.
 * Encapsula las reglas de negocio y garantiza la consistencia de los datos.
 */
public class AnalisisParentesco {
    
    private static final int LONGITUD_MINIMA_ID_SOLICITUD = 5;
    private static final int LONGITUD_MAXIMA_ID_SOLICITUD = 50;
    private static final int LONGITUD_MAXIMA_OBSERVACIONES = 1000;
    private static final int LONGITUD_MINIMA_OBSERVACIONES = 0;
    private static final int LONGITUD_MINIMA_RESULTADO = 10;
    private static final int LONGITUD_MAXIMA_RESULTADO = 2000;
    private static final int LONGITUD_MINIMA_USUARIO = 3;
    private static final int LONGITUD_MAXIMA_USUARIO = 50;
    
    private String idAnalisis;
    private final String idSolicitud;
    private final IdentificadorCiudadano ciudadanoConsultado;
    private final TipoVinculo tipoVinculo;
    private final Integer nivelComplejidad;
    private CriteriosBusqueda criteriosBusqueda;
    private EstadoAnalisis estado;
    private String resultadoAnalisis;
    private final String usuarioTecnico;
    private final LocalDateTime fechaCreacion;
    private LocalDateTime fechaModificacion;
    private String observaciones;
    
    // Constructor privado para reconstrucción desde persistencia
    private AnalisisParentesco(String idAnalisis, String idSolicitud, IdentificadorCiudadano ciudadanoConsultado,
                              TipoVinculo tipoVinculo, Integer nivelComplejidad, CriteriosBusqueda criteriosBusqueda,
                              EstadoAnalisis estado, String resultadoAnalisis, String usuarioTecnico,
                              LocalDateTime fechaCreacion, LocalDateTime fechaModificacion, String observaciones) {
        this.idAnalisis = idAnalisis;
        this.idSolicitud = idSolicitud;
        this.ciudadanoConsultado = ciudadanoConsultado;
        this.tipoVinculo = tipoVinculo;
        this.nivelComplejidad = nivelComplejidad;
        this.criteriosBusqueda = criteriosBusqueda;
        this.estado = estado;
        this.resultadoAnalisis = resultadoAnalisis;
        this.usuarioTecnico = usuarioTecnico;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this.observaciones = observaciones;
    }
    
    /**
     * Factory method para crear un nuevo análisis de parentesco.
     * Valida todas las reglas de negocio.
     */
    public static AnalisisParentesco crear(String idSolicitud, 
                                          IdentificadorCiudadano ciudadanoConsultado,
                                          TipoVinculo tipoVinculo,
                                          CriteriosBusqueda criteriosBusqueda,
                                          String usuarioTecnico,
                                          String observaciones) {
        validarIdSolicitud(idSolicitud);
        validarUsuarioTecnico(usuarioTecnico);
        validarObservaciones(observaciones);
        
        Objects.requireNonNull(ciudadanoConsultado, "El ciudadano consultado no puede ser nulo");
        Objects.requireNonNull(tipoVinculo, "El tipo de vínculo no puede ser nulo");
        Objects.requireNonNull(criteriosBusqueda, "Los criterios de búsqueda no pueden ser nulos");
        
        // El nivel de complejidad se calcula automáticamente basado en los criterios
        int nivelComplejidad = calcularNivelComplejidad(criteriosBusqueda);
        
        return new AnalisisParentesco(
            null, // El ID se asigna al persistir
            idSolicitud,
            ciudadanoConsultado,
            tipoVinculo,
            nivelComplejidad,
            criteriosBusqueda,
            EstadoAnalisis.PENDIENTE, // Estado inicial
            null, // Sin resultado aún
            usuarioTecnico,
            LocalDateTime.now(),
            null, // No hay modificación aún
            observaciones
        );
    }
    
    /**
     * Factory method para reconstruir un análisis desde persistencia.
     */
    public static AnalisisParentesco reconstruir(String idAnalisis, String idSolicitud,
                                                IdentificadorCiudadano ciudadanoConsultado,
                                                TipoVinculo tipoVinculo, Integer nivelComplejidad,
                                                CriteriosBusqueda criteriosBusqueda, EstadoAnalisis estado,
                                                String resultadoAnalisis, String usuarioTecnico,
                                                LocalDateTime fechaCreacion, LocalDateTime fechaModificacion,
                                                String observaciones) {
        return new AnalisisParentesco(idAnalisis, idSolicitud, ciudadanoConsultado, tipoVinculo,
                                     nivelComplejidad, criteriosBusqueda, estado, resultadoAnalisis,
                                     usuarioTecnico, fechaCreacion, fechaModificacion, observaciones);
    }
    
    /**
     * Calcula el nivel de complejidad basado en los criterios de búsqueda.
     * Lógica de negocio: más criterios = mayor complejidad.
     */
    private static int calcularNivelComplejidad(CriteriosBusqueda criterios) {
        int complejidad = criterios.calcularComplejidad();
        
        // Normalizar a escala 1-5
        if (complejidad == 0) return 1;
        if (complejidad <= 2) return 2;
        if (complejidad <= 4) return 3;
        if (complejidad <= 6) return 4;
        return 5;
    }
    
    /**
     * Inicia el procesamiento del análisis.
     * Regla de negocio: Solo puede iniciarse si está PENDIENTE.
     */
    public void iniciarProcesamiento() {
        if (!estado.puedeTransicionarA(EstadoAnalisis.EN_PROCESO)) {
            throw new IllegalStateException(
                String.format("No se puede iniciar el procesamiento desde el estado %s", estado)
            );
        }
        this.estado = EstadoAnalisis.EN_PROCESO;
        this.fechaModificacion = LocalDateTime.now();
    }
    
    /**
     * Completa el análisis con un resultado.
     * Regla de negocio: Solo puede completarse si está EN_PROCESO.
     */
    public void completarConResultado(String resultado) {
        if (!estado.puedeTransicionarA(EstadoAnalisis.COMPLETADO)) {
            throw new IllegalStateException(
                String.format("No se puede completar el análisis desde el estado %s", estado)
            );
        }
        validarResultadoAnalisis(resultado);
        
        this.resultadoAnalisis = resultado;
        this.estado = EstadoAnalisis.COMPLETADO;
        this.fechaModificacion = LocalDateTime.now();
    }
    
    /**
     * Valida el análisis completado.
     * Regla de negocio: Solo puede validarse si está COMPLETADO.
     */
    public void validar() {
        if (!estado.puedeTransicionarA(EstadoAnalisis.VALIDADO)) {
            throw new IllegalStateException(
                String.format("No se puede validar el análisis desde el estado %s", estado)
            );
        }
        this.estado = EstadoAnalisis.VALIDADO;
        this.fechaModificacion = LocalDateTime.now();
    }
    
    /**
     * Rechaza el análisis con observaciones obligatorias.
     * Regla de negocio: Puede rechazarse desde EN_PROCESO o COMPLETADO.
     */
    public void rechazar(String motivoRechazo) {
        if (!estado.puedeTransicionarA(EstadoAnalisis.RECHAZADO)) {
            throw new IllegalStateException(
                String.format("No se puede rechazar el análisis desde el estado %s", estado)
            );
        }
        
        if (motivoRechazo == null || motivoRechazo.trim().isEmpty()) {
            throw new IllegalArgumentException("El motivo de rechazo es obligatorio");
        }
        
        this.observaciones = motivoRechazo;
        this.estado = EstadoAnalisis.RECHAZADO;
        this.fechaModificacion = LocalDateTime.now();
    }
    
    /**
     * Cancela el análisis.
     * Regla de negocio: Puede cancelarse desde PENDIENTE, EN_PROCESO.
     */
    public void cancelar(String motivoCancelacion) {
        if (!estado.puedeTransicionarA(EstadoAnalisis.CANCELADO)) {
            throw new IllegalStateException(
                String.format("No se puede cancelar el análisis desde el estado %s", estado)
            );
        }
        
        this.observaciones = motivoCancelacion;
        this.estado = EstadoAnalisis.CANCELADO;
        this.fechaModificacion = LocalDateTime.now();
    }
    
    /**
     * Actualiza los criterios de búsqueda.
     * Regla de negocio: Solo se pueden actualizar si NO está en estado final.
     */
    public void actualizarCriterios(CriteriosBusqueda nuevosCriterios) {
        if (estado.esFinal()) {
            throw new IllegalStateException(
                "No se pueden actualizar los criterios en un análisis en estado final"
            );
        }
        
        Objects.requireNonNull(nuevosCriterios, "Los criterios de búsqueda no pueden ser nulos");
        this.criteriosBusqueda = nuevosCriterios;
        this.nivelComplejidad = calcularNivelComplejidad(nuevosCriterios);
        this.fechaModificacion = LocalDateTime.now();
    }
    
    /**
     * Actualiza las observaciones del análisis.
     */
    public void actualizarObservaciones(String nuevasObservaciones) {
        validarObservaciones(nuevasObservaciones);
        this.observaciones = nuevasObservaciones;
        this.fechaModificacion = LocalDateTime.now();
    }
    
    /**
     * Verifica si el análisis está activo (no está en estado final).
     */
    public boolean estaActivo() {
        return !estado.esFinal();
    }
    
    /**
     * Verifica si el análisis puede ser modificado.
     */
    public boolean puedeSerModificado() {
        return estado == EstadoAnalisis.PENDIENTE || estado == EstadoAnalisis.EN_PROCESO;
    }
    
    // Validaciones privadas
    private static void validarIdSolicitud(String idSolicitud) {
        if (idSolicitud == null || idSolicitud.trim().isEmpty()) {
            throw new IllegalArgumentException("El ID de solicitud no puede ser nulo o vacío");
        }
        
        if (idSolicitud.length() < LONGITUD_MINIMA_ID_SOLICITUD || 
            idSolicitud.length() > LONGITUD_MAXIMA_ID_SOLICITUD) {
            throw new IllegalArgumentException(
                String.format("El ID de solicitud debe tener entre %d y %d caracteres", 
                    LONGITUD_MINIMA_ID_SOLICITUD, LONGITUD_MAXIMA_ID_SOLICITUD)
            );
        }
    }
    
    private static void validarUsuarioTecnico(String usuario) {
        if (usuario == null || usuario.trim().isEmpty()) {
            throw new IllegalArgumentException("El usuario técnico no puede ser nulo o vacío");
        }
        
        if (usuario.length() < LONGITUD_MINIMA_USUARIO || usuario.length() > LONGITUD_MAXIMA_USUARIO) {
            throw new IllegalArgumentException(
                String.format("El usuario técnico debe tener entre %d y %d caracteres",
                    LONGITUD_MINIMA_USUARIO, LONGITUD_MAXIMA_USUARIO)
            );
        }
    }
    
    private static void validarObservaciones(String observaciones) {
        if (observaciones != null && observaciones.length() > LONGITUD_MAXIMA_OBSERVACIONES) {
            throw new IllegalArgumentException(
                String.format("Las observaciones no pueden exceder %d caracteres", LONGITUD_MAXIMA_OBSERVACIONES)
            );
        }
    }
    
    private static void validarResultadoAnalisis(String resultado) {
        if (resultado == null || resultado.trim().isEmpty()) {
            throw new IllegalArgumentException("El resultado del análisis no puede ser nulo o vacío");
        }
        
        if (resultado.length() < LONGITUD_MINIMA_RESULTADO || resultado.length() > LONGITUD_MAXIMA_RESULTADO) {
            throw new IllegalArgumentException(
                String.format("El resultado debe tener entre %d y %d caracteres",
                    LONGITUD_MINIMA_RESULTADO, LONGITUD_MAXIMA_RESULTADO)
            );
        }
    }
    
    // Getters
    public String getIdAnalisis() {
        return idAnalisis;
    }
    
    public String getIdSolicitud() {
        return idSolicitud;
    }
    
    public IdentificadorCiudadano getCiudadanoConsultado() {
        return ciudadanoConsultado;
    }
    
    public TipoVinculo getTipoVinculo() {
        return tipoVinculo;
    }
    
    public Integer getNivelComplejidad() {
        return nivelComplejidad;
    }
    
    public CriteriosBusqueda getCriteriosBusqueda() {
        return criteriosBusqueda;
    }
    
    public EstadoAnalisis getEstado() {
        return estado;
    }
    
    public String getResultadoAnalisis() {
        return resultadoAnalisis;
    }
    
    public String getUsuarioTecnico() {
        return usuarioTecnico;
    }
    
    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }
    
    public LocalDateTime getFechaModificacion() {
        return fechaModificacion;
    }
    
    public String getObservaciones() {
        return observaciones;
    }
    
    // Setter necesario para la persistencia (asignación del ID)
    public void asignarId(String idAnalisis) {
        if (this.idAnalisis != null) {
            throw new IllegalStateException("El ID del análisis ya ha sido asignado");
        }
        this.idAnalisis = idAnalisis;
    }
    
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
                "idAnalisis='" + idAnalisis + '\'' +
                ", idSolicitud='" + idSolicitud + '\'' +
                ", ciudadanoConsultado=" + ciudadanoConsultado +
                ", tipoVinculo=" + tipoVinculo +
                ", estado=" + estado +
                ", nivelComplejidad=" + nivelComplejidad +
                '}';
    }
}
