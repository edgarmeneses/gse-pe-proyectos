package pe.gob.reniec.analizadoractas.application.service;

import pe.gob.reniec.analizadoractas.domain.model.AnalisisActas;
import pe.gob.reniec.analizadoractas.domain.model.SolicitudAnalisis;
import pe.gob.reniec.analizadoractas.domain.model.UsuarioSolicitante;
import pe.gob.reniec.analizadoractas.domain.ports.in.AnalizarActasUseCase;
import pe.gob.reniec.analizadoractas.domain.ports.out.AnalizadorActasDataPort;

/**
 * Servicio de aplicación que implementa el caso de uso de análisis de actas
 */
public class AnalizarActasService implements AnalizarActasUseCase {

    private final AnalizadorActasDataPort analizadorActasDataPort;

    public AnalizarActasService(AnalizadorActasDataPort analizadorActasDataPort) {
        this.analizadorActasDataPort = analizadorActasDataPort;
    }

    @Override
    public AnalisisActas analizar(SolicitudAnalisis solicitudAnalisis,
                                   UsuarioSolicitante usuarioSolicitante,
                                   String prioridadAnalisis) {

        // 1. Obtener actas desde MsDataActas según criterios de búsqueda
        Object actasParaAnalizar = analizadorActasDataPort.obtenerActasParaAnalisis(solicitudAnalisis);

        // 2. Ejecutar análisis mediante componente de IA
        AnalisisActas analisisActas = analizadorActasDataPort.ejecutarAnalisisConIA(
                actasParaAnalizar,
                prioridadAnalisis
        );

        // 3. Establecer usuario solicitante
        analisisActas.setUsuarioSolicitante(usuarioSolicitante);

        // 4. Guardar resultados del análisis en MsDataActas
        AnalisisActas analisisGuardado = analizadorActasDataPort.guardarResultadosAnalisis(analisisActas);

        return analisisGuardado;
    }
}
