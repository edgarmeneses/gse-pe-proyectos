package pe.gob.reniec.dominioparentesco.infrastructure.adapters.in.rest.dto;

/**
 * DTO para las opciones de análisis.
 */
public class OpcionesAnalisisDto {
    private Boolean generarArbolGenealogico;
    private Boolean validarContraAPD;
    private Boolean incluirActasSustento;
    private Boolean detectarInconsistencias;

    public OpcionesAnalisisDto() {}

    public OpcionesAnalisisDto(Boolean generarArbolGenealogico, Boolean validarContraAPD,
                              Boolean incluirActasSustento, Boolean detectarInconsistencias) {
        this.generarArbolGenealogico = generarArbolGenealogico;
        this.validarContraAPD = validarContraAPD;
        this.incluirActasSustento = incluirActasSustento;
        this.detectarInconsistencias = detectarInconsistencias;
    }

    public Boolean getGenerarArbolGenealogico() { return generarArbolGenealogico; }
    public void setGenerarArbolGenealogico(Boolean generarArbolGenealogico) { this.generarArbolGenealogico = generarArbolGenealogico; }

    public Boolean getValidarContraAPD() { return validarContraAPD; }
    public void setValidarContraAPD(Boolean validarContraAPD) { this.validarContraAPD = validarContraAPD; }

    public Boolean getIncluirActasSustento() { return incluirActasSustento; }
    public void setIncluirActasSustento(Boolean incluirActasSustento) { this.incluirActasSustento = incluirActasSustento; }

    public Boolean getDetectarInconsistencias() { return detectarInconsistencias; }
    public void setDetectarInconsistencias(Boolean detectarInconsistencias) { this.detectarInconsistencias = detectarInconsistencias; }
}
