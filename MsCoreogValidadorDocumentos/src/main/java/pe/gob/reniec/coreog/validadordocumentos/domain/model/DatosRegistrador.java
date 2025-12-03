package pe.gob.reniec.coreog.validadordocumentos.domain.model;

import java.time.LocalDate;

/**
 * Objeto de valor que representa los datos del registrador verificado
 */
public class DatosRegistrador {
    private String codigoRegistrador;
    private String nombreRegistrador;
    private String documentoIdentidad;
    private String oficinaRegistral;
    private LocalDate periodoInicio;
    private LocalDate periodoFin;
    private Boolean enPeriodoVigencia;

    public DatosRegistrador() {
    }

    public String getCodigoRegistrador() {
        return codigoRegistrador;
    }

    public void setCodigoRegistrador(String codigoRegistrador) {
        this.codigoRegistrador = codigoRegistrador;
    }

    public String getNombreRegistrador() {
        return nombreRegistrador;
    }

    public void setNombreRegistrador(String nombreRegistrador) {
        this.nombreRegistrador = nombreRegistrador;
    }

    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public void setDocumentoIdentidad(String documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
    }

    public String getOficinaRegistral() {
        return oficinaRegistral;
    }

    public void setOficinaRegistral(String oficinaRegistral) {
        this.oficinaRegistral = oficinaRegistral;
    }

    public LocalDate getPeriodoInicio() {
        return periodoInicio;
    }

    public void setPeriodoInicio(LocalDate periodoInicio) {
        this.periodoInicio = periodoInicio;
    }

    public LocalDate getPeriodoFin() {
        return periodoFin;
    }

    public void setPeriodoFin(LocalDate periodoFin) {
        this.periodoFin = periodoFin;
    }

    public Boolean getEnPeriodoVigencia() {
        return enPeriodoVigencia;
    }

    public void setEnPeriodoVigencia(Boolean enPeriodoVigencia) {
        this.enPeriodoVigencia = enPeriodoVigencia;
    }
}
