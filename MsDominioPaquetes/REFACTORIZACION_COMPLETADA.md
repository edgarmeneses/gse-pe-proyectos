# Refactorización de Arquitectura Hexagonal - Completada

## Resumen Ejecutivo

Se ha completado exitosamente la refactorización del microservicio **MsDominioPaquetes** para implementar una arquitectura hexagonal estricta donde:

- ✅ **Dominio puro**: Solo contiene conceptos de negocio electoral
- ✅ **Use Cases retornan entidades de dominio**: Sin DTOs ni objetos técnicos
- ✅ **DTOs en la infraestructura**: Todos los objetos de respuesta están en la capa de infraestructura
- ✅ **Separación clara de responsabilidades**: Cada capa cumple su propósito arquitectónico

---

## Cambios Realizados

### 1. Limpieza del Modelo de Dominio

#### Antes
El modelo de dominio contenía clases técnicas y de presentación:
- `Paginacion` (concepto técnico de UI)
- `ResultadoConsultaPaquetes`, `ResultadoAprobacionPaquete`, `ResultadoConfirmacionRevision` (objetos de respuesta)
- `SiguientePaso`, `Trazabilidad` (metadatos operacionales)
- `InformacionPublicacion` (metadatos administrativos)
- `ResumenPaquetes` (cálculos/estadísticas)

#### Después
El dominio contiene **SOLO 4 clases** que representan conceptos del negocio electoral:

```
domain/
  model/
    ├── PaqueteElectoral.java      ← Entidad principal del dominio
    ├── Ubicacion.java              ← Value Object geográfico
    ├── Aprobacion.java             ← Proceso de negocio
    └── Confirmacion.java           ← Proceso de negocio
```

**PaqueteElectoral** fue limpiado, eliminando:
- `rutaArchivoPDF` (detalle técnico de almacenamiento)
- `tamanioArchivoDatos` (detalle técnico)
- `informacionPublicacion` (metadatos administrativos)

---

### 2. Reubicación de Objetos de Respuesta

Todos los objetos de respuesta fueron movidos de `application/result/` a `infrastructure/adapters/in/rest/response/`:

```
infrastructure/
  adapters/
    in/
      rest/
        response/
          ├── ResultadoConsultaPaquetes.java
          ├── ResultadoAprobacionPaquete.java
          ├── ResultadoConfirmacionRevision.java
          ├── InformacionPaginacion.java
          ├── InformacionTrazabilidad.java
          ├── InformacionSiguientePaso.java
          ├── InformacionPublicacion.java
          └── ResumenPaquetes.java
```

**Justificación arquitectónica**: Estos objetos son específicos del adapter REST y no deben contaminar la capa de aplicación. Cada adapter puede tener sus propios formatos de respuesta.

---

### 3. Actualización de Use Cases (Puertos de Entrada)

Los Use Cases ahora retornan **entidades de dominio puras**:

#### ConsultarPaquetesUseCase
```java
public interface ConsultarPaquetesUseCase {
    List<PaqueteElectoral> ejecutar(String idPadron, String tipoPadron, String estadoPaquete, 
                                     String codigoCronogramaElectoral, Integer pagina, 
                                     Integer registrosPorPagina);
}
```

#### AprobarPaqueteUseCase
```java
public interface AprobarPaqueteUseCase {
    PaqueteElectoral ejecutar(String paqueteId, String usuarioAprobacion, String comentario,
                              LocalDateTime fechaPublicacion, String lugarPublicacion, 
                              String observaciones);
}
```

#### ConfirmarRevisionPaquetesUseCase
```java
public interface ConfirmarRevisionPaquetesUseCase {
    void ejecutar(String idPadron, String tipoPadron, String usuarioConfirmacion, 
                  String comentario);
}
```

**Beneficio**: Los Use Cases son reutilizables desde cualquier adapter (REST, GraphQL, CLI, eventos, etc.) sin cambios.

---

### 4. Reescritura de Services (Implementación de Use Cases)

Los servicios de aplicación fueron reescritos para trabajar exclusivamente con entidades de dominio:

#### ConsultarPaquetesService
- Delega la consulta al `PaqueteElectoralDataPort`
- Retorna `List<PaqueteElectoral>` directamente
- No construye objetos de respuesta

