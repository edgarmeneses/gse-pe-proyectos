# Refactorización del Modelo de Dominio - MsDatosGrafos

## Fecha
2024

## Objetivo
Refactorizar el modelo de dominio para que represente verdaderos conceptos de negocio y no sea una copia de los DTOs. Eliminar preocupaciones técnicas del dominio y aplicar correctamente los principios de Domain-Driven Design (DDD).

## Problemas Identificados

### Antes de la Refactorización
1. **Modelo Anémico**: Los objetos de dominio eran simples contenedores de datos con getters/setters
2. **Preocupaciones Técnicas en el Dominio**: 
   - `Paginacion` era parte del modelo de dominio
   - `ResumenVinculos` contenía estadísticas calculadas
3. **Objetos Mutables**: Los objetos de dominio tenían setters y eran mutables
4. **Falta de Lógica de Negocio**: No había métodos que encapsularan reglas de negocio
5. **Tipo de Dato Primitivo**: `categoriaParentesco` era un String sin validación

## Cambios Realizados

### 1. Dominio (domain/model)

#### Archivos Creados
- **`CategoriaParentesco.java`**: Enum con valores CONSANGUINEO y AFINIDAD
  - Incluye método `fromString()` para conversión segura

#### Archivos Modificados

**`Ciudadano.java`** (Entity)
- ✅ Inmutable con campos `final`
- ✅ Constructor con validación (idCiudadano no nulo)
- ✅ `equals()` y `hashCode()` basados en ID (identidad de entidad)
- ❌ Eliminados setters

**`TipoParentesco.java`** (Value Object)
- ✅ Inmutable con campos `final`
- ✅ Método de negocio: `esSimetrico()`
- ✅ `equals()` y `hashCode()` completos (igualdad por valor)
- ❌ Eliminados setters

**`Vigencia.java`** (Value Object)
- ✅ Inmutable con campos `final`
- ✅ Métodos de negocio: `estaVigente()`, `estaVigenteEn(LocalDateTime fecha)`
- ✅ Lógica de vigencia calculada (compara fechaFin con ahora)
- ❌ Eliminado campo `esVigente` (ahora es calculado)
- ❌ Eliminados setters

**`Sustento.java`** (Value Object)
- ✅ Inmutable con campos `final`
- ✅ Métodos de negocio: `tieneDocumentos()`, `tieneActa()`, `tieneDocumento(String id)`
- ✅ `equals()` y `hashCode()` por valor
- ❌ Eliminados setters

**`VinculoParentesco.java`** (Aggregate Root)
- ✅ Inmutable con campos `final`
- ✅ Campo `categoriaParentesco` cambiado de String a enum `CategoriaParentesco`
- ✅ Métodos de negocio:
  - `esDeCategoria(CategoriaParentesco categoria)`
  - `esVigente()` (delega a Vigencia)
  - `tieneSustento()` (delega a Sustento)
- ✅ Constructor con validación (tipoParentesco, grado, categoría y ciudadano no nulos)
- ✅ `equals()` y `hashCode()` basados en ID
- ❌ Eliminados setters

**`GrafoParentesco.java`** (Domain Service - anteriormente ResultadoConsultaVinculos)
- ✅ Representa concepto de negocio: red de relaciones familiares
- ✅ Inmutable con campos `final`
- ✅ Métodos de filtrado:
  - `getVinculosVigentes()`
  - `getVinculosPorCategoria(CategoriaParentesco categoria)`
  - `getVinculosHastaGrado(int gradoMaximo)`
- ✅ Métodos de conteo:
  - `contarVinculos()`
  - `contarVinculosPorCategoria(CategoriaParentesco categoria)`
  - `contarVinculosVigentes()`
- ❌ Eliminados setters
- ❌ Eliminadas referencias a Paginacion y ResumenVinculos

#### Archivos Eliminados del Dominio
- ❌ **`Paginacion.java`**: Preocupación técnica de infraestructura
- ❌ **`ResumenVinculos.java`**: Estadísticas calculadas, no concepto de negocio

### 2. Puertos (domain/ports)

**`ConsultarVinculosParentescoUseCase.java`** (Puerto de Entrada)
- ✅ Método renombrado a `consultar()`
- ✅ Parámetro `categoriaParentesco` cambiado de String a enum `CategoriaParentesco`
- ✅ Retorna `GrafoParentesco` (antes ResultadoConsultaVinculos)
- ❌ Eliminados parámetros `pagina` y `registrosPorPagina` (preocupaciones de infraestructura)

**`VinculoParentescoRepositoryPort.java`** (Puerto de Salida)
- ✅ Método renombrado a `consultarGrafoParentesco()`
- ✅ Parámetro `categoria` cambiado de String a enum `CategoriaParentesco`
- ✅ Retorna `GrafoParentesco`
- ❌ Eliminados parámetros de paginación

### 3. Capa de Aplicación (application)

**`ConsultarVinculosParentescoService.java`**
- ✅ Validación añadida: idCiudadano no nulo/vacío
- ✅ Llamada al puerto actualizada con nuevos parámetros
- ✅ Retorna `GrafoParentesco`
- ❌ Eliminada lógica de paginación (movida a infraestructura)

### 4. Adaptadores de Entrada (infrastructure/adapters/in/rest)

**`VinculoParentescoController.java`**
- ✅ Recibe parámetros de paginación (pero no los pasa al dominio)
- ✅ Convierte String `categoriaParentesco` a enum usando `CategoriaParentesco.fromString()`
- ✅ Llama al mapper con `toResponseDto(grafo, pagina, registrosPorPagina)`
- ✅ La paginación se aplica a nivel de infraestructura

