# MsDominioParentesco - Microservicio Dominio Parentesco

## Información General

**Nombre del Microservicio:** MsDominioParentesco (Microservicio Dominio Parentesco)  
**Versión del API:** v1  
**Paquete Base:** pe.gob.reniec.dominio.parentesco  
**Tipo:** Microservicio de Dominio (MsDominio)  
**Organización:** RENIEC (Registro Nacional de Identificación y Estado Civil)

## Contexto de Negocio

El Microservicio Dominio Parentesco es el componente de lógica de negocio de la plataforma SIIRC especializado en el análisis, validación y certificación de vínculos familiares entre ciudadanos. Su propósito principal es gestionar y centralizar toda la inteligencia de negocio relacionada con el análisis de parentesco, actuando como el motor que verifica la coherencia de las relaciones familiares contra las reglas del registro civil peruano.

Este microservicio orquesta el proceso completo de análisis de vínculos, desde la recepción de una solicitud hasta la generación automática de la población de posibles vínculos, coordinando la consulta de datos del APD y actas registrales para establecer cadenas de parentesco hasta el cuarto grado de consanguinidad y segundo de afinidad.

## Arquitectura

Este microservicio sigue una **Arquitectura Hexagonal** estricta con las siguientes características:

- **Sin dependencias de frameworks:** Código Java puro sin anotaciones de Spring, JPA, JAX-RS, etc.
- **Sin tecnología concreta:** No se define el protocolo de comunicación con servicios externos (HTTP, SOAP, colas, etc.)
- **Tipo MsDominio:** NO define `RepositoryPort`. Se integra con componentes externos (MsDataParentesco, MsSagaAPD, MsDatosActas) a través de puertos de salida y adaptadores.

### Estructura del Proyecto

```
src/main/java/pe/gob/reniec/dominio/parentesco/
├── domain/
│   ├── model/                          # Entidades del dominio (POJOs)
│   │   ├── ActaPendienteDigitalizacion.java
│   │   ├── ActaSustento.java
│   │   ├── AnalisisParentesco.java     # Aggregate Root
│   │   ├── CiudadanoAnalizado.java
│   │   ├── ConyugeIntermedio.java
│   │   ├── CriteriosBusqueda.java
│   │   ├── DatosAPD.java
│   │   ├── DatosCiudadano.java
│   │   ├── Inconsistencia.java
│   │   ├── Metadata.java
│   │   ├── OpcionesAnalisis.java
│   │   ├── PoblacionVinculosPosibles.java
│   │   ├── RangoAnios.java
│   │   ├── ResumenAnalisis.java
│   │   ├── ServiciosConsultados.java
│   │   ├── SolicitudAnalisisParentesco.java
│   │   ├── VinculoAfinidad.java
│   │   └── VinculoConsanguineo.java
│   └── ports/
│       ├── in/                         # Puertos de entrada (use cases)
│       │   └── EjecutarAnalisisParentescoUseCase.java
│       └── out/                        # Puertos de salida (hacia servicios externos)
│           ├── APDDataPort.java
│           ├── ActasDataPort.java
│           └── ParentescoDataPort.java
├── application/
│   └── service/                        # Servicios de aplicación
│       └── EjecutarAnalisisParentescoService.java
└── infrastructure/
    └── adapters/
        ├── in/
        │   └── rest/
        │       ├── controller/
        │       │   └── ParentescoController.java
        │       ├── dto/                # DTOs (records)
        │       │   ├── AnalisisParentescoDataResponseDto.java
        │       │   ├── AnalisisParentescoResponseDto.java
        │       │   ├── ActaPendienteDigitalizacionResponseDto.java
        │       │   ├── ActaSustentoResponseDto.java
        │       │   ├── CiudadanoAnalizadoResponseDto.java
        │       │   ├── ConyugeIntermedioResponseDto.java
        │       │   ├── CriteriosBusquedaRequestDto.java
        │       │   ├── DatosAPDResponseDto.java
        │       │   ├── DatosCiudadanoRequestDto.java
        │       │   ├── DetalleErrorDto.java
        │       │   ├── ErrorDto.java
        │       │   ├── ErrorResponseDto.java
        │       │   ├── InconsistenciaResponseDto.java
        │       │   ├── MetadataResponseDto.java
        │       │   ├── OpcionesAnalisisRequestDto.java
        │       │   ├── PoblacionVinculosPosiblesResponseDto.java
        │       │   ├── RangoAniosRequestDto.java
        │       │   ├── ResumenAnalisisResponseDto.java
        │       │   ├── ServiciosConsultadosResponseDto.java
        │       │   ├── SolicitudAnalisisParentescoRequestDto.java
        │       │   ├── VinculoAfinidadResponseDto.java
        │       │   └── VinculoConsanguineoResponseDto.java
        │       └── mapper/
        │           └── ParentescoDtoMapper.java
        └── out/
            └── msdata/
                └── client/             # Adaptadores hacia servicios externos
                    ├── APDDataAdapter.java
                    ├── ActasDataAdapter.java
                    └── ParentescoDataAdapter.java
```

