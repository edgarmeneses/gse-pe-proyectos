package pe.gob.reniec.msdatos.repositoriodocumental.infrastructure.adapters.in.rest.dto;

/**
 * DTO Response: Crear Carpeta
 */
public class CrearCarpetaResponseDto {
    private String id;
    private String createdAt;
    private String estadoCarpeta;
    private String ruta;

    public CrearCarpetaResponseDto() {
    }

    public CrearCarpetaResponseDto(String id, String createdAt, String estadoCarpeta, String ruta) {
        this.id = id;
        this.createdAt = createdAt;
        this.estadoCarpeta = estadoCarpeta;
        this.ruta = ruta;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getEstadoCarpeta() {
        return estadoCarpeta;
    }

    public void setEstadoCarpeta(String estadoCarpeta) {
        this.estadoCarpeta = estadoCarpeta;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
}
