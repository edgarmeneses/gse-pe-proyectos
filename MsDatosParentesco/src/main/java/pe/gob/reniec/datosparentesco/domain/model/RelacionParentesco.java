package pe.gob.reniec.datosparentesco.domain.model;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Aggregate Root - Representa una relación de parentesco en el dominio.
 * Encapsula las reglas de negocio sobre relaciones familiares.
 */
public class RelacionParentesco {
    
    private static final int GRADO_MINIMO = 1;
    private static final int GRADO_MAXIMO = 10;
    private static final int LONGITUD_MAXIMA_DESCRIPCION = 200;
    private static final int LONGITUD_MAXIMA_OBSERVACION = 500;
    private static final int LONGITUD_MINIMA_ID_ACTA = 10;
    private static final int LONGITUD_MAXIMA_ID_ACTA = 50;
    private static final int LONGITUD_MINIMA_ID_DOCUMENTO = 5;
    private static final int LONGITUD_MAXIMA_ID_DOCUMENTO = 50;
    
    private Long idRelacion;
    private final String idAnalisis;
    private final IdentificadorCiudadano ciudadanoOrigen;
    private final IdentificadorCiudadano ciudadanoDestino;
    private final TipoVinculo tipoParentesco;
    private final String descripcionParentesco;
    private final Integer gradoParentesco;
    private final String idActaSustento;
    private final String idDocumentoSustento;
    private final LocalDateTime fechaInicioVigencia;
    private final LocalDateTime fechaRegistro;
    private boolean vigente;
    private String observacion;
    private final RelacionInversa relacionInversa;
    
    // Constructor privado para reconstrucción desde persistencia
    private RelacionParentesco(Long idRelacion, String idAnalisis, IdentificadorCiudadano ciudadanoOrigen,
                              IdentificadorCiudadano ciudadanoDestino, TipoVinculo tipoParentesco,
                              String descripcionParentesco, Integer gradoParentesco, String idActaSustento,
                              String idDocumentoSustento, LocalDateTime fechaInicioVigencia,
                              LocalDateTime fechaRegistro, boolean vigente, String observacion,
                              RelacionInversa relacionInversa) {
        this.idRelacion = idRelacion;
        this.idAnalisis = idAnalisis;
        this.ciudadanoOrigen = ciudadanoOrigen;
        this.ciudadanoDestino = ciudadanoDestino;
        this.tipoParentesco = tipoParentesco;
        this.descripcionParentesco = descripcionParentesco;
        this.gradoParentesco = gradoParentesco;
        this.idActaSustento = idActaSustento;
        this.idDocumentoSustento = idDocumentoSustento;
        this.fechaInicioVigencia = fechaInicioVigencia;
        this.fechaRegistro = fechaRegistro;
        this.vigente = vigente;
        this.observacion = observacion;
        this.relacionInversa = relacionInversa;
    }
    
    /**
     * Factory method para crear una nueva relación de parentesco.
     * Valida todas las reglas de negocio.
     */
    public static RelacionParentesco establecer(String idAnalisis,
                                               IdentificadorCiudadano ciudadanoOrigen,
                                               IdentificadorCiudadano ciudadanoDestino,
                                               TipoVinculo tipoParentesco,
                                               String descripcionParentesco,
                                               Integer gradoParentesco,
                                               String idActaSustento,
                                               String idDocumentoSustento,
                                               LocalDateTime fechaInicioVigencia,
                                               String observacion) {
        // Validaciones
        validarIdAnalisis(idAnalisis);
        validarCiudadanos(ciudadanoOrigen, ciudadanoDestino);
        validarDescripcion(descripcionParentesco);
        validarGradoParentesco(gradoParentesco);
        validarActaSustento(idActaSustento);
        validarDocumentoSustento(idDocumentoSustento);
        validarFechaInicioVigencia(fechaInicioVigencia);
        validarObservacion(observacion);
        
        Objects.requireNonNull(tipoParentesco, "El tipo de parentesco no puede ser nulo");
        
        // Crear la relación inversa automáticamente
        RelacionInversa inversa = RelacionInversa.crear(
            ciudadanoDestino,
            ciudadanoOrigen,
            tipoParentesco.obtenerVinculoInverso()
        );
        
        return new RelacionParentesco(
            null, // El ID se asigna al persistir
            idAnalisis,
            ciudadanoOrigen,
            ciudadanoDestino,
            tipoParentesco,
            descripcionParentesco,
            gradoParentesco,
            idActaSustento,
            idDocumentoSustento,
            fechaInicioVigencia != null ? fechaInicioVigencia : LocalDateTime.now(),
            LocalDateTime.now(),
            true, // Vigente por defecto
            observacion,
            inversa
        );
    }
    
