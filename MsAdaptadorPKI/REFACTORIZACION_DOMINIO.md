# Refactorización del Modelo de Dominio - MsAdaptadorPKI

## Fecha: 3 de diciembre de 2025

## Problema Identificado

El modelo de dominio original estaba **anémico** y demasiado alineado a los DTOs:
- Clases con solo getters/setters sin comportamiento
- No encapsulaba reglas de negocio
- Usaba tipos primitivos (String) en lugar de Value Objects
- No validaba invariantes del dominio
- Permitía estados inválidos

## Solución Implementada: Modelo de Dominio Rico (DDD)

### Principios Aplicados

1. **Value Objects**: Encapsular conceptos de negocio con validación
2. **Enums para constantes**: Tipo seguro para estados y tipos
3. **Inmutabilidad**: Objetos de dominio inmutables donde sea posible
4. **Factory Methods**: Constructores privados + métodos de creación con validación
5. **Comportamiento de negocio**: Métodos que representen operaciones del dominio
6. **Sin setters**: Evitar mutación descontrolada

---

## Archivos Creados (14 nuevos Value Objects y Enums)

### Value Objects (10)

1. **NumeroSolicitud** - Número de solicitud de certificado (10 caracteres)
2. **NumeroCertificado** - Número de certificado emitido (10 caracteres)
3. **DNI** - Documento nacional de identidad (8 dígitos, validado)
4. **Email** - Dirección de correo electrónico (validación RFC 5322)
5. **Ciudadano** - Datos de identidad del ciudadano con comportamiento
6. **ContactoCiudadano** - Información de contacto del ciudadano
7. **PeriodoValidez** - Período de validez del certificado con lógica de expiración
8. **ClavePublica** - Clave pública en Base64 validada
9. **NumerosSolicitud** - Conjunto de 3 números de solicitud

### Enums (6)

10. **TipoCertificado** - AUTENTICACION, FIRMA, CIFRADO
11. **EstadoCertificado** - PENDIENTE, VIGENTE, REVOCADO, EXPIRADO
12. **TipoDocumento** - DNI, CE, PASAPORTE
13. **MotivoRevocacion** - Motivos válidos para revocar certificados
14. **Sexo** - MASCULINO, FEMENINO
15. **EstadoCivil** - SOLTERO, CASADO, DIVORCIADO, VIUDO, CONVIVIENTE

---

## Archivos Refactorizados (3 Aggregates)

### 1. CertificadoDigital (Aggregate Root)

**ANTES** (Modelo Anémico):
```java
public class CertificadoDigital {
    private String tipo;
    private String numeroSolicitud;
    private String numeroDni;
    // ... 14 campos String/LocalDateTime
    
    // Solo getters/setters - SIN comportamiento
}
```

**DESPUÉS** (Modelo Rico):
```java
public class CertificadoDigital {
    private final TipoCertificado tipo;
    private final NumeroSolicitud numeroSolicitud;
    private final Ciudadano ciudadano;
    private PeriodoValidez periodoValidez;
    private EstadoCertificado estado;
    // ... Value Objects
    
    // Constructor privado
    private CertificadoDigital(...) { }
    
    // Factory Method con validación
    public static CertificadoDigital crear(...) {
        // validaciones de negocio
    }
    
    // COMPORTAMIENTO DE NEGOCIO
    public void emitir(...) { }
    public void revocar(MotivoRevocacion motivo) { }
    public boolean estaVigente() { }
    public boolean haExpirado() { }
    public void verificarExpiracion() { }
    public long diasRestantesValidez() { }
    
    // Solo getters (inmutabilidad)
}
```

**Reglas de Negocio Implementadas**:
- ✅ Solo se puede emitir un certificado PENDIENTE
- ✅ Solo se puede revocar un certificado VIGENTE
- ✅ Fecha de expiración debe ser posterior a emisión
- ✅ Verifica automáticamente si está vigente/expirado
- ✅ Calcula días restantes de validez

---

### 2. SolicitudCertificado (Aggregate)

**ANTES**:
```java
public class SolicitudCertificado {
    private String numeroCertificados;
    private CertificadoDigital certificadoAutenticacion;
    private CertificadoDigital certificadoFirma;
    private CertificadoDigital certificadoCifrado;
    private DatosAdicionales datosAdicionales;
    
    // Getters/Setters
}
```

