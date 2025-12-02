# Microservicio MsDNI

## Tipo de Microservicio
**MsDominio** (Microservicio de Dominio)

## Descripción
Microservicio encargado de exponer tres endpoints de consulta de datos de ciudadanos del Registro Nacional de Identificación y Estado Civil (RENIEC) del Perú. Opera en ambientes de producción y pruebas, consultando información a través del CUI (Código Único de Identificación / DNI) del ciudadano.

**Características principales:**
- Solo operaciones de consulta (GET) - sin escritura, modificación o borrado
- Retorna información en formato JSON estructurado
- Destinado a aplicaciones internas del proyecto DNId
- Acceso restringido por IP

## Arquitectura
Este proyecto implementa **Arquitectura Hexagonal (Ports & Adapters)** con **Domain-Driven Design (DDD)** siguiendo los principios de tecnología agnóstica:

- ✅ **Sin frameworks** (Spring, JAX-RS, etc.)
- ✅ **Sin anotaciones** (JPA, MapStruct, etc.)
- ✅ **POJOs puros**: interfaces, clases, enums
- ✅ **Implementaciones stub** con `UnsupportedOperationException()`

## Estructura del Proyecto

```
src/main/java/pe/gob/reniec/msdni/
├── domain/
│   ├── model/
│   │   ├── DatosMayorEdad.java
│   │   ├── DatosMenorEdad.java
│   │   └── DatosTarjetaDNI.java
│   └── ports/
│       ├── in/
│       │   ├── ConsultarDatosMayorEdadUseCase.java
│       │   ├── ConsultarDatosMenorEdadUseCase.java
│       │   └── ConsultarDatosTarjetaDNIUseCase.java
│       └── out/
│           ├── DatosMayorEdadDataPort.java        # MsDominio pattern
│           ├── DatosMenorEdadDataPort.java        # MsDominio pattern
│           └── DatosTarjetaDNIDataPort.java       # MsDominio pattern
├── application/
│   └── service/
│       ├── ConsultarDatosMayorEdadService.java
│       ├── ConsultarDatosMenorEdadService.java
│       └── ConsultarDatosTarjetaDNIService.java
└── infrastructure/
    └── adapters/
        ├── in/rest/
        │   ├── controller/
        │   │   ├── DatosMayorEdadController.java
        │   │   ├── DatosMenorEdadController.java
        │   │   └── DatosTarjetaDNIController.java
        │   ├── dto/
        │   │   ├── DatosMayorEdadResponseDto.java (record)
        │   │   ├── DatosMenorEdadResponseDto.java (record)
        │   │   ├── DatosTarjetaDNIResponseDto.java (record)
        │   │   ├── DatosTitularDto.java (record)
        │   │   ├── DatosTitularMenorDto.java (record)
        │   │   ├── ProgenitorDto.java (record)
        │   │   ├── DatosTarjetaDto.java (record)
        │   │   ├── ErrorResponseDto.java (record)
        │   │   └── ErrorDetalleDto.java (record)
        │   └── mapper/
        │       ├── DatosMayorEdadDtoMapper.java
        │       ├── DatosMenorEdadDtoMapper.java
        │       └── DatosTarjetaDNIDtoMapper.java
        └── out/msdata/client/
            ├── DatosMayorEdadDataAdapter.java
            ├── DatosMenorEdadDataAdapter.java
            └── DatosTarjetaDNIDataAdapter.java
```

## Endpoints

### 1. Endpoint: DatosMayorEdad

Consulta datos e imágenes de ciudadanos mayores de edad.

**Especificación:**
- **Path:** `/api/v1/solicitudes/MsDatosSolicitudes`
- **Método:** `GET`
- **Protocolo:** `REST/HTTP`
- **API Gateway:** Interno

**Headers:**
```
Content-Type: application/json
Authorization: Bearer {JWT_TOKEN}
X-Correlation-ID: {UUID}
X-Office-Code: {ORG-CIUDAD-CENTRO}
```

**Parámetros de Entrada:**
| Parámetro | Tipo | Obligatorio | Longitud | Descripción |
|-----------|------|-------------|----------|-------------|
| CUI | String | Sí | 8 | Código Único de Identificación (DNI) |

