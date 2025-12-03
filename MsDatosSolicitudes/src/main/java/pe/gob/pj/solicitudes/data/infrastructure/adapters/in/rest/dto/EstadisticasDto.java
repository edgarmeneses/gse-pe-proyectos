package pe.gob.pj.solicitudes.data.infrastructure.adapters.in.rest.dto;

import java.util.List;
import java.util.Map;

public record EstadisticasDto(
        String tiempoTotalProceso,
        Map<String, String> tiempoPorEtapa,
        Long usuariosInvolucrados,
        List<String> oficinasProceso
) {
}
