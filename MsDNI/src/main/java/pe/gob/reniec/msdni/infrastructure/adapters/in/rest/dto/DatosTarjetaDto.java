package pe.gob.reniec.msdni.infrastructure.adapters.in.rest.dto;

public record DatosTarjetaDto(
    String fechaEmisionDni,
    String fechaCaducidadDni,
    Long versionDni,
    String numeroTarjeta
) {}
