# Modelo de Dominio Refactorizado - MsDominioProteccionDocumentos

## Cambios Realizados

### ✅ Modelo de Dominio REAL (No copia de DTOs)

#### Eliminadas (No son del dominio):
- ❌ `RespuestaProteccion` → Era un wrapper de API REST con `success`, `timestamp`, `links`, `metadata`
- ❌ `LinksHATEOAS` → Concepto de REST/HTTP, no de dominio
- ❌ `MetadataRespuesta` → Metadatos de API REST (requestId, correlationId, version)
- ❌ `ErrorResponse`, `ErrorDetalle`, `ErrorItem` → Estructuras de manejo de errores HTTP
- ❌ `DataProteccion` → Wrapper innecesario
- ❌ `ArchivoProtegido` → Renombrado a `DocumentoProtegido`
- ❌ `MetadatosDocumento` → Renombrado a `Documento`
- ❌ `DatosMetadatos` → Renombrado a `Metadatos`
- ❌ `FuenteDocumento` → Renombrado a `Fuente`
- ❌ `ReferenciaRepositorio` → Renombrado a `Referencia`
- ❌ `InformacionSeguridad` → Renombrado a `ResultadoSeguridad` y simplificado
- ❌ `EstadisticasCompresion` → Renombrado a `Estadisticas` y simplificado

---

## Modelo de Dominio Actualizado

### 🟢 Aggregate Roots

#### 1. **SolicitudProteccion**
- `solicitudId`: String
- `tipoOperacion`: TipoOperacion (enum)
- `fechaSolicitud`: LocalDateTime
- `fuente`: Fuente
- `documentos`: List<Documento>
- `configuracion`: ConfiguracionProteccion
- `destinatarios`: List<Destinatario>

#### 2. **ProcesoProteccion** (antes RespuestaProteccion)
- `procesoId`: String
- `solicitudId`: String
- `estado`: EstadoProceso (enum)
- `fechaProcesamiento`: LocalDateTime
- `documentosProtegidos`: List<DocumentoProtegido>
- `resultadoSeguridad`: ResultadoSeguridad
- `estadisticas`: Estadisticas

---

### 🔵 Value Objects

#### **Fuente** (antes FuenteDocumento)
- `tipo`: String
- `origen`: String
- `referencia`: Referencia

#### **Referencia** (antes ReferenciaRepositorio)
- `sistema`: String
- `transaccionId`: String
- `codigoSeguimiento`: String

#### **Documento** (antes MetadatosDocumento)
- `documentoId`: String
- `nombre`: String
- `tipo`: TipoDocumento (enum)
- `tamanioBytes`: Long
- `formato`: String
- `metadatos`: Metadatos

#### **Metadatos** (antes DatosMetadatos)
- `titulo`: String
- `descripcion`: String
- `autor`: String
- `fechaCreacion`: LocalDateTime
- `clasificacion`: ClasificacionDocumento (enum)
- `palabrasClave`: List<String>

#### **ConfiguracionProteccion**
- `nivelCompresion`: NivelCompresion (enum)
- `algoritmoCifrado`: AlgoritmoCifrado (enum)
- `clavePublica`: String
- `incluirMetadatos`: Boolean
- `proteccionPassword`: ProteccionPassword

#### **ProteccionPassword** (nuevo)
- `protegido`: Boolean
- `passwordHash`: String

#### **Destinatario**
- `destinatarioId`: String
- `tipo`: String
- `nivelAcceso`: String
- `permisos`: List<String>

#### **DocumentoProtegido** (antes ArchivoProtegido)
- `documentoId`: String
- `documentoOriginalId`: String
- `nombre`: String
- `compresion`: Compresion
- `cifrado`: Cifrado
- `ubicacionAlmacenamiento`: String

#### **Compresion** (nuevo - encapsula lógica de compresión)
- `nivel`: NivelCompresion (enum)
- `formato`: String
- `tamanioOriginalBytes`: Long
- `tamanioComprimidoBytes`: Long
- `ratioCompresion`: Double

#### **Cifrado** (nuevo - encapsula lógica de cifrado)
- `algoritmo`: AlgoritmoCifrado (enum)
- `hash`: String
- `algoritmoHash`: String
- `fechaCifrado`: LocalDateTime
- `huellaCifrado`: String

