package pe.gob.onpe.dominio.tachareclamo.infrastructure.adapters.in.rest.controller;

import pe.gob.onpe.dominio.tachareclamo.domain.model.Ciudadano;
import pe.gob.onpe.dominio.tachareclamo.domain.ports.in.RegistrarCiudadanoUseCase;
import pe.gob.onpe.dominio.tachareclamo.infrastructure.adapters.in.rest.dto.CiudadanoRequestDto;
import pe.gob.onpe.dominio.tachareclamo.infrastructure.adapters.in.rest.dto.CiudadanoResponseDto;
import pe.gob.onpe.dominio.tachareclamo.infrastructure.adapters.in.rest.mapper.CiudadanoDtoMapper;

public class CiudadanoController {
    private final RegistrarCiudadanoUseCase registrarCiudadanoUseCase;

    public CiudadanoController(RegistrarCiudadanoUseCase registrarCiudadanoUseCase) {
        this.registrarCiudadanoUseCase = registrarCiudadanoUseCase;
    }

    /**
     * POST /ciudadanos
     * Registra un nuevo ciudadano
     */
    public CiudadanoResponseDto registrar(CiudadanoRequestDto requestDto) {
        try {
            Ciudadano ciudadano = CiudadanoDtoMapper.toDomain(requestDto);
            Ciudadano ciudadanoRegistrado = registrarCiudadanoUseCase.registrar(ciudadano);
            return CiudadanoDtoMapper.toResponseDto(ciudadanoRegistrado, "201", "Ciudadano registrado exitosamente");
        } catch (IllegalArgumentException e) {
            // En un escenario real, esto retornaría un ResponseEntity con status 400
            throw e;
        } catch (Exception e) {
            // En un escenario real, esto retornaría un ResponseEntity con status 500
            throw new RuntimeException("Error al registrar ciudadano", e);
        }
    }
}
