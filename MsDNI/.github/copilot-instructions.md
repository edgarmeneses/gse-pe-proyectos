# AI Coding Agent Instructions - MsDNI Microservice Generator

## Architecture Overview

This project generates Java microservices following **strict Hexagonal Architecture (Ports & Adapters)** with **Domain-Driven Design (DDD)** principles. Code generation is specification-driven from PDF documents defining endpoints, models, and business rules.

### Critical Constraint: Technology-Agnostic Implementation
- **NO frameworks** (Spring, JAX-RS, etc.)
- **NO annotations** (JPA, MapStruct, etc.)  
- **Pure Java POJOs**: interfaces, classes, enums only
- All implementations use stub methods (`throw UnsupportedOperationException()`)

## Microservice Types

### MsDominio (Domain Services)
**Purpose**: Business logic layer that delegates data operations to MsData services

**Key Rules**:
- ❌ NEVER define `RepositoryPort` or `RepositoryAdapter`
- ✅ Define `{Entity}DataPort` (out port) for external MsData communication
- ✅ Implement `{Entity}DataAdapter` (no protocol details - HTTP/SOAP/etc)
- Structure: `domain/ports/out/{Entity}DataPort.java` → `infrastructure/adapters/out/msdata/client/{Entity}DataAdapter.java`

### MsData (Data Services)  
**Purpose**: Data persistence abstraction layer

**Key Rules**:
- ✅ Define `{Entity}RepositoryPort` and `{Entity}RepositoryAdapter`
- ✅ Define `{Entity}Entity.java` (POJO, no JPA annotations)
- Structure: `domain/ports/out/{Entity}RepositoryPort.java` → `infrastructure/adapters/out/persistence/{Entity}RepositoryAdapter.java`

## Project Structure (Mandatory)

```
src/main/java/{package.base}/
├── domain/
│   ├── model/{Entity}.java                    # Aggregate roots
│   └── ports/
│       ├── in/                                 # Use case interfaces
│       │   ├── Crear{Entity}UseCase.java
│       │   ├── Consultar{Entity}UseCase.java
│       │   ├── Listar{Entities}UseCase.java
│       │   ├── Actualizar{Entity}UseCase.java
│       │   └── Eliminar{Entity}UseCase.java    # Only if in spec
│       └── out/                                # External dependencies
│           ├── {Entity}DataPort.java           # MsDominio only
│           └── {Entity}RepositoryPort.java     # MsData only
├── application/service/                        # Use case implementations
│   ├── Crear{Entity}Service.java
│   └── ...Service.java
└── infrastructure/adapters/
    ├── in/rest/
    │   ├── controller/{Entity}Controller.java  # No annotations
    │   ├── dto/{Entity}RequestDto.java         # Use Java records
    │   └── mapper/{Entity}DtoMapper.java
    └── out/
        ├── persistence/                        # MsData only
        │   ├── entity/{Entity}Entity.java
        │   ├── mapper/{Entity}PersistenceMapper.java
        │   └── {Entity}RepositoryAdapter.java
        └── msdata/client/                      # MsDominio only
            └── {Entity}DataAdapter.java
```

## Type Mapping Conventions

When extracting from specifications:
- `string` → `String`
- `integer/int/long` → `Long` (default for integers)
- `number/decimal/double` → `Double`
- `boolean` → `Boolean`
- `date` → `LocalDate`
- `datetime/timestamp` → `LocalDateTime`
- `array/list` → `List<T>`

**Smart type inference**: If a string field contains date/time patterns (e.g., "2025-12-01T10:30:00"), use `LocalDateTime` instead of `String`.

## Endpoint to Use Case Mapping

Only generate use cases for operations **explicitly defined in specification PDF**:
- `POST /resource` → `Crear{Entity}UseCase` + `Crear{Entity}Service`
- `GET /resource/{id}` → `Consultar{Entity}UseCase` + `Consultar{Entity}Service`
- `GET /resource` → `Listar{Entities}UseCase` + `Listar{Entities}Service`
- `PUT/PATCH /resource/{id}` → `Actualizar{Entity}UseCase` + `Actualizar{Entity}Service`
- `DELETE /resource/{id}` → `Eliminar{Entity}UseCase` + `Eliminar{Entity}Service`

## Code Generation Rules

1. **DTOs as Records**: Use Java `record` syntax for all DTOs
   ```java
   public record PersonaRequestDto(String nombre, LocalDateTime fechaNacimiento) {}
   ```

2. **Controllers Without Annotations**: Plain POJOs with descriptive method names
   ```java
   public class PersonaController {
       public PersonaResponseDto crear(PersonaRequestDto request) {
           throw new UnsupportedOperationException();
       }
   }
   ```

3. **No Protocol Assumptions**: Never specify HTTP clients, SOAP bindings, or messaging queues in adapters

4. **README.md Requirements**: Always document:
   - Microservice type (MsDominio vs MsData)
   - All endpoints with method, path, params, status codes
   - Entity mappings and type conversions
   - Structural consequences (ports/adapters used)
   - Technology limitations disclaimer

## Development Workflow

1. **Extract from PDF**: Microservice name, context, API version, endpoints, entities
2. **Identify Type**: MsDominio (no repository) vs MsData (with repository)
3. **Generate Structure**: Follow mandatory folder hierarchy
4. **Create Artifacts**: 
   - Domain models and ports
   - Application services
   - Infrastructure adapters (stub implementations)
5. **Document**: Generate README with extracted specifications

## Critical Validation Checklist

- [ ] Code compiles as pure Java (no external dependencies)
- [ ] Correct microservice type structure (DataPort vs RepositoryPort)
- [ ] Only endpoints from PDF specification implemented
- [ ] All DTOs use Java `record` syntax
- [ ] No frameworks or annotations anywhere
- [ ] Stub implementations use `UnsupportedOperationException`
- [ ] README documents microservice type and limitations

## When Specifications Are Ambiguous

- ✅ Document ambiguity in README
- ❌ Never infer or assume additional operations
- ❌ Never create CRUD operations not in spec
- ✅ Use `String` for unclear types until clarified

## Example Package Structure

For "MsDNI" service → `pe.gob.organizacion.dni` or similar based on organizational context.
