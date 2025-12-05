package pe.gse.adaptadorbcp.infrastructure.adapters.in.rest.controller;

import pe.gse.adaptadorbcp.domain.model.EntidadPlaceholder;
import pe.gse.adaptadorbcp.domain.ports.in.*;
import pe.gse.adaptadorbcp.infrastructure.adapters.in.rest.dto.EntidadRequestDto;
import pe.gse.adaptadorbcp.infrastructure.adapters.in.rest.dto.EntidadResponseDto;
import pe.gse.adaptadorbcp.infrastructure.adapters.in.rest.mapper.EntidadDtoMapper;

public class EntidadController {

    private final CrearEntidadUseCase crearUseCase;
    private final ConsultarEntidadUseCase consultarUseCase;
    private final ListarEntidadesUseCase listarUseCase;
    private final ActualizarEntidadUseCase actualizarUseCase;
    private final EliminarEntidadUseCase eliminarUseCase;
    private final EntidadDtoMapper mapper;

    public EntidadController(CrearEntidadUseCase crearUseCase,
                             ConsultarEntidadUseCase consultarUseCase,
                             ListarEntidadesUseCase listarUseCase,
                             ActualizarEntidadUseCase actualizarUseCase,
                             EliminarEntidadUseCase eliminarUseCase,
                             EntidadDtoMapper mapper) {
        this.crearUseCase = crearUseCase;
        this.consultarUseCase = consultarUseCase;
        this.listarUseCase = listarUseCase;
        this.actualizarUseCase = actualizarUseCase;
        this.eliminarUseCase = eliminarUseCase;
        this.mapper = mapper;
    }

    public EntidadResponseDto crear(EntidadRequestDto request) {
        throw new UnsupportedOperationException("Implementación pendiente");
    }

    public EntidadResponseDto obtenerPorId(Long id) {
        throw new UnsupportedOperationException("Implementación pendiente");
    }

    public EntidadResponseDto[] listar() {
        throw new UnsupportedOperationException("Implementación pendiente");
    }

    public EntidadResponseDto actualizar(Long id, EntidadRequestDto request) {
        throw new UnsupportedOperationException("Implementación pendiente");
    }

    public boolean eliminar(Long id) {
        throw new UnsupportedOperationException("Implementación pendiente");
    }
}
