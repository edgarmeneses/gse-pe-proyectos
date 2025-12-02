package pe.gob.reniec.coreografia.cotejo.infrastructure.adapters.in.rest.dto;

public record RegistroCotejoDto(
    Long secuencia,
    String numeroDni,
    String apellidoPaterno,
    String apellidoMaterno,
    String nombres,
    String fechaNacimiento,
    String genero
) {}
