package pe.gob.reniec.padronelectoral.infrastructure.adapters.in.rest.mapper;

import pe.gob.reniec.padronelectoral.domain.model.ActualizacionPadron;
import pe.gob.reniec.padronelectoral.domain.model.Ciudadano;
import pe.gob.reniec.padronelectoral.domain.model.PadronElectoral;
import pe.gob.reniec.padronelectoral.domain.model.PaginatedResult;
import pe.gob.reniec.padronelectoral.infrastructure.adapters.in.rest.dto.ConsultarPadronResponseDto;
import pe.gob.reniec.padronelectoral.infrastructure.adapters.in.rest.dto.ListarPadronesResponseDto;
import pe.gob.reniec.padronelectoral.infrastructure.adapters.in.rest.dto.PadronElectoralResponseDto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PadronElectoralDtoMapper {

    private static final DateTimeFormatter ISO_FORMATTER = DateTimeFormatter.ISO_DATE_TIME;

    public PadronElectoralResponseDto toResponseDto(PadronElectoral padronElectoral) {
        if (padronElectoral == null) {
            return null;
        }

        PadronElectoralResponseDto dto = new PadronElectoralResponseDto();
        dto.setIdPadron(padronElectoral.getIdPadron());
        dto.setTipoPadron(padronElectoral.getTipoPadron());
        dto.setFechaCreacion(formatDateTime(padronElectoral.getFechaCreacion()));
        dto.setFechaActualizacion(formatDateTime(padronElectoral.getFechaActualizacion()));
        dto.setListaCiudadanos(toCiudadanosDtoList(padronElectoral.getListaCiudadanos()));

        return dto;
    }

    public ListarPadronesResponseDto toListarResponseDto(PaginatedResult<PadronElectoral> paginatedResult) {
        if (paginatedResult == null) {
            return null;
        }

        ListarPadronesResponseDto dto = new ListarPadronesResponseDto();
        dto.setNumber(paginatedResult.getNumber());
        dto.setSize(paginatedResult.getSize());
        dto.setTotalElements(paginatedResult.getTotalElements());
        dto.setTotalPages(paginatedResult.getTotalPages());
        dto.setHasNext(paginatedResult.getHasNext());
        dto.setContenido(toPadronResumenDtoList(paginatedResult.getContenido()));

        return dto;
    }

    public ConsultarPadronResponseDto toConsultarResponseDto(PadronElectoral padronElectoral) {
        if (padronElectoral == null) {
            return null;
        }

        ConsultarPadronResponseDto dto = new ConsultarPadronResponseDto();
        
        ConsultarPadronResponseDto.PadronDto padronDto = new ConsultarPadronResponseDto.PadronDto();
        padronDto.setFechaCreacion(formatDateTime(padronElectoral.getFechaCreacion()));
        padronDto.setTipoPadron(padronElectoral.getTipoPadron());
        padronDto.setTipoProceso(padronElectoral.getTipoProceso());
        padronDto.setActualizacionPadron(toActualizacionPadronDtoList(padronElectoral.getActualizacionesPadron()));
        
        dto.setPadron(padronDto);
        dto.setListaCiudadanos(toConsultarCiudadanosDtoList(padronElectoral.getListaCiudadanos()));
        
        return dto;
    }

    private List<PadronElectoralResponseDto.CiudadanoDto> toCiudadanosDtoList(List<Ciudadano> ciudadanos) {
        if (ciudadanos == null) {
            return new ArrayList<>();
        }

        return ciudadanos.stream()
                .map(this::toCiudadanoDto)
                .collect(Collectors.toList());
    }

    private PadronElectoralResponseDto.CiudadanoDto toCiudadanoDto(Ciudadano ciudadano) {
        if (ciudadano == null) {
            return null;
        }

        PadronElectoralResponseDto.CiudadanoDto dto = new PadronElectoralResponseDto.CiudadanoDto();
        dto.setNombre(ciudadano.getNombre());
        dto.setDocumento(ciudadano.getDocumento());
        dto.setDireccion(ciudadano.getDireccion());

        return dto;
    }

    private List<ConsultarPadronResponseDto.CiudadanoDto> toConsultarCiudadanosDtoList(List<Ciudadano> ciudadanos) {
        if (ciudadanos == null) {
            return new ArrayList<>();
        }

        return ciudadanos.stream()
                .map(this::toConsultarCiudadanoDto)
                .collect(Collectors.toList());
    }

    private ConsultarPadronResponseDto.CiudadanoDto toConsultarCiudadanoDto(Ciudadano ciudadano) {
        if (ciudadano == null) {
            return null;
        }

        ConsultarPadronResponseDto.CiudadanoDto dto = new ConsultarPadronResponseDto.CiudadanoDto();
        dto.setNombre(ciudadano.getNombre());
        dto.setDocumento(ciudadano.getDocumento());
        dto.setDireccion(ciudadano.getDireccion());

        return dto;
    }

    private List<ListarPadronesResponseDto.PadronResumenDto> toPadronResumenDtoList(List<PadronElectoral> padrones) {
        if (padrones == null) {
            return new ArrayList<>();
        }

        return padrones.stream()
                .map(this::toPadronResumenDto)
                .collect(Collectors.toList());
    }

    private ListarPadronesResponseDto.PadronResumenDto toPadronResumenDto(PadronElectoral padron) {
        if (padron == null) {
            return null;
        }

        ListarPadronesResponseDto.PadronResumenDto dto = new ListarPadronesResponseDto.PadronResumenDto();
        dto.setIdPadron(padron.getIdPadron());
        dto.setTipoPadron(padron.getTipoPadron());
        dto.setTipoProceso(padron.getTipoProceso());
        dto.setFechaCreacion(formatDateTime(padron.getFechaCreacion()));
        dto.setCantidadCiudadanos(padron.getCantidadCiudadanos());
        
        if (padron.getCircunscripcion() != null) {
            dto.setCircunscripcion(
                padron.getCircunscripcion().getDepartamento() + " - " +
                padron.getCircunscripcion().getProvincia() + " - " +
                padron.getCircunscripcion().getDistrito()
            );
        }

        return dto;
    }

    private List<ConsultarPadronResponseDto.ActualizacionPadronDto> toActualizacionPadronDtoList(
            List<ActualizacionPadron> actualizaciones) {
        if (actualizaciones == null) {
            return new ArrayList<>();
        }

        return actualizaciones.stream()
                .map(this::toActualizacionPadronDto)
                .collect(Collectors.toList());
    }

    private ConsultarPadronResponseDto.ActualizacionPadronDto toActualizacionPadronDto(ActualizacionPadron actualizacion) {
        if (actualizacion == null) {
            return null;
        }

        ConsultarPadronResponseDto.ActualizacionPadronDto dto = new ConsultarPadronResponseDto.ActualizacionPadronDto();
        dto.setFechaActualizacion(formatDateTime(actualizacion.getFechaActualizacion()));
        dto.setUsuarioResponsableId(actualizacion.getUsuarioResponsableId());
        dto.setInformeFinalVerificacionDomicilioId(actualizacion.getInformeFinalVerificacionDomicilioId());

        return dto;
    }

    private String formatDateTime(LocalDateTime dateTime) {
        if (dateTime == null) {
            return null;
        }
        return dateTime.format(ISO_FORMATTER);
    }
}
