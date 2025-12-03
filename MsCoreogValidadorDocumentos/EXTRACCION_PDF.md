# Extracción del PDF: Microservicio MsCoreogValidadorDocumentos v1.0

## Información General

**Nombre del Microservicio**: MsCoreogValidadorDocumentos  
**Versión del Documento**: 1.0  
**Fecha de Generación del Documento**: 02/12/2025  
**Fecha de Extracción**: 03/12/2025  
**Total de Páginas del PDF**: 19

---

## Contexto del Negocio

**Organización**: RENIEC - Registro Nacional de Identificación y Estado Civil  
**Sistema**: SIIRC - Sistema Integrado de Identificación y Registro Civil

**Descripción del Contexto**:
El RENIEC es el organismo técnico autónomo encargado de la identificación de los peruanos, otorgar el Documento Nacional de Identidad (DNI) y registrar los hechos vitales. En el marco de la modernización y transformación digital del Estado peruano, RENIEC ha desarrollado el DNI Electrónico (DNIe).

**Propósito del Microservicio**:
El Microservicio de Validación de Documentos con IA (MsCoreogValidadorDocumentos) es responsable de la evaluación automática de documentos digitales dentro de la plataforma SIIRC, utilizando modelos de inteligencia artificial para detectar posibles inconsistencias, errores o señales de fraude.

---

## Tipo de Microservicio

**Clasificación**: MsDominio (Microservicio de Dominio)

**Justificación**:
- El nombre comienza con "MsCoreog" (prefijo de dominio, no "MsData")
- Es responsable de la lógica de negocio de validación y evaluación
- Se integra con MsData para persistencia (no define RepositoryPort propio)
- Contiene reglas de negocio complejas (evaluación con IA, verificación de firmas)

---

## Versión del API

**Versión**: v1  
**Path Base**: `/api/v1/documentos/MsCoreogValidadorDocumentos`

---

## Paquete Base Java

**Paquete**: `pe.gob.reniec.coreog.validadordocumentos`

**Justificación**:
- Organización: pe.gob.reniec (RENIEC - Perú)
- Módulo: coreog (Core de Gestión)
- Subdominio: validadordocumentos

---

## Endpoints Identificados

### ENDPOINT 1: Calificar Documento

**Método HTTP**: POST  
**Path Completo**: `/api/v1/documentos/MsCoreogValidadorDocumentos/calificar`  
**API Gateway**: Interno  
**Protocolo**: REST/HTTP

#### Headers Requeridos
- `Authorization: Bearer {JWT_TOKEN}` (Requerido)
- `Content-Type: application/json` (Requerido)
- `X-Correlation-Id: {UUID}` (Opcional, para trazabilidad)
- `X-Usuario-Id: {ID_USUARIO}` (Requerido)
- `X-Oficina-Id: {ID_OFICINA}` (Requerido)

#### Parámetros de Entrada (Request Body)

**Estructura JSON del Request**:
```json
{
  "solicitudId": "string (UUID)",
  "tramiteId": "string",
  "tipoTramite": "string",
  "documentos": [array],
  "parametrosValidacion": {object},
  "usuarioSolicita": "string",
  "oficinaOrigen": "string",
  "fechaSolicitud": "YYYY-MM-DDThh:mm:ssZ",
  "observaciones": "string"
}
```

**Detalle de Campos**:

| Campo | Tipo | Obligatorio | Long. Min | Long. Max | Descripción |
|-------|------|-------------|-----------|-----------|-------------|
| solicitudId | String (UUID) | Sí | 36 | 36 | ID de la solicitud |
| tramiteId | String | Sí | 3 | 50 | ID del trámite |
| tipoTramite | String | Sí | 5 | 100 | Tipo de trámite |
| documentos | Array | Sí | 1 doc | 20 docs | Lista de documentos a validar |
| usuarioSolicita | String | Sí | 5 | 50 | Usuario solicitante |
| oficinaOrigen | String | Sí | 5 | 50 | Oficina de origen |
| fechaSolicitud | String (ISO 8601) | Sí | - | - | Fecha de solicitud |
| observaciones | String | No | 0 | 500 | Observaciones |

