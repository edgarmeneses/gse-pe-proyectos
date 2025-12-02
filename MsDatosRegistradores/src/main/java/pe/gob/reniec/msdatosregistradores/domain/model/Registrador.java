package pe.gob.reniec.msdatosregistradores.domain.model;

import java.time.LocalDateTime;
import java.util.List;

public class Registrador {
    private String idRegistrador;
    private String numeroDni;
    private String primerApellido;
    private String segundoApellido;
    private String prenombres;
    private String nombreCompleto;
    private String numeroImagen;
    private AsignacionActual asignacionActual;
    private Firma firma;
    private Sello sello;
    private List<Periodo> periodos;
    private Auditoria auditoria;

    public Registrador() {
    }

    public Registrador(String idRegistrador, String numeroDni, String primerApellido, 
                      String segundoApellido, String prenombres, String nombreCompleto,
                      String numeroImagen, AsignacionActual asignacionActual, 
                      Firma firma, Sello sello, List<Periodo> periodos, Auditoria auditoria) {
        this.idRegistrador = idRegistrador;
        this.numeroDni = numeroDni;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.prenombres = prenombres;
        this.nombreCompleto = nombreCompleto;
        this.numeroImagen = numeroImagen;
        this.asignacionActual = asignacionActual;
        this.firma = firma;
        this.sello = sello;
        this.periodos = periodos;
        this.auditoria = auditoria;
    }

    public String getIdRegistrador() {
        return idRegistrador;
    }

    public void setIdRegistrador(String idRegistrador) {
        this.idRegistrador = idRegistrador;
    }

    public String getNumeroDni() {
        return numeroDni;
    }

    public void setNumeroDni(String numeroDni) {
        this.numeroDni = numeroDni;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getPrenombres() {
        return prenombres;
    }

    public void setPrenombres(String prenombres) {
        this.prenombres = prenombres;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getNumeroImagen() {
        return numeroImagen;
    }

    public void setNumeroImagen(String numeroImagen) {
        this.numeroImagen = numeroImagen;
    }

    public AsignacionActual getAsignacionActual() {
        return asignacionActual;
    }

    public void setAsignacionActual(AsignacionActual asignacionActual) {
        this.asignacionActual = asignacionActual;
    }

    public Firma getFirma() {
        return firma;
    }

    public void setFirma(Firma firma) {
        this.firma = firma;
    }

    public Sello getSello() {
        return sello;
    }

    public void setSello(Sello sello) {
        this.sello = sello;
    }

    public List<Periodo> getPeriodos() {
        return periodos;
    }

    public void setPeriodos(List<Periodo> periodos) {
        this.periodos = periodos;
    }

    public Auditoria getAuditoria() {
        return auditoria;
    }

    public void setAuditoria(Auditoria auditoria) {
        this.auditoria = auditoria;
    }
}
