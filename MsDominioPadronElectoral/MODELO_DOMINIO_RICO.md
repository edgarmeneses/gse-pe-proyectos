# Modelo de Dominio Rico - MsDominioPadronElectoral

## ✅ Refactorización Completada

El modelo de dominio ha sido completamente refactorizado para ser un **verdadero modelo rico** con comportamiento, validaciones y lógica de negocio, en lugar de simples DTOs con getters/setters.

## 🎯 Principios Aplicados

### 1. **Inmutabilidad**
- Todos los Value Objects son inmutables (solo getters, sin setters)
- PadronElectoral es inmutable (se usa Builder pattern para crear instancias)
- Los cambios generan nuevas instancias en lugar de mutar el estado

### 2. **Encapsulación**
- Validaciones en constructores
- Lógica de negocio dentro de las entidades
- State interno protegido

### 3. **Domain-Driven Design**
- **Aggregate Root**: `PadronElectoral`
- **Value Objects**: `Circunscripcion`, `Ciudadano`, `ActualizacionPadron`, `PadronElectoralId`, `NumeroDocumento`
- **Enums de Dominio**: `TipoPadron`, `TipoProceso`, `TipoVerificacion`

## 📦 Estructura del Modelo de Dominio

### Aggregate Root: `PadronElectoral`

**Características**:
- ✅ Inmutable (final fields)
- ✅ Builder pattern para construcción
- ✅ Factory methods (crear, reconstruir)
- ✅ Métodos de dominio con lógica de negocio
- ✅ Validaciones en construcción
- ✅ Collections inmutables expuestas

**Métodos de Dominio**:
```java
- crear()                          // Factory para nuevo padrón
- reconstruir()                    // Factory desde persistencia
- actualizar()                     // Retorna nueva instancia actualizada
- estaActualizado()               // Lógica de negocio
- obtenerUltimaActualizacion()    // Navegación en el dominio
- contarCiudadanos()              // Cálculo derivado
- perteneceACircunscripcion()     // Verificación de pertenencia
- esFinal()                       // Estado del padrón
- buscarCiudadano()               // Consulta en el agregado
```

### Value Objects Ricos

#### `PadronElectoralId`
- Encapsula el identificador único
- Validación de nulidad y vacío
- Tipo seguro en lugar de String plano

#### `Circunscripcion`
- **Validaciones**: campos obligatorios, longitud máxima
- **Normalización**: Upper case automático
- **Métodos de dominio**:
  - `coincideCon()` - comparación inteligente
  - `obtenerUbicacionCompleta()` - representación
  - `esCapital()` - lógica de negocio

#### `Ciudadano`
- **Validaciones**: nombre y dirección obligatorios con límites
- **Normalización**: nombre en mayúsculas
- **Composición**: usa `NumeroDocumento` (otro Value Object)
- **Métodos de dominio**:
  - `tieneDNI()`
  - `tieneCarnetExtranjeria()`

#### `NumeroDocumento`
- **Validación con Regex**: DNI (8 dígitos) o CE (9 dígitos)
- **Métodos de dominio**:
  - `esDNI()`
  - `esCarnetExtranjeria()`

#### `ActualizacionPadron`
- **Múltiples constructores**: creación vs reconstrucción
- **Timestamp automático**: en creación
- **Validaciones**: usuario e informe obligatorios
- **Métodos de dominio**:
  - `cambiaTipoPadron()`

### Enums de Dominio

#### `TipoPadron`
```java
INICIAL, PRELIMINAR, FINAL, COMPLEMENTARIO
```
- Conversión desde String
- Descripción legible
- Tipo seguro

#### `TipoProceso`
```java
ELECCIONES_GENERALES, ELECCIONES_REGIONALES, 
ELECCIONES_MUNICIPALES, REFERENDUM, CONSULTA_POPULAR
```

#### `TipoVerificacion`
```java
PRESENCIAL, DOCUMENTAL, VIRTUAL, MIXTA
```
- Valor por defecto: DOCUMENTAL

