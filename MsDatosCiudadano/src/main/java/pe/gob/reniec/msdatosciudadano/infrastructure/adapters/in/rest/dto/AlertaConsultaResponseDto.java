package pe.gob.reniec.msdatosciudadano.infrastructure.adapters.in.rest.dto;

public record AlertaConsultaResponseDto (
    AlertaDto alerta,
    CiudadanoDto ciudadano
){
}
