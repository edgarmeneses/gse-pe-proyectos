package pe.gob.reniec.certificadosdigitales.infrastructure.adapters.out.msdata.client;

import pe.gob.reniec.certificadosdigitales.domain.ports.out.AdaptadorPkiPort;

public class AdaptadorPkiAdapter implements AdaptadorPkiPort {

    @Override
    public String generarNumerosSolicitud(String numeroDocumento, String tipoDocumento, String codigoSolicitudTramite) {
        throw new UnsupportedOperationException(
            "Implementación pendiente: consumir POST /api/v1/adaptador/MsAdaptadorPKI/generarNumerosSolicitud2"
        );
    }

    @Override
    public Object generarCertificadoDigital(String solicitudPkiId, Object datosCiudadano, Object configuracionCertificados) {
        throw new UnsupportedOperationException(
            "Implementación pendiente: consumir POST /api/v1/adaptador/MsAdaptadorPKI/generarCertificadoDigitalDniE"
        );
    }
}
