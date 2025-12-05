package pe.gob.reniec.analisisbiometrico.infrastructure.adapters.in.rest.controller;

import pe.gob.reniec.analisisbiometrico.domain.model.Ciudadano;
import pe.gob.reniec.analisisbiometrico.domain.model.ResultadoAnalisis;
import pe.gob.reniec.analisisbiometrico.domain.ports.in.ValidarDatosBiometricosUseCase;
import pe.gob.reniec.analisisbiometrico.infrastructure.adapters.in.rest.dto.ValidarDatosBiometricosRequestDto;
import pe.gob.reniec.analisisbiometrico.infrastructure.adapters.in.rest.dto.ValidarDatosBiometricosResponseDto;
import pe.gob.reniec.analisisbiometrico.infrastructure.adapters.in.rest.mapper.AnalisisBiometricoDtoMapper;

import java.util.List;

/**
 * Controller REST para análisis biométrico
 * Path: /api/v1/tramite/MsDominioAnalisisBiometrico
 * Método: POST
 */
public class AnalisisBiometricoController {

    private final ValidarDatosBiometricosUseCase validarDatosBiometricosUseCase;
    private final AnalisisBiometricoDtoMapper mapper;

    public AnalisisBiometricoController(ValidarDatosBiometricosUseCase validarDatosBiometricosUseCase,
                                       AnalisisBiometricoDtoMapper mapper) {
        this.validarDatosBiometricosUseCase = validarDatosBiometricosUseCase;
        this.mapper = mapper;
    }

    /**
     * POST /api/v1/tramite/MsDominioAnalisisBiometrico
     * Valida datos biométricos de uno o varios ciudadanos
     *
     * @param request DTO con lista de ciudadanos a validar
     * @return DTO con resultados de análisis biométrico
     */
    public ValidarDatosBiometricosResponseDto validarDatosBiometricos(
            ValidarDatosBiometricosRequestDto request) {
        throw new UnsupportedOperationException("Implementación pendiente");
    }
}
