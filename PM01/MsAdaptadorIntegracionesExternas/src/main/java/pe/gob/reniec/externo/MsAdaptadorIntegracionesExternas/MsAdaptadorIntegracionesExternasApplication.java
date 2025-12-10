package pe.gob.reniec.externo.MsAdaptadorIntegracionesExternas;

import com.sun.net.httpserver.HttpServer;
import pe.gob.reniec.externo.MsAdaptadorIntegracionesExternas.application.ports.in.ValidarDatosMigracionesUseCase;
import pe.gob.reniec.externo.MsAdaptadorIntegracionesExternas.application.ports.out.MigracionesClientPort;
import pe.gob.reniec.externo.MsAdaptadorIntegracionesExternas.application.services.ValidarDatosMigracionesService;
import pe.gob.reniec.externo.MsAdaptadorIntegracionesExternas.infrastructure.adapters.in.web.MigracionesController;
import pe.gob.reniec.externo.MsAdaptadorIntegracionesExternas.infrastructure.adapters.out.external.MigracionesExternalAdapter;

import java.io.IOException;
import java.net.InetSocketAddress;

public class MsAdaptadorIntegracionesExternasApplication {

    public static void main(String[] args) throws IOException {
        // 1. Crear adaptadores de salida (Infrastructure)
        MigracionesClientPort migracionesAdapter = new MigracionesExternalAdapter();

        // 2. Crear servicios de aplicación (Application) e inyectar puertos
        ValidarDatosMigracionesUseCase migracionesService = new ValidarDatosMigracionesService(migracionesAdapter);

        // 3. Crear adaptadores de entrada (Infrastructure) e inyectar casos de uso
        MigracionesController migracionesController = new MigracionesController(migracionesService);

        // 4. Configurar servidor HTTP
        int port = 8080;
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        
        // 5. Mapear rutas a controladores
        server.createContext("/api/v1/externo/MsAdaptadorIntegracionesExternas/migraciones/validar", migracionesController);
        
        server.setExecutor(null); // creates a default executor
        server.start();
        
        System.out.println("Microservicio MsAdaptadorIntegracionesExternas iniciado en el puerto " + port);
    }
}
