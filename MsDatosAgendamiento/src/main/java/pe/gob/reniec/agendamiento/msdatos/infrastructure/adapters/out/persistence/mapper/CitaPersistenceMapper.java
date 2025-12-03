package pe.gob.reniec.agendamiento.msdatos.infrastructure.adapters.out.persistence.mapper;

import pe.gob.reniec.agendamiento.msdatos.domain.model.*;
import pe.gob.reniec.agendamiento.msdatos.infrastructure.adapters.out.persistence.entity.CitaEntity;

public class CitaPersistenceMapper {

    public CitaEntity toEntity(Cita cita) {
        if (cita == null) {
            return null;
        }

        CitaEntity entity = new CitaEntity();
        entity.setCitaId(cita.getCitaId());
        entity.setCodigoCita(cita.getCodigoCita());
        
        if (cita.getEstado() != null) {
            entity.setEstadoCodigo(cita.getEstado().getCodigo());
            entity.setEstadoDescripcion(cita.getEstado().getDescripcion());
            entity.setEstadoPermiteModificacion(cita.getEstado().getPermiteModificacion());
            entity.setEstadoPermiteCancelacion(cita.getEstado().getPermiteCancelacion());
        }
        
        if (cita.getSedeServicio() != null) {
            entity.setSedeCodigoSede(cita.getSedeServicio().getCodigoSede());
            entity.setSedeNombreSede(cita.getSedeServicio().getNombreSede());
            entity.setSedeDireccion(cita.getSedeServicio().getDireccion());
            entity.setSedeTelefono(cita.getSedeServicio().getTelefono());
        }
        
        if (cita.getSolicitud() != null) {
            entity.setSolicitudIdSolicitud(cita.getSolicitud().getIdSolicitud());
            entity.setSolicitudNumeroTramite(cita.getSolicitud().getNumeroTramite());
        }
        
        if (cita.getSolicitante() != null) {
            entity.setSolicitanteDni(cita.getSolicitante().getDni());
            entity.setSolicitanteNombres(cita.getSolicitante().getNombres());
            entity.setSolicitanteApellidoPaterno(cita.getSolicitante().getApellidoPaterno());
            entity.setSolicitanteApellidoMaterno(cita.getSolicitante().getApellidoMaterno());
            entity.setSolicitanteNombreCompleto(cita.getSolicitante().getNombreCompleto());
            entity.setSolicitanteEmail(cita.getSolicitante().getEmail());
            entity.setSolicitanteTelefono(cita.getSolicitante().getTelefono());
        }
        
        if (cita.getProgramacion() != null) {
            entity.setProgramacionFechaCita(cita.getProgramacion().getFechaCita());
            entity.setProgramacionHoraCita(cita.getProgramacion().getHoraCita());
            entity.setProgramacionFechaHoraCompleta(cita.getProgramacion().getFechaHoraCompleta());
            entity.setProgramacionIdDisponibilidad(cita.getProgramacion().getIdDisponibilidad());
        }
        
        if (cita.getTecnicoAsignado() != null) {
            entity.setTecnicoIdTecnico(cita.getTecnicoAsignado().getIdTecnico());
            entity.setTecnicoNombreCompleto(cita.getTecnicoAsignado().getNombreCompleto());
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

    public Cita toDomain(CitaEntity entity) {
        if (entity == null) {
            return null;
        }

        Cita cita = new Cita();
        cita.setCitaId(entity.getCitaId());
        cita.setCodigoCita(entity.getCodigoCita());
        
        EstadoCita estado = new EstadoCita(
            entity.getEstadoCodigo(),
            entity.getEstadoDescripcion(),
            entity.getEstadoPermiteModificacion(),
            entity.getEstadoPermiteCancelacion()
        );
        cita.setEstado(estado);
        
        SedeServicio sede = new SedeServicio(
            entity.getSedeCodigoSede(),
            entity.getSedeNombreSede(),
            entity.getSedeDireccion(),
            entity.getSedeTelefono()
        );
        cita.setSedeServicio(sede);
        
        Solicitud solicitud = new Solicitud(
            entity.getSolicitudIdSolicitud(),
            entity.getSolicitudNumeroTramite()
        );
        cita.setSolicitud(solicitud);
        
        Solicitante solicitante = new Solicitante(
            entity.getSolicitanteDni(),
            entity.getSolicitanteNombres(),
            entity.getSolicitanteApellidoPaterno(),
            entity.getSolicitanteApellidoMaterno(),
            entity.getSolicitanteNombreCompleto(),
            entity.getSolicitanteEmail(),
            entity.getSolicitanteTelefono()
        );
        cita.setSolicitante(solicitante);
        
        Programacion programacion = new Programacion(
            entity.getProgramacionFechaCita(),
            entity.getProgramacionHoraCita(),
            entity.getProgramacionFechaHoraCompleta(),
            entity.getProgramacionIdDisponibilidad()
        );
        cita.setProgramacion(programacion);
        
        if (entity.getTecnicoIdTecnico() != null) {
            TecnicoAsignado tecnico = new TecnicoAsignado(
                entity.getTecnicoIdTecnico(),
                entity.getTecnicoNombreCompleto()
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