#### **ResultadoSeguridad** (antes InformacionSeguridad - simplificado)
- `algoritmoCifrado`: AlgoritmoCifrado (enum)
- `nivelSeguridad`: NivelSeguridad (enum)

#### **Estadisticas** (antes EstadisticasCompresion - sin porcentajeReduccion calculado)
- `totalDocumentos`: Long
- `documentosProcesados`: Long
- `documentosFallidos`: Long
- `tiempoProcesamientoMs`: Long
- `ahorroEspacioBytes`: Long

---

### 🟡 Enumeraciones (Domain-Driven)

#### **EstadoProceso**
```java
PENDIENTE, EN_PROCESO, COMPLETADO, COMPLETADO_CON_ERRORES, FALLIDO
```

#### **NivelCompresion**
```java
NINGUNO, BAJO, MEDIO, ALTO, MAXIMO
```

#### **AlgoritmoCifrado**
```java
AES256, RSA2048, RSA4096
```

#### **NivelSeguridad**
```java
BASICO, MEDIO, ALTO, CRITICO
```

#### **TipoDocumento**
```java
DNI, ACTA_NACIMIENTO, ACTA_MATRIMONIO, ACTA_DEFUNCION, CERTIFICADO, OTRO
```

#### **ClasificacionDocumento**
```java
PUBLICO, INTERNO, CONFIDENCIAL, SECRETO
```

#### **TipoOperacion**
```java
COMPRIMIR_Y_PROTEGER, SOLO_COMPRIMIR, SOLO_PROTEGER
```

---

## Puertos Refactorizados

### ✅ Puerto de Entrada

#### **ComprimirYProtegerDocumentosUseCase**
```java
ProcesoProteccion ejecutar(SolicitudProteccion solicitud);
```

### ✅ Puertos de Salida (Específicos para la operación)

#### **ConfiguracionPort** (antes ConfiguracionDataPort - simplificado)
```java
ConfiguracionProteccion obtenerConfiguracion(TipoOperacion tipoOperacion);
```
- ❌ Eliminado: `obtenerConfiguracionPorDefecto()` - redundante
- ✅ Simplificado a una sola operación centrada en el negocio

#### **AlmacenamientoPort** (antes DocumentoDataPort - enfocado)
```java
Documento obtenerDocumento(String documentoId);
String almacenarDocumentoProtegido(DocumentoProtegido documentoProtegido);
```
- ❌ Eliminado: `actualizarMetadatos()` - No es parte de "Comprimir y Proteger"
- ✅ Solo operaciones necesarias para la operación principal

---

## Adaptadores Refactorizados

### **ConfiguracionAdapter** (antes ConfiguracionDataAdapter)
- Implementa `ConfiguracionPort`
- Integración con MsDatosConfiguracion

### **AlmacenamientoAdapter** (antes DocumentoDataAdapter)
- Implementa `AlmacenamientoPort`
- Integración con MsGestorDocumentos

---

## Resumen de Mejoras

### 🎯 Principios DDD Aplicados:

1. **Lenguaje Ubicuo**:
   - `Documento` (no MetadatosDocumento)
   - `Compresion` y `Cifrado` como conceptos explícitos
   - `ProcesoProteccion` (no RespuestaProteccion)

2. **Enriquecimiento del Modelo**:
   - Enums para valores acotados (tipo seguro)
   - Value Objects con comportamiento cohesivo
   - Separación clara entre dominio e infraestructura

3. **Eliminación de Contaminación**:
   - Sin conceptos HTTP/REST en el dominio
   - Sin estructuras de respuesta genéricas
   - Sin wrappers innecesarios

4. **Cohesión**:
   - `Compresion` encapsula todo lo relacionado a compresión
   - `Cifrado` encapsula todo lo relacionado a cifrado
   - Puertos enfocados únicamente en "Comprimir y Proteger"

---

## Conteo Final

### Modelo de Dominio:
- **2 Aggregate Roots**
- **10 Value Objects**
- **7 Enumeraciones**
- **Total: 19 clases de dominio**

### Puertos:
- **1 Puerto de Entrada**
- **2 Puertos de Salida** (simplificados y enfocados)

### Adaptadores:
- **2 Adaptadores** (renombrados y actualizados)
