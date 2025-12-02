package pe.gob.reniec.certificadosdigitales.application.service;

import pe.gob.reniec.certificadosdigitales.domain.model.CertificadoDigital;
import pe.gob.reniec.certificadosdigitales.domain.model.Ciudadano;
import pe.gob.reniec.certificadosdigitales.domain.model.ConfiguracionCertificados;
import pe.gob.reniec.certificadosdigitales.domain.model.Metadatos;
import pe.gob.reniec.certificadosdigitales.domain.model.Solicitud;
import pe.gob.reniec.certificadosdigitales.domain.ports.in.ObtenerCertificadoDigitalUseCase;
import pe.gob.reniec.certificadosdigitales.domain.ports.out.AdaptadorPkiPort;

public class ObtenerCertificadoDigitalService implements ObtenerCertificadoDigitalUseCase {
    
    private final AdaptadorPkiPort adaptadorPkiPort;

    public ObtenerCertificadoDigitalService(AdaptadorPkiPort adaptadorPkiPort) {
        this.adaptadorPkiPort = adaptadorPkiPort;
    }

    @Override
    public CertificadoDigital obtenerCertificadoDigital(
        Solicitud solicitud,
        Ciudadano ciudadano,
        ConfiguracionCertificados configuracionCertificados,
        Metadatos metadatos
    ) {
        throw new UnsupportedOperationException("Implementación pendiente: coreografía de dos pasos con MsAdaptadorPKI");
    }
}
