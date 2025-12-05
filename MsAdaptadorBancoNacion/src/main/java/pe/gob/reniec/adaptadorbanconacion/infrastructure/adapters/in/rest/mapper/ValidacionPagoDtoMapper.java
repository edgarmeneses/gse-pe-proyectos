package pe.gob.reniec.adaptadorbanconacion.infrastructure.adapters.in.rest.mapper;

import pe.gob.reniec.adaptadorbanconacion.domain.model.Auditoria;
import pe.gob.reniec.adaptadorbanconacion.domain.model.Coincidencias;
import pe.gob.reniec.adaptadorbanconacion.domain.model.DetalleTransaccion;
import pe.gob.reniec.adaptadorbanconacion.domain.model.Metadata;
import pe.gob.reniec.adaptadorbanconacion.domain.model.SolicitudValidacion;
import pe.gob.reniec.adaptadorbanconacion.domain.model.Validacion;
import pe.gob.reniec.adaptadorbanconacion.infrastructure.adapters.in.rest.dto.AuditoriaDto;
import pe.gob.reniec.adaptadorbanconacion.infrastructure.adapters.in.rest.dto.CoincidenciasDto;
import pe.gob.reniec.adaptadorbanconacion.infrastructure.adapters.in.rest.dto.DetalleTransaccionDto;
import pe.gob.reniec.adaptadorbanconacion.infrastructure.adapters.in.rest.dto.MetadataDto;
import pe.gob.reniec.adaptadorbanconacion.infrastructure.adapters.in.rest.dto.ValidacionPagoRequestDto;
import pe.gob.reniec.adaptadorbanconacion.infrastructure.adapters.in.rest.dto.ValidacionPagoResponseDto;

public class ValidacionPagoDtoMapper {

    public SolicitudValidacion toDomain(ValidacionPagoRequestDto dto) {
        throw new UnsupportedOperationException("Implementación pendiente");
    }

    public ValidacionPagoResponseDto toDto(Validacion validacion) {
        throw new UnsupportedOperationException("Implementación pendiente");
    }

    public Metadata metadataToDomain(MetadataDto dto) {
        throw new UnsupportedOperationException("Implementación pendiente");
    }

    public DetalleTransaccionDto detalleTransaccionToDto(DetalleTransaccion detalleTransaccion) {
        throw new UnsupportedOperationException("Implementación pendiente");
    }

    public CoincidenciasDto coincidenciasToDto(Coincidencias coincidencias) {
        throw new UnsupportedOperationException("Implementación pendiente");
    }

    public AuditoriaDto auditoriaToDto(Auditoria auditoria) {
        throw new UnsupportedOperationException("Implementación pendiente");
    }
}
