package pe.gob.reniec.coreografia.cotejomasivo.application.service;

import pe.gob.reniec.coreografia.cotejomasivo.domain.model.*;
import pe.gob.reniec.coreografia.cotejomasivo.domain.ports.in.IniciarCotejoMasivoUseCase;
import pe.gob.reniec.coreografia.cotejomasivo.domain.ports.out.CotejoMasivoDataPort;

import java.util.List;

/**
 * Servicio de aplicación - Implementa el caso de uso de iniciar cotejo masivo
 */
public class IniciarCotejoMasivoService implements IniciarCotejoMasivoUseCase {
    
    private final CotejoMasivoDataPort cotejoMasivoDataPort;
    
    public IniciarCotejoMasivoService(CotejoMasivoDataPort cotejoMasivoDataPort) {
        this.cotejoMasivoDataPort = cotejoMasivoDataPort;
    }
    
    @Override
    public ResultadoRegistroSolicitud iniciarCotejo(
        SolicitudCotejoMasivo solicitud,
        String correlationId,
        String officeCode,
        String userRole,
        String requestSource,
        String idempotencyKey
    ) {
        // Validar que la entidad solicitante existe
        if (!cotejoMasivoDataPort.validarEntidadSolicitante(solicitud.getEntidadSolicitante().getCodigo())) {
            throw new RuntimeException("Entidad solicitante no encontrada");
        }
        
        // Validar que no existe solicitud con el mismo número
        if (cotejoMasivoDataPort.existeSolicitud(solicitud.getNumeroSolicitud())) {
            throw new RuntimeException("Ya existe una solicitud con el mismo número");
        }
        
        // Validar idempotencia
        if (cotejoMasivoDataPort.existeSolicitudPorIdempotencyKey(idempotencyKey)) {
            throw new RuntimeException("Ya existe una solicitud con la misma clave de idempotencia");
        }
        
        // Registrar la solicitud usando el método de negocio del Aggregate Root
        solicitud.registrar(userRole, officeCode, idempotencyKey);
        
        // Persistir la solicitud
        cotejoMasivoDataPort.registrarSolicitud(solicitud, officeCode, userRole, idempotencyKey);
        
        // Publicar eventos de inicio de cotejo
        List<EventoGenerado> eventosGenerados = cotejoMasivoDataPort.publicarEventoInicioCotejo(solicitud, correlationId);
        
        // Calcular tiempo estimado de procesamiento basado en prioridad
        String tiempoEstimado = cotejoMasivoDataPort.calcularTiempoEstimado(
            solicitud.getRegistrosCotejo().size(),
            solicitud.getPrioridad()
        );
        
        // Construir y retornar el resultado del dominio
        return new ResultadoRegistroSolicitud(
            solicitud,
            eventosGenerados,
            tiempoEstimado
        );
    }
}
