# Extracción del PDF: Microservicio MsDatosSolicitudes V1.3


--- Página 1 ---
 
 
 
Microservicio MsDatosSolicitudes 
Documento Versión: 1.3 
Gestión de Seguridad Electrónica 
 
 
Fecha generación: 
01/12/2025 
 
 
  
 
 
 

--- Página 2 ---
 
Microservicio MsDatosSolicitudes 
2 
 
 
 
 
 
 
 
 
 
 
 
CONTROL DE VERSIÓN 
 
 
 
 
VERSIÓN 
FECHA DE ACTUALIZACIÓN 
CARGO 
DESCRIPCIÓN 
1.0 
03/11/2025 
Arquitecto de Software 
Versión inicial del documento 
1.1 
29/11/2025 
Control de Arquitectura 
Corrección del documento 
basado en observaciones 
1.2 
30/11/2025 
Control de Arquitectura 
Revisión estructura de 
objetos JSON 
1.3 
01/12/2025 
Documentador Técnico 
Se añaden los Endpoints 3.1.6
Crear Diligencia, 3.1.7 Verificar
Duplicados, 
3.1.8 
Ver
Trazabilidad 
 
 
 
 

--- Página 3 ---
 
Microservicio MsDatosSolicitudes 
3 
 
Tabla de contenido 
1 
CONTEXTO ............................................................................................................................................... 4 
2 
INTRODUCCIÓN ....................................................................................................................................... 4 
2.1 
Justificación de la Arquitectura de Microservicios ............................................................................. 4 
2.2 
Arquitectura de Referencia ................................................................................................................ 4 
2.3 
Códigos de Respuesta HTTP Estándar ............................................................................................. 4 
3 
CATÁLOGO DE MICROSERVICIOS ........................................................................................................ 5 
3.1 
Microservicio MsDatosSolicitudes ..................................................................................................... 5 
3.1.1 
Endpoint: Crear Nueva Solicitud ................................................................................................ 5 
3.1.2 
Endpoint: Listar Solicitudes ...................................................................................................... 10 
3.1.3 
Endpoint: Consultar Solicitud Específica ................................................................................. 13 
3.1.4 
Endpoint: Actualizar Solicitud Completa .................................................................................. 17 
3.1.5 
Endpoint: Consultar Solicitudes Pendientes Offline ................................................................ 21 
3.1.6 
Endpoint: Crear Diligencia ....................................................................................................... 24 
3.1.7 
Endpoint: Verificar Duplicados ................................................................................................. 28 
3.1.8 
Endpoint: Ver Trazabilidad ....................................................................................................... 32 
 
 
 
 
 
 

--- Página 4 ---
 
Microservicio MsDatosSolicitudes 
4 
1 CONTEXTO 
El Registro Nacional de Identificación y Estado Civil (RENIEC) es el organismo técnico autónomo encargado 
de la identificación de los peruanos, otorgar el Documento Nacional de Identidad (DNI) y registrar los hechos 
vitales. En el marco de la modernización y transformación digital del Estado peruano, RENIEC ha desarrollado 
el DNI Electrónico (DNIe), un documento de identidad que incorpora tecnología de chip y biometría, 
permitiendo la autenticación electrónica de ciudadanos y facilitando servicios digitales seguros. 
2 INTRODUCCIÓN 
Este documento describe el catálogo de microservicios identificados para la solución de Personalización 
del DNIe de RENIEC. El objetivo es establecer una arquitectura técnica moderna, escalable y mantenible que 
reemplace o complemente los sistemas monolíticos actuales mediante una transición ordenada hacia una 
arquitectura orientada a microservicios. 
2.1 Justificación de la Arquitectura de 
Microservicios 
La adopción de microservicios para esta solución responde a necesidades técnicas y operativas 
concretas: 
Escalabilidad Independiente: Componentes con cargas diferenciadas pueden escalar de forma 
independiente según demanda real, optimizando recursos de infraestructura. 
Resiliencia y Tolerancia a Fallos: El fallo de un microservicio no compromete servicios críticos. Los 
patrones Circuit Breaker y Retry garantizan continuidad operativa. 
Agilidad en el Desarrollo: Equipos autónomos pueden desarrollar, probar y desplegar servicios de 
manera independiente, reduciendo tiempos de entrega. 
Mantenibilidad y Evolución Tecnológica: Cada servicio puede evolucionar tecnológicamente sin 
afectar al ecosistema completo. 
Trazabilidad y Observabilidad: Arquitectura distribuida permite implementar logging centralizado, 
distributed tracing y métricas granulares. 
2.2 Arquitectura de Referencia 
La solución se estructura en tres capas principales: 
Capa de Exposición (API Management Layer): API Manager como punto único de entrada con 
gestión centralizada de seguridad, throttling y versionado. 
Capa de Representación (Microservices Layer): Microservicios de negocio con lógica específica 
de dominio y responsabilidad única. 
Capa de Integración (Integration Layer): Event Streaming para comunicación asíncrona y 
conectores a sistemas legados. 
2.3 Códigos de Respuesta HTTP Estándar 
Todos los microservicios implementan un conjunto estandarizado de códigos de respuesta HTTP 
para garantizar consistencia: 
Código 
Descripción 
200 
OK - Operación completada exitosamente 
201 
Created - Recurso creado exitosamente 
400 
Bad Request - Parámetros inválidos o datos incompletos 
401 
Unauthorized - Token JWT inválido, expirado o ausente 
403 
Forbidden - Sin permisos suficientes para ejecutar la operación 

--- Página 5 ---
 
Microservicio MsDatosSolicitudes 
5 
404 
Not Found - Recurso no encontrado en el sistema 
408 
Request Timeout - Tiempo de espera agotado al conectar 
409 
Conflict - Conflicto con el estado actual del recurso 
422 
Unprocessable Entity - Datos válidos pero no procesables por reglas de negocio 
429 
Too Many Requests - Límite de rate limit excedido 
500 
Internal Server Error - Error interno del servicio (información generalizada al exterior, 
detalle en logs) 
502 
Bad Gateway - Servicio externo no disponible o respuesta inválida 
503 
Service Unavailable - Servicio temporalmente no disponible o Circuit Breaker abierto 
504 
Gateway Timeout - Servicio externo no respondió en tiempo esperado 
 
3 CATÁLOGO DE MICROSERVICIOS 
3.1 Microservicio MsDatosSolicitudes 
El Microservicio de Solicitudes es responsable de la gestión de las solicitudes dentro de la plataforma 
SIIRC. Una solicitud representa un trámite iniciado por cualquiera de los grupos de interés 
(stakeholders), y este microservicio permite su creación, actualización y persistencia. 
3.1.1 Endpoint: Crear Nueva Solicitud 
Endpoint que permite la creación de una nueva solicitud en el sistema SIIRC 
Atributo 
Valor 
Path 
/api/v1/solicitudes/MsDatosSolicitudes 
API Gateway 
Interno 
Método HTTP 
POST 
Protocolo 
REST/HTTP 
Headers 
Authorization String (Bearer token JWT para autenticación del usuario) 
Content-Type String ("application/json") 
X-Correlation-ID UUID (Identificador único de correlación para trazabilidad end-to-
end) 
X-Office-Code String (Código de oficina o sede desde donde se realiza la operación) 
X-User-Role String (Rol del usuario que realiza la operación, por ejemplo: 
REGISTRADOR) 
X-Request-Source String (Origen de la solicitud: WEB, MOBILE, KIOSK, 
API_EXTERNA) 
X-Idempotency-Key String (Identificador 
único 
de 
operación 
para 
evitar 
duplicidades en solicitudes repetidas)X-Idempotency-Key UUID(Clave para evitar 
creaciones duplicadas) 
Entrada 
{ 
  "tipoTramite": "string", 
  "subTipoTramite": "string", 
  "solicitante": { 
    "dni": "string", 
    "nombres": "string", 
    "apellidoPaterno": "string", 
    "apellidoMaterno": "string", 
    "email": "string", 
    "telefono": "string", 
    "direccion": { 

--- Página 6 ---
 
Microservicio MsDatosSolicitudes 
6 
      "departamento": "string", 
      "provincia": "string", 
      "distrito": "string", 
      "direccionCompleta": "string" 
    } 
  }, 
  "tipoSolicitante": "string", 
  "prioridad": "string", 
  "requisitosCumplidos": [ 
    { 
      "requisitoId": "string", 
      "nombreRequisito": "string", 
      "cumple": "boolean", 
      "observacion": "string" 
    } 
  ], 
  "datosEspecificosTramite": { 
    "motivoRenovacion": "string", 
    "dniAnterior": "string", 
    "fechaVencimientoDniAnterior": "YYYY-MM-DDThh:mm:ssZ", 
    "requiereEntregaDomicilio": "boolean", 
    "oficinaEntregaPreferida": "string", 
    "documentosAdjuntos": [ 
      { 
        "tipo": "string", 
        "nombre": "string", 
        "tamanioBytes": "integer", 
        "mimeType": "string", 
        "checksum": "string" 
      } 
    ] 
  }, 
  "pago": { 
    "montoPagado": "number", 
    "metodoPago": "string", 
    "referenciaPago": "string", 
    "fechaPago": "YYYY-MM-DDThh:mm:ssZ" 
  }, 
  "observaciones": "string" 
} 
Respuesta 
{ 
  "success": "boolean", 
  "data": { 
    "solicitudId": "string", 
    "numeroSolicitud": "string", 
    "estado": "string", 
    "tipoTramite": "string", 
    "dniSolicitante": "string", 
    "nombresSolicitante": "string", 
    "fechaRegistro": "YYYY-MM-DDThh:mm:ssZ", 
    "usuarioRegistro": "string", 
    "oficinaRegistro": { 
      "codigo": "string", 
      "nombre": "string" 
    }, 
    "siguientesPasos": [ 
      { 
        "paso": "string" 
      } 
    ], 
    "tiempoEstimadoResolucion": "integer", 
    "fechaVencimiento": "YYYY-MM-DDThh:mm:ssZ", 
    "urlSeguimiento": "string", 

--- Página 7 ---
 
Microservicio MsDatosSolicitudes 
7 
    "codigoQR": "string", 
    "_links": { 
      "self": "string", 
      "actualizar": "string", 
      "cambiarEstado": "string", 
      "historial": "string" 
    } 
  }, 
  "metadata": { 
    "timestamp": "string", 
    "correlationId": "string", 
    "version": "string" 
  } 
} 
Error Response 
     "error": { 
      "tipo": "string", 
      "titulo": "string", 
      "estado": "integer", 
      "errores": [ 
        { 
         "detalleError": "string" 
      } 
    ] 
  } 
 
