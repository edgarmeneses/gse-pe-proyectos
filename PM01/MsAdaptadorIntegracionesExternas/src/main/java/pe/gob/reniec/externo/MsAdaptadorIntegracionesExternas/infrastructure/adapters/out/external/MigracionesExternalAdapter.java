package pe.gob.reniec.externo.MsAdaptadorIntegracionesExternas.infrastructure.adapters.out.external;

import pe.gob.reniec.externo.MsAdaptadorIntegracionesExternas.application.ports.out.MigracionesClientPort;
import pe.gob.reniec.externo.MsAdaptadorIntegracionesExternas.domain.model.migraciones.RespuestaMigraciones;
import pe.gob.reniec.externo.MsAdaptadorIntegracionesExternas.domain.model.migraciones.SolicitudMigraciones;
import pe.gob.reniec.externo.MsAdaptadorIntegracionesExternas.domain.model.migraciones.RespuestaMigratoria;
import pe.gob.reniec.externo.MsAdaptadorIntegracionesExternas.domain.model.common.Metadata;

import java.net.http.HttpClient;
import java.time.Instant;

public class MigracionesExternalAdapter implements MigracionesClientPort {

    private final HttpClient httpClient;

    public MigracionesExternalAdapter() {
        this.httpClient = HttpClient.newHttpClient();
    }

    @Override
    public RespuestaMigraciones consultarMigraciones(SolicitudMigraciones solicitud) {
        // Lógica para llamar al servicio externo de Migraciones
        // Por ahora retornamos una respuesta simulada (Mock)
        
        RespuestaMigraciones respuesta = new RespuestaMigraciones();
        
        RespuestaMigratoria data = new RespuestaMigratoria();
        data.setEsValido(true);
        data.setEstadoMigratorio("REGULAR");
        data.setTipoCalidad("RESIDENTE");
        data.setFechaIngreso("2023-01-01");
        data.setFechaVencimiento("2025-01-01");
        
        respuesta.setRespuestaMigratoria(data);
        
        Metadata metadata = new Metadata();
        metadata.setTimestamp(Instant.now().toString());
        metadata.setProveedor("MIGRACIONES");
        metadata.setTiempoRespuesta("100ms");
        metadata.setCorrelationId("12345");
        
        respuesta.setMetadata(metadata);
        
        return respuesta;
    }
}
