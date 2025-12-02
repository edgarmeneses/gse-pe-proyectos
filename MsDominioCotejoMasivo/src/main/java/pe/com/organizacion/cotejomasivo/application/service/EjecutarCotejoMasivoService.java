package pe.com.organizacion.cotejomasivo.application.service;

import pe.com.organizacion.cotejomasivo.domain.model.CotejoMasivo;
import pe.com.organizacion.cotejomasivo.domain.model.CriterioCotejo;
import pe.com.organizacion.cotejomasivo.domain.ports.in.EjecutarCotejoMasivoUseCase;
import pe.com.organizacion.cotejomasivo.domain.ports.out.CotejoMasivoDataPort;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * Servicio de aplicación: EjecutarCotejoMasivoService
 * Implementa el caso de uso para ejecutar un cotejo masivo
 */
public class EjecutarCotejoMasivoService implements EjecutarCotejoMasivoUseCase {
    
    private final CotejoMasivoDataPort cotejoMasivoDataPort;
    
    public EjecutarCotejoMasivoService(CotejoMasivoDataPort cotejoMasivoDataPort) {
        this.cotejoMasivoDataPort = cotejoMasivoDataPort;
    }
    
    @Override
    public CotejoMasivo ejecutar(List<CriterioCotejo> criteriosCotejo, String usuarioSolicitante) {
        // Crear nueva instancia de CotejoMasivo
        CotejoMasivo cotejoMasivo = new CotejoMasivo();
        cotejoMasivo.setIdEjecucion(UUID.randomUUID().toString());
        cotejoMasivo.setFechaSolicitud(LocalDateTime.now());
        cotejoMasivo.setEstado("PENDIENTE");
        cotejoMasivo.setCriteriosCotejo(criteriosCotejo);
        cotejoMasivo.setUsuarioSolicitante(usuarioSolicitante);
        cotejoMasivo.setTotalRegistros(0L);
        cotejoMasivo.setRegistrosProcesados(0L);
        cotejoMasivo.setRegistrosExitosos(0L);
        cotejoMasivo.setRegistrosConError(0L);
        
        // Delegar la creación al puerto de salida (MsDataCotejoMasivo)
        return cotejoMasivoDataPort.crear(cotejoMasivo);
    }
}
