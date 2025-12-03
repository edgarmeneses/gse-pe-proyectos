package pe.gob.reniec.protecciondocumentos.domain.model;

import java.time.LocalDateTime;
import java.util.List;

public class Metadatos {
    private String titulo;
    private String descripcion;
    private String autor;
    private LocalDateTime fechaCreacion;
    private ClasificacionDocumento clasificacion;
    private List<String> palabrasClave;

    public Metadatos() {
    }

    public Metadatos(String titulo, String descripcion, String autor, LocalDateTime fechaCreacion, 
                    ClasificacionDocumento clasificacion, List<String> palabrasClave) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.autor = autor;
        this.fechaCreacion = fechaCreacion;
        this.clasificacion = clasificacion;
        this.palabrasClave = palabrasClave;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public ClasificacionDocumento getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(ClasificacionDocumento clasificacion) {
        this.clasificacion = clasificacion;
    }

    public List<String> getPalabrasClave() {
        return palabrasClave;
    }

    public void setPalabrasClave(List<String> palabrasClave) {
        this.palabrasClave = palabrasClave;
    }
}
