package pe.gob.reniec.gse.agendamiento.data.infrastructure.adapters.in.rest.controller;

import pe.gob.reniec.gse.agendamiento.data.domain.model.Disponibilidad;
import pe.gob.reniec.gse.agendamiento.data.domain.model.ResumenDisponibilidad;
import pe.gob.reniec.gse.agendamiento.data.domain.ports.in.ActualizarDisponibilidadUseCase;
import pe.gob.reniec.gse.agendamiento.data.domain.ports.in.ConfigurarDisponibilidadUseCase;
import pe.gob.reniec.gse.agendamiento.data.domain.ports.in.ConsultarDisponibilidadUseCase;
import pe.gob.reniec.gse.agendamiento.data.infrastructure.adapters.in.rest.dto.ApiResponseDto;
import java.time.LocalDate;
import java.util.List;

public class DisponibilidadController {
    
    private final ConsultarDisponibilidadUseCase consultarDisponibilidadUseCase;
    private final ConfigurarDisponibilidadUseCase configurarDisponibilidadUseCase;
    private final ActualizarDisponibilidadUseCase actualizarDisponibilidadUseCase;
    
    public DisponibilidadController(ConsultarDisponibilidadUseCase consultarDisponibilidadUseCase,
                                   ConfigurarDisponibilidadUseCase configurarDisponibilidadUseCase,
                                   ActualizarDisponibilidadUseCase actualizarDisponibilidadUseCase) {
        this.consultarDisponibilidadUseCase = consultarDisponibilidadUseCase;
        this.configurarDisponibilidadUseCase = configurarDisponibilidadUseCase;
        this.actualizarDisponibilidadUseCase = actualizarDisponibilidadUseCase;
    }
    
    public ApiResponseDto<List<Disponibilidad>> consultar(String codigoSede, LocalDate fechaDesde,
                                                          LocalDate fechaHasta, Boolean soloDisponibles,
                                                          String correlationId) {
        List<Disponibilidad> disponibilidades = consultarDisponibilidadUseCase.consultar(codigoSede, fechaDesde,
                                                                                         fechaHasta, soloDisponibles);
        ResumenDisponibilidad resumen = consultarDisponibilidadUseCase.obtenerResumen(codigoSede, fechaDesde, fechaHasta);
        
        throw new UnsupportedOperationException("Consultar disponibilidad no implementado");
    }
    
    public ApiResponseDto<Void> configurar(Object request, String correlationId) {
        throw new UnsupportedOperationException("Configurar disponibilidad no implementado");
    }
    
    public ApiResponseDto<Disponibilidad> actualizar(String disponibilidadId, Object request, String correlationId) {
        throw new UnsupportedOperationException("Actualizar disponibilidad no implementado");
    }
}
