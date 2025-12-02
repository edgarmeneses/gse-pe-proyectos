package pe.gob.reniec.msdatosregistradores.infrastructure.adapters.in.rest.dto;

import java.util.List;

public record ListaDataDto(
    List<RegistradorListItemDto> registradores,
    PaginacionDto paginacion
) {}
