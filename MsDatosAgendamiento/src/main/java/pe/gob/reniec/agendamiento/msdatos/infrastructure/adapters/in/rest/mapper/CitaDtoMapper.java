package pe.gob.reniec.agendamiento.msdatos.infrastructure.adapters.in.rest.mapper;

import pe.gob.reniec.agendamiento.msdatos.domain.model.*;
import pe.gob.reniec.agendamiento.msdatos.domain.ports.in.CancelarCitaUseCase;
import pe.gob.reniec.agendamiento.msdatos.domain.ports.in.ListarCitasUseCase;
import pe.gob.reniec.agendamiento.msdatos.infrastructure.adapters.in.rest.dto.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CitaDtoMapper {

    public Cita toDomain(CrearCitaRequestDto dto) {
        if (dto == null) {
            return null;
        }

        Cita cita = new Cita();
        
        if (dto.sedeServicio() != null) {
            SedeServicio sede = new SedeServicio(
                dto.sedeServicio().codigoSede(),
                dto.sedeServicio().nombreSede(),
                null,
                null
            );
            cita.setSedeServicio(sede);
        }
        
        if (dto.solicitud() != null) {
            Solicitud solicitud = new Solicitud(
                dto.solicitud().idSolicitud(),
                dto.solicitud().numeroTramite()
            );
            cita.setSolicitud(solicitud);
        }
        
        if (dto.solicitante() != null) {
            Solicitante solicitante = new Solicitante(
                dto.solicitante().dni(),
                dto.solicitante().nombres(),
                dto.solicitante().apellidoPaterno(),
                dto.solicitante().apellidoMaterno(),
                null,
                dto.solicitante().email(),
                dto.solicitante().telefono()
            );
            cita.setSolicitante(solicitante);
        }
        
        if (dto.programacion() != null) {
            LocalDateTime fechaCita = parseFecha(dto.programacion().fechaCita());
            Programacion programacion = new Programacion(
                fechaCita,
                dto.programacion().horaCita(),
                fechaCita,
                dto.programacion().idDisponibilidad()
            );
            cita.setProgramacion(programacion);
        }
        
        if (dto.tecnicoAsignado() != null) {
            TecnicoAsignado tecnico = new TecnicoAsignado(
                dto.tecnicoAsignado().idTecnico(),
                dto.tecnicoAsignado().nombreCompleto()
            );
            cita.setTecnicoAsignado(tecnico);
        }
        
        cita.setObservaciones(dto.observaciones());
        
        return cita;
    }

    public CrearCitaResponseDto toCrearResponseDto(Cita cita) {
        if (cita == null) {
            return null;
        }

        CrearCitaResponseDto.SedeServicioDto sedeDto = new CrearCitaResponseDto.SedeServicioDto(
            cita.getSedeServicio().getCodigoSede(),
            cita.getSedeServicio().getNombreSede(),
            cita.getSedeServicio().getDireccion()
        );

        CrearCitaResponseDto.SolicitanteDto solicitanteDto = new CrearCitaResponseDto.SolicitanteDto(
            cita.getSolicitante().getDni(),
            cita.getSolicitante().getNombreCompleto()
        );

        CrearCitaResponseDto.ProgramacionDto programacionDto = new CrearCitaResponseDto.ProgramacionDto(
            formatFecha(cita.getProgramacion().getFechaCita()),
            cita.getProgramacion().getHoraCita(),
            formatFecha(cita.getProgramacion().getFechaHoraCompleta())
        );

        CrearCitaResponseDto.TecnicoAsignadoDto tecnicoDto = null;
        if (cita.getTecnicoAsignado() != null) {
            tecnicoDto = new CrearCitaResponseDto.TecnicoAsignadoDto(
                cita.getTecnicoAsignado().getIdTecnico(),
                cita.getTecnicoAsignado().getNombreCompleto()
            );
        }

        CrearCitaResponseDto.LinksDto links = new CrearCitaResponseDto.LinksDto(
            "/api/v1/agendamiento/MsDatosAgendamiento/citas/" + cita.getCitaId(),
            "/api/v1/agendamiento/MsDatosAgendamiento/citas/" + cita.getCitaId(),
            "/api/v1/agendamiento/MsDatosAgendamiento/citas/" + cita.getCitaId() + "/cancelar",
            "/api/v1/agendamiento/MsDatosAgendamiento/citas/" + cita.getCitaId() + "/historial"
        );

        CrearCitaResponseDto.DataDto data = new CrearCitaResponseDto.DataDto(
            cita.getCitaId(),
            cita.getCodigoCita(),
            cita.getEstado().getCodigo(),
            sedeDto,
            solicitanteDto,
            programacionDto,
            tecnicoDto,
            cita.getTokenReagendamiento(),
            formatFecha(cita.getFechaLimiteReagendamiento()),
            formatFecha(cita.getFechaRegistro()),
            cita.getUsuarioRegistro(),
            links
        );

        CrearCitaResponseDto.MetadataDto metadata = new CrearCitaResponseDto.MetadataDto(
            LocalDateTime.now().toString(),
            "correlation-id",
            "v1"
        );

        return new CrearCitaResponseDto(true, data, metadata);
    }

    public ConsultarCitaResponseDto toConsultarResponseDto(Cita cita) {
        if (cita == null) {
            return new ConsultarCitaResponseDto(
                false,
                null,
                new ConsultarCitaResponseDto.MetadataDto("Cita no encontrada", null)
            );
        }

        ConsultarCitaResponseDto.SedeServicioDto sedeDto = new ConsultarCitaResponseDto.SedeServicioDto(
            cita.getSedeServicio().getCodigoSede(),
            cita.getSedeServicio().getNombreSede(),
            cita.getSedeServicio().getDireccion()
        );

        ConsultarCitaResponseDto.SolicitanteDto solicitanteDto = new ConsultarCitaResponseDto.SolicitanteDto(
            cita.getSolicitante().getDni(),
            cita.getSolicitante().getNombreCompleto(),
            cita.getSolicitante().getEmail(),
            cita.getSolicitante().getTelefono()
        );

        ConsultarCitaResponseDto.ProgramacionDto programacionDto = new ConsultarCitaResponseDto.ProgramacionDto(
            formatFecha(cita.getProgramacion().getFechaCita()),
            cita.getProgramacion().getHoraCita(),
            formatFecha(cita.getProgramacion().getFechaHoraCompleta())
        );

        ConsultarCitaResponseDto.TecnicoAsignadoDto tecnicoDto = null;
        if (cita.getTecnicoAsignado() != null) {
            tecnicoDto = new ConsultarCitaResponseDto.TecnicoAsignadoDto(
                cita.getTecnicoAsignado().getIdTecnico(),
                cita.getTecnicoAsignado().getNombreCompleto()
            );
        }

        List<ConsultarCitaResponseDto.HistorialDto> historial = cita.getHistorial() != null
            ? cita.getHistorial().stream()
                .map(h -> new ConsultarCitaResponseDto.HistorialDto(
                    formatFecha(h.getFechaCambio()),
                    h.getUsuario(),
                    h.getCampo(),
                    h.getValorAnterior(),
                    h.getValorNuevo(),
                    h.getMotivo()
                ))
                .collect(Collectors.toList())
            : Collections.emptyList();

        ConsultarCitaResponseDto.CitaDataDto data = new ConsultarCitaResponseDto.CitaDataDto(
            cita.getCitaId(),
            cita.getCodigoCita(),
            cita.getEstado().getCodigo(),
            sedeDto,
            solicitanteDto,
            programacionDto,
            tecnicoDto,
            cita.getTokenReagendamiento(),
            formatFecha(cita.getFechaLimiteReagendamiento()),
            historial
        );

        return new ConsultarCitaResponseDto(
            true,
            data,
            new ConsultarCitaResponseDto.MetadataDto("Consulta exitosa", null)
        );
    }

    public ListarCitasResponseDto toListarResponseDto(ListarCitasUseCase.ResultadoPaginado resultado) {
        if (resultado == null || resultado.citas() == null) {
            return new ListarCitasResponseDto(
                false,
                Collections.emptyList(),
                null,
                new ListarCitasResponseDto.MetadataDto("No se encontraron citas", null)
            );
        }

        List<ListarCitasResponseDto.CitaDto> citas = resultado.citas().stream()
            .map(c -> new ListarCitasResponseDto.CitaDto(
                c.getCitaId(),
                c.getCodigoCita(),
                c.getEstado().getCodigo(),
                c.getSedeServicio().getCodigoSede(),
                c.getSedeServicio().getNombreSede(),
                c.getSolicitante().getDni(),
                c.getSolicitante().getNombreCompleto(),
                formatFecha(c.getProgramacion().getFechaCita()),
                c.getProgramacion().getHoraCita(),
                c.getTecnicoAsignado() != null ? c.getTecnicoAsignado().getNombreCompleto() : null
            ))
            .collect(Collectors.toList());

        ListarCitasResponseDto.PaginacionDto paginacion = new ListarCitasResponseDto.PaginacionDto(
            resultado.paginacion().getTotalElementos(),
            resultado.paginacion().getTotalPaginas(),
            resultado.paginacion().getPaginaActual(),
            resultado.paginacion().getElementosPorPagina(),
            resultado.paginacion().isHaySiguiente(),
            resultado.paginacion().isHayAnterior()
        );

        return new ListarCitasResponseDto(
            true,
            citas,
            paginacion,
            new ListarCitasResponseDto.MetadataDto("Listado de citas exitoso", null)
        );
    }

    public Cita toDomainActualizar(ActualizarCitaRequestDto dto) {
        if (dto == null) {
            return null;
        }

        Cita cita = new Cita();
        
        if (dto.nuevaProgramacion() != null) {
            LocalDateTime fechaCita = parseFecha(dto.nuevaProgramacion().fechaCita());
            Programacion programacion = new Programacion(
                fechaCita,
                dto.nuevaProgramacion().horaCita(),
                fechaCita,
                dto.nuevaProgramacion().idDisponibilidad()
            );
            cita.setProgramacion(programacion);
        }
        
        if (dto.tecnicoAsignado() != null) {
            TecnicoAsignado tecnico = new TecnicoAsignado(
                dto.tecnicoAsignado().idTecnico(),
                dto.tecnicoAsignado().nombreCompleto()
            );
            cita.setTecnicoAsignado(tecnico);
        }
        
        cita.setObservaciones(dto.observaciones());
        
        return cita;
    }

    public ActualizarCitaResponseDto toActualizarResponseDto(Cita cita) {
        if (cita == null) {
            return new ActualizarCitaResponseDto(
                false,
                null,
                new ActualizarCitaResponseDto.MetadataDto("Error al actualizar cita", null)
            );
        }

        ActualizarCitaResponseDto.CitaDataDto data = new ActualizarCitaResponseDto.CitaDataDto(
            cita.getCitaId(),
            cita.getCodigoCita(),
            cita.getEstado().getCodigo(),
            formatFecha(cita.getProgramacion().getFechaCita()),
            cita.getProgramacion().getHoraCita(),
            cita.getTecnicoAsignado() != null ? cita.getTecnicoAsignado().getNombreCompleto() : null,
            formatFecha(cita.getFechaActualizacion())
        );

        return new ActualizarCitaResponseDto(
            true,
            data,
            new ActualizarCitaResponseDto.MetadataDto("Cita actualizada exitosamente", null)
        );
    }

    public CancelarCitaResponseDto toCancelarResponseDto(CancelarCitaUseCase.ResultadoCancelacion resultado) {
        if (resultado == null) {
            return new CancelarCitaResponseDto(
                false,
                null,
                new CancelarCitaResponseDto.MetadataDto("Error al cancelar cita", null)
            );
        }

        CancelarCitaResponseDto.CitaDataDto data = new CancelarCitaResponseDto.CitaDataDto(
            resultado.citaId(),
            resultado.codigoCita(),
            resultado.estadoFinal(),
            resultado.motivoCancelacion(),
            formatFecha(resultado.fechaCancelacion()),
            resultado.usuarioCancelacion(),
            resultado.permiteCancelar()
        );

        return new CancelarCitaResponseDto(
            true,
            data,
            new CancelarCitaResponseDto.MetadataDto("Cita cancelada exitosamente", null)
        );
    }

    public FiltroCita toFiltroCita(String codigoSede, String estado, String dniSolicitante,
                                    String numeroTramite, String idTecnico, String fechaDesde,
                                    String fechaHasta, Integer page, Integer size,
                                    String sort, String direction) {
        FiltroCita filtro = new FiltroCita();
        filtro.setCodigoSede(codigoSede);
        filtro.setEstado(estado);
        filtro.setDniSolicitante(dniSolicitante);
        filtro.setNumeroTramite(numeroTramite);
        filtro.setIdTecnico(idTecnico);
        filtro.setFechaDesde(fechaDesde != null ? LocalDate.parse(fechaDesde) : null);
        filtro.setFechaHasta(fechaHasta != null ? LocalDate.parse(fechaHasta) : null);
        filtro.setPage(page);
        filtro.setSize(size);
        filtro.setSort(sort);
        filtro.setDirection(direction);
        return filtro;
    }

    private LocalDateTime parseFecha(String fecha) {
        if (fecha == null) {
            return null;
        }
        return LocalDateTime.parse(fecha, DateTimeFormatter.ISO_DATE_TIME);
    }

    private String formatFecha(LocalDateTime fecha) {
        if (fecha == null) {
            return null;
        }
        return fecha.format(DateTimeFormatter.ISO_DATE_TIME);
    }
}
