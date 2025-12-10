package pe.gob.reniec.externo.MsAdaptadorIntegracionesExternas.infrastructure.adapters.in.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import pe.gob.reniec.externo.MsAdaptadorIntegracionesExternas.application.ports.in.ValidarDatosMigracionesUseCase;
import pe.gob.reniec.externo.MsAdaptadorIntegracionesExternas.domain.model.migraciones.RespuestaMigraciones;
import pe.gob.reniec.externo.MsAdaptadorIntegracionesExternas.domain.model.migraciones.SolicitudMigraciones;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MigracionesController implements HttpHandler {

    private final ValidarDatosMigracionesUseCase useCase;
    private final ObjectMapper objectMapper;

    public MigracionesController(ValidarDatosMigracionesUseCase useCase) {
        this.useCase = useCase;
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        if ("POST".equals(exchange.getRequestMethod())) {
            try {
                InputStream requestBody = exchange.getRequestBody();
                SolicitudMigraciones solicitud = objectMapper.readValue(requestBody, SolicitudMigraciones.class);

                RespuestaMigraciones respuesta = useCase.validarDatos(solicitud);

                String response = objectMapper.writeValueAsString(respuesta);
                exchange.getResponseHeaders().set("Content-Type", "application/json");
                exchange.sendResponseHeaders(200, response.getBytes().length);
                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();
            } catch (Exception e) {
                e.printStackTrace();
                String errorResponse = "{\"error\": \"Internal Server Error: " + e.getMessage() + "\"}";
                exchange.sendResponseHeaders(500, errorResponse.getBytes().length);
                OutputStream os = exchange.getResponseBody();
                os.write(errorResponse.getBytes());
                os.close();
            }
        } else {
            exchange.sendResponseHeaders(405, -1); // Method Not Allowed
        }
    }
}
