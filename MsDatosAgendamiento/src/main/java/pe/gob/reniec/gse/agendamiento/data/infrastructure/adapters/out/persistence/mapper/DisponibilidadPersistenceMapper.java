package pe.gob.reniec.gse.agendamiento.data.infrastructure.adapters.out.persistence.mapper;

import pe.gob.reniec.gse.agendamiento.data.domain.model.Disponibilidad;
import pe.gob.reniec.gse.agendamiento.data.infrastructure.adapters.out.persistence.entity.DisponibilidadEntity;

public class DisponibilidadPersistenceMapper {
    
    public static DisponibilidadEntity toEntity(Disponibilidad disponibilidad) {
        DisponibilidadEntity entity = new DisponibilidadEntity();
        entity.setIdDisponibilidad(disponibilidad.getIdDisponibilidad());
        entity.setCodigoSede(disponibilidad.getCodigoSede());
        entity.setFecha(disponibilidad.getFecha());
        entity.setDiaSemana(disponibilidad.getDiaSemana());
        entity.setEsHabil(disponibilidad.getEsHabil());
        entity.setMotivoNoHabil(disponibilidad.getMotivoNoHabil());
        entity.setHoraInicio(disponibilidad.getHoraInicio());
        entity.setHoraFin(disponibilidad.getHoraFin());
        entity.setCapacidadTotal(disponibilidad.getCapacidadTotal());
        entity.setCapacidadOcupada(disponibilidad.getCapacidadOcupada());
        entity.setCapacidadDisponible(disponibilidad.getCapacidadDisponible());
        entity.setEstado(disponibilidad.getEstado());
        entity.setFechaRegistro(disponibilidad.getFechaRegistro());
        entity.setUsuarioRegistro(disponibilidad.getUsuarioRegistro());
        entity.setFechaActualizacion(disponibilidad.getFechaActualizacion());
        entity.setUsuarioActualizacion(disponibilidad.getUsuarioActualizacion());
        return entity;
    }
    
    public static Disponibilidad toDomain(DisponibilidadEntity entity) {
        Disponibilidad disponibilidad = new Disponibilidad();
        disponibilidad.setIdDisponibilidad(entity.getIdDisponibilidad());
        disponibilidad.setCodigoSede(entity.getCodigoSede());
        disponibilidad.setFecha(entity.getFecha());
        disponibilidad.setDiaSemana(entity.getDiaSemana());
        disponibilidad.setEsHabil(entity.getEsHabil());
        disponibilidad.setMotivoNoHabil(entity.getMotivoNoHabil());
        disponibilidad.setHoraInicio(entity.getHoraInicio());
        disponibilidad.setHoraFin(entity.getHoraFin());
        disponibilidad.setCapacidadTotal(entity.getCapacidadTotal());
        disponibilidad.setCapacidadOcupada(entity.getCapacidadOcupada());
        disponibilidad.setCapacidadDisponible(entity.getCapacidadDisponible());
        disponibilidad.setEstado(entity.getEstado());
        disponibilidad.setFechaRegistro(entity.getFechaRegistro());
        disponibilidad.setUsuarioRegistro(entity.getUsuarioRegistro());
        disponibilidad.setFechaActualizacion(entity.getFechaActualizacion());
        disponibilidad.setUsuarioActualizacion(entity.getUsuarioActualizacion());
        return disponibilidad;
    }
}
