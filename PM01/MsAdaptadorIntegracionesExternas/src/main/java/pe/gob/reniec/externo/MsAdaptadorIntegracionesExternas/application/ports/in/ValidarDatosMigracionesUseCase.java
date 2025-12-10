package pe.gob.reniec.externo.MsAdaptadorIntegracionesExternas.application.ports.in;

import pe.gob.reniec.externo.MsAdaptadorIntegracionesExternas.domain.model.migraciones.RespuestaMigraciones;
import pe.gob.reniec.externo.MsAdaptadorIntegracionesExternas.domain.model.migraciones.SolicitudMigraciones;

public interface ValidarDatosMigracionesUseCase {
    RespuestaMigraciones validarDatos(SolicitudMigraciones solicitud);
}
