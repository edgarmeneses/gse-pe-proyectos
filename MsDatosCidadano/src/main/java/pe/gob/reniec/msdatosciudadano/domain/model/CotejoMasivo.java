package pe.gob.reniec.msdatosciudadano.domain.model;

import java.time.LocalDateTime;
import java.util.List;

public class CotejoMasivo {
    private String solicitudId;
    private String codigoCotejo;
    private EntidadSolicitante entidadSolicitante;
    private ConfiguracionCotejo configuracionCotejo;
    private List<RegistroCotejo> registros;
    private LocalDateTime fechaProcesamiento;
    private String estadoProceso;

    public CotejoMasivo() {
    }

    public String getSolicitudId() {
        return solicitudId;
    }

    public void setSolicitudId(String solicitudId) {
        this.solicitudId = solicitudId;
    }

    public String getCodigoCotejo() {
        return codigoCotejo;
    }

    public void setCodigoCotejo(String codigoCotejo) {
        this.codigoCotejo = codigoCotejo;
    }

    public EntidadSolicitante getEntidadSolicitante() {
        return entidadSolicitante;
    }

    public void setEntidadSolicitante(EntidadSolicitante entidadSolicitante) {
        this.entidadSolicitante = entidadSolicitante;
    }

    public ConfiguracionCotejo getConfiguracionCotejo() {
        return configuracionCotejo;
    }

    public void setConfiguracionCotejo(ConfiguracionCotejo configuracionCotejo) {
        this.configuracionCotejo = configuracionCotejo;
    }

    public List<RegistroCotejo> getRegistros() {
        return registros;
    }

    public void setRegistros(List<RegistroCotejo> registros) {
        this.registros = registros;
    }

    public LocalDateTime getFechaProcesamiento() {
        return fechaProcesamiento;
    }

    public void setFechaProcesamiento(LocalDateTime fechaProcesamiento) {
        this.fechaProcesamiento = fechaProcesamiento;
    }

    public String getEstadoProceso() {
        return estadoProceso;
    }

    public void setEstadoProceso(String estadoProceso) {
        this.estadoProceso = estadoProceso;
    }
}
