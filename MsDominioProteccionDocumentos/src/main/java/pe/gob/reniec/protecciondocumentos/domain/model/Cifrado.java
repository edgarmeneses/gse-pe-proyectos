package pe.gob.reniec.protecciondocumentos.domain.model;

import java.time.LocalDateTime;

public class Cifrado {
    private AlgoritmoCifrado algoritmo;
    private String hash;
    private String algoritmoHash;
    private LocalDateTime fechaCifrado;
    private String huellaCifrado;

    public Cifrado() {
    }

    public Cifrado(AlgoritmoCifrado algoritmo, String hash, String algoritmoHash, 
                  LocalDateTime fechaCifrado, String huellaCifrado) {
        this.algoritmo = algoritmo;
        this.hash = hash;
        this.algoritmoHash = algoritmoHash;
        this.fechaCifrado = fechaCifrado;
        this.huellaCifrado = huellaCifrado;
    }

    public AlgoritmoCifrado getAlgoritmo() {
        return algoritmo;
    }

    public void setAlgoritmo(AlgoritmoCifrado algoritmo) {
        this.algoritmo = algoritmo;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getAlgoritmoHash() {
        return algoritmoHash;
    }

    public void setAlgoritmoHash(String algoritmoHash) {
        this.algoritmoHash = algoritmoHash;
    }

    public LocalDateTime getFechaCifrado() {
        return fechaCifrado;
    }

    public void setFechaCifrado(LocalDateTime fechaCifrado) {
        this.fechaCifrado = fechaCifrado;
    }

    public String getHuellaCifrado() {
        return huellaCifrado;
    }

    public void setHuellaCifrado(String huellaCifrado) {
        this.huellaCifrado = huellaCifrado;
    }
}
