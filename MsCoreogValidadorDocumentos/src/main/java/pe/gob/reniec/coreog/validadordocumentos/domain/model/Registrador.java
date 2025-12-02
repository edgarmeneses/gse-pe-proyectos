package pe.gob.reniec.coreog.validadordocumentos.domain.model;

import java.time.LocalDate;

/**
 * Entidad de dominio que representa un registrador civil
 */
public class Registrador {
    private String codigoRegistrador;
    private String nombreRegistrador;
    private String documentoIdentidad;
    private String oficinaRegistral;
    private LocalDate periodoInicio;
    private LocalDate periodoFin;

    public Registrador() {
    }

    public Registrador(String codigoRegistrador, String nombreRegistrador, 
                       String documentoIdentidad, String oficinaRegistral, 
                       LocalDate periodoInicio, LocalDate periodoFin) {
        this.codigoRegistrador = codigoRegistrador;
        this.nombreRegistrador = nombreRegistrador;
        this.documentoIdentidad = documentoIdentidad;
        this.oficinaRegistral = oficinaRegistral;
        this.periodoInicio = periodoInicio;
        this.periodoFin = periodoFin;
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
}
