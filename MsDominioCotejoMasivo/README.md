# Microservicio MsDominioCotejoMasivo

## Descripción General

**MsDominioCotejoMasivo** es un microservicio de dominio (MsDominio) que implementa la lógica de negocio para el cotejo masivo de datos personales contra el Padrón Nacional de Identificación (RENIEC). Este microservicio orquesta el proceso de validación masiva de identidades y coordina la persistencia de datos a través de su microservicio de datos asociado (MsDatosCotejoMasivo).

**Tipo:** Microservicio de Dominio (MsDominio)  
**Versión API:** 1.0  
**Arquitectura:** Hexagonal (Ports & Adapters)  
**Contexto:** Sistema de Cotejo Masivo RENIEC

## Arquitectura

### Patrón Hexagonal

El microservicio sigue estrictamente la arquitectura hexagonal con tres capas claramente definidas:

```
MsDominioCotejoMasivo/
├── domain/                          # Núcleo de negocio (independiente)
│   ├── model/                       # Entidades del dominio
│   │   ├── Ejecucion.java          # Agregado raíz
│   │   ├── RegistroEntrada.java    # Entidad de entrada
│   │   ├── ResultadoCotejo.java    # Entidad de resultado
│   │   └── ResumenResultados.java  # Objeto de valor
│   └── ports/                       # Contratos del dominio
│       ├── in/                      # Casos de uso (entrada)
│       │   ├── EjecutarCotejoUseCase.java
│       │   ├── ConsultarEstadoUseCase.java
│       │   └── ObtenerResultadosUseCase.java
│       └── out/                     # Puertos de salida
│           └── EjecucionDataPort.java
├── application/                     # Orquestación
│   └── service/                     # Implementación de casos de uso
│       ├── EjecutarCotejoService.java
│       ├── ConsultarEstadoService.java
│       └── ObtenerResultadosService.java
└── infrastructure/                  # Adaptadores técnicos
    └── adapters/
        ├── in/                      # Adaptadores de entrada
        │   └── rest/
        │       ├── controller/
        │       │   └── CotejoController.java
        │       ├── dto/             # Objetos de transferencia
        │       │   ├── EjecutarCotejoRequestDto.java
        │       │   ├── RegistroEntradaDto.java
        │       │   ├── EjecutarCotejoResponseDto.java
        │       │   ├── ConsultarEstadoResponseDto.java
        │       │   ├── ObtenerResultadosResponseDto.java
        │       │   └── MetadataDto.java
        │       └── mapper/
        │           └── CotejoDtoMapper.java
        └── out/                     # Adaptadores de salida
            └── msdata/
                └── client/
                    └── EjecucionDataAdapter.java
```

### Características de la Arquitectura

- **Sin frameworks**: Implementación en Java puro (POJOs) sin dependencias de Spring, Jakarta EE u otros frameworks
- **Separación de responsabilidades**: 
  - **Domain**: Contiene la lógica de negocio pura
  - **Application**: Orquesta casos de uso
  - **Infrastructure**: Adaptadores técnicos (REST, cliente MsData)
- **Inversión de dependencias**: La infraestructura depende del dominio, nunca al revés
- **Protocolo agnóstico**: Los puertos no asumen tecnologías específicas

### Diferencia entre MsDominio y MsDatos

**MsDominio (este microservicio)**:
- NO tiene `RepositoryPort` (no accede directamente a base de datos)
- SÍ tiene `DataPort` (puerto de salida hacia MsDatosCotejoMasivo)
- Contiene lógica de negocio y orquestación
- Delega persistencia al microservicio de datos

**MsDatos (MsDatosCotejoMasivo)**:
- SÍ tiene `RepositoryPort` (acceso a base de datos)
- NO tiene `DataPort` a otros microservicios
- Responsable de operaciones CRUD
- Expone endpoints para persistencia y consulta

## API REST

### Endpoint 1: Ejecutar Cotejo Masivo

