# MsAdaptadorBCP - Arquitectura Hexagonal

## 📋 Información General

- **Nombre del Microservicio**: MsAdaptadorBCP
- **Versión API**: v1
- **Tipo de Microservicio**: MsDominio (Adaptador/Integración)
- **Paquete Base**: `pe.com.gse.adaptadorbcp`
- **Generado según**: Prompt AGENT_PROMPT_MEJORADO.md v3.0

## 🎯 Propósito

Microservicio adaptador para integración con servicios externos del BCP (Banco de Crédito del Perú). Actúa como capa de abstracción entre la arquitectura interna y los servicios del BCP.

## 🏗️ Arquitectura

### Tipo: MsDominio
- ✅ Define: Agregados, Casos de Uso, Servicios de Aplicación
- ✅ Puerto de salida: BCPDataPort
- ✅ Adaptador: BCPDataAdapter
- ❌ NO define: RepositoryPort ni Entities de persistencia
- 🎯 Propósito: Orquestar integración con sistema externo (BCP)

## 📁 Estructura del Proyecto

```
src/main/java/pe/com/gse/adaptadorbcp/
│
├── domain/                                 # Capa de Dominio
│   ├── model/                              # Modelos de dominio
│   │   ├── SolicitudBCP.java              # Aggregate Root: Solicitud hacia BCP
│   │   └── RespuestaBCP.java              # Aggregate Root: Respuesta del BCP
│   │
│   └── ports/                              # Puertos (interfaces)
│       ├── in/                             # Puertos de entrada (Use Cases)
│       │   └── ProcesarSolicitudUseCase.java
│       │
│       └── out/                            # Puertos de salida
│           └── BCPDataPort.java           # Puerto para comunicación con BCP
│
├── application/                            # Capa de Aplicación
│   └── service/                            # Servicios de aplicación
│       └── ProcesarSolicitudService.java  # Implementa ProcesarSolicitudUseCase
│
└── infrastructure/                         # Capa de Infraestructura
    └── adapters/                           # Adaptadores
        ├── in/                             # Adaptadores de entrada
        │   └── rest/                       # Adaptador REST
        │       ├── controller/
        │       │   └── AdaptadorBCPController.java
        │       ├── dto/
        │       │   ├── SolicitudBCPRequestDto.java
        │       │   └── RespuestaBCPResponseDto.java
        │       └── mapper/
        │           └── BCPDtoMapper.java
        │
        └── out/                            # Adaptadores de salida
            └── bcp/                        # Adaptador para comunicación con BCP
                └── BCPDataAdapter.java    # Implementa BCPDataPort
```

## 🔌 Endpoints Documentados

### POST /api/v1/adaptador/procesar
Procesa solicitudes hacia el BCP

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

## 🎭 Casos de Uso Implementados

| Caso de Uso | Endpoint | Archivo |
|-------------|----------|---------|
| Procesar Solicitud | POST /api/v1/adaptador/procesar | ProcesarSolicitudUseCase.java |

## 📊 Entidades del Dominio

### SolicitudBCP
Representa una solicitud hacia el BCP
- `tipoOperacion`: String - Tipo de operación a realizar
- `datos`: String - Datos de la solicitud

### RespuestaBCP
Representa la respuesta del BCP
- `codigo`: String - Código de respuesta
- `mensaje`: String - Mensaje descriptivo
- `datos`: String - Datos de respuesta

## 🔄 Flujo de Datos

```
[Cliente] 
   ↓
[AdaptadorBCPController] (REST Adapter - Entrada)
   ↓
[ProcesarSolicitudUseCase] (Puerto de Entrada)
   ↓
[ProcesarSolicitudService] (Servicio de Aplicación)
   ↓
[BCPDataPort] (Puerto de Salida)
   ↓
[BCPDataAdapter] (Adaptador - Salida)
   ↓
[Servicios BCP Externos]
```

## 🎯 Principios Aplicados

