# MsAdaptadorIntegracionesExternas

Este proyecto implementa el microservicio `MsAdaptadorIntegracionesExternas` siguiendo una Arquitectura Hexagonal estricta y utilizando Java puro (sin frameworks como Spring).

## Estructura del Proyecto

El proyecto sigue la estructura de paquetes definida:
`pe.gob.reniec.externo.MsAdaptadorIntegracionesExternas`

- **application**: Contiene los puertos (interfaces) y servicios (implementación de casos de uso).
- **domain**: Contiene las entidades del dominio (POJOs).
- **infrastructure**: Contiene los adaptadores de entrada (Controladores Web) y salida (Clientes HTTP externos).

## Decisiones de Arquitectura

1. **Tipo de Microservicio**: Se ha clasificado como un servicio de Dominio (Type A) que orquesta llamadas a sistemas externos. En lugar de un `DataPort` para persistencia, utiliza puertos de salida (`ClientPort`) para comunicarse con las integraciones externas (Migraciones, ONPE, JNE, SUNAT, RREE).
2. **Tecnología**: Se utiliza Java 11+ con `com.sun.net.httpserver.HttpServer` para exponer los endpoints REST, cumpliendo con la restricción de "Sin frameworks".
3. **JSON**: Se ha incluido la librería `jackson-databind` para el manejo de JSON, ya que la implementación manual de serialización/deserialización para estructuras complejas sería propensa a errores y poco mantenible.
4. **Endpoints Implementados**: Se ha implementado completamente el flujo de `Migraciones` (`ValidarDatosMigraciones`). Los demás flujos (ONPE, JNE, SUNAT, RREE) tienen sus interfaces definidas pero requieren implementación detallada de sus modelos y lógica.

## Ejecución

Para compilar y ejecutar el proyecto:

```bash
mvn clean package
java -jar target/MsAdaptadorIntegracionesExternas-1.0.0.jar
```

O ejecutar la clase `MsAdaptadorIntegracionesExternasApplication` desde el IDE.

## Archivos Generados

- `extract_pdf.py`: Script utilizado para extraer el texto del PDF de especificación.
- `extracted_text.txt`: Texto extraído del PDF.
