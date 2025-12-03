package pe.gob.reniec.gse.registradores.infrastructure.adapters.in.rest.dto;

import java.util.List;

/**
 * DTO Response: Detalle Completo de Registrador
 */
public class RegistradorDetalleResponseDto {
    private String idRegistrador;
    private String numeroDni;
    private String primerApellido;
    private String segundoApellido;
    private String prenombres;
    private String nombreCompleto;
    private String numeroImagen;
    private AsignacionActualDto asignacionActual;
    private FirmaDto firma;
    private SelloDto sello;
    private List<PeriodoDto> periodos;
    private AuditoriaDto auditoria;
    private LinksDetalleDto links;

    public RegistradorDetalleResponseDto() {
    }

    public RegistradorDetalleResponseDto(String idRegistrador, String numeroDni, String primerApellido, 
                                        String segundoApellido, String prenombres, String nombreCompleto, 
                                        String numeroImagen, AsignacionActualDto asignacionActual, 
                                        FirmaDto firma, SelloDto sello, List<PeriodoDto> periodos, 
                                        AuditoriaDto auditoria, LinksDetalleDto links) {
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
        this.links = links;
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

    public AsignacionActualDto getAsignacionActual() {
        return asignacionActual;
    }

    public void setAsignacionActual(AsignacionActualDto asignacionActual) {
        this.asignacionActual = asignacionActual;
    }

    public FirmaDto getFirma() {
        return firma;
    }

    public void setFirma(FirmaDto firma) {
        this.firma = firma;
    }

    public SelloDto getSello() {
        return sello;
    }

    public void setSello(SelloDto sello) {
        this.sello = sello;
    }

    public List<PeriodoDto> getPeriodos() {
        return periodos;
    }

    public void setPeriodos(List<PeriodoDto> periodos) {
        this.periodos = periodos;
    }

    public AuditoriaDto getAuditoria() {
        return auditoria;
    }

    public void setAuditoria(AuditoriaDto auditoria) {
        this.auditoria = auditoria;
    }

    public LinksDetalleDto getLinks() {
        return links;
    }

    public void setLinks(LinksDetalleDto links) {
        this.links = links;
    }
}