**Estructura de `documentos[]`**:

| Campo | Tipo | Obligatorio | Long. Min | Long. Max | Descripción |
|-------|------|-------------|-----------|-----------|-------------|
| documentoId | String (UUID) | Sí | 36 | 36 | ID del documento |
| tipoDocumental | String | Sí | 3 | 50 | Tipo documental |
| nombreArchivo | String | Sí | 3 | 200 | Nombre del archivo |
| rutaGestorDocumental | String (URI) | Sí | 10 | 500 | Ruta en el gestor documental |
| hashSHA256 | String | Sí | 64 | 64 | Hash SHA-256 del documento |
| formatoDocumento | String | Sí | 3 | 10 | Formato (PDF, JPG, PNG, etc.) |
| tamanioBytes | Integer | Sí | - | - | Tamaño en bytes |
| requiereValidacionIA | Boolean | Sí | - | - | Si requiere validación con IA |

**Estructura de `parametrosValidacion`** (Opcional):

| Campo | Tipo | Obligatorio | Long. Min | Long. Max | Descripción |
|-------|------|-------------|-----------|-----------|-------------|
| nivelPonderacionMinimo | Decimal | No | - | - | Nivel de ponderación mínimo |
| modeloIA | String | No | 3 | 50 | Modelo de IA a utilizar |
| tiposObservacion | Array | No | 0 | 20 | Tipos de observación aplicables |

#### Parámetros de Salida (Response Body)

**Estructura JSON del Response**:
```json
{
  "success": boolean,
  "data": {
    "evaluacionId": "string (UUID)",
    "solicitudId": "string (UUID)",
    "tramiteId": "string",
    "fechaEvaluacion": "YYYY-MM-DDThh:mm:ssZ",
    "modeloIAUtilizado": "string",
    "tiempoProcesamientoMs": integer,
    "resultadoGeneral": {object},
    "documentosEvaluados": [array],
    "accionesRecomendadas": [array]
  },
  "metadata": {object},
  "error": {object}
}
```

**Campos Principales del Response**:

| Campo | Tipo | Obligatorio | Descripción |
|-------|------|-------------|-------------|
| success | Boolean | Sí | Indica si la operación fue exitosa |
| data.evaluacionId | String (UUID) | Sí | ID de la evaluación generada |
| data.solicitudId | String (UUID) | Sí | UUID de la solicitud evaluada |
| data.tramiteId | String | Sí | ID del trámite asociado |
| data.fechaEvaluacion | String (ISO 8601) | Sí | Fecha/hora de procesamiento |
| data.modeloIAUtilizado | String | Sí | Versión del modelo de IA utilizado |
| data.tiempoProcesamientoMs | Integer | Sí | Tiempo total en milisegundos |

**Estructura de `resultadoGeneral`**:

| Campo | Tipo | Descripción |
|-------|------|-------------|
| estado | String | APROBADO, ALERTA, RECHAZADO |
| scorePromedio | Decimal | Puntaje promedio (0-100) |
| nivelRiesgo | String | BAJO, MEDIO, ALTO, CRITICO |
| alertaFraude | Boolean | Indica si se detectó alerta de fraude |
| requiereRevisionManual | Boolean | Indica si requiere revisión manual |
| observacionesGenerales | String | Observaciones generales |

**Estructura de `documentosEvaluados[]`**:

| Campo | Tipo | Descripción |
|-------|------|-------------|
| documentoId | String (UUID) | ID del documento evaluado |
| tipoDocumental | String | Tipo documental |
| nombreArchivo | String | Nombre del archivo |
| estadoEvaluacion | String | Estado de la evaluación |
| scoreConfiabilidad | Decimal | Puntaje de confiabilidad (0-100) |
| nivelRiesgo | String | Nivel de riesgo |
| alertaFraude | Boolean | Indica alerta de fraude |
| observaciones | Array | Lista de observaciones detectadas |
| metricas | Object | Métricas técnicas (calidadImagen, legibilidadTexto, etc.) |
| tiempoProcesamientoMs | Integer | Tiempo de procesamiento |

