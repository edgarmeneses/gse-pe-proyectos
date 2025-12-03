package pe.gob.reniec.msdatosciudadano.infrastructure.adapters.in.rest.controller;

import pe.gob.reniec.msdatosciudadano.domain.model.Ciudadano;
import pe.gob.reniec.msdatosciudadano.domain.model.ConsultaMasiva;
import pe.gob.reniec.msdatosciudadano.domain.ports.in.*;
import pe.gob.reniec.msdatosciudadano.infrastructure.adapters.in.rest.dto.*;
import pe.gob.reniec.msdatosciudadano.infrastructure.adapters.in.rest.mapper.CiudadanoDtoMapper;
import pe.gob.reniec.msdatosciudadano.infrastructure.adapters.in.rest.mapper.ConsultaMasivaDtoMapper;
import java.util.List;

public class CiudadanoController {
    private final CrearCiudadanoUseCase crearCiudadanoUseCase;
    private final ActualizarCiudadanoUseCase actualizarCiudadanoUseCase;
    private final ConsultarCiudadanoUseCase consultarCiudadanoUseCase;
    private final ListarCiudadanosUseCase listarCiudadanosUseCase;
    private final ConsultarInformePericialUseCase consultarInformePericialUseCase;
    private final ConsultaMasivaUseCase consultaMasivaUseCase;

    public CiudadanoController(CrearCiudadanoUseCase crearCiudadanoUseCase,
                              ActualizarCiudadanoUseCase actualizarCiudadanoUseCase,
                              ConsultarCiudadanoUseCase consultarCiudadanoUseCase,
                              ListarCiudadanosUseCase listarCiudadanosUseCase,
                              ConsultarInformePericialUseCase consultarInformePericialUseCase,
                              ConsultaMasivaUseCase consultaMasivaUseCase) {
        this.crearCiudadanoUseCase = crearCiudadanoUseCase;
        this.actualizarCiudadanoUseCase = actualizarCiudadanoUseCase;
        this.consultarCiudadanoUseCase = consultarCiudadanoUseCase;
        this.listarCiudadanosUseCase = listarCiudadanosUseCase;
        this.consultarInformePericialUseCase = consultarInformePericialUseCase;
        this.consultaMasivaUseCase = consultaMasivaUseCase;
    }

    public CiudadanoResponseDto crear(CrearCiudadanoRequestDto request) {
        Ciudadano ciudadano = CiudadanoDtoMapper.toDomain(request);
        String id = crearCiudadanoUseCase.crear(ciudadano);
        return CiudadanoDtoMapper.toResponseDto(id, ciudadano);
    }

    public Object actualizar(String id, CrearCiudadanoRequestDto request) {
        Ciudadano ciudadano = CiudadanoDtoMapper.toDomain(request);
        List<String> datosActualizados = actualizarCiudadanoUseCase.actualizar(id, ciudadano);
        throw new UnsupportedOperationException("Implementación pendiente");
    }

    public Ciudadano obtenerPorDocumento(String tipoDocumento, String numeroDocumento) {
        return consultarCiudadanoUseCase.consultar(tipoDocumento, numeroDocumento);
    }

    public List<Ciudadano> listar(Integer page, Integer size, String queryParam1, 
                                  String queryParam2, String queryParam3, List<String> fields) {
        return listarCiudadanosUseCase.listar(page, size, queryParam1, queryParam2, queryParam3, fields);
    }

    public Object consultarInformesPericial(String tipoDocumento, String numeroDocumento) {
        return consultarInformePericialUseCase.consultar(tipoDocumento, numeroDocumento);
    }

    public ConsultaMasiva consultaMasiva(ConsultaMasivaRequestDto request) {
        ConsultaMasiva consulta = ConsultaMasivaDtoMapper.toDomain(request);
        return consultaMasivaUseCase.procesar(consulta);
    }
}
