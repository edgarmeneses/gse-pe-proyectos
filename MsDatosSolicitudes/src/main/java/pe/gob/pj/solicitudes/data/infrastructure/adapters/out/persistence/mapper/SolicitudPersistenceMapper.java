package pe.gob.pj.solicitudes.data.infrastructure.adapters.out.persistence.mapper;

import pe.gob.pj.solicitudes.data.domain.model.Solicitud;
import pe.gob.pj.solicitudes.data.domain.model.OficinaRegistro;
import pe.gob.pj.solicitudes.data.infrastructure.adapters.out.persistence.entity.SolicitudEntity;

public class SolicitudPersistenceMapper {

    public SolicitudEntity toEntity(Solicitud solicitud) {
        if (solicitud == null) {
            return null;
        }

        SolicitudEntity entity = new SolicitudEntity();
        entity.setSolicitudId(solicitud.getSolicitudId());
        entity.setNumeroSolicitud(solicitud.getNumeroSolicitud());
        entity.setEstado(solicitud.getEstado());
        entity.setTipoTramite(solicitud.getTipoTramite());
        entity.setSubTipoTramite(solicitud.getSubTipoTramite());
        
        if (solicitud.getSolicitante() != null) {
            entity.setDniSolicitante(solicitud.getSolicitante().getDni());
            entity.setNombresSolicitante(solicitud.getSolicitante().getNombres());
            entity.setApellidoPaternoSolicitante(solicitud.getSolicitante().getApellidoPaterno());
            entity.setApellidoMaternoSolicitante(solicitud.getSolicitante().getApellidoMaterno());
            entity.setEmailSolicitante(solicitud.getSolicitante().getEmail());
            entity.setTelefonoSolicitante(solicitud.getSolicitante().getTelefono());
        }
        
        entity.setTipoSolicitante(solicitud.getTipoSolicitante());
        entity.setPrioridad(solicitud.getPrioridad());
        entity.setObservaciones(solicitud.getObservaciones());
        entity.setFechaRegistro(solicitud.getFechaRegistro());
        entity.setFechaVencimiento(solicitud.getFechaVencimiento());
        entity.setUsuarioRegistro(solicitud.getUsuarioRegistro());
        
        if (solicitud.getOficinaRegistro() != null) {
            entity.setCodigoOficinaRegistro(solicitud.getOficinaRegistro().getCodigo());
            entity.setNombreOficinaRegistro(solicitud.getOficinaRegistro().getNombre());
        }
        
        entity.setTiempoEstimadoResolucion(solicitud.getTiempoEstimadoResolucion());
        entity.setUsuarioAsignado(solicitud.getUsuarioAsignado());
        entity.setRequiereDiligencia(solicitud.getRequiereDiligencia());
        
        return entity;
    }

    public Solicitud toDomain(SolicitudEntity entity) {
        if (entity == null) {
            return null;
        }

        Solicitud solicitud = new Solicitud();
        solicitud.setSolicitudId(entity.getSolicitudId());
        solicitud.setNumeroSolicitud(entity.getNumeroSolicitud());
        solicitud.setEstado(entity.getEstado());
        solicitud.setTipoTramite(entity.getTipoTramite());
        solicitud.setSubTipoTramite(entity.getSubTipoTramite());
        solicitud.setTipoSolicitante(entity.getTipoSolicitante());
        solicitud.setPrioridad(entity.getPrioridad());
        solicitud.setObservaciones(entity.getObservaciones());
        solicitud.setFechaRegistro(entity.getFechaRegistro());
        solicitud.setFechaVencimiento(entity.getFechaVencimiento());
        solicitud.setUsuarioRegistro(entity.getUsuarioRegistro());
        
        if (entity.getCodigoOficinaRegistro() != null) {
            OficinaRegistro oficinaRegistro = new OficinaRegistro(
                    entity.getCodigoOficinaRegistro(),
                    entity.getNombreOficinaRegistro()
            );
            solicitud.setOficinaRegistro(oficinaRegistro);
        }
        
        solicitud.setTiempoEstimadoResolucion(entity.getTiempoEstimadoResolucion());
        solicitud.setUsuarioAsignado(entity.getUsuarioAsignado());
        solicitud.setRequiereDiligencia(entity.getRequiereDiligencia());
        
        return solicitud;
    }
}
