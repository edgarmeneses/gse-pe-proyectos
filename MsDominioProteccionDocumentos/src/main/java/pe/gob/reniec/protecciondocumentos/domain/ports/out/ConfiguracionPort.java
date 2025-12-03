package pe.gob.reniec.protecciondocumentos.domain.ports.out;

import pe.gob.reniec.protecciondocumentos.domain.model.ConfiguracionProteccion;
import pe.gob.reniec.protecciondocumentos.domain.model.TipoOperacion;

public interface ConfiguracionPort {
    ConfiguracionProteccion obtenerConfiguracion(TipoOperacion tipoOperacion);
}