#### Códigos de Status HTTP

| Código | Respuesta | Descripción |
|--------|-----------|-------------|
| 200 | OK | Evaluación realizada exitosamente |
| 400 | Bad Request | Parámetros inválidos o documentos no encontrados |
| 401 | Unauthorized | Token JWT inválido o expirado |
| 403 | Forbidden | Sin permisos para solicitar validación |
| 404 | Not Found | Solicitud o documentos no localizados |
| 408 | Request Timeout | Timeout al obtener documentos |
| 422 | Unprocessable Entity | Documentos en formato no soportado o trámite en estado no válido |
| 429 | Too Many Requests | Límite de rate limit excedido |
| 500 | Internal Server Error | Error interno del servicio |
| 502 | Bad Gateway | Error al comunicarse con gestor documental o servicio de IA |
| 503 | Service Unavailable | Servicio de IA temporalmente no disponible - Circuit Breaker activado |
| 504 | Gateway Timeout | Timeout en servicio de IA |

---

### ENDPOINT 2: Verificar Firma del Registrador

**Método HTTP**: POST  
**Path Completo**: `/api/v1/documentos/MsCoreogValidadorDocumentos/verificarFirmaRegistrador`  
**API Gateway**: Interno  
**Protocolo**: REST/HTTP

#### Headers Requeridos
- `Authorization: Bearer {JWT_TOKEN}` (Requerido)
- `Content-Type: application/json` (Requerido)
- `X-Correlation-Id: {UUID}` (Opcional, para trazabilidad)
- `X-Usuario-Id: {ID_USUARIO}` (Requerido)
- `X-Oficina-Id: {ID_OFICINA}` (Requerido)

#### Parámetros de Entrada (Request Body)

**Estructura JSON del Request**:
```json
{
  "solicitudId": "string (UUID)",
  "tramiteId": "string",
  "documentoId": "string (UUID)",
  "tipoActa": "string",
  "rutaGestorDocumental": "string (URI)",
  "hashSHA256": "string",
  "datosRegistrador": {object},
  "datosActa": {object},
  "parametrosVerificacion": {object},
  "usuarioSolicita": "string",
  "oficinaOrigen": "string",
  "fechaSolicitud": "YYYY-MM-DDThh:mm:ssZ",
  "observaciones": "string"
}
```

**Detalle de Campos Principales**:

| Campo | Tipo | Obligatorio | Long. Min | Long. Max | Descripción |
|-------|------|-------------|-----------|-----------|-------------|
| solicitudId | String (UUID) | Sí | 36 | 36 | ID de la solicitud |
| tramiteId | String | Sí | 3 | 50 | ID del trámite |
| documentoId | String (UUID) | Sí | 36 | 36 | ID del documento |
| tipoActa | String | Sí | 3 | 20 | Tipo de acta (nacimiento, matrimonio, defunción) |
| rutaGestorDocumental | String (URI) | Sí | 10 | 500 | Ruta del documento |
| hashSHA256 | String | Sí | 64 | 64 | Hash SHA-256 |

**Estructura de `datosRegistrador`**:

| Campo | Tipo | Obligatorio | Long. Min | Long. Max | Descripción |
|-------|------|-------------|-----------|-----------|-------------|
| numeroDniRegistrador | String | Sí | 8 | 8 | DNI del registrador |
| idUsuario | String | No | 1 | 8 | ID de usuario |
| primerApellido | String | Sí | 2 | 128 | Primer apellido |
| segundoApellido | String | No | 2 | 128 | Segundo apellido |
| prenombres | String | Sí | 2 | 160 | Prenombres |
| codigoLocal | String | Sí | 6 | 6 | Código del local |