**Respuesta Exitosa (200 OK):**
```json
{
  "datosTitular": {
    "CUI": "12345678",
    "nombres": "Juan Carlos",
    "apellidoPaterno": "Pérez",
    "apellidoMaterno": "García",
    "fechaNacimiento": "1990-05-15",
    "lugarNacimiento": "Lima, Perú",
    "sexo": "M",
    "estadoCivil": "Soltero",
    "fotografia": "base64_encoded_image_or_url",
    "firma": "base64_encoded_signature_or_url",
    "domicilio": "Av. Ejemplo 123, Lima"
  }
}
```

**Códigos de Estado:**
- `200 OK` - Consulta realizada exitosamente
- `400 Bad Request` - Parámetros inválidos o estructura incorrecta
- `401 Unauthorized` - Token JWT inválido, expirado o ausente
- `403 Forbidden` - Sin permisos para ejecutar la operación
- `408 Request Timeout` - Tiempo de espera agotado
- `422 Unprocessable Entity` - Datos válidos pero no procesables
- `429 Too Many Requests` - Límite de rate limit excedido
- `500 Internal Server Error` - Error interno del servicio

---

### 2. Endpoint: DatosMenorEdad

Consulta datos e imágenes de ciudadanos menores de edad.

**Especificación:**
- **Path:** `/api/v1/solicitudes/MsDatosSolicitudes`
- **Método:** `GET`
- **Protocolo:** `REST/HTTP`
- **API Gateway:** Interno

**Headers:**
```
Content-Type: application/json
Authorization: Bearer {JWT_TOKEN}
X-Correlation-ID: {UUID}
X-Office-Code: {ORG-CIUDAD-CENTRO}
```

**Parámetros de Entrada:**
| Parámetro | Tipo | Obligatorio | Longitud | Descripción |
|-----------|------|-------------|----------|-------------|
| CUI | String | Sí | 8 | Código Único de Identificación (DNI) |

**Respuesta Exitosa (200 OK):**
```json
{
  "datosTitular": {
    "CUI": "87654321",
    "nombresApellidos": "María Luisa Rodríguez Sánchez",
    "fechaNacimiento": "2015-03-20",
    "lugarNacimiento": "Cusco, Perú",
    "sexo": "F",
    "fotografia": "base64_encoded_image_or_url",
    "domicilio": "Jr. Ejemplo 456, Cusco",
    "madre": {
      "CUI": "45678901",
      "nombresApellidos": "Ana Sánchez López"
    },
    "padre": {
      "CUI": "23456789",
      "nombresApellidos": "Carlos Rodríguez Pérez"
    }
  }
}
```

**Códigos de Estado:** *(idénticos a DatosMayorEdad)*

---

### 3. Endpoint: DatosTarjetaDNI

Consulta datos de la tarjeta física del DNI.

**Especificación:**
- **Path:** `/api/v1/solicitudes/MsDatosSolicitudes`
- **Método:** `GET`
- **Protocolo:** `REST/HTTP`
- **API Gateway:** Interno

**Headers:**
```
Content-Type: application/json
Authorization: Bearer {JWT_TOKEN}
X-Correlation-ID: {UUID}
X-Office-Code: {ORG-CIUDAD-CENTRO}
```

**Parámetros de Entrada:**
| Parámetro | Tipo | Obligatorio | Longitud | Descripción |
|-----------|------|-------------|----------|-------------|
| CUI | String | Sí | 8 | Código Único de Identificación (DNI) |

**Respuesta Exitosa (200 OK):**
```json
{
  "datosTarjeta": {
    "fechaEmisionDni": "2020-01-15",
    "fechaCaducidadDni": "2030-01-15",
    "versionDni": 2,
    "numeroTarjeta": "PE123456789"
  }
}
```

**Versiones DNI:**
- `0` - DNI azul (tarjeta antigua)
- `1` - DNIe v1
- `2` - DNIe v2
- `3` - DNIe v3

**Códigos de Estado:** *(idénticos a DatosMayorEdad)*

---

## Entidades del Dominio

