package pe.gob.reniec.gse.agendamiento.data.infrastructure.adapters.out.persistence.mapper;

import pe.gob.reniec.gse.agendamiento.data.domain.model.*;
import pe.gob.reniec.gse.agendamiento.data.infrastructure.adapters.out.persistence.entity.CitaEntity;

public class CitaPersistenceMapper {
    
    public static CitaEntity toEntity(Cita cita) {
        CitaEntity entity = new CitaEntity();
        entity.setCitaId(cita.getCitaId());
        entity.setCodigoCita(cita.getCodigoCita());
        
        if (cita.getEstado() != null) {
            entity.setEstadoCodigo(cita.getEstado().getCodigo());
            entity.setEstadoDescripcion(cita.getEstado().getDescripcion());
            entity.setPermiteModificacion(cita.getEstado().getPermiteModificacion());
            entity.setPermiteCancelacion(cita.getEstado().getPermiteCancelacion());
        }
        
        if (cita.getSedeServicio() != null) {
            entity.setCodigoSede(cita.getSedeServicio().getCodigoSede());
            entity.setNombreSede(cita.getSedeServicio().getNombreSede());
            entity.setDireccionSede(cita.getSedeServicio().getDireccion());
            entity.setTelefonoSede(cita.getSedeServicio().getTelefono());
        }
        
        if (cita.getSolicitud() != null) {
            entity.setIdSolicitud(cita.getSolicitud().getIdSolicitud());
            entity.setNumeroTramite(cita.getSolicitud().getNumeroTramite());
        }
        
        if (cita.getSolicitante() != null) {
            entity.setDniSolicitante(cita.getSolicitante().getDni());
            entity.setNombresSolicitante(cita.getSolicitante().getNombres());
            entity.setApellidoPaternoSolicitante(cita.getSolicitante().getApellidoPaterno());
            entity.setApellidoMaternoSolicitante(cita.getSolicitante().getApellidoMaterno());
            entity.setEmailSolicitante(cita.getSolicitante().getEmail());
            entity.setTelefonoSolicitante(cita.getSolicitante().getTelefono());
        }
        
        if (cita.getProgramacion() != null) {
            entity.setFechaCita(cita.getProgramacion().getFechaCita());
            entity.setHoraCita(cita.getProgramacion().getHoraCita());
            entity.setIdDisponibilidad(cita.getProgramacion().getIdDisponibilidad());
        }
        
        if (cita.getTecnicoAsignado() != null) {
            entity.setIdTecnico(cita.getTecnicoAsignado().getIdTecnico());
            entity.setNombreCompletoTecnico(cita.getTecnicoAsignado().getNombreCompleto());
        }
        
        entity.setTokenReagendamiento(cita.getTokenReagendamiento());
        entity.setFechaLimiteReagendamiento(cita.getFechaLimiteReagendamiento());
        entity.setCantidadReagendamientos(cita.getCantidadReagendamientos());
        entity.setMaximoReagendamientos(cita.getMaximoReagendamientos());
        entity.setObservaciones(cita.getObservaciones());
        entity.setFechaRegistro(cita.getFechaRegistro());
        entity.setUsuarioRegistro(cita.getUsuarioRegistro());
        entity.setFechaActualizacion(cita.getFechaActualizacion());
        entity.setUsuarioActualizacion(cita.getUsuarioActualizacion());
        
        return entity;
    }
    
    public static Cita toDomain(CitaEntity entity) {
        Cita cita = new Cita();
        cita.setCitaId(entity.getCitaId());
        cita.setCodigoCita(entity.getCodigoCita());
        
        EstadoCita estado = new EstadoCita(
            entity.getEstadoCodigo(),
            entity.getEstadoDescripcion(),
            entity.getPermiteModificacion(),
            entity.getPermiteCancelacion()
        );
        cita.setEstado(estado);
        
        SedeServicio sede = new SedeServicio(
            entity.getCodigoSede(),
            entity.getNombreSede(),
            entity.getDireccionSede(),
            entity.getTelefonoSede(),
            null, null
        );
        cita.setSedeServicio(sede);
        
        Solicitud solicitud = new Solicitud(
            entity.getIdSolicitud(),
            entity.getNumeroTramite()
        );
        cita.setSolicitud(solicitud);
        
        Solicitante solicitante = new Solicitante(
            entity.getDniSolicitante(),
            entity.getNombresSolicitante(),
            entity.getApellidoPaternoSolicitante(),
            entity.getApellidoMaternoSolicitante(),
            entity.getEmailSolicitante(),
            entity.getTelefonoSolicitante()
        );
        cita.setSolicitante(solicitante);
        
        Programacion programacion = new Programacion(
            entity.getFechaCita(),
            entity.getHoraCita(),
            entity.getIdDisponibilidad()
        );
        cita.setProgramacion(programacion);
        
        if (entity.getIdTecnico() != null) {
            TecnicoAsignado tecnico = new TecnicoAsignado(
                entity.getIdTecnico(),
                entity.getNombreCompletoTecnico()
            );
            cita.setTecnicoAsignado(tecnico);
        }
        
        cita.setTokenReagendamiento(entity.getTokenReagendamiento());
        cita.setFechaLimiteReagendamiento(entity.getFechaLimiteReagendamiento());
        cita.setCantidadReagendamientos(entity.getCantidadReagendamientos());
        cita.setMaximoReagendamientos(entity.getMaximoReagendamientos());
        cita.setObservaciones(entity.getObservaciones());
        cita.setFechaRegistro(entity.getFechaRegistro());
        cita.setUsuarioRegistro(entity.getUsuarioRegistro());
        cita.setFechaActualizacion(entity.getFechaActualizacion());
        cita.setUsuarioActualizacion(entity.getUsuarioActualizacion());
        
        return cita;
    }
}