3.1.1.1 Parámetros de Entrada 
Dato 
Atributo 
Tipo 
Obligatorio 
Longitud 
mínima 
Longitud 
máxima 
Tipo de Trámite 
tipoTramite 
String 
Sí 
3 
50 
Subtipo de 
Trámite 
subTipoTramite 
String 
Sí 
3 
50 
Solicitante 
solicitante 
Object 
Sí 
NA 
NA 
DNI 
solicitante.dni 
String 
Sí 
8 
8 
Nombres 
solicitante.nombres 
String 
Sí 
1 
100 
Apellido 
Paterno 
solicitante.apellidoPaterno 
String 
Sí 
1 
60 
Apellido 
Materno 
solicitante.apellidoMaterno 
String 
Sí 
1 
60 
Email 
solicitante.email 
String 
No 
5 
254 
Teléfono 
solicitante.telefono 
String 
No 
7 
15 
Dirección 
solicitante.direccion 
Object 
No 
NA 
NA 
Departamento 
solicitante.direccion.departamento 
String 
No 
2 
50 
Provincia 
solicitante.direccion.provincia 
String 
No 
2 
50 
Distrito 
solicitante.direccion.distrito 
String 
No 
2 
50 
Dirección 
Completa 
solicitante.direccion.direccionCom
pleta 
String 
No 
5 
200 
Tipo de 
Solicitante 
tipoSolicitante 
String 
Sí 
3 
30 
Prioridad 
prioridad 
String 
Sí 
4 
20 
Requisitos 
Cumplidos 
requisitosCumplidos 
Array 
Sí 
1 
100 

--- Página 8 ---
 
Microservicio MsDatosSolicitudes 
8 
RequisitoId 
requisitosCumplidos[].requisitoId 
String 
Sí 
3 
50 
RequisitoNomb
re 
requisitosCumplidos[].nombreRequ
isito 
String 
Sí 
3 
120 
RequisitoCump
le 
requisitosCumplidos[].cumple 
Boole
an 
Sí 
NA 
NA 
RequisitoObser
vación 
requisitosCumplidos[].observacion 
String 
No 
0 
300 
Datos 
Específicos 
datosEspecificosTramite 
Object 
Sí 
NA 
NA 
Motivo 
Renovación 
datosEspecificosTramite.motivoRe
novacion 
String 
Sí 
3 
30 
DNI Anterior 
datosEspecificosTramite.dniAnteri
or 
String 
Sí 
8 
8 
Fecha 
Vencimiento 
DNI Anterior 
datosEspecificosTramite.fechaVen
cimientoDniAnterior 
String 
(Date 
ISO 
8601) 
Sí 
NA 
NA 
Entrega a 
Domicilio 
datosEspecificosTramite.requiereE
ntregaDomicilio 
Boole
an 
Sí 
NA 
NA 
Oficina Entrega 
Preferida 
datosEspecificosTramite.oficinaEnt
regaPreferida 
String 
No 
5 
40 
Documentos 
Adjuntos 
documentosAdjuntos 
Array 
No 
0 
20 
Doc.Tipo 
documentosAdjuntos[].tipo 
String 
Sí 
3 
40 
Doc.Nombre 
documentosAdjuntos[].nombre 
String 
Sí 
3 
200 
Doc.Tamaño 
(bytes) 
documentosAdjuntos[].tamanioByt
es 
Intege
r 
Sí 
NA 
NA 
Doc.MimeType 
documentosAdjuntos[].mimeType 
String 
Sí 
3 
100 
Doc.Checksum 
documentosAdjuntos[].checksum 
String 
No 
10 
200 
Pago 
pago 
Object 
Sí 
NA 
NA 
Monto Pagado 
pago.montoPagado 
Decim
al 
Sí 
NA 
NA 
Método de 
Pago 
pago.metodoPago 
String 
Sí 
2 
20 
Referencia de 
Pago 
pago.referenciaPago 
String 
Sí 
3 
60 
Fecha de Pago 
pago.fechaPago 
String 
(Date 
ISO 
8601) 
Sí 
NA 
NA 
Observaciones 
observaciones 
String 
No 
0 
500 
 
3.1.1.2 Parámetros de Respuesta 
Nombre 
Tipo 
Obligatorio 
Descripción 
success 
Boolean 
Sí 
Indica si la operación fue exitosa. 
data 
Object 
Sí 
Cuerpo principal de la respuesta. 
data.solicitudId 
String 
Sí 
UUID de la solicitud creada. 
data.numeroSolicitud 
String 
Sí 
Número legible de solicitud. 
data.estado 
String 
Sí 
Estado actual de la solicitud. 

--- Página 9 ---
 
Microservicio MsDatosSolicitudes 
9 
data.tipoTramite 
String 
Sí 
Tipo de trámite. 
data.dniSolicitante 
String 
Sí 
DNI del solicitante. 
data.nombresSolicitante 
String 
Sí 
Nombres y apellidos concatenados. 
data.fechaRegistro 
String 
(Date ISO 
8601) 
Sí 
Fecha/hora de registro ISO 8601. 
data.usuarioRegistro 
String 
Sí 
Usuario que registra. 
data.oficinaRegistro 
Object 
Sí 
Oficina de registro. 
data.oficinaRegistro.codigo 
String 
Sí 
Código de oficina . 
data.oficinaRegistro.nombre 
String 
Sí 
Nombre de la oficina. 
data.siguientesPasos[] 
Array 
No 
Próximas acciones sugeridas. 
data.siguientesPasos[].paso 
String 
No 
Siguiente paso en la solicitud 
data.tiempoEstimadoResolucion 
Integer 
No 
Días estimados de resolución. 
data.fechaVencimiento 
String 
(Date ISO 
8601) 
No 
Fecha límite/compromiso. 
data.urlSeguimiento 
String 
(URI) 
No 
URL para seguimiento. 
data.codigoQR 
String 
No 
PNG en Base64 del QR. 
data._links 
Object 
Sí 
Hipervínculos de navegación. 
data._links.self 
String 
Sí 
Recurso actual. 
data._links.actualizar 
String 
Sí 
URL para actualizar. 
data._links.cambiarEstado 
String 
Sí 
URL para cambio de estado. 
data._links.historial 
String 
Sí 
URL para historial. 
metadata 
Object 
Sí 
Metadatos de la operación. 
metadata.timestamp 
String 
(Date ISO 
8601) 
Sí 
Marca de tiempo del procesamiento. 
metadata.correlationId 
String 
Sí 
Identificador de correlación para 
trazabilidad. 
metadata.version 
String 
Sí 
Versión del servicio. 
error 
Object 
No 
Objeto qué especifica algún error 
existente en la operación. 
error.tipo 
String 
No 
Tipo de error 
error.titulo 
String 
No 
Título del error 
error.status 
integer 
No 
Número del estado de error 
error.errores 
Array 
No 
Listado de errores 
error.errores[].detalleError 
String 
No 
Detalle del error generado 
 
3.1.1.3 Valores para el atributo de statusCode 
Código 
Respuesta 
Descripción 
201 
Created 
Solicitud creada exitosamente 
400 
Bad Request 
Datos inválidos o requisitos incompletos 
401 
Unauthorized 
Token JWT inválido o expirado 
403 
Forbidden 
Usuario sin permisos para crear solicitudes en esta oficina 
409 
Conflict 
Ya existe una solicitud activa para este ciudadano y trámite 
422 
Unprocessable Entity 
Datos válidos pero lógica de negocio no permite procesarlos 
429 
Too Many Requests 
Límite de rate limit excedido 
500 
Internal Server Error 
Error interno del servidor 

--- Página 10 ---
 
Microservicio MsDatosSolicitudes 
10 
503 
Service Unavailable 
Servicio temporalmente no disponible 
 
3.1.2 Endpoint: Listar Solicitudes 
Endpoint que permite listar solicitudes con parámetros de filtrado 
Atributo 
Valor 
Path 
/api/v1/solicitudes/MsDatosSolicitudes 
API Gateway 
Interno 
Método HTTP 
GET 
Protocolo 
REST/HTTP 
Headers 
Authorization String (Bearer token JWT para autenticación del usuario) 
X-Correlation-ID UUID (ID de correlación para trazabilidad end-to-end) 
X-Office-Code String (Código de oficina del usuario o punto de atención) 
X-User-Role String (Rol del usuario en el sistema, por ejemplo: 
CALIFICADOR) 
Parámetros  
• 
estado (string): Indica el estado para aplicar filtro. 
• 
tipoTramite (string): Define el tipo de trámite a consultar. 
• 
codigoOficina (string): Identifica la oficina correspondiente. 
• 
dniSolicitante (string): Permite filtrar por documento del solicitante. 
• 
usuarioAsignado (string): Usuario asociado al trámite. 
• 
fechaDesde (string): Fecha inicial del rango a consultar en formato de 
timestamp. 
• 
fechaHasta (string): Fecha final del rango a consultar en formato de 
timestamp. 
• 
prioridad (string): Nivel de prioridad para el filtro. 
• 
soloVencidas (boolean): Indica si se deben incluir únicamente las 
solicitudes vencidas. 
• 
page (integer): Número de página para la paginación. 
• 
size (integer): Cantidad de registros por página. 
• 
sort (string): Campo utilizado para ordenar los resultados. 
• 
direction (string): Dirección del ordenamiento. 
Respuesta 
{ 
  "success": "boolean", 
  "data": [ 
    { 
      "solicitudId": "string", 
      "numeroSolicitud": "string", 
      "estado": "string", 
      "tipoTramite": "string", 
      "dniSolicitante": "string", 
      "nombresSolicitante": "string", 
      "fechaRegistro": "YYYY-MM-DDThh:mm:ssZ", 
      "fechaVencimiento": "YYYY-MM-DDThh:mm:ssZ", 
      "prioridad": "string", 
      "usuarioAsignado": "string", 
      "oficinaRegistro": "string", 
      "diasTranscurridos": "integer", 
      "diasRestantes": "integer" 
    } 
  ], 
  "pagination": { 
    "page": "integer", 
    "size": "integer", 
    "totalElements": "integer", 
    "totalPages": "integer", 

--- Página 11 ---
 
Microservicio MsDatosSolicitudes 
11 
    "first": "boolean", 
    "last": "boolean" 
  } 
} 
Error Response 
     "error": { 
      "tipo": "string", 
      "titulo": "string", 
      "estado": "integer", 
      "errores": [ 
        { 
         "detalleError": "string" 
      } 
    ] 
  } 
 
