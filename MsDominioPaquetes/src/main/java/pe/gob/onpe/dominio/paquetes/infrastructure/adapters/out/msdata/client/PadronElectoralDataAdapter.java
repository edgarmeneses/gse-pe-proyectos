package pe.gob.onpe.dominio.paquetes.infrastructure.adapters.out.msdata.client;

import pe.gob.onpe.dominio.paquetes.domain.model.PaqueteElectoral;
import pe.gob.onpe.dominio.paquetes.domain.ports.out.PadronElectoralDataPort;
import java.util.List;

public class PadronElectoralDataAdapter implements PadronElectoralDataPort {

    // Operaciones de Padrón Electoral
    @Override
    public Integer contarPaquetesPorPadron(String idPadron) {
        throw new UnsupportedOperationException("Implementacion pendiente: conectar con MsDatosElectoral para contar paquetes por padron");
    }

    @Override
    public Integer contarPaquetesAprobadosPorPadron(String idPadron) {
        throw new UnsupportedOperationException("Implementacion pendiente: conectar con MsDatosElectoral para contar paquetes aprobados por padron");
    }

    @Override
    public void actualizarEstadoRevision(String idPadron, String nuevoEstadoRevision) {
        throw new UnsupportedOperationException("Implementacion pendiente: conectar con MsDatosElectoral para actualizar estado de revision del padron");
    }

    @Override
    public String obtenerCronogramaElectoral(String idPadron) {
        throw new UnsupportedOperationException("Implementacion pendiente: conectar con MsDatosElectoral para obtener cronograma electoral");
    }

    // Operaciones de Paquetes Electorales
    @Override
    public List<PaqueteElectoral> consultarPaquetes(
            String idPadron,
            String tipoPadron,
            String codigoDepartamento,
            String codigoProvincia,
            String codigoDistrito,
            String estadoPaquete,
            Integer paginaActual,
            Integer registrosPorPagina) {
        throw new UnsupportedOperationException("Implementacion pendiente: conectar con MsDatosElectoral - PaqueteElectoralController.consultarPaquetes");
    }

    @Override
    public PaqueteElectoral consultarPaqueteElectoral(String paqueteId) {
        throw new UnsupportedOperationException("Implementacion pendiente: conectar con MsDatosElectoral - PaqueteElectoralController.obtenerPaquetePorId");
    }

    @Override
    public PaqueteElectoral actualizarPaqueteElectoral(String paqueteId, String nuevoEstado) {
        throw new UnsupportedOperationException("Implementacion pendiente: conectar con MsDatosElectoral - ActualizarPaqueteElectoralService.actualizarEstado");
    }

    @Override
    public void registrarTrazabilidad(String paqueteId, String accion, String usuario, String ipOrigen, String detalle) {
        throw new UnsupportedOperationException("Implementacion pendiente: conectar con sistema de trazabilidad");
    }
}