## Endpoints

### POST /api/v1/parentesco/MsDominioParentesco/analisis/ejecutar

Inicia y ejecuta el proceso de análisis de vínculos de parentesco para una persona natural.

#### Headers

| Header | Tipo | Obligatorio | Descripción |
|--------|------|-------------|-------------|
| Authorization | String | Sí | Bearer token JWT para autenticación |
| Content-Type | String | Sí | application/json |
| X-Correlation-ID | UUID | Sí | Identificador único de correlación para trazabilidad end-to-end |
| X-Office-Code | String | Sí | Código de oficina RENIEC (formato: ORG-LIMA-CENTRO) |
| X-User-Role | String | Sí | Rol del usuario (TECNICO_VINCULO, COORDINADOR_VINCULO) |
| X-Idempotency-Key | UUID | Sí | Clave de idempotencia para evitar duplicados |

#### Request Body

```json
{
  "idSolicitud": "string",
  "idCiudadanoConsultado": "string",
  "datosCiudadano": {
    "nombres": "string",
    "apellidoPaterno": "string",
    "apellidoMaterno": "string",
    "fechaNacimiento": "YYYY-MM-DD",
    "sexo": "string",
    "estadoCivil": "string"
  },
  "tipoVinculo": "string",
  "nivelComplejidad": 1,
  "criteriosBusqueda": {
    "rangoAniosPadres": {
      "anioInicio": 1950,
      "anioFin": 1980
    },
    "rangoAniosHijos": {
      "anioInicio": 2000,
      "anioFin": 2024
    },
    "variacionesNombre": ["string"],
    "incluirFallecidos": true,
    "incluirActasAnuladas": false
  },
  "opcionesAnalisis": {
    "generarArbolGenealogico": true,
    "validarContraAPD": true,
    "incluirActasSustento": true,
    "detectarInconsistencias": true
  },
  "usuarioTecnico": "string",
  "observaciones": "string"
}
```

#### Response Body (Éxito)

```json
{
  "success": true,
  "data": {
    "idAnalisis": "string",
    "idSolicitud": "string",
    "idCiudadanoConsultado": "string",
    "tipoVinculo": "string",
    "nivelComplejidad": 1,
    "estado": "string",
    "ciudadanoAnalizado": {
      "idCiudadano": "string",
      "nombreCompleto": "string",
      "fechaNacimiento": "YYYY-MM-DD",
      "estadoCivil": "string",
      "datosAPD": {
        "version": "string",
        "ultimaActualizacion": "YYYY-MM-DDThh:mm:ss±hh:mm",
        "estadoAPD": "string"
      }
    },
    "poblacionVinculosPosibles": {
      "totalEncontrados": 0,
      "vinculosConsanguineos": [],
      "vinculosAfinidad": []
    },
    "resumenAnalisis": {
      "vinculosGrado1": 0,
      "vinculosGrado2": 0,
      "vinculosGrado3": 0,
      "vinculosGrado4": 0,
      "vinculosAfinidad": 0,
      "actasConsultadas": 0,
      "actasNoDigitalizadas": 0,
      "inconsistenciasDetectadas": 0
    },
    "inconsistencias": [],
    "actasPendientesDigitalizacion": [],
    "fechaAnalisis": "YYYY-MM-DDThh:mm:ss±hh:mm",
    "tiempoProcesamientoMs": 0,
    "usuarioTecnico": "string"
  },
  "metadata": {
    "timestamp": "YYYY-MM-DDThh:mm:ss±hh:mm",
    "correlationId": "string",
    "version": "string",
    "serviciosConsultados": {
      "msSagaAPD": true,
      "msDatosActas": true,
      "msDatosParentesco": true
    }
  }
}
```

#### Response Body (Error)

```json
{
  "error": {
    "tipo": "string",
    "titulo": "string",
    "estado": 400,
    "errores": [
      {
        "detalleError": "string"
      }
    ]
  }
}
```

#### Status Codes

| Código | Descripción |
|--------|-------------|
| 200 | OK - Ejecución realizada exitosamente |
| 202 | Accepted - Procesamiento asíncrono en curso |
| 400 | Bad Request - Parámetros inválidos o incompletos |
| 401 | Unauthorized - Token inválido o ausente |
| 403 | Forbidden - Sin permisos para análisis |
| 404 | Not Found - Ciudadano no encontrado |
| 408 | Request Timeout - Timeout en servicios externos |
| 409 | Conflict - Análisis activo existente |
| 422 | Unprocessable Entity - Complejidad incompatible |
| 429 | Too Many Requests - Rate limit excedido |
| 500 | Internal Server Error - Error interno |
| 502 | Bad Gateway - MsSagaAPD o MsDatosActas caído |
| 503 | Service Unavailable - Servicio no disponible |
| 504 | Gateway Timeout - Timeout en consulta externa |

