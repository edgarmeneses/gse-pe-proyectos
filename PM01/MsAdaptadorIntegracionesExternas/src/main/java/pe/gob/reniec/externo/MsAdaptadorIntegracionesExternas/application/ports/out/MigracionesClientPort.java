package pe.gob.reniec.externo.MsAdaptadorIntegracionesExternas.application.ports.out;

import pe.gob.reniec.externo.MsAdaptadorIntegracionesExternas.domain.model.migraciones.RespuestaMigraciones;
import pe.gob.reniec.externo.MsAdaptadorIntegracionesExternas.domain.model.migraciones.SolicitudMigraciones;

public interface MigracionesClientPort {
    RespuestaMigraciones consultarMigraciones(SolicitudMigraciones solicitud);
}