    /**
     * Factory method para reconstruir una relación desde persistencia.
     */
    public static RelacionParentesco reconstruir(Long idRelacion, String idAnalisis,
                                                IdentificadorCiudadano ciudadanoOrigen,
                                                IdentificadorCiudadano ciudadanoDestino,
                                                TipoVinculo tipoParentesco, String descripcionParentesco,
                                                Integer gradoParentesco, String idActaSustento,
                                                String idDocumentoSustento, LocalDateTime fechaInicioVigencia,
                                                LocalDateTime fechaRegistro, boolean vigente,
                                                String observacion, RelacionInversa relacionInversa) {
        return new RelacionParentesco(idRelacion, idAnalisis, ciudadanoOrigen, ciudadanoDestino,
                                     tipoParentesco, descripcionParentesco, gradoParentesco,
                                     idActaSustento, idDocumentoSustento, fechaInicioVigencia,
                                     fechaRegistro, vigente, observacion, relacionInversa);
    }
    
    /**
     * Marca la relación como inactiva.
     * Regla de negocio: Una relación inactiva no puede reactivarse.
     */
    public void marcarComoInactiva(String motivoInactivacion) {
        if (!vigente) {
            throw new IllegalStateException("La relación ya está inactiva");
        }
        
        if (motivoInactivacion == null || motivoInactivacion.trim().isEmpty()) {
            throw new IllegalArgumentException("El motivo de inactivación es obligatorio");
        }
        
        validarObservacion(motivoInactivacion);
        this.observacion = motivoInactivacion;
        this.vigente = false;
    }
    
    /**
     * Actualiza la observación de la relación.
     * Regla de negocio: Solo se pueden actualizar observaciones en relaciones vigentes.
     */
    public void actualizarObservacion(String nuevaObservacion) {
        if (!vigente) {
            throw new IllegalStateException("No se pueden actualizar observaciones en relaciones inactivas");
        }
        
        validarObservacion(nuevaObservacion);
        this.observacion = nuevaObservacion;
    }
    
    /**
     * Verifica si la relación es directa (primer grado).
     */
    public boolean esRelacionDirecta() {
        return gradoParentesco != null && gradoParentesco == 1;
    }
    
    /**
     * Verifica si la relación es colateral (entre hermanos, primos, etc).
     */
    public boolean esRelacionColateral() {
        return tipoParentesco == TipoVinculo.HERMANO || 
               tipoParentesco == TipoVinculo.PRIMO ||
               descripcionParentesco != null && 
               (descripcionParentesco.contains("primo") || descripcionParentesco.contains("hermano"));
    }
    
    /**
     * Verifica si la relación es ascendente (hacia padres/abuelos).
     */
    public boolean esRelacionAscendente() {
        return tipoParentesco == TipoVinculo.PADRE || 
               tipoParentesco == TipoVinculo.MADRE ||
               tipoParentesco == TipoVinculo.ABUELO ||
               tipoParentesco == TipoVinculo.ABUELA;
    }
    
    /**
     * Verifica si la relación es descendente (hacia hijos/nietos).
     */
    public boolean esRelacionDescendente() {
        return tipoParentesco == TipoVinculo.HIJO ||
               tipoParentesco == TipoVinculo.NIETO;
    }
    
    /**
     * Verifica si la relación está vigente.
     */
    public boolean esVigente() {
        return vigente;
    }
    
    /**
     * Verifica si la relación tiene documentación de sustento completa.
     */
    public boolean tieneSustentoCompleto() {
        return (idActaSustento != null && !idActaSustento.trim().isEmpty()) ||
               (idDocumentoSustento != null && !idDocumentoSustento.trim().isEmpty());
    }
    
    /**
     * Obtiene el tipo de vínculo inverso de esta relación.
     */
    public TipoVinculo obtenerTipoVinculoInverso() {
        return tipoParentesco.obtenerVinculoInverso();
    }
    
    // Validaciones privadas
    private static void validarIdAnalisis(String idAnalisis) {
        if (idAnalisis == null || idAnalisis.trim().isEmpty()) {
            throw new IllegalArgumentException("El ID de análisis no puede ser nulo o vacío");
        }
    }
    
    private static void validarCiudadanos(IdentificadorCiudadano origen, IdentificadorCiudadano destino) {
        Objects.requireNonNull(origen, "El ciudadano origen no puede ser nulo");
        Objects.requireNonNull(destino, "El ciudadano destino no puede ser nulo");
        
        if (origen.equals(destino)) {
            throw new IllegalArgumentException("Una persona no puede tener relación de parentesco consigo misma");
        }
    }
    
