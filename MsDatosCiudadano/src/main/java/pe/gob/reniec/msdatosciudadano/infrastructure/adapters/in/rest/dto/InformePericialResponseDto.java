package pe.gob.reniec.msdatosciudadano.infrastructure.adapters.in.rest.dto;

import java.time.LocalDateTime;
import java.util.List;

public record InformePericialResponseDto (
    List<Object> Type,
    EstructuraDto estructura
){
  public record EstructuraDto(
      String informeId,
      String ciudadanoId,
      String solicitudId,
      FechaGeneracionDto fechaGeneracion,
      ResultadoDto resultado,
      String urlPdf
  ) {
    public record ResultadoDto(
        Boolean huellaCoincide,
        Boolean rostroCoincide
    ) {}
    public record FechaGeneracionDto(
        String format,
        LocalDateTime description,
        String string
    ) {}
  }
}
