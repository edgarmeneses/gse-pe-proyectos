# MsDominioPaquetes - Microservicio de Dominio de Paquetes Electorales

## Descripción General

Microservicio de dominio que gestiona la lógica de negocio de paquetes electorales, implementado bajo arquitectura hexagonal sin frameworks. Este microservicio coordina las operaciones de consulta, aprobación y confirmación de paquetes electorales, delegando las operaciones de datos al microservicio **MsDatosElectoral**.

**Versión API**: 1.0  
**Arquitectura**: Hexagonal (Ports and Adapters)  
**Patrón**: Domain-Driven Design (DDD)  
**Tipo**: MsDominio (sin persistencia directa)

## Características Principales

- ✅ **Arquitectura Hexagonal**: Separación estricta entre dominio, aplicación e infraestructura
- ✅ **Sin Frameworks**: Implementación pura en Java (POJOs), sin Spring, JPA, JAX-RS, etc.
- ✅ **Domain-Driven Design**: Agregados, entidades, objetos de valor y puertos claramente definidos
- ✅ **Integración con MsDatosElectoral**: Conexión a través de puertos OUT con el microservicio de datos
- ✅ **API REST**: 3 endpoints para gestión completa de paquetes electorales
- ✅ **Validaciones de Negocio**: Integridad de datos, estados, aprobaciones y confirmaciones

## Estructura del Proyecto

```
MsDominioPaquetes/
├── src/main/java/pe/gob/onpe/dominio/paquetes/
│   ├── domain/                          # Capa de Dominio (núcleo de negocio)
│   │   ├── model/                       # Modelos de dominio (12 clases)
│   │   │   ├── PaqueteElectoral.java
│   │   │   ├── Ubicacion.java
│   │   │   ├── InformacionPublicacion.java
│   │   │   ├── Aprobacion.java
│   │   │   ├── Trazabilidad.java
│   │   │   ├── ResumenPaquetes.java
│   │   │   ├── Paginacion.java
│   │   │   ├── Confirmacion.java
│   │   │   ├── SiguientePaso.java
│   │   │   ├── ResultadoConsultaPaquetes.java
│   │   │   ├── ResultadoAprobacionPaquete.java
│   │   │   └── ResultadoConfirmacionRevision.java
│   │   └── ports/                       # Puertos (interfaces)
│   │       ├── in/                      # Puertos de entrada (3 use cases)
│   │       │   ├── ConsultarPaquetesUseCase.java
│   │       │   ├── AprobarPaqueteUseCase.java
│   │       │   └── ConfirmarRevisionPaquetesUseCase.java
│   │       └── out/                     # Puertos de salida (2 data ports)
│   │           ├── PaqueteElectoralDataPort.java
│   │           └── PadronElectoralDataPort.java
│   ├── application/                     # Capa de Aplicación (servicios)
│   │   └── service/
│   │       ├── ConsultarPaquetesService.java
│   │       ├── AprobarPaqueteService.java
│   │       └── ConfirmarRevisionPaquetesService.java
│   └── infrastructure/                  # Capa de Infraestructura (adaptadores)
│       └── adapters/
│           ├── in/rest/                 # Adaptadores de entrada (REST)
│           │   ├── controller/
│           │   │   └── PaquetesElectoralesController.java
│           │   ├── dto/                 # DTOs (17 clases)
│           │   │   ├── ConsultarPaquetesRequestDto.java
│           │   │   ├── ConsultarPaquetesResponseDto.java
│           │   │   ├── AprobarPaqueteRequestDto.java
│           │   │   ├── AprobarPaqueteResponseDto.java
│           │   │   ├── ConfirmarRevisionRequestDto.java
│           │   │   ├── ConfirmarRevisionResponseDto.java
│           │   │   ├── PaqueteElectoralDto.java
│           │   │   ├── UbicacionDto.java
│           │   │   ├── InformacionPublicacionDto.java
│           │   │   ├── AprobacionDto.java
│           │   │   ├── ConfirmacionDto.java
│           │   │   ├── TrazabilidadDto.java
│           │   │   ├── ResumenPaquetesDto.java
│           │   │   ├── PaginacionDto.java
│           │   │   ├── MetadataDto.java
│           │   │   └── SiguientePasoDto.java
│           │   └── mapper/
│           │       └── PaqueteElectoralDtoMapper.java
│           └── out/msdata/client/       # Adaptadores de salida (MsData)
│               ├── PaqueteElectoralDataAdapter.java
│               └── PadronElectoralDataAdapter.java
├── ANALISIS_PDF_MsDominioPaquetes.md    # Especificación extraída del PDF
└── README.md                            # Este archivo
```

