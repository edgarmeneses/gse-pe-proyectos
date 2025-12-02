package pe.gob.reniec.agendamiento.infrastructure.adapters.out.persistence.mapper;

import pe.gob.reniec.agendamiento.domain.model.*;
import pe.gob.reniec.agendamiento.infrastructure.adapters.out.persistence.entity.ExcepcionHorariaEntity;
import java.util.List;

public class ExcepcionHorariaPersistenceMapper {
    
    public ExcepcionHorariaEntity domainToEntity(ExcepcionHoraria excepcion) {
        return new ExcepcionHorariaEntity(
            excepcion.idExcepcion(),
            excepcion.codigoSede(),
            excepcion.nombreSede(),
            excepcion.fechaExcepcion(),
            excepcion.tipoExcepcion(),
            excepcion.descripcion(),
            excepcion.horarioEspecial() != null ? excepcion.horarioEspecial().horaInicio() : null,
            excepcion.horarioEspecial() != null ? excepcion.horarioEspecial().horaFin() : null,
            excepcion.horarioEspecial() != null ? excepcion.horarioEspecial().capacidadPorFranja() : null,
            excepcion.citasAfectadas() != null ? excepcion.citasAfectadas().cantidad() : null,
            excepcion.citasAfectadas() != null ? excepcion.citasAfectadas().accion() : null,
            excepcion.fechaRegistro(),
            excepcion.usuarioRegistro()
        );
    }

    public ExcepcionHoraria entityToDomain(ExcepcionHorariaEntity entity) {
        HorarioEspecial horarioEspecial = entity.getHoraInicio() != null
            ? new HorarioEspecial(
                entity.getHoraInicio(),
                entity.getHoraFin(),
                entity.getCapacidadPorFranja()
            )
            : null;

        CitasAfectadas citasAfectadas = entity.getCantidadCitasAfectadas() != null
            ? new CitasAfectadas(
                entity.getCantidadCitasAfectadas(),
                entity.getAccionCitasAfectadas(),
                List.of()
            )
            : null;

        return new ExcepcionHoraria(
            entity.getIdExcepcion(),
            entity.getCodigoSede(),
            entity.getNombreSede(),
            entity.getFechaExcepcion(),
            entity.getTipoExcepcion(),
            entity.getDescripcion(),
            horarioEspecial,
            citasAfectadas,
            entity.getFechaRegistro(),
            entity.getUsuarioRegistro(),
            null
        );
    }
}