3.1.2.1 Parámetros de Entrada 
Dato 
Atributo 
Tipo 
Obligatorio 
Longitud 
mínima 
Longitud 
máxima 
Estado 
estado 
String 
No 
1 
20 
Tipo de Trámite 
tipoTramite 
String 
No 
3 
50 
Código de Oficina 
codigoOficina 
String 
No 
3 
10 
DNI del Solicitante 
dniSolicitante 
String 
No 
8 
8 
Usuario Asignado 
usuarioAsignado 
String 
No 
3 
50 
Fecha Desde 
fechaDesde 
String 
(Date ISO 
8601) 
No 
NA 
NA 
Fecha Hasta 
fechaHasta 
String 
(Date ISO 
8601) 
No 
NA 
NA 
Prioridad 
prioridad 
String 
No 
3 
20 
Solo Vencidas 
soloVencidas 
Boolean 
No 
NA 
NA 
Página 
page 
Integer 
No 
1 
NA 
Tamaño de Página 
size 
Integer 
No 
1 
NA 
Campo de 
Ordenamiento 
sort 
String 
No 
3 
50 
Dirección de 
Ordenamiento 
direction 
String 
No 
3 
10 
 
3.1.2.2 Parámetros de Respuesta 
Nombre 
Tipo 
Obligatorio 
Descripción 
success 
Boolean 
Sí 
Indica si la operación fue exitosa. 
data 
Array(Object) 
Sí 
Lista de solicitudes devueltas por la 
consulta. 
data.solicitudId 
String 
Sí 
Identificador único de la solicitud. 
data.numeroSolicitud 
String 
Sí 
Número visible de la solicitud. 
data.estado 
String 
Sí 
Estado actual del trámite. 
data.tipoTramite 
String 
Sí 
Tipo de trámite o proceso asociado. 
data.dniSolicitante 
String 
Sí 
DNI del solicitante del trámite. 

--- Página 12 ---
 
Microservicio MsDatosSolicitudes 
12 
data.nombresSolicitante 
String 
Sí 
Nombres y apellidos concatenados del 
solicitante. 
data.fechaRegistro 
String (Date 
ISO 8601) 
Sí 
Fecha y hora en que se registró la solicitud  
data.fechaVencimiento 
String (Date 
ISO 8601) 
No 
Fecha límite de atención o vencimiento del 
trámite. 
data.prioridad 
String 
No 
Nivel de prioridad asignado. 
data.usuarioAsignado 
String 
No 
Usuario o funcionario responsable del 
trámite. 
data.oficinaRegistro 
String 
Sí 
Nombre o código de la oficina donde se 
registró la solicitud. 
data.diasTranscurridos 
Integer 
No 
Número de días transcurridos desde el 
registro. 
data.diasRestantes 
Integer 
No 
Número de días restantes hasta el 
vencimiento. 
pagination 
Object 
Sí 
Información de paginación de los 
resultados. 
pagination.page 
Integer 
Sí 
Número de página actual 
pagination.size 
Integer 
Sí 
Tamaño máximo de elementos por página. 
pagination.totalElements 
Integer 
Sí 
Total de elementos disponibles. 
pagination.totalPages 
Integer 
Sí 
Total de páginas disponibles. 
pagination.first 
Boolean 
Sí 
Indica si es la primera página. 
pagination.last 
Boolean 
Sí 
Indica si es la última página. 
error 
Object 
No 
Objeto qué especifica algún error existente 
en la operación. 
error.tipo 
String 
No 
Tipo de error 
error.titulo 
String 
No 
Título del error 
error.status 
integer 
No 
Número del estado de error 
error.errores 
Array 
No 
Listado de errores 
error.errores[].detalleError
String 
No 
Detalle del error generado 
 
3.1.2.3 Valores para el atributo de statusCode 
Código 
Respuesta 
Descripción 
200 
OK 
Consulta realizada exitosamente 
400 
Bad Request 
Parámetros de búsqueda inválidos 
401 
Unauthorized 
Token JWT inválido o expirado 
403 
Forbidden 
Usuario sin permisos para consultar solicitudes en esta 
oficina 
422 
Unprocessable Entity 
Parámetros de búsqueda inválidos 
429 
Too Many Requests 
Límite de rate limit excedido 
500 
Internal Server Error 
Error interno del servidor 
503 
Service Unavailable 
Servicio temporalmente no disponible 
 

--- Página 13 ---
 
Microservicio MsDatosSolicitudes 
13 
3.1.3 Endpoint: Consultar Solicitud Específica 
Endpoint que permite consultar una solicitud especifica por el id de la solicitud 
Atributo 
Valor 
Path 
/api/v1/solicitudes/MsDatosSolicitudes 
API Gateway 
Interno 
Método HTTP 
GET 
Protocolo 
REST/HTTP 
Headers 
Authorization String (Bearer token JWT para autenticación del usuario) 
X-Correlation-ID UUID (Identificador único de correlación para trazabilidad end-
to-end) 
X-Office-Code String (Código de oficina o sede desde donde se realiza la 
operación) 
X-User-Role String (Rol del usuario que realiza la operación, por ejemplo: 
REGISTRADOR) 
Parámetros  
• 
id(string): Identificador de la solicitud utilizada para realizar el filtro 
correspondiente. 
Respuesta 
{ 
  "success": "boolean", 
  "data": { 
    "solicitudId": "string", 
    "numeroSolicitud": "string", 
    "tipoTramite": "string", 
    "subTipoTramite": "string", 
    "estado": "string", 
    "estadoAnterior": "string", 
    "fechaRegistro": "YYYY-MM-DDThh:mm:ssZ", 
    "fechaCambioEstado": "YYYY-MM-DDThh:mm:ssZ", 
    "fechaVencimiento": "YYYY-MM-DDThh:mm:ssZ", 
    "solicitante": { 
      "dni": "string", 
      "nombres": "string", 
      "apellidoPaterno": "string", 
      "apellidoMaterno": "string", 
      "email": "string", 
      "telefono": "string", 
      "direccion": { 
        "departamento": "string", 
        "provincia": "string", 
        "distrito": "string", 
        "direccionCompleta": "string" 
      } 
    }, 
    "tipoSolicitante": "string", 
    "prioridad": "string", 
    "oficinaRegistro": { 
      "codigo": "string", 
      "nombre": "string" 
    }, 
    "usuarioRegistro": "string", 
    "usuarioAsignado": "string", 
    "fechaAsignacion": "YYYY-MM-DDThh:mm:ssZ", 
    "pago": { 
      "montoTotal": "number", 
      "montoPagado": "number", 
      "estadoPago": "string", 
      "referenciaPago": "string", 

--- Página 14 ---
 
Microservicio MsDatosSolicitudes 
14 
      "fechaPago": "YYYY-MM-DDThh:mm:ssZ" 
    }, 
    "observaciones": "string", 
    "requiereDiligencia": "boolean", 
    "tiempoEstimadoResolucion": "integer", 
    "diasTranscurridos": "integer", 
    "diasRestantes": "integer", 
    "urlSeguimiento": "string" 
  }, 
  "metadata": { 
    "timestamp": "YYYY-MM-DDThh:mm:ssZ", 
    "correlationId": "string", 
    "version": "string" 
  } 
} 
Error Response 
     "error": { 
      "tipo": "string", 
      "titulo": "string", 
      "estado": "integer", 
      "errores": [ 
        { 
         "detalleError": "string" 
      } 
    ] 
  } 
 
3.1.3.1 Parámetros de Entrada 
Dato 
Atributo 
Tipo 
Obligatorio 
Longitud 
mínima 
Longitud 
máxima 
Identificador de 
Solicitud 
solicitudId 
String (UUID) 
Sí 
36 
36 
 
