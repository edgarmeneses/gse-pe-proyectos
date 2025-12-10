package pe.gob.reniec.hechosvitales.certificadodefuncion.infrastructure.adapters.in.rest.mapper;

import pe.gob.reniec.hechosvitales.certificadodefuncion.domain.model.*;
import pe.gob.reniec.hechosvitales.certificadodefuncion.infrastructure.adapters.in.rest.dto.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Mapper: Transformación entre objetos del dominio y DTOs REST
 * Implementa mapeo sin dependencias externas (sin MapStruct, sin Lombok)
 */
public class CertificadoDefuncionDtoMapper {

    private static final DateTimeFormatter ISO_FORMATTER = DateTimeFormatter.ISO_OFFSET_DATE_TIME;

    /**
     * Convierte lista de entidades del dominio a DTO de respuesta
     */
    public ConsultaCertificadoResponseDto toResponseDto(List<CertificadoDefuncion> certificados) {
        ConsultaCertificadoResponseDto response = new ConsultaCertificadoResponseDto();
        response.setSuccess(true);
        response.setStatusCode("200");
        response.setMessage("Operación realizada exitosamente");

        // Mapear certificados
        List<CertificadoDefuncionDto> certificadosDto = certificados.stream()
            .map(this::toCertificadoDto)
            .collect(Collectors.toList());

        ConsultaCertificadoResponseDto.DataDto data = new ConsultaCertificadoResponseDto.DataDto(certificadosDto);
        response.setData(data);

        // Crear metadatos
        MetadataDto metadata = new MetadataDto();
        metadata.setTimestamp(LocalDateTime.now(ZoneId.of("America/Lima")).format(ISO_FORMATTER));
        metadata.setCorrelationId(UUID.randomUUID().toString());
        metadata.setVersion("v1");
        metadata.setSource("WS-CDEF");
        response.setMetadata(metadata);

        return response;
    }

    /**
     * Convierte entidad del dominio a DTO
     */
    public CertificadoDefuncionDto toCertificadoDto(CertificadoDefuncion certificado) {
        if (certificado == null) {
            return null;
        }

        CertificadoDefuncionDto dto = new CertificadoDefuncionDto();
        dto.setNuCdef(certificado.getNuCdef());
        dto.setCoTipoCdef(certificado.getCoTipoCdef());
        dto.setCoEstadoCdef(certificado.getCoEstadoCdef());
        dto.setDeEstadoCdef(certificado.getDeEstadoCdef());
        dto.setFeCrea(certificado.getFeCrea());
        dto.setFeModifica(certificado.getFeModifica());
        dto.setObservaciones(certificado.getObservaciones());
        dto.setFallecido(toFallecidoDto(certificado.getFallecido()));
        dto.setDefuncion(toDefuncionDto(certificado.getDefuncion()));
        dto.setProfesional(toProfesionalDto(certificado.getProfesional()));
        dto.setCertificante(toCertificanteDto(certificado.getCertificante()));
        dto.setCausasMuerte(toCausasMuerteDto(certificado.getCausasMuerte()));
        dto.setDeclarante(toDeclaranteDto(certificado.getDeclarante()));
        dto.setAuditoria(toAuditoriaDto(certificado.getAuditoria()));

        return dto;
    }

    /**
     * Convierte Fallecido del dominio a DTO
     */
    public FallecidoDto toFallecidoDto(Fallecido fallecido) {
        if (fallecido == null) {
            return null;
        }

        FallecidoDto dto = new FallecidoDto();
        dto.setCoTitularTipoDocIdentidad(fallecido.getCoTitularTipoDocIdentidad());
        dto.setDeTitularDocIdentidad(fallecido.getDeTitularDocIdentidad());
        dto.setDeTitularPrimerApellido(fallecido.getDeTitularPrimerApellido());
        dto.setDeTitularSegundoApellido(fallecido.getDeTitularSegundoApellido());
        dto.setDeTitularPrenombres(fallecido.getDeTitularPrenombres());
        dto.setFeTitularNacimiento(fallecido.getFeTitularNacimiento());
        dto.setDeTitularSexo(fallecido.getDeTitularSexo());
        dto.setCoTitularEstadoCivil(fallecido.getCoTitularEstadoCivil());
        dto.setDeTitularEstadoCivil(fallecido.getDeTitularEstadoCivil());
        dto.setCoTitularGradoInstruccion(fallecido.getCoTitularGradoInstruccion());
        dto.setDeTitularGradoInstruccion(fallecido.getDeTitularGradoInstruccion());
        dto.setCoTitularOcupacion(fallecido.getCoTitularOcupacion());
        dto.setDeTitularOcupacion(fallecido.getDeTitularOcupacion());

        return dto;
    }

