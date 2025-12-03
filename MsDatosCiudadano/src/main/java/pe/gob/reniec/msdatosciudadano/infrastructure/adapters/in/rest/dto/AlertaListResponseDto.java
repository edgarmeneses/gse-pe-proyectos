package pe.gob.reniec.msdatosciudadano.infrastructure.adapters.in.rest.dto;

import java.util.List;

public record AlertaListResponseDto (
    PageDto page,
    List<Object> alerts
){

}
