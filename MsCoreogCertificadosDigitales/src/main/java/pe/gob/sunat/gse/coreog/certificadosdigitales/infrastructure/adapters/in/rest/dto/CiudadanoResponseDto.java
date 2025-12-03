package pe.gob.sunat.gse.coreog.certificadosdigitales.infrastructure.adapters.in.rest.dto;

/**
 * DTO para información del ciudadano en la respuesta
 */
public class CiudadanoResponseDto {
    
    private String numeroDocumento;
    private String nombreCompleto;
    
    public CiudadanoResponseDto() {
    }
    
    public String getNumeroDocumento() {
        return numeroDocumento;
    }
    
    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }
    
    public String getNombreCompleto() {
        return nombreCompleto;
    }
    
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
}
