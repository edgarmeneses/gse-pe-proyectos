package pe.gob.reniec.dominioparentesco.infrastructure.adapters.in.rest.dto;

import java.time.LocalDateTime;

/**
 * DTO para los datos del APD (Archivo de Personas y Datos).
 */
public class DatosAPDDto {
    private String version;
    private LocalDateTime ultimaActualizacion;
    private String estadoAPD;

    public DatosAPDDto() {}

    public String getVersion() { return version; }
    public void setVersion(String version) { this.version = version; }

    public LocalDateTime getUltimaActualizacion() { return ultimaActualizacion; }
    public void setUltimaActualizacion(LocalDateTime ultimaActualizacion) { this.ultimaActualizacion = ultimaActualizacion; }

    public String getEstadoAPD() { return estadoAPD; }
    public void setEstadoAPD(String estadoAPD) { this.estadoAPD = estadoAPD; }
}
