package pe.gob.reniec.agendamiento.infrastructure.adapters.out.persistence.mapper;

import pe.gob.reniec.agendamiento.domain.model.*;
import pe.gob.reniec.agendamiento.infrastructure.adapters.out.persistence.entity.DisponibilidadEntity;
import java.util.List;

public class DisponibilidadPersistenceMapper {
    
    public DisponibilidadEntity domainToEntity(Disponibilidad disponibilidad) {
        return new DisponibilidadEntity(
            disponibilidad.idDisponibilidad(),
            disponibilidad.sedeServicio().codigoSede(),
            disponibilidad.sedeServicio().nombreSede(),
            disponibilidad.sedeServicio().direccion(),
            disponibilidad.sedeServicio().telefono(),
            disponibilidad.sedeServicio().capacidadDiariaMaxima(),
            disponibilidad.sedeServicio().tiempoAtencionMinutos(),
            disponibilidad.fecha(),
            disponibilidad.diaSemana(),
            disponibilidad.esHabil(),
            disponibilidad.motivoNoHabil(),
            disponibilidad.horaInicio(),
            disponibilidad.horaFin(),
            disponibilidad.capacidadTotal(),
            disponibilidad.capacidadOcupada(),
            disponibilidad.capacidadDisponible(),
            disponibilidad.estado(),
            disponibilidad.fechaRegistro(),
            disponibilidad.usuarioRegistro(),
            disponibilidad.fechaActualizacion(),
            disponibilidad.usuarioActualizacion()
        );
    }

    public Disponibilidad entityToDomain(DisponibilidadEntity entity) {
        SedeServicio sedeServicio = new SedeServicio(
            entity.getCodigoSede(),
            entity.getNombreSede(),
            entity.getDireccionSede(),
            entity.getTelefonoSede(),
            entity.getCapacidadDiariaMaxima(),
            entity.getTiempoAtencionMinutos()
        );

        return new Disponibilidad(
            entity.getIdDisponibilidad(),
            sedeServicio,
            entity.getFecha(),
            entity.getDiaSemana(),
            entity.getEsHabil(),
            entity.getMotivoNoHabil(),
            entity.getHoraInicio(),
            entity.getHoraFin(),
            entity.getCapacidadTotal(),
            entity.getCapacidadOcupada(),
            entity.getCapacidadDisponible(),
            entity.getEstado(),
            List.of(),
            entity.getFechaRegistro(),
            entity.getUsuarioRegistro(),
            entity.getFechaActualizacion(),
            entity.getUsuarioActualizacion()
        );
    }
}
