package pe.gob.reniec.dominioparentesco.infrastructure.adapters.in.rest.dto;

import java.time.LocalDateTime;

/**
 * DTO para el acta que sustenta un vínculo de parentesco.
 */
public class ActaSustentoDto {
    private String idActa;
    private String tipoActa;
    private LocalDateTime fechaActa;
    private String lugarActa;

    public ActaSustentoDto() {}

    public String getIdActa() { return idActa; }
    public void setIdActa(String idActa) { this.idActa = idActa; }

    public String getTipoActa() { return tipoActa; }
    public void setTipoActa(String tipoActa) { this.tipoActa = tipoActa; }

    public LocalDateTime getFechaActa() { return fechaActa; }
    public void setFechaActa(LocalDateTime fechaActa) { this.fechaActa = fechaActa; }

    public String getLugarActa() { return lugarActa; }
    public void setLugarActa(String lugarActa) { this.lugarActa = lugarActa; }
}
