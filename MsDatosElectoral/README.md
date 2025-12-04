# Microservicio MsDatosElectoral

## Descripción
Microservicio de datos electorales de la ONPE (Oficina Nacional de Procesos Electorales) implementado bajo **Arquitectura Hexagonal (Puertos y Adaptadores)** con principios de **Domain-Driven Design (DDD)** en Java puro.

**Tipo de microservicio:** MsData (capa de datos)  
**Versión API:** V1.3  
**Patrón de persistencia:** RepositoryPort/RepositoryAdapter

## Características
- **Java puro**: Sin frameworks (no Spring, JPA, JAX-RS, MapStruct)
- **Sin anotaciones**: Clases POJO con getters/setters
- **Inyección de dependencias por constructor**
- **Separación de responsabilidades**: Dominio, Aplicación, Infraestructura
- **Puertos definidos como interfaces**
- **Adaptadores con implementaciones mínimas** (UnsupportedOperationException)

## Estructura del Proyecto

```
src/main/java/pe/gob/onpe/datos/electoral/
├── domain/
│   ├── model/                         # Entidades del dominio (POJOs)
│   │   ├── Impugnacion.java
│   │   ├── Visita.java
│   │   ├── InformeFinal.java
│   │   ├── Analisis.java
│   │   ├── TachaReclamo.java
│   │   └── PaqueteElectoral.java
│   ├── ports/
│   │   ├── in/                        # Puertos de entrada (Casos de Uso)
│   │   │   ├── ConsultarImpugnacionUseCase.java
│   │   │   ├── ListarImpugnacionesUseCase.java
│   │   │   ├── RegistrarVisitaUseCase.java
│   │   │   ├── GuardarInformeFinalUseCase.java
│   │   │   ├── RegistrarAnalisisUseCase.java
│   │   │   ├── ConsultarAnalisisUseCase.java
│   │   │   ├── CrearTachaReclamoUseCase.java
│   │   │   ├── ActualizarTachaReclamoUseCase.java
│   │   │   └── ActualizarPaqueteElectoralUseCase.java
│   │   └── out/                       # Puertos de salida (Repositorios)
│   │       ├── ImpugnacionRepositoryPort.java
│   │       ├── VisitaRepositoryPort.java
│   │       ├── InformeFinalRepositoryPort.java
│   │       ├── AnalisisRepositoryPort.java
│   │       ├── TachaReclamoRepositoryPort.java
│   │       └── PaqueteElectoralRepositoryPort.java
├── application/
│   └── service/                       # Servicios de aplicación
│       ├── ConsultarImpugnacionService.java
│       ├── ListarImpugnacionesService.java
│       ├── RegistrarVisitaService.java
│       ├── GuardarInformeFinalService.java
│       ├── RegistrarAnalisisService.java
│       ├── ConsultarAnalisisService.java
│       ├── CrearTachaReclamoService.java
│       ├── ActualizarTachaReclamoService.java
│       └── ActualizarPaqueteElectoralService.java
└── infrastructure/
    └── adapters/
        ├── in/
        │   └── rest/                  # Adaptador REST de entrada
        │       ├── controller/        # Controladores (POJOs sin anotaciones)
        │       │   ├── ImpugnacionController.java
        │       │   ├── VisitaController.java
        │       │   ├── InformeFinalController.java
        │       │   ├── AnalisisController.java
        │       │   ├── TachaReclamoController.java
        │       │   └── PaqueteElectoralController.java
        │       ├── dto/               # DTOs de entrada/salida
        │       │   ├── ImpugnacionRequestDto.java
        │       │   ├── ImpugnacionResponseDto.java
        │       │   ├── VisitaRequestDto.java
        │       │   ├── VisitaResponseDto.java
        │       │   ├── InformeFinalRequestDto.java
        │       │   ├── InformeFinalResponseDto.java
        │       │   ├── AnalisisRequestDto.java
        │       │   ├── AnalisisResponseDto.java
        │       │   ├── TachaReclamoRequestDto.java
        │       │   ├── TachaReclamoResponseDto.java
        │       │   ├── PaqueteElectoralRequestDto.java
        │       │   └── PaqueteElectoralResponseDto.java
        │       └── mapper/            # Mapeadores DTO ↔ Domain
        │           ├── ImpugnacionDtoMapper.java
        │           ├── VisitaDtoMapper.java
        │           ├── InformeFinalDtoMapper.java
        │           ├── AnalisisDtoMapper.java
        │           ├── TachaReclamoDtoMapper.java
        │           └── PaqueteElectoralDtoMapper.java
        └── out/
            └── persistence/           # Adaptador de persistencia de salida
                ├── entity/            # Entidades de persistencia (POJOs)
                │   ├── ImpugnacionEntity.java
                │   ├── VisitaEntity.java
                │   ├── InformeFinalEntity.java
                │   ├── AnalisisEntity.java
                │   ├── TachaReclamoEntity.java
                │   └── PaqueteElectoralEntity.java
                ├── mapper/            # Mapeadores Persistence ↔ Domain
                │   ├── ImpugnacionPersistenceMapper.java
                │   ├── VisitaPersistenceMapper.java
                │   ├── InformeFinalPersistenceMapper.java
                │   ├── AnalisisPersistenceMapper.java
                │   ├── TachaReclamoPersistenceMapper.java
                │   └── PaqueteElectoralPersistenceMapper.java
                └── [RepositoryAdapters]/  # Implementaciones de RepositoryPort
                    ├── ImpugnacionRepositoryAdapter.java
                    ├── VisitaRepositoryAdapter.java
                    ├── InformeFinalRepositoryAdapter.java
                    ├── AnalisisRepositoryAdapter.java
                    ├── TachaReclamoRepositoryAdapter.java
                    └── PaqueteElectoralRepositoryAdapter.java
```