### DatosMayorEdad
| Atributo | Tipo Java | Tipo Especificación | Descripción |
|----------|-----------|---------------------|-------------|
| cui | String | string | Código Único de Identificación |
| nombres | String | string | Nombres del ciudadano |
| apellidoPaterno | String | string | Apellido paterno |
| apellidoMaterno | String | string | Apellido materno |
| fechaNacimiento | LocalDate | Date ISO 8601 | Fecha de nacimiento |
| lugarNacimiento | String | string | Lugar de nacimiento |
| sexo | String | string | Sexo del ciudadano |
| estadoCivil | String | string | Estado civil |
| fotografia | String | string (base64/URL) | Fotografía |
| firma | String | string (base64/URL) | Firma |
| domicilio | String | string | Dirección residencial |

### DatosMenorEdad
| Atributo | Tipo Java | Tipo Especificación | Descripción |
|----------|-----------|---------------------|-------------|
| cui | String | string | Código Único de Identificación |
| nombresApellidos | String | string | Nombres y apellidos completos |
| fechaNacimiento | LocalDate | Date ISO 8601 | Fecha de nacimiento |
| lugarNacimiento | String | string | Lugar de nacimiento |
| sexo | String | string | Sexo del menor |
| fotografia | String | string (base64/URL) | Fotografía |
| domicilio | String | string | Dirección residencial |
| madre | Progenitor | object | Datos de la madre |
| padre | Progenitor | object | Datos del padre |

**Progenitor (nested class):**
| Atributo | Tipo Java | Descripción |
|----------|-----------|-------------|
| cui | String | CUI del progenitor |
| nombresApellidos | String | Nombres y apellidos del progenitor |

### DatosTarjetaDNI
| Atributo | Tipo Java | Tipo Especificación | Descripción |
|----------|-----------|---------------------|-------------|
| fechaEmisionDni | LocalDate | Date ISO 8601 | Fecha de emisión del DNI |
| fechaCaducidadDni | LocalDate | Date ISO 8601 | Fecha de caducidad del DNI |
| versionDni | Long | integer | Versión del DNI (0: azul, 1-3: DNIe) |
| numeroTarjeta | String | string | Número único de la tarjeta |

---

## Mapeo de Tipos

### Convenciones de Tipo
| Tipo Especificación | Tipo Java | Justificación |
|---------------------|-----------|---------------|
| string | String | Tipo estándar de texto |
| integer/int/long | Long | Uso de Long por defecto para enteros |
| number/decimal/double | Double | Números de punto flotante |
| boolean | Boolean | Valores booleanos |
| date | LocalDate | Fechas sin hora (YYYY-MM-DD) |
| datetime/Date ISO 8601 | LocalDate | Conversión a LocalDate para fechas simples |
| array/list | List<T> | Colecciones genéricas |
| object | Clase POJO | Objetos complejos anidados |

### Inferencia Inteligente
- Campos con patrones de fecha/hora se mapean a `LocalDate` aunque la especificación indique `string`
- Los códigos de versión se mapean a `Long` para permitir expansión futura

---

## Decisiones Arquitectónicas

### 1. MsDominio (sin Repository)
Este microservicio **NO** implementa `RepositoryPort` ni `RepositoryAdapter` porque:
- Es un servicio de consulta que **delega** operaciones de datos a servicios externos (MsData)
- Utiliza **DataPort** y **DataAdapter** para comunicarse con servicios de datos externos
- Sigue el patrón de microservicio de dominio que orquesta lógica de negocio sin persistencia directa

**Estructura de Puertos:**
```
domain/ports/out/
├── DatosMayorEdadDataPort.java       ← Para servicios externos
├── DatosMenorEdadDataPort.java
└── DatosTarjetaDNIDataPort.java

infrastructure/adapters/out/msdata/client/
├── DatosMayorEdadDataAdapter.java    ← Sin detalles de protocolo
├── DatosMenorEdadDataAdapter.java
└── DatosTarjetaDNIDataAdapter.java
```

### 2. DTOs como Records
Se utiliza la sintaxis de Java `record` para todos los DTOs:
- Inmutabilidad por defecto
- Código más conciso
- Generación automática de `equals()`, `hashCode()` y `toString()`

