package pe.gob.reniec.configuracion.infrastructure.adapters.in.rest.controller;

import pe.gob.reniec.configuracion.domain.model.Configuracion;
import pe.gob.reniec.configuracion.domain.model.ConfiguracionSincronizacion;
import pe.gob.reniec.configuracion.domain.model.ResultadoSincronizacion;
import pe.gob.reniec.configuracion.domain.model.ResultadoValidacion;
import pe.gob.reniec.configuracion.domain.ports.in.ActualizarConfiguracionUseCase;
import pe.gob.reniec.configuracion.domain.ports.in.ConsultarConfiguracionUseCase;
import pe.gob.reniec.configuracion.domain.ports.in.ConsultarConfiguracionesPorCategoriaUseCase;
import pe.gob.reniec.configuracion.domain.ports.in.SincronizarConfiguracionesUseCase;
import pe.gob.reniec.configuracion.domain.ports.in.ValidarConfiguracionUseCase;
import pe.gob.reniec.configuracion.infrastructure.adapters.in.rest.dto.*;
import pe.gob.reniec.configuracion.infrastructure.adapters.in.rest.mapper.ConfiguracionDtoMapper;

import java.util.List;

/**
 * Controlador REST - Configuraciones
 * IMPORTANTE: Sin anotaciones de frameworks (Java puro)
 * Base path: /api/v1/configuracion/MsDatosConfiguracion
 */
public class ConfiguracionController {

    private final ConsultarConfiguracionUseCase consultarConfiguracionUseCase;
    private final ActualizarConfiguracionUseCase actualizarConfiguracionUseCase;
    private final SincronizarConfiguracionesUseCase sincronizarConfiguracionesUseCase;
    private final ConsultarConfiguracionesPorCategoriaUseCase consultarPorCategoriaUseCase;
    private final ValidarConfiguracionUseCase validarConfiguracionUseCase;
    private final ConfiguracionDtoMapper mapper;

    public ConfiguracionController(
            ConsultarConfiguracionUseCase consultarConfiguracionUseCase,
            ActualizarConfiguracionUseCase actualizarConfiguracionUseCase,
            SincronizarConfiguracionesUseCase sincronizarConfiguracionesUseCase,
            ConsultarConfiguracionesPorCategoriaUseCase consultarPorCategoriaUseCase,
            ValidarConfiguracionUseCase validarConfiguracionUseCase,
            ConfiguracionDtoMapper mapper
    ) {
        this.consultarConfiguracionUseCase = consultarConfiguracionUseCase;
        this.actualizarConfiguracionUseCase = actualizarConfiguracionUseCase;
        this.sincronizarConfiguracionesUseCase = sincronizarConfiguracionesUseCase;
        this.consultarPorCategoriaUseCase = consultarPorCategoriaUseCase;
        this.validarConfiguracionUseCase = validarConfiguracionUseCase;
        this.mapper = mapper;
    }

    /**
     * GET /api/v1/configuracion/MsDatosConfiguracion
     * Consultar configuración por clave
     *
     * @param clave Clave de la configuración
     * @param contexto Filtro adicional de contexto
     * @param ambiente Nombre del ambiente
     * @param version Versión específica
     * @param incluirMetadata Incluir metadata en la respuesta
     * @return ConfiguracionResponseDto
     */
    public ConfiguracionResponseDto consultarPorClave(
            String clave,
            String contexto,
            String ambiente,
            Integer version,
            Boolean incluirMetadata
    ) {
        Configuracion configuracion = consultarConfiguracionUseCase.consultarPorClave(
                clave, contexto, ambiente, version, incluirMetadata
        );
        return mapper.toConfiguracionResponseDto(configuracion);
    }

    /**
     * PUT /api/v1/configuracion/MsDatosConfiguracion/{clave}
     * Actualizar configuración
     *
     * @param clave Clave de la configuración a actualizar
     * @param request Datos de actualización
     * @return ActualizarConfiguracionResponseDto
     */
    public ActualizarConfiguracionResponseDto actualizar(
            String clave,
            ActualizarConfiguracionRequestDto request
    ) {
        List<Configuracion> configuraciones = actualizarConfiguracionUseCase.actualizar(
                clave,
                request.getValor(),
                request.getMotivoCambio(),
                request.getAplicarInmediatamente(),
                request.getNotificarServicios(),
                request.getRequiereAprobacion()
        );
        return mapper.toActualizarConfiguracionResponseDto(configuraciones);
    }

    /**
     * POST /api/v1/configuracion/MsDatosConfiguracion/sincronizar
     * Sincronizar configuraciones (Modo Offline/Online)
     *
     * @param request Datos de sincronización
     * @return SincronizarConfiguracionesResponseDto
     */
    public SincronizarConfiguracionesResponseDto sincronizar(
            SincronizarConfiguracionesRequestDto request
    ) {
        ConfiguracionSincronizacion sincronizacion = mapper.toConfiguracionSincronizacion(request);
        ResultadoSincronizacion resultado = sincronizarConfiguracionesUseCase.sincronizar(sincronizacion);
        return mapper.toSincronizarConfiguracionesResponseDto(resultado);
    }

    /**
     * GET /api/v1/configuracion/MsDatosConfiguracion/categoria
     * Consultar configuraciones por categoría
     *
     * @param categoria Categoría de configuración
     * @param subcategoria Subcategoría (opcional)
     * @param soloActivas Solo activas
     * @param incluirHistorial Incluir historial
     * @param page Número de página
     * @param size Tamaño de página
     * @return ConsultarCategoriaResponseDto
     */
    public ConsultarCategoriaResponseDto consultarPorCategoria(
            String categoria,
            String subcategoria,
            Boolean soloActivas,
            Boolean incluirHistorial,
            Integer page,
            Integer size
    ) {
        List<Configuracion> configuraciones = consultarPorCategoriaUseCase.consultarPorCategoria(
                categoria, subcategoria, soloActivas, incluirHistorial, page, size
        );
        return mapper.toConsultarCategoriaResponseDto(configuraciones, categoria, page, size);
    }

    /**
     * POST /api/v1/configuracion/MsDatosConfiguracion/validar
     * Validar configuración
     *
     * @param request Datos de validación
     * @return ValidarConfiguracionResponseDto
     */
    public ValidarConfiguracionResponseDto validar(
            ValidarConfiguracionRequestDto request
    ) {
        Configuracion.Contexto contexto = mapper.toContexto(request.getContexto());
        ResultadoValidacion resultado = validarConfiguracionUseCase.validar(
                request.getClave(),
                request.getValor(),
                contexto,
                request.getValidarDependencias()
        );
        return mapper.toValidarConfiguracionResponseDto(resultado);
    }
}
