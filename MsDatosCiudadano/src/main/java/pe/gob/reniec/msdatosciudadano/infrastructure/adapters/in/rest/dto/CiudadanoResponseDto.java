package pe.gob.reniec.msdatosciudadano.infrastructure.adapters.in.rest.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record CiudadanoResponseDto(
    String solicitudId,
    LocalDateTime fechaProcesamiento,
    String estadoProceso,
    List<ResultadoDto> resultados
) {

    public record ResultadoDto(
        String numeroSecuencia,
        String tipoDocumento,
        String numeroDocumento,
        String estadoConsulta,
        DatosCiudadanoDto datosCiudadano
    ) {}

    public record DatosCiudadanoDto(
        String primerApellido,
        String segundoApellido,
        String prenombres,
        LocalDate fechaNacimiento,
        String sexo,
        String estadoCivil,
        String ubigeo,
        String direccion
    ) {}
}