3.1.3.2 Parámetros de Respuesta 
Nombre 
Tipo 
Obligatorio 
Descripción 
success 
Boolean 
Sí 
Indica si la operación fue 
exitosa. 
data 
Object 
Sí 
Cuerpo principal de la 
respuesta con información 
del trámite. 
data.solicitudId 
String 
Sí 
Identificador único (UUID) 
de la solicitud. 
data.numeroSolicitud 
String 
Sí 
Número visible o legible 
asignado a la solicitud. 
data.tipoTramite 
String 
Sí 
Tipo de trámite solicitado. 
data.subTipoTramite 
String 
No 
Subtipo o clasificación 
específica del trámite. 
data.estado 
String 
Sí 
Estado actual de la solicitud. 
data.estadoAnterior 
String 
No 
Estado previo antes del 
cambio de estado actual. 
data.fechaRegistro 
String 
(Date 
Sí 
Fecha y hora de registro del 
trámite en formato ISO 
8601. 

--- Página 15 ---
 
Microservicio MsDatosSolicitudes 
15 
ISO 
8601) 
data.fechaCambioEstado 
String 
(Date 
ISO 
8601) 
No 
Fecha y hora del último 
cambio de estado en 
formato ISO 8601. 
data.fechaVencimiento 
String 
(Date 
ISO 
8601) 
No 
Fecha de vencimiento o 
plazo del trámite en formato 
ISO 8601. 
data.solicitante 
Object 
Sí 
Información del ciudadano o 
entidad que realiza el 
trámite. 
data.solicitante.dni 
String 
Sí 
Documento Nacional de 
Identidad del solicitante. 
data.solicitante.nombres 
String 
Sí 
Nombres del solicitante. 
data.solicitante.apellidoPaterno 
String 
Sí 
Apellido paterno del 
solicitante. 
data.solicitante.apellidoMaterno 
String 
Sí 
Apellido materno del 
solicitante. 
data.solicitante.email 
String 
No 
Correo electrónico del 
solicitante. 
data.solicitante.telefono 
String 
No 
Teléfono de contacto. 
data.solicitante.direccion 
Object 
No 
Dirección completa del 
solicitante. 
data.solicitante.direccion.departamento 
String 
Sí 
Departamento de residencia 
del solicitante 
data.solicitante.direccion.provincia 
String 
Sí 
Provincia de residencia del 
solicitante 
data.solicitante.direccion.distrito 
String 
Sí 
Distrito de residencia del 
solicitante 
data.solicitante.direccion.direccionCompleta 
String 
Sí 
Dirección completa del 
solicitante 
data.tipoSolicitante 
String 
Sí 
Tipo de solicitante 
data.prioridad 
String 
No 
Prioridad asignada al trámite 
data.oficinaRegistro 
Object 
Sí 
Oficina donde se registró el 
trámite. 
data.oficinaRegistro.codigo 
String 
Sí 
Código de la oficina. 
data.oficinaRegistro.nombre 
String 
Sí 
Nombre descriptivo de la 
oficina. 
data.usuarioRegistro 
String 
Sí 
Usuario responsable del 
registro inicial. 
data.usuarioAsignado 
String 
No 
Usuario actual asignado al 
trámite. 
data.fechaAsignacion 
String 
(Date 
ISO 
8601) 
No 
Fecha y hora en que se 
asignó al usuario actual en 
formato ISO 8601. 

--- Página 16 ---
 
Microservicio MsDatosSolicitudes 
16 
data.pago 
Object 
No 
Información del pago 
asociado al trámite. 
data.pago.montoTotal 
Number 
No 
Monto total del trámite. 
data.pago.montoPagado 
Number 
No 
Monto efectivamente 
pagado. 
data.pago.estadoPago 
String 
No 
Estado actual del pago. 
data.pago.referenciaPago 
String 
No 
Referencia o número de 
comprobante del pago. 
data.pago.fechaPago 
String 
(Date 
ISO 
8601) 
No 
Fecha y hora en que se 
realizó el pago en formato 
ISO 8601. 
data.observaciones 
String 
No 
Comentarios u 
observaciones adicionales. 
data.requiereDiligencia 
Boolean 
No 
Indica si requiere una 
diligencia adicional. 
data.tiempoEstimadoResolucion 
Integer 
No 
Tiempo estimado de 
resolución en días. 
data.diasTranscurridos 
Integer 
No 
Número de días 
transcurridos desde el 
registro. 
data.diasRestantes 
Integer 
No 
Número de días restantes 
antes del vencimiento. 
data.urlSeguimiento 
String 
(URI) 
No 
Enlace para realizar el 
seguimiento en línea del 
trámite. 
metadata 
Object 
Sí 
Metadatos de la operación. 
metadata.timestamp 
String 
(Date 
ISO 
8601) 
Sí 
Marca de tiempo del 
procesamiento. 
metadata.correlationId 
String 
Sí 
Identificador de correlación 
para trazabilidad. 
metadata.version 
String 
Sí 
Versión del servicio. 
error 
Object 
No 
Objeto qué especifica algún 
error existente en la 
operación. 
error.tipo 
String 
No 
Tipo de error 
error.titulo 
String 
No 
Título del error 
error.status 
integer 
No 
Número del estado de error 
error.errores 
Array 
No 
Listado de errores 
error.errores[].detalleError 
String 
No 
Detalle del error generado 
 
3.1.3.3 Valores para el atributo de statusCode 
Código 
Respuesta 
Descripción 
200 
OK 
Solicitud encontrada y recuperada exitosamente 

--- Página 17 ---
 
Microservicio MsDatosSolicitudes 
17 
400 
Bad Request 
UUID de solicitud con formato inválido 
401 
Unauthorized 
Token JWT inválido o expirado 
403 
Forbidden 
Usuario sin permisos para consultar solicitudes en esta oficina 
404 
Not Found 
Solicitud no encontrada con el ID proporcionado 
429 
Too Many Requests Límite de rate limit excedido 
500 
Internal Server Error Error interno del servidor 
503 
Service Unavailable Servicio temporalmente no disponible 
 
3.1.4 Endpoint: Actualizar Solicitud Completa 
Endpoint encargado de actualizar una solicitud especifica por el id de la solicitud 
Atributo 
Valor 
Path 
/api/v1/solicitudes/MsDatosSolicitudes 
API Gateway 
Interno 
Método HTTP 
PUT 
Protocolo 
REST/HTTP 
Headers 
Authorization String (Bearer token JWT para autenticación del usuario) 
"Content-Type": "application/json" 
X-Correlation-ID UUID (Identificador único de correlación para trazabilidad end-
to-end) 
X-Office-Code String (Código de oficina o sede desde donde se realiza la 
operación) 
X-User-Role String (Rol del usuario que realiza la operación, por ejemplo: 
REGISTRADOR) 
Entrada 
{ 
  "prioridad": "string", 
  "requisitosCumplidos": [ 
    { 
      "requisitoId": "string", 
      "nombreRequisito": "string", 
      "cumple": "boolean", 
      "observacion": "string" 
    } 
  ], 
  "datosEspecificosTramite": { 
    "motivoRenovacion": "String", 
    "dniAnterior": "String", 
    "fechaVencimientoDniAnterior": "YYYY-MM-DDThh:mm:ssZ", 
    "requiereEntregaDomicilio": "boolean", 
    "oficinaEntregaPreferida": "String", 
    "documentosAdjuntos": [ 
      { 
        "tipo": "string", 
        "nombre": "string", 
        "tamanioBytes": "integer", 
        "mimeType": "string", 
        "checksum": "string" 
      } 
    ] 
  }, 
  "pago": { 
    "montoPagado": "number", 
    "metodoPago": "string", 

--- Página 18 ---
 
Microservicio MsDatosSolicitudes 
18 
    "referenciaPago": "string", 
    "fechaPago": "YYYY-MM-DDThh:mm:ssZ" 
  }, 
  "observaciones": "string" 
} 
Respuesta 
{ 
  "success": "boolean", 
  "data": { 
    "solicitudId": "string", 
    "numeroSolicitud": "string", 
    "estado": "string", 
    "tipoTramite": "string", 
    "dniSolicitante": "string", 
    "nombresSolicitante": "string", 
    "fechaRegistro": "YYYY-MM-DDThh:mm:ssZ", 
    "usuarioRegistro": "string", 
    "oficinaRegistro": { 
      "codigo": "string", 
      "nombre": "string" 
    }, 
    "siguientesPasos": [ 
      { 
        "paso": "string" 
      } 
    ], 
    "tiempoEstimadoResolucion": "integer", 
    "fechaVencimiento": "YYYY-MM-DDThh:mm:ssZ", 
    "urlSeguimiento": "string", 
    "codigoQR": "string", 
    "_links": { 
      "self": "string", 
      "actualizar": "string", 
      "cambiarEstado": "string", 
      "historial": "string" 
    } 
  }, 
  "metadata": { 
    "timestamp": "YYYY-MM-DDThh:mm:ssZ", 
    "correlationId": "string", 
    "version": "string" 
  } 
} 
Error Response 
     "error": { 
      "tipo": "string", 
      "titulo": "string", 
      "estado": "integer", 
      "errores": [ 
        { 
         "detalleError": "string" 
      } 
    ] 
  } 
 
3.1.4.1 Parámetros de Entrada 
Dato 
Atributo 
Tipo 
Obligatorio 
Longitud 
mínima 
Longitud 
máxima 
Prioridad 
prioridad 
String 
Sí 
4 
20 
Requisitos 
Cumplidos 
requisitosCumplidos 
Array 
Sí 
1 
100 

--- Página 19 ---
 
Microservicio MsDatosSolicitudes 
19 
RequisitoId 
requisitosCumplidos[].requisitoId 
String 
Sí 
3 
50 
RequisitoNombre requisitosCumplidos[].nombreRe
quisito 
String 
Sí 
3 
120 
RequisitoCumple requisitosCumplidos[].cumple 
Boolean 
Sí 
NA 
NA 
RequisitoObserva
ción 
requisitosCumplidos[].observacio
n 
String 
No 
0 
300 
Datos Específicos datosEspecificosTramite 
Object 
Sí 
NA 
NA 
Motivo 
Renovación 
datosEspecificosTramite.motivoR
enovacion 
String 
Sí 
3 
30 
DNI Anterior 
datosEspecificosTramite.dniAnter
ior 
String 
Sí 
8 
8 
Fecha 
Vencimiento DNI 
Anterior 
datosEspecificosTramite.fechaVe
ncimientoDniAnterior 
String 
(Date 
ISO 
8601) 
Sí 
NA 
NA 
Entrega a 
Domicilio 
datosEspecificosTramite.requiere
EntregaDomicilio 
Boolean 
Sí 
NA 
NA 
Oficina Entrega 
Preferida 
datosEspecificosTramite.oficinaE
ntregaPreferida 
String 
No 
5 
40 
Documentos 
Adjuntos 
documentosAdjuntos 
Array 
No 
0 
20 
Doc.Tipo 
documentosAdjuntos[].tipo 
String 
Sí 
3 
40 
Doc.Nombre 
documentosAdjuntos[].nombre 
String 
Sí 
3 
200 
Doc.Tamaño 
(bytes) 
documentosAdjuntos[].tamanioBy
tes 
Integer 
Sí 
NA 
NA 
Doc.MimeType 
documentosAdjuntos[].mimeType 
String 
Sí 
3 
100 
Doc.Checksum 
documentosAdjuntos[].checksum 
String 
No 
10 
200 
Pago 
pago 
Object 
Sí 
NA 
NA 
Monto Pagado 
pago.montoPagado 
Decimal 
Sí 
NA 
NA 
Método de Pago 
pago.metodoPago 
String 
Sí 
2 
20 
Referencia de 
Pago 
pago.referenciaPago 
String 
Sí 
3 
60 
Fecha de Pago 
pago.fechaPago 
String 
(Date 
ISO 
8601) 
Sí 
NA 
NA 
Observaciones 
observaciones 
String 
No 
0 
500 
 