## API REST - Endpoints

### 1. Consultar Paquetes Electorales

**Endpoint**: `GET /api/v1/electoral/paquetes/MsDominioPaquetes`

**Descripción**: Consulta paquetes electorales con filtros avanzados y paginación.

**Parámetros de Consulta**:
- `idPadron` (String, opcional): Identificador del padrón electoral
- `tipoPadron` (String, opcional): Tipo de padrón (DEFINITIVO, PROVISIONAL, COMPLEMENTARIO)
- `codigoDepartamento` (String, opcional): Código del departamento (2 dígitos)
- `codigoProvincia` (String, opcional): Código de la provincia (4 dígitos)
- `codigoDistrito` (String, opcional): Código del distrito (6 dígitos)
- `estadoPaquete` (String, opcional): Estado del paquete (GENERADO, EN_REVISION, APROBADO, PUBLICADO)
- `paginaActual` (Integer, opcional, default=1): Número de página
- `registrosPorPagina` (Integer, opcional, default=10): Registros por página

**Respuesta Exitosa (200)**:
```json
{
  "success": true,
  "data": {
    "paquetes": [
      {
        "paqueteId": "PKG-2024-LIMA-001",
        "codigoPaquete": "LIMA-01-01-2024",
        "idPadron": "PADRON-2024-001",
        "tipoPadron": "DEFINITIVO",
        "codigoCronogramaElectoral": "CRON-ERM-2024",
        "tipoProcesoElectoral": "ELECCIONES_REGIONALES_MUNICIPALES",
        "ubicacion": {
          "codigoDepartamento": "15",
          "nombreDepartamento": "LIMA",
          "codigoProvincia": "1501",
          "nombreProvincia": "LIMA",
          "codigoDistrito": "150101",
          "nombreDistrito": "LIMA",
          "ubigeo": "150101"
        },
        "estadoPaquete": "APROBADO",
        "fechaGeneracion": "2024-01-15T10:30:00",
        "fechaUltimaActualizacion": "2024-01-20T14:45:00",
        "usuarioUltimaActualizacion": "admin.electoral",
        "totalCiudadanos": 15432,
        "totalImagenes": 15432,
        "tamanioArchivoPDF": 125896700,
        "tamanioArchivoDatos": 2048576,
        "hashIntegridad": "SHA256:a1b2c3d4e5f6...",
        "rutaArchivoPDF": "/storage/paquetes/2024/LIMA-01-01-2024.pdf",
        "rutaArchivoDatos": "/storage/paquetes/2024/LIMA-01-01-2024.dat",
        "rutaArchivoImagenes": "/storage/imagenes/2024/LIMA-01-01-2024/",
        "informacionPublicacion": {
          "fechaPublicacion": "2024-01-22T08:00:00",
          "lugarPublicacion": "Portal Institucional ONPE",
          "observaciones": "Publicado según cronograma electoral"
        },
        "aprobacion": {
          "aprobado": true,
          "fechaAprobacion": "2024-01-20T14:45:00",
          "usuarioAprobacion": "supervisor.onpe",
          "comentarioAprobacion": "Paquete aprobado tras verificación de integridad"
        }
      }
    ],
    "resumen": {
      "totalPaquetes": 1845,
      "paquetesAprobados": 1520,
      "paquetesPendientes": 250,
      "paquetesEnRevision": 75,
      "porcentajeAvance": 82.38,
      "porcentajeAprobacion": 92.68
    },
    "paginacion": {
      "totalRegistros": 1845,
      "totalPaginas": 185,
      "paginaActual": 1,
      "registrosPorPagina": 10,
      "tieneAnterior": false,
      "tieneSiguiente": true
    }
  },
  "metadata": {
    "timestamp": "2024-01-25T16:30:45",
    "version": "1.0"
  }
}
```

---

### 2. Aprobar Paquete Electoral

**Endpoint**: `PUT /api/v1/electoral/paquetes/MsDominioPaquetes/{paqueteId}/aprobar`

