package pe.gob.reniec.configuracion.domain.model;

import java.util.List;

/**
 * Value Object - Resultado de operación de sincronización
 */
public class ResultadoSincronizacion {

    private String status;
    private String sincronizacionId;
    private Integer configuracionesActualizadas;
    private Integer configuracionesConflicto;
    private Integer totalConfiguraciones;
    private List<ResolucionConflicto> resolucionConflictos;
    private String proximaSincronizacion;
    private String estadoDispositivo;

    public ResultadoSincronizacion() {
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

    public List<ResolucionConflicto> getResolucionConflictos() {
        return resolucionConflictos;
    }

    public void setResolucionConflictos(List<ResolucionConflicto> resolucionConflictos) {
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

    /**
     * Value Object - Resolución de conflicto de sincronización
     */
    public static class ResolucionConflicto {
        private String clave;
        private String resolucion;
        private String motivoConflicto;

        public ResolucionConflicto() {
        }

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
