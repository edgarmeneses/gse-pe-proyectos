package pe.gob.reniec.dominioparentesco.infrastructure.adapters.in.rest.dto;

/**
 * DTO para el resumen del análisis de parentesco.
 */
public class ResumenAnalisisDto {
    private Integer vinculosGrado1;
    private Integer vinculosGrado2;
    private Integer vinculosGrado3;
    private Integer vinculosGrado4;
    private Integer vinculosAfinidad;
    private Integer actasConsultadas;
    private Integer actasNoDigitalizadas;
    private Integer inconsistenciasDetectadas;

    public ResumenAnalisisDto() {}

    public Integer getVinculosGrado1() { return vinculosGrado1; }
    public void setVinculosGrado1(Integer vinculosGrado1) { this.vinculosGrado1 = vinculosGrado1; }

    public Integer getVinculosGrado2() { return vinculosGrado2; }
    public void setVinculosGrado2(Integer vinculosGrado2) { this.vinculosGrado2 = vinculosGrado2; }

    public Integer getVinculosGrado3() { return vinculosGrado3; }
    public void setVinculosGrado3(Integer vinculosGrado3) { this.vinculosGrado3 = vinculosGrado3; }

    public Integer getVinculosGrado4() { return vinculosGrado4; }
    public void setVinculosGrado4(Integer vinculosGrado4) { this.vinculosGrado4 = vinculosGrado4; }

    public Integer getVinculosAfinidad() { return vinculosAfinidad; }
    public void setVinculosAfinidad(Integer vinculosAfinidad) { this.vinculosAfinidad = vinculosAfinidad; }

    public Integer getActasConsultadas() { return actasConsultadas; }
    public void setActasConsultadas(Integer actasConsultadas) { this.actasConsultadas = actasConsultadas; }

    public Integer getActasNoDigitalizadas() { return actasNoDigitalizadas; }
    public void setActasNoDigitalizadas(Integer actasNoDigitalizadas) { this.actasNoDigitalizadas = actasNoDigitalizadas; }

    public Integer getInconsistenciasDetectadas() { return inconsistenciasDetectadas; }
    public void setInconsistenciasDetectadas(Integer inconsistenciasDetectadas) { this.inconsistenciasDetectadas = inconsistenciasDetectadas; }
}
