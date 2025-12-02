package pe.gob.reniec.msdatosregistradores.infrastructure.adapters.in.rest.controller;

import pe.gob.reniec.msdatosregistradores.domain.ports.in.CrearRegistradorUseCase;
import pe.gob.reniec.msdatosregistradores.domain.ports.in.ConsultarRegistradorUseCase;
import pe.gob.reniec.msdatosregistradores.domain.ports.in.ListarRegistradoresUseCase;
import pe.gob.reniec.msdatosregistradores.infrastructure.adapters.in.rest.dto.*;
import pe.gob.reniec.msdatosregistradores.infrastructure.adapters.in.rest.mapper.RegistradorDtoMapper;

public class RegistradorController {
    private final CrearRegistradorUseCase crearRegistradorUseCase;
    private final ConsultarRegistradorUseCase consultarRegistradorUseCase;
    private final ListarRegistradoresUseCase listarRegistradoresUseCase;
    private final RegistradorDtoMapper mapper;

    public RegistradorController(CrearRegistradorUseCase crearRegistradorUseCase,
                                ConsultarRegistradorUseCase consultarRegistradorUseCase,
                                ListarRegistradoresUseCase listarRegistradoresUseCase,
                                RegistradorDtoMapper mapper) {
        this.crearRegistradorUseCase = crearRegistradorUseCase;
        this.consultarRegistradorUseCase = consultarRegistradorUseCase;
        this.listarRegistradoresUseCase = listarRegistradoresUseCase;
        this.mapper = mapper;
    }

    public RegistradorResponseDto crear(RegistradorRequestDto request) {
        throw new UnsupportedOperationException("Método no implementado");
    }

    public ListarRegistradoresResponseDto listar(String codigoLocal, String estado, 
                                                String numeroDni, String nombreRegistrador, 
                                                Long pagina, Long registrosPorPagina) {
        throw new UnsupportedOperationException("Método no implementado");
    }

    public RegistradorDetalleResponseDto obtenerPorId(String idRegistrador) {
        throw new UnsupportedOperationException("Método no implementado");
    }
}