**DESPUÉS**:
```java
public class SolicitudCertificado {
    private final String numeroCertificados;
    private final CertificadoDigital certificadoAutenticacion;
    private final CertificadoDigital certificadoFirma;
    private final CertificadoDigital certificadoCifrado;
    private final ContactoCiudadano contactoCiudadano;
    
    // Constructor privado
    private SolicitudCertificado(...) { }
    
    // Factory Method con validación
    public static SolicitudCertificado crear(...) {
        // Valida que los 3 certificados existan
        // Valida que sean del tipo correcto
        // Valida que sean del mismo ciudadano
    }
    
    // COMPORTAMIENTO
    public List<CertificadoDigital> obtenerTodosCertificados() { }
    public boolean todosVigentes() { }
    public boolean algunoExpirado() { }
    public Ciudadano getCiudadano() { }
    
    // Solo getters
}
```

**Reglas de Negocio Implementadas**:
- ✅ Los 3 certificados deben proporcionarse
- ✅ Cada certificado debe ser del tipo correcto
- ✅ Todos los certificados deben ser del mismo ciudadano
- ✅ Provee operaciones de consulta de estado agregado

---

### 3. SolicitudNumerosSecuencia (Value Object Complejo)

**ANTES**:
```java
public class SolicitudNumerosSecuencia {
    private String dni;
    private String nombres;
    private String apellidoPaterno;
    // ... 15 campos String
    
    // Getters/Setters
}
```

**DESPUÉS**:
```java
public class SolicitudNumerosSecuencia {
    private final Ciudadano ciudadano;
    private final ContactoCiudadano contacto;
    private final String codigoOficina;
    private final Sexo sexo;
    private final EstadoCivil estadoCivil;
    // ... Value Objects
    
    // Constructor privado
    private SolicitudNumerosSecuencia(...) { }
    
    // Factory Method con validación
    public static SolicitudNumerosSecuencia crear(...) {
        // Validaciones de negocio
    }
    
    // Solo getters
}
```

**Reglas de Negocio Implementadas**:
- ✅ Ciudadano y contacto son obligatorios
- ✅ Código de oficina debe tener 5 caracteres
- ✅ Nacionalidad por defecto "PERUANA"
- ✅ Agrupa datos relacionados en Value Objects

---

## Ejemplos de Value Objects con Validación

### DNI
```java
public class DNI {
    private final String numero;
    private static final Pattern PATRON_DNI = Pattern.compile("^\\d{8}$");
    
    public static DNI de(String numero) {
        // Valida formato 8 dígitos
        if (!PATRON_DNI.matcher(dniLimpio).matches()) {
            throw new IllegalArgumentException(...);
        }
        return new DNI(dniLimpio);
    }
}
```

### Email
```java
public class Email {
    private final String valor;
    private static final Pattern PATRON_EMAIL = Pattern.compile(...);
    
    public static Email de(String email) {
        // Valida formato RFC 5322
        if (!PATRON_EMAIL.matcher(emailLimpio).matches()) {
            throw new IllegalArgumentException(...);
        }
        return new Email(emailLimpio);
    }
}
```

### Ciudadano
```java
public class Ciudadano {
    private final DNI dni;
    private final String apellidoPaterno;
    // ...
    
    public static Ciudadano de(...) {
        // Validaciones de campos obligatorios
    }
    
    public int calcularEdad() { }
    public String getNombreCompleto() { }
    public boolean esMayorDeEdad() { }
}
```

---

## Comparación: Antes vs Después

| Aspecto | ANTES (Anémico) | DESPUÉS (Rico) |
|---------|-----------------|----------------|
| **Validación** | En DTOs o servicios | En el dominio mismo |
| **Tipos** | String primitivos | Value Objects tipados |
| **Estados** | Cualquier valor String | Enums con valores válidos |
| **Comportamiento** | Solo getters/setters | Métodos de negocio |
| **Invariantes** | No protegidas | Protegidas por constructores privados |
| **Mutabilidad** | Setters públicos | Inmutables (final fields) |
| **Factory** | Constructor público | Factory Methods con validación |
| **Igualdad** | Por referencia | equals/hashCode por valor |

---

## Beneficios del Modelo Rico

### 1. **Validación Centralizada**
- Las reglas de negocio están en el dominio, no dispersas
- Imposible crear objetos en estado inválido

### 2. **Type Safety**
- `TipoCertificado.AUTENTICACION` vs `"AUTENTICACION"` (error prone)
- El compilador ayuda a detectar errores