## Entidades del Dominio

### 1. Impugnacion
Representa una impugnación en el proceso electoral.

**Atributos:**
- `id` (Long): Identificador único
- `numeroImpugnacion` (String): Número de la impugnación
- `fechaRegistro` (LocalDateTime): Fecha de registro
- `estado` (String): Estado actual
- `descripcion` (String): Descripción detallada
- `tipo` (String): Tipo de impugnación

### 2. Visita
Representa una visita de verificación electoral.

**Atributos:**
- `id` (Long): Identificador único
- `fechaVisita` (LocalDateTime): Fecha de la visita
- `lugar` (String): Lugar visitado
- `observaciones` (String): Observaciones realizadas
- `responsable` (String): Responsable de la visita

### 3. InformeFinal
Representa un informe final del proceso electoral.

**Atributos:**
- `id` (Long): Identificador único
- `numeroInforme` (String): Número del informe
- `fechaEmision` (LocalDateTime): Fecha de emisión
- `contenido` (String): Contenido del informe
- `conclusiones` (String): Conclusiones del informe
- `estado` (String): Estado del informe

### 4. Analisis
Representa un análisis realizado en el proceso electoral.

**Atributos:**
- `id` (Long): Identificador único
- `tipoAnalisis` (String): Tipo de análisis
- `fechaAnalisis` (LocalDateTime): Fecha del análisis
- `resultado` (String): Resultado del análisis
- `observaciones` (String): Observaciones adicionales
- `estado` (String): Estado del análisis

### 5. TachaReclamo
Representa una tacha o reclamo en el proceso electoral.

**Atributos:**
- `id` (Long): Identificador único
- `tipo` (String): Tipo de tacha/reclamo
- `numeroExpediente` (String): Número de expediente
- `fechaRegistro` (LocalDateTime): Fecha de registro
- `estado` (String): Estado actual
- `descripcion` (String): Descripción del caso
- `solicitante` (String): Persona que solicita

### 6. PaqueteElectoral
Representa un paquete electoral.

