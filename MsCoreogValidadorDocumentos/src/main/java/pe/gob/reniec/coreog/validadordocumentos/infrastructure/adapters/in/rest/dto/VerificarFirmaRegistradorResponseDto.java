package pe.gob.reniec.coreog.validadordocumentos.infrastructure.adapters.in.rest.dto;

import java.util.List;

/**
 * DTO de Response: Verificar Firma del Registrador
 * Nota: Contiene todas las clases internas necesarias para la respuesta completa
 */
public class VerificarFirmaRegistradorResponseDto {
    
    private Boolean success;
    private DataDto data;
    private MetadataDto metadata;
    private ErrorDto error;
    
    public VerificarFirmaRegistradorResponseDto() {
    }
    
    // Getters y Setters principales
    public Boolean getSuccess() {
        return success;
    }
    
    public void setSuccess(Boolean success) {
        this.success = success;
    }
    
    public DataDto getData() {
        return data;
    }
    
    public void setData(DataDto data) {
        this.data = data;
    }
    
    public MetadataDto getMetadata() {
        return metadata;
    }
    
    public void setMetadata(MetadataDto metadata) {
        this.metadata = metadata;
    }
    
    public ErrorDto getError() {
        return error;
    }
    
    public void setError(ErrorDto error) {
        this.error = error;
    }
    
    // Clases internas  (getters/setters omitidos por brevedad - agregar según necesidad)
    public static class DataDto {
        private String verificacionId;
        private String solicitudId;
        private String tramiteId;
        private String documentoId;
        private String fechaVerificacion;
        private String modeloIAUtilizado;
        private Long tiempoProcesamientoMs;
        private ResultadoGeneralDto resultadoGeneral;
        private VerificacionFirmaDto verificacionFirma;
        private VerificacionSelloDto verificacionSello;
        private VerificacionPeriodoDto verificacionPeriodo;
        private DatosRegistradorVerificadoDto datosRegistradorVerificado;
        private List<AlertaDto> alertas;
        private List<AccionRecomendadaDto> accionesRecomendadas;
        
        public DataDto() {
        }
        
        // TODO: Agregar getters y setters completos
    }
    
    public static class ResultadoGeneralDto {
        private String estadoVerificacion;
        private Boolean firmaValida;
        private Boolean selloValido;
        private Boolean periodoValido;
        private Boolean requiereRevisionManual;
        private String observacionesGenerales;
        
        public ResultadoGeneralDto() {
        }
        
        // TODO: Agregar getters y setters completos
    }
    
    public static class VerificacionFirmaDto {
        private String estadoFirma;
        private Double scoreSimilitud;
        private String nivelConfianza;
        private Boolean firmaEncontradaEnBD;
        private String imagenFirmaDocumento;
        private String imagenFirmaReferencia;
        private String observaciones;
        private MetricasFirmaDto metricas;
        
        public VerificacionFirmaDto() {
        }
        
        // TODO: Agregar getters y setters completos
    }
    
    public static class MetricasFirmaDto {
        private Double similitudEstructural;
        private Double similitudTrazos;
        private Double calidadImagenExtraida;
        
        public MetricasFirmaDto() {
        }
        
        // TODO: Agregar getters y setters completos
    }
    
    public static class VerificacionSelloDto {
        private String estadoSello;
        private Double scoreSimilitud;
        private String nivelConfianza;
        private Boolean selloEncontradoEnBD;
        private String imagenSelloDocumento;
        private String imagenSelloReferencia;
        private String observaciones;
        private MetricasSelloDto metricas;
        
        public VerificacionSelloDto() {
        }
        
        // TODO: Agregar getters y setters completos
    }
    
    public static class MetricasSelloDto {
        private Double similitudForma;
        private Double legibilidadTexto;
        private Double calidadImagenExtraida;
        
        public MetricasSelloDto() {
        }
        
        // TODO: Agregar getters y setters completos
    }
    
    public static class VerificacionPeriodoDto {
        private String estadoPeriodo;
        private Boolean registradorEncontrado;
        private Boolean registradorHabilitado;
        private String fechaInscripcionActa;
        private PeriodoHabilitacionDto periodoHabilitacion;
        private String estadoRegistrador;
        private String observaciones;
        
        public VerificacionPeriodoDto() {
        }
        
        // TODO: Agregar getters y setters completos
    }
    
    public static class PeriodoHabilitacionDto {
        private String fechaInicio;
        private String fechaFin;
        private String codigoLocal;
        private String nombreOficina;
        
        public PeriodoHabilitacionDto() {
        }
        
        // TODO: Agregar getters y setters completos
    }
    
    public static class DatosRegistradorVerificadoDto {
        private String numeroDniRegistrador;
        private String idUsuario;
        private String nombreCompleto;
        private String codigoLocal;
        private String nombreOficina;
        private String estadoActual;
        
        public DatosRegistradorVerificadoDto() {
        }
        
        // TODO: Agregar getters y setters completos
    }
    
    public static class AlertaDto {
        private String codigo;
        private String tipo;
        private String descripcion;
        private String severidad;
        
        public AlertaDto() {
        }
        
        // TODO: Agregar getters y setters completos
    }
    
    public static class AccionRecomendadaDto {
        private String tipo;
        private String descripcion;
        private String prioridad;
        
        public AccionRecomendadaDto() {
        }
        
        // TODO: Agregar getters y setters completos
    }
    
    public static class MetadataDto {
        private String timestamp;
        private String correlationId;
        private String version;
        private String servidorProcesamiento;
        
        public MetadataDto() {
        }
        
        // TODO: Agregar getters y setters completos
    }
    
    public static class ErrorDto {
        private String tipo;
        private String titulo;
        private Integer estado;
        private List<DetalleErrorDto> errores;
        
        public ErrorDto() {
        }
        
        // TODO: Agregar getters y setters completos
    }
    
    public static class DetalleErrorDto {
        private String codigo;
        private String campo;
        private String detalleError;
        
        public DetalleErrorDto() {
        }
        
        // TODO: Agregar getters y setters completos
    }
}
