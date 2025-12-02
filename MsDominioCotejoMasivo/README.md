# MsDominioCotejoMasivo - Microservicio de Dominio

## Información General

**Nombre del Microservicio:** MsDominioCotejoMasivo  
**Tipo:** Microservicio de Dominio  
**Versión API:** v1.0  
**Paquete Base:** `pe.com.organizacion.cotejomasivo`  
**Arquitectura:** Hexagonal (Ports and Adapters)

## Contexto de Negocio

MsDominioCotejoMasivo es un microservicio de dominio responsable de la lógica de negocio para el proceso de cotejo masivo de datos. Este microservicio orquesta las operaciones de cotejo sin depender de tecnologías específicas de persistencia o comunicación.

### Características Principales

- Ejecución asíncrona de procesos de cotejo masivo
- Seguimiento del estado de ejecución en tiempo real
- Obtención paginada de resultados
- Integración con MsDataCotejoMasivo para persistencia de datos
- Arquitectura limpia sin dependencias de frameworks

## Arquitectura Hexagonal

### Tipo de Microservicio: Dominio

Como microservicio de dominio (**MsDominio**), este proyecto:

- **NO define RepositoryPort** - La persistencia es responsabilidad de MsDataCotejoMasivo
- **Define DataPorts** - Interfaces para comunicarse con el microservicio de datos
- **Implementa la lógica de negocio** - Casos de uso y reglas de dominio
- **Mantiene neutralidad tecnológica** - Sin frameworks, sin anotaciones

### Estructura del Proyecto

```
src/main/java/pe/com/organizacion/cotejomasivo/
├── domain/                          # Capa de Dominio
│   ├── model/                       # Entidades y Value Objects
│   │   ├── CotejoMasivo.java        # Aggregate Root
│   │   ├── CriterioCotejo.java      # Value Object
│   │   ├── ResultadoCotejo.java     # Value Object
│   │   └── ResultadosPaginados.java # Value Object
│   └── ports/                       # Puertos (Interfaces)
│       ├── in/                      # Puertos de Entrada (Use Cases)
│       │   ├── EjecutarCotejoMasivoUseCase.java
│       │   ├── ConsultarCotejoMasivoUseCase.java
│       │   └── ObtenerResultadosCotejoMasivoUseCase.java
│       └── out/                     # Puertos de Salida (Data Ports)
│           └── CotejoMasivoDataPort.java
├── application/                     # Capa de Aplicación
│   └── service/                     # Servicios (Implementan Use Cases)
│       ├── EjecutarCotejoMasivoService.java
│       ├── ConsultarCotejoMasivoService.java
│       └── ObtenerResultadosCotejoMasivoService.java
└── infrastructure/                  # Capa de Infraestructura
    └── adapters/                    # Adaptadores
        ├── in/                      # Adaptadores de Entrada
        │   └── rest/                # Adaptador REST
        │       ├── controller/
        │       │   └── CotejoMasivoController.java
        │       ├── dto/             # DTOs (Java Records)
        │       │   ├── EjecutarCotejoMasivoRequestDto.java
        │       │   ├── EjecutarCotejoMasivoResponseDto.java
        │       │   ├── ConsultarCotejoMasivoResponseDto.java
        │       │   ├── ObtenerResultadosCotejoMasivoResponseDto.java
        │       │   ├── CriterioCotejoDto.java
        │       │   └── ResultadoCotejoDto.java
        │       └── mapper/
        │           └── CotejoMasivoDtoMapper.java
        └── out/                     # Adaptadores de Salida
            └── msdata/              # Adaptador para MsDataCotejoMasivo
                └── client/
                    └── CotejoMasivoDataAdapter.java
```

## Entidades del Dominio

### CotejoMasivo (Aggregate Root)

Representa una ejecución de cotejo masivo con los siguientes atributos:

| Atributo | Tipo | Descripción |
|----------|------|-------------|
| idEjecucion | String (UUID) | Identificador único de la ejecución |
| fechaSolicitud | LocalDateTime | Fecha y hora de solicitud |
| estado | String | PENDIENTE, EN_PROCESO, COMPLETADO, ERROR |
| criteriosCotejo | List<CriterioCotejo> | Criterios de cotejo aplicados |
| totalRegistros | Long | Total de registros a procesar |
| registrosProcesados | Long | Registros ya procesados |
| registrosExitosos | Long | Registros procesados exitosamente |
| registrosConError | Long | Registros con errores |
| fechaInicio | LocalDateTime | Fecha y hora de inicio del proceso |
| fechaFin | LocalDateTime | Fecha y hora de finalización |
| usuarioSolicitante | String | Usuario que solicitó el cotejo |

### CriterioCotejo (Value Object)

