package pe.gob.reniec.circunscripciones.infrastructure.adapters.in.rest.controller;

import pe.gob.reniec.circunscripciones.domain.model.AnalisisCircunscripcion;
import pe.gob.reniec.circunscripciones.domain.model.InformeFinal;
import pe.gob.reniec.circunscripciones.domain.model.ListadoVisitas;
import pe.gob.reniec.circunscripciones.domain.model.MigracionDomiciliaria;
import pe.gob.reniec.circunscripciones.domain.ports.in.AnalisisCircunscripcionesUseCase;
import pe.gob.reniec.circunscripciones.domain.ports.in.ConsultarMigracionesDomiciliariasUseCase;
import pe.gob.reniec.circunscripciones.domain.ports.in.GenerarInformeFinalUseCase;
import pe.gob.reniec.circunscripciones.domain.ports.in.GenerarListadosVisitasUseCase;
import pe.gob.reniec.circunscripciones.infrastructure.adapters.in.rest.dto.AnalisisCircunscripcionRequestDto;
import pe.gob.reniec.circunscripciones.infrastructure.adapters.in.rest.dto.AnalisisCircunscripcionResponseDto;
import pe.gob.reniec.circunscripciones.infrastructure.adapters.in.rest.dto.InformeFinalRequestDto;
import pe.gob.reniec.circunscripciones.infrastructure.adapters.in.rest.dto.InformeFinalResponseDto;
import pe.gob.reniec.circunscripciones.infrastructure.adapters.in.rest.dto.ListadoVisitasRequestDto;
import pe.gob.reniec.circunscripciones.infrastructure.adapters.in.rest.dto.ListadoVisitasResponseDto;
import pe.gob.reniec.circunscripciones.infrastructure.adapters.in.rest.dto.MigracionesResponseDto;
import pe.gob.reniec.circunscripciones.infrastructure.adapters.in.rest.mapper.AnalisisCircunscripcionDtoMapper;
import pe.gob.reniec.circunscripciones.infrastructure.adapters.in.rest.mapper.InformeFinalDtoMapper;
import pe.gob.reniec.circunscripciones.infrastructure.adapters.in.rest.mapper.ListadoVisitasDtoMapper;
import pe.gob.reniec.circunscripciones.infrastructure.adapters.in.rest.mapper.MigracionDtoMapper;
import java.util.List;

public class CircunscripcionesController {

    private final AnalisisCircunscripcionesUseCase analisisCircunscripcionesUseCase;
    private final ConsultarMigracionesDomiciliariasUseCase consultarMigracionesDomiciliariasUseCase;
    private final GenerarInformeFinalUseCase generarInformeFinalUseCase;
    private final GenerarListadosVisitasUseCase generarListadosVisitasUseCase;
    private final AnalisisCircunscripcionDtoMapper analisisMapper;
    private final MigracionDtoMapper migracionMapper;
    private final InformeFinalDtoMapper informeMapper;
    private final ListadoVisitasDtoMapper listadoMapper;

    public CircunscripcionesController(
            AnalisisCircunscripcionesUseCase analisisCircunscripcionesUseCase,
            ConsultarMigracionesDomiciliariasUseCase consultarMigracionesDomiciliariasUseCase,
            GenerarInformeFinalUseCase generarInformeFinalUseCase,
            GenerarListadosVisitasUseCase generarListadosVisitasUseCase,
            AnalisisCircunscripcionDtoMapper analisisMapper,
            MigracionDtoMapper migracionMapper,
            InformeFinalDtoMapper informeMapper,
            ListadoVisitasDtoMapper listadoMapper) {
        this.analisisCircunscripcionesUseCase = analisisCircunscripcionesUseCase;
        this.consultarMigracionesDomiciliariasUseCase = consultarMigracionesDomiciliariasUseCase;
        this.generarInformeFinalUseCase = generarInformeFinalUseCase;
        this.generarListadosVisitasUseCase = generarListadosVisitasUseCase;
        this.analisisMapper = analisisMapper;
        this.migracionMapper = migracionMapper;
        this.informeMapper = informeMapper;
        this.listadoMapper = listadoMapper;
    }

    public AnalisisCircunscripcionResponseDto ejecutarAnalisis(AnalisisCircunscripcionRequestDto request) {
        throw new UnsupportedOperationException("Implementación pendiente");
    }

    public MigracionesResponseDto consultarMigraciones(String dni, String ubigeoOrigen,
                                                       String ubigeoDestino, String fechaDesde,
                                                       String fechaHasta, String tipoMovimiento,
                                                       Boolean incluirVerificados, Integer page,
                                                       Integer pageSize) {
        throw new UnsupportedOperationException("Implementación pendiente");
    }

    public InformeFinalResponseDto generarInformeFinal(InformeFinalRequestDto request) {
        throw new UnsupportedOperationException("Implementación pendiente");
    }

    public ListadoVisitasResponseDto generarListadosVisitas(ListadoVisitasRequestDto request) {
        throw new UnsupportedOperationException("Implementación pendiente");
    }
}
