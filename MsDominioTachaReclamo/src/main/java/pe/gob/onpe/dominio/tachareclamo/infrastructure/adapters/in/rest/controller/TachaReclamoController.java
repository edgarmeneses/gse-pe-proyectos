package pe.gob.onpe.dominio.tachareclamo.infrastructure.adapters.in.rest.controller;

import pe.gob.onpe.dominio.tachareclamo.domain.model.Derivacion;
import pe.gob.onpe.dominio.tachareclamo.domain.model.TachaReclamo;
import pe.gob.onpe.dominio.tachareclamo.domain.model.ValidacionSustento;
import pe.gob.onpe.dominio.tachareclamo.domain.ports.in.DerivarTachaReclamoUseCase;
import pe.gob.onpe.dominio.tachareclamo.domain.ports.in.RegistrarTachaReclamoUseCase;
import pe.gob.onpe.dominio.tachareclamo.domain.ports.in.ValidarSustentoUseCase;
import pe.gob.onpe.dominio.tachareclamo.infrastructure.adapters.in.rest.dto.DerivarTachaReclamoRequestDto;
import pe.gob.onpe.dominio.tachareclamo.infrastructure.adapters.in.rest.dto.DerivarTachaReclamoResponseDto;
import pe.gob.onpe.dominio.tachareclamo.infrastructure.adapters.in.rest.dto.TachaReclamoRequestDto;
import pe.gob.onpe.dominio.tachareclamo.infrastructure.adapters.in.rest.dto.TachaReclamoResponseDto;
import pe.gob.onpe.dominio.tachareclamo.infrastructure.adapters.in.rest.dto.ValidarSustentoRequestDto;
import pe.gob.onpe.dominio.tachareclamo.infrastructure.adapters.in.rest.dto.ValidarSustentoResponseDto;
import pe.gob.onpe.dominio.tachareclamo.infrastructure.adapters.in.rest.mapper.DerivacionDtoMapper;
import pe.gob.onpe.dominio.tachareclamo.infrastructure.adapters.in.rest.mapper.TachaReclamoDtoMapper;
import pe.gob.onpe.dominio.tachareclamo.infrastructure.adapters.in.rest.mapper.ValidacionSustentoDtoMapper;

public class TachaReclamoController {
    private final RegistrarTachaReclamoUseCase registrarTachaReclamoUseCase;
    private final ValidarSustentoUseCase validarSustentoUseCase;
    private final DerivarTachaReclamoUseCase derivarTachaReclamoUseCase;

    public TachaReclamoController(RegistrarTachaReclamoUseCase registrarTachaReclamoUseCase,
                                  ValidarSustentoUseCase validarSustentoUseCase,
                                  DerivarTachaReclamoUseCase derivarTachaReclamoUseCase) {
        this.registrarTachaReclamoUseCase = registrarTachaReclamoUseCase;
        this.validarSustentoUseCase = validarSustentoUseCase;
        this.derivarTachaReclamoUseCase = derivarTachaReclamoUseCase;
    }

    /**
     * POST /tacha-reclamo
     * Registra una nueva tacha o reclamo
     */
    public TachaReclamoResponseDto registrar(TachaReclamoRequestDto requestDto) {
        try {
            TachaReclamo tachaReclamo = TachaReclamoDtoMapper.toDomain(requestDto);
            TachaReclamo tachaReclamoRegistrado = registrarTachaReclamoUseCase.registrar(tachaReclamo);
            return TachaReclamoDtoMapper.toResponseDto(tachaReclamoRegistrado, "201", "Tacha/Reclamo registrado exitosamente");
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Error al registrar tacha/reclamo", e);
        }
    }

    /**
     * POST /tacha-reclamo/validar-sustento
     * Valida el sustento de una tacha o reclamo
     */
    public ValidarSustentoResponseDto validarSustento(ValidarSustentoRequestDto requestDto) {
        try {
            ValidacionSustento validacion = validarSustentoUseCase.validar(
                requestDto.getTachaReclamoId(),
                requestDto.getSustento(),
                "Observaciones de la validación"
            );
            return ValidacionSustentoDtoMapper.toResponseDto(validacion, "200", "Sustento validado exitosamente");
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (IllegalStateException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Error al validar sustento", e);
        }
    }

    /**
     * PUT /tacha-reclamo/{id}/derivar
     * Deriva una tacha o reclamo a otra área
     */
    public DerivarTachaReclamoResponseDto derivar(Long id, DerivarTachaReclamoRequestDto requestDto) {
        try {
            Derivacion derivacion = derivarTachaReclamoUseCase.derivar(
                id,
                requestDto.getAreaDestino(),
                requestDto.getResponsable(),
                requestDto.getObservaciones()
            );
            
            // En un escenario real, obtendrías el tachaReclamo actualizado para los datos completos
            return DerivacionDtoMapper.toResponseDto(
                derivacion,
                id,
                "EXP-XXXXX", // Esto debería obtenerse del tachaReclamo actualizado
                "VALIDADO",  // Estado anterior
                "200",
                "Tacha/Reclamo derivado exitosamente"
            );
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (IllegalStateException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Error al derivar tacha/reclamo", e);
        }
    }
}
