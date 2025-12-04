package pe.gob.reniec.dominioparentesco.domain.model;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Value Object - Representa los datos de un acta de sustento.
 */
public class ActaSustento {
    
    private final String idActa;
    private final String tipoActa;
    private final LocalDateTime fechaActa;
    private final String lugarActa;
    
    public ActaSustento(String idActa, String tipoActa, 
                       LocalDateTime fechaActa, String lugarActa) {
        this.idActa = idActa;
        this.tipoActa = tipoActa;
        this.fechaActa = fechaActa;
        this.lugarActa = lugarActa;
    }
    
    public String getIdActa() {
        return idActa;
    }
    
    public String getTipoActa() {
        return tipoActa;
    }
    
    public LocalDateTime getFechaActa() {
        return fechaActa;
    }
    
    public String getLugarActa() {
        return lugarActa;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActaSustento that = (ActaSustento) o;
        return Objects.equals(idActa, that.idActa);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(idActa);
    }
    
    @Override
    public String toString() {
        return "ActaSustento{" +
                "idActa='" + idActa + '\'' +
                ", tipoActa='" + tipoActa + '\'' +
                ", fechaActa=" + fechaActa +
                ", lugarActa='" + lugarActa + '\'' +
                '}';
    }
}
