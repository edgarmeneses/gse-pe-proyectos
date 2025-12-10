# Diagrama de Arquitectura - MsDominioPadronElectoral

## Arquitectura Hexagonal - Vista General

```
┌─────────────────────────────────────────────────────────────────────────────┐
│                         CAPA DE INFRAESTRUCTURA                             │
│                           (Adaptadores de Entrada)                          │
├─────────────────────────────────────────────────────────────────────────────┤
│                                                                             │
│  ┌───────────────────────────────────────────────────────────────────┐    │
│  │              PadronElectoralController                             │    │
│  │  - generarPadronElectoral()                                        │    │
│  │  - actualizarPadronElectoral()                                     │    │
│  │  - listarPadronesElectorales()                                     │    │
│  │  - consultarPadronElectoral()                                      │    │
│  └───────────────────────────────────────────────────────────────────┘    │
│                            ▲                                               │
│                            │ DTOs                                          │
│                            │                                               │
│  ┌────────────────────────┴────────────────────────┐                      │
│  │  DTOs (Request/Response)                        │                      │
│  │  - GenerarPadronElectoralRequestDto             │                      │
│  │  - ActualizarPadronElectoralRequestDto          │                      │
│  │  - PadronElectoralResponseDto                   │                      │
│  │  - ListarPadronesResponseDto                    │                      │
│  │  - ConsultarPadronResponseDto                   │                      │
│  └─────────────────────────────────────────────────┘                      │
│                                                                             │
└─────────────────────────────────────────────────────────────────────────────┘
                                    │
                                    │ Mapper
                                    ▼
┌─────────────────────────────────────────────────────────────────────────────┐
│                            CAPA DE APLICACIÓN                               │
│                            (Casos de Uso - Services)                        │
├─────────────────────────────────────────────────────────────────────────────┤
│                                                                             │
│  ┌───────────────────────────┐     ┌──────────────────────────────┐       │
│  │ GenerarPadronElectoralSvc │     │ ActualizarPadronElectoralSvc │       │
│  └───────────────────────────┘     └──────────────────────────────┘       │
│                                                                             │
│  ┌───────────────────────────┐     ┌──────────────────────────────┐       │
│  │ ConsultarPadronElectoralSvc│     │ ListarPadronesElectoralesSvc │       │
│  └───────────────────────────┘     └──────────────────────────────┘       │
│                                                                             │
│                      │ implements UseCases                                 │
│                      ▼                                                      │
└─────────────────────────────────────────────────────────────────────────────┘
                                    │
                                    │
                                    ▼
┌─────────────────────────────────────────────────────────────────────────────┐
│                              CAPA DE DOMINIO                                │
│                        (Lógica de Negocio y Puertos)                       │
├─────────────────────────────────────────────────────────────────────────────┤
│                                                                             │
│  ┌──────────────────────── PUERTOS DE ENTRADA ────────────────────────┐   │
│  │                                                                      │   │
│  │  GenerarPadronElectoralUseCase       <<interface>>                  │   │
│  │  ActualizarPadronElectoralUseCase    <<interface>>                  │   │
│  │  ConsultarPadronElectoralUseCase     <<interface>>                  │   │
│  │  ListarPadronesElectoralesUseCase    <<interface>>                  │   │
│  │                                                                      │   │
│  └──────────────────────────────────────────────────────────────────────┘   │
│                                                                             │
│  ┌──────────────────────── MODELO DE DOMINIO ─────────────────────────┐   │
│  │                                                                      │   │
│  │  ┌─────────────────────────────────────────────────────┐            │   │
│  │  │  PadronElectoral (Aggregate Root)                   │            │   │
│  │  │  - idPadron: String                                 │            │   │
│  │  │  - tipoPadron: String                               │            │   │
│  │  │  - tipoProceso: String                              │            │   │
│  │  │  - fechaCreacion: LocalDateTime                     │            │   │
│  │  │  - fechaActualizacion: LocalDateTime                │            │   │
│  │  │  - circunscripcion: Circunscripcion                 │            │   │
│  │  │  - listaCiudadanos: List<Ciudadano>                 │            │   │
│  │  │  - actualizacionesPadron: List<ActualizacionPadron> │            │   │
│  │  └─────────────────────────────────────────────────────┘            │   │
│  │                                                                      │   │
│  │  Value Objects:                                                     │   │
│  │  - Circunscripcion                                                  │   │
│  │  - Ciudadano                                                        │   │
│  │  - ActualizacionPadron                                              │   │
│  │  - PaginatedResult<T>                                               │   │
│  │  - ErrorResponse                                                    │   │
│  │                                                                      │   │
│  └──────────────────────────────────────────────────────────────────────┘   │
│                                                                             │
│  ┌──────────────────────── PUERTO DE SALIDA ──────────────────────────┐   │
│  │                                                                      │   │
│  │  PadronElectoralDataPort  <<interface>> (UNIFICADO)                 │   │
│  │  + crearPadron()                                                    │   │
│  │  + actualizarPadron()                                               │   │
│  │  + listarPadrones()                                                 │   │
│  │  + consultarPadronPorId()                                           │   │
│  │  + obtenerCiudadanosPaginados()                                     │   │
│  │                                                                      │   │
│  └──────────────────────────────────────────────────────────────────────┘   │
│                                                                             │
└─────────────────────────────────────────────────────────────────────────────┘
                                    │
                                    │ implements
                                    ▼
┌─────────────────────────────────────────────────────────────────────────────┐
│                         CAPA DE INFRAESTRUCTURA                             │
│                           (Adaptadores de Salida)                           │
├─────────────────────────────────────────────────────────────────────────────┤
│                                                                             │
│  ┌────────────────────────────────────────────────────────────────┐        │
│  │          PadronElectoralDataAdapter                             │        │
│  │                                                                  │        │
│  │  Implementa: PadronElectoralDataPort                            │        │
│  │                                                                  │        │
│  │  Nota: Sin protocolo definido (HTTP/SOAP/Colas)                │        │
│  │  Métodos lanzan UnsupportedOperationException                   │        │
│  │  Requiere implementación tecnológica específica                 │        │
│  └────────────────────────────────────────────────────────────────┘        │
│                                                                             │
└─────────────────────────────────────────────────────────────────────────────┘
                                    │
                                    │ (No implementado)
                                    ▼
                        ┌────────────────────────────┐
                        │  MsDataPadronElectoral     │
                        │  (Componente Externo)      │
                        └────────────────────────────┘
```

