package pe.gob.sunat.sol.adaptadorpki.infrastructure.adapters.in.rest.mapper;

import pe.gob.sunat.sol.adaptadorpki.domain.model.Certificado;
import pe.gob.sunat.sol.adaptadorpki.infrastructure.adapters.in.rest.dto.ValidarCertificadoRequestDto;
import pe.gob.sunat.sol.adaptadorpki.infrastructure.adapters.in.rest.dto.ValidarCertificadoResponseDto;
import pe.gob.sunat.sol.adaptadorpki.infrastructure.adapters.in.rest.dto.ConsultarCertificadoResponseDto;

public class CertificadoDtoMapper {

    public Certificado toDomain(ValidarCertificadoRequestDto requestDto) {
        if (requestDto == null) {
            return null;
        }
        Certificado certificado = new Certificado();
        certificado.setCertificado(requestDto.certificado());
        certificado.setFechaValidacion(requestDto.fechaValidacion());
        return certificado;
    }

    public ValidarCertificadoResponseDto toValidarResponseDto(Certificado certificado) {
        if (certificado == null) {
            return null;
        }
        return new ValidarCertificadoResponseDto(
            certificado.getEsValido(),
            certificado.getFechaExpiracion(),
            certificado.getEmisor(),
            certificado.getTitular(),
            certificado.getCodigoRespuesta(),
            certificado.getMensaje()
        );
    }

    public ConsultarCertificadoResponseDto toConsultarResponseDto(Certificado certificado) {
        if (certificado == null) {
            return null;
        }
        return new ConsultarCertificadoResponseDto(
            certificado.getNumeroCertificado(),
            certificado.getTitular(),
            certificado.getEmisor(),
            certificado.getFechaEmision(),
            certificado.getFechaExpiracion(),
            certificado.getEstado(),
            certificado.getCodigoRespuesta(),
            certificado.getMensaje()
        );
    }
}
