package pe.gob.reniec.configuracion.domain.model;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Value Object - Datos de sincronización de configuraciones
 */
public class ConfiguracionSincronizacion {

    private String dispositivoId;
    private String tipoDispositivo;
    private LocalDateTime ultimaSincronizacion;
    private List<ConfiguracionLocal> configuracionesLocales;
    private String modoOperacion;
    private Boolean solicitudCompleta;

    public ConfiguracionSincronizacion() {
    }

    public String getDispositivoId() {
        return dispositivoId;
    }

    public void setDispositivoId(String dispositivoId) {
        this.dispositivoId = dispositivoId;
    }

    public String getTipoDispositivo() {
        return tipoDispositivo;
    }

    public void setTipoDispositivo(String tipoDispositivo) {
        this.tipoDispositivo = tipoDispositivo;
    }

    public LocalDateTime getUltimaSincronizacion() {
        return ultimaSincronizacion;
    }

    public void setUltimaSincronizacion(LocalDateTime ultimaSincronizacion) {
        this.ultimaSincronizacion = ultimaSincronizacion;
    }

    public List<ConfiguracionLocal> getConfiguracionesLocales() {
        return configuracionesLocales;
    }

    public void setConfiguracionesLocales(List<ConfiguracionLocal> configuracionesLocales) {
        this.configuracionesLocales = configuracionesLocales;
    }

    public String getModoOperacion() {
        return modoOperacion;
    }

    public void setModoOperacion(String modoOperacion) {
        this.modoOperacion = modoOperacion;
    }

    public Boolean getSolicitudCompleta() {
        return solicitudCompleta;
    }

    public void setSolicitudCompleta(Boolean solicitudCompleta) {
        this.solicitudCompleta = solicitudCompleta;
    }

    /**
     * Value Object - Configuración local del dispositivo
     */
    public static class ConfiguracionLocal {
        private String clave;
        private String valor;
        private LocalDateTime fechaModificacion;

        public ConfiguracionLocal() {
        }

        public String getClave() {
            return clave;
        }

        public void setClave(String clave) {
            this.clave = clave;
        }

        public String getValor() {
            return valor;
        }

        public void setValor(String valor) {
            this.valor = valor;
        }

        public LocalDateTime getFechaModificacion() {
            return fechaModificacion;
        }

        public void setFechaModificacion(LocalDateTime fechaModificacion) {
            this.fechaModificacion = fechaModificacion;
        }
    }
}
