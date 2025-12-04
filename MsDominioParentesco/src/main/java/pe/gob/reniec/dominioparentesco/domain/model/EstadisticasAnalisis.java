package pe.gob.reniec.dominioparentesco.domain.model;

/**
 * Value Object - Representa las estadísticas calculadas de un análisis.
 * Inmutable y calculado a partir del estado del aggregate.
 */
public class EstadisticasAnalisis {
    
    private final int totalVinculosEncontrados;
    private final int vinculosPrimerGrado;
    private final int vinculosSegundoGrado;
    private final int vinculosTercerGrado;
    private final int vinculosCuartoGrado;
    private final int vinculosConfiables;
    private final int vinculosRequierenValidacion;
    private final int inconsistenciasDetectadas;
    
    public EstadisticasAnalisis(int totalVinculosEncontrados,
                               int vinculosPrimerGrado,
                               int vinculosSegundoGrado,
                               int vinculosTercerGrado,
                               int vinculosCuartoGrado,
                               int vinculosConfiables,
                               int vinculosRequierenValidacion,
                               int inconsistenciasDetectadas) {
        this.totalVinculosEncontrados = totalVinculosEncontrados;
        this.vinculosPrimerGrado = vinculosPrimerGrado;
        this.vinculosSegundoGrado = vinculosSegundoGrado;
        this.vinculosTercerGrado = vinculosTercerGrado;
        this.vinculosCuartoGrado = vinculosCuartoGrado;
        this.vinculosConfiables = vinculosConfiables;
        this.vinculosRequierenValidacion = vinculosRequierenValidacion;
        this.inconsistenciasDetectadas = inconsistenciasDetectadas;
    }
    
    public double calcularPorcentajeConfiabilidad() {
        if (totalVinculosEncontrados == 0) {
            return 0.0;
        }
        return (double) vinculosConfiables / totalVinculosEncontrados * 100.0;
    }
    
    public boolean todosVinculosSonConfiables() {
        return vinculosConfiables == totalVinculosEncontrados;
    }
    
    public boolean hayVinculosQueRequierenValidacion() {
        return vinculosRequierenValidacion > 0;
    }
    
    // Getters
    public int getTotalVinculosEncontrados() { return totalVinculosEncontrados; }
    public int getVinculosPrimerGrado() { return vinculosPrimerGrado; }
    public int getVinculosSegundoGrado() { return vinculosSegundoGrado; }
    public int getVinculosTercerGrado() { return vinculosTercerGrado; }
    public int getVinculosCuartoGrado() { return vinculosCuartoGrado; }
    public int getVinculosConfiables() { return vinculosConfiables; }
    public int getVinculosRequierenValidacion() { return vinculosRequierenValidacion; }
    public int getInconsistenciasDetectadas() { return inconsistenciasDetectadas; }
    
    @Override
    public String toString() {
        return String.format("Análisis: %d vínculos encontrados (%.1f%% confiables), %d inconsistencias",
            totalVinculosEncontrados, calcularPorcentajeConfiabilidad(), inconsistenciasDetectadas);
    }
}
