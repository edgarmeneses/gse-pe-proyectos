package pe.gob.reniec.siirc.msdatosgrafos.domain.model;

/**
 * Value Object que representa el resumen estadístico de vínculos de parentesco
 */
public class Resumen {
    private final Long totalVinculos;
    private final Long vinculosConsanguineos;
    private final Long vinculosPorAfinidad;
    private final Long vinculosVigentes;
    private final Long vinculosNoVigentes;

    public Resumen(Long totalVinculos, Long vinculosConsanguineos, Long vinculosPorAfinidad, 
                   Long vinculosVigentes, Long vinculosNoVigentes) {
        this.totalVinculos = totalVinculos;
        this.vinculosConsanguineos = vinculosConsanguineos;
        this.vinculosPorAfinidad = vinculosPorAfinidad;
        this.vinculosVigentes = vinculosVigentes;
        this.vinculosNoVigentes = vinculosNoVigentes;
    }

    public Long getTotalVinculos() {
        return totalVinculos;
    }

    public Long getVinculosConsanguineos() {
        return vinculosConsanguineos;
    }

    public Long getVinculosPorAfinidad() {
        return vinculosPorAfinidad;
    }

    public Long getVinculosVigentes() {
        return vinculosVigentes;
    }

    public Long getVinculosNoVigentes() {
        return vinculosNoVigentes;
    }
}
