# Especificación Extraída - MsAdaptadorBCP v1.2

## Información General
- **Nombre del Microservicio**: MsAdaptadorBCP
- **Versión API**: v1
- **Tipo**: MsDominio (Adaptador/Integración)
- **Contexto**: Microservicio adaptador para integración con servicios del BCP

## Paquete Base
`pe.com.gse.adaptadorbcp`

## Endpoints Identificados

### 1. POST /api/v1/adaptador/procesar
**Propósito**: Procesar solicitudes hacia BCP

**Request**:
```json
{
  "tipoOperacion": "string",
  "datos": "string"
}
```

**Response**: 200 OK
```json
{
  "codigo": "string",
  "mensaje": "string",
  "datos": "string"
}
```

## Entidades del Dominio

### SolicitudBCP
Representa una solicitud hacia el BCP
- `tipoOperacion`: String - Tipo de operación a realizar
- `datos`: String - Datos de la solicitud

### RespuestaBCP
Representa la respuesta del BCP
- `codigo`: String - Código de respuesta
- `mensaje`: String - Mensaje descriptivo
- `datos`: String - Datos de respuesta

## Casos de Uso a Generar
Basándome en el endpoint documentado:
1. ProcesarSolicitudUseCase - Para POST /api/v1/adaptador/procesar

## Tipo de Microservicio Determinado
**MsDominio** porque:
- Es un adaptador/integración (no gestiona persistencia directa)
- Orquesta comunicación con sistema externo (BCP)
- Define DataPort hacia servicios externos

## Puertos de Salida
- `BCPDataPort` - Para comunicación con servicios BCP

## Notas
- Microservicio de integración, no maneja persistencia propia
- Actúa como adaptador entre la arquitectura interna y servicios BCP externos
