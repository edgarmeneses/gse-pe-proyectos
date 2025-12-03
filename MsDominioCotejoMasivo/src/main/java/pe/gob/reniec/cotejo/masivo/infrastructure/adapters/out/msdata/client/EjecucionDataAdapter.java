package pe.gob.reniec.cotejo.masivo.infrastructure.adapters.out.msdata.client;

import pe.gob.reniec.cotejo.masivo.domain.model.Ejecucion;
import pe.gob.reniec.cotejo.masivo.domain.model.RegistroEntrada;
import pe.gob.reniec.cotejo.masivo.domain.model.ResultadoCotejo;
import pe.gob.reniec.cotejo.masivo.domain.ports.out.EjecucionDataPort;

import java.util.List;

/**
 * Adaptador para comunicación con MsDatosCotejoMasivo.
 * 
 * Esta implementación es un placeholder ya que el protocolo de comunicación
 * (HTTP/REST, SOAP, mensajería) no está definido en la especificación.
 * 
 * Los métodos lanzan UnsupportedOperationException hasta que se defina
 * el mecanismo de integración específico con MsDatosCotejoMasivo.
 */
public class EjecucionDataAdapter implements EjecucionDataPort {

    @Override
    public Long crearEjecucion(Ejecucion ejecucion) {
        throw new UnsupportedOperationException(
            "Integración con MsDatosCotejoMasivo no implementada. " +
            "Debe definirse el protocolo de comunicación (HTTP/REST, SOAP, mensajería) " +
            "y realizar la invocación al endpoint CrearEjecucion de MsDatosCotejoMasivo."
        );
    }

    @Override
    public ResultadoRegistroBatch registrarRegistrosEntrada(Long ejecucionId, List<RegistroEntrada> registros) {
        throw new UnsupportedOperationException(
            "Integración con MsDatosCotejoMasivo no implementada. " +
            "Debe definirse el protocolo de comunicación (HTTP/REST, SOAP, mensajería) " +
            "y realizar la invocación al endpoint RegistrarRegistrosEntrada de MsDatosCotejoMasivo."
        );
    }

    @Override
    public ResultadoCotejoBatch registrarResultadosCotejo(Long ejecucionId, List<ResultadoCotejo> resultados) {
        throw new UnsupportedOperationException(
            "Integración con MsDatosCotejoMasivo no implementada. " +
            "Debe definirse el protocolo de comunicación (HTTP/REST, SOAP, mensajería) " +
            "y realizar la invocación al endpoint RegistrarResultadosCotejo de MsDatosCotejoMasivo."
        );
    }

    @Override
    public Ejecucion consultarEjecucion(Long ejecucionId) {
        throw new UnsupportedOperationException(
            "Integración con MsDatosCotejoMasivo no implementada. " +
            "Debe definirse el protocolo de comunicación (HTTP/REST, SOAP, mensajería) " +
            "y realizar la invocación al endpoint ConsultarEjecucion de MsDatosCotejoMasivo."
        );
    }

    @Override
    public List<ResultadoCotejo> obtenerResultadosCotejo(
            Long ejecucionId,
            String codigoResultado,
            int numeroPagina,
            int elementosPorPagina) {
        throw new UnsupportedOperationException(
            "Integración con MsDatosCotejoMasivo no implementada. " +
            "Debe definirse el protocolo de comunicación (HTTP/REST, SOAP, mensajería) " +
            "y realizar la invocación al endpoint ObtenerResultados de MsDatosCotejoMasivo."
        );
    }
}
