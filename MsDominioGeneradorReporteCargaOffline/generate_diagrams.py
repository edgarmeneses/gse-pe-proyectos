#!/usr/bin/env python3
"""
Script para generar imágenes PNG de los diagramas Mermaid
Usa la API pública de Kroki (https://kroki.io)
"""

import base64
import zlib
import requests
from pathlib import Path

def encode_diagram(diagram_text):
    """Codifica el diagrama Mermaid en formato compatible con Kroki"""
    compressed = zlib.compress(diagram_text.encode('utf-8'), level=9)
    encoded = base64.urlsafe_b64encode(compressed).decode('utf-8')
    return encoded

def generate_image(diagram_text, output_file, diagram_type='mermaid', format='png'):
    """Genera una imagen PNG del diagrama usando Kroki API"""
    encoded = encode_diagram(diagram_text)
    url = f"https://kroki.io/{diagram_type}/{format}/{encoded}"

    print(f"Generando {output_file}...")
    try:
        response = requests.get(url, timeout=30)
        response.raise_for_status()

        with open(output_file, 'wb') as f:
            f.write(response.content)
        print(f"[OK] Generado: {output_file}")
        return True
    except Exception as e:
        print(f"[ERROR] Error generando {output_file}: {e}")
        return False

# Diagrama 1: Diagrama Completo de Clases
diagram1 = """classDiagram
    %% ============================================================
    %% CAPA DE DOMINIO - Domain Layer (Núcleo del negocio)
    %% ============================================================

    namespace Domain_Model {
        class ReporteCarga {
            -String idReporteCargue
            -Integer cantidadTramitesTransferido
            -List~String~ logTramitre
            -EstadoReporte estadoReporte
            -Metadata metadata
            -String reporteBase64
            -String urlReporteRepositorio
            +ReporteCarga()
            +getters()
            +setters()
        }

        class ReporteCargaPendiente {
            -String idReportePendiente
            -Integer cantidadTramitesGestionados
            -EstadoReporte estadoReporte
            -Metadata metadata
            -String reporteBase64
            -String urlReporteRepositorio
            +ReporteCargaPendiente()
            +getters()
            +setters()
        }

        class EstadoReporte {
            <<Value Object>>
            -String tipo
            -List~String~ valor
            +EstadoReporte()
            +getters()
            +setters()
        }

        class Metadata {
            <<Value Object>>
            -LocalDateTime timestamp
            -String correlationId
            -String version
            +Metadata()
            +getters()
            +setters()
        }
    }

    namespace Domain_Ports_In {
        class GenerarReporteUseCase {
            <<interface>>
            +generar(String idCargueTramite) ReporteCarga
        }

        class GenerarReporteSolicitudesPendientesUseCase {
            <<interface>>
            +generar(String itineranteId) ReporteCargaPendiente
        }
    }

    namespace Domain_Ports_Out {
        class ReporteCargaDataPort {
            <<interface>>
            +guardar(ReporteCarga) ReporteCarga
            +buscarPorId(String) ReporteCarga
            +buscarPorIdCargueTramite(String) ReporteCarga
        }

        class ReporteCargaPendienteDataPort {
            <<interface>>
            +guardar(ReporteCargaPendiente) ReporteCargaPendiente
            +buscarPorId(String) ReporteCargaPendiente
            +buscarPorItineranteId(String) ReporteCargaPendiente
        }
    }

    namespace Application_Service {
        class GenerarReporteService {
            -ReporteCargaDataPort reporteCargaDataPort
            +GenerarReporteService(ReporteCargaDataPort)
            +generar(String idCargueTramite) ReporteCarga
        }

        class GenerarReporteSolicitudesPendientesService {
            -ReporteCargaPendienteDataPort reporteCargaPendienteDataPort
            +GenerarReporteSolicitudesPendientesService(ReporteCargaPendienteDataPort)
            +generar(String itineranteId) ReporteCargaPendiente
        }
    }

    namespace Infrastructure_Controller {
        class GeneradorReporteCargaOfflineController {
            <<POJO>>
            -GenerarReporteUseCase generarReporteUseCase
            -GenerarReporteSolicitudesPendientesUseCase generarReporteSolicitudesPendientesUseCase
            +GeneradorReporteCargaOfflineController(...)
            +generarReporte(ReporteCargaRequestDto) ReporteCargaResponseDto
            +generarReporteSolicitudesPendientes(...) ReporteCargaPendienteResponseDto
        }
    }

    namespace Infrastructure_Mappers {
        class ReporteCargaDtoMapper {
            +toDto(ReporteCarga) ReporteCargaResponseDto
            +toDomain(ReporteCargaResponseDto) ReporteCarga
        }

        class ReporteCargaPendienteDtoMapper {
            +toDto(ReporteCargaPendiente) ReporteCargaPendienteResponseDto
            +toDomain(ReporteCargaPendienteResponseDto) ReporteCargaPendiente
        }
    }

    namespace Infrastructure_Adapters_Out {
        class ReporteCargaDataAdapter {
            +guardar(ReporteCarga) ReporteCarga
            +buscarPorId(String) ReporteCarga
            +buscarPorIdCargueTramite(String) ReporteCarga
        }

        class ReporteCargaPendienteDataAdapter {
            +guardar(ReporteCargaPendiente) ReporteCargaPendiente
            +buscarPorId(String) ReporteCargaPendiente
            +buscarPorItineranteId(String) ReporteCargaPendiente
        }
    }

    %% Relaciones
    ReporteCarga *-- EstadoReporte
    ReporteCarga *-- Metadata
    ReporteCargaPendiente *-- EstadoReporte
    ReporteCargaPendiente *-- Metadata

    GenerarReporteService ..|> GenerarReporteUseCase
    GenerarReporteSolicitudesPendientesService ..|> GenerarReporteSolicitudesPendientesUseCase

    ReporteCargaDataAdapter ..|> ReporteCargaDataPort
    ReporteCargaPendienteDataAdapter ..|> ReporteCargaPendienteDataPort

    GenerarReporteService --> ReporteCargaDataPort
    GenerarReporteSolicitudesPendientesService --> ReporteCargaPendienteDataPort

    GenerarReporteService ..> ReporteCarga
    GenerarReporteSolicitudesPendientesService ..> ReporteCargaPendiente

    GeneradorReporteCargaOfflineController --> GenerarReporteUseCase
    GeneradorReporteCargaOfflineController --> GenerarReporteSolicitudesPendientesUseCase

    ReporteCargaDtoMapper ..> ReporteCarga
    ReporteCargaPendienteDtoMapper ..> ReporteCargaPendiente

    ReporteCargaDataAdapter ..> ReporteCarga
    ReporteCargaPendienteDataAdapter ..> ReporteCargaPendiente
"""