**Estructura de `datosActa`**:

| Campo | Tipo | Obligatorio | Descripción |
|-------|------|-------------|-------------|
| numeroActa | String | Sí | Número de acta |
| anioActa | Integer | Sí | Año del acta |
| fechaInscripcion | String (ISO 8601) | Sí | Fecha de inscripción |
| oficinaRegistroCivil | String | Sí | Oficina de registro civil |

**Estructura de `parametrosVerificacion`** (Opcional):

| Campo | Tipo | Obligatorio | Descripción |
|-------|------|-------------|-------------|
| umbralSimilitudFirma | Decimal | No | Umbral mínimo de similitud para firma |
| umbralSimilitudSello | Decimal | No | Umbral mínimo de similitud para sello |
| modeloIA | String | No | Modelo de IA a utilizar |
| incluirImagenesReferencia | Boolean | No | Si incluir imágenes de referencia |

#### Parámetros de Salida (Response Body)

**Estructura JSON del Response**:
```json
{
  "success": boolean,
  "data": {
    "verificacionId": "string (UUID)",
    "solicitudId": "string (UUID)",
    "tramiteId": "string",
    "documentoId": "string (UUID)",
    "fechaVerificacion": "YYYY-MM-DDThh:mm:ssZ",
    "modeloIAUtilizado": "string",
    "tiempoProcesamientoMs": integer,
    "resultadoGeneral": {object},
    "verificacionFirma": {object},
    "verificacionSello": {object},
    "verificacionPeriodo": {object},
    "datosRegistradorVerificado": {object},
    "alertas": [array],
    "accionesRecomendadas": [array]
  },
  "metadata": {object},
  "error": {object}
}
```

**Estructura de `resultadoGeneral`**:

| Campo | Tipo | Descripción |
|-------|------|-------------|
| estadoVerificacion | String | VALIDO, INVALIDO, PARCIAL, INDETERMINADO |
| firmaValida | Boolean | Indica si la firma pasó la verificación |
| selloValido | Boolean | Indica si el sello pasó la verificación |
| periodoValido | Boolean | Indica si el período del registrador es válido |
| requiereRevisionManual | Boolean | Indica si requiere revisión manual |
| observacionesGenerales | String | Observaciones generales |

**Estructura de `verificacionFirma`**:

| Campo | Tipo | Descripción |
|-------|------|-------------|
| estadoFirma | String | VALIDA, INVALIDA, NO_ENCONTRADA, INDETERMINADA |
| scoreSimilitud | Decimal | Porcentaje de similitud (0-100) |
| nivelConfianza | String | ALTO, MEDIO, BAJO |
| firmaEncontradaEnBD | Boolean | Si se encontró firma de referencia |
| imagenFirmaDocumento | String (Base64) | Imagen de firma extraída |
| imagenFirmaReferencia | String (Base64) | Imagen de firma de referencia |
| observaciones | String | Observaciones específicas |
| metricas | Object | Métricas (similitudEstructural, similitudTrazos, calidadImagenExtraida) |

**Estructura de `verificacionSello`**:

| Campo | Tipo | Descripción |
|-------|------|-------------|
| estadoSello | String | VALIDO, INVALIDO, NO_ENCONTRADO, INDETERMINADO |
| scoreSimilitud | Decimal | Porcentaje de similitud (0-100) |
| nivelConfianza | String | ALTO, MEDIO, BAJO |
| selloEncontradoEnBD | Boolean | Si se encontró sello de referencia |
| imagenSelloDocumento | String (Base64) | Imagen de sello extraído |
| imagenSelloReferencia | String (Base64) | Imagen de sello de referencia |
| observaciones | String | Observaciones específicas |
| metricas | Object | Métricas (similitudForma, legibilidadTexto, calidadImagenExtraida) |

**Estructura de `verificacionPeriodo`**:

