package pe.gob.pj.solicitudes.data.infrastructure.adapters.in.rest.dto;

import java.util.List;
import java.util.Map;

public final class EstadisticasDto {
    private final String tiempoTotalProceso;
    private final Map<String, String> tiempoPorEtapa;
    private final Long usuariosInvolucrados;
    private final List<String> oficinasProceso;

    public EstadisticasDto(String tiempoTotalProceso, Map<String, String> tiempoPorEtapa, Long usuariosInvolucrados, List<String> oficinasProceso) {
        this.tiempoTotalProceso = tiempoTotalProceso;
        this.tiempoPorEtapa = tiempoPorEtapa;
        this.usuariosInvolucrados = usuariosInvolucrados;
        this.oficinasProceso = oficinasProceso;
    }

    public String tiempoTotalProceso() { return tiempoTotalProceso; }
    public Map<String, String> tiempoPorEtapa() { return tiempoPorEtapa; }
    public Long usuariosInvolucrados() { return usuariosInvolucrados; }
    public List<String> oficinasProceso() { return oficinasProceso; }
}