**Descripción**: Inicia una ejecución de cotejo masivo de registros contra el Padrón RENIEC.

**Ruta**: `/api/v1/cotejo/ejecutar`  
**Método**: `POST`  
**Content-Type**: `application/json`

**Parámetros del Request Body**:

```json
{
  "solicitudId": "string (required) - Identificador único de la solicitud",
  "codigoOrganizacion": "string (required) - Código de la organización solicitante",
  "nombreOrganizacion": "string (optional) - Nombre de la organización",
  "codigoEnvio": "string (optional) - Código del envío",
  "numeroLote": "string (optional) - Número de lote",
  "documentoSustento": "string (optional) - Documento de sustento legal",
  "observaciones": "string (optional) - Observaciones adicionales",
  "indicadorDomicilio": "string (optional) - Indicador si se valida domicilio (S/N)",
  "codigoPrograma": "string (optional) - Código del programa beneficiario",
  "registros": [
    {
      "numeroSecuencia": "integer (required) - Número de secuencia del registro",
      "numeroDni": "string (required) - Número de DNI a validar",
      "apellidoPaterno": "string (required) - Apellido paterno",
      "apellidoMaterno": "string (required) - Apellido materno",
      "nombres": "string (required) - Nombres",
      "fechaNacimiento": "string (optional) - Fecha de nacimiento (formato ISO 8601)",
      "indicadorSexo": "string (optional) - Sexo (M/F)",
      "identificadorInstitucion": "string (optional) - Identificador de la institución",
      "datosAdicionales": "string (optional) - Datos adicionales en formato JSON"
    }
  ]
}
```

**Response Body (200 OK)**:

```json
{
  "success": true,
  "data": {
    "ejecucionId": 123,
    "estadoProceso": "REGISTRADO",
    "mensajeProceso": "Ejecución creada exitosamente",
    "codigoEstado": "REG",
    "descripcionEstado": "Registrado",
    "totalRegistrosEntrada": 150,
    "fechaCreacion": "2024-01-15T10:30:00Z"
  },
  "metadata": {
    "timestamp": "2024-01-15T10:30:00Z",
    "correlationId": "uuid-v4",
    "version": "1.0"
  }
}
```

**Códigos de Estado HTTP**:
- `200 OK`: Ejecución creada exitosamente
- `400 Bad Request`: Datos de entrada inválidos
- `500 Internal Server Error`: Error en el procesamiento

---

### Endpoint 2: Consultar Estado de Ejecución

**Descripción**: Consulta el estado actual de una ejecución de cotejo masivo.

**Ruta**: `/api/v1/cotejo/estado/{ejecucionId}`  
**Método**: `GET`

**Parámetros de Path**:
- `ejecucionId` (Long, required): Identificador de la ejecución

**Response Body (200 OK)**:

```json
{
  "success": true,
  "data": {
    "ejecucionId": 123,
    "codigoEstado": "COMP",
    "descripcionEstado": "Completado",
    "totalRegistrosEntrada": 150,
    "totalRegistrosProcesados": 150,
    "totalRegistrosCorrectos": 120,
    "totalRegistrosIncorrectos": 30,
    "fechaInicioProceso": "2024-01-15T10:30:00Z",
    "fechaFinProceso": "2024-01-15T10:45:00Z",
    "resumenResultados": {
      "totalCorrectos": 120,
      "totalDniNoExiste": 15,
      "totalDatosNoCoinciden": 10,
      "totalErrores": 5,
      "porcentajeExito": 80.0
    }
  },
  "metadata": {
    "timestamp": "2024-01-15T11:00:00Z",
    "correlationId": "uuid-v4",
    "version": "1.0"
  }
}
```

**Códigos de Estado HTTP**:
- `200 OK`: Consulta exitosa
- `404 Not Found`: Ejecución no encontrada
- `500 Internal Server Error`: Error en el procesamiento

---

### Endpoint 3: Obtener Resultados de Cotejo

