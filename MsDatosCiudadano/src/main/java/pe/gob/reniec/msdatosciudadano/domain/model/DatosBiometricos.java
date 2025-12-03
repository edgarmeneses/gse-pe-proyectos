package pe.gob.reniec.msdatosciudadano.domain.model;

import java.time.LocalDateTime;
import java.util.List;

public class DatosBiometricos {
    private List<HuellaDactilar> huellasDactilares;
    private List<Fotografia> fotografia;
    private List<FirmaDigital> firmaDigital;
    private LocalDateTime fechaRegistro;

    public DatosBiometricos() {
    }

    public DatosBiometricos(List<HuellaDactilar> huellasDactilares, List<Fotografia> fotografia,
                           List<FirmaDigital> firmaDigital, LocalDateTime fechaRegistro) {
        this.huellasDactilares = huellasDactilares;
        this.fotografia = fotografia;
        this.firmaDigital = firmaDigital;
        this.fechaRegistro = fechaRegistro;
    }

    public List<HuellaDactilar> getHuellasDactilares() {
        return huellasDactilares;
    }

    public void setHuellasDactilares(List<HuellaDactilar> huellasDactilares) {
        this.huellasDactilares = huellasDactilares;
    }

    public List<Fotografia> getFotografia() {
        return fotografia;
    }

    public void setFotografia(List<Fotografia> fotografia) {
        this.fotografia = fotografia;
    }

    public List<FirmaDigital> getFirmaDigital() {
        return firmaDigital;
    }

    public void setFirmaDigital(List<FirmaDigital> firmaDigital) {
        this.firmaDigital = firmaDigital;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}
