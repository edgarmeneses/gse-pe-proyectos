package pe.gob.onpe.dominio.paquetes.domain.ports.out;

import pe.gob.onpe.dominio.paquetes.domain.model.PaqueteElectoral;
import java.util.List;

public interface PadronElectoralDataPort {
    // Operaciones de Padrón Electoral
    Integer contarPaquetesPorPadron(String idPadron);
    
    Integer contarPaquetesAprobadosPorPadron(String idPadron);
    
    void actualizarEstadoRevision(String idPadron, String nuevoEstadoRevision);
    
    String obtenerCronogramaElectoral(String idPadron);
    
    // Operaciones de Paquetes Electorales
    List<PaqueteElectoral> consultarPaquetes(String idPadron, String tipoPadron, String codigoDepartamento,
                                             String codigoProvincia, String codigoDistrito, String estadoPaquete,
                                             Integer pagina, Integer registrosPorPagina);
    
    PaqueteElectoral consultarPaqueteElectoral(String paqueteId);
    
    PaqueteElectoral actualizarPaqueteElectoral(String paqueteId, String nuevoEstado);
    
    void registrarTrazabilidad(String paqueteId, String accion, String usuario, String ipOrigen, String detalle);
}