### 3. Controllers sin Anotaciones
Los controllers son POJOs puros sin anotaciones de frameworks:
- Métodos descriptivos con nombres claros
- Sin dependencia de Spring/JAX-RS
- Preparados para cualquier capa de presentación

### 4. Implementaciones Stub
Todos los métodos lanzan `UnsupportedOperationException()`:
- Estructura completa pero sin lógica implementada
- Listo para implementación futura
- Compilación exitosa garantizada

---

## Códigos de Respuesta HTTP Estándar

| Código | Descripción |
|--------|-------------|
| 200 | OK - Operación completada exitosamente |
| 201 | Created - Recurso creado exitosamente |
| 400 | Bad Request - Parámetros inválidos o datos incompletos |
| 401 | Unauthorized - Token JWT inválido, expirado o ausente |
| 403 | Forbidden - Sin permisos suficientes |
| 404 | Not Found - Recurso no encontrado |
| 408 | Request Timeout - Tiempo de espera agotado |
| 409 | Conflict - Conflicto con el estado actual del recurso |
| 422 | Unprocessable Entity - Datos válidos pero no procesables |
| 429 | Too Many Requests - Límite de rate limit excedido |
| 500 | Internal Server Error - Error interno del servicio |
| 502 | Bad Gateway - Servicio externo no disponible |
| 503 | Service Unavailable - Servicio temporalmente no disponible |
| 504 | Gateway Timeout - Servicio externo no respondió a tiempo |

---

## Formato de Error Estándar

```json
{
  "error": {
    "tipo": "ValidationError",
    "titulo": "Parámetro CUI inválido",
    "estado": 400,
    "errores": [
      {
        "detalleError": "El CUI debe tener exactamente 8 dígitos"
      }
    ]
  }
}
```

---

## Limitaciones Tecnológicas

### ⚠️ Este proyecto NO incluye:
1. **Frameworks de aplicación**: No usa Spring Boot, Micronaut, Quarkus, etc.
2. **Anotaciones de persistencia**: No usa JPA, Hibernate, MyBatis, etc.
3. **Librerías de mapeo**: No usa MapStruct, ModelMapper, etc.
4. **Implementación de red**: Los adapters no especifican HTTP clients, SOAP, messaging, etc.
5. **Configuración de entorno**: No hay `application.properties`, `application.yml`, etc.
6. **Gestión de dependencias**: No hay `pom.xml`, `build.gradle`, etc.

### ✅ Este proyecto SÍ proporciona:
1. **Estructura arquitectónica completa** siguiendo Hexagonal Architecture
2. **Separación clara de responsabilidades** (domain, application, infrastructure)
3. **Contratos bien definidos** (interfaces de ports)
4. **Modelos de dominio puros** sin dependencias externas
5. **DTOs con sintaxis moderna** (Java records)
6. **Documentación exhaustiva** de endpoints y entidades

---

## Próximos Pasos para Implementación

1. **Agregar gestión de dependencias**: Crear `pom.xml` o `build.gradle`
2. **Seleccionar frameworks**: Añadir Spring Boot, Micronaut, etc.
3. **Implementar adapters de red**: HTTP clients, REST templates, etc.
4. **Añadir manejo de errores**: Exception handlers, mapeo de errores HTTP
5. **Configurar seguridad**: Validación de JWT, autorización
6. **Implementar logging y trazabilidad**: Usar X-Correlation-ID
7. **Añadir tests**: Unit tests, integration tests
8. **Configurar CI/CD**: Pipeline de despliegue

---

## Información del Documento

- **Microservicio:** MsDNI
- **Versión Especificación:** 2.0
- **Fecha Generación:** 01/12/2025
- **Organización:** RENIEC (Registro Nacional de Identificación y Estado Civil)
- **Proyecto:** Personalización del DNI Electrónico (DNIe)
- **Paquete Base:** `pe.gob.reniec.msdni`

---

## Contacto y Soporte

Para consultas técnicas o solicitudes de acceso al servicio, contactar al equipo de Gestión de Seguridad Electrónica de RENIEC.

**Nota:** El servicio está destinado exclusivamente a aplicaciones informáticas del proyecto DNId desplegadas en servidores con IPs autorizadas.