**Descripción**: Obtiene los resultados detallados de una ejecución con paginación.

**Ruta**: `/api/v1/cotejo/resultados/{ejecucionId}`  
**Método**: `GET`

**Parámetros de Path**:
- `ejecucionId` (Long, required): Identificador de la ejecución

**Parámetros de Query**:
- `codigoResultado` (String, optional): Filtrar por código de resultado (CORRECTO, DNI_NO_EXISTE, DATOS_NO_COINCIDEN, ERROR)
- `numeroPagina` (Integer, optional, default=1): Número de página (1-indexed)
- `elementosPorPagina` (Integer, optional, default=50): Cantidad de elementos por página

**Response Body (200 OK)**:

```json
{
  "success": true,
  "data": {
    "resultados": [
      {
        "resultadoId": 456,
        "registroEntradaId": 789,
        "codigoResultado": "CORRECTO",
        "numeroDni": "12345678",
        "apellidoPaterno": "PEREZ",
        "apellidoMaterno": "GARCIA",
        "nombres": "JUAN CARLOS",
        "coincideDni": "S",
        "coincideApellidoPaterno": "S",
        "coincideApellidoMaterno": "S",
        "coincideNombres": "S",
        "mensajeObservacion": "Datos coinciden correctamente"
      }
    ],
    "paginacion": {
      "paginaActual": 1,
      "elementosPorPagina": 50,
      "totalElementos": 150,
      "totalPaginas": 3
    }
  },
  "metadata": {
    "timestamp": "2024-01-15T11:05:00Z",
    "correlationId": "uuid-v4",
    "version": "1.0"
  }
}
```

**Códigos de Estado HTTP**:
- `200 OK`: Consulta exitosa
- `404 Not Found`: Ejecución no encontrada
- `500 Internal Server Error`: Error en el procesamiento

## Modelo de Dominio

### Entidad: Ejecucion (Agregado Raíz)

Representa una ejecución de cotejo masivo con su ciclo de vida completo.

**Atributos**:
- `ejecucionId` (Long): Identificador único
- `solicitudId` (String): ID de la solicitud origen
- `codigoOrganizacion` (String): Código de organización solicitante
- `nombreOrganizacion` (String): Nombre de la organización
- `codigoEnvio` (String): Código del envío
- `numeroLote` (String): Número de lote
- `documentoSustento` (String): Documento legal de sustento
- `observaciones` (String): Observaciones
- `indicadorDomicilio` (String): Indicador validación domicilio (S/N)
- `codigoPrograma` (String): Código del programa
- `codigoEstado` (String): Código del estado (REG, PROC, COMP, ERR)
- `descripcionEstado` (String): Descripción del estado
- `totalRegistrosEntrada` (Integer): Total de registros ingresados
- `totalRegistrosProcesados` (Integer): Total procesados
- `totalRegistrosCorrectos` (Integer): Total correctos
- `totalRegistrosIncorrectos` (Integer): Total incorrectos
- `fechaCreacion` (LocalDateTime): Fecha de creación
- `fechaInicioProceso` (LocalDateTime): Fecha inicio del procesamiento
- `fechaFinProceso` (LocalDateTime): Fecha fin del procesamiento
- `mensajeError` (String): Mensaje de error si ocurre
- `usuarioCreacion` (String): Usuario que creó la ejecución
- `resumenResultados` (ResumenResultados): Resumen de resultados

**Métodos de negocio**:
- `iniciarProceso()`: Cambia estado a EN_PROCESO y registra fecha inicio
- `finalizarProceso(ResumenResultados)`: Cambia estado a COMPLETADO y registra resumen
- `registrarError(String)`: Cambia estado a ERROR y registra mensaje
- `actualizarEstado()`: Actualiza descripción según código de estado

**Estados posibles**:
- `REGISTRADO`: Ejecución creada, pendiente de procesar
- `EN_PROCESO`: Procesamiento en curso
- `COMPLETADO`: Procesamiento finalizado exitosamente
- `ERROR`: Procesamiento finalizado con errores