3.1.4.2 Parámetros de Respuesta 
Nombre 
Tipo 
Obligatorio 
Descripción 
success 
Boolean 
Sí 
Indica si la operación fue exitosa. 
data 
Object 
Sí 
Cuerpo principal de la respuesta. 
data.solicitudId 
String 
Sí 
UUID de la solicitud creada. 
data.numeroSolicitud 
String 
Sí 
Número legible de solicitud. 
data.estado 
String 
Sí 
Estado actual de la solicitud  
data.tipoTramite 
String 
Sí 
Tipo de trámite. 
data.dniSolicitante 
String 
Sí 
DNI del solicitante. 

--- Página 20 ---
 
Microservicio MsDatosSolicitudes 
20 
data.nombresSolicitante 
String 
Sí 
Nombres y apellidos concatenados. 
data.fechaRegistro 
String (Date 
ISO 8601) 
Sí 
Fecha/hora de registro ISO 8601 (UTC). 
data.usuarioRegistro 
String 
Sí 
Usuario que registra. 
data.oficinaRegistro 
Object 
Sí 
Oficina de registro. 
data.oficinaRegistro.codigo 
String 
Sí 
Código de oficina (ej.: ORG-LIMA-
CENTRO). 
data.oficinaRegistro.nombre 
String 
Sí 
Nombre de la oficina. 
data.siguientesPasos[] 
Array 
No 
Próximas acciones sugeridas. 
data.siguientesPasos[].paso 
String 
No 
Siguiente paso en la solicitud 
data.tiempoEstimadoResolucion 
Integer 
No 
Días estimados de resolución. 
data.fechaVencimiento 
String (Date 
ISO 8601) 
No 
Fecha límite/compromiso. 
data.urlSeguimiento 
String (URI) 
No 
URL para seguimiento. 
data.codigoQR 
String 
No 
PNG en Base64 del QR. 
data._links 
Object 
Sí 
Hipervínculos de navegación. 
data._links.self 
String 
Sí 
Recurso actual. 
data._links.actualizar 
String 
Sí 
Endpoint para actualizar. 
data._links.cambiarEstado 
String 
Sí 
Endpoint para cambio de estado. 
data._links.historial 
String 
Sí 
Endpoint para historial. 
metadata 
Object 
Sí 
Metadatos de la operación. 
metadata.timestamp 
String (Date 
ISO 8601) 
Sí 
Marca de tiempo del procesamiento. 
metadata.correlationId 
String 
Sí 
Identificador de correlación para 
trazabilidad. 
metadata.version 
String 
Sí 
Versión del servicio. 
error 
Object 
No 
Objeto qué especifica algún error existente 
en la operación. 
error.tipo 
String 
No 
Path de la ruta con error 
error.titulo 
String 
No 
Título del error 
error.status 
integer 
No 
Número del estado de error 
error.errores 
Array 
No 
Listado de errores 
error.errores[].detalleError 
String 
No 
Detalle del error generado 
 
3.1.4.3 Valores para el atributo de statusCode 
Código 
Respuesta 
Descripción 
200 
OK 
Solicitud actualizada exitosamente 
400 
Bad Request 
Datos de actualización inválidos 
401 
Unauthorized 
Token JWT inválido o expirado 
403 
Forbidden 
Usuario sin permisos para actualizar esta solicitud 
404 
Not Found 
Solicitud no encontrada con el ID proporcionado 
422 
Unprocessable Entity 
Estado actual no permite actualizaciones 
429 
Too Many Requests 
Límite de rate limit excedido 
500 
Internal Server Error 
Error interno del servidor 
503 
Service Unavailable 
Servicio temporalmente no disponible 
 

--- Página 21 ---
 
Microservicio MsDatosSolicitudes 
21 
3.1.5 Endpoint: Consultar Solicitudes Pendientes Offline 
Endpoint que permite consultar las solicitudes que están pendientes de sincronización cuando el 
sistema trabaja en modo offline, permitiendo a los funcionarios conocer qué trámites aún no han sido 
enviados al sistema central. 
Atributo 
Valor 
Path 
/api/v1/solicitudes/MsDatosSolicitudes/offline/pendientes 
API Gateway 
Interno 
Método HTTP 
GET 
Protocolo 
REST/HTTP 
Headers 
Authorization String Bearer token JWT para autenticación 
Content-Type String "application/json" 
X-Correlation-ID UUID Identificador único de correlación 
X-Office-Code String Código de oficina o sede 
X-Device-ID String Identificador único del dispositivo en modo offline 
X-Sync-Token String Token de sincronización para operaciones distribuidas 
Parámetros 
• 
oficinaCode (string): Código de la oficina utilizada como filtro. 
• 
dispositivoId (string): Identificador del dispositivo asociado a la consulta. 
• 
fechaDesde (string): Fecha inicial para el rango de consulta. 
• 
fechaHasta (string): Fecha final para el rango de consulta. 
• 
estadoSincronizacion (string): Estado de sincronización utilizado como 
criterio de filtrado. 
• 
page (integer): Número de página para la paginación. 
• 
size (integer): Cantidad de registros por página. 
• 
incluirDetalles (boolean): Indica si deben incluirse detalles adicionales en 
la respuesta. 
Respuesta 
{ 
  "statusCode": "integer", 
  "data": [ 
    { 
      "solicitudId": "string", 
      "numeroSolicitud": "string", 
      "tipoTramite": "string", 
      "dniSolicitante": "string", 
      "nombresSolicitante": "string", 
      "fechaRegistroOffline": "YYYY-MM-DDThh:mm:ssZ", 
      "fechaUltimoIntento": "YYYY-MM-DDThh:mm:ssZ", 
      "dispositivoId": "string", 
      "dispositivoNombre": "string", 
      "estadoSincronizacion": "string", 
      "intentosSincronizacion": "integer", 
      "proximoIntentoEn": "YYYY-MM-DDThh:mm:ssZ", 
      "ultimoErrorSincronizacion": "string", 
      "codigoError": "string", 
      "prioridad": "string", 
      "tamañoDatos": "integer", 
      "conDocumentosAdjuntos": "boolean", 
      "numeroDocumentosAdjuntos": "integer", 
      "validacionBiometricaLocal": "string", 
      "oficinaRegistro": "string" 
    } 
  ], 
  "resumen": { 
    "totalPendientes": "integer", 
    "totalErrores": "integer", 
    "totalSincronizados": "integer", 
    "tamañoTotalPendiente": "integer", 
    "dispositivosAfectados": "integer", 
    "solicitudMasAntigua": "YYYY-MM-DDThh:mm:ssZ" 
  }, 

--- Página 22 ---
 
Microservicio MsDatosSolicitudes 
22 
  "pagination": { 
    "page": "integer", 
    "size": "integer", 
    "totalElements": "integer", 
    "totalPages": "integer", 
    "first": "boolean", 
    "last": "boolean" 
  }, 
  "metadata": { 
    "timestamp": "YYYY-MM-DDThh:mm:ssZ", 
    "correlationId": "string", 
    "version": "string", 
    "tiempoConsulta": "string" 
  } 
} 
Error Response 
     "error": { 
      "tipo": "string", 
      "titulo": "string", 
      "estado": "integer", 
      "errores": [ 
        { 
         "detalleError": "string" 
      } 
    ] 
  } 
 
3.1.5.1 Parámetros de Entrada 
Dato 
Atributo 
Tipo 
Obligatorio 
Longitud 
mínima 
Longitud 
máxima 
Código de Oficina 
oficinaCode 
String 
Sí 
2 
20 
ID de Dispositivo 
dispositivoId 
String 
No 
3 
50 
Fecha Desde 
fechaDesde 
String 
No 
10 
10 
Fecha Hasta 
fechaHasta 
String 
No 
10 
10 
Estado de 
Sincronización 
estadoSincronizacion 
String 
No 
5 
20 
Número de Página 
page 
Integer 
No 
NA 
NA 
Tamaño de Página 
size 
Integer 
No 
NA 
NA 
Incluir Detalles 
incluirDetalles 
Boolean 
No 
NA 
NA 
 
3.1.5.2 Parámetros de Respuesta 
Nombre 
Tipo 
Obligatorio 
Descripción 
statusCode 
Integer 
Sí 
Código de estado HTTP 
solicitudId 
String 
Sí 
ID único temporal con prefijo "offline_" 
numeroSolicitud 
String 
Sí 
Número temporal de solicitud offline 
tipoTramite 
String 
Sí 
Tipo de trámite registrado 
dniSolicitante 
String 
Sí 
DNI del solicitante 
nombresSolicitante 
String 
Sí 
Nombres completos del solicitante 
fechaRegistroOffline 
String (Date 
ISO 8601) 
Sí 
Fecha y hora de registro en modo 
offline 

--- Página 23 ---
 
