package pe.gob.reniec.cotejo.masivo.infrastructure.adapters.in.rest.mapper;

import pe.gob.reniec.cotejo.masivo.domain.model.Ejecucion;
import pe.gob.reniec.cotejo.masivo.domain.model.RegistroEntrada;
import pe.gob.reniec.cotejo.masivo.domain.model.ResultadoCotejo;
import pe.gob.reniec.cotejo.masivo.infrastructure.adapters.in.rest.dto.*;
import java.util.List;
import java.util.stream.Collectors;

public class EjecucionDtoMapper {

    public static Ejecucion toDomain(CrearEjecucionRequestDto dto) {
        Ejecucion ejecucion = new Ejecucion();
        ejecucion.setSolicitudId(dto.solicitudId());
        ejecucion.setCodigoOrganizacion(dto.codigoOrganizacion());
        ejecucion.setNombreOrganizacion(dto.nombreOrganizacion());
        ejecucion.setCodigoEnvio(dto.codigoEnvio());
        ejecucion.setNumeroLote(dto.numeroLote());
        ejecucion.setTotalRegistrosEntrada(dto.totalRegistrosEntrada());
        ejecucion.setDocumentoSustento(dto.documentoSustento());
        ejecucion.setObservaciones(dto.observaciones());
        ejecucion.setIndicadorDomicilio(dto.indicadorDomicilio());
        ejecucion.setCodigoPrograma(dto.codigoPrograma());
        return ejecucion;
    }

    public static EjecucionResponseDto toResponseDto(Ejecucion ejecucion) {
        LinksDto links = new LinksDto(
            "/api/v1/ciudadano/MsDatosCotejoMasivo/ejecuciones/" + ejecucion.getEjecucionId(),
            "/api/v1/ciudadano/MsDatosCotejoMasivo/ejecuciones/" + ejecucion.getEjecucionId() + "/registros",
            "/api/v1/ciudadano/MsDatosCotejoMasivo/ejecuciones/" + ejecucion.getEjecucionId() + "/resultados",
            "/api/v1/ciudadano/MsDatosCotejoMasivo/ejecuciones/" + ejecucion.getEjecucionId() + "/estado",
            null
        );
        
        return new EjecucionResponseDto(
            ejecucion.getEjecucionId(),
            ejecucion.getSolicitudId(),
            ejecucion.getCodigoOrganizacion(),
            ejecucion.getNombreOrganizacion(),
            ejecucion.getCodigoEnvio(),
            ejecucion.getNumeroLote(),
            ejecucion.getCodigoEstado(),
            ejecucion.getDescripcionEstado(),
            ejecucion.getTotalRegistrosEntrada(),
            ejecucion.getFechaCreacion(),
            ejecucion.getUsuarioCreacion(),
            links
        );
    }

    public static EjecucionDetalleResponseDto toDetalleResponseDto(Ejecucion ejecucion) {
        LinksDto links = new LinksDto(
            "/api/v1/ciudadano/MsDatosCotejoMasivo/ejecuciones/" + ejecucion.getEjecucionId(),
            "/api/v1/ciudadano/MsDatosCotejoMasivo/ejecuciones/" + ejecucion.getEjecucionId() + "/registros",
            "/api/v1/ciudadano/MsDatosCotejoMasivo/ejecuciones/" + ejecucion.getEjecucionId() + "/resultados",
            "/api/v1/ciudadano/MsDatosCotejoMasivo/ejecuciones/" + ejecucion.getEjecucionId() + "/estado",
            "/api/v1/ciudadano/MsDatosCotejoMasivo/solicitudes/" + ejecucion.getSolicitudId()
        );

        ResumenResultadosDetalleDto resumen = null;
        if (ejecucion.getResumenResultados() != null) {
            resumen = new ResumenResultadosDetalleDto(
                ejecucion.getResumenResultados().getTotalCorrectos(),
                ejecucion.getResumenResultados().getTotalIncorrectos(),
                ejecucion.getResumenResultados().getTotalNoEncontrados(),
                ejecucion.getResumenResultados().getTotalFallecidos(),
                ejecucion.getResumenResultados().getTotalRestringidos(),
                ejecucion.getResumenResultados().getTotalCaducados(),
                ejecucion.getResumenResultados().getTotalErrores()
            );
        }
        
        return new EjecucionDetalleResponseDto(
            ejecucion.getEjecucionId(),
            ejecucion.getSolicitudId(),
            ejecucion.getCodigoOrganizacion(),
            ejecucion.getNombreOrganizacion(),
            ejecucion.getCodigoEnvio(),
            ejecucion.getNumeroLote(),
            ejecucion.getCodigoEstado(),
            ejecucion.getDescripcionEstado(),
            ejecucion.getTotalRegistrosEntrada(),
            ejecucion.getTotalRegistrosProcesados(),
            ejecucion.getTotalRegistrosCorrectos(),
            ejecucion.getTotalRegistrosIncorrectos(),
            ejecucion.getFechaInicioProceso(),
            ejecucion.getFechaFinProceso(),
            ejecucion.getDocumentoSustento(),
            ejecucion.getObservaciones(),
            ejecucion.getUrlReporteGenerado(),
            ejecucion.getIndicadorDomicilio(),
            ejecucion.getCodigoPrograma(),
            resumen,
            ejecucion.getFechaCreacion(),
            ejecucion.getUsuarioCreacion(),
            ejecucion.getFechaModificacion(),
            ejecucion.getUsuarioModificacion(),
            links
        );
    }

