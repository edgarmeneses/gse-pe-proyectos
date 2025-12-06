package pe.gob.reniec.configuracion.infrastructure.adapters.in.rest.dto;

import java.util.List;

/**
 * DTO de petición - Sincronizar configuraciones
 * Endpoint: POST /api/v1/configuracion/MsDatosConfiguracion/sincronizar
 */
public class SincronizarConfiguracionesRequestDto {

    private String dispositivoId;
    private String tipoDispositivo;
    private String ultimaSincronizacion;
    private List<ConfiguracionLocalDto> configuracionesLocales;
    private String modoOperacion;
    private Boolean solicitudCompleta;

    public SincronizarConfiguracionesRequestDto() {
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

    public String getUltimaSincronizacion() {
        return ultimaSincronizacion;
    }

    public void setUltimaSincronizacion(String ultimaSincronizacion) {
        this.ultimaSincronizacion = ultimaSincronizacion;
    }

    public List<ConfiguracionLocalDto> getConfiguracionesLocales() {
        return configuracionesLocales;
    }

    public void setConfiguracionesLocales(List<ConfiguracionLocalDto> configuracionesLocales) {
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

    public static class ConfiguracionLocalDto {
        private String clave;
        private String valor;
        private String fechaModificacion;

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

        public String getFechaModificacion() {
            return fechaModificacion;
        }

        public void setFechaModificacion(String fechaModificacion) {
            this.fechaModificacion = fechaModificacion;
        }
    }
}
