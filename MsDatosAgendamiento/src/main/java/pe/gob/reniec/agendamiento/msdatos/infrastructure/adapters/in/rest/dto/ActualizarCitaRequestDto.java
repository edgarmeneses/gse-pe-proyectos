package pe.gob.reniec.agendamiento.msdatos.infrastructure.adapters.in.rest.dto;

public record ActualizarCitaRequestDto(
    String tokenReagendamiento,
    NuevaProgramacionDto nuevaProgramacion,
    TecnicoAsignadoDto tecnicoAsignado,
    String motivoCambio,
    String observaciones
) {
    public record NuevaProgramacionDto(
        String fechaCita,
        String horaCita,
        String idDisponibilidad
    ) {}

    public record TecnicoAsignadoDto(
        String idTecnico,
        String nombreCompleto
    ) {}
}