    public static EjecucionListItemDto toListItemDto(Ejecucion ejecucion) {
        return new EjecucionListItemDto(
            ejecucion.getEjecucionId(),
            ejecucion.getSolicitudId(),
            ejecucion.getCodigoOrganizacion(),
            ejecucion.getNombreOrganizacion(),
            ejecucion.getCodigoEnvio(),
            ejecucion.getNumeroLote(),
            ejecucion.getCodigoEstado(),
            ejecucion.getDescripcionEstado(),
            ejecucion.getTotalRegistrosEntrada(),
            ejecucion.getTotalRegistrosProcesados(),
            ejecucion.getTotalRegistrosCorrectos(),
            ejecucion.getTotalRegistrosIncorrectos(),
            ejecucion.getFechaInicioProceso(),
            ejecucion.getFechaFinProceso(),
            ejecucion.getFechaCreacion(),
            ejecucion.getUsuarioCreacion()
        );
    }

    public static List<EjecucionListItemDto> toListItemDtos(List<Ejecucion> ejecuciones) {
        return ejecuciones.stream()
            .map(EjecucionDtoMapper::toListItemDto)
            .collect(Collectors.toList());
    }

    public static RegistroEntrada toDomain(RegistroEntradaItemDto dto) {
        RegistroEntrada registro = new RegistroEntrada();
        registro.setNumeroSecuencia(dto.numeroSecuencia());
        registro.setNumeroDni(dto.numeroDni());
        registro.setApellidoPaterno(dto.apellidoPaterno());
        registro.setApellidoMaterno(dto.apellidoMaterno());
        registro.setNombres(dto.nombres());
        registro.setFechaNacimiento(dto.fechaNacimiento());
        registro.setIndicadorSexo(dto.indicadorSexo());
        registro.setIdentificadorInstitucion(dto.identificadorInstitucion());
        registro.setDatosAdicionales(dto.datosAdicionales() != null ? dto.datosAdicionales().toString() : null);
        return registro;
    }

    public static List<RegistroEntrada> toRegistroEntradaDomain(List<RegistroEntradaItemDto> dtos) {
        return dtos.stream()
            .map(EjecucionDtoMapper::toDomain)
            .collect(Collectors.toList());
    }

    public static ResultadoCotejo toDomain(ResultadoCotejoItemDto dto) {
        ResultadoCotejo resultado = new ResultadoCotejo();
        resultado.setRegistroEntradaId(dto.registroEntradaId());
        resultado.setCodigoResultado(dto.codigoResultado());
        resultado.setNumeroDniEncontrado(dto.numeroDniEncontrado());
        resultado.setApellidoPaternoEncontrado(dto.apellidoPaternoEncontrado());
        resultado.setApellidoMaternoEncontrado(dto.apellidoMaternoEncontrado());
        resultado.setNombresEncontrado(dto.nombresEncontrado());
        resultado.setFechaNacimientoEncontrada(dto.fechaNacimientoEncontrada());
        resultado.setIndicadorSexoEncontrado(dto.indicadorSexoEncontrado());
        resultado.setCodigoUbigeoDomicilio(dto.codigoUbigeoDomicilio());
        resultado.setDescripcionDomicilio(dto.descripcionDomicilio());
        resultado.setEstadoCivil(dto.estadoCivil());
        resultado.setCondicionCiudadano(dto.condicionCiudadano());
        resultado.setFechaCaducidadDni(dto.fechaCaducidadDni());
        resultado.setIndicadorRestriccion(dto.indicadorRestriccion());
        resultado.setFechaRestriccion(dto.fechaRestriccion());
        resultado.setCoincideDni(dto.coincideDni());
        resultado.setCoincideApellidoPaterno(dto.coincideApellidoPaterno());
        resultado.setCoincideApellidoMaterno(dto.coincideApellidoMaterno());
        resultado.setCoincideNombres(dto.coincideNombres());
        resultado.setCoincideFechaNacimiento(dto.coincideFechaNacimiento());
        resultado.setCoincideSexo(dto.coincideSexo());
        resultado.setMensajeObservacion(dto.mensajeObservacion());
        return resultado;
    }

    public static List<ResultadoCotejo> toResultadoCotejoDomain(List<ResultadoCotejoItemDto> dtos) {
        return dtos.stream()
            .map(EjecucionDtoMapper::toDomain)
            .collect(Collectors.toList());
    }
}