**Descripción**: Aprueba un paquete electoral específico tras validar su integridad.

**Parámetros de Ruta**:
- `paqueteId` (String, requerido): Identificador único del paquete

**Cuerpo de Solicitud**:
```json
{
  "informacionPublicacion": {
    "fechaPublicacion": "2024-02-01T08:00:00",
    "lugarPublicacion": "Portal Institucional ONPE",
    "observaciones": "Publicación programada según cronograma"
  },
  "comentario": "Paquete verificado y aprobado para publicación",
  "confirmarIntegridad": true
}
```

**Respuesta Exitosa (200)**:
```json
{
  "success": true,
  "data": {
    "paqueteId": "PKG-2024-LIMA-001",
    "codigoPaquete": "LIMA-01-01-2024",
    "estadoAnterior": "EN_REVISION",
    "estadoActual": "APROBADO",
    "aprobacion": {
      "aprobado": true,
      "fechaAprobacion": "2024-01-25T16:45:30",
      "usuarioAprobacion": "supervisor.onpe",
      "comentarioAprobacion": "Paquete verificado y aprobado para publicación"
    },
    "informacionPublicacion": {
      "fechaPublicacion": "2024-02-01T08:00:00",
      "lugarPublicacion": "Portal Institucional ONPE",
      "observaciones": "Publicación programada según cronograma"
    },
    "trazabilidad": {
      "accion": "APROBACION_PAQUETE",
      "fechaAccion": "2024-01-25T16:45:30",
      "usuarioAccion": "supervisor.onpe",
      "ipOrigen": "192.168.1.100",
      "detalleAccion": "Aprobación de paquete PKG-2024-LIMA-001 con confirmación de integridad"
    }
  },
  "metadata": {
    "timestamp": "2024-01-25T16:45:30",
    "version": "1.0"
  }
}
```

**Validaciones**:
- ✅ El parámetro `confirmarIntegridad` debe ser `true`
- ✅ El paquete debe existir
- ✅ El paquete no puede estar ya en estado APROBADO

---

### 3. Confirmar Revisión de Paquetes del Padrón

**Endpoint**: `PUT /api/v1/electoral/paquetes/MsDominioPaquetes/padron/{idPadron}/confirmar-revision`

**Descripción**: Confirma que todos los paquetes de un padrón han sido revisados y aprobados.

**Parámetros de Ruta**:
- `idPadron` (String, requerido): Identificador del padrón electoral

**Cuerpo de Solicitud**:
```json
{
  "tipoPadron": "DEFINITIVO",
  "comentario": "Todos los paquetes del padrón han sido verificados y aprobados",
  "confirmarRevisionCompleta": true
}
```

**Respuesta Exitosa (200)**:
```json
{
  "success": true,
  "data": {
    "idPadron": "PADRON-2024-001",
    "tipoPadron": "DEFINITIVO",
    "codigoCronogramaElectoral": "CRON-ERM-2024",
    "estadoRevisionAnterior": "EN_REVISION",
    "estadoRevisionActual": "REVISION_COMPLETADA",
    "confirmacion": {
      "confirmado": true,
      "fechaConfirmacion": "2024-01-25T17:00:00",
      "usuarioConfirmacion": "coordinador.onpe",
      "comentarioConfirmacion": "Todos los paquetes del padrón han sido verificados y aprobados"
    },
    "resumenPaquetes": {
      "totalPaquetes": 250,
      "paquetesAprobados": 250,
      "paquetesPendientes": 0,
      "paquetesEnRevision": 0,
      "porcentajeAvance": 100.0,
      "porcentajeAprobacion": 100.0
    },
    "siguientePaso": {
      "accion": "PUBLICAR_PADRON",
      "descripcion": "Proceder con la publicación oficial del padrón electoral",
      "plantillaSugerida": "publicacion-padron-definitivo-2024"
    },
    "trazabilidad": {
      "accion": "CONFIRMACION_REVISION_PADRON",
      "fechaAccion": "2024-01-25T17:00:00",
      "usuarioAccion": "coordinador.onpe",
      "ipOrigen": "192.168.1.105",
      "detalleAccion": "Confirmación de revisión completa del padrón PADRON-2024-001"
    }
  },
  "metadata": {
    "timestamp": "2024-01-25T17:00:00",
    "version": "1.0"
  }
}
```

