package pe.gob.reniec.padron.paquetes.infrastructure.adapters.in.rest.mapper;

import pe.gob.reniec.padron.paquetes.domain.model.*;
import pe.gob.reniec.padron.paquetes.infrastructure.adapters.in.rest.dto.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Mapper para convertir entre objetos del dominio y DTOs REST.
 * Implementación sin frameworks de mapeo.
 */
public class PaqueteDtoMapper {

    private static final DateTimeFormatter ISO_FORMATTER = DateTimeFormatter.ISO_DATE_TIME;

    public ConsultaPaquetesResponseDto toConsultaPaquetesResponseDto(ConsultaPaquetesResult result) {
        throw new UnsupportedOperationException("Método de mapeo a implementar");
    }

    public AprobarPaqueteResponseDto toAprobarPaqueteResponseDto(AprobacionResult result) {
        throw new UnsupportedOperationException("Método de mapeo a implementar");
    }

    public ConfirmarRevisionResponseDto toConfirmarRevisionResponseDto(ConfirmacionRevisionResult result) {
        throw new UnsupportedOperationException("Método de mapeo a implementar");
    }

    public InformacionPublicacion toInformacionPublicacion(InformacionPublicacionDto dto) {
        if (dto == null) {
            return null;
        }
        
        InformacionPublicacion informacion = new InformacionPublicacion();
        if (dto.fechaPublicacion() != null) {
            informacion.setFechaPublicacion(dto.fechaPublicacion());
        }
        informacion.setLugarPublicacion(dto.lugarPublicacion());
        informacion.setObservaciones(dto.observaciones());
        
        return informacion;
    }

    private String formatLocalDateTime(LocalDateTime dateTime) {
        if (dateTime == null) {
            return null;
        }
        return dateTime.format(ISO_FORMATTER);
    }
}
