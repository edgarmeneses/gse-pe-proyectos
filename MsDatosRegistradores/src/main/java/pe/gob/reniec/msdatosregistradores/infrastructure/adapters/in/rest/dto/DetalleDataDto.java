package pe.gob.reniec.msdatosregistradores.infrastructure.adapters.in.rest.dto;

import java.util.List;

public record DetalleDataDto(
    String idRegistrador,
    String numeroDni,
    String primerApellido,
    String segundoApellido,
    String prenombres,
    String nombreCompleto,
    String numeroImagen,
    AsignacionActualDto asignacionActual,
    FirmaDto firma,
    SelloDto sello,
    List<PeriodoDto> periodos,
    AuditoriaDto auditoria,
    LinksDto _links
) {}