---

### Entidad: RegistroEntrada

Representa un registro individual a validar en el cotejo masivo.

**Atributos**:
- `registroEntradaId` (Long): Identificador único
- `ejecucionId` (Long): ID de la ejecución asociada
- `numeroSecuencia` (Integer): Número de secuencia en el lote
- `numeroDni` (String): DNI a validar
- `apellidoPaterno` (String): Apellido paterno
- `apellidoMaterno` (String): Apellido materno
- `nombres` (String): Nombres
- `fechaNacimiento` (LocalDateTime): Fecha de nacimiento
- `indicadorSexo` (String): Sexo (M/F)
- `identificadorInstitucion` (String): ID de la institución
- `datosAdicionales` (String): Datos adicionales (JSON)

---

### Entidad: ResultadoCotejo

Representa el resultado del cotejo de un registro individual.

**Atributos**:
- `resultadoId` (Long): Identificador único
- `ejecucionId` (Long): ID de la ejecución
- `registroEntradaId` (Long): ID del registro de entrada
- `codigoResultado` (String): Código del resultado
- `numeroDniEncontrado` (String): DNI encontrado en Padrón
- `apellidoPaternoEncontrado` (String): Apellido paterno encontrado
- `apellidoMaternoEncontrado` (String): Apellido materno encontrado
- `nombresEncontrado` (String): Nombres encontrados
- `coincideDni` (String): Indica si coincide DNI (S/N)
- `coincideApellidoPaterno` (String): Indica si coincide apellido paterno (S/N)
- `coincideApellidoMaterno` (String): Indica si coincide apellido materno (S/N)
- `coincideNombres` (String): Indica si coinciden nombres (S/N)
- `mensajeObservacion` (String): Mensaje de observación

**Códigos de resultado**:
- `CORRECTO`: Todos los datos coinciden
- `DNI_NO_EXISTE`: DNI no existe en el Padrón RENIEC
- `DATOS_NO_COINCIDEN`: DNI existe pero datos no coinciden
- `ERROR`: Error en el procesamiento

---

### Objeto de Valor: ResumenResultados

Representa el resumen consolidado de resultados de una ejecución.

**Atributos**:
- `totalCorrectos` (Integer): Total de registros correctos
- `totalDniNoExiste` (Integer): Total de DNI no encontrados
- `totalDatosNoCoinciden` (Integer): Total con datos no coincidentes
- `totalErrores` (Integer): Total con errores
- `porcentajeExito` (Double): Porcentaje de éxito calculado

**Métodos**:
- `calcularPorcentajeExito()`: Calcula el porcentaje de registros correctos

## Casos de Uso

### 1. EjecutarCotejoUseCase

**Responsabilidad**: Orquestar la ejecución de un cotejo masivo.

**Flujo**:
1. Crear ejecución en estado REGISTRADO
2. Registrar registros de entrada
3. Ejecutar cotejo contra Padrón RENIEC
4. Registrar resultados del cotejo
5. Actualizar estado a COMPLETADO o ERROR

**Clases internas**:
- `SolicitudCotejo`: DTO de entrada con datos de la solicitud
- `ResultadoEjecucionCotejo`: DTO de salida con resultado de la ejecución

---

### 2. ConsultarEstadoUseCase

**Responsabilidad**: Consultar el estado actual de una ejecución.

**Entrada**: `ejecucionId` (Long)  
**Salida**: `Ejecucion` con estado completo y resumen de resultados

---

### 3. ObtenerResultadosUseCase

**Responsabilidad**: Obtener resultados paginados de una ejecución.

**Entrada**: `FiltrosResultados` (ejecucionId, codigoResultado opcional, paginación)  
**Salida**: `ResultadoPaginado` con lista de resultados y metadata de paginación

**Clases internas**:
- `FiltrosResultados`: Criterios de búsqueda y paginación
- `ResultadoPaginado`: Resultados con información de paginación