**Validaciones**:
- ✅ El parámetro `confirmarRevisionCompleta` debe ser `true`
- ✅ Todos los paquetes del padrón deben estar APROBADOS
- ✅ El padrón debe existir

---

## Modelos de Dominio

### Entidades Principales

#### 1. PaqueteElectoral
Agregado raíz que representa un paquete electoral con toda su información.

**Atributos** (21 campos):
- `paqueteId`: Identificador único
- `codigoPaquete`: Código del paquete
- `idPadron`: Identificador del padrón
- `tipoPadron`: Tipo de padrón
- `codigoCronogramaElectoral`: Código del cronograma
- `tipoProcesoElectoral`: Tipo de proceso
- `ubicacion`: Ubicación geográfica (Value Object)
- `estadoPaquete`: Estado actual
- `fechaGeneracion`: Fecha de creación
- `fechaUltimaActualizacion`: Última modificación
- `usuarioUltimaActualizacion`: Usuario que modificó
- `totalCiudadanos`: Cantidad de ciudadanos
- `totalImagenes`: Cantidad de imágenes
- `tamanioArchivoPDF`: Tamaño del PDF en bytes
- `tamanioArchivoDatos`: Tamaño del archivo de datos
- `hashIntegridad`: Hash para validación
- `rutaArchivoPDF`: Ruta del PDF
- `rutaArchivoDatos`: Ruta del archivo de datos
- `rutaArchivoImagenes`: Ruta de imágenes
- `informacionPublicacion`: Info de publicación (Value Object)
- `aprobacion`: Información de aprobación (Value Object)

#### 2. ResultadoConsultaPaquetes
Agregado que encapsula los resultados de consulta con paginación.

**Atributos**:
- `paquetes`: Lista de PaqueteElectoral
- `resumen`: ResumenPaquetes (estadísticas)
- `paginacion`: Paginacion (info de páginas)

#### 3. ResultadoAprobacionPaquete
Agregado que representa el resultado de una aprobación.

**Atributos**:
- `paqueteId`: Identificador del paquete
- `codigoPaquete`: Código del paquete
- `estadoAnterior`: Estado previo
- `estadoActual`: Estado actual
- `aprobacion`: Aprobacion (detalles)
- `informacionPublicacion`: InformacionPublicacion
- `trazabilidad`: Trazabilidad (auditoría)

#### 4. ResultadoConfirmacionRevision
Agregado que representa el resultado de confirmación de revisión.

**Atributos**:
- `idPadron`: Identificador del padrón
- `tipoPadron`: Tipo de padrón
- `codigoCronogramaElectoral`: Cronograma
- `estadoRevisionAnterior`: Estado previo
- `estadoRevisionActual`: Estado actual
- `confirmacion`: Confirmacion (detalles)
- `resumenPaquetes`: ResumenPaquetes
- `siguientePaso`: SiguientePaso (siguiente acción)
- `trazabilidad`: Trazabilidad

### Objetos de Valor (Value Objects)

#### Ubicacion
- `codigoDepartamento`, `nombreDepartamento`
- `codigoProvincia`, `nombreProvincia`
- `codigoDistrito`, `nombreDistrito`
- `ubigeo`

#### InformacionPublicacion
- `fechaPublicacion`
- `lugarPublicacion`
- `observaciones`

#### Aprobacion
- `aprobado`
- `fechaAprobacion`
- `usuarioAprobacion`
- `comentarioAprobacion`

#### Confirmacion
- `confirmado`
- `fechaConfirmacion`
- `usuarioConfirmacion`
- `comentarioConfirmacion`

#### Trazabilidad
- `accion`
- `fechaAccion`
- `usuarioAccion`
- `ipOrigen`
- `detalleAccion`

#### ResumenPaquetes
- `totalPaquetes`
- `paquetesAprobados`
- `paquetesPendientes`
- `paquetesEnRevision`
- `porcentajeAvance`
- `porcentajeAprobacion`

#### Paginacion
- `totalRegistros`
- `totalPaginas`
- `paginaActual`
- `registrosPorPagina`
- `tieneAnterior`
- `tieneSiguiente`

#### SiguientePaso
- `accion`
- `descripcion`
- `plantillaSugerida`

---

## Casos de Uso (Puertos IN)

