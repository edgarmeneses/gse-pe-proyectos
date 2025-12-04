# Refactorización del Modelo de Dominio - MsDominioParentesco

## Problema Detectado

El modelo de dominio inicial (versión anémica) tenía las siguientes debilidades:

1. **Modelo Anémico**: Las clases eran simples contenedores de datos sin comportamiento
2. **Primitiva Obsession**: Uso de `String` para DNI, tipos de vínculo, estados
3. **Lógica en la capa de aplicación**: Las validaciones y reglas de negocio estaban en los servicios
4. **Duplicación DTOs-Dominio**: El dominio reflejaba casi exactamente la estructura de los DTOs

## Solución: Modelo de Dominio Rico

Se refactorizó hacia un modelo DDD (Domain-Driven Design) auténtico con:

### Value Objects

**DNI** - Validación de identidad
```java
DNI dni = DNI.of("12345678"); // Valida formato de 8 dígitos
```
- Validación con regex `^\\d{8}$`
- Inmutable
- Factory method `of()`

**TipoVinculo** - Tipos de relaciones de parentesco
```java
TipoVinculo padre = TipoVinculo.PADRE; // Primer grado consanguíneo
```
- 15 constantes predefinidas (PADRE, MADRE, HIJO, HERMANO, CONYUGE, etc.)
- Grado (1-4)
- Categoría (CONSANGUINEO/AFINIDAD)
- Métodos: `esConsanguineo()`, `esAfinidad()`, `fromCodigo()`

### Enums con Comportamiento

**EstadoAnalisis** - Máquina de estados
```java
if (estado.puedeTransicionarA(EstadoAnalisis.COMPLETADO)) {
    analisis.completar();
}
```
Estados: `SOLICITADO` → `EN_PROCESO` → `COMPLETADO`/`COMPLETADO_CON_OBSERVACIONES`/`FALLIDO`/`CANCELADO`

**NivelConfianza** - Niveles de confianza
```java
NivelConfianza nivel = NivelConfianza.fromPorcentaje(0.85); // ALTO
if (nivel.esConfiable()) { ... }
```
- ALTO: 0.80-1.00
- MEDIO: 0.50-0.79
- BAJO: 0.00-0.49

**CategoriaVinculo** - Categorización de vínculos
```java
enum CategoriaVinculo { CONSANGUINEO, AFINIDAD }
```

**TipoInconsistencia** - Tipos de inconsistencias
```java
if (inconsistencia.getTipo().esCritica()) {
    // Requiere intervención inmediata
}
```

### Entities

**Ciudadano** - Entidad con lógica de negocio
```java
Ciudadano ciudadano = Ciudadano.crear(dni, "Juan Pérez", LocalDate.of(1980, 5, 15));
int edad = ciudadano.calcularEdad();
boolean esMayor = ciudadano.esMayorDeEdad();
```

Validaciones:
- Nombre: 3-200 caracteres
- Fecha de nacimiento: entre 1900 y hoy
- Cálculo de edad automático

**Vinculo** - Relación entre ciudadanos con reglas complejas
```java
Vinculo vinculo = Vinculo.establecer(padre, hijo, TipoVinculo.HIJO, NivelConfianza.ALTO, true);
```

Reglas de negocio enforceadas:
- No puede vincular un ciudadano consigo mismo
- Padre/madre debe ser mayor que hijo
- Diferencia de edad mínima de 15 años para relaciones de primer grado
- Cónyuges deben ser mayores de edad (18+)
- Validación de coherencia con actas civiles

**DeteccionInconsistencia** - Registro de anomalías
```java
DeteccionInconsistencia inc = new DeteccionInconsistencia(
    TipoInconsistencia.FECHA_NACIMIENTO_INCONSISTENTE,
    "Padre más joven que hijo",
    List.of(padre, hijo),
    LocalDateTime.now()
);
```

### Aggregate Root

**AnalisisParentesco** - Orquestador principal
```java
// Iniciar análisis
AnalisisParentesco analisis = AnalisisParentesco.iniciar(
    ciudadano, TipoVinculo.PADRE, profundidad, usuario);

analisis.iniciarEjecucion();

// Registrar vínculos con validación automática
analisis.registrarVinculoEncontrado(vinculo);

// Registrar inconsistencias
analisis.registrarInconsistencia(tipo, descripcion, afectados);

// Completar
analisis.completar(); // Transición automática según inconsistencias

// Estadísticas
EstadisticasAnalisis stats = analisis.calcularEstadisticas();
System.out.println("Confiabilidad: " + stats.calcularPorcentajeConfiabilidad() + "%");
```

Comportamiento rico:
- **Transiciones de estado**: Valida transiciones permitidas
- **Validación de vínculos**: Verifica coherencia con ciudadano analizado
- **Detección automática**: Marca vínculos incompatibles como inconsistencias
- **Estadísticas**: Calcula métricas en tiempo real
- **Invariantes**: No permite operaciones en estados inválidos

### Value Object Calculado

**EstadisticasAnalisis** - Métricas inmutables
```java
EstadisticasAnalisis stats = analisis.calcularEstadisticas();
System.out.println("Total vínculos: " + stats.getTotalVinculosEncontrados());
System.out.println("Confiabilidad: " + stats.calcularPorcentajeConfiabilidad() + "%");
System.out.println("Requieren validación: " + stats.getVinculosRequierenValidacion());
```

## Comparación: Antes vs Después