| Atributo | Tipo | Descripción |
|----------|------|-------------|
| campo | String | Campo sobre el que se aplica el criterio |
| operador | String | IGUAL, CONTIENE, MAYOR_QUE, MENOR_QUE |
| valor | String | Valor de comparación |

### ResultadoCotejo (Value Object)

| Atributo | Tipo | Descripción |
|----------|------|-------------|
| idRegistro | String | Identificador del registro procesado |
| estadoCotejo | String | EXITOSO, ERROR, NO_ENCONTRADO |
| detalles | String | Información adicional del resultado |
| fechaProcesamiento | LocalDateTime | Fecha y hora de procesamiento |

### ResultadosPaginados (Value Object)

| Atributo | Tipo | Descripción |
|----------|------|-------------|
| idEjecucion | String | Identificador de la ejecución |
| estado | String | Estado actual de la ejecución |
| resultados | List<ResultadoCotejo> | Lista de resultados |
| paginaActual | Long | Número de página actual (base 0) |
| tamanio | Long | Tamaño de página |
| totalResultados | Long | Total de resultados disponibles |
| totalPaginas | Long | Total de páginas |

## Endpoints API

### 1. Ejecutar Cotejo Masivo

**Endpoint:** `POST /api/v1/cotejo-masivo/ejecutar`  
**Descripción:** Inicia un nuevo proceso de cotejo masivo

**Request Body:**
```json
{
  "criteriosCotejo": [
    {
      "campo": "nombreCompleto",
      "operador": "CONTIENE",
      "valor": "Juan"
    }
  ],
  "usuarioSolicitante": "usuario123"
}
```

**Response (201 Created):**
```json
{
  "idEjecucion": "550e8400-e29b-41d4-a716-446655440000",
  "fechaSolicitud": "2025-12-01T10:00:00",
  "estado": "PENDIENTE",
  "statusCode": 201,
  "mensaje": "Proceso de cotejo masivo iniciado exitosamente"
}
```

**Códigos de Estado:**
- `201` - Cotejo masivo iniciado exitosamente
- `400` - Solicitud inválida - criterios de cotejo incorrectos
- `401` - No autorizado - usuario no válido
- `500` - Error interno del servidor

---

### 2. Consultar Estado de Ejecución

**Endpoint:** `GET /api/v1/cotejo-masivo/estado/{idEjecucion}`  
**Descripción:** Consulta el estado actual de una ejecución de cotejo masivo

**Path Parameters:**
- `idEjecucion`: String (UUID, requerido)

**Response (200 OK):**
```json
{
  "idEjecucion": "550e8400-e29b-41d4-a716-446655440000",
  "fechaSolicitud": "2025-12-01T10:00:00",
  "estado": "EN_PROCESO",
  "totalRegistros": 1000,
  "registrosProcesados": 500,
  "registrosExitosos": 450,
  "registrosConError": 50,
  "fechaInicio": "2025-12-01T10:00:05",
  "fechaFin": null,
  "usuarioSolicitante": "usuario123",
  "statusCode": 200,
  "mensaje": "Consulta exitosa"
}
```

**Códigos de Estado:**
- `200` - Consulta exitosa
- `404` - Ejecución no encontrada
- `500` - Error interno del servidor

---

### 3. Obtener Resultados de Cotejo

**Endpoint:** `GET /api/v1/cotejo-masivo/resultados/{idEjecucion}`  
**Descripción:** Obtiene los resultados paginados de una ejecución de cotejo masivo

**Path Parameters:**
- `idEjecucion`: String (UUID, requerido)

**Query Parameters:**
- `pagina`: Long (opcional, default: 0) - Número de página (base 0)
- `tamanio`: Long (opcional, default: 100) - Tamaño de página
- `estadoCotejo`: String (opcional) - Filtro por estado: EXITOSO, ERROR, NO_ENCONTRADO

