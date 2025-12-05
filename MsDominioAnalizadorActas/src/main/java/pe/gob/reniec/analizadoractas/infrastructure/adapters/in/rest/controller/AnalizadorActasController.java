package pe.gob.reniec.analizadoractas.infrastructure.adapters.in.rest.controller;

import pe.gob.reniec.analizadoractas.domain.model.AnalisisActas;
import pe.gob.reniec.analizadoractas.domain.model.SolicitudAnalisis;
import pe.gob.reniec.analizadoractas.domain.model.UsuarioSolicitante;
import pe.gob.reniec.analizadoractas.domain.ports.in.AnalizarActasUseCase;
import pe.gob.reniec.analizadoractas.infrastructure.adapters.in.rest.dto.AnalisisRequestDto;
import pe.gob.reniec.analizadoractas.infrastructure.adapters.in.rest.dto.AnalisisResponseDto;
import pe.gob.reniec.analizadoractas.infrastructure.adapters.in.rest.mapper.AnalizadorActasDtoMapper;

/**
 * Controlador REST para el análisis de actas
 * IMPORTANTE: Sin anotaciones de frameworks (Java puro)
 * Path: POST /api/v1/actas/MsDominioAnalizadorActas/analizar
 */
public class AnalizadorActasController {

    private final AnalizarActasUseCase analizarActasUseCase;
    private final AnalizadorActasDtoMapper mapper;

    public AnalizadorActasController(AnalizarActasUseCase analizarActasUseCase,
                                     AnalizadorActasDtoMapper mapper) {
        this.analizarActasUseCase = analizarActasUseCase;
        this.mapper = mapper;
    }

    /**
     * Endpoint: Analizar Actas
     * Método: POST
     * Path: /api/v1/actas/MsDominioAnalizadorActas/analizar
     *
     * @param request DTO con criterios de análisis
     * @return AnalisisResponseDto con resultados del análisis
     */
    public AnalisisResponseDto analizar(AnalisisRequestDto request) {

        // 1. Mapear DTOs a objetos de dominio
        SolicitudAnalisis solicitudAnalisis = mapper.toSolicitudAnalisisDomain(
                request.getSolicitudAnalisis()
        );

        UsuarioSolicitante usuarioSolicitante = mapper.toUsuarioSolicitanteDomain(
                request.getUsuarioSolicitante()
        );

        // 2. Ejecutar caso de uso
        AnalisisActas analisisActas = analizarActasUseCase.analizar(
                solicitudAnalisis,
                usuarioSolicitante,
                request.getPrioridadAnalisis()
        );

        // 3. Mapear resultado a DTO de respuesta
        AnalisisResponseDto response = mapper.toAnalisisResponseDto(analisisActas);

        return response;
    }
}
