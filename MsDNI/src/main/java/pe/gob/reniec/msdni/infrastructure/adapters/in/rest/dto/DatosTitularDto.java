package pe.gob.reniec.msdni.infrastructure.adapters.in.rest.dto;

public record DatosTitularDto(
    String CUI,
    String nombres,
    String apellidoPaterno,
    String apellidoMaterno,
    String fechaNacimiento,
    String lugarNacimiento,
    String sexo,
    String estadoCivil,
    String fotografia,
    String firma,
    String domicilio
) {}