## Entidades del Dominio

### Mapeo de Tipos de Datos

| Tipo JSON | Tipo Java |
|-----------|-----------|
| string | String |
| integer | Integer |
| long | Long |
| number | Double |
| boolean | Boolean |
| date (YYYY-MM-DD) | LocalDate |
| datetime (ISO 8601) | LocalDateTime |
| array | List\<T\> |

### Entidades Principales

1. **SolicitudAnalisisParentesco** - Solicitud de análisis de parentesco
2. **AnalisisParentesco** - Resultado del análisis (Aggregate Root)
3. **CiudadanoAnalizado** - Datos del ciudadano analizado
4. **PoblacionVinculosPosibles** - Contenedor de vínculos encontrados
5. **VinculoConsanguineo** - Vínculo por consanguinidad
6. **VinculoAfinidad** - Vínculo por afinidad
7. **ResumenAnalisis** - Resumen estadístico del análisis
8. **Inconsistencia** - Inconsistencias detectadas
9. **ActaPendienteDigitalizacion** - Actas no digitalizadas
10. **Metadata** - Metadatos de la respuesta

## Puertos y Adaptadores

### Puertos de Entrada (In)

- **EjecutarAnalisisParentescoUseCase** - Ejecutar análisis de parentesco

### Puertos de Salida (Out)

- **APDDataPort** - Consultar datos del APD desde MsSagaAPD
- **ActasDataPort** - Consultar actas registrales desde MsDatosActas
- **ParentescoDataPort** - Gestionar análisis en MsDatosParentesco

### Adaptadores de Salida

- **APDDataAdapter** - Implementa APDDataPort (sin protocolo definido)
- **ActasDataAdapter** - Implementa ActasDataPort (sin protocolo definido)
- **ParentescoDataAdapter** - Implementa ParentescoDataPort (sin protocolo definido)

## Servicios Externos Consultados

1. **MsSagaAPD** - Consulta del Archivo Personal de Datos
2. **MsDatosActas** - Consulta de actas registrales (nacimiento, matrimonio, defunción)
3. **MsDatosParentesco** - Persistencia de análisis de parentesco

## Reglas de Negocio

1. **Análisis de Parentesco:**
   - Basado en consulta del APD del ciudadano
   - Correlación con actas registrales
   - Cadenas de parentesco hasta 4° grado de consanguinidad
   - Cadenas de parentesco hasta 2° grado de afinidad

2. **Nivel de Complejidad:** Valor entre 1 y 4 que determina la profundidad del análisis

3. **Grados de Parentesco:**
   - Grado 1: Padres, hijos
   - Grado 2: Abuelos, nietos, hermanos
   - Grado 3: Bisabuelos, bisnietos, tíos, sobrinos
   - Grado 4: Tatarabuelos, tataranietos, primos hermanos, tíos abuelos, sobrinos nietos

4. **Validaciones:**
   - Coherencia de relaciones familiares
   - Detección de inconsistencias
   - Validación contra APD (opcional)

5. **Seguridad y Trazabilidad:**
   - Autenticación mediante JWT
   - Roles: TECNICO_VINCULO, COORDINADOR_VINCULO
   - Correlación end-to-end
   - Idempotencia

## Limitaciones

1. **Sin frameworks:** El código es Java puro sin dependencias de frameworks específicos
2. **Sin protocolo de comunicación:** Los adaptadores no definen cómo conectarse a servicios externos (HTTP, SOAP, colas, etc.)
3. **Sin implementación de lógica:** Los servicios y adaptadores lanzan `UnsupportedOperationException` como placeholders
4. **Sin anotaciones:** No se usan anotaciones de Spring, JPA, JAX-RS, etc.
5. **Sin build configuration:** No se proporciona pom.xml ni configuraciones de construcción
6. **Solo estructura:** Este proyecto define únicamente la estructura y contratos (interfaces), no la implementación completa

## Tipo de Microservicio

**MsDominio** - Este es un microservicio de dominio que:
- NO define `RepositoryPort` ni `RepositoryAdapter`
- Se integra con MsDataParentesco a través de puertos de salida (`ParentescoDataPort`)
- Orquesta la lógica de negocio del análisis de parentesco
- Consulta datos de servicios externos (APD, Actas) sin asumir el protocolo

## Próximos Pasos

Para completar la implementación:

1. Implementar la lógica de negocio en `EjecutarAnalisisParentescoService`
2. Implementar los adaptadores con tecnología específica (RestTemplate, WebClient, etc.)
3. Agregar validaciones y manejo de errores
4. Configurar dependencias en pom.xml o build.gradle
5. Agregar anotaciones de framework si se decide usar Spring, Quarkus, etc.
6. Implementar seguridad, logging y observabilidad
7. Crear tests unitarios e integración

## Contacto

**Responsable:** Arquitecto de Software  
**Organización:** RENIEC  
**Fecha:** 01/12/2025
