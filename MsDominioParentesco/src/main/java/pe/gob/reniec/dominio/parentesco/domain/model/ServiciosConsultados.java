package pe.gob.reniec.dominio.parentesco.domain.model;

public class ServiciosConsultados {
    private Boolean msSagaAPD;
    private Boolean msDatosActas;
    private Boolean msDatosParentesco;

    public ServiciosConsultados() {
    }

    public ServiciosConsultados(Boolean msSagaAPD, Boolean msDatosActas, Boolean msDatosParentesco) {
        this.msSagaAPD = msSagaAPD;
        this.msDatosActas = msDatosActas;
        this.msDatosParentesco = msDatosParentesco;
    }

    public Boolean getMsSagaAPD() {
        return msSagaAPD;
    }

    public void setMsSagaAPD(Boolean msSagaAPD) {
        this.msSagaAPD = msSagaAPD;
    }

    public Boolean getMsDatosActas() {
        return msDatosActas;
    }

    public void setMsDatosActas(Boolean msDatosActas) {
        this.msDatosActas = msDatosActas;
    }

    public Boolean getMsDatosParentesco() {
        return msDatosParentesco;
    }

    public void setMsDatosParentesco(Boolean msDatosParentesco) {
        this.msDatosParentesco = msDatosParentesco;
    }
}
