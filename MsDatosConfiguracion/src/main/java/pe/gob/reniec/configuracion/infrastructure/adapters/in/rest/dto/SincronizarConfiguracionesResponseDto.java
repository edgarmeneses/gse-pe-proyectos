package pe.gob.reniec.configuracion.infrastructure.adapters.in.rest.dto;

import java.util.List;

/**
 * DTO de respuesta - Sincronizar configuraciones
 * Endpoint: POST /api/v1/configuracion/MsDatosConfiguracion/sincronizar
 */
public class SincronizarConfiguracionesResponseDto {

    private String status;
    private String sincronizacionId;
    private Integer configuracionesActualizadas;
    private Integer configuracionesConflicto;
    private Integer totalConfiguraciones;
    private List<ResolucionConflictoDto> resolucionConflictos;
    private String proximaSincronizacion;
    private String estadoDispositivo;

    public SincronizarConfiguracionesResponseDto() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSincronizacionId() {
        return sincronizacionId;
    }

    public void setSincronizacionId(String sincronizacionId) {
        this.sincronizacionId = sincronizacionId;
    }

    public Integer getConfiguracionesActualizadas() {
        return configuracionesActualizadas;
    }

    public void setConfiguracionesActualizadas(Integer configuracionesActualizadas) {
        this.configuracionesActualizadas = configuracionesActualizadas;
    }

    public Integer getConfiguracionesConflicto() {
        return configuracionesConflicto;
    }

    public void setConfiguracionesConflicto(Integer configuracionesConflicto) {
        this.configuracionesConflicto = configuracionesConflicto;
    }

    public Integer getTotalConfiguraciones() {
        return totalConfiguraciones;
    }

    public void setTotalConfiguraciones(Integer totalConfiguraciones) {
        this.totalConfiguraciones = totalConfiguraciones;
    }

    public List<ResolucionConflictoDto> getResolucionConflictos() {
        return resolucionConflictos;
    }

    public void setResolucionConflictos(List<ResolucionConflictoDto> resolucionConflictos) {
        this.resolucionConflictos = resolucionConflictos;
    }

    public String getProximaSincronizacion() {
        return proximaSincronizacion;
    }

    public void setProximaSincronizacion(String proximaSincronizacion) {
        this.proximaSincronizacion = proximaSincronizacion;
    }

    public String getEstadoDispositivo() {
        return estadoDispositivo;
    }

    public void setEstadoDispositivo(String estadoDispositivo) {
        this.estadoDispositivo = estadoDispositivo;
    }

    public static class ResolucionConflictoDto {
        private String clave;
        private String resolucion;
        private String motivoConflicto;

        public String getClave() {
            return clave;
        }

        public void setClave(String clave) {
            this.clave = clave;
        }

        public String getResolucion() {
            return resolucion;
        }

        public void setResolucion(String resolucion) {
            this.resolucion = resolucion;
        }

        public String getMotivoConflicto() {
            return motivoConflicto;
        }

        public void setMotivoConflicto(String motivoConflicto) {
            this.motivoConflicto = motivoConflicto;
        }
    }
}
