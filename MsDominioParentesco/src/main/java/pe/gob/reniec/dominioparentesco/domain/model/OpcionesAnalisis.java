package pe.gob.reniec.dominioparentesco.domain.model;

import java.util.Objects;

/**
 * Value Object - Representa las opciones de configuración para el análisis.
 */
public class OpcionesAnalisis {
    
    private final Boolean generarArbolGenealogico;
    private final Boolean validarContraAPD;
    private final Boolean incluirActasSustento;
    private final Boolean detectarInconsistencias;
    
    public OpcionesAnalisis(Boolean generarArbolGenealogico,
                           Boolean validarContraAPD,
                           Boolean incluirActasSustento,
                           Boolean detectarInconsistencias) {
        this.generarArbolGenealogico = generarArbolGenealogico != null ? generarArbolGenealogico : false;
        this.validarContraAPD = validarContraAPD != null ? validarContraAPD : true;
        this.incluirActasSustento = incluirActasSustento != null ? incluirActasSustento : true;
        this.detectarInconsistencias = detectarInconsistencias != null ? detectarInconsistencias : true;
    }
    
    public Boolean getGenerarArbolGenealogico() {
        return generarArbolGenealogico;
    }
    
    public Boolean getValidarContraAPD() {
        return validarContraAPD;
    }
    
    public Boolean getIncluirActasSustento() {
        return incluirActasSustento;
    }
    
    public Boolean getDetectarInconsistencias() {
        return detectarInconsistencias;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OpcionesAnalisis that = (OpcionesAnalisis) o;
        return Objects.equals(generarArbolGenealogico, that.generarArbolGenealogico) &&
               Objects.equals(validarContraAPD, that.validarContraAPD) &&
               Objects.equals(incluirActasSustento, that.incluirActasSustento) &&
               Objects.equals(detectarInconsistencias, that.detectarInconsistencias);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(generarArbolGenealogico, validarContraAPD, 
                          incluirActasSustento, detectarInconsistencias);
    }
    
    @Override
    public String toString() {
        return "OpcionesAnalisis{" +
                "generarArbolGenealogico=" + generarArbolGenealogico +
                ", validarContraAPD=" + validarContraAPD +
                ", incluirActasSustento=" + incluirActasSustento +
                ", detectarInconsistencias=" + detectarInconsistencias +
                '}';
    }
}
