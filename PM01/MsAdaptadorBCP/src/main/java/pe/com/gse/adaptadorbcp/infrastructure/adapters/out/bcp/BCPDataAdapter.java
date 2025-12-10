package pe.com.gse.adaptadorbcp.infrastructure.adapters.out.bcp;

import pe.com.gse.adaptadorbcp.domain.model.RespuestaBCP;
import pe.com.gse.adaptadorbcp.domain.model.SolicitudBCP;
import pe.com.gse.adaptadorbcp.domain.ports.out.BCPDataPort;

/**
 * Adaptador de salida: BCPDataAdapter
 * Implementa la comunicación con servicios externos del BCP
 * 
 * Tipo: MsDominio - DataAdapter para integración
 * Sin anotaciones de frameworks - Java puro
 */
public class BCPDataAdapter implements BCPDataPort {
    
    @Override
    public RespuestaBCP enviarSolicitud(SolicitudBCP solicitud) {
        // Implementación stub - Conexión con BCP pendiente
        // Aquí iría la lógica para:
        // 1. Transformar la solicitud al formato esperado por BCP
        // 2. Realizar la llamada HTTP/REST al servicio BCP
        // 3. Procesar la respuesta
        // 4. Transformar la respuesta al modelo de dominio
        throw new UnsupportedOperationException("Implementación pendiente - Conexión con BCP");
    }
}
