package pe.gob.reniec.certificadosdigitales.domain.ports.out;

public interface AdaptadorPkiPort {
    String generarNumerosSolicitud(String numeroDocumento, String tipoDocumento, String codigoSolicitudTramite);
    
    Object generarCertificadoDigital(String solicitudPkiId, Object datosCiudadano, Object configuracionCertificados);
}
