package pe.gob.reniec.hechosvitales.certificadodefuncion.domain.model;

/**
 * Value Object: Información de la Defunción
 */
public class Defuncion {

    private String feFallecimiento;
    private String hoFallecimiento;
    private String coFallecimientoCont;
    private String coFallecimientoPais;
    private String deFallecimientoPais;
    private String coFallecimientoDpto;
    private String deFallecimientoDpto;
    private String coFallecimientoProv;
    private String deFallecimientoProv;
    private String coFallecimientoDist;
    private String deFallecimientoDist;
    private String deFallecimientoTipoLugar;
    private String coFallecimientoRenaes;
    private String deFallecimientoNombreLugar;
    private String deFallecimientoDireccion;
    private String coTipoMuerte;
    private String deTipoMuerte;

    public Defuncion() {
    }

    public Defuncion(String feFallecimiento, String hoFallecimiento, String coFallecimientoCont, 
                     String coFallecimientoPais, String deFallecimientoPais, String coFallecimientoDpto, 
                     String deFallecimientoDpto, String coFallecimientoProv, String deFallecimientoProv, 
                     String coFallecimientoDist, String deFallecimientoDist, String deFallecimientoTipoLugar, 
                     String coFallecimientoRenaes, String deFallecimientoNombreLugar, 
                     String deFallecimientoDireccion, String coTipoMuerte, String deTipoMuerte) {
        this.feFallecimiento = feFallecimiento;
        this.hoFallecimiento = hoFallecimiento;
        this.coFallecimientoCont = coFallecimientoCont;
        this.coFallecimientoPais = coFallecimientoPais;
        this.deFallecimientoPais = deFallecimientoPais;
        this.coFallecimientoDpto = coFallecimientoDpto;
        this.deFallecimientoDpto = deFallecimientoDpto;
        this.coFallecimientoProv = coFallecimientoProv;
        this.deFallecimientoProv = deFallecimientoProv;
        this.coFallecimientoDist = coFallecimientoDist;
        this.deFallecimientoDist = deFallecimientoDist;
        this.deFallecimientoTipoLugar = deFallecimientoTipoLugar;
        this.coFallecimientoRenaes = coFallecimientoRenaes;
        this.deFallecimientoNombreLugar = deFallecimientoNombreLugar;
        this.deFallecimientoDireccion = deFallecimientoDireccion;
        this.coTipoMuerte = coTipoMuerte;
        this.deTipoMuerte = deTipoMuerte;
    }

    public String getFeFallecimiento() {
        return feFallecimiento;
    }

    public void setFeFallecimiento(String feFallecimiento) {
        this.feFallecimiento = feFallecimiento;
    }

    public String getHoFallecimiento() {
        return hoFallecimiento;
    }

    public void setHoFallecimiento(String hoFallecimiento) {
        this.hoFallecimiento = hoFallecimiento;
    }

    public String getCoFallecimientoCont() {
        return coFallecimientoCont;
    }

    public void setCoFallecimientoCont(String coFallecimientoCont) {
        this.coFallecimientoCont = coFallecimientoCont;
    }

    public String getCoFallecimientoPais() {
        return coFallecimientoPais;
    }

    public void setCoFallecimientoPais(String coFallecimientoPais) {
        this.coFallecimientoPais = coFallecimientoPais;
    }

    public String getDeFallecimientoPais() {
        return deFallecimientoPais;
    }

    public void setDeFallecimientoPais(String deFallecimientoPais) {
        this.deFallecimientoPais = deFallecimientoPais;
    }

    public String getCoFallecimientoDpto() {
        return coFallecimientoDpto;
    }

    public void setCoFallecimientoDpto(String coFallecimientoDpto) {
        this.coFallecimientoDpto = coFallecimientoDpto;
    }

    public String getDeFallecimientoDpto() {
        return deFallecimientoDpto;
    }

    public void setDeFallecimientoDpto(String deFallecimientoDpto) {
        this.deFallecimientoDpto = deFallecimientoDpto;
    }

    public String getCoFallecimientoProv() {
        return coFallecimientoProv;
    }

    public void setCoFallecimientoProv(String coFallecimientoProv) {
        this.coFallecimientoProv = coFallecimientoProv;
    }

    public String getDeFallecimientoProv() {
        return deFallecimientoProv;
    }

    public void setDeFallecimientoProv(String deFallecimientoProv) {
        this.deFallecimientoProv = deFallecimientoProv;
    }

    public String getCoFallecimientoDist() {
        return coFallecimientoDist;
    }

    public void setCoFallecimientoDist(String coFallecimientoDist) {
        this.coFallecimientoDist = coFallecimientoDist;
    }

    public String getDeFallecimientoDist() {
        return deFallecimientoDist;
    }

    public void setDeFallecimientoDist(String deFallecimientoDist) {
        this.deFallecimientoDist = deFallecimientoDist;
    }

    public String getDeFallecimientoTipoLugar() {
        return deFallecimientoTipoLugar;
    }

    public void setDeFallecimientoTipoLugar(String deFallecimientoTipoLugar) {
        this.deFallecimientoTipoLugar = deFallecimientoTipoLugar;
    }

    public String getCoFallecimientoRenaes() {
        return coFallecimientoRenaes;
    }

    public void setCoFallecimientoRenaes(String coFallecimientoRenaes) {
        this.coFallecimientoRenaes = coFallecimientoRenaes;
    }

    public String getDeFallecimientoNombreLugar() {
        return deFallecimientoNombreLugar;
    }

    public void setDeFallecimientoNombreLugar(String deFallecimientoNombreLugar) {
        this.deFallecimientoNombreLugar = deFallecimientoNombreLugar;
    }

    public String getDeFallecimientoDireccion() {
        return deFallecimientoDireccion;
    }

    public void setDeFallecimientoDireccion(String deFallecimientoDireccion) {
        this.deFallecimientoDireccion = deFallecimientoDireccion;
    }

    public String getCoTipoMuerte() {
        return coTipoMuerte;
    }

    public void setCoTipoMuerte(String coTipoMuerte) {
        this.coTipoMuerte = coTipoMuerte;
    }

    public String getDeTipoMuerte() {
        return deTipoMuerte;
    }

    public void setDeTipoMuerte(String deTipoMuerte) {
        this.deTipoMuerte = deTipoMuerte;
    }
}
