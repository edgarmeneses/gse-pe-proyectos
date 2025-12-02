package pe.gob.reniec.dominio.parentesco.domain.model;

import java.time.LocalDateTime;

public class DatosAPD {
    private String version;
    private LocalDateTime ultimaActualizacion;
    private String estadoAPD;

    public DatosAPD() {
    }

    public DatosAPD(String version, LocalDateTime ultimaActualizacion, String estadoAPD) {
        this.version = version;
        this.ultimaActualizacion = ultimaActualizacion;
        this.estadoAPD = estadoAPD;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public LocalDateTime getUltimaActualizacion() {
        return ultimaActualizacion;
    }

    public void setUltimaActualizacion(LocalDateTime ultimaActualizacion) {
        this.ultimaActualizacion = ultimaActualizacion;
    }

    public String getEstadoAPD() {
        return estadoAPD;
    }

    public void setEstadoAPD(String estadoAPD) {
        this.estadoAPD = estadoAPD;
    }
}