### 1. ConsultarPaquetesUseCase
```java
ResultadoConsultaPaquetes consultar(
    String idPadron,
    String tipoPadron,
    String codigoDepartamento,
    String codigoProvincia,
    String codigoDistrito,
    String estadoPaquete,
    Integer paginaActual,
    Integer registrosPorPagina
);
```

### 2. AprobarPaqueteUseCase
```java
ResultadoAprobacionPaquete aprobar(
    String paqueteId,
    InformacionPublicacion informacionPublicacion,
    String comentario,
    Boolean confirmarIntegridad
);
```

### 3. ConfirmarRevisionPaquetesUseCase
```java
ResultadoConfirmacionRevision confirmarRevision(
    String idPadron,
    String tipoPadron,
    String comentario,
    Boolean confirmarRevisionCompleta
);
```

---

## Puertos de Salida (Puertos OUT)

### 1. PaqueteElectoralDataPort
Conexión con **MsDatosElectoral** para operaciones de paquetes.

**Métodos**:
```java
List<PaqueteElectoral> consultarPaquetes(...);  // → PaqueteElectoralController.consultarPaquetes
PaqueteElectoral obtenerPorId(String paqueteId);  // → PaqueteElectoralController.obtenerPaquetePorId
void actualizarEstado(...);  // → ActualizarPaqueteElectoralService
void registrarTrazabilidad(Trazabilidad trazabilidad);
```

### 2. PadronElectoralDataPort
Conexión con **MsDatosElectoral** para operaciones de padrón.

**Métodos**:
```java
ResumenPaquetes obtenerResumenPaquetes(String idPadron);
void actualizarEstadoRevision(...);
Map<String, Object> obtenerCronogramaElectoral(String codigoCronograma);
```

---

## Servicios de Aplicación

### 1. ConsultarPaquetesService
- Implementa: `ConsultarPaquetesUseCase`
- Delega a: `PaqueteElectoralDataPort.consultarPaquetes()`

### 2. AprobarPaqueteService
- Implementa: `AprobarPaqueteUseCase`
- Lógica de negocio:
  - Valida `confirmarIntegridad = true`
  - Obtiene paquete por ID
  - Valida estado (no debe estar APROBADO)
  - Actualiza estado a APROBADO
  - Registra trazabilidad
  - Construye resultado con aprobación y publicación

### 3. ConfirmarRevisionPaquetesService
- Implementa: `ConfirmarRevisionPaquetesUseCase`
- Lógica de negocio:
  - Valida `confirmarRevisionCompleta = true`
  - Obtiene resumen de paquetes del padrón
  - Valida que todos estén aprobados (100%)
  - Actualiza estado de revisión del padrón
  - Obtiene cronograma electoral
  - Registra trazabilidad
  - Sugiere siguiente paso (PUBLICAR_PADRON)

---

## Adaptadores de Infraestructura

### Adaptadores de Entrada (REST)

#### PaquetesElectoralesController
Controlador REST sin anotaciones que expone los 3 endpoints.

**Métodos**:
- `consultarPaquetes(...)` → GET
- `aprobarPaquete(paqueteId, request)` → PUT
- `confirmarRevision(idPadron, request)` → PUT

#### PaqueteElectoralDtoMapper
Mapper estático para conversión bidireccional entre modelos de dominio y DTOs.

**Métodos principales**:
- `toConsultarPaquetesResponseDto(ResultadoConsultaPaquetes)`
- `toAprobarPaqueteResponseDto(ResultadoAprobacionPaquete)`
- `toConfirmarRevisionResponseDto(ResultadoConfirmacionRevision)`
- `toPaqueteElectoralDto(PaqueteElectoral)`
- `toInformacionPublicacionDomain(InformacionPublicacionDto)`
- Métodos auxiliares para value objects

### Adaptadores de Salida (MsData Clients)

#### PaqueteElectoralDataAdapter
Implementa `PaqueteElectoralDataPort`. Estado actual: stubs que lanzan `UnsupportedOperationException` con mensaje indicando la conexión pendiente con MsDatosElectoral.

#### PadronElectoralDataAdapter
Implementa `PadronElectoralDataPort`. Estado actual: stubs que lanzan `UnsupportedOperationException` con mensaje indicando la operación pendiente.

---

## Integración con MsDatosElectoral

