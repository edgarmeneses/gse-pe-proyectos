package pe.gob.reniec.hechosVitales.infrastructure.adapters.in.rest.controller;

import pe.gob.reniec.hechosVitales.domain.model.CriterioBusqueda;
import pe.gob.reniec.hechosVitales.domain.ports.in.ConsultarCertificadoNacidoVivoUseCase;
import pe.gob.reniec.hechosVitales.infrastructure.adapters.in.rest.dto.CertificadoResponseDto;
import pe.gob.reniec.hechosVitales.infrastructure.adapters.in.rest.mapper.CertificadoDtoMapper;

/**
 * Controlador REST: CertificadoNacidoVivoController
 * 
 * Expone el endpoint GET para consultar certificados de nacido vivo.
 * Maneja la comunicación HTTP y delega al caso de uso.
 */
public class CertificadoNacidoVivoController {
    
    private final ConsultarCertificadoNacidoVivoUseCase consultarUseCase;
    private final CertificadoDtoMapper mapper;
    
    public CertificadoNacidoVivoController(
            ConsultarCertificadoNacidoVivoUseCase consultarUseCase,
            CertificadoDtoMapper mapper) {
        this.consultarUseCase = consultarUseCase;
        this.mapper = mapper;
    }
    
    /**
     * GET /api/v1/hechosVitales/MsAdaptadorCertificadoNacidoVivo/certificado-nacido-vivo
     * 
     * @param coEntidad Código de entidad (11 caracteres)
     * @param nuCnv Número de CNV (8-10 caracteres)
     * @param tipoDoc Tipo de documento (1 carácter)
     * @param correlationId X-Correlation-ID header
     * @return CertificadoResponseDto con los datos del certificado
     */
    public CertificadoResponseDto obtenerCertificado(
            String coEntidad,
            String nuCnv,
            String tipoDoc) {
        
        // Construcción de criterios de búsqueda (Value Object valida reglas de negocio)
        CriterioBusqueda criterio = new CriterioBusqueda(coEntidad, nuCnv, tipoDoc);
        
        // Invocación al caso de uso
        var certificado = consultarUseCase.consultar(criterio, "correlationId");
        
        // Mapeo a DTO de respuesta
        return mapper.toResponseDto(certificado, "correlationId");
    }
}
