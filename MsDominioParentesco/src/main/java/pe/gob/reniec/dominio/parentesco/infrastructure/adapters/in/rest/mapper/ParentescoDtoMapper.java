package pe.gob.reniec.dominio.parentesco.infrastructure.adapters.in.rest.mapper;

import pe.gob.reniec.dominio.parentesco.domain.model.*;
import pe.gob.reniec.dominio.parentesco.infrastructure.adapters.in.rest.dto.*;

import java.util.List;
import java.util.stream.Collectors;

public class ParentescoDtoMapper {

    public SolicitudAnalisisParentesco toDomain(SolicitudAnalisisParentescoRequestDto dto) {
        if (dto == null) {
            return null;
        }
        
        SolicitudAnalisisParentesco solicitud = new SolicitudAnalisisParentesco();
        solicitud.setIdSolicitud(dto.idSolicitud());
        solicitud.setIdCiudadanoConsultado(dto.idCiudadanoConsultado());
        solicitud.setDatosCiudadano(toDatosCiudadano(dto.datosCiudadano()));
        solicitud.setTipoVinculo(dto.tipoVinculo());
        solicitud.setNivelComplejidad(dto.nivelComplejidad());
        solicitud.setCriteriosBusqueda(toCriteriosBusqueda(dto.criteriosBusqueda()));
        solicitud.setOpcionesAnalisis(toOpcionesAnalisis(dto.opcionesAnalisis()));
        solicitud.setUsuarioTecnico(dto.usuarioTecnico());
        solicitud.setObservaciones(dto.observaciones());
        
        return solicitud;
    }

    private DatosCiudadano toDatosCiudadano(DatosCiudadanoRequestDto dto) {
        if (dto == null) {
            return null;
        }
        
        return new DatosCiudadano(
            dto.nombres(),
            dto.apellidoPaterno(),
            dto.apellidoMaterno(),
            dto.fechaNacimiento(),
            dto.sexo(),
            dto.estadoCivil()
        );
    }

    private RangoAnios toRangoAnios(RangoAniosRequestDto dto) {
        if (dto == null) {
            return null;
        }
        
        return new RangoAnios(dto.anioInicio(), dto.anioFin());
    }

    private CriteriosBusqueda toCriteriosBusqueda(CriteriosBusquedaRequestDto dto) {
        if (dto == null) {
            return null;
        }
        
        return new CriteriosBusqueda(
            toRangoAnios(dto.rangoAniosPadres()),
            toRangoAnios(dto.rangoAniosHijos()),
            dto.variacionesNombre(),
            dto.incluirFallecidos(),
            dto.incluirActasAnuladas()
        );
    }

    private OpcionesAnalisis toOpcionesAnalisis(OpcionesAnalisisRequestDto dto) {
        if (dto == null) {
            return null;
        }
        
        return new OpcionesAnalisis(
            dto.generarArbolGenealogico(),
            dto.validarContraAPD(),
            dto.incluirActasSustento(),
            dto.detectarInconsistencias()
        );
    }

    public AnalisisParentescoResponseDto toResponseDto(AnalisisParentesco analisis, Metadata metadata) {
        if (analisis == null) {
            return null;
        }
        
        AnalisisParentescoDataResponseDto data = new AnalisisParentescoDataResponseDto(
            analisis.getIdAnalisis(),
            analisis.getIdSolicitud(),
            analisis.getIdCiudadanoConsultado(),
            analisis.getTipoVinculo(),
            analisis.getNivelComplejidad(),
            analisis.getEstado(),
            toCiudadanoAnalizadoDto(analisis.getCiudadanoAnalizado()),
            toPoblacionVinculosDto(analisis.getPoblacionVinculosPosibles()),
            toResumenAnalisisDto(analisis.getResumenAnalisis()),
            toInconsistenciasDto(analisis.getInconsistencias()),
            toActasPendientesDto(analisis.getActasPendientesDigitalizacion()),
            analisis.getFechaAnalisis(),
            analisis.getTiempoProcesamientoMs(),
            analisis.getUsuarioTecnico()
        );
        
        return new AnalisisParentescoResponseDto(
            true,
            data,
            toMetadataDto(metadata)
        );
    }

    private CiudadanoAnalizadoResponseDto toCiudadanoAnalizadoDto(CiudadanoAnalizado ciudadano) {
        if (ciudadano == null) {
            return null;
        }
        
        return new CiudadanoAnalizadoResponseDto(
            ciudadano.getIdCiudadano(),
            ciudadano.getNombreCompleto(),
            ciudadano.getFechaNacimiento(),
            ciudadano.getEstadoCivil(),
            toDatosAPDDto(ciudadano.getDatosAPD())
        );
    }

    private DatosAPDResponseDto toDatosAPDDto(DatosAPD datosAPD) {
        if (datosAPD == null) {
            return null;
        }
        
        return new DatosAPDResponseDto(
            datosAPD.getVersion(),
            datosAPD.getUltimaActualizacion(),
            datosAPD.getEstadoAPD()
        );
    }

    private PoblacionVinculosPosiblesResponseDto toPoblacionVinculosDto(PoblacionVinculosPosibles poblacion) {
        if (poblacion == null) {
            return null;
        }
        
        return new PoblacionVinculosPosiblesResponseDto(
            poblacion.getTotalEncontrados(),
            toVinculosConsanguineosDto(poblacion.getVinculosConsanguineos()),
            toVinculosAfinidadDto(poblacion.getVinculosAfinidad())
        );
    }

