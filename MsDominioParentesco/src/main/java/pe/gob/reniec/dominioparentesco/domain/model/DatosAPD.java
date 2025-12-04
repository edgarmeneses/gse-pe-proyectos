package pe.gob.reniec.dominioparentesco.domain.model;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Value Object - Representa información del APD de un ciudadano.
 */
public class DatosAPD {
    
    private final String version;
    private final LocalDateTime ultimaActualizacion;
    private final String estadoAPD;
    
    public DatosAPD(String version, LocalDateTime ultimaActualizacion, String estadoAPD) {
        this.version = version;
        this.ultimaActualizacion = ultimaActualizacion;
        this.estadoAPD = estadoAPD;
    }
    
    public String getVersion() {
        return version;
    }
    
    public LocalDateTime getUltimaActualizacion() {
        return ultimaActualizacion;
    }
    
    public String getEstadoAPD() {
        return estadoAPD;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DatosAPD datosAPD = (DatosAPD) o;
        return Objects.equals(version, datosAPD.version) &&
               Objects.equals(ultimaActualizacion, datosAPD.ultimaActualizacion) &&
               Objects.equals(estadoAPD, datosAPD.estadoAPD);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(version, ultimaActualizacion, estadoAPD);
    }
    
    @Override
    public String toString() {
        return "DatosAPD{" +
                "version='" + version + '\'' +
                ", ultimaActualizacion=" + ultimaActualizacion +
                ", estadoAPD='" + estadoAPD + '\'' +
                '}';
    }
}
