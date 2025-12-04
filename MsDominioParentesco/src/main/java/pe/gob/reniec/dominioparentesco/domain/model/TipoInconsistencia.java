package pe.gob.reniec.dominioparentesco.domain.model;

/**
 * Enum - Tipos de inconsistencias que pueden detectarse en el análisis.
 */
public enum TipoInconsistencia {
    
    // Inconsistencias críticas
    FECHA_NACIMIENTO_INCONSISTENTE(true, "Fechas de nacimiento imposibles o contradictorias"),
    VINCULO_IMPOSIBLE(true, "Vínculo que viola reglas lógicas de parentesco"),
    DUPLICIDAD_IDENTIDAD(true, "Misma persona registrada con identidades diferentes"),
    
    // Inconsistencias que requieren revisión
    TIPO_VINCULO_INCOMPATIBLE(false, "Tipo de vínculo no corresponde con el análisis solicitado"),
    ACTA_FALTANTE(false, "No se encuentra el acta de sustento"),
    DATOS_INCOMPLETOS(false, "Información incompleta en los registros"),
    DIFERENCIA_EDAD_INUSUAL(false, "Diferencia de edad fuera de lo común"),
    
    // Inconsistencias menores
    VARIACION_NOMBRE(false, "Variaciones en el nombre del ciudadano"),
    DATOS_NO_DIGITALIZADOS(false, "Actas no digitalizadas");
    
    private final boolean critica;
    private final String descripcion;
    
    TipoInconsistencia(boolean critica, String descripcion) {
        this.critica = critica;
        this.descripcion = descripcion;
    }
    
    public boolean esCritica() {
        return critica;
    }
    
    public boolean requiereRevision() {
        return this == TIPO_VINCULO_INCOMPATIBLE ||
               this == DIFERENCIA_EDAD_INUSUAL ||
               this == DATOS_INCOMPLETOS;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
}