### ✅ Neutralidad Tecnológica TOTAL
- ❌ Sin frameworks (Spring, Jakarta EE, Quarkus)
- ❌ Sin anotaciones (@Entity, @RestController, @Autowired)
- ❌ Sin librerías externas (MapStruct, Lombok, Hibernate)
- ✅ Solo Java puro: interfaces, clases, POJOs

### ✅ Arquitectura Hexagonal Estricta
- ✅ Separación clara de capas (Domain, Application, Infrastructure)
- ✅ Dependencias apuntan hacia el dominio
- ✅ Dominio independiente de infraestructura
- ✅ Puertos e interfaces definen contratos

### ✅ Fidelidad a la Especificación
- ✅ Solo endpoints documentados en el PDF
- ✅ Tipos de datos según especificación
- ✅ Sin asumir funcionalidades no documentadas

## 🚧 Estado de Implementación

### Completado ✅
- [x] Estructura de carpetas hexagonal
- [x] Entidades del dominio (SolicitudBCP, RespuestaBCP)
- [x] Puerto de entrada: ProcesarSolicitudUseCase
- [x] Puerto de salida: BCPDataPort
- [x] Servicio de aplicación: ProcesarSolicitudService
- [x] Controller REST: AdaptadorBCPController
- [x] DTOs (Request/Response)
- [x] Mapper: BCPDtoMapper
- [x] Adaptador de salida: BCPDataAdapter

### Pendiente 🚧
- [ ] Implementación de lógica de negocio real
- [ ] Conexión efectiva con servicios BCP
- [ ] Validaciones de entrada
- [ ] Manejo de errores y excepciones
- [ ] Tests unitarios
- [ ] Configuración de frameworks (cuando se elija tecnología)

## 📝 Notas de Implementación

### Implementaciones Stub
Todas las clases están generadas con implementaciones stub que lanzan `UnsupportedOperationException`. Esto permite:
- ✅ Código compilable
- ✅ Estructura completa
- ✅ Contratos definidos
- ⏳ Lógica de negocio pendiente

### Ejemplo de Método Stub
```java
@Override
public RespuestaBCP procesar(SolicitudBCP solicitud) {
    throw new UnsupportedOperationException("Implementación pendiente");
}
```

## 🔍 Convenciones Aplicadas

### Nomenclatura de Puertos
- **MsDominio** → `{Entidad}DataPort` ✅ (BCPDataPort)

### Nomenclatura de Adaptadores
- **MsDominio** → `{Entidad}DataAdapter` ✅ (BCPDataAdapter)

### Métodos en Controllers
- `procesar()` → POST /api/v1/adaptador/procesar

## 📚 Documentación de Referencia

- Especificación Original: `p_Microservicio MsAdaptadorBCP V1.2.pdf`
- Especificación Extraída: `ESPECIFICACION_EXTRAIDA.md`
- Prompt de Generación: `AGENT_PROMPT_MEJORADO.md` v3.0

## 🔧 Próximos Pasos

1. **Elegir Stack Tecnológico** (Spring Boot, Quarkus, Jakarta EE, etc.)
2. **Añadir Dependencias** en pom.xml o build.gradle
3. **Implementar Lógica de Negocio** en servicios
4. **Configurar Cliente HTTP** para comunicación con BCP
5. **Añadir Validaciones** en DTOs y servicios
6. **Implementar Manejo de Errores**
7. **Escribir Tests** unitarios e integración
8. **Configurar Properties** (URLs, timeouts, credenciales)
9. **Añadir Logging**
10. **Documentar API** (OpenAPI/Swagger cuando se agregue framework)

## ⚙️ Compilación

El código Java puro generado es compilable con JDK 11+:

```bash
# Compilar (sin framework aún)
javac -d target/classes src/main/java/pe/com/gse/adaptadorbcp/**/*.java
```

## 📄 Licencia

[Definir según organización]

---

**Fecha de Generación**: 2025-12-05  
**Generado por**: GitHub Copilot con Claude Sonnet 4.5  
**Basado en**: AGENT_PROMPT_MEJORADO.md v3.0
