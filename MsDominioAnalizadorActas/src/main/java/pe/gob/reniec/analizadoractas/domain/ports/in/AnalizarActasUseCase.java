package pe.gob.reniec.analizadoractas.domain.ports.in;

import pe.gob.reniec.analizadoractas.domain.model.AnalisisActas;
import pe.gob.reniec.analizadoractas.domain.model.SolicitudAnalisis;
import pe.gob.reniec.analizadoractas.domain.model.UsuarioSolicitante;

/**
 * Puerto de entrada (Use Case): Define el contrato para el análisis de actas registrales
 */
public interface AnalizarActasUseCase {

    /**
     * Ejecuta el análisis automatizado de actas registrales mediante IA
     *
     * @param solicitudAnalisis Criterios de búsqueda y filtrado de actas
     * @param usuarioSolicitante Usuario que solicita el análisis
     * @param prioridadAnalisis Prioridad del análisis (ALTA, MEDIA, BAJA)
     * @return AnalisisActas con los resultados del análisis
     */
    AnalisisActas analizar(SolicitudAnalisis solicitudAnalisis,
                           UsuarioSolicitante usuarioSolicitante,
                           String prioridadAnalisis);
}