    private List<VinculoConsanguineoResponseDto> toVinculosConsanguineosDto(List<VinculoConsanguineo> vinculos) {
        if (vinculos == null) {
            return null;
        }
        
        return vinculos.stream()
            .map(this::toVinculoConsanguineoDto)
            .collect(Collectors.toList());
    }

    private VinculoConsanguineoResponseDto toVinculoConsanguineoDto(VinculoConsanguineo vinculo) {
        if (vinculo == null) {
            return null;
        }
        
        return new VinculoConsanguineoResponseDto(
            vinculo.getIdVinculoPosible(),
            vinculo.getIdCiudadanoRelacionado(),
            vinculo.getNombreCompleto(),
            vinculo.getTipoParentesco(),
            vinculo.getDescripcionParentesco(),
            vinculo.getGradoConsanguinidad(),
            vinculo.getLineaParentesco(),
            toActaSustentoDto(vinculo.getActaSustento()),
            vinculo.getNivelConfianza(),
            vinculo.getEstadoConfirmacion(),
            vinculo.getRequiereValidacionManual(),
            vinculo.getObservaciones()
        );
    }

    private List<VinculoAfinidadResponseDto> toVinculosAfinidadDto(List<VinculoAfinidad> vinculos) {
        if (vinculos == null) {
            return null;
        }
        
        return vinculos.stream()
            .map(this::toVinculoAfinidadDto)
            .collect(Collectors.toList());
    }

    private VinculoAfinidadResponseDto toVinculoAfinidadDto(VinculoAfinidad vinculo) {
        if (vinculo == null) {
            return null;
        }
        
        return new VinculoAfinidadResponseDto(
            vinculo.getIdVinculoPosible(),
            vinculo.getIdCiudadanoRelacionado(),
            vinculo.getNombreCompleto(),
            vinculo.getTipoParentesco(),
            vinculo.getDescripcionParentesco(),
            vinculo.getGradoAfinidad(),
            toConyugeIntermedioDto(vinculo.getConyugeIntermedio()),
            toActaSustentoDto(vinculo.getActaSustento()),
            vinculo.getNivelConfianza(),
            vinculo.getEstadoConfirmacion(),
            vinculo.getRequiereValidacionManual(),
            vinculo.getObservaciones()
        );
    }

    private ConyugeIntermedioResponseDto toConyugeIntermedioDto(ConyugeIntermedio conyuge) {
        if (conyuge == null) {
            return null;
        }
        
        return new ConyugeIntermedioResponseDto(
            conyuge.getIdCiudadano(),
            conyuge.getNombreCompleto()
        );
    }

    private ActaSustentoResponseDto toActaSustentoDto(ActaSustento acta) {
        if (acta == null) {
            return null;
        }
        
        return new ActaSustentoResponseDto(
            acta.getTipoActa(),
            acta.getNumeroActa(),
            acta.getFechaRegistro(),
            acta.getOficinaRegistral()
        );
    }

    private ResumenAnalisisResponseDto toResumenAnalisisDto(ResumenAnalisis resumen) {
        if (resumen == null) {
            return null;
        }
        
        return new ResumenAnalisisResponseDto(
            resumen.getVinculosGrado1(),
            resumen.getVinculosGrado2(),
            resumen.getVinculosGrado3(),
            resumen.getVinculosGrado4(),
            resumen.getVinculosAfinidad(),
            resumen.getActasConsultadas(),
            resumen.getActasNoDigitalizadas(),
            resumen.getInconsistenciasDetectadas()
        );
    }

    private List<InconsistenciaResponseDto> toInconsistenciasDto(List<Inconsistencia> inconsistencias) {
        if (inconsistencias == null) {
            return null;
        }
        
        return inconsistencias.stream()
            .map(this::toInconsistenciaDto)
            .collect(Collectors.toList());
    }

    private InconsistenciaResponseDto toInconsistenciaDto(Inconsistencia inconsistencia) {
        if (inconsistencia == null) {
            return null;
        }
        
        return new InconsistenciaResponseDto(
            inconsistencia.getTipo(),
            inconsistencia.getDescripcion(),
            inconsistencia.getCiudadanosInvolucrados(),
            inconsistencia.getSeveridad(),
            inconsistencia.getAccionRecomendada()
        );
    }

    private List<ActaPendienteDigitalizacionResponseDto> toActasPendientesDto(List<ActaPendienteDigitalizacion> actas) {
        if (actas == null) {
            return null;
        }
        
        return actas.stream()
            .map(this::toActaPendienteDto)
            .collect(Collectors.toList());
    }

    private ActaPendienteDigitalizacionResponseDto toActaPendienteDto(ActaPendienteDigitalizacion acta) {
        if (acta == null) {
            return null;
        }
        
        return new ActaPendienteDigitalizacionResponseDto(
            acta.getTipoActa(),
            acta.getReferenciaActa(),
            acta.getOficinaRegistral(),
            acta.getObservacion()
        );
    }

    private MetadataResponseDto toMetadataDto(Metadata metadata) {
        if (metadata == null) {
            return null;
        }
        
        return new MetadataResponseDto(
            metadata.getTimestamp(),
            metadata.getCorrelationId(),
            metadata.getVersion(),
            toServiciosConsultadosDto(metadata.getServiciosConsultados())
        );
    }

    private ServiciosConsultadosResponseDto toServiciosConsultadosDto(ServiciosConsultados servicios) {
        if (servicios == null) {
            return null;
        }
        
        return new ServiciosConsultadosResponseDto(
            servicios.getMsSagaAPD(),
            servicios.getMsDatosActas(),
            servicios.getMsDatosParentesco()
        );
    }
}
