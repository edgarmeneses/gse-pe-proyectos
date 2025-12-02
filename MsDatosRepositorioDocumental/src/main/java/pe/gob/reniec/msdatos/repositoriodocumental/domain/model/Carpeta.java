package pe.gob.reniec.msdatos.repositoriodocumental.domain.model;

import java.time.LocalDateTime;
import java.util.Map;

public class Carpeta {
    private String id;
    private String nombre;
    private String parentId;
    private String descripcion;
    private String estadoCarpeta;
    private String ruta;
    private Map<String, Object> metadata;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Carpeta() {
    }

    public Carpeta(String id, String nombre, String parentId, String descripcion, String estadoCarpeta, 
                   String ruta, Map<String, Object> metadata, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.nombre = nombre;
        this.parentId = parentId;
        this.descripcion = descripcion;
        this.estadoCarpeta = estadoCarpeta;
        this.ruta = ruta;
        this.metadata = metadata;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public Map<String, Object> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
