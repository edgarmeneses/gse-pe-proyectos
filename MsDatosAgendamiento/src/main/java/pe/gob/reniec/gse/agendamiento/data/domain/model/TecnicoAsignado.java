package pe.gob.reniec.gse.agendamiento.data.domain.model;

public class TecnicoAsignado {
    
    private final String idTecnico;
    private final String nombreCompleto;
    
    public TecnicoAsignado(String idTecnico, String nombreCompleto) {
        if (idTecnico == null || idTecnico.trim().isEmpty()) {
            throw new IllegalArgumentException("El ID del técnico es requerido");
        }
        if (nombreCompleto == null || nombreCompleto.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del técnico es requerido");
        }
        this.idTecnico = idTecnico.trim();
        this.nombreCompleto = nombreCompleto.trim();
    }
    
    public String getIdTecnico() {
        return idTecnico;
    }
    
    public String getNombreCompleto() {
        return nombreCompleto;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TecnicoAsignado that = (TecnicoAsignado) o;
        return idTecnico.equals(that.idTecnico);
    }
    
    @Override
    public int hashCode() {
        return idTecnico.hashCode();
    }
}