Este microservicio **NO** tiene persistencia propia. Todas las operaciones de datos se delegan a **MsDatosElectoral** a través de los puertos OUT:

| Puerto OUT | Adaptador | Endpoint MsDatosElectoral |
|-----------|-----------|---------------------------|
| `PaqueteElectoralDataPort.consultarPaquetes()` | `PaqueteElectoralDataAdapter` | `PaqueteElectoralController.consultarPaquetes()` |
| `PaqueteElectoralDataPort.obtenerPorId()` | `PaqueteElectoralDataAdapter` | `PaqueteElectoralController.obtenerPaquetePorId()` |
| `PaqueteElectoralDataPort.actualizarEstado()` | `PaqueteElectoralDataAdapter` | `ActualizarPaqueteElectoralService.actualizarEstado()` |
| `PadronElectoralDataPort.obtenerResumenPaquetes()` | `PadronElectoralDataAdapter` | Operación en MsDatosElectoral |
| `PadronElectoralDataPort.actualizarEstadoRevision()` | `PadronElectoralDataAdapter` | Operación en MsDatosElectoral |
| `PadronElectoralDataPort.obtenerCronogramaElectoral()` | `PadronElectoralDataAdapter` | Operación en MsDatosElectoral |

**Nota**: Los adaptadores actualmente tienen implementaciones stub. Requieren desarrollo para conectar con MsDatosElectoral mediante cliente HTTP, gRPC, o el protocolo elegido.

---

## Principios de Diseño

### Arquitectura Hexagonal
- **Capa de Dominio**: Lógica de negocio pura, independiente de frameworks
- **Capa de Aplicación**: Orquestación de casos de uso
- **Capa de Infraestructura**: Detalles técnicos (REST, clientes HTTP, etc.)

### Sin Frameworks
- ✅ Java puro (POJOs)
- ✅ Sin anotaciones (@RestController, @Service, @Entity, etc.)
- ✅ Sin dependencias externas de frameworks
- ✅ Compilable como Java estándar

### Domain-Driven Design
- ✅ Agregados claramente definidos
- ✅ Objetos de valor inmutables (Value Objects)
- ✅ Puertos (interfaces) para abstraer dependencias
- ✅ Lenguaje ubicuo del dominio electoral

### Separación de Responsabilidades
- **MsDominioPaquetes**: Lógica de negocio, validaciones, orquestación
- **MsDatosElectoral**: Persistencia, consultas, operaciones CRUD

---

## Próximos Pasos

### Implementación Pendiente

1. **Implementar Adaptadores de Salida**:
   - Desarrollar cliente HTTP/gRPC para conectar con MsDatosElectoral
   - Implementar métodos en `PaqueteElectoralDataAdapter`
   - Implementar métodos en `PadronElectoralDataAdapter`
   - Configurar endpoints y credenciales

2. **Manejo de Errores**:
   - Definir excepciones de dominio personalizadas
   - Implementar DTOs de error (ErrorResponseDto)
   - Agregar códigos de error estándar
   - Implementar try-catch en servicios y controladores

3. **Validaciones Adicionales**:
   - Validaciones de formato de parámetros
   - Validaciones de reglas de negocio adicionales
   - Validaciones de permisos/autorizaciones

4. **Testing**:
   - Tests unitarios de servicios de aplicación
   - Tests de mappers
   - Tests de integración con mocks de adaptadores
   - Tests de contrato con MsDatosElectoral

5. **Integración con Framework REST**:
   - Configurar Spring Boot (si se decide usar framework)
   - Agregar anotaciones REST (@RestController, @GetMapping, etc.)
   - Configurar serialización JSON (Jackson)
   - Configurar CORS y seguridad

6. **Documentación API**:
   - Generar especificación OpenAPI/Swagger
   - Documentar códigos de error
   - Ejemplos de curl/Postman

---

## Documentación de Referencia

- **ANALISIS_PDF_MsDominioPaquetes.md**: Especificación completa extraída del PDF oficial (1000 líneas)
- **Microservicio MsDominioPaquetes V1.0.pdf**: Documento original de especificación

---

## Contacto y Soporte

**Proyecto**: Sistema Electoral - ONPE  
**Módulo**: Gestión de Paquetes Electorales  
**Tipo**: Microservicio de Dominio (MsDominio)  
**Versión**: 1.0  
