package pe.gob.pj.solicitudes.data.infrastructure.adapters.in.rest.dto;

import java.time.LocalDateTime;
import java.util.Map;

public record EventoDto(
        String eventoId,
        String tipoEvento,
        LocalDateTime fechaHora,
        String descripcion,
        UsuarioDto usuario,
        OficinaDto oficina,
        Map<String, Object> detalles,
        Map<String, Object> metadatos,
        String estadoAnterior,
        String estadoNuevo
) {
}