**Atributos:**
- `id` (Long): Identificador único
- `numeroPaquete` (String): Número del paquete
- `estado` (String): Estado del paquete
- `fechaRecepcion` (LocalDateTime): Fecha de recepción
- `ubicacion` (String): Ubicación del paquete
- `observaciones` (String): Observaciones adicionales

## Endpoints de la API

### 1. Consultar Impugnación por ID
**Operación:** Consultar impugnación específica  
**Método HTTP:** GET  
**Ruta:** `/api/v1/impugnaciones/{id}`  
**Parámetros:** `id` (Long) - Path parameter  
**Respuesta:** `ImpugnacionResponseDto`  
**Códigos de estado:**
- 200: Éxito
- 404: No encontrado

**Controller:** `ImpugnacionController.consultarPorId(Long id)`

---

### 2. Listar Impugnaciones
**Operación:** Listar todas las impugnaciones  
**Método HTTP:** GET  
**Ruta:** `/api/v1/impugnaciones`  
**Parámetros:** Ninguno  
**Respuesta:** `List<ImpugnacionResponseDto>`  
**Códigos de estado:**
- 200: Éxito

**Controller:** `ImpugnacionController.listar()`

---

### 3. Registrar Visita
**Operación:** Registrar nueva visita  
**Método HTTP:** POST  
**Ruta:** `/api/v1/visitas`  
**Parámetros:** `VisitaRequestDto` (body)  
**Respuesta:** `VisitaResponseDto`  
**Códigos de estado:**
- 201: Creado
- 400: Solicitud inválida

**Controller:** `VisitaController.registrar(VisitaRequestDto request)`

---

### 4. Guardar Informe Final
**Operación:** Guardar informe final  
**Método HTTP:** POST  
**Ruta:** `/api/v1/informes`  
**Parámetros:** `InformeFinalRequestDto` (body)  
**Respuesta:** `InformeFinalResponseDto`  
**Códigos de estado:**
- 201: Creado
- 400: Solicitud inválida

**Controller:** `InformeFinalController.guardar(InformeFinalRequestDto request)`

---

### 5. Registrar Análisis
**Operación:** Registrar nuevo análisis  
**Método HTTP:** POST  
**Ruta:** `/api/v1/analisis`  
**Parámetros:** `AnalisisRequestDto` (body)  
**Respuesta:** `AnalisisResponseDto`  
**Códigos de estado:**
- 201: Creado
- 400: Solicitud inválida

**Controller:** `AnalisisController.registrar(AnalisisRequestDto request)`

---

### 6. Consultar Análisis por ID
**Operación:** Consultar análisis específico  
**Método HTTP:** GET  
**Ruta:** `/api/v1/analisis/{id}`  
**Parámetros:** `id` (Long) - Path parameter  
**Respuesta:** `AnalisisResponseDto`  
**Códigos de estado:**
- 200: Éxito
- 404: No encontrado

**Controller:** `AnalisisController.consultarPorId(Long id)`

---

### 7. Crear Tacha/Reclamo
**Operación:** Crear nueva tacha o reclamo  
**Método HTTP:** POST  
**Ruta:** `/api/v1/tachas-reclamos`  
**Parámetros:** `TachaReclamoRequestDto` (body)  
**Respuesta:** `TachaReclamoResponseDto`  
**Códigos de estado:**
- 201: Creado
- 400: Solicitud inválida

**Controller:** `TachaReclamoController.crear(TachaReclamoRequestDto request)`

---

### 8. Actualizar Tacha/Reclamo
**Operación:** Actualizar tacha o reclamo existente  
**Método HTTP:** PUT  
**Ruta:** `/api/v1/tachas-reclamos/{id}`  
**Parámetros:** 
- `id` (Long) - Path parameter
- `TachaReclamoRequestDto` (body)  
**Respuesta:** `TachaReclamoResponseDto`  
**Códigos de estado:**
- 200: Éxito
- 404: No encontrado
- 400: Solicitud inválida

**Controller:** `TachaReclamoController.actualizar(Long id, TachaReclamoRequestDto request)`

---

