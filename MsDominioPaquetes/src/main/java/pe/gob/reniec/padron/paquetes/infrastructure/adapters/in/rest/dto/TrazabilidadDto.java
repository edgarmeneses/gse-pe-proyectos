package pe.gob.reniec.padron.paquetes.infrastructure.adapters.in.rest.dto;

import java.time.LocalDateTime;

public record TrazabilidadDto(
    String accion,
    LocalDateTime fechaAccion,
    String usuarioAccion,
    String ipOrigen,
    String detalleAccion
) {}
