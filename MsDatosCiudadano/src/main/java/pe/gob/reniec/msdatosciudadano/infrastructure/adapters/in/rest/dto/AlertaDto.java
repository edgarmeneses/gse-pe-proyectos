package pe.gob.reniec.msdatosciudadano.infrastructure.adapters.in.rest.dto;

import java.time.LocalDateTime;

public record AlertaDto (
    String id,
    String estado,
    LocalDateTime fechaCreacion,
    LocalDateTime fechaActualizacion,
    String situacion,
    String motivo,
    LocalDateTime fechaDeteccion,
    LocalDateTime fechaMaximaDescargo,
    String medioVerificacion,
    String nivelAlerta
){

}
