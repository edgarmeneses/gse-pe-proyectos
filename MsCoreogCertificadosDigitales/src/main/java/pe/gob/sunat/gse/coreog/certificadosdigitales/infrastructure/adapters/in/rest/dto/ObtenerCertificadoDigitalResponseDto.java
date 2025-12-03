package pe.gob.sunat.gse.coreog.certificadosdigitales.infrastructure.adapters.in.rest.dto;

/**
 * DTO de respuesta principal con estructura success/data/metadata
 */
public class ObtenerCertificadoDigitalResponseDto {
    
    private Boolean success;
    private DataDto data;
    private MetadataResponseDto metadata;
    
    public ObtenerCertificadoDigitalResponseDto() {
    }
    
    public Boolean getSuccess() {
        return success;
    }
    
    public void setSuccess(Boolean success) {
        this.success = success;
    }
    
    public DataDto getData() {
        return data;
    }
    
    public void setData(DataDto data) {
        this.data = data;
    }
    
    public MetadataResponseDto getMetadata() {
        return metadata;
    }
    
    public void setMetadata(MetadataResponseDto metadata) {
        this.metadata = metadata;
    }
}