Microservicio MsDatosSolicitudes 
23 
fechaUltimoIntento 
String (Date 
ISO 8601) 
No 
Fecha del último intento de 
sincronización 
dispositivoId 
String 
Sí 
Identificador del dispositivo que 
registró 
dispositivoNombre 
String 
Sí 
Nombre descriptivo del dispositivo 
estadoSincronizacion 
String 
Sí 
Estado de la sincronización 
intentosSincronizacion 
Integer 
Sí 
Número de intentos realizados 
proximoIntentoEn 
String (Date 
ISO 8601) 
No 
Fecha programada del próximo 
intento 
ultimoErrorSincronizacion 
String 
No 
Descripción del último error si existe 
codigoError 
String 
No 
Código de error estandarizado 
prioridad 
String 
Sí 
Prioridad 
tamañoDatos 
Integer 
Sí 
Tamaño en bytes de los datos a 
sincronizar 
conDocumentosAdjuntos 
Boolean 
Sí 
Si incluye documentos adjuntos 
numeroDocumentosAdjuntos 
Integer 
Sí 
Cantidad de documentos adjuntos 
validacionBiometricaLocal 
String 
Sí 
Estado de validación biométrica local 
oficinaRegistro 
String 
Sí 
Nombre de la oficina/punto de registro 
totalPendientes 
Integer 
Sí 
Total de solicitudes pendientes 
totalErrores 
Integer 
Sí 
Total de solicitudes con error 
totalSincronizados 
Integer 
Sí 
Total ya sincronizadas 
tamañoTotalPendiente 
Integer 
Sí 
Tamaño total en bytes pendientes 
dispositivosAfectados 
Integer 
Sí 
Número de dispositivos con 
pendientes 
solicitudMasAntigua 
String (Date 
ISO 8601) 
No 
Fecha de la solicitud más antigua 
page 
Integer 
Sí 
Página actual 
size 
Integer 
Sí 
Tamaño de página 
totalElements 
Integer 
Sí 
Total de elementos 
totalPages 
Integer 
Sí 
Total de páginas 
error 
Object 
No 
Objeto qué especifica algún error 
existente en la operación. 
error.tipo 
String 
No 
Tipo de error 
error.titulo 
String 
No 
Título del error 
error.status 
integer 
No 
Número del estado de error 
error.errores 
Array 
No 
Listado de errores 
error.errores[].detalleError 
String 
No 
Detalle del error generado 
 
3.1.5.3 Valores para el atributo statusCode 
Código 
Respuesta 
Descripción 
200 
OK 
Solicitudes consultadas exitosamente 
400 
Bad Request 
Parámetros de búsqueda inválidos (fechas incorrectas, oficina 
inválida) 

--- Página 24 ---
 
Microservicio MsDatosSolicitudes 
24 
401 
Unauthorized 
Token JWT inválido o expirado 
403 
Forbidden 
Usuario sin permisos para consultar solicitudes offline de esta 
oficina 
404 
Not Found 
No se encontraron solicitudes pendientes con los criterios 
especificados 
429 
Too Many Requests 
Límite de rate limit excedido 
500 
Internal Server Error 
Error interno del servidor 
503 
Service Unavailable 
Servicio temporalmente no disponible 
 
3.1.6 Endpoint: Crear Diligencia 
Descripción: Endpoint que permite crear una diligencia asociada a una solicitud o trámite que requiere 
información adicional de entidades externas (MIGRACIONES, MINSA, otras oficinas RENIEC, etc.). 
Justificación 
• 
Este endpoint responde a la necesidad establecida en: 
• 
RF-019: Gestión de Diligencias 
• 
RF-039: Gestión Diligencias Pendientes 
• 
RF-040: Seguimiento de Diligencias 
Muchos trámites registrales requieren información de otras entidades antes de poder resolverse. Este 
endpoint permite: 
• 
Crear diligencias formales con plazo de respuesta 
• 
Generar oficios automáticos 
• 
Establecer seguimiento de respuestas 
• 
Gestionar reiteraciones si no hay respuesta 
• 
Mantener trazabilidad completa del proceso 
Atributo 
Valor 
Path 
/api/v1/solicitudes/MsDatosSolicitudes/diligencia 
API Gateway 
Interno 
Método HTTP 
POST 
Protocolo 
REST/HTTP 
Headers 
Authorization String Bearer token JWT para autenticación 
Content-Type String "application/json" 
X-Correlation-ID UUID Identificador único de correlación 
X-Office-Code String Código de oficina o sede 
X-User-Role String (Rol del usuario autenticado) 
X-Idempotency-Key UUID (Clave de idempotencia para prevenir duplicación en 
reintentos) 
Entrada 
{ 
  "solicitudId": "string", 
  "tipoDiligencia": "string", 
  "entidadDestino": "string", 
  "tipoEntidad": "string", 
  "datosContactoEntidad": { 
    "nombre": "string", 
    "direccion": "string", 
    "telefono": "string", 
    "email": "string", 
    "personaContacto": "string" 
  }, 
  "motivoDiligencia": "string", 

--- Página 25 ---
 
Microservicio MsDatosSolicitudes 
25 
  "fundamentoLegal": "string", 
  "informacionRequerida": "string", 
  "documentosRequeridos": [ 
    { 
      "tipoDocumento": "string", 
      "descripcion": "string", 
      "obligatorio": "boolean", 
      "formatoSolicitado": "string" 
    } 
  ], 
  "plazoRespuesta": "integer", 
  "unidadPlazo": "string", 
  "prioridad": "string", 
  "requiereRespuestaOficial": "boolean", 
  "permitoRespuestaDigital": "boolean", 
  "datosReferenciaOficio": { 
    "numeroOficioAsociado": "string", 
    "expedienteReferencia": "string" 
  }, 
  "observaciones": "string", 
  "oficinaResponsableSeguimiento": "string", 
  "usuarioSolicitante": "string", 
  "notificarCreacion": "boolean", 
  "destinatariosNotificacion": [ 
    "string" 
  ] 
} 
Respuesta 
 { 
  "statusCode": "integer", 
  "data": { 
    "diligenciaId": "string", 
    "numeroDiligencia": "string", 
    "solicitudId": "string", 
    "numeroSolicitud": "string", 
    "estado": "string", 
    "tipoDiligencia": "string", 
    "entidadDestino": "string", 
    "motivoDiligencia": "string", 
    "fechaCreacion": "YYYY-MM-DDThh:mm:ssZ", 
    "fechaVencimiento": "YYYY-MM-DDThh:mm:ssZ", 
    "plazoRespuesta": "integer", 
    "diasTranscurridos": "integer", 
    "diasRestantes": "integer", 
    "prioridad": "string", 
    "oficinaResponsable": { 
      "codigo": "string", 
      "nombre": "string" 
    }, 
    "usuarioSolicitante": "string", 
    "estadoOficio": "string", 
    "documentosGenerados": [ 
      { 
        "tipoDocumento": "string", 
        "numeroOficio": "string", 
        "urlDocumento": "string", 
        "fechaGeneracion": "YYYY-MM-DDThh:mm:ssZ", 
        "firmadoDigitalmente": "boolean", 
        "hash": "string" 
      } 
    ], 
    "seguimiento": { 
      "reiteracionesPermitidas": "integer", 
      "proximaRevision": "YYYY-MM-DDThh:mm:ssZ", 
      "alertasConfiguradas": "boolean" 

--- Página 26 ---
 
Microservicio MsDatosSolicitudes 
26 
    }, 
    "eventosPublicados": [ 
      "string" 
    ] 
  }, 
  "metadata": { 
    "timestamp": "string", 
    "correlationId": "string", 
    "version": "string" 
  } 
} 
Error Response 
     "error": { 
      "tipo": "string", 
      "titulo": "string", 
      "estado": "integer", 
 
      "errores": [ 
        { 
         "detalleError": "string" 
      } 
    ] 
  } 
 
3.1.7 Parámetros de Entrada 
Dato 
Atributo 
Tipo 
Obligatori
o 
Longitu
d Mín 
Longitu
d Máx 
data 
solicitudId 
String 
(UUID) 
Sí 
36 
36 
data 
tipoDiligencia 
String 
Sí 
- 
- 
data 
entidadDestino 
String 
Sí 
3 
100 
data 
tipoEntidad 
String 
Sí 
- 
- 
data.datosContactoEntida
d 
nombre 
String 
Sí 
5 
200 
data.datosContactoEntida
d 
direccion 
String 
Condicion
al 
10 
300 
data.datosContactoEntida
d 
email 
String 
Condicion
al 
5 
100 
data.datosContactoEntida
d 
telefono 
String 
No 
7 
20 
data 
motivoDiligencia 
String 
Sí 
20 
1000 
data 
fundamentoLegal 
String 
Sí 
10 
500 
data 
informacionRequerida 
String 
Sí 
10 
2000 
data.documentosRequerid
os[] 
tipoDocumento 
String 
Sí 
3 
100 
data.documentosRequerid
os[] 
descripcion 
String 
Sí 
10 
500 
data.documentosRequerid
os[] 
obligatorio 
Boolea
n 
Sí 
- 
- 

--- Página 27 ---
 
Microservicio MsDatosSolicitudes 
27 
data 
plazoRespuesta 
Integer 
Sí 
- 
- 
data 
unidadPlazo 
String 
Sí 
- 
- 
data 
prioridad 
String 
No 
- 
- 
data 
requiereRespuestaOficial 
Boolea
n 
No 
- 
- 
data 
permitoRespuestaDigital 
Boolea
n 
No 
- 
- 
data 
observaciones 
String 
No 
0 
2000 
data 
oficinaResponsableSeguimi
ento 
String 
Sí 
3 
20 
 
3.1.7.1 Parámetros de Respuesta 
Dato 
Atributo 
Tipo 
Obligatorio 
Descripción 
- 
statusCode 
Integer 
Sí 
Código 
de 
estado HTTP 
data 
diligenciaId 
String 
(UUID) 
Sí 
Identificador 
único 
de 
la 
diligencia 
creada 
data 
numeroDiligencia 
String 
Sí 
Número 
correlativo 
visible 
(DIL-
YYYY-
NNNNNN) 
data 
solicitudId 
String 
(UUID) 
Sí 
ID 
de 
la 
solicitud origen 
data 
numeroSolicitud 
String 
Sí 
Número de la 
solicitud origen 
data 
estado 
String 
Sí 
Estado 
inicial 
(PENDIENTE) 
data 
tipoDiligencia 
String 
Sí 
FISICA 
o 
DIGITAL 
data 
entidadDestino 
String 
Sí 
Entidad 
externa 
destinataria 
data 
motivoDiligencia 
String 
Sí 
Motivo de la 
diligencia 
data 
fechaCreacion 
String (Date 
ISO 8601) 
Sí 
Fecha y hora 
de creación 
data 
fechaVencimiento 
String (Date 
ISO 8601) 
Sí 
Fecha límite de 
respuesta 
data 
plazoRespuesta 
Integer 
Sí 
Plazo en días 

