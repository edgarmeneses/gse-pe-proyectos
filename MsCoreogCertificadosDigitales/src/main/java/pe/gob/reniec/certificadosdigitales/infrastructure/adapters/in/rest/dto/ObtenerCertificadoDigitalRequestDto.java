package pe.gob.reniec.certificadosdigitales.infrastructure.adapters.in.rest.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record ObtenerCertificadoDigitalRequestDto(
    SolicitudDto solicitud,
    CiudadanoDto ciudadano,
    ConfiguracionCertificadosDto configuracionCertificados,
    MetadatosDto metadatos
) {
    public record SolicitudDto(
        String numeroDocumento,
        String tipoDocumento,
        String codigoSolicitudTramite,
        String numeroTramite
    ) {}

    public record CiudadanoDto(
        String nombres,
        String apellidoPaterno,
        String apellidoMaterno,
        LocalDate fechaNacimiento,
        String sexo,
        String correoElectronico,
        String departamento,
        String provincia,
        String distrito
    ) {}

    public record ConfiguracionCertificadosDto(
        List<String> tipoCertificados,
        Long vigenciaAnios,
        Boolean usoExtendido,
        String nivelSeguridad
    ) {}

    public record MetadatosDto(
        String oficinaOrigen,
        String usuarioRegistrador,
        String ipOrigen,
        LocalDateTime timestampSolicitud
    ) {}
}
