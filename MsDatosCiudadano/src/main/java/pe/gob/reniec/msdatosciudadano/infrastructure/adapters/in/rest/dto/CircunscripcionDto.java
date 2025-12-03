package pe.gob.reniec.msdatosciudadano.infrastructure.adapters.in.rest.dto;

public record CircunscripcionDto(
    String circunscripcionId,
    Integer totalCambios,
    Float promedioCambios,
    MigracionDto migraciones
) {
}