## Flujo de Datos - Ejemplo: Generar Padrón Electoral

```
1. REQUEST (HTTP POST)
   ↓
2. PadronElectoralController.generarPadronElectoral(GenerarPadronElectoralRequestDto)
   ↓
3. PadronElectoralDtoMapper (conversión DTO → Domain)
   ↓
4. GenerarPadronElectoralUseCase.generar(tipoPadron, depto, prov, dist)
   ↓
5. GenerarPadronElectoralService.generar()
   ↓
6. PadronElectoralDataPort.crearPadron() [interface]
   ↓
7. PadronElectoralDataAdapter.crearPadron() [implementación stub]
   ↓
8. [Comunicación con MsDataPadronElectoral - NO IMPLEMENTADA]
   ↓
9. Return PadronElectoral (Domain Model)
   ↓
10. PadronElectoralDtoMapper (conversión Domain → DTO)
   ↓
11. PadronElectoralResponseDto
   ↓
12. RESPONSE (HTTP 201 Created)
```

## Principios de Arquitectura Hexagonal Aplicados

### ✅ Inversión de Dependencias
- Las capas externas dependen de las internas
- El dominio NO depende de infraestructura
- Uso de interfaces (puertos) para desacoplar

### ✅ Puertos (Interfaces)
**Puertos de Entrada (Driving/Primary)**:
- `GenerarPadronElectoralUseCase`
- `ActualizarPadronElectoralUseCase`
- `ConsultarPadronElectoralUseCase`
- `ListarPadronesElectoralesUseCase`

**Puerto de Salida Unificado (Driven/Secondary)**:
- `PadronElectoralDataPort` (agrupa todas las operaciones hacia MsData)

### ✅ Adaptadores
**Adaptador de Entrada (REST)**:
- `PadronElectoralController` + DTOs + Mapper

**Adaptador de Salida (MsData Client)**:
- `PadronElectoralDataAdapter`