### 3. **Expresividad**
```java
// ANTES
if (certificado.getEstadoCertificado().equals("VIGENTE") && 
    LocalDateTime.now().isBefore(certificado.getFechaExpiracion())) {
    // ...
}

// DESPUÉS
if (certificado.estaVigente()) {
    // ...
}
```

### 4. **Encapsulación**
- El estado interno no se puede corromper
- Solo se pueden aplicar operaciones válidas

### 5. **Testabilidad**
- Métodos de negocio son testeables unitariamente
- No se necesita mockear para validaciones

### 6. **Documentación**
- El código documenta las reglas de negocio
- Los tipos comunican intención

---

## Estructura Final del Dominio

```
domain/model/
├── Aggregates & Entities
│   ├── CertificadoDigital.java       (Aggregate Root - Rico en comportamiento)
│   ├── SolicitudCertificado.java     (Aggregate - Validaciones de conjunto)
│   └── SolicitudNumerosSecuencia.java (Value Object complejo)
│
├── Value Objects
│   ├── NumeroSolicitud.java          (10 caracteres, validado)
│   ├── NumeroCertificado.java        (10 caracteres, validado)
│   ├── DNI.java                      (8 dígitos, validado)
│   ├── Email.java                    (RFC 5322, validado)
│   ├── Ciudadano.java                (Identidad + comportamiento)
│   ├── ContactoCiudadano.java        (Datos de contacto)
│   ├── PeriodoValidez.java           (Lógica de fechas)
│   ├── ClavePublica.java             (Base64, validado)
│   ├── NumerosSolicitud.java         (Conjunto de 3 números)
│   ├── RespuestaPKI.java             (DTO técnico - simple)
│   ├── MetadataRespuesta.java        (DTO técnico - simple)
│   ├── ErrorResponse.java            (DTO técnico - simple)
│   └── DetalleError.java             (DTO técnico - simple)
│
└── Enums
    ├── TipoCertificado.java          (AUTENTICACION, FIRMA, CIFRADO)
    ├── EstadoCertificado.java        (PENDIENTE, VIGENTE, REVOCADO, EXPIRADO)
    ├── TipoDocumento.java            (DNI, CE, PASAPORTE)
    ├── MotivoRevocacion.java         (8 motivos válidos)
    ├── Sexo.java                     (MASCULINO, FEMENINO)
    └── EstadoCivil.java              (5 estados)
```

**Total**: 24 archivos en el dominio (vs 9 originales)

---

## Reglas de Negocio Capturadas

### CertificadoDigital
1. Solo se emite si está PENDIENTE
2. Solo se revoca si está VIGENTE
3. Fecha expiración > fecha emisión
4. Auto-verificación de expiración
5. Cálculo de días restantes

### SolicitudCertificado
1. Los 3 certificados son obligatorios
2. Cada uno debe ser del tipo correcto
3. Todos del mismo ciudadano
4. Validación de conjunto

### Value Objects
1. DNI: exactamente 8 dígitos
2. NumeroSolicitud/NumeroCertificado: 10 caracteres
3. Email: formato RFC 5322
4. ClavePublica: Base64 válido
5. Ciudadano: campos obligatorios
6. PeriodoValidez: fechas coherentes

---

## Próximos Pasos

### Para el Mapper (Infraestructura → Dominio)
El mapper ahora necesita:
1. Convertir Strings a Value Objects
2. Convertir Strings a Enums
3. Usar Factory Methods del dominio
4. Manejar excepciones de validación

### Para los Servicios
Los servicios ahora pueden:
1. Confiar en que el dominio está válido
2. Enfocarse en orquestación
3. No duplicar validaciones

### Para los Tests
1. Testear reglas de negocio directamente
2. Verificar que objetos inválidos no se pueden crear
3. Testear comportamiento de negocio

---

## Conclusión

El modelo de dominio ahora:
- ✅ **Es rico en comportamiento** (no anémico)
- ✅ **Encapsula reglas de negocio** (no en servicios)
- ✅ **Usa tipos del dominio** (no primitivos)
- ✅ **Protege invariantes** (constructor privado + factory)
- ✅ **Es inmutable** (final fields, sin setters)
- ✅ **Es expresivo** (nombres de negocio)
- ✅ **Es testeable** (lógica unitaria)
- ✅ **Es mantenible** (reglas centralizadas)

El modelo de dominio representa verdaderamente el **lenguaje ubicuo** del negocio de certificados digitales del DNIe.
