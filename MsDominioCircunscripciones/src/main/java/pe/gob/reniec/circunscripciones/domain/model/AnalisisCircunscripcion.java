package pe.gob.reniec.circunscripciones.domain.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class AnalisisCircunscripcion {

    private String analisisId;
    private String cronogramaId;
    private LocalDateTime fechaAnalisis;
    private PeriodoAnalizado periodoAnalizado;
    private EstadisticasGenerales estadisticasGenerales;
    private List<CircunscripcionAfectada> circunscripcionesAfectadas;
    private List<Alerta> alertasDetectadas;
    private List<String> recomendaciones;
    private String estadoAnalisis;
    private Integer tiempoProcesamientoMs;

    public AnalisisCircunscripcion() {
    }

    public AnalisisCircunscripcion(String analisisId, String cronogramaId, LocalDateTime fechaAnalisis,
                                    PeriodoAnalizado periodoAnalizado, EstadisticasGenerales estadisticasGenerales,
                                    List<CircunscripcionAfectada> circunscripcionesAfectadas,
                                    List<Alerta> alertasDetectadas, List<String> recomendaciones,
                                    String estadoAnalisis, Integer tiempoProcesamientoMs) {
        this.analisisId = analisisId;
        this.cronogramaId = cronogramaId;
        this.fechaAnalisis = fechaAnalisis;
        this.periodoAnalizado = periodoAnalizado;
        this.estadisticasGenerales = estadisticasGenerales;
        this.circunscripcionesAfectadas = circunscripcionesAfectadas;
        this.alertasDetectadas = alertasDetectadas;
        this.recomendaciones = recomendaciones;
        this.estadoAnalisis = estadoAnalisis;
        this.tiempoProcesamientoMs = tiempoProcesamientoMs;
    }

    public String getAnalisisId() {
        return analisisId;
    }

    public void setAnalisisId(String analisisId) {
        this.analisisId = analisisId;
    }

    public String getCronogramaId() {
        return cronogramaId;
    }

    public void setCronogramaId(String cronogramaId) {
        this.cronogramaId = cronogramaId;
    }

    public LocalDateTime getFechaAnalisis() {
        return fechaAnalisis;
    }

    public void setFechaAnalisis(LocalDateTime fechaAnalisis) {
        this.fechaAnalisis = fechaAnalisis;
    }

    public PeriodoAnalizado getPeriodoAnalizado() {
        return periodoAnalizado;
    }

    public void setPeriodoAnalizado(PeriodoAnalizado periodoAnalizado) {
        this.periodoAnalizado = periodoAnalizado;
    }

    public EstadisticasGenerales getEstadisticasGenerales() {
        return estadisticasGenerales;
    }

    public void setEstadisticasGenerales(EstadisticasGenerales estadisticasGenerales) {
        this.estadisticasGenerales = estadisticasGenerales;
    }

    public List<CircunscripcionAfectada> getCircunscripcionesAfectadas() {
        return circunscripcionesAfectadas;
    }

    public void setCircunscripcionesAfectadas(List<CircunscripcionAfectada> circunscripcionesAfectadas) {
        this.circunscripcionesAfectadas = circunscripcionesAfectadas;
    }

    public List<Alerta> getAlertasDetectadas() {
        return alertasDetectadas;
    }

    public void setAlertasDetectadas(List<Alerta> alertasDetectadas) {
        this.alertasDetectadas = alertasDetectadas;
    }

    public List<String> getRecomendaciones() {
        return recomendaciones;
    }

    public void setRecomendaciones(List<String> recomendaciones) {
        this.recomendaciones = recomendaciones;
    }

    public String getEstadoAnalisis() {
        return estadoAnalisis;
    }

    public void setEstadoAnalisis(String estadoAnalisis) {
        this.estadoAnalisis = estadoAnalisis;
    }

    public Integer getTiempoProcesamientoMs() {
        return tiempoProcesamientoMs;
    }

    public void setTiempoProcesamientoMs(Integer tiempoProcesamientoMs) {
        this.tiempoProcesamientoMs = tiempoProcesamientoMs;
    }
}
