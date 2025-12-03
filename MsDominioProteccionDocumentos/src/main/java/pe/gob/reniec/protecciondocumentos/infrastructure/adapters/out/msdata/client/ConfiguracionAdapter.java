package pe.gob.reniec.protecciondocumentos.infrastructure.adapters.out.msdata.client;

import pe.gob.reniec.protecciondocumentos.domain.model.ConfiguracionProteccion;
import pe.gob.reniec.protecciondocumentos.domain.model.TipoOperacion;
import pe.gob.reniec.protecciondocumentos.domain.ports.out.ConfiguracionPort;

public class ConfiguracionAdapter implements ConfiguracionPort {

    @Override
    public ConfiguracionProteccion obtenerConfiguracion(TipoOperacion tipoOperacion) {
        throw new UnsupportedOperationException("Implementación pendiente - integración con MsDatosConfiguracion");
    }
}