| Campo | Tipo | Descripción |
|-------|------|-------------|
| estadoPeriodo | String | VALIDO, INVALIDO, NO_VERIFICABLE |
| registradorEncontrado | Boolean | Si se encontró el registrador en BD |
| registradorHabilitado | Boolean | Si estaba habilitado en la fecha |
| fechaInscripcionActa | String (ISO 8601) | Fecha de inscripción del acta |
| periodoHabilitacion | Object | Período de habilitación (fechaInicio, fechaFin, codigoLocal, nombreOficina) |
| estadoRegistrador | String | ACTIVO, BAJA, SUSPENDIDO |
| observaciones | String | Observaciones |

#### Códigos de Status HTTP

| Código | Respuesta | Descripción |
|--------|-----------|-------------|
| 200 | OK | Verificación realizada exitosamente |
| 400 | Bad Request | Parámetros inválidos o documento no encontrado |
| 401 | Unauthorized | Token JWT inválido o expirado |
| 403 | Forbidden | Sin permisos para solicitar verificación |
| 404 | Not Found | Documento no localizado o registrador no encontrado |
| 408 | Request Timeout | Timeout al obtener documento |
| 422 | Unprocessable Entity | Documento no contiene firma/sello extraíble |
| 429 | Too Many Requests | Límite de rate limit excedido |
| 500 | Internal Server Error | Error interno del servicio |
| 502 | Bad Gateway | Error al comunicarse con BD de Registradores o servicio de IA |
| 503 | Service Unavailable | Servicio de IA temporalmente no disponible - Circuit Breaker activado |
| 504 | Gateway Timeout | Timeout en servicio de IA |

---

## Entidades del Dominio Identificadas

### 1. Documento
**Tipo**: Entidad  
**Descripción**: Representa un documento digital a ser validado

**Atributos**:
- documentoId: String (UUID)
- tipoDocumental: String
- nombreArchivo: String
- rutaGestorDocumental: String (URI)
- hashSHA256: String (64 chars)
- formatoDocumento: String
- tamanioBytes: Integer
- requiereValidacionIA: Boolean

### 2. Evaluacion
**Tipo**: Aggregate Root  
**Descripción**: Resultado de la evaluación de documentos con IA

**Atributos principales**:
- evaluacionId: String (UUID)
- solicitudId: String (UUID)
- tramiteId: String
- fechaEvaluacion: DateTime (ISO 8601)
- modeloIAUtilizado: String
- tiempoProcesamientoMs: Integer
- resultadoGeneral: Object
- documentosEvaluados: Array
- accionesRecomendadas: Array

### 3. Verificacion
**Tipo**: Aggregate Root  
**Descripción**: Resultado de la verificación de firma y sello del registrador

**Atributos principales**:
- verificacionId: String (UUID)
- solicitudId: String (UUID)
- tramiteId: String
- documentoId: String (UUID)
- fechaVerificacion: DateTime (ISO 8601)
- modeloIAUtilizado: String
- tiempoProcesamientoMs: Integer
- resultadoGeneral: Object
- verificacionFirma: Object
- verificacionSello: Object
- verificacionPeriodo: Object
- datosRegistradorVerificado: Object
- alertas: Array
- accionesRecomendadas: Array

### 4. Registrador
**Tipo**: Entidad  
**Descripción**: Datos de un registrador civil

**Atributos**:
- numeroDniRegistrador: String (8 chars)
- idUsuario: String
- primerApellido: String
- segundoApellido: String
- prenombres: String
- codigoLocal: String (6 chars)

---

## Reglas de Negocio Identificadas

### Validación de Documentos
1. Los documentos deben existir en el gestor documental antes de ser evaluados
2. La integridad de los documentos debe verificarse mediante hash SHA-256
3. Solo documentos en formatos soportados pueden ser evaluados
4. El trámite debe estar en estado válido para evaluación
5. Máximo 20 documentos por solicitud de evaluación