#### AprobarPaqueteService
- Recibe parámetros primitivos en lugar de `InformacionPublicacion`
- Actualiza el estado del paquete usando lógica de dominio
- Retorna `PaqueteElectoral` con el nuevo estado

#### ConfirmarRevisionPaquetesService
- Valida la regla de negocio: "todos los paquetes deben estar aprobados"
- Usa los data ports para contar paquetes
- Retorna `void` (operación de comando sin resultado)

---

### 5. Actualización de Data Ports (Puertos de Salida)

Los data ports fueron actualizados para trabajar con el dominio:

#### PaqueteElectoralDataPort
```java
public interface PaqueteElectoralDataPort {
    List<PaqueteElectoral> consultarPaquetes(String idPadron, String tipoPadron, 
                                             String estadoPaquete, String codigoCronogramaElectoral, 
                                             Integer pagina, Integer registrosPorPagina);
    
    PaqueteElectoral guardarPaquete(PaqueteElectoral paquete);
    
    PaqueteElectoral buscarPorId(String paqueteId);
}
```

#### PadronElectoralDataPort
```java
public interface PadronElectoralDataPort {
    Integer contarPaquetesPorPadron(String idPadron, String tipoPadron);
    
    Integer contarPaquetesAprobadosPorPadron(String idPadron, String tipoPadron);
}
```

---

### 6. Refactorización del Controller

El **PaquetesElectoralesController** fue reescrito para:

1. **Recibir entidades de dominio** de los Use Cases
2. **Delegar la construcción de DTOs** al mapper
3. **Calcular datos técnicos** (paginación, resumen) en la infraestructura

#### Ejemplo: Consultar Paquetes
```java
@PostMapping("/consultar")
public ResponseEntity<ConsultarPaquetesResponseDto> consultarPaquetes(
        @RequestBody ConsultarPaquetesRequestDto request) {
    
    // 1. Llamar al Use Case (retorna dominio puro)
    List<PaqueteElectoral> paquetes = consultarPaquetesUseCase.ejecutar(
        request.getIdPadron(),
        request.getTipoPadron(),
        request.getEstadoPaquete(),
        request.getCodigoCronogramaElectoral(),
        request.getPagina(),
        request.getRegistrosPorPagina()
    );
    
    // 2. Convertir a DTO en la infraestructura
    ConsultarPaquetesResponseDto response = PaqueteElectoralDtoMapper.toConsultarPaquetesResponseDto(
        paquetes,
        request.getPagina() != null ? request.getPagina() : 1,
        request.getRegistrosPorPagina() != null ? request.getRegistrosPorPagina() : 10
    );
    
    return ResponseEntity.ok(response);
}
```

---

### 7. Refactorización del Mapper

El **PaqueteElectoralDtoMapper** fue completamente refactorizado:

#### Nuevos Métodos Principales

**toConsultarPaquetesResponseDto**
- Recibe: `List<PaqueteElectoral>`, `Integer pagina`, `Integer registrosPorPagina`
- Calcula: Resumen estadístico desde la lista de paquetes
- Calcula: Información de paginación (totalPaginas, tieneAnterior, tieneSiguiente)
- Construye: DTO de respuesta completo

**toAprobarPaqueteResponseDto**
- Recibe: `PaqueteElectoral` aprobado, `InformacionPublicacionDto`
- Construye: Trazabilidad de la acción
- Construye: DTO de respuesta con estado actualizado

**toConfirmarRevisionResponseDto**
- Recibe: `String idPadron`, `String tipoPadron`
- Construye: Confirmación con timestamp
- Construye: Sugerencia de siguiente paso (generar oficio)
- Construye: Trazabilidad de la acción

#### Métodos Auxiliares

- **calcularResumen**: Computa estadísticas desde `List<PaqueteElectoral>`
- **calcularPaginacion**: Calcula metadata de paginación
- **parseFecha**: Convierte String ISO a LocalDateTime
- **formatDateTime**: Convierte LocalDateTime a String ISO

---

## Arquitectura Final

### Diagrama de Capas

