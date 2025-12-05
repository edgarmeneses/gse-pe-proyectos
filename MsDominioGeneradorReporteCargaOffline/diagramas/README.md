# Diagramas de Arquitectura - MsDominioGeneradorReporteCargaOffline

Esta carpeta contiene los diagramas de clases en formato PNG de la arquitectura hexagonal implementada.

## 📊 Archivos Generados

### 1. `01_diagrama_clases_completo.png`
**Diagrama de Clases Completo**

Muestra todas las clases del proyecto organizadas por capas y namespaces:

- **Domain Model (4 clases)**:
  - `ReporteCarga` - Aggregate Root
  - `ReporteCargaPendiente` - Aggregate Root
  - `EstadoReporte` - Value Object
  - `Metadata` - Value Object

- **Domain Ports IN (2 interfaces)**:
  - `GenerarReporteUseCase`
  - `GenerarReporteSolicitudesPendientesUseCase`

- **Domain Ports OUT (2 interfaces)**:
  - `ReporteCargaDataPort`
  - `ReporteCargaPendienteDataPort`

- **Application Services (2 clases)**:
  - `GenerarReporteService`
  - `GenerarReporteSolicitudesPendientesService`

- **Infrastructure - Adapters IN**:
  - `GeneradorReporteCargaOfflineController` (Controller)
  - `ReporteCargaDtoMapper` (Mapper)
  - `ReporteCargaPendienteDtoMapper` (Mapper)

- **Infrastructure - Adapters OUT (2 clases)**:
  - `ReporteCargaDataAdapter`
  - `ReporteCargaPendienteDataAdapter`

**Relaciones mostradas**:
- Composición entre Aggregates y Value Objects
- Implementación de interfaces (Ports)
- Dependencias entre capas
- Uso de Domain Model por Services y Adapters

---

### 2. `02_flujo_arquitectura_hexagonal.png`
**Flujo de Arquitectura Hexagonal**

Vista simplificada que ilustra el flujo de datos:

1. **Infrastructure - Adapters IN** (azul claro):
   - Controller recibe requests HTTP
   - DTOs transfieren datos
   - Mappers convierten DTO ↔ Domain

2. **Application - Services** (verde claro):
   - Implementan lógica de negocio
   - Orquestan operaciones

3. **Domain - Core Business** (amarillo/naranja/rosa):
   - **Ports IN**: Casos de uso (interfaces)
   - **Model**: Aggregates y Value Objects
   - **Ports OUT**: Contratos de integración

4. **Infrastructure - Adapters OUT** (morado):
   - DataAdapters implementan integración

5. **External - MsData** (gris):
   - Microservicio externo de datos

**Características destacadas**:
- Flujo unidireccional: Controller → UseCase → Service → DataPort → Adapter → MsData
- Inversión de dependencias (Dependency Inversion Principle)
- Separación clara entre lógica de negocio e infraestructura

---

### 3. `03_vista_dependencias.png`
**Vista de Dependencias por Capa**

Diagrama que muestra la dirección de las dependencias entre las 4 capas:

- **Capa 1: Infrastructure IN** (Controller, DTOs, Mappers)
- **Capa 2: Application** (Services)
- **Capa 3: Domain - CORE** ⭐ (Ports IN, Model, Ports OUT)
- **Capa 4: Infrastructure OUT** (Adapters)

**Principio clave**: Todas las dependencias apuntan hacia el **Domain (Core)**.

**Reglas de dependencia**:
- ✅ Infrastructure → Domain (permitido)
- ✅ Application → Domain (permitido)
- ❌ Domain → Infrastructure (prohibido)
- ❌ Domain → Application (prohibido)

Esto garantiza que el núcleo del negocio (Domain) sea:
- Independiente de frameworks
- Independiente de tecnologías
- Testeable de forma aislada
- Agnóstico de protocolos de comunicación

---

## 🎨 Convenciones de Color

- **Azul claro** (`#bbdefb`): Controllers / Infrastructure IN
- **Verde claro** (`#c8e6c9`): Services / Application
- **Amarillo** (`#fff9c4`): Ports IN / UseCases
- **Naranja claro** (`#ffccbc`): Domain Model / Aggregates
- **Rosa claro** (`#f8bbd0`): Ports OUT / DataPorts
- **Morado claro** (`#d1c4e9`): Adapters OUT / Infrastructure OUT
- **Gris** (`#cfd8dc`): Sistemas externos (MsData)

---

## 🔧 Regenerar Diagramas

Para regenerar los diagramas, ejecuta:

```bash
python generate_diagrams.py
```

**Requisitos**:
- Python 3.8+
- Librería `requests` (`pip install requests`)

El script usa la API pública de [Kroki](https://kroki.io) para renderizar diagramas Mermaid a PNG.

---

## 📝 Notas Técnicas

- **Formato**: PNG (alta resolución)
- **Renderizado**: Kroki API (https://kroki.io)
- **Sintaxis**: Mermaid (classDiagram, graph)
- **Generado**: 2025-12-04
- **Arquitectura**: Hexagonal estricta
- **Tipo**: MsDominio (con DataPorts)

---

## 📚 Referencias

- [Arquitectura Hexagonal - Alistair Cockburn](https://alistair.cockburn.us/hexagonal-architecture/)
- [Domain-Driven Design - Eric Evans](https://www.domainlanguage.com/ddd/)
- [Mermaid Documentation](https://mermaid.js.org/)
- [Kroki - Diagrams as Code](https://kroki.io/)
