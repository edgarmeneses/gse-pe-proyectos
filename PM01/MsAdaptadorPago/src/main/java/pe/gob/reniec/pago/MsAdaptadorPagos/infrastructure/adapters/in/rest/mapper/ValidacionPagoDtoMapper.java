package pe.gob.reniec.pago.MsAdaptadorPagos.infrastructure.adapters.in.rest.mapper;

import pe.gob.reniec.pago.MsAdaptadorPagos.domain.model.ValidacionPago;
import pe.gob.reniec.pago.MsAdaptadorPagos.infrastructure.adapters.in.rest.dto.ValidacionPagoRequestDto;
import pe.gob.reniec.pago.MsAdaptadorPagos.infrastructure.adapters.in.rest.dto.ValidacionPagoResponseDto;

public class ValidacionPagoDtoMapper {

    public ValidacionPago toDomain(ValidacionPagoRequestDto dto) {
        // Aquí se debe implementar la lógica de mapeo manual
        // Convirtiendo DTOs anidados a Value Objects del dominio
        throw new UnsupportedOperationException("Implementación pendiente: Mapeo DTO -> Domain");
    }

    public ValidacionPagoResponseDto toDto(ValidacionPago domain) {
        // Aquí se debe implementar la lógica de mapeo manual
        // Convirtiendo el Aggregate Root y sus VOs a la estructura plana/anidada del DTO
        throw new UnsupportedOperationException("Implementación pendiente: Mapeo Domain -> DTO");
    }
}