## Integración con MsDatosCotejoMasivo

El microservicio se integra con **MsDatosCotejoMasivo** a través del puerto de salida `EjecucionDataPort`, que define las siguientes operaciones:

### Operaciones disponibles:

1. **crearEjecucion**: Persiste una nueva ejecución
2. **registrarRegistrosEntrada**: Registra lote de registros de entrada
3. **registrarResultadosCotejo**: Registra lote de resultados
4. **consultarEjecucion**: Consulta una ejecución por ID
5. **obtenerResultadosCotejo**: Obtiene resultados con paginación

### Mapeo de endpoints:

| Operación DataPort | Endpoint MsDatosCotejoMasivo |
|-------------------|------------------------------|
| crearEjecucion | POST /api/v1/ejecuciones |
| registrarRegistrosEntrada | POST /api/v1/ejecuciones/{id}/registros-entrada |
| registrarResultadosCotejo | POST /api/v1/ejecuciones/{id}/resultados |
| consultarEjecucion | GET /api/v1/ejecuciones/{id} |
| obtenerResultadosCotejo | GET /api/v1/ejecuciones/{id}/resultados |

### Estado de implementación:

⚠️ **Importante**: El adaptador `EjecucionDataAdapter` actualmente lanza `UnsupportedOperationException` ya que el protocolo de comunicación (HTTP/REST, SOAP, mensajería) no está definido en la especificación del proyecto.

Para completar la integración se debe:
1. Definir el protocolo de comunicación (recomendado: HTTP/REST con JSON)
2. Implementar el cliente HTTP en `EjecucionDataAdapter`
3. Mapear las estructuras de datos entre ambos microservicios
4. Configurar manejo de errores y reintentos
5. Implementar circuit breaker para resiliencia

## Limitaciones y Consideraciones

### Implementación actual:

1. **Sin frameworks**: El código está implementado en Java puro sin dependencias de Spring, Jakarta EE, etc. Esto permite flexibilidad pero requiere implementación manual de:
   - Inyección de dependencias
   - Manejo de transacciones
   - Configuración de servidor HTTP
   - Serialización JSON

2. **Integración con MsDatosCotejoMasivo**: Pendiente de implementación. Se requiere definir:
   - Protocolo de comunicación
   - Formato de mensajes
   - Manejo de errores
   - Estrategia de reintentos

3. **Integración con Padrón RENIEC**: El método `ejecutarCotejoPadron()` en `EjecutarCotejoService` es un placeholder que lanza `UnsupportedOperationException`. Debe implementarse:
   - Cliente del servicio de consulta RENIEC
   - Lógica de comparación de datos
   - Manejo de timeouts y errores
   - Generación de objetos `ResultadoCotejo`

4. **Sin anotaciones REST**: El `CotejoController` no tiene anotaciones de framework (como `@RestController`, `@PostMapping`, etc.). Se requiere:
   - Configurar un servidor HTTP manualmente (Jetty, Netty, etc.)
   - Implementar routing de endpoints
   - Implementar serialización/deserialización JSON
   - O migrar a un framework REST

### Próximos pasos de implementación:

1. **Configuración de infraestructura**:
   - Servidor HTTP embebido
   - Configuración de puertos y contexto
   - Logging estructurado

2. **Inyección de dependencias**:
   - Factory para creación de servicios
   - Configuración de adaptadores

3. **Persistencia**:
   - Implementar cliente HTTP para MsDatosCotejoMasivo
   - Mapeo de DTOs entre microservicios

4. **Integración externa**:
   - Cliente del Padrón RENIEC
   - Lógica de cotejo de datos
   - Manejo de errores y reintentos

5. **Observabilidad**:
   - Logging de operaciones
   - Métricas de rendimiento
   - Trazabilidad distribuida

## Contacto y Soporte

Para dudas o soporte técnico contactar al equipo de desarrollo de RENIEC.

**Versión del documento**: 1.0  
**Fecha**: 2024-01-15
