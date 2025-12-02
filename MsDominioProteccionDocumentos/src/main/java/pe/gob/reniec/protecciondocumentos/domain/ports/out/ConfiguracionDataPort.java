package pe.gob.reniec.protecciondocumentos.domain.ports.out;

import pe.gob.reniec.protecciondocumentos.domain.model.ConfiguracionProteccion;

public interface ConfiguracionDataPort {
    ConfiguracionProteccion obtenerConfiguracionPorDefecto();
    ConfiguracionProteccion validarConfiguracion(ConfiguracionProteccion configuracion);
}