--- Página 28 ---
 
Microservicio MsDatosSolicitudes 
28 
data 
diasTranscurridos 
Integer 
Sí 
Días 
desde 
creación (0 al 
crear) 
data 
diasRestantes 
Integer 
Sí 
Días 
hasta 
vencimiento 
data 
prioridad 
String 
Sí 
ALTA, MEDIA, 
BAJA 
data.oficinaResponsable 
codigo 
String 
Sí 
Código 
de 
oficina 
responsable 
data.oficinaResponsable 
nombre 
String 
Sí 
Nombre 
de 
oficina 
responsable 
data 
usuarioSolicitante 
String 
Sí 
Email 
del 
usuario 
que 
creó 
data 
estadoOficio 
String 
Sí 
GENERADO, 
ENVIADO, 
RECIBIDO 
data.documentosGenerados[] tipoDocumento 
String 
Sí 
Tipo 
de 
documento 
generado 
data.documentosGenerados[] numeroOficio 
String 
Sí 
Número 
del 
oficio generado 
data.documentosGenerados[] urlDocumento 
String 
Sí 
URL 
para 
descarga 
del 
PDF 
data.documentosGenerados[] firmadoDigitalmente 
Boolean 
Sí 
Si tiene firma 
digital 
data.documentosGenerados[] hash 
String 
Sí 
Hash SHA-256 
del documento 
data.seguimiento 
reiteracionesPermitidas Integer 
Sí 
Reiteraciones 
permitidas 
data.seguimiento 
proximaRevision 
String (Date 
ISO 8601) 
Sí 
Fecha 
de 
próxima 
revisión 
data.seguimiento 
alertasConfiguradas 
Boolean 
Sí 
Si hay alertas 
configuradas 
data 
eventosPublicados 
Array[String] 
No 
Lista 
de 
eventos 
publicados en 
Kafka 
3.1.7.2 Valores para el atributo statusCode 
Código 
Respuesta 
Descripción 
201 
Created 
Diligencia creada exitosamente 

--- Página 29 ---
 
Microservicio MsDatosSolicitudes 
29 
400 
Bad Request 
Datos inválidos o requisitos incompletos 
401 
Unauthorized 
Token JWT inválido o expirado 
403 
Forbidden 
Usuario sin permisos para crear diligencias 
404 
Not Found 
Solicitud origen no encontrada 
409 
Conflict 
Ya existe una diligencia activa para esta solicitud y entidad 
422 
Unprocessable Entity 
Datos válidos pero lógica de negocio no permite procesarlos 
429 
Too Many Requests 
Límite de rate limit excedido 
500 
Internal Server Error 
Error interno del servidor 
503 
Service Unavailable 
Servicio temporalmente no disponible 
 
3.1.8 Endpoint: Verificar Duplicados 
Endpoint que permite consultar el historial completo de trazabilidad de una solicitud, incluyendo todos los 
eventos, cambios de estado, modificaciones de datos, asignaciones de usuarios y diligencias creadas. Este 
endpoint es fundamental para cumplir con los requisitos RNF-001 (Log Auditoría) y RNF-020 (Trazabilidad 
Completa), proporcionando transparencia total sobre el ciclo de vida de cada solicitud. 
Atributo 
Valor 
Path 
/api/v1/solicitudes/MsDatosSolicitudes/verificar-duplicado 
API Gateway 
Interno 
Método HTTP 
POST 
Protocolo 
REST/HTTP 
Headers 
AuthorizationStringSíBearer token JWT para autenticación 
Content-Type String "application/json" 
X-Correlation-ID UUID Identificador único de correlación 
X-Office-Code String Código de oficina donde se realiza validación 
X-Device-ID String ID del dispositivo de captura biométrica 
X-Biometric-Quality String Calidad reportada por dispositivo 
Entrada 
• 
solicitudId UUID 
• 
fechaDesde String (ISO 8601) 
• 
fechaHasta String (ISO 8601) 
• 
tipoEvento String 
• 
usuarioId String 
• 
limit Integer 
• 
offset Integer 
• 
ordenamiento String 
• 
incluirDatosDetallados Boolean 
Respuesta 
{ 
  "success": "boolean", 
  "data": { 
    "solicitudId": "string", 
    "numeroSolicitud": "string", 
    "tipoTramite": "string", 
    "estadoActual": "string", 
    "fechaCreacion": "YYYY-MM-DDThh:mm:ssZ", 
    "fechaUltimaModificacion": "YYYY-MM-DDThh:mm:ssZ", 
    "totalEventos": "integer", 
    "eventos": [ 
      { 
        "eventoId": "string", 
        "tipoEvento": "string", 
        "fechaHora": "YYYY-MM-DDThh:mm:ssZ", 

--- Página 30 ---
 
Microservicio MsDatosSolicitudes 
30 
        "descripcion": "string", 
        "usuario": { 
          "usuarioId": "string", 
          "nombreCompleto": "string", 
          "rol": "string", 
          "email": "string" 
        }, 
        "oficina": { 
          "codigo": "string", 
          "nombre": "string" 
        }, 
        "detalles": { 
          "motivo": "string", 
          "canalIngreso": "string", 
          "dispositivoId": "string", 
          "resultado": "string", 
          "scoreHuellas": "number", 
          "scoreRostro": "number", 
          "tiempoValidacion": "string", 
          "coincidenciasEncontradas": "integer", 
          "estadoAnterior": "string", 
          "estadoNuevo": "string", 
          "algoritmo": "string", 
          "cargaTrabajo": { 
            "solicitudesPendientes": "integer", 
            "promedioAtencion": "string" 
          }, 
          "usuarioAsignado": { 
            "usuarioId": "string", 
            "nombreCompleto": "string", 
            "rol": "string" 
          }, 
          "prioridad": "string", 
          "sesionId": "string", 
          "camposModificados": [ 
            { 
              "campo": "string", 
              "valorAnterior": "string", 
              "valorNuevo": "string", 
              "justificacion": "string" 
            } 
          ], 
          "requiereAprobacion": "boolean", 
          "documentoSoporte": "string", 
          "comentario": "string", 
          "visibilidad": "string", 
          "categoria": "string", 
          "diligenciaId": "string", 
          "numeroDiligencia": "string", 
          "entidadDestino": "string", 
          "tipoConsulta": "string", 
          "plazoRespuesta": "string", 
          "estado": "string", 
          "canalNotificacion": "string", 
          "destinatario": "string", 
          "destinatarios": [ 
            "string" 
          ], 
          "asunto": "string", 
          "estadoEnvio": "string", 
          "plantilla": "string", 
          "respuesta": "string", 
          "domicilioFiscal": "string", 
          "coincidencia": "boolean", 

--- Página 31 ---
 
Microservicio MsDatosSolicitudes 
31 
          "documentoRespuesta": "string", 
          "resolucion": "string", 
          "tiempoTotalProceso": "string", 
          "proximoPaso": "string", 
          "mensaje": "string" 
        }, 
        "metadatos": { 
          "ipOrigen": "string", 
          "navegador": "string", 
          "sistemaOperativo": "string", 
          "geolocalizacion": { 
            "pais": "string", 
            "departamento": "string", 
            "ciudad": "string" 
          }, 
          "servicioExterno": "string", 
          "versionServicio": "string", 
          "estacionTrabajo": "string" 
        }, 
        "estadoAnterior": "string", 
        "estadoNuevo": "string" 
      } 
    ], 
    "resumenEventos": { 
      "totalCambiosEstado": "integer", 
      "totalModificaciones": "integer", 
      "totalAsignaciones": "integer", 
      "totalDiligencias": "integer", 
      "totalValidaciones": "integer", 
      "totalComentarios": "integer", 
      "totalNotificaciones": "integer" 
    }, 
    "estadisticas": { 
      "tiempoTotalProceso": "string", 
      "tiempoPorEtapa": { 
        "REGISTRADA": "string", 
        "ASIGNADA": "string", 
        "EN_PROCESO": "string" 
      }, 
      "usuariosInvolucrados": "integer", 
      "oficinasProceso": [ 
        "string" 
      ] 
    }, 
    "paginacion": { 
      "totalRegistros": "integer", 
      "totalPaginas": "integer", 
      "paginaActual": "integer", 
      "registrosPorPagina": "integer", 
      "tieneAnterior": "boolean", 
      "tieneSiguiente": "boolean" 
    } 
  }, 
  "metadata": { 
    "timestamp": "string", 
    "correlationId": "string", 
    "version": "string", 
    "tiempoRespuesta": "string" 
  } 
} 
Error Response 
     "error": { 
      "tipo": "string", 
      "titulo": "string", 
      "estado": "integer", 

--- Página 32 ---
 
Microservicio MsDatosSolicitudes 
32 
 
      "errores": [ 
        { 
         "detalleError": "string" 
      } 
    ] 
  } 
 
3.1.8.1 Parámetros de Entrada 
Parámetro 
Tipo 
Obligatorio 
Descripción 
Valores Permitidos 
fechaDesde 
String 
(ISO 
8601) 
No 
Fecha de inicio 
del 
rango 
de 
búsqueda 
YYYY-MM-DD 
fechaHasta 
String 
(ISO 
8601) 
No 
Fecha fin del 
rango 
de 
búsqueda 
YYYY-MM-DD 
tipoEvento 
String 
No 
Filtrar por tipo 
de evento 
CAMBIO_ESTADO, 
MODIFICACION, ASIGNACION, 
DILIGENCIA, 
VALIDACION_BIOMETRICA, 
COMENTARIO, NOTIFICACION 
usuarioId 
String 
No 
Filtrar 
eventos 
de un usuario 
específico 
-- 
limit 
Integer 
No 
Número 
máximo 
de 
eventos 
por 
página 
1-100 
offset 
Integer 
No 
Número 
de 
registros a omitir 
para paginación 
>= 0 
ordenamiento 
String 
No 
Orden de los 
resultados 
ASC, DESC 
incluirDatosDetallados 
Boolean 
No 
Incluir 
datos 
completos 
de 
modificaciones 
true, false 
 
