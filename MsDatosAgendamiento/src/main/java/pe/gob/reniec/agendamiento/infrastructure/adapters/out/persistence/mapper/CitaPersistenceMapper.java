package pe.gob.reniec.agendamiento.infrastructure.adapters.out.persistence.mapper;

import pe.gob.reniec.agendamiento.domain.model.*;
import pe.gob.reniec.agendamiento.infrastructure.adapters.out.persistence.entity.CitaEntity;

public class CitaPersistenceMapper {
    
    public CitaEntity domainToEntity(Cita cita) {
        return new CitaEntity(
            cita.citaId(),
            cita.codigoCita(),
            cita.estado(),
            cita.sedeServicio().codigoSede(),
            cita.sedeServicio().nombreSede(),
            cita.sedeServicio().direccion(),
            cita.sedeServicio().telefono(),
            cita.sedeServicio().capacidadDiariaMaxima(),
            cita.sedeServicio().tiempoAtencionMinutos(),
            cita.solicitud().idSolicitud(),
            cita.solicitud().numeroTramite(),
            cita.solicitante().dni(),
            cita.solicitante().nombres(),
            cita.solicitante().apellidoPaterno(),
            cita.solicitante().apellidoMaterno(),
            cita.solicitante().nombreCompleto(),
            cita.solicitante().email(),
            cita.solicitante().telefono(),
            cita.programacion().fechaCita(),
            cita.programacion().horaCita(),
            cita.programacion().fechaHoraCompleta(),
            cita.programacion().idDisponibilidad(),
            cita.tecnicoAsignado() != null ? cita.tecnicoAsignado().idTecnico() : null,
            cita.tecnicoAsignado() != null ? cita.tecnicoAsignado().nombreCompleto() : null,
            cita.tokenReagendamiento(),
            cita.fechaLimiteReagendamiento(),
            cita.cantidadReagendamientos(),
            cita.maximoReagendamientos(),
            cita.observaciones(),
            cita.fechaRegistro(),
            cita.usuarioRegistro(),
            cita.fechaActualizacion(),
            cita.usuarioActualizacion()
        );
    }

    public Cita entityToDomain(CitaEntity entity) {
        SedeServicio sedeServicio = new SedeServicio(
            entity.getCodigoSede(),
            entity.getNombreSede(),
            entity.getDireccionSede(),
            entity.getTelefonoSede(),
            entity.getCapacidadDiariaMaxima(),
            entity.getTiempoAtencionMinutos()
        );

        Solicitud solicitud = new Solicitud(
            entity.getIdSolicitud(),
            entity.getNumeroTramite()
        );

        Solicitante solicitante = new Solicitante(
            entity.getDniSolicitante(),
            entity.getNombresSolicitante(),
            entity.getApellidoPaternoSolicitante(),
            entity.getApellidoMaternoSolicitante(),
            entity.getNombreCompletoSolicitante(),
            entity.getEmailSolicitante(),
            entity.getTelefonoSolicitante()
        );

        Programacion programacion = new Programacion(
            entity.getFechaCita(),
            entity.getHoraCita(),
            entity.getFechaHoraCompleta(),
            entity.getIdDisponibilidad()
        );

        TecnicoAsignado tecnicoAsignado = entity.getIdTecnico() != null
            ? new TecnicoAsignado(
                entity.getIdTecnico(),
                entity.getNombreCompletoTecnico()
            )
            : null;

        return new Cita(
            entity.getCitaId(),
            entity.getCodigoCita(),
            entity.getEstado(),
            sedeServicio,
            solicitud,
            solicitante,
            programacion,
            tecnicoAsignado,
            entity.getTokenReagendamiento(),
            entity.getFechaLimiteReagendamiento(),
            entity.getCantidadReagendamientos(),
            entity.getMaximoReagendamientos(),
            entity.getObservaciones(),
            entity.getFechaRegistro(),
            entity.getUsuarioRegistro(),
            entity.getFechaActualizacion(),
            entity.getUsuarioActualizacion()
        );
    }
}
