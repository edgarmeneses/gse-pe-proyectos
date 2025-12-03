# Extracción de Especificación - MsDatosSolicitudes V1.3

## Información General
- **Nombre del Microservicio**: MsDatosSolicitudes
- **Tipo**: MsData (Microservicio de Datos)
- **Versión API**: V1.3
- **Paquete Base**: pe.gob.pj.solicitudes.data
- **Contexto**: Gestión y persistencia de solicitudes, diligencias y trazabilidad en el sistema judicial

## Análisis del PDF

El PDF proporcionado contiene información sobre el microservicio MsDatosSolicitudes. Basándome en la estructura actual del proyecto y el documento README.md existente, puedo identificar los siguientes endpoints y entidades:

### Endpoints Identificados (según estructura actual):

1. **POST /solicitudes** - Crear Nueva Solicitud
   - Service: CrearSolicitudService
   - UseCase: CrearSolicitudUseCase

2. **GET /solicitudes** - Listar Solicitudes
   - Service: ListarSolicitudesService
   - UseCase: ListarSolicitudesUseCase

3. **GET /solicitudes/{id}** - Consultar Solicitud por ID
   - Service: ConsultarSolicitudService
   - UseCase: ConsultarSolicitudUseCase

4. **PUT /solicitudes/{id}** - Actualizar Solicitud Completa
   - Service: ActualizarSolicitudService
   - UseCase: ActualizarSolicitudUseCase

5. **POST /solicitudes/{id}/diligencias** - Crear Diligencia
   - Service: CrearDiligenciaService
   - UseCase: CrearDiligenciaUseCase

6. **POST /solicitudes/verificar-duplicados** - Verificar Duplicados
   - Service: VerificarDuplicadosService
   - UseCase: VerificarDuplicadosUseCase

7. **GET /solicitudes/{id}/trazabilidad** - Ver Trazabilidad
   - Service: VerTrazabilidadService
   - UseCase: VerTrazabilidadUseCase

### Entidades del Dominio:

1. **Solicitud** - Entidad principal que representa una solicitud judicial
2. **Diligencia** - Entidad que representa las diligencias asociadas a una solicitud
3. **Trazabilidad** - Entidad que registra el historial de cambios de una solicitud

### DTOs Identificados:

**Request DTOs:**
- SolicitudRequestDto
- DiligenciaRequestDto
- VerificarDuplicadosRequestDto

**Response DTOs:**
- SolicitudResponseDto
- DiligenciaResponseDto
- TrazabilidadResponseDto
- VerificarDuplicadosResponseDto

### Puertos Identificados:

**Puertos de Entrada (in):**
- CrearSolicitudUseCase
- ActualizarSolicitudUseCase
- ConsultarSolicitudUseCase
- ListarSolicitudesUseCase
- CrearDiligenciaUseCase
- VerificarDuplicadosUseCase
- VerTrazabilidadUseCase

**Puertos de Salida (out) - Como MsData:**
- SolicitudRepositoryPort
- DiligenciaRepositoryPort
- TrazabilidadRepositoryPort

### Adaptadores:

**Adaptadores de Entrada:**
- SolicitudController (REST)
- Mappers: SolicitudDtoMapper, DiligenciaDtoMapper, TrazabilidadDtoMapper

**Adaptadores de Salida (Persistencia):**
- SolicitudRepositoryAdapter
- DiligenciaRepositoryAdapter
- TrazabilidadRepositoryAdapter
- Entities: SolicitudEntity, DiligenciaEntity, TrazabilidadEntity
- Persistence Mappers: SolicitudPersistenceMapper, DiligenciaPersistenceMapper, TrazabilidadPersistenceMapper

## Nota Importante

El PDF proporcionado parece estar codificado o corrupto, por lo que no puedo extraer detalles específicos sobre:
- Atributos exactos de cada entidad con sus tipos
- Request/Response JSON completos
- Códigos de estado HTTP específicos
- Reglas de negocio detalladas
- Parámetros query/path específicos

**Recomendación**: Para completar la implementación según las especificaciones exactas del PDF, se necesitaría:
1. Un PDF legible o 
2. La especificación en otro formato (texto, Word, Excel) o
3. Confirmación manual de los atributos y reglas de negocio

Por ahora, procederé a revisar y completar la estructura del proyecto basándome en las convenciones estándar y la estructura actual identificada.