3.1.8.2 Parámetros de Respuesta 
Nombre 
Tipo 
Obligatorio 
Descripción 
success 
Boolean 
Sí 
Indica si la operación fue 
exitosa 
data 
Object 
Sí 
Contiene toda la información 
del historial de la solicitud 
data.solicitudId 
String 
Sí 
ID único de la solicitud 
data.numeroSolicitud 
String 
Sí 
Número 
asignado 
a 
la 
solicitud 

--- Página 33 ---
 
Microservicio MsDatosSolicitudes 
33 
data.tipoTramite 
String 
Sí 
Tipo de trámite realizado 
data.estadoActual 
String 
Sí 
Estado actual del trámite 
data.fechaCreacion 
String (ISO 8601) 
Sí 
Fecha de creación de la 
solicitud 
data.fechaUltimaModificacion 
String (ISO 8601) 
Sí 
Última fecha de modificación 
data.totalEventos 
Integer 
Sí 
Número total de eventos 
registrados 
data.eventos 
Array 
Sí 
Lista de eventos asociados a 
la solicitud 
data.eventos.eventoId 
String 
Sí 
Identificador único del evento 
data.eventos.tipoEvento 
String 
Sí 
Tipo de evento registrado 
data.eventos.fechaHora 
String (ISO 8601) 
Sí 
Fecha y hora del evento 
data.eventos.descripcion 
String 
Sí 
Descripción del evento 
data.eventos.usuario 
Object 
Sí 
Datos del usuario que generó 
el evento 
data.eventos.usuario.usuarioId 
String 
Sí 
Identificador del usuario 
data.eventos.usuario.nombreCompleto 
String 
Sí 
Nombre del usuario 
data.eventos.usuario.rol 
String 
Sí 
Rol del usuario 
data.eventos.usuario.email 
String 
No 
Correo del usuario 
data.eventos.oficina.codigo 
String 
No 
Código de la oficina 
data.eventos.oficina.nombre 
String 
No 
Nombre de la oficina 
data.eventos.detalles 
Object 
No 
Información 
adicional 
asociada al evento 
data.eventos.detalles.motivo 
String 
No 
Motivo del evento 
data.eventos.detalles.canalIngreso 
String 
No 
Canal de ingreso de la 
solicitud 
data.eventos.detalles.dispositivoId 
String 
No 
Identificador del dispositivo 
data.eventos.detalles.resultado 
String 
No 
Resultado asociado al evento 
data.eventos.detalles.scoreHuellas 
Number 
No 
Score 
de 
validación 
de 
huellas 
data.eventos.detalles.scoreRostro 
Number 
No 
Score de validación facial 
data.eventos.detalles.tiempoValidacio
n 
String 
No 
Tiempo 
que 
tomó 
la 
validación 
data.eventos.detalles.coincidenciasEn
contradas 
Integer 
No 
Cantidad de coincidencias 
encontradas 
data.eventos.detalles.estadoAnterior 
String 
No 
Estado previo del trámite 
data.eventos.detalles.estadoNuevo 
String 
No 
Estado actualizado 
data.eventos.detalles.algoritmo 
String 
No 
Algoritmo 
usado 
en 
la 
asignación 
data.eventos.detalles.cargaTrabajo.sol
icitudesPendientes 
Integer 
No 
Solicitudes en cola 

--- Página 34 ---
 
Microservicio MsDatosSolicitudes 
34 
data.eventos.detalles.cargaTrabajo.pr
omedioAtencion 
String 
No 
Tiempo promedio de atención 
data.eventos.detalles.usuarioAsignado
.usuarioId 
String 
No 
ID del usuario asignado 
data.eventos.detalles.usuarioAsignado
.nombreCompleto 
String 
No 
Nombre del asignado 
data.eventos.detalles.usuarioAsignado
.rol 
String 
No 
Rol del asignado 
data.eventos.detalles.prioridad 
String 
No 
Prioridad del evento 
data.eventos.detalles.sesionId 
String 
No 
ID de sesión 
data.eventos.detalles.camposModifica
dos 
Array 
No 
Lista de campos modificados 
data.eventos.detalles.camposModifica
dos.campo 
String 
No 
Campo modificado 
data.eventos.detalles.camposModifica
dos.valorAnterior 
String 
No 
Valor previo 
data.eventos.detalles.camposModifica
dos.valorNuevo 
String 
No 
Valor nuevo 
data.eventos.detalles.camposModifica
dos.justificacion 
String 
No 
Justificación del cambio 
data.eventos.detalles.requiereAprobac
ion 
Boolean 
No 
Si requiere aprobación 
data.eventos.detalles.documentoSopo
rte 
String 
No 
Documento relacionado 
data.eventos.detalles.comentario 
String 
No 
Comentario del evaluador 
data.eventos.detalles.visibilidad 
String 
No 
Nivel 
de 
visibilidad 
del 
comentario 
data.eventos.detalles.categoria 
String 
No 
Categoría del comentario 
data.eventos.detalles.diligenciaId 
String 
No 
ID de la diligencia 
data.eventos.detalles.numeroDiligenci
a 
String 
No 
Número de la diligencia 
data.eventos.detalles.entidadDestino 
String 
No 
Entidad a la que se envió la 
diligencia 
data.eventos.detalles.tipoConsulta 
String 
No 
Tipo de consulta 
data.eventos.detalles.plazoRespuesta 
String 
No 
Plazo de respuesta 
data.eventos.detalles.estado 
String 
No 
Estado de la diligencia 
data.eventos.detalles.canalNotificacion 
String 
No 
Medio de notificación 
data.eventos.detalles.destinatario 
String 
No 
Destinatario 
data.eventos.detalles.destinatarios 
Array[String] 
No 
Lista de destinatarios 
data.eventos.detalles.asunto 
String 
No 
Asunto de la notificación 
data.eventos.detalles.estadoEnvio 
String 
No 
Estado del envío 
data.eventos.detalles.plantilla 
String 
No 
Plantilla utilizada 

--- Página 35 ---
 
Microservicio MsDatosSolicitudes 
35 
data.eventos.detalles.respuesta 
String 
No 
Respuesta recibida 
data.eventos.detalles.domicilioFiscal 
String 
No 
Domicilio fiscal verificado 
data.eventos.detalles.coincidencia 
Boolean 
No 
Indica si coincidió 
data.eventos.detalles.documentoResp
uesta 
String 
No 
Documento de respuesta 
data.eventos.detalles.resolucion 
String 
No 
Resolución emitida 
data.eventos.detalles.tiempoTotalProc
eso 
String 
No 
Tiempo total del proceso 
data.eventos.detalles.proximoPaso 
String 
No 
Próximo paso del trámite 
data.eventos.detalles.mensaje 
String 
No 
Mensaje enviado 
data.eventos.metadatos 
Object 
No 
Metadatos del evento 
data.eventos.metadatos.ipOrigen 
String 
No 
IP de origen 
data.eventos.metadatos.navegador 
String 
No 
Navegador utilizado 
data.eventos.metadatos.sistemaOpera
tivo 
String 
No 
Sistema operativo 
data.eventos.metadatos.geolocalizacio
n.pais 
String 
No 
País detectado 
data.eventos.metadatos.geolocalizacio
n.departamento 
String 
No 
Departamento detectado 
data.eventos.metadatos.geolocalizacio
n.ciudad 
String 
No 
Ciudad detectada 
data.eventos.metadatos.servicioExtern
o 
String 
No 
Servicio externo usado 
data.eventos.metadatos.versionServici
o 
String 
No 
Versión del servicio 
data.eventos.metadatos.estacionTraba
jo 
String 
No 
Estación de trabajo 
data.resumenEventos.totalCambiosEst
ado 
Integer 
Sí 
Total de cambios de estado 
data.resumenEventos.totalModificacio
nes 
Integer 
Sí 
Total de modificaciones 
data.resumenEventos.totalAsignacion
es 
Integer 
Sí 
Total de asignaciones 
data.resumenEventos.totalDiligencias 
Integer 
Sí 
Total de diligencias 
data.resumenEventos.totalValidacione
s 
Integer 
Sí 
Total de validaciones 
data.resumenEventos.totalComentario
s 
Integer 
Sí 
Total de comentarios 
data.resumenEventos.totalNotificacion
es 
Integer 
Sí 
Total de notificaciones 
data.estadisticas.tiempoTotalProceso 
String 
Sí 
Tiempo total del proceso 
data.estadisticas.tiempoPorEtapa 
Object 
Sí 
Duración por etapa 

--- Página 36 ---
 
Microservicio MsDatosSolicitudes 
36 
data.estadisticas.usuariosInvolucrados 
Integer 
Sí 
Número 
de 
usuarios 
involucrados 
data.estadisticas.oficinasProceso 
Array[String] 
Sí 
Oficinas que intervinieron 
data.paginacion.totalRegistros 
Integer 
Sí 
Total de registros 
data.paginacion.totalPaginas 
Integer 
Sí 
Total de páginas 
data.paginacion.paginaActual 
Integer 
Sí 
Página actual 
data.paginacion.registrosPorPagina 
Integer 
Sí 
Número de registros por 
página 
data.paginacion.tieneAnterior 
Boolean 
Sí 
Indica si hay página anterior 
data.paginacion.tieneSiguiente 
Boolean 
Sí 
Indica si hay página siguiente 
metadata.timestamp 
String 
Sí 
Momento de respu 
3.1.8.3 Valores para el atributo statusCode 
Código Descripción 
Escenario 
200 
OK 
Historial de trazabilidad recuperado exitosamente 
400 
Bad Request 
Parámetros de consulta inválidos (fechas mal formateadas, limit fuera de 
rango) 
401 
Unauthorized 
Token JWT inválido, expirado o ausente 
403 
Forbidden 
Usuario sin permisos para consultar historial (rol insuficiente) 
404 
Not Found 
Solicitud no encontrada en el sistema 
429 
Too 
Many 
Requests 
Límite de rate limit excedido (>200 peticiones/minuto) 
500 
Internal 
Server 
Error 
Error interno del servidor (base de datos no disponible, servicio de 
auditoría caído) 
503 
Service 
Unavailable 
Servicio de auditoría temporalmente no disponible 
 