### Antes (Modelo Anémico)
```java
// Datos sin validación
ResultadoAnalisisParentesco resultado = new ResultadoAnalisisParentesco();
resultado.setDniCiudadano("12345678");
resultado.setEstado("COMPLETADO"); // String sin restricciones

// Lógica en servicio
if (relacionConsanguinea.getTipoRelacion().equals("PADRE")) {
    // Validar edad manualmente en el servicio
    if (padre.getEdad() > hijo.getEdad()) {
        // ...
    }
}
```

### Después (Modelo Rico)
```java
// Validación automática en construcción
DNI dni = DNI.of("12345678"); // Lanza excepción si inválido
EstadoAnalisis estado = EstadoAnalisis.COMPLETADO;

// Lógica en el dominio
Vinculo vinculo = Vinculo.establecer(padre, hijo, TipoVinculo.PADRE, nivel, true);
// Lanza IllegalArgumentException si padre <= hijo en edad
// Lanza IllegalArgumentException si diferencia < 15 años

// Agregado con invariantes
analisis.registrarVinculoEncontrado(vinculo);
// Valida automáticamente que el vínculo involucra al ciudadano analizado
// Detecta incompatibilidades de tipo automáticamente
```

## Beneficios de la Refactorización

### 1. **Validaciones Centralizadas**
- Todas las reglas están en el dominio, no dispersas
- Imposible crear objetos inválidos
- Factory methods controlan la creación

### 2. **Tipo Seguro**
- `EstadoAnalisis` en lugar de `String`
- `TipoVinculo` en lugar de `String`
- Compilador detecta errores

### 3. **Expresividad**
```java
// Antes
if (resultado.getEstado().equals("COMPLETADO")) { ... }

// Después
if (analisis.getEstado() == EstadoAnalisis.COMPLETADO) { ... }
if (analisis.getEstado().esEstadoFinal()) { ... }
```

### 4. **Testabilidad**
```java
@Test
void debeValidarEdadEnVinculoPadreHijo() {
    Ciudadano padre = Ciudadano.crear(dni1, "Padre", LocalDate.of(1980, 1, 1));
    Ciudadano hijo = Ciudadano.crear(dni2, "Hijo", LocalDate.of(1975, 1, 1)); // ¡Hijo mayor!
    
    assertThrows(IllegalArgumentException.class, () -> {
        Vinculo.establecer(padre, hijo, TipoVinculo.HIJO, NivelConfianza.ALTO, true);
    });
}
```

### 5. **Mantenibilidad**
- Cambios de reglas de negocio: solo en el dominio
- No hay código duplicado en servicios
- Comportamiento cohesivo

### 6. **Independencia Tecnológica**
- Dominio puro Java sin frameworks
- Puertos usan tipos primitivos (String, Map)
- Adaptadores son stubs reemplazables

## Estructura de Capas Refactorizada

```
domain/
  model/
    ├── DNI.java                         (Value Object)
    ├── TipoVinculo.java                 (Value Object)
    ├── CategoriaVinculo.java            (Enum)
    ├── EstadoAnalisis.java              (Enum con lógica)
    ├── NivelConfianza.java              (Enum con lógica)
    ├── TipoInconsistencia.java          (Enum)
    ├── Ciudadano.java                   (Entity)
    ├── Vinculo.java                     (Entity)
    ├── DeteccionInconsistencia.java     (Value Object)
    ├── AnalisisParentesco.java          (Aggregate Root)
    └── EstadisticasAnalisis.java        (Value Object calculado)
  
  ports/
    in/
      └── EjecutarAnalisisParentescoUseCase.java
    out/
      ├── AnalisisParentescoDataPort.java  (Retorna Map<String, Object>)
      ├── APDDataPort.java                 (Retorna Map<String, Object>)
      └── ActasDataPort.java               (Retorna boolean)

application/
  service/
    └── EjecutarAnalisisParentescoService.java  (Orquestación)

infrastructure/
  adapters/
    in/rest/
      ├── AnalisisParentescoController.java
      ├── dto/ (Records - interfaz externa)
      └── mapper/ (Convierte DTOs ↔ Dominio)
    out/msdata/client/
      ├── AnalisisParentescoDataAdapter.java  (Stub)
      ├── APDDataAdapter.java                 (Stub)
      └── ActasDataAdapter.java               (Stub)
```

## Siguientes Pasos

1. **Actualizar DTOs y Mapper**: Convertir entre el nuevo modelo rico y los DTOs de REST
2. **Actualizar Controller**: Usar el nuevo use case signature
3. **Implementar Adaptadores**: Reemplazar stubs con clientes reales (HTTP/SOAP)
4. **Tests Unitarios**: Crear tests para todas las reglas de dominio
5. **Tests de Integración**: Validar flujo completo end-to-end

## Documentación de Reglas de Negocio

### Reglas de Vínculos Padre-Hijo
- El padre/madre debe ser mayor que el hijo
- Diferencia mínima de edad: 15 años
- Requiere acta de nacimiento para alta confianza

### Reglas de Vínculos Conyugales
- Ambos cónyuges deben ser mayores de edad (18+)
- No puede existir vínculo consigo mismo

### Reglas de Análisis
- Profundidad: 1-4 grados
- Solo vínculos compatibles con tipo buscado (consanguíneo/afinidad)
- Análisis solo modificable en estado EN_PROCESO
- Completado automático con observaciones si hay inconsistencias críticas

### Niveles de Confianza
- ALTO (≥80%): Vínculo confirmado con múltiples fuentes
- MEDIO (50-79%): Vínculo probable, requiere validación
- BAJO (<50%): Vínculo dudoso, requiere validación manual

Esta refactorización transforma un modelo anémico en un **modelo de dominio rico** que encapsula reglas de negocio, garantiza invariantes y proporciona una API expresiva y tipo-segura.
