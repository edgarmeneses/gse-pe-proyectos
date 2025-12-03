package pe.gob.reniec.gse.registradores.infrastructure.adapters.out.persistence.mapper;

import pe.gob.reniec.gse.registradores.domain.model.*;
import pe.gob.reniec.gse.registradores.infrastructure.adapters.out.persistence.entity.PeriodoEntity;
import pe.gob.reniec.gse.registradores.infrastructure.adapters.out.persistence.entity.RegistradorEntity;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper de persistencia: RegistradorPersistenceMapper
 * Convierte entre objetos del dominio y entidades de persistencia.
 */
public class RegistradorPersistenceMapper {
    
    /**
     * Convierte una entidad de dominio Registrador a RegistradorEntity.
     */
    public static RegistradorEntity toEntity(Registrador registrador) {
        if (registrador == null) return null;
        
        RegistradorEntity entity = new RegistradorEntity();
        entity.setIdRegistrador(registrador.getIdRegistrador());
        entity.setNumeroDni(registrador.getNumeroDni());
        entity.setPrimerApellido(registrador.getPrimerApellido());
        entity.setSegundoApellido(registrador.getSegundoApellido());
        entity.setPrenombres(registrador.getPrenombres());
        entity.setNombreCompleto(registrador.getNombreCompleto());
        entity.setNumeroImagen(registrador.getNumeroImagen());
        entity.setCodigoLocal(registrador.getCodigoLocal());
        entity.setTipoRegistrador(registrador.getTipoRegistrador());
        entity.setObservaciones(registrador.getObservaciones());
        entity.setCodigoEstadoRegistrador(registrador.getCodigoEstadoRegistrador());
        
        // Mapear AsignacionActual
        if (registrador.getAsignacionActual() != null) {
            entity.setDescripcionLocal(registrador.getAsignacionActual().getDescripcionLocal());
            entity.setDescripcionEstado(registrador.getAsignacionActual().getDescripcionEstado());
        }
        
        // Mapear Firma
        if (registrador.getFirma() != null) {
            entity.setTieneFirmaRegistrada(registrador.getFirma().getTieneRegistrada());
            entity.setHashFirma(registrador.getFirma().getHashFirma());
            entity.setFechaActualizacionFirma(registrador.getFirma().getFechaUltimaActualizacion());
        }
        
        // Mapear Sello
        if (registrador.getSello() != null) {
            entity.setTieneSelloRegistrado(registrador.getSello().getTieneRegistrado());
            entity.setHashSello(registrador.getSello().getHashSello());
            entity.setFechaActualizacionSello(registrador.getSello().getFechaUltimaActualizacion());
        }
        
        // Mapear Auditoría
        if (registrador.getAuditoria() != null) {
            entity.setUsuarioCreacion(registrador.getAuditoria().getUsuarioCreacion());
            entity.setFechaCreacion(registrador.getAuditoria().getFechaCreacion());
            entity.setUsuarioModificacion(registrador.getAuditoria().getUsuarioModificacion());
            entity.setFechaModificacion(registrador.getAuditoria().getFechaModificacion());
        }
        
        return entity;
    }
    
    /**
     * Convierte una RegistradorEntity a entidad de dominio Registrador.
     */
    public static Registrador toDomain(RegistradorEntity entity) {
        if (entity == null) return null;
        
        Registrador registrador = new Registrador();
        registrador.setIdRegistrador(entity.getIdRegistrador());
        registrador.setNumeroDni(entity.getNumeroDni());
        registrador.setPrimerApellido(entity.getPrimerApellido());
        registrador.setSegundoApellido(entity.getSegundoApellido());
        registrador.setPrenombres(entity.getPrenombres());
        registrador.setNumeroImagen(entity.getNumeroImagen());
        registrador.setCodigoLocal(entity.getCodigoLocal());
        registrador.setTipoRegistrador(entity.getTipoRegistrador());
        registrador.setObservaciones(entity.getObservaciones());
        registrador.setCodigoEstadoRegistrador(entity.getCodigoEstadoRegistrador());
        
        // Mapear AsignacionActual
        AsignacionActual asignacion = new AsignacionActual(
            entity.getCodigoLocal(),
            entity.getDescripcionLocal(),
            entity.getCodigoEstadoRegistrador(),
            entity.getDescripcionEstado(),
            entity.getFechaCreacion()
        );
        registrador.setAsignacionActual(asignacion);
        
        // Mapear Firma
        Firma firma = new Firma(
            entity.getTieneFirmaRegistrada(),
            entity.getHashFirma(),
            entity.getFechaActualizacionFirma()
        );
        registrador.setFirma(firma);
        
        // Mapear Sello
        Sello sello = new Sello(
            entity.getTieneSelloRegistrado(),
            entity.getHashSello(),
            entity.getFechaActualizacionSello()
        );
        registrador.setSello(sello);
        
        // Mapear Auditoría
        Auditoria auditoria = new Auditoria(
            entity.getUsuarioCreacion(),
            entity.getFechaCreacion(),
            entity.getUsuarioModificacion(),
            entity.getFechaModificacion()
        );
        registrador.setAuditoria(auditoria);
        
        return registrador;
    }
    
    /**
     * Convierte una entidad de dominio Registrador completo (con periodos) a Registrador de dominio.
     */
    public static Registrador toDomainWithPeriodos(RegistradorEntity entity, List<PeriodoEntity> periodosEntity) {
        Registrador registrador = toDomain(entity);
        
        if (periodosEntity != null && !periodosEntity.isEmpty()) {
            List<Periodo> periodos = periodosEntity.stream()
                .map(RegistradorPersistenceMapper::periodoDomainFromEntity)
                .collect(Collectors.toList());
            registrador.setPeriodos(periodos);
        }
        
        return registrador;
    }
    
    /**
     * Convierte PeriodoEntity a Periodo de dominio.
     */
    private static Periodo periodoDomainFromEntity(PeriodoEntity entity) {
        if (entity == null) return null;
        
        return new Periodo(
            entity.getIdPeriodo(),
            entity.getCodigoLocal(),
            entity.getDescripcionLocal(),
            entity.getFechaInicio(),
            entity.getFechaFin(),
            entity.getEstado()
        );
    }
    
    /**
     * Convierte Periodo de dominio a PeriodoEntity.
     */
    public static PeriodoEntity periodoToEntity(Periodo periodo, String idRegistrador) {
        if (periodo == null) return null;
        
        PeriodoEntity entity = new PeriodoEntity();
        entity.setIdPeriodo(periodo.getIdPeriodo());
        entity.setIdRegistrador(idRegistrador);
        entity.setCodigoLocal(periodo.getCodigoLocal());
        entity.setDescripcionLocal(periodo.getDescripcionLocal());
        entity.setFechaInicio(periodo.getFechaInicio());
        entity.setFechaFin(periodo.getFechaFin());
        entity.setEstado(periodo.getEstado());
        
        return entity;
    }
}