### ✅ Dominio Puro
- Sin dependencias externas
- POJOs puros en Java
- Lógica de negocio centralizada
- Aggregate Root: `PadronElectoral`
- Value Objects: `Circunscripcion`, `Ciudadano`, `ActualizacionPadron`

## Características Especiales del Diseño

### 🔹 Puerto de Salida Unificado
En lugar de múltiples puertos de salida, se implementó un **puerto único** (`PadronElectoralDataPort`) que agrupa todas las operaciones hacia MsDataPadronElectoral:
- Simplifica la arquitectura
- Reduce el número de interfaces
- Facilita la implementación del adaptador
- Mantiene cohesión funcional

### 🔹 MsDominio vs MsData
Este microservicio es **MsDominio**, por lo tanto:
- ❌ NO tiene `RepositoryPort` (no accede a BD directamente)
- ✅ Tiene `DataPort` (se comunica con MsDataPadronElectoral)
- ✅ Implementa lógica de dominio y orquestación
- ✅ Delega persistencia al componente de datos externo

### 🔹 Neutralidad Tecnológica
- Sin anotaciones de frameworks
- Sin dependencias externas
- Código Java puro compilable
- Adaptador stub con `UnsupportedOperationException`
- Permite integrar cualquier tecnología posteriormente

## Relación con MsDataPadronElectoral

```
┌───────────────────────────────────┐
│  MsDominioPadronElectoral         │
│  (Este Microservicio)             │
│                                   │
│  - Lógica de dominio              │
│  - Orquestación de casos de uso   │
│  - Validaciones de negocio        │
│  - NO accede a BD directamente    │
│                                   │
└───────────────────────────────────┘
            │
            │ PadronElectoralDataPort
            │ (Puerto de Salida)
            ▼
┌───────────────────────────────────┐
│  MsDataPadronElectoral            │
│  (Componente Externo - No impl.)  │
│                                   │
│  - Persistencia de datos          │
│  - Acceso a base de datos         │
│  - CRUD de padrones               │
│  - Generación de ciudadanos       │
│                                   │
└───────────────────────────────────┘
```

## Diagrama de Clases - Dominio

```
┌─────────────────────────────────┐
│    PadronElectoral              │
│    (Aggregate Root)             │
├─────────────────────────────────┤
│ - idPadron: String              │
│ - tipoPadron: String            │
│ - tipoProceso: String           │
│ - fechaCreacion: LocalDateTime  │
│ - fechaActualizacion: LDT       │
│ - circunscripcion ───────────┐  │
│ - listaCiudadanos: List ─────┼─┐│
│ - actualizacionesPadron ─────┼┐││
│ - cantidadCiudadanos: Integer││││
└──────────────────────────────┼┼┼┘
                               ││││
        ┌──────────────────────┘│││
        │                       │││
        ▼                       │││
┌──────────────────┐            │││
│ Circunscripcion  │            │││
├──────────────────┤            │││
│ - departamento   │            │││
│ - provincia      │            │││
│ - distrito       │            │││
└──────────────────┘            │││
                                │││
        ┌───────────────────────┘││
        │                        ││
        ▼                        ││
┌──────────────────┐             ││
│ Ciudadano        │             ││
├──────────────────┤             ││
│ - nombre         │             ││
│ - documento      │             ││
│ - direccion      │             ││
└──────────────────┘             ││
                                 ││
        ┌────────────────────────┘│
        │                         │
        ▼                         │
┌────────────────────────┐        │
│ ActualizacionPadron    │        │
├────────────────────────┤        │
│ - fechaActualizacion   │        │
│ - usuarioResponsableId │        │
│ - informeFinal...Id    │        │
└────────────────────────┘        │
                                  │
        ┌─────────────────────────┘
        │
        ▼
┌────────────────────────┐
│ PaginatedResult<T>     │
├────────────────────────┤
│ - number: Integer      │
│ - size: Integer        │
│ - totalElements: Long  │
│ - totalPages: Integer  │
│ - hasNext: Boolean     │
│ - contenido: List<T>   │
└────────────────────────┘
```

---

**Nota**: Este diagrama representa la arquitectura implementada siguiendo estrictamente el prompt de arquitectura hexagonal y las especificaciones del PDF sin agregar funcionalidades no documentadas.