    /**
     * Convierte Defunción del dominio a DTO
     */
    public DefuncionDto toDefuncionDto(Defuncion defuncion) {
        if (defuncion == null) {
            return null;
        }

        DefuncionDto dto = new DefuncionDto();
        dto.setFeFallecimiento(defuncion.getFeFallecimiento());
        dto.setHoFallecimiento(defuncion.getHoFallecimiento());
        dto.setCoFallecimientoCont(defuncion.getCoFallecimientoCont());
        dto.setCoFallecimientoPais(defuncion.getCoFallecimientoPais());
        dto.setDeFallecimientoPais(defuncion.getDeFallecimientoPais());
        dto.setCoFallecimientoDpto(defuncion.getCoFallecimientoDpto());
        dto.setDeFallecimientoDpto(defuncion.getDeFallecimientoDpto());
        dto.setCoFallecimientoProv(defuncion.getCoFallecimientoProv());
        dto.setDeFallecimientoProv(defuncion.getDeFallecimientoProv());
        dto.setCoFallecimientoDist(defuncion.getCoFallecimientoDist());
        dto.setDeFallecimientoDist(defuncion.getDeFallecimientoDist());
        dto.setDeFallecimientoTipoLugar(defuncion.getDeFallecimientoTipoLugar());
        dto.setCoFallecimientoRenaes(defuncion.getCoFallecimientoRenaes());
        dto.setDeFallecimientoNombreLugar(defuncion.getDeFallecimientoNombreLugar());
        dto.setDeFallecimientoDireccion(defuncion.getDeFallecimientoDireccion());
        dto.setCoTipoMuerte(defuncion.getCoTipoMuerte());
        dto.setDeTipoMuerte(defuncion.getDeTipoMuerte());

        return dto;
    }

    /**
     * Convierte Profesional del dominio a DTO
     */
    public ProfesionalDto toProfesionalDto(Profesional profesional) {
        if (profesional == null) {
            return null;
        }

        ProfesionalDto dto = new ProfesionalDto();
        dto.setDeProfDocIdentidad(profesional.getDeProfDocIdentidad());

        return dto;
    }

    /**
     * Convierte Certificante del dominio a DTO
     */
    public CertificanteDto toCertificanteDto(Certificante certificante) {
        if (certificante == null) {
            return null;
        }

        CertificanteDto dto = new CertificanteDto();
        dto.setDeProfDocIdentidad(certificante.getDeProfDocIdentidad());
        dto.setDeProfNombres(certificante.getDeProfNombres());
        dto.setDeProfApellidoPaterno(certificante.getDeProfApellidoPaterno());
        dto.setDeProfApellidoMaterno(certificante.getDeProfApellidoMaterno());
        dto.setCoColegioProf(certificante.getCoColegioProf());
        dto.setDeColegioProf(certificante.getDeColegioProf());
        dto.setNuColegioProf(certificante.getNuColegioProf());

        return dto;
    }

    /**
     * Convierte lista de CausaMuerte del dominio a DTOs
     */
    public List<CausaMuerteDto> toCausasMuerteDto(List<CausaMuerte> causasMuerte) {
        if (causasMuerte == null) {
            return null;
        }

        return causasMuerte.stream()
            .map(this::toCausaMuerteDto)
            .collect(Collectors.toList());
    }

    /**
     * Convierte CausaMuerte del dominio a DTO
     */
    public CausaMuerteDto toCausaMuerteDto(CausaMuerte causaMuerte) {
        if (causaMuerte == null) {
            return null;
        }

        CausaMuerteDto dto = new CausaMuerteDto();
        dto.setTipoCausa(causaMuerte.getTipoCausa());
        dto.setCoEnfermedad(causaMuerte.getCoEnfermedad());
        dto.setDeEnfermedad(causaMuerte.getDeEnfermedad());
        dto.setTiempoEvolucion(causaMuerte.getTiempoEvolucion());

        return dto;
    }

    /**
     * Convierte Declarante del dominio a DTO
     */
    public DeclaranteDto toDeclaranteDto(Declarante declarante) {
        if (declarante == null) {
            return null;
        }

        DeclaranteDto dto = new DeclaranteDto();
        dto.setCoDeclaranteTipoDocIdentidad(declarante.getCoDeclaranteTipoDocIdentidad());
        dto.setDeDeclaranteDocIdentidad(declarante.getDeDeclaranteDocIdentidad());
        dto.setDeDeclaranteNombres(declarante.getDeDeclaranteNombres());
        dto.setDeDeclaranteApellidoPaterno(declarante.getDeDeclaranteApellidoPaterno());
        dto.setDeDeclaranteApellidoMaterno(declarante.getDeDeclaranteApellidoMaterno());
        dto.setCoParentesco(declarante.getCoParentesco());
        dto.setDeParentesco(declarante.getDeParentesco());

        return dto;
    }

    /**
     * Convierte Auditoria del dominio a DTO
     */
    public AuditoriaDto toAuditoriaDto(Auditoria auditoria) {
        if (auditoria == null) {
            return null;
        }

        AuditoriaDto dto = new AuditoriaDto();
        dto.setUsuarioCrea(auditoria.getUsuarioCrea());
        dto.setUsuarioModifica(auditoria.getUsuarioModifica());
        dto.setOficinaCrea(auditoria.getOficinaCrea());

        return dto;
    }
}