## 🔄 Comparación: Antes vs Después

### ❌ ANTES (Modelo Anémico)
```java
public class PadronElectoral {
    private String idPadron;
    private String tipoPadron;  // String sin validación
    private LocalDateTime fechaCreacion;
    private List<Ciudadano> listaCiudadanos;
    
    // Solo getters y setters
    public String getIdPadron() { return idPadron; }
    public void setIdPadron(String id) { this.idPadron = id; }
    // ... más getters/setters sin lógica
}
```

**Problemas**:
- ❌ Sin validaciones
- ❌ Sin comportamiento
- ❌ Mutable (setters públicos)
- ❌ Tipos primitivos (String para todo)
- ❌ Acoplado a DTOs
- ❌ Sin lógica de negocio

### ✅ DESPUÉS (Modelo Rico)
```java
public class PadronElectoral {
    private final PadronElectoralId id;
    private final TipoPadron tipoPadron;  // Enum tipado
    private final LocalDateTime fechaCreacion;
    private final List<Ciudadano> ciudadanos;  // Inmutable
    
    private PadronElectoral(Builder builder) {
        this.id = Objects.requireNonNull(builder.id);
        this.tipoPadron = Objects.requireNonNull(builder.tipoPadron);
        // Validaciones en construcción
    }
    
    // Factory methods
    public static PadronElectoral crear(...) { }
    public static PadronElectoral reconstruir(...) { }
    
    // Métodos de dominio
    public PadronElectoral actualizar(ActualizacionPadron act) { }
    public boolean estaActualizado() { }
    public int contarCiudadanos() { }
    public boolean perteneceACircunscripcion(...) { }
    
    // Collections inmutables
    public List<Ciudadano> getCiudadanos() {
        return Collections.unmodifiableList(ciudadanos);
    }
    
    // Builder pattern
    public static class Builder { ... }
}
```

**Ventajas**:
- ✅ Inmutable y thread-safe
- ✅ Validaciones estrictas
- ✅ Comportamiento rico
- ✅ Tipos de dominio (no primitivos)
- ✅ Desacoplado de DTOs
- ✅ Lógica de negocio encapsulada
- ✅ Factory methods expresivos

## 📊 Métricas del Modelo Rico

| Archivo | Líneas | Tipo | Características |
|---------|--------|------|-----------------|
| PadronElectoral.java | 226 | Aggregate Root | Inmutable, Builder, Factory methods, 8 métodos de dominio |
| Ciudadano.java | 94 | Value Object | Inmutable, validaciones, NumeroDocumento compuesto |
| ActualizacionPadron.java | 114 | Value Object | Inmutable, 3 constructores, timestamp automático |
| Circunscripcion.java | 81 | Value Object | Inmutable, normalización, 3 métodos de dominio |
| NumeroDocumento.java | 60 | Value Object | Inmutable, validación regex, 2 métodos de dominio |
| PadronElectoralId.java | 40 | Value Object | Inmutable, tipo seguro |
| TipoPadron.java | 36 | Enum | Conversión desde String |
| TipoProceso.java | 37 | Enum | Conversión desde String |
| TipoVerificacion.java | 36 | Enum | Valor por defecto |

**Total**: 724 líneas de código de dominio rico

## 🎨 Patrones Aplicados

### 1. **Builder Pattern**
- Usado en `PadronElectoral`
- Construcción fluida y expresiva
- Validaciones centralizadas

### 2. **Factory Method**
- `PadronElectoral.crear()` - para nuevos padrones
- `PadronElectoral.reconstruir()` - desde persistencia

### 3. **Value Object Pattern**
- Todos inmutables
- Validaciones en constructor
- equals/hashCode basados en valor

### 4. **Type Object Pattern**
- `PadronElectoralId` en lugar de String
- `NumeroDocumento` en lugar de String
- Enums en lugar de Strings

### 5. **Aggregate Pattern**
- `PadronElectoral` como raíz
- Controla acceso a `Ciudadano` y `ActualizacionPadron`
- Consistencia transaccional