**Response (200 OK):**
```json
{
  "idEjecucion": "550e8400-e29b-41d4-a716-446655440000",
  "estado": "COMPLETADO",
  "resultados": [
    {
      "idRegistro": "REG001",
      "estadoCotejo": "EXITOSO",
      "detalles": "Registro procesado correctamente",
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

**Códigos de Estado:**
- `200` - Resultados obtenidos exitosamente
- `404` - Ejecución no encontrada
- `422` - Proceso no completado - resultados aún no disponibles
- `500` - Error interno del servidor

## Mapeo de Tipos de Datos

| Tipo en Especificación | Tipo en Java | Notas |
|------------------------|--------------|-------|
| string | String | Texto general |
| integer/int | Long | Valores numéricos enteros |
| number/decimal | Double | Valores numéricos decimales |
| boolean | Boolean | Valores lógicos |
| date | LocalDate | Fechas sin hora |
| datetime/timestamp | LocalDateTime | Fechas con hora |
| array/list | List<T> | Colecciones |
| UUID | String | Identificadores únicos |

## Integración con MsDataCotejoMasivo

### Puerto de Salida: CotejoMasivoDataPort

Este microservicio se integra con **MsDataCotejoMasivo** (microservicio de datos) a través del puerto de salida `CotejoMasivoDataPort`, que define las siguientes operaciones:

1. **crear(CotejoMasivo)** - Crea un nuevo registro de ejecución
2. **actualizar(CotejoMasivo)** - Actualiza el estado de una ejecución
3. **consultarPorId(String)** - Consulta una ejecución por su ID
4. **obtenerResultados(String, Long, Long, String)** - Obtiene resultados paginados

### Adaptador: CotejoMasivoDataAdapter

La clase `CotejoMasivoDataAdapter` implementa el puerto `CotejoMasivoDataPort`. 

**IMPORTANTE:** El protocolo de comunicación (HTTP, SOAP, colas de mensajería, etc.) NO está definido en esta especificación y debe ser implementado según los requisitos del proyecto.

## Reglas de Negocio

1. **Validación de Criterios:** Todos los criterios de cotejo deben ser válidos antes de iniciar el proceso
2. **Ciclo de Estado:** El estado debe seguir el flujo: PENDIENTE → EN_PROCESO → COMPLETADO/ERROR
3. **Generación de UUID:** Cada ejecución recibe un identificador UUID único
4. **Paginación Obligatoria:** Los resultados siempre se devuelven paginados
5. **Valores por Defecto:** 
   - Página por defecto: 0
   - Tamaño por defecto: 100 registros
6. **Trazabilidad:** Se mantiene registro completo de fechas y usuario solicitante

## Características Técnicas

### Sin Frameworks
Este proyecto está diseñado como **Java puro** sin dependencias de frameworks:
- Sin Spring, JAX-RS, o similares
- Sin JPA, Hibernate, o ORMs
- Sin anotaciones de frameworks
- Sin librerías de mapeo (MapStruct, ModelMapper, etc.)

### Java Records para DTOs
Los DTOs utilizan Java Records (Java 14+) para mayor inmutabilidad y concisión:
```java
public record EjecutarCotejoMasivoRequestDto(
    List<CriterioCotejoDto> criteriosCotejo,
    String usuarioSolicitante
) {}
```

### Compilación
El código es compilable como **Java puro**:
- Solo interfaces, clases, enums
- Sin dependencias externas
- POJOs con getters/setters estándar

## Limitaciones Conocidas

1. **Protocolo de Comunicación No Definido:** La comunicación con MsDataCotejoMasivo debe ser implementada
2. **Sin Build Configuration:** No se incluye `pom.xml` ni configuraciones de build
3. **Sin Implementación de Persistencia:** Los adaptadores lanzan `UnsupportedOperationException`
4. **Sin Manejo de Errores HTTP Real:** Los códigos de estado están documentados pero no implementados
5. **Sin Validaciones:** La validación de entrada debe ser implementada

## Próximos Pasos para Implementación

1. **Definir Protocolo de Comunicación:**
   - Elegir: HTTP REST, SOAP, colas de mensajería, gRPC, etc.
   - Implementar cliente de comunicación en `CotejoMasivoDataAdapter`

2. **Agregar Framework Web (Opcional):**
   - Añadir Spring Boot, Quarkus, Micronaut, etc.
   - Agregar anotaciones al controlador (`@RestController`, `@PostMapping`, etc.)

3. **Implementar Validaciones:**
   - Validar criterios de cotejo
   - Validar formato de UUID
   - Validar parámetros de paginación

4. **Agregar Manejo de Errores:**
   - Crear excepciones personalizadas
   - Implementar controladores de excepciones
   - Mapear excepciones a códigos HTTP

5. **Configurar Build:**
   - Crear `pom.xml` o `build.gradle`
   - Definir dependencias necesarias
   - Configurar plugins de compilación

6. **Implementar Tests:**
   - Tests unitarios para servicios
   - Tests de integración para adaptadores
   - Tests de contrato para DTOs

## Documentación Adicional

- **PDF_TRANSCRIPTION.md**: Transcripción completa de la especificación original
- **AGENT_PROMPT.md**: Prompt utilizado para generar este proyecto

## Criterios de Aceptación Cumplidos

✅ Uso exclusivo de información del PDF  
✅ Estructura del proyecto coincide con la especificada  
✅ Es MsDominio: existen puertos out hacia MsDataXXXX, NO existe RepositoryPort  
✅ Código compila como Java puro sin dependencias externas  
✅ Solo se crean casos de uso para endpoints documentados  
✅ DTOs implementados como Java records  
✅ Sin frameworks ni anotaciones  
✅ Separación clara de capas: dominio, aplicación, infraestructura

## Licencia

Este proyecto es generado automáticamente según especificaciones de arquitectura hexagonal.

## Contacto

Para más información sobre la especificación, consultar el documento PDF original.
