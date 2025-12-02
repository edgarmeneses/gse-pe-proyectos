package pe.gob.reniec.certificadosdigitales.domain.ports.in;

import pe.gob.reniec.certificadosdigitales.domain.model.CertificadoDigital;
import pe.gob.reniec.certificadosdigitales.domain.model.Ciudadano;
import pe.gob.reniec.certificadosdigitales.domain.model.ConfiguracionCertificados;
import pe.gob.reniec.certificadosdigitales.domain.model.Metadatos;
import pe.gob.reniec.certificadosdigitales.domain.model.Solicitud;

public interface ObtenerCertificadoDigitalUseCase {
    CertificadoDigital obtenerCertificadoDigital(
        Solicitud solicitud,
        Ciudadano ciudadano,
        ConfiguracionCertificados configuracionCertificados,
        Metadatos metadatos
    );
}