# Diagrama 2: Flujo de Arquitectura Hexagonal
diagram2 = """graph TB
    subgraph "INFRASTRUCTURE - Adapters IN"
        Controller[GeneradorReporteCargaOfflineController<br/>POJO sin anotaciones]
        DTOs[DTOs: Request/Response]
        Mappers[Mappers: Domain ↔ DTO]
    end

    subgraph "APPLICATION - Services"
        Service1[GenerarReporteService]
        Service2[GenerarReporteSolicitudesPendientesService]
    end

    subgraph "DOMAIN - Core Business"
        subgraph "Ports IN - UseCases"
            UC1[GenerarReporteUseCase]
            UC2[GenerarReporteSolicitudesPendientesUseCase]
        end

        subgraph "Model - Aggregates"
            Model1[ReporteCarga]
            Model2[ReporteCargaPendiente]
            VO1[EstadoReporte]
            VO2[Metadata]
        end

        subgraph "Ports OUT - DataPorts"
            Port1[ReporteCargaDataPort]
            Port2[ReporteCargaPendienteDataPort]
        end
    end

    subgraph "INFRASTRUCTURE - Adapters OUT"
        Adapter1[ReporteCargaDataAdapter]
        Adapter2[ReporteCargaPendienteDataAdapter]
    end

    subgraph "EXTERNAL - MsData"
        MsData[(MsData<br/>Microservicio de Datos)]
    end

    Controller -->|usa| UC1
    Controller -->|usa| UC2
    Controller -->|recibe/retorna| DTOs
    Mappers -->|convierte| Model1
    Mappers -->|convierte| Model2

    UC1 -.->|implementa| Service1
    UC2 -.->|implementa| Service2

    Service1 -->|usa| Port1
    Service2 -->|usa| Port2
    Service1 -->|crea| Model1
    Service2 -->|crea| Model2

    Model1 -->|contiene| VO1
    Model1 -->|contiene| VO2
    Model2 -->|contiene| VO1
    Model2 -->|contiene| VO2

    Port1 -.->|implementa| Adapter1
    Port2 -.->|implementa| Adapter2

    Adapter1 -->|integra con| MsData
    Adapter2 -->|integra con| MsData

    style Controller fill:#bbdefb
    style Service1 fill:#c8e6c9
    style Service2 fill:#c8e6c9
    style UC1 fill:#fff9c4
    style UC2 fill:#fff9c4
    style Model1 fill:#ffccbc
    style Model2 fill:#ffccbc
    style Port1 fill:#f8bbd0
    style Port2 fill:#f8bbd0
    style Adapter1 fill:#d1c4e9
    style Adapter2 fill:#d1c4e9
    style MsData fill:#cfd8dc
"""

# Diagrama 3: Vista de Dependencias
diagram3 = """graph LR
    subgraph "CAPA 1: Infrastructure IN"
        A1[Controller]
        A2[DTOs]
        A3[Mappers]
    end

    subgraph "CAPA 2: Application"
        B1[Services]
    end

    subgraph "CAPA 3: Domain - CORE"
        C1[Ports IN]
        C2[Model]
        C3[Ports OUT]
    end

    subgraph "CAPA 4: Infrastructure OUT"
        D1[Adapters OUT]
    end

    A1 -->|depende de| C1
    A2 -->|independiente| C2
    A3 -->|depende de| C2
    B1 -->|implementa| C1
    B1 -->|depende de| C3
    B1 -->|usa| C2
    D1 -->|implementa| C3
    D1 -->|usa| C2

    style C1 fill:#ffd54f
    style C2 fill:#ffd54f
    style C3 fill:#ffd54f
"""

if __name__ == "__main__":
    print("=" * 60)
    print("Generador de Diagramas - MsDominioGeneradorReporteCargaOffline")
    print("=" * 60)
    print()

    output_dir = Path(__file__).parent / "diagramas"
    output_dir.mkdir(exist_ok=True)

    diagrams = [
        (diagram1, output_dir / "01_diagrama_clases_completo.png"),
        (diagram2, output_dir / "02_flujo_arquitectura_hexagonal.png"),
        (diagram3, output_dir / "03_vista_dependencias.png"),
    ]

    results = []
    for diagram, output_file in diagrams:
        success = generate_image(diagram, output_file)
        results.append(success)

    print()
    print("=" * 60)
    if all(results):
        print("[OK] Todos los diagramas se generaron exitosamente!")
        print(f"[OK] Ubicacion: {output_dir}")
    else:
        print("[WARNING] Algunos diagramas no se pudieron generar")
    print("=" * 60)