**`VinculoParentescoDtoMapper.java`** (REESCRITO)
- ✅ Método `toResponseDto()` ahora acepta: `GrafoParentesco`, `pagina`, `registrosPorPagina`
- ✅ Métodos privados añadidos:
  - `aplicarPaginacion()`: Implementa lógica de paginación usando `subList()`
  - `calcularPaginacion()`: Calcula `PaginacionDto`
  - `calcularResumen()`: Genera `ResumenVinculosDto` usando métodos de `GrafoParentesco`
- ✅ `toVinculoDto()`: Convierte enum `CategoriaParentesco` a String con `.name()`
- ✅ `toVigenciaDto()`: Llama a `vigencia.estaVigente()` para calcular estado
- ✅ **Separación de responsabilidades**: El mapper ahora es responsable de:
  - Conversión de dominio a DTOs
  - Aplicación de paginación (infraestructura)
  - Cálculo de estadísticas (infraestructura)

### 5. Adaptadores de Salida (infrastructure/adapters/out/persistence)

**`VinculoParentescoRepositoryAdapter.java`**
- ✅ Método renombrado a `consultarGrafoParentesco()`
- ✅ Parámetro `categoriaParentesco` cambiado a enum `CategoriaParentesco`
- ✅ Retorna `GrafoParentesco`
- ❌ Eliminados parámetros de paginación
- ✅ Mensaje de error actualizado con `.name()` para el enum

**`VinculoParentescoPersistenceMapper.java`** (REESCRITO)
- ✅ Método `toDomain()` para `GrafoParentescoEntity`
- ✅ Conversión de String a enum `CategoriaParentesco.fromString()`
- ✅ Constructor de `Vigencia` sin campo `esVigente`
- ✅ Métodos `toEntity()` actualizados para objetos inmutables
- ✅ `toVinculoEntity()`: Convierte enum a String con `.name()`
- ✅ `toEntity(TipoParentesco)`: Llama a `esSimetrico()` (método de negocio)
- ❌ Eliminadas conversiones de Paginacion y ResumenVinculos

**Entidades de Persistencia:**

Archivos Eliminados:
- ❌ `PaginacionEntity.java`
- ❌ `ResumenVinculosEntity.java`
- ❌ `ResultadoConsultaVinculosEntity.java`

Archivo Creado:
- ✅ **`GrafoParentescoEntity.java`**: Entidad simplificada con:
  - `CiudadanoEntity ciudadanoConsultado`
  - `List<VinculoParentescoEntity> vinculos`
  - Getters y setters (las entidades de persistencia pueden ser mutables)

Archivos Mantenidos (Sin cambios mayores):
- `CiudadanoEntity.java`: Mutable con getters/setters
- `TipoParentescoEntity.java`: Mutable con getters/setters
- `VigenciaEntity.java`: Mutable con getters/setters (mantiene `esVigente` para persistencia)
- `SustentoEntity.java`: Mutable con getters/setters
- `VinculoParentescoEntity.java`: Mutable con getters/setters, campo `categoriaParentesco` sigue siendo String

## Principios Aplicados

### 1. Inmutabilidad en el Dominio
- Todos los objetos de dominio usan campos `final`
- Sin setters en el dominio
- Constructores con validación

### 2. Encapsulación de Lógica de Negocio
- Métodos de negocio en Value Objects y Entities
- Lógica calculada en el dominio (`estaVigente()`, `esSimetrico()`)
- GrafoParentesco encapsula operaciones de filtrado y conteo

### 3. Separación de Preocupaciones
- **Dominio**: Conceptos de negocio puros
- **Infraestructura**: Paginación, conversión, estadísticas
- **Persistencia**: Entidades mutables (OK para capa técnica)

### 4. Type Safety
- Enum `CategoriaParentesco` en lugar de String
- Validación en conversión `fromString()`

### 5. Value Objects vs Entities
- **Value Objects**: Igualdad por valor (TipoParentesco, Vigencia, Sustento)
- **Entities**: Igualdad por ID (Ciudadano, VinculoParentesco)

## Resumen de Archivos

### Totales
- **Archivos Java**: 33
- **Archivos Eliminados**: 5 (Paginacion, ResumenVinculos en dominio + 3 entidades)
- **Archivos Creados**: 2 (CategoriaParentesco enum, GrafoParentescoEntity)
- **Archivos Modificados**: 13

### Por Capa
- **Dominio**: 8 archivos (1 enum, 5 value objects/entities, 1 aggregate root, 1 domain service)
- **Puertos**: 2 archivos
- **Aplicación**: 1 archivo
- **Infraestructura REST**: 11 archivos (1 controller, 1 mapper, 9 DTOs)
- **Infraestructura Persistencia**: 11 archivos (6 entities, 1 mapper, 1 adapter)

## Beneficios de la Refactorización

1. **Modelo Rico en Dominio**: Los objetos de dominio ahora contienen lógica de negocio
2. **Separación Clara**: Las preocupaciones técnicas están en infraestructura
3. **Inmutabilidad**: Mayor seguridad y facilidad para razonar sobre el código
4. **Type Safety**: Enum en lugar de String para categorías
5. **Testabilidad**: Lógica de negocio fácilmente testeable sin infraestructura
6. **Mantenibilidad**: Cambios en paginación/estadísticas no afectan el dominio
7. **DDD Correctamente Aplicado**: Value Objects, Entities, Aggregate Roots bien diferenciados

## Compilación
✅ El código compila sin errores
⚠️ Warning: Campo `mapper` en `VinculoParentescoRepositoryAdapter` no usado (esperado, es un stub)

## Próximos Pasos (Sugeridos)
1. Implementar pruebas unitarias para la lógica de dominio
2. Implementar la conexión real a la base de datos de grafos (Neo4j)
3. Añadir más validaciones de negocio si es necesario
4. Documentar casos de uso y reglas de negocio
