package pe.gob.onpe.dominio.tachareclamo.infrastructure.adapters.in.rest.mapper;

import pe.gob.onpe.dominio.tachareclamo.domain.model.Derivacion;
import pe.gob.onpe.dominio.tachareclamo.infrastructure.adapters.in.rest.dto.DerivarTachaReclamoResponseDto;

public class DerivacionDtoMapper {

    public static DerivarTachaReclamoResponseDto toResponseDto(Derivacion derivacion, Long id, String numeroExpediente, 
                                                                String estadoAnterior, String statusCode, String message) {
        if (derivacion == null) {
            return null;
        }

        DerivarTachaReclamoResponseDto dto = new DerivarTachaReclamoResponseDto();
        dto.setId(id);
        dto.setNumeroExpediente(numeroExpediente);
        dto.setEstadoAnterior(estadoAnterior);
        dto.setEstadoActual("DERIVADO");
        dto.setAreaDestino(derivacion.getAreaDestino());
        dto.setFechaDerivacion(derivacion.getFechaDerivacion());
        dto.setStatusCode(statusCode);
        dto.setMessage(message);

        return dto;
    }
}
