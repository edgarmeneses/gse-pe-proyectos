package pe.gob.reniec.msdni.infrastructure.adapters.in.rest.dto;

public record DatosTitularMenorDto(
    String CUI,
    String nombresApellidos,
    String fechaNacimiento,
    String lugarNacimiento,
    String sexo,
    String fotografia,
    String domicilio,
    ProgenitorDto madre,
    ProgenitorDto padre
) {}
