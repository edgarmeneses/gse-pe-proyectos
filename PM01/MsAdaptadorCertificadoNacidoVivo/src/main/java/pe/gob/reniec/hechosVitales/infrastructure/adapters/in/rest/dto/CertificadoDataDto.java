package pe.gob.reniec.hechosVitales.infrastructure.adapters.in.rest.dto;

/**
 * DTO: CertificadoDataDto
 * 
 * Representa el objeto data dentro de la respuesta con los datos
 * del certificado de nacido vivo.
 */
public class CertificadoDataDto {
    
    private String coTipoDocMadre;
    private String nuDocMadre;
    private String feNaceMenor;
    private String hoNaceMenor;
    private String sexoMenor;
    private String coRespuesta;
    private String deRespuesta;
    
    public CertificadoDataDto() {
    }
    
    public CertificadoDataDto(String coTipoDocMadre, String nuDocMadre, String feNaceMenor,
                              String hoNaceMenor, String sexoMenor, String coRespuesta,
                              String deRespuesta) {
        this.coTipoDocMadre = coTipoDocMadre;
        this.nuDocMadre = nuDocMadre;
        this.feNaceMenor = feNaceMenor;
        this.hoNaceMenor = hoNaceMenor;
        this.sexoMenor = sexoMenor;
        this.coRespuesta = coRespuesta;
        this.deRespuesta = deRespuesta;
    }
    
    public String getCoTipoDocMadre() {
        return coTipoDocMadre;
    }
    
    public void setCoTipoDocMadre(String coTipoDocMadre) {
        this.coTipoDocMadre = coTipoDocMadre;
    }
    
    public String getNuDocMadre() {
        return nuDocMadre;
    }
    
    public void setNuDocMadre(String nuDocMadre) {
        this.nuDocMadre = nuDocMadre;
    }
    
    public String getFeNaceMenor() {
        return feNaceMenor;
    }
    
    public void setFeNaceMenor(String feNaceMenor) {
        this.feNaceMenor = feNaceMenor;
    }
    
    public String getHoNaceMenor() {
        return hoNaceMenor;
    }
    
    public void setHoNaceMenor(String hoNaceMenor) {
        this.hoNaceMenor = hoNaceMenor;
    }
    
    public String getSexoMenor() {
        return sexoMenor;
    }
    
    public void setSexoMenor(String sexoMenor) {
        this.sexoMenor = sexoMenor;
    }
    
    public String getCoRespuesta() {
        return coRespuesta;
    }
    
    public void setCoRespuesta(String coRespuesta) {
        this.coRespuesta = coRespuesta;
    }
    
    public String getDeRespuesta() {
        return deRespuesta;
    }
    
    public void setDeRespuesta(String deRespuesta) {
        this.deRespuesta = deRespuesta;
    }
}