### Verificación de Firma y Sello
1. La firma y sello deben extraerse del documento usando modelos de IA
2. La similitud debe calcularse comparando con la firma/sello de referencia almacenado en BD
3. El registrador debe existir en la Base de Datos de Registradores
4. El registrador debe haber estado habilitado en la fecha de inscripción del acta
5. El registrador debe haber estado asignado al local correcto en la fecha de inscripción
6. Se aplican umbrales de similitud configurables para determinar validez

### Niveles de Riesgo
- **BAJO**: Score > 80, sin alertas de fraude
- **MEDIO**: Score entre 50-80, alertas menores
- **ALTO**: Score entre 30-50, alertas significativas
- **CRITICO**: Score < 30 o detección de fraude confirmada

### Estados de Evaluación
- **APROBADO**: Documentos pasan todas las validaciones
- **ALERTA**: Documentos tienen observaciones pero pueden procesarse
- **RECHAZADO**: Documentos no pasan validaciones críticas

### Estados de Verificación
- **VALIDO**: Firma y sello coinciden, período válido
- **INVALIDO**: Firma o sello no coinciden, o período inválido
- **PARCIAL**: Algunos componentes válidos, otros no
- **INDETERMINADO**: No se puede determinar con certeza

---

## Integraciones con Componentes Externos

### 1. MsDataValidadorDocumentos
**Tipo**: MsData (Microservicio de Datos)  
**Propósito**: Persistencia de evaluaciones y verificaciones

**Operaciones requeridas**:
- Guardar evaluación
- Consultar evaluación por ID
- Consultar evaluaciones por solicitud
- Guardar verificación
- Consultar verificación por ID
- Consultar verificaciones por solicitud

### 2. MsDataRegistradores
**Tipo**: MsData (Microservicio de Datos)  
**Propósito**: Consulta de información de registradores civiles

**Operaciones requeridas**:
- Consultar registrador por DNI
- Obtener firma de referencia
- Obtener sello de referencia
- Verificar habilitación en fecha específica
- Consultar período de habilitación

### 3. Gestor Documental
**Tipo**: Servicio Externo  
**Propósito**: Almacenamiento y recuperación de documentos

**Operaciones requeridas**:
- Obtener documento por ruta
- Verificar integridad (hash SHA-256)
- Verificar existencia de documento

### 4. Servicio de Inteligencia Artificial
**Tipo**: Servicio Externo  
**Propósito**: Evaluación y comparación de documentos con modelos de IA

**Operaciones requeridas**:
- Evaluar documentos (calidad, legibilidad, integridad)
- Extraer firma de documento
- Extraer sello de documento
- Comparar firma con referencia
- Comparar sello con referencia
- Calcular métricas de similitud

---

## Mapeo de Tipos de Datos (PDF → Java)

| Tipo en PDF | Tipo Java | Justificación |
|-------------|-----------|---------------|
| string | String | Cadenas de texto |
| integer | Long | Números enteros (preferencia por Long para seguridad) |
| number / decimal | Double | Números con decimales |
| boolean | Boolean | Valores verdadero/falso |
| date | LocalDate | Fechas sin componente de hora |
| datetime / timestamp / ISO 8601 | LocalDateTime | Fechas con hora completa |
| UUID | String | Identificadores únicos (representación String) |
| Base64 | String | Imágenes codificadas |
| URI | String | Rutas y URLs |
| array / list | List<T> | Colecciones de elementos |

---

## Códigos HTTP Estándar del Sistema

| Código | Categoría | Descripción |
|--------|-----------|-------------|
| 200 | Success | Operación completada exitosamente |
| 201 | Success | Recurso creado exitosamente |
| 400 | Client Error | Parámetros inválidos o datos incompletos |
| 401 | Client Error | Token JWT inválido, expirado o ausente |
| 403 | Client Error | Sin permisos suficientes |
| 404 | Client Error | Recurso no encontrado |
| 408 | Client Error | Timeout de la petición |
| 409 | Client Error | Conflicto con estado actual del recurso |
| 422 | Client Error | Datos válidos pero no procesables por reglas de negocio |
| 429 | Client Error | Límite de rate limit excedido |
| 500 | Server Error | Error interno del servicio |
| 502 | Server Error | Servicio externo no disponible o respuesta inválida |
| 503 | Server Error | Servicio temporalmente no disponible o Circuit Breaker abierto |
| 504 | Server Error | Servicio externo no respondió en tiempo esperado |

