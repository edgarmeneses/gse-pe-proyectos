# Modelo de Dominio Refactorizado - MsDatosSolicitudes

## 📋 Resumen de Cambios

Se ha refactorizado el modelo de dominio para cumplir con **Arquitectura Hexagonal** y **Domain-Driven Design (DDD)**, eliminando conceptos de infraestructura y presentación que estaban mezclados con el dominio.

---

## ✅ Estructura del Dominio Limpio

### 📦 `domain/model/` - Entidades y Value Objects

#### **Aggregate Roots** (Entidades principales con identidad)

1. **`Solicitud`** - Solicitud de trámite
   - ✅ Eliminados campos de presentación: `urlSeguimiento`, `codigoQR`, `diasTranscurridos`, `diasRestantes`, `siguientesPasos`
   - ✅ Añadidos métodos de negocio: `estaVencida()`, `estaPendiente()`, `cambiarEstado()`, `asignarUsuario()`
   - ✅ Colecciones inmutables con métodos para agregar elementos
   - ✅ Agregado campo `documentosAdjuntos` (estaba faltando)

2. **`Diligencia`** - Diligencia o gestión externa
   - ✅ Eliminados campos calculados: `diasTranscurridos`, `diasRestantes`
   - ✅ Eliminados campos de infraestructura: `oficinaResponsableSeguimiento`, `seguimiento`, `eventosPublicados`
   - ✅ Añadidos métodos de negocio: `estaVencida()`, `estaPendiente()`, `cambiarEstado()`, `marcarOficioEnviado()`, `marcarOficioRespondido()`
   - ✅ Colecciones inmutables

3. **`Trazabilidad`** - Historial de eventos de una solicitud
   - ✅ Eliminados: `Paginacion`, `Estadisticas`, `ResumenEventos`, `totalEventos` (campo redundante)
   - ✅ Solo contiene eventos del dominio
   - ✅ Métodos de negocio: `getTotalEventos()`, `obtenerEventosPorTipo()`, `obtenerUltimoEvento()`, `agregarEvento()`

#### **Entities** (Entidades con identidad dentro de aggregates)

4. **`Evento`** - Evento en el historial de una solicitud
   - ✅ Mantiene información de cambios de estado y acciones

#### **Value Objects** (Objetos sin identidad, inmutables)

5. **`Solicitante`** - Persona que realiza la solicitud
6. **`Direccion`** - Dirección postal
7. **`Pago`** - Información de pago
8. **`DocumentoAdjunto`** - Documento adjunto a la solicitud
9. **`RequisitoCumplido`** - Requisito completado
10. **`DatosEspecificosTramite`** - Datos específicos del tipo de trámite
11. **`DocumentoRequerido`** - Documento requerido para diligencia
12. **`DocumentoGenerado`** - Documento generado por el sistema
13. **`DatosContactoEntidad`** - Datos de contacto de entidad externa
14. **`OficinaRegistro`** - Oficina que registra la solicitud
15. **`OficinaResponsable`** - Oficina responsable de una diligencia
16. **`Usuario`** - Información de usuario del sistema
17. **`Oficina`** - Información de oficina

---

## 🗑️ Clases Eliminadas del Dominio

| Clase | Razón de eliminación | Nueva ubicación |
|-------|---------------------|-----------------|
| `Paginacion` | Concepto de infraestructura (API REST) | Ya existe `PaginacionDto` |
| `Estadisticas` | Datos calculados para respuesta | Ya existe `EstadisticasDto` |
| `ResumenEventos` | Agregado calculado para respuesta | Ya existe `ResumenEventosDto` |
| `SiguientePaso` | Metadata de presentación/UI | Ya existe `SiguientePasoDto` |
| `Seguimiento` | No es concepto de negocio core | Removido (configuración) |

---

## 📊 Nueva Capa de Aplicación

### 📦 `application/query/` - Query Results

Se crearon objetos para envolver resultados de consultas con metadata:

1. **`SolicitudQueryResult`**
   - Contiene: `List<Solicitud>` + datos de paginación
   - Usado por: `ListarSolicitudesUseCase`

2. **`TrazabilidadQueryResult`**
   - Contiene: `Trazabilidad` + estadísticas + resumen de eventos + paginación
   - Usado por: `VerTrazabilidadUseCase`

---

## 🔄 Puertos Actualizados

### **Puertos de Entrada (Use Cases)**

- ✅ `ListarSolicitudesUseCase` → retorna `SolicitudQueryResult`
- ✅ `VerTrazabilidadUseCase` → retorna `TrazabilidadQueryResult`
- ✅ `CrearSolicitudUseCase` → retorna `Solicitud` (dominio puro)
- ✅ `ConsultarSolicitudUseCase` → retorna `Solicitud` (dominio puro)
- ✅ `ActualizarSolicitudUseCase` → retorna `Solicitud` (dominio puro)
- ✅ `CrearDiligenciaUseCase` → retorna `Diligencia` (dominio puro)
- ✅ `VerificarDuplicadosUseCase` → retorna `Boolean`

### **Puertos de Salida (Repository Ports)**

- ✅ `SolicitudRepositoryPort.listar()` → retorna `SolicitudQueryResult`
- ✅ `TrazabilidadRepositoryPort.buscarPorSolicitudId()` → retorna `TrazabilidadQueryResult`
- ✅ Otros métodos retornan entidades de dominio puras

---

## 📐 Principios Aplicados

### ✅ Arquitectura Hexagonal
- **Dominio**: Sin dependencias de infraestructura
- **Puertos**: Interfaces que definen contratos
- **Adaptadores**: Se encargarán de transformar entre dominio y DTOs

### ✅ Domain-Driven Design (DDD)
- **Aggregates**: `Solicitud`, `Diligencia`, `Trazabilidad` con invariantes y comportamiento
- **Value Objects**: Objetos inmutables sin identidad
- **Entities**: Con identidad única
- **Métodos de dominio**: Lógica de negocio encapsulada en las entidades

### ✅ Separation of Concerns
- **Dominio**: Solo conceptos de negocio
- **Aplicación**: Coordinación y query results
- **Infraestructura**: DTOs, mappers, persistencia

---

## 🎯 Próximos Pasos (Recomendados)

1. **Validar Value Objects**
   - Hacer inmutables los Value Objects (constructores con validación)
   - Añadir validaciones de negocio

2. **Actualizar Adaptadores**
   - Ajustar mappers de DTOs para trabajar con el nuevo modelo
   - Actualizar adapters de persistencia

3. **Implementar Domain Events**
   - Para comunicación entre aggregates
   - Publicar eventos cuando cambia el estado

4. **Añadir Factory Methods**
   - Para creación de aggregates con validaciones

---

## 📚 Referencias

- **Arquitectura Hexagonal**: Alistair Cockburn
- **Domain-Driven Design**: Eric Evans
- **Clean Architecture**: Robert C. Martin
