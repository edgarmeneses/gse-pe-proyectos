package pe.gob.reniec.dominioparentesco.infrastructure.adapters.in.rest.dto;

/**
 * DTO para los servicios consultados durante el análisis.
 */
public class ServiciosConsultadosDto {
    private Boolean msSagaAPD;
    private Boolean msDatosActas;
    private Boolean msDatosParentesco;

    public ServiciosConsultadosDto() {}

    public Boolean getMsSagaAPD() { return msSagaAPD; }
    public void setMsSagaAPD(Boolean msSagaAPD) { this.msSagaAPD = msSagaAPD; }

    public Boolean getMsDatosActas() { return msDatosActas; }
    public void setMsDatosActas(Boolean msDatosActas) { this.msDatosActas = msDatosActas; }

    public Boolean getMsDatosParentesco() { return msDatosParentesco; }
    public void setMsDatosParentesco(Boolean msDatosParentesco) { this.msDatosParentesco = msDatosParentesco; }
}
