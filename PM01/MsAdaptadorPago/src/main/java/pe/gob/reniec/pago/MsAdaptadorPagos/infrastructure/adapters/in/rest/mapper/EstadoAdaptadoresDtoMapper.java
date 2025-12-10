package pe.gob.reniec.pago.MsAdaptadorPagos.infrastructure.adapters.in.rest.mapper;

import pe.gob.reniec.pago.MsAdaptadorPagos.domain.model.AdaptadorBancario;
import pe.gob.reniec.pago.MsAdaptadorPagos.infrastructure.adapters.in.rest.dto.EstadoAdaptadoresResponseDto;
import java.util.List;

public class EstadoAdaptadoresDtoMapper {

    public EstadoAdaptadoresResponseDto toDto(List<AdaptadorBancario> domainList) {
        // Mapear la lista de agregados AdaptadorBancario al DTO de respuesta
        throw new UnsupportedOperationException("Implementación pendiente: Mapeo Domain List -> DTO");
    }
}
