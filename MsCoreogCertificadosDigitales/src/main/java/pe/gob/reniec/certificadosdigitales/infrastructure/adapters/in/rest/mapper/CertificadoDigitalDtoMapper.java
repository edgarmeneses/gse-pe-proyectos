package pe.gob.reniec.certificadosdigitales.infrastructure.adapters.in.rest.mapper;

import pe.gob.reniec.certificadosdigitales.domain.model.Auditoria;
import pe.gob.reniec.certificadosdigitales.domain.model.CertificadoDigital;
import pe.gob.reniec.certificadosdigitales.domain.model.Certificado;
import pe.gob.reniec.certificadosdigitales.domain.model.Ciudadano;
import pe.gob.reniec.certificadosdigitales.domain.model.ConfiguracionCertificados;
import pe.gob.reniec.certificadosdigitales.domain.model.Metadatos;
import pe.gob.reniec.certificadosdigitales.domain.model.PasoProceso;
import pe.gob.reniec.certificadosdigitales.domain.model.PasosProceso;
import pe.gob.reniec.certificadosdigitales.domain.model.Solicitud;
import pe.gob.reniec.certificadosdigitales.domain.model.Transaccion;
import pe.gob.reniec.certificadosdigitales.infrastructure.adapters.in.rest.dto.ObtenerCertificadoDigitalRequestDto;
import pe.gob.reniec.certificadosdigitales.infrastructure.adapters.in.rest.dto.ObtenerCertificadoDigitalResponseDto;

import java.util.List;
import java.util.stream.Collectors;

public class CertificadoDigitalDtoMapper {

    public Solicitud toSolicitudDomain(ObtenerCertificadoDigitalRequestDto.SolicitudDto dto) {
        if (dto == null) {
            return null;
        }
        return new Solicitud(
            dto.numeroDocumento(),
            dto.tipoDocumento(),
            dto.codigoSolicitudTramite(),
            dto.numeroTramite()
        );
    }

    public Ciudadano toCiudadanoDomain(ObtenerCertificadoDigitalRequestDto.CiudadanoDto dto) {
        if (dto == null) {
            return null;
        }
        return new Ciudadano(
            dto.nombres(),
            dto.apellidoPaterno(),
            dto.apellidoMaterno(),
            dto.fechaNacimiento(),
            dto.sexo(),
            dto.correoElectronico(),
            dto.departamento(),
            dto.provincia(),
            dto.distrito()
        );
    }

    public ConfiguracionCertificados toConfiguracionCertificadosDomain(ObtenerCertificadoDigitalRequestDto.ConfiguracionCertificadosDto dto) {
        if (dto == null) {
            return null;
        }
        return new ConfiguracionCertificados(
            dto.tipoCertificados(),
            dto.vigenciaAnios(),
            dto.usoExtendido(),
            dto.nivelSeguridad()
        );
    }

    public Metadatos toMetadatosDomain(ObtenerCertificadoDigitalRequestDto.MetadatosDto dto) {
        if (dto == null) {
            return null;
        }
        return new Metadatos(
            dto.oficinaOrigen(),
            dto.usuarioRegistrador(),
            dto.ipOrigen(),
            dto.timestampSolicitud()
        );
    }

    public ObtenerCertificadoDigitalResponseDto toResponseDto(
        CertificadoDigital certificadoDigital,
        Boolean success,
        Long statusCode,
        String message
    ) {
        if (certificadoDigital == null) {
            return null;
        }

        ObtenerCertificadoDigitalResponseDto.DataDto dataDto = new ObtenerCertificadoDigitalResponseDto.DataDto(
            toTransaccionDto(certificadoDigital.getTransaccion()),
            toCiudadanoResumenDto(certificadoDigital.getCiudadano()),
            toCertificadosDto(certificadoDigital.getCertificados()),
            toPasosProcesoDto(certificadoDigital.getPasosProceso()),
            toAuditoriaDto(certificadoDigital.getAuditoria())
        );

        return new ObtenerCertificadoDigitalResponseDto(
            success,
            statusCode,
            message,
            dataDto,
            null,
            null
        );
    }

    private ObtenerCertificadoDigitalResponseDto.TransaccionDto toTransaccionDto(Transaccion transaccion) {
        if (transaccion == null) {
            return null;
        }
        return new ObtenerCertificadoDigitalResponseDto.TransaccionDto(
            transaccion.getTransaccionId(),
            transaccion.getCodigoSolicitudTramite(),
            transaccion.getEstado(),
            transaccion.getFechaInicio(),
            transaccion.getFechaFin(),
            transaccion.getTiempoProcesamientoMs()
        );
    }

    private ObtenerCertificadoDigitalResponseDto.CiudadanoResumenDto toCiudadanoResumenDto(Ciudadano ciudadano) {
        if (ciudadano == null) {
            return null;
        }
        String nombreCompleto = ciudadano.getNombres() + " " +
            ciudadano.getApellidoPaterno() + " " +
            (ciudadano.getApellidoMaterno() != null ? ciudadano.getApellidoMaterno() : "");
        
        return new ObtenerCertificadoDigitalResponseDto.CiudadanoResumenDto(
            null,
            nombreCompleto.trim()
        );
    }

    private List<ObtenerCertificadoDigitalResponseDto.CertificadoDto> toCertificadosDto(List<Certificado> certificados) {
        if (certificados == null) {
            return null;
        }
        return certificados.stream()
            .map(this::toCertificadoDto)
            .collect(Collectors.toList());
    }

    private ObtenerCertificadoDigitalResponseDto.CertificadoDto toCertificadoDto(Certificado certificado) {
        if (certificado == null) {
            return null;
        }
        return new ObtenerCertificadoDigitalResponseDto.CertificadoDto(
            certificado.getTipoCertificado(),
            certificado.getCertificadoId(),
            certificado.getNumeroSerie(),
            certificado.getFechaEmision(),
            certificado.getFechaVencimiento(),
            certificado.getVigenciaAnios(),
            certificado.getEstadoCertificado(),
            certificado.getAlgoritmoFirma(),
            certificado.getLongitudClave(),
            certificado.getSubjectDN(),
            certificado.getHuellaCertificado(),
            certificado.getCertificadoBase64()
        );
    }

    private ObtenerCertificadoDigitalResponseDto.PasosProcesoDto toPasosProcesoDto(PasosProceso pasosProceso) {
        if (pasosProceso == null) {
            return null;
        }
        return new ObtenerCertificadoDigitalResponseDto.PasosProcesoDto(
            toPasoProcesoDto(pasosProceso.getPaso1GeneracionClaves()),
            toPasoProcesoDto(pasosProceso.getPaso2EmisionCertificado())
        );
    }

    private ObtenerCertificadoDigitalResponseDto.PasoProcesoDto toPasoProcesoDto(PasoProceso pasoProceso) {
        if (pasoProceso == null) {
            return null;
        }
        return new ObtenerCertificadoDigitalResponseDto.PasoProcesoDto(
            pasoProceso.getEstado(),
            pasoProceso.getSolicitudPkiId(),
            pasoProceso.getFechaInicio(),
            pasoProceso.getFechaFin(),
            pasoProceso.getIntentos()
        );
    }

    private ObtenerCertificadoDigitalResponseDto.AuditoriaDto toAuditoriaDto(Auditoria auditoria) {
        if (auditoria == null) {
            return null;
        }
        return new ObtenerCertificadoDigitalResponseDto.AuditoriaDto(
            auditoria.getRegistroAuditoriaId(),
            auditoria.getUsuarioEjecutor(),
            auditoria.getOficinaEjecucion(),
            auditoria.getIpCliente()
        );
    }
}
