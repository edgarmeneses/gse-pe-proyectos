package pe.gob.reniec.dominioparentesco.domain.model;

import java.util.Objects;

/**
 * Value Object - Representa el resumen estadístico del análisis.
 */
public class ResumenAnalisis {
    
    private final Integer vinculosGrado1;
    private final Integer vinculosGrado2;
    private final Integer vinculosGrado3;
    private final Integer vinculosGrado4;
    private final Integer vinculosAfinidad;
    private final Integer actasConsultadas;
    private final Integer actasNoDigitalizadas;
    private final Integer inconsistenciasDetectadas;
    
    public ResumenAnalisis(Integer vinculosGrado1, Integer vinculosGrado2,
                          Integer vinculosGrado3, Integer vinculosGrado4,
                          Integer vinculosAfinidad, Integer actasConsultadas,
                          Integer actasNoDigitalizadas, Integer inconsistenciasDetectadas) {
        this.vinculosGrado1 = vinculosGrado1 != null ? vinculosGrado1 : 0;
        this.vinculosGrado2 = vinculosGrado2 != null ? vinculosGrado2 : 0;
        this.vinculosGrado3 = vinculosGrado3 != null ? vinculosGrado3 : 0;
        this.vinculosGrado4 = vinculosGrado4 != null ? vinculosGrado4 : 0;
        this.vinculosAfinidad = vinculosAfinidad != null ? vinculosAfinidad : 0;
        this.actasConsultadas = actasConsultadas != null ? actasConsultadas : 0;
        this.actasNoDigitalizadas = actasNoDigitalizadas != null ? actasNoDigitalizadas : 0;
        this.inconsistenciasDetectadas = inconsistenciasDetectadas != null ? inconsistenciasDetectadas : 0;
    }
    
    public Integer getVinculosGrado1() { return vinculosGrado1; }
    public Integer getVinculosGrado2() { return vinculosGrado2; }
    public Integer getVinculosGrado3() { return vinculosGrado3; }
    public Integer getVinculosGrado4() { return vinculosGrado4; }
    public Integer getVinculosAfinidad() { return vinculosAfinidad; }
    public Integer getActasConsultadas() { return actasConsultadas; }
    public Integer getActasNoDigitalizadas() { return actasNoDigitalizadas; }
    public Integer getInconsistenciasDetectadas() { return inconsistenciasDetectadas; }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResumenAnalisis that = (ResumenAnalisis) o;
        return Objects.equals(vinculosGrado1, that.vinculosGrado1) &&
               Objects.equals(vinculosGrado2, that.vinculosGrado2) &&
               Objects.equals(vinculosGrado3, that.vinculosGrado3) &&
               Objects.equals(vinculosGrado4, that.vinculosGrado4) &&
               Objects.equals(vinculosAfinidad, that.vinculosAfinidad) &&
               Objects.equals(actasConsultadas, that.actasConsultadas) &&
               Objects.equals(actasNoDigitalizadas, that.actasNoDigitalizadas) &&
               Objects.equals(inconsistenciasDetectadas, that.inconsistenciasDetectadas);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(vinculosGrado1, vinculosGrado2, vinculosGrado3, vinculosGrado4,
                          vinculosAfinidad, actasConsultadas, actasNoDigitalizadas, inconsistenciasDetectadas);
    }
    
    @Override
    public String toString() {
        return "ResumenAnalisis{" +
                "vinculosGrado1=" + vinculosGrado1 +
                ", vinculosGrado2=" + vinculosGrado2 +
                ", vinculosGrado3=" + vinculosGrado3 +
                ", vinculosGrado4=" + vinculosGrado4 +
                ", vinculosAfinidad=" + vinculosAfinidad +
                ", actasConsultadas=" + actasConsultadas +
                ", actasNoDigitalizadas=" + actasNoDigitalizadas +
                ", inconsistenciasDetectadas=" + inconsistenciasDetectadas +
                '}';
    }
}
