package pe.gob.sunat.gse.coreog.certificadosdigitales.infrastructure.adapters.in.rest.mapper;

import pe.gob.sunat.gse.coreog.certificadosdigitales.domain.model.CertificadoDigital;
import pe.gob.sunat.gse.coreog.certificadosdigitales.infrastructure.adapters.in.rest.dto.*;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper entre el dominio y los DTOs REST
 * Implementación manual sin dependencias de frameworks
 * 
 * Mapea estructuras complejas:
 * - Request: 4 secciones (solicitud, ciudadano, configuracionCertificados, metadatos)
 * - Response: success + data (5 secciones) + metadata
 * - Data incluye: transaccion, ciudadano, certificados[], pasosProceso (2 pasos), auditoria
 */
public class CertificadoDigitalDtoMapper {
    
    /**
     * Convierte domain model a DTO de respuesta completo
     * Estructura: {success: true, data: {transaccion, ciudadano, certificados[], pasosProceso, auditoria}, metadata}
     * 
     * @param certificados Lista de certificados emitidos (domain)
     * @param requestDto Request original (para trazar datos de auditoría)
     * @return ObtenerCertificadoDigitalResponseDto con estructura completa
     */
    public ObtenerCertificadoDigitalResponseDto toResponseDto(List<CertificadoDigital> certificados, 
                                                               ObtenerCertificadoDigitalRequestDto requestDto) {
        ObtenerCertificadoDigitalResponseDto responseDto = new ObtenerCertificadoDigitalResponseDto();
        responseDto.setSuccess(true);
        
        // Construir Data (5 secciones)
        DataDto dataDto = new DataDto();
        
        // 1. Transaccion
        TransaccionDto transaccionDto = new TransaccionDto();
        transaccionDto.setTransaccionId("TRX-" + System.currentTimeMillis()); // Implementación temporal
        transaccionDto.setEstado("COMPLETADO");
        transaccionDto.setFechaInicio(getCurrentTimestamp());
        transaccionDto.setFechaFin(getCurrentTimestamp());
        //transaccionDto.setTiempoProcesamientoMs(1500L); // Implementación temporal
        dataDto.setTransaccion(transaccionDto);
        
        // 2. Ciudadano
        CiudadanoResponseDto ciudadanoResponseDto = new CiudadanoResponseDto();
        //ciudadanoResponseDto.setNumeroDocumento(requestDto.getCiudadano().getNumeroDocumento());
        ciudadanoResponseDto.setNombreCompleto(
            requestDto.getCiudadano().getNombres() + " " + 
            requestDto.getCiudadano().getApellidoPaterno() + " " + 
            requestDto.getCiudadano().getApellidoMaterno()
        );
        dataDto.setCiudadano(ciudadanoResponseDto);
        
        // 3. Certificados
        List<CertificadoDigitalDto> certificadosDto = certificados.stream()
            .map(this::toCertificadoDigitalDto)
            .collect(Collectors.toList());
        dataDto.setCertificados(certificadosDto);
        
        // 4. PasosProceso (2 pasos obligatorios)
        PasosProcesoDto pasosProcesoDto = new PasosProcesoDto();
        
        Paso1GeneracionClavesDto paso1 = new Paso1GeneracionClavesDto();
        paso1.setSolicitudPkiId("PKI-SOLICITUD-123"); // Implementación temporal
        paso1.setEstado("COMPLETADO");
        paso1.setFechaInicio(getCurrentTimestamp());
        paso1.setFechaFin(getCurrentTimestamp());
        paso1.setIntentos(1);
        pasosProcesoDto.setPaso1GeneracionClaves(paso1);
        
        Paso2EmisionCertificadoDto paso2 = new Paso2EmisionCertificadoDto();
        paso2.setEstado("COMPLETADO");
        paso2.setFechaInicio(getCurrentTimestamp());
        paso2.setFechaFin(getCurrentTimestamp());
        paso2.setIntentos(1);
        pasosProcesoDto.setPaso2EmisionCertificado(paso2);
        
        dataDto.setPasosProceso(pasosProcesoDto);
        
        // 5. Auditoria
        AuditoriaDto auditoriaDto = new AuditoriaDto();
        auditoriaDto.setRegistroAuditoriaId("AUD-" + System.currentTimeMillis());
        auditoriaDto.setUsuarioEjecutor(requestDto.getMetadatos().getUsuarioRegistrador());
        auditoriaDto.setOficinaEjecucion(requestDto.getMetadatos().getOficinaOrigen());
        auditoriaDto.setIpCliente(requestDto.getMetadatos().getIpOrigen());
        //auditoriaDto.setTimestampEjecucion(getCurrentTimestamp());
        dataDto.setAuditoria(auditoriaDto);
        
        responseDto.setData(dataDto);
        
        // Metadata
        MetadataResponseDto metadataDto = new MetadataResponseDto();
        //metadataDto.setVersion("1.0");
        metadataDto.setTimestamp(getCurrentTimestamp());
        metadataDto.setCorrelationId("CORR-" + System.currentTimeMillis()); // Debería venir del header X-Correlation-ID
        responseDto.setMetadata(metadataDto);
        
        return responseDto;
    }
    
    /**
     * Convierte CertificadoDigital (domain) a CertificadoDigitalDto
     */
    private CertificadoDigitalDto toCertificadoDigitalDto(CertificadoDigital certificado) {
        CertificadoDigitalDto dto = new CertificadoDigitalDto();
        dto.setTipoCertificado(certificado.getTipoCertificado());
        dto.setCertificadoId(certificado.getCertificadoId());
        dto.setNumeroSerie(certificado.getNumeroSerie());
        dto.setFechaEmision(certificado.getFechaEmision());
        dto.setFechaVencimiento(certificado.getFechaVencimiento());
        dto.setVigenciaAnios(certificado.getVigenciaAnios());
        dto.setEstadoCertificado(certificado.getEstadoCertificado());
        dto.setAlgoritmoFirma(certificado.getAlgoritmoFirma());
        dto.setLongitudClave(certificado.getLongitudClave());
        dto.setSubjectDN(certificado.getSubjectDN());
        dto.setHuellaCertificado(certificado.getHuellaCertificado());
        dto.setCertificadoBase64(certificado.getCertificadoBase64());
        return dto;
    }
    
    /**
     * Convierte RequestDto a objetos del dominio (si fuera necesario)
     * En este caso el UseCase recibe Object directamente por simplicidad
     */
    public CertificadoDigital toDomainModel(ObtenerCertificadoDigitalRequestDto requestDto) {
        // Implementación pendiente según necesidad
        throw new UnsupportedOperationException("Conversión request -> domain pendiente");
    }
    
    /**
     * Genera timestamp en formato ISO 8601
     */
    private String getCurrentTimestamp() {
        return java.time.Instant.now().toString();
    }
}