---

## Patrones de Arquitectura Mencionados

### Resiliencia y Tolerancia a Fallos
- **Circuit Breaker**: Implementado cuando el servicio de IA no está disponible (status 503)
- **Retry**: Para reintentos ante fallos temporales
- **Timeout**: Gestión de tiempos máximos de espera (408, 504)

### Seguridad
- **JWT Authentication**: Tokens Bearer para autenticación
- **Authorization**: Control de permisos por roles (403 Forbidden)
- **Rate Limiting**: Control de límites de peticiones (429)

### Observabilidad
- **Distributed Tracing**: Header X-Correlation-Id para trazabilidad
- **Logging Centralizado**: Registro de eventos del sistema
- **Métricas Granulares**: Tiempos de procesamiento, scores, etc.

### Arquitectura
- **API Management**: Punto único de entrada (API Gateway)
- **Microservices**: Servicios con responsabilidad única
- **Event Streaming**: Comunicación asíncrona (mencionado en arquitectura)

---

## Limitaciones Identificadas

### Límites Operativos
- Máximo 20 documentos por solicitud de calificación
- Tamaño máximo de documento: según configuración del gestor documental
- Formatos soportados: Solo los definidos en `formatoDocumento`
- Rate Limit: Límite de peticiones por unidad de tiempo (no especificado en PDF)

### Dependencias Críticas
- Disponibilidad del Gestor Documental
- Disponibilidad del Servicio de IA
- Disponibilidad de MsData (para persistencia)
- Disponibilidad de MsDataRegistradores (para verificación de firmas)

### Restricciones de Seguridad
- Token JWT requerido en todos los endpoints
- Validación de permisos por usuario y oficina
- Verificación de integridad mediante hash SHA-256

---

## Información No Encontrada en el PDF

Los siguientes aspectos NO están especificados en el PDF:

1. **Protocolos de Comunicación**: No se especifica si las integraciones son HTTP, SOAP, colas, gRPC, etc.
2. **Configuración de Base de Datos**: No se define el esquema de persistencia
3. **Modelos de IA Específicos**: No se especifican versiones o configuraciones de modelos
4. **Valores de Umbrales**: No se definen valores por defecto para umbrales de similitud
5. **Configuración de Rate Limit**: No se especifican límites concretos
6. **Timeouts Específicos**: No se definen tiempos máximos de espera
7. **Formato de Logs**: No se especifica estructura de logs centralizados
8. **Métricas de Performance**: No se definen SLAs o SLOs

---

## Resumen de la Extracción

✅ **Nombre del Microservicio**: MsCoreogValidadorDocumentos  
✅ **Tipo**: MsDominio  
✅ **Versión API**: v1  
✅ **Endpoints**: 2 (Calificar Documento, Verificar Firma del Registrador)  
✅ **Entidades**: 4 (Documento, Evaluacion, Verificacion, Registrador)  
✅ **Integraciones**: 4 (MsDataValidadorDocumentos, MsDataRegistradores, Gestor Documental, Servicio IA)  
✅ **Status Codes**: 14 códigos HTTP diferentes  
✅ **Headers**: 5 headers (Authorization, Content-Type, X-Correlation-Id, X-Usuario-Id, X-Oficina-Id)

---

## Fecha de Extracción
**Fecha**: 03/12/2025  
**Herramienta**: Python PyPDF2  
**Archivo Fuente**: Microservicio MsCoreogValidadorDocumentos v1.0.pdf (675,499 bytes)
