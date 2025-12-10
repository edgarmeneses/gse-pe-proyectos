package pe.gob.reniec.pago.MsAdaptadorPagos.infrastructure.adapters.in.rest.controller;

import pe.gob.reniec.pago.MsAdaptadorPagos.domain.model.AdaptadorBancario;
import pe.gob.reniec.pago.MsAdaptadorPagos.domain.model.ValidacionPago;
import pe.gob.reniec.pago.MsAdaptadorPagos.domain.ports.in.ConsultarEstadoAdaptadoresUseCase;
import pe.gob.reniec.pago.MsAdaptadorPagos.domain.ports.in.RoutearValidacionPagoUseCase;
import pe.gob.reniec.pago.MsAdaptadorPagos.infrastructure.adapters.in.rest.dto.EstadoAdaptadoresResponseDto;
import pe.gob.reniec.pago.MsAdaptadorPagos.infrastructure.adapters.in.rest.dto.ValidacionPagoRequestDto;
import pe.gob.reniec.pago.MsAdaptadorPagos.infrastructure.adapters.in.rest.dto.ValidacionPagoResponseDto;
import pe.gob.reniec.pago.MsAdaptadorPagos.infrastructure.adapters.in.rest.mapper.EstadoAdaptadoresDtoMapper;
import pe.gob.reniec.pago.MsAdaptadorPagos.infrastructure.adapters.in.rest.mapper.ValidacionPagoDtoMapper;
import java.util.List;

public class MsAdaptadorPagosController {

    private final RoutearValidacionPagoUseCase routearValidacionPagoUseCase;
    private final ConsultarEstadoAdaptadoresUseCase consultarEstadoAdaptadoresUseCase;
    private final ValidacionPagoDtoMapper validacionPagoDtoMapper;
    private final EstadoAdaptadoresDtoMapper estadoAdaptadoresDtoMapper;

    public MsAdaptadorPagosController(RoutearValidacionPagoUseCase routearValidacionPagoUseCase,
                                      ConsultarEstadoAdaptadoresUseCase consultarEstadoAdaptadoresUseCase,
                                      ValidacionPagoDtoMapper validacionPagoDtoMapper,
                                      EstadoAdaptadoresDtoMapper estadoAdaptadoresDtoMapper) {
        this.routearValidacionPagoUseCase = routearValidacionPagoUseCase;
        this.consultarEstadoAdaptadoresUseCase = consultarEstadoAdaptadoresUseCase;
        this.validacionPagoDtoMapper = validacionPagoDtoMapper;
        this.estadoAdaptadoresDtoMapper = estadoAdaptadoresDtoMapper;
    }

    // POST /api/v1/pago/MsAdaptadorPagos/validar-pago
    public ValidacionPagoResponseDto routearValidacionPago(ValidacionPagoRequestDto request) {
        ValidacionPago solicitud = validacionPagoDtoMapper.toDomain(request);
        ValidacionPago resultado = routearValidacionPagoUseCase.routear(solicitud);
        return validacionPagoDtoMapper.toDto(resultado);
    }

    // GET /api/v1/pago/MsAdaptadorPagos/estado-adaptadores
    public EstadoAdaptadoresResponseDto consultarEstadoAdaptadores() {
        List<AdaptadorBancario> estado = consultarEstadoAdaptadoresUseCase.consultar();
        return estadoAdaptadoresDtoMapper.toDto(estado);
    }
}