    private static void validarDescripcion(String descripcion) {
        if (descripcion != null && descripcion.length() > LONGITUD_MAXIMA_DESCRIPCION) {
            throw new IllegalArgumentException(
                String.format("La descripción no puede exceder %d caracteres", LONGITUD_MAXIMA_DESCRIPCION)
            );
        }
    }
    
    private static void validarGradoParentesco(Integer grado) {
        if (grado != null && (grado < GRADO_MINIMO || grado > GRADO_MAXIMO)) {
            throw new IllegalArgumentException(
                String.format("El grado de parentesco debe estar entre %d y %d", GRADO_MINIMO, GRADO_MAXIMO)
            );
        }
    }
    
    private static void validarActaSustento(String idActa) {
        if (idActa != null && !idActa.trim().isEmpty()) {
            if (idActa.length() < LONGITUD_MINIMA_ID_ACTA || idActa.length() > LONGITUD_MAXIMA_ID_ACTA) {
                throw new IllegalArgumentException(
                    String.format("El ID de acta debe tener entre %d y %d caracteres",
                        LONGITUD_MINIMA_ID_ACTA, LONGITUD_MAXIMA_ID_ACTA)
                );
            }
        }
    }
    
    private static void validarDocumentoSustento(String idDocumento) {
        if (idDocumento != null && !idDocumento.trim().isEmpty()) {
            if (idDocumento.length() < LONGITUD_MINIMA_ID_DOCUMENTO || 
                idDocumento.length() > LONGITUD_MAXIMA_ID_DOCUMENTO) {
                throw new IllegalArgumentException(
                    String.format("El ID de documento debe tener entre %d y %d caracteres",
                        LONGITUD_MINIMA_ID_DOCUMENTO, LONGITUD_MAXIMA_ID_DOCUMENTO)
                );
            }
        }
    }
    
    private static void validarFechaInicioVigencia(LocalDateTime fecha) {
        if (fecha != null && fecha.isAfter(LocalDateTime.now())) {
            throw new IllegalArgumentException("La fecha de inicio de vigencia no puede ser futura");
        }
    }
    
    private static void validarObservacion(String observacion) {
        if (observacion != null && observacion.length() > LONGITUD_MAXIMA_OBSERVACION) {
            throw new IllegalArgumentException(
                String.format("La observación no puede exceder %d caracteres", LONGITUD_MAXIMA_OBSERVACION)
            );
        }
    }
    
    // Getters
    public Long getIdRelacion() {
        return idRelacion;
    }
    
    public String getIdAnalisis() {
        return idAnalisis;
    }
    
    public IdentificadorCiudadano getCiudadanoOrigen() {
        return ciudadanoOrigen;
    }
    
    public IdentificadorCiudadano getCiudadanoDestino() {
        return ciudadanoDestino;
    }
    
    public TipoVinculo getTipoParentesco() {
        return tipoParentesco;
    }
    
    public String getDescripcionParentesco() {
        return descripcionParentesco;
    }
    
    public Integer getGradoParentesco() {
        return gradoParentesco;
    }
    
    public String getIdActaSustento() {
        return idActaSustento;
    }
    
    public String getIdDocumentoSustento() {
        return idDocumentoSustento;
    }
    
    public LocalDateTime getFechaInicioVigencia() {
        return fechaInicioVigencia;
    }
    
    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }
    
    public Boolean getVigente() {
        return vigente;
    }
    
    public String getObservacion() {
        return observacion;
    }
    
    public RelacionInversa getRelacionInversa() {
        return relacionInversa;
    }
    
    // Setter necesario para la persistencia (asignación del ID)
    public void asignarId(Long idRelacion) {
        if (this.idRelacion != null) {
            throw new IllegalStateException("El ID de la relación ya ha sido asignado");
        }
        this.idRelacion = idRelacion;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RelacionParentesco that = (RelacionParentesco) o;
        return Objects.equals(idRelacion, that.idRelacion);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(idRelacion);
    }
    
    @Override
    public String toString() {
        return "RelacionParentesco{" +
                "idRelacion=" + idRelacion +
                ", ciudadanoOrigen=" + ciudadanoOrigen +
                ", ciudadanoDestino=" + ciudadanoDestino +
                ", tipoParentesco=" + tipoParentesco +
                ", gradoParentesco=" + gradoParentesco +
                ", vigente=" + vigente +
                '}';
    }
}
