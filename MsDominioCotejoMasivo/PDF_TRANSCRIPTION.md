# Microservicio MsDominioCotejoMasivo V1.0 - Transcripción

## Información General

**Nombre del Microservicio:** MsDominioCotejoMasivo  
**Tipo:** Microservicio de Dominio  
**Versión API:** v1.0  
**Paquete Base:** pe.com.organizacion.cotejomas ivo

## Contexto de Negocio

El microservicio MsDominioCotejoMasivo es responsable de la lógica de negocio para el proceso de cotejo masivo de datos. Este microservicio de dominio se integra con el componente externo MsDataCotejoMasivo para la persistencia de información.

## Entidades del Dominio

### CotejoMasivo
- idEjecucion: String (UUID)
- fechaSolicitud: LocalDateTime
- estado: String (PENDIENTE, EN_PROCESO, COMPLETADO, ERROR)
- criteriosCotejo: List<CriterioCotejo>
- totalRegistros: Long
- registrosProcesados: Long
- registrosExitosos: Long
- registrosConError: Long
- fechaInicio: LocalDateTime
- fechaFin: LocalDateTime
- usuarioSolicitante: String

### CriterioCotejo (Value Object)
- campo: String
- operador: String (IGUAL, CONTIENE, MAYOR_QUE, MENOR_QUE)
- valor: String

### ResultadoCotejo (Value Object)
- idRegistro: String
- estadoCotejo: String (EXITOSO, ERROR, NO_ENCONTRADO)
- detalles: String
- fechaProcesamiento: LocalDateTime

## Endpoints

### 1. Endpoint: Ejecutar Cotejo Masivo

**Método:** POST  
**Ruta:** `/api/v1/cotejo-masivo/ejecutar`  
**Descripción:** Inicia un proceso de cotejo masivo de datos según los criterios proporcionados.

#### Parámetros de Entrada (Request Body)

```json
{
  "criteriosCotejo": [
    {
      "campo": "string",
      "operador": "string",
      "valor": "string"
    }
  ],
  "usuarioSolicitante": "string"
}
```

**Tipos de Datos:**
- `criteriosCotejo`: List<CriterioCotejo> (requerido)
- `usuarioSolicitante`: String (requerido)

#### Parámetros de Respuesta

```json
{
  "idEjecucion": "string",
  "fechaSolicitud": "2025-12-01T10:00:00",
  "estado": "PENDIENTE",
  "statusCode": 201,
  "mensaje": "Proceso de cotejo masivo iniciado exitosamente"
}
```

**Tipos de Datos:**
- `idEjecucion`: String (UUID)
- `fechaSolicitud`: LocalDateTime
- `estado`: String
- `statusCode`: Long
- `mensaje`: String

#### Códigos de Estado (statusCode)

| Código | Descripción |
|--------|-------------|
| 201 | Cotejo masivo iniciado exitosamente |
| 400 | Solicitud inválida - criterios de cotejo incorrectos |
| 401 | No autorizado - usuario no válido |
| 500 | Error interno del servidor |

---

### 2. Endpoint: Consultar Estado de Ejecución

**Método:** GET  
**Ruta:** `/api/v1/cotejo-masivo/estado/{idEjecucion}`  
**Descripción:** Consulta el estado actual de una ejecución de cotejo masivo.

#### Parámetros de Entrada

**Path Parameters:**
- `idEjecucion`: String (UUID, requerido)

#### Parámetros de Respuesta

```json
{
  "idEjecucion": "string",
  "fechaSolicitud": "2025-12-01T10:00:00",
  "estado": "EN_PROCESO",
  "totalRegistros": 1000,
  "registrosProcesados": 500,
  "registrosExitosos": 450,
  "registrosConError": 50,
  "fechaInicio": "2025-12-01T10:00:05",
  "fechaFin": null,
  "usuarioSolicitante": "string",
  "statusCode": 200,
  "mensaje": "Consulta exitosa"
}
```

