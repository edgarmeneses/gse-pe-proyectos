package pe.gob.reniec.protecciondocumentos.domain.model;

public class ConfiguracionProteccion {
    private NivelCompresion nivelCompresion;
    private AlgoritmoCifrado algoritmoCifrado;
    private String clavePublica;
    private Boolean incluirMetadatos;
    private ProteccionPassword proteccionPassword;

    public ConfiguracionProteccion() {
    }

    public ConfiguracionProteccion(NivelCompresion nivelCompresion, AlgoritmoCifrado algoritmoCifrado, 
                                  String clavePublica, Boolean incluirMetadatos, ProteccionPassword proteccionPassword) {
        this.nivelCompresion = nivelCompresion;
        this.algoritmoCifrado = algoritmoCifrado;
        this.clavePublica = clavePublica;
        this.incluirMetadatos = incluirMetadatos;
        this.proteccionPassword = proteccionPassword;
    }

    public NivelCompresion getNivelCompresion() {
        return nivelCompresion;
    }

    public void setNivelCompresion(NivelCompresion nivelCompresion) {
        this.nivelCompresion = nivelCompresion;
    }

    public AlgoritmoCifrado getAlgoritmoCifrado() {
        return algoritmoCifrado;
    }

    public void setAlgoritmoCifrado(AlgoritmoCifrado algoritmoCifrado) {
        this.algoritmoCifrado = algoritmoCifrado;
    }

    public String getClavePublica() {
        return clavePublica;
    }

    public void setClavePublica(String clavePublica) {
        this.clavePublica = clavePublica;
    }

    public Boolean getIncluirMetadatos() {
        return incluirMetadatos;
    }

    public void setIncluirMetadatos(Boolean incluirMetadatos) {
        this.incluirMetadatos = incluirMetadatos;
    }

    public ProteccionPassword getProteccionPassword() {
        return proteccionPassword;
    }

    public void setProteccionPassword(ProteccionPassword proteccionPassword) {
        this.proteccionPassword = proteccionPassword;
    }
}