### 9. Actualizar Paquete Electoral
**Operación:** Actualizar paquete electoral existente  
**Método HTTP:** PUT  
**Ruta:** `/api/v1/paquetes-electorales/{id}`  
**Parámetros:** 
- `id` (Long) - Path parameter
- `PaqueteElectoralRequestDto` (body)  
**Respuesta:** `PaqueteElectoralResponseDto`  
**Códigos de estado:**
- 200: Éxito
- 404: No encontrado
- 400: Solicitud inválida

**Controller:** `PaqueteElectoralController.actualizar(Long id, PaqueteElectoralRequestDto request)`

---

## Mapeo de Tipos

| Tipo Java | Uso |
|-----------|-----|
| `Long` | Identificadores únicos (IDs) |
| `String` | Textos (números, descripciones, estados, tipos, etc.) |
| `LocalDateTime` | Marcas de tiempo (fechas de registro, emisión, análisis, visitas, recepción) |
| `List<T>` | Colecciones de entidades |

## Patrón RepositoryPort vs DataPort

**Este microservicio sigue el patrón MsData:**
- **Puertos de salida:** `RepositoryPort` (no `DataPort`)
- **Adaptadores de salida:** `RepositoryAdapter` (implementan `RepositoryPort`)
- **Operaciones:** Métodos CRUD estándar (save, findById, findAll, update)
- **Capa de datos:** Responsable de persistencia y recuperación de datos

## Limitaciones

1. **Sin frameworks:** No se utilizan Spring, Jakarta EE, Quarkus, Micronaut, etc.
2. **Sin JPA/Hibernate:** No hay anotaciones de persistencia (@Entity, @Table, etc.)
3. **Sin JAX-RS:** No hay anotaciones REST (@Path, @GET, @POST, etc.)
4. **Sin MapStruct:** Mapeos manuales con métodos estáticos
5. **Implementaciones stub:** Los adaptadores lanzan `UnsupportedOperationException` (requiere implementación futura)
6. **Sin inyección automática:** Las dependencias se pasan por constructor manualmente

## Principios de Diseño

### Arquitectura Hexagonal
- **Dominio** en el centro (independiente de infraestructura)
- **Puertos** como contratos (interfaces)
- **Adaptadores** conectan el dominio con el mundo exterior

### Domain-Driven Design
- **Entidades** con identidad única
- **Value Objects** (implícitos en atributos simples)
- **Servicios de dominio** cuando la lógica no pertenece a una entidad
- **Repositorios** para abstracción de persistencia

### Inversión de Dependencias
- El dominio define interfaces (`ports/out`)
- La infraestructura implementa esas interfaces (`adapters/out`)
- El dominio nunca depende de infraestructura

## Notas de Implementación

1. **Todos los controladores son POJOs** con métodos que representan endpoints (sin anotaciones de framework)
2. **Los servicios implementan casos de uso** y coordinan la lógica de negocio
3. **Los repositorios son abstracciones** (interfaces) en el dominio
4. **Los adaptadores son implementaciones concretas** en infraestructura
5. **Los mappers son clases con métodos estáticos** para conversiones de tipos
6. **Sin gestión de transacciones** (debe implementarse según tecnología elegida)
7. **Sin validaciones automáticas** (debe implementarse según requerimientos)

## Próximos Pasos

Para completar la implementación funcional:

1. Elegir tecnología de persistencia (JDBC, MyBatis, etc.)
2. Implementar cuerpos de métodos en `RepositoryAdapter`
3. Elegir framework web (opcional: Jetty, Undertow, etc.)
4. Implementar capa de protocolo HTTP en controladores
5. Agregar validaciones en servicios de aplicación
6. Implementar manejo de errores y excepciones personalizadas
7. Agregar logs (SLF4J, Log4j2, etc.)
8. Implementar tests unitarios e integración

## Autor

Generado según especificaciones del documento **Microservicio MsDatosElectoral V1.3.pdf**

## Licencia

Propiedad de la Oficina Nacional de Procesos Electorales (ONPE) - Perú