```
┌────────────────────────────────────────────────────────────┐
│                    INFRASTRUCTURE LAYER                     │
│  ┌──────────────────────────────────────────────────────┐  │
│  │  REST Controller (PaquetesElectoralesController)     │  │
│  │  - Recibe HTTP requests                              │  │
│  │  - Llama Use Cases                                   │  │
│  │  - Delega mapeo de DTOs                              │  │
│  └──────────────────────────────────────────────────────┘  │
│  ┌──────────────────────────────────────────────────────┐  │
│  │  DTOs (Request/Response)                             │  │
│  │  - ConsultarPaquetesRequestDto/ResponseDto          │  │
│  │  - AprobarPaqueteRequestDto/ResponseDto             │  │
│  │  - ConfirmarRevisionRequestDto/ResponseDto          │  │
│  └──────────────────────────────────────────────────────┘  │
│  ┌──────────────────────────────────────────────────────┐  │
│  │  Response Objects (infrastructure/response)          │  │
│  │  - ResultadoConsultaPaquetes                         │  │
│  │  - InformacionPaginacion                             │  │
│  │  - ResumenPaquetes                                   │  │
│  │  - InformacionTrazabilidad                           │  │
│  └──────────────────────────────────────────────────────┘  │
│  ┌──────────────────────────────────────────────────────┐  │
│  │  Mapper (PaqueteElectoralDtoMapper)                  │  │
│  │  - Convierte Domain → DTO                            │  │
│  │  - Calcula datos técnicos (paginación, resumen)     │  │
│  └──────────────────────────────────────────────────────┘  │
│  ┌──────────────────────────────────────────────────────┐  │
│  │  Data Adapters (implementan Data Ports)              │  │
│  │  - PaqueteElectoralDataAdapter                       │  │
│  │  - PadronElectoralDataAdapter                        │  │
│  └──────────────────────────────────────────────────────┘  │
└────────────────────────────────────────────────────────────┘
                            ▲
                            │ Implements
                            │
┌────────────────────────────────────────────────────────────┐
│                     APPLICATION LAYER                       │
│  ┌──────────────────────────────────────────────────────┐  │
│  │  Services (implementan Use Cases)                    │  │
│  │  - ConsultarPaquetesService                          │  │
│  │  - AprobarPaqueteService                             │  │
│  │  - ConfirmarRevisionPaquetesService                  │  │
│  │                                                       │  │
│  │  Trabajan SOLO con entidades de dominio             │  │
│  └──────────────────────────────────────────────────────┘  │
└────────────────────────────────────────────────────────────┘
                            ▲
                            │ Uses
                            │
┌────────────────────────────────────────────────────────────┐
│                       DOMAIN LAYER                          │
│  ┌──────────────────────────────────────────────────────┐  │
│  │  Ports (Interfaces)                                  │  │
│  │  ┌────────────────┐  ┌─────────────────────────┐    │  │
│  │  │  Use Cases     │  │  Data Ports             │    │  │
│  │  │  (IN)          │  │  (OUT)                  │    │  │
│  │  └────────────────┘  └─────────────────────────┘    │  │
│  └──────────────────────────────────────────────────────┘  │
│  ┌──────────────────────────────────────────────────────┐  │
│  │  Model (Entidades de Dominio PURAS)                 │  │
│  │  - PaqueteElectoral                                  │  │
│  │  - Ubicacion                                         │  │
│  │  - Aprobacion                                        │  │
│  │  - Confirmacion                                      │  │
│  │                                                       │  │
│  │  SOLO conceptos de negocio electoral                │  │
│  └──────────────────────────────────────────────────────┘  │
└────────────────────────────────────────────────────────────┘
```

### Flujo de Datos

**Request → Response (Ejemplo: Consultar Paquetes)**

```
1. Cliente HTTP
   │
   ├─→ POST /api/paquetes/consultar
   │   Body: ConsultarPaquetesRequestDto
   │
2. Controller (Infrastructure)
   │
   ├─→ consultarPaquetesUseCase.ejecutar(...)
   │   Retorna: List<PaqueteElectoral>
   │
3. Service (Application)
   │
   ├─→ paqueteElectoralDataPort.consultarPaquetes(...)
   │   Retorna: List<PaqueteElectoral>
   │
4. Data Adapter (Infrastructure)
   │
   ├─→ Accede a BD/API externa
   │   Retorna: List<PaqueteElectoral>
   │
5. Controller (Infrastructure)
   │
   ├─→ PaqueteElectoralDtoMapper.toConsultarPaquetesResponseDto(paquetes, pagina, registros)
   │   - Calcula resumen estadístico
   │   - Calcula información de paginación
   │   - Convierte PaqueteElectoral → PaqueteElectoralDto
   │   Retorna: ConsultarPaquetesResponseDto
   │
6. Cliente HTTP
   ←─ Response: ConsultarPaquetesResponseDto
```