## 🔒 Validaciones Implementadas

### PadronElectoral
- ✅ ID obligatorio (no nulo)
- ✅ TipoPadron obligatorio
- ✅ TipoProceso obligatorio
- ✅ Circunscripción obligatoria
- ✅ Fecha de creación obligatoria

### Circunscripcion
- ✅ Departamento obligatorio (1-50 chars)
- ✅ Provincia obligatoria (1-50 chars)
- ✅ Distrito obligatorio (1-50 chars)
- ✅ Normalización a mayúsculas

### Ciudadano
- ✅ Nombre obligatorio (1-200 chars)
- ✅ Documento válido (DNI 8 o CE 9 dígitos)
- ✅ Dirección obligatoria (1-300 chars)
- ✅ Normalización de nombre a mayúsculas

### NumeroDocumento
- ✅ Formato válido: `^\\d{8}$` o `^\\d{9}$`
- ✅ Solo dígitos numéricos

### ActualizacionPadron
- ✅ Usuario responsable obligatorio
- ✅ Informe de verificación obligatorio
- ✅ Tipo de verificación obligatorio
- ✅ Fecha automática en creación

## 🚀 Beneficios del Modelo Rico

### 1. **Integridad de Datos**
- Imposible crear objetos inválidos
- Validaciones automáticas en construcción
- Estado consistente garantizado

### 2. **Expresividad**
```java
// Antes (anémico)
padron.setTipoPadron("FINAL");
padron.setFechaActualizacion(LocalDateTime.now());

// Después (rico)
PadronElectoral padronActualizado = padron.actualizar(
    new ActualizacionPadron(usuario, informe, TipoPadron.FINAL, TipoVerificacion.DOCUMENTAL)
);
```

### 3. **Seguridad de Tipos**
```java
// Antes
String tipoPadron = "FNAL";  // Typo no detectado

// Después
TipoPadron tipo = TipoPadron.FINAL;  // Type-safe, IDE autocomplete
```

### 4. **Testabilidad**
- Objetos inmutables fáciles de testear
- Sin efectos secundarios
- Comportamiento predecible

### 5. **Mantenibilidad**
- Lógica de negocio en un solo lugar
- Fácil de entender y modificar
- Cambios localizados

## 📝 Ejemplo de Uso

```java
// Crear un nuevo padrón
PadronElectoral padron = PadronElectoral.crear(
    "PAD-2025-001",
    TipoPadron.INICIAL,
    TipoProceso.ELECCIONES_GENERALES,
    new Circunscripcion("Lima", "Lima", "Miraflores"),
    Arrays.asList(
        new Ciudadano("Juan Pérez", "12345678", "Av. Larco 123"),
        new Ciudadano("María García", "87654321", "Calle Los Olivos 456")
    )
);

// Verificar lógica de negocio
if (padron.perteneceACircunscripcion("Lima", "Lima", "Miraflores")) {
    System.out.println("Padrón válido para Miraflores");
}

int totalVotantes = padron.contarCiudadanos();  // 2

// Actualizar padrón (retorna nueva instancia)
ActualizacionPadron actualizacion = new ActualizacionPadron(
    "USR-001",
    "INF-VER-2025-01",
    TipoPadron.FINAL,
    TipoVerificacion.PRESENCIAL
);

PadronElectoral padronFinal = padron.actualizar(actualizacion);

// Verificar cambio
if (padronFinal.esFinal()) {
    System.out.println("Padrón finalizado y listo para elecciones");
}
```

## ✅ Conclusión

El modelo de dominio ahora es:
- ✅ **Rico** en comportamiento y lógica de negocio
- ✅ **Inmutable** y thread-safe
- ✅ **Validado** automáticamente
- ✅ **Expresivo** con métodos de dominio
- ✅ **Desacoplado** de DTOs e infraestructura
- ✅ **Type-safe** con enums y value objects
- ✅ **Testeable** y mantenible

Este es un verdadero **modelo de dominio DDD**, no un simple modelo de datos.