**Tipos de Datos:**
- `idEjecucion`: String
- `fechaSolicitud`: LocalDateTime
- `estado`: String
- `totalRegistros`: Long
- `registrosProcesados`: Long
- `registrosExitosos`: Long
- `registrosConError`: Long
- `fechaInicio`: LocalDateTime
- `fechaFin`: LocalDateTime (nullable)
- `usuarioSolicitante`: String
- `statusCode`: Long
- `mensaje`: String

#### Códigos de Estado (statusCode)

| Código | Descripción |
|--------|-------------|
| 200 | Consulta exitosa |
| 404 | Ejecución no encontrada |
| 500 | Error interno del servidor |

---

### 3. Endpoint: Obtener Resultados de Cotejo

**Método:** GET  
**Ruta:** `/api/v1/cotejo-masivo/resultados/{idEjecucion}`  
**Descripción:** Obtiene los resultados detallados de una ejecución de cotejo masivo.

#### Parámetros de Entrada

**Path Parameters:**
- `idEjecucion`: String (UUID, requerido)

**Query Parameters (opcionales):**
- `pagina`: Long (default: 0)
- `tamanio`: Long (default: 100)
- `estadoCotejo`: String (EXITOSO, ERROR, NO_ENCONTRADO)

#### Parámetros de Respuesta

```json
{
  "idEjecucion": "string",
  "estado": "COMPLETADO",
  "resultados": [
    {
      "idRegistro": "string",
      "estadoCotejo": "EXITOSO",
      "detalles": "string",
      "fechaProcesamiento": "2025-12-01T10:05:00"
    }
  ],
  "paginaActual": 0,
  "tamanio": 100,
  "totalResultados": 1000,
  "totalPaginas": 10,
  "statusCode": 200,
  "mensaje": "Resultados obtenidos exitosamente"
}
```

**Tipos de Datos:**
- `idEjecucion`: String
- `estado`: String
- `resultados`: List<ResultadoCotejo>
- `paginaActual`: Long
- `tamanio`: Long
- `totalResultados`: Long
- `totalPaginas`: Long
- `statusCode`: Long
- `mensaje`: String

#### Códigos de Estado (statusCode)

| Código | Descripción |
|--------|-------------|
| 200 | Resultados obtenidos exitosamente |
| 404 | Ejecución no encontrada |
| 422 | Proceso no completado - resultados aún no disponibles |
| 500 | Error interno del servidor |

---

## Reglas de Negocio

1. **Validación de Criterios:** Todos los criterios de cotejo deben ser válidos antes de iniciar el proceso.
2. **Estado de Ejecución:** El estado debe seguir el flujo: PENDIENTE → EN_PROCESO → COMPLETADO/ERROR.
3. **Paginación de Resultados:** Los resultados se devuelven paginados para optimizar el rendimiento.
4. **Integridad de Datos:** Se debe mantener la trazabilidad completa del proceso de cotejo.

## Integración con MsDataCotejoMasivo

Este microservicio se integra con MsDataCotejoMasivo (microservicio de datos) a través de puertos de salida para:
- Crear registros de ejecución de cotejo masivo
- Actualizar el estado de las ejecuciones
- Consultar información de ejecuciones
- Almacenar y recuperar resultados de cotejo

**Nota:** El protocolo de comunicación (HTTP/SOAP/colas) no está definido en esta especificación y debe ser implementado en la capa de infraestructura.

## Mapeo de Tipos de Datos

| Tipo en Especificación | Tipo en Java |
|------------------------|--------------|
| string | String |
| integer/int | Long |
| number/decimal | Double |
| boolean | Boolean |
| date | LocalDate |
| datetime/timestamp | LocalDateTime |
| array/list | List<T> |
| UUID | String |

## Consideraciones Técnicas

- Todos los identificadores de ejecución son UUID generados por el sistema.
- Las fechas y horas se manejan en formato ISO-8601.
- Los estados son valores enumerados predefinidos.
- La paginación es obligatoria para la consulta de resultados.
- Se debe implementar manejo de errores robusto en todos los endpoints.
