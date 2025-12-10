package pe.gob.reniec.externo.MsAdaptadorIntegracionesExternas.application.services;

import pe.gob.reniec.externo.MsAdaptadorIntegracionesExternas.application.ports.in.ValidarDatosMigracionesUseCase;
import pe.gob.reniec.externo.MsAdaptadorIntegracionesExternas.application.ports.out.MigracionesClientPort;
import pe.gob.reniec.externo.MsAdaptadorIntegracionesExternas.domain.model.migraciones.RespuestaMigraciones;
import pe.gob.reniec.externo.MsAdaptadorIntegracionesExternas.domain.model.migraciones.SolicitudMigraciones;

public class ValidarDatosMigracionesService implements ValidarDatosMigracionesUseCase {

    private final MigracionesClientPort migracionesClientPort;

    public ValidarDatosMigracionesService(MigracionesClientPort migracionesClientPort) {
        this.migracionesClientPort = migracionesClientPort;
    }

    @Override
    public RespuestaMigraciones validarDatos(SolicitudMigraciones solicitud) {
        // Aquí podría ir validación de negocio previa
        if (solicitud == null || solicitud.getCiudadano() == null) {
            throw new IllegalArgumentException("Solicitud o ciudadano no puede ser nulo");
        }
        return migracionesClientPort.consultarMigraciones(solicitud);
    }
}
