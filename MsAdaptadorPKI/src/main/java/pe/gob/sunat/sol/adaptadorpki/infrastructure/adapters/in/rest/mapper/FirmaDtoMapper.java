package pe.gob.sunat.sol.adaptadorpki.infrastructure.adapters.in.rest.mapper;

import pe.gob.sunat.sol.adaptadorpki.domain.model.Firma;
import pe.gob.sunat.sol.adaptadorpki.infrastructure.adapters.in.rest.dto.FirmarDocumentoRequestDto;
import pe.gob.sunat.sol.adaptadorpki.infrastructure.adapters.in.rest.dto.FirmarDocumentoResponseDto;

public class FirmaDtoMapper {

    public Firma toDomain(FirmarDocumentoRequestDto requestDto) {
        if (requestDto == null) {
            return null;
        }
        Firma firma = new Firma();
        firma.setDocumento(requestDto.documento());
        firma.setCertificado(requestDto.certificado());
        firma.setPassword(requestDto.password());
        firma.setTipoFirma(requestDto.tipoFirma());
        return firma;
    }

    public FirmarDocumentoResponseDto toResponseDto(Firma firma) {
        if (firma == null) {
            return null;
        }
        return new FirmarDocumentoResponseDto(
            firma.getDocumentoFirmado(),
            firma.getFechaFirma(),
            firma.getCodigoRespuesta(),
            firma.getMensaje()
        );
    }
}
