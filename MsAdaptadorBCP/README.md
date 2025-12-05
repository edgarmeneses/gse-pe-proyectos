# MsAdaptadorBCP – Arquitectura Hexagonal (Neutralidad Tecnológica)

Estado: Estructura base generada según `AGENT_PROMPT_MEJORADO.md`.

## Contexto y tipo de microservicio
- Nombre detectado: `MsAdaptadorBCP`.
- Tipo: Ambiguo. Asumido temporalmente como `MsData` (caso más simple) según sección 11, Situación 3.
- Paquete base: `pe.gse.adaptadorbcp`.

## Estructura generada
Conforme a la sección 7:
- `domain/model/EntidadPlaceholder.java`
- `domain/ports/in/*UseCase.java` (CRUD)
- `domain/ports/out/EntidadRepositoryPort.java`
- `application/service/*Service.java` (stubs compilables)
- `infrastructure/adapters/in/rest/controller/EntidadController.java`
- `infrastructure/adapters/in/rest/dto/*Dto.java`
- `infrastructure/adapters/in/rest/mapper/EntidadDtoMapper.java`

## Trazabilidad a la especificación (PDF)
El archivo `p_Microservicio MsAdaptadorBCP V1.2.pdf` no está totalmente procesado aquí. Para mantener la fidelidad:
- No se han definido endpoints específicos ni estructuras de request/response.
- Se creó un `EntidadPlaceholder` y DTOs mínimos con comentarios "Estructura no especificada".

## ⚠️ Ambigüedades detectadas
- Tipo de microservicio (MsDominio vs MsData): Ambiguo; asumido MsData temporalmente.
- Endpoints: No extraídos; pendientes de definición exacta.
- Entidades y tipos de datos: No especificados; pendientes.

## Próximos pasos
1. Extraer del PDF: versión API, endpoints, entidades y tipos.
2. Reemplazar `EntidadPlaceholder` por entidades reales.
3. Ajustar puertos de salida: `DataPort` si es `MsDominio`, `RepositoryPort` si es `MsData`.
4. Crear adaptadores correspondientes (`RepositoryAdapter` o `DataAdapter`).

## Reglas cumplidas
- Neutralidad: Sin frameworks, anotaciones ni librerías externas.
- Clases compilables: Constructores/getters/setters; métodos como `throw new UnsupportedOperationException`.
- Convenciones: Paquete base y nombres según guía.