---

## Principios de Arquitectura Hexagonal Aplicados

### ✅ 1. Independencia del Dominio
El dominio no tiene dependencias hacia capas externas. Solo contiene lógica de negocio pura.

### ✅ 2. Puertos y Adaptadores
- **Puertos de Entrada (Use Cases)**: Definen qué puede hacer el sistema
- **Puertos de Salida (Data Ports)**: Definen qué necesita el sistema
- **Adaptadores**: Implementan los puertos para tecnologías específicas

### ✅ 3. Regla de Dependencia
```
Infrastructure → Application → Domain
(nunca al revés)
```

### ✅ 4. Testabilidad
- Los Use Cases se pueden testear con mocks de los Data Ports
- El dominio se puede testear sin infraestructura
- Los adapters se pueden testear independientemente

### ✅ 5. Flexibilidad
- Se puede cambiar REST por GraphQL sin tocar dominio ni aplicación
- Se puede cambiar BD sin tocar dominio ni aplicación
- Se pueden agregar nuevos adapters sin modificar el core

---

## Beneficios Obtenidos

### 1. Dominio Limpio y Expresivo
El modelo de dominio representa exactamente el negocio electoral sin contaminación técnica.

### 2. Reusabilidad de Use Cases
Los Use Cases pueden ser llamados desde:
- REST API
- GraphQL API
- CLI
- Sistema de eventos
- Batch jobs
- Tests

### 3. Facilidad de Testing
```java
// Test unitario de un Use Case sin infraestructura
@Test
void debeAprobarPaqueteCuandoUsuarioTienePermiso() {
    // Given
    PaqueteElectoralDataPort mockDataPort = mock(PaqueteElectoralDataPort.class);
    AprobarPaqueteService service = new AprobarPaqueteService(mockDataPort);
    
    // When
    PaqueteElectoral resultado = service.ejecutar("PKG-001", "usuario", "OK", ...);
    
    // Then
    assertEquals("APROBADO", resultado.getEstadoPaquete());
}
```

### 4. Mantenibilidad
Cada capa tiene responsabilidades claras:
- **Dominio**: Lógica de negocio
- **Aplicación**: Orquestación de casos de uso
- **Infraestructura**: Detalles técnicos y comunicación

### 5. Escalabilidad Arquitectónica
Se pueden agregar nuevos adapters sin modificar el core:
```
infrastructure/
  adapters/
    in/
      rest/          ← Ya existe
      graphql/       ← Nuevo (futuro)
      messaging/     ← Nuevo (futuro)
    out/
      database/      ← Ya existe
      cache/         ← Nuevo (futuro)
      external-api/  ← Nuevo (futuro)
```

---

## Validación Final

### ✅ Compilación Exitosa
```
No errors found.
```

### ✅ Estructura de Directorios

```
src/main/java/pe/gob/onpe/dominio/paquetes/
├── domain/
│   ├── model/                    (4 clases de dominio puro)
│   └── ports/
│       ├── in/                   (3 Use Cases)
│       └── out/                  (2 Data Ports)
├── application/
│   └── service/                  (3 Services)
└── infrastructure/
    └── adapters/
        ├── in/
        │   └── rest/
        │       ├── controller/
        │       ├── dto/
        │       ├── mapper/
        │       └── response/     (8 objetos de respuesta)
        └── out/
            └── persistence/      (Adaptadores de BD)
```

### ✅ Dependencias Correctas

```
Infrastructure → Application → Domain ✓
Application → Domain ✓
Domain → (ninguna) ✓
```

---

## Conclusión

La refactorización ha logrado:

1. ✅ **Dominio puro**: Solo 4 clases con conceptos de negocio electoral
2. ✅ **Use Cases independientes**: Retornan entidades de dominio
3. ✅ **DTOs en infraestructura**: Separación clara de responsabilidades
4. ✅ **Arquitectura hexagonal estricta**: Cumple todos los principios
5. ✅ **Código compilable**: Sin errores
6. ✅ **Mantenible y escalable**: Preparado para evolución futura

El microservicio **MsDominioPaquetes** ahora tiene una arquitectura limpia, testeable y preparada para crecer sin acoplamiento técnico.
