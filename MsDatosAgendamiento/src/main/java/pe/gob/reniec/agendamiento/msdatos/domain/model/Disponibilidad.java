package pe.gob.reniec.agendamiento.msdatos.domain.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/**
 * Disponibilidad - Aggregate Root
 * Representa la configuración de disponibilidad horaria de una sede para brindar servicios.
 * Mantiene la invariante: la capacidad disponible nunca puede ser negativa.
 */
public class Disponibilidad {
    // Identidad
    private String disponibilidadId;
    
    // Datos básicos
    private String codigoSede;
    private LocalDate fechaConsulta;
    
    // Configuración horaria
    private ConfiguracionDisponibilidad configuracion;
    
    // Estado
    private String estado; // ACTIVO, INACTIVO
    
    // Auditoría
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;

    // Value Object interno para configuración
    public static class ConfiguracionDisponibilidad {
        private final String nombreSede;
        private final LocalDate fechaVigenciaDesde;
        private final LocalDate fechaVigenciaHasta;
        private final List<HorarioServicio> horarios;

        public ConfiguracionDisponibilidad(String nombreSede, LocalDate fechaVigenciaDesde,
                                          LocalDate fechaVigenciaHasta, List<HorarioServicio> horarios) {
            this.nombreSede = nombreSede;
            this.fechaVigenciaDesde = fechaVigenciaDesde;
            this.fechaVigenciaHasta = fechaVigenciaHasta;
            this.horarios = horarios != null ? new ArrayList<>(horarios) : new ArrayList<>();
        }

        public String getNombreSede() {
            return nombreSede;
        }

        public LocalDate getFechaVigenciaDesde() {
            return fechaVigenciaDesde;
        }

        public LocalDate getFechaVigenciaHasta() {
            return fechaVigenciaHasta;
        }

        public List<HorarioServicio> getHorarios() {
            return Collections.unmodifiableList(horarios);
        }
    }

    // Constructores
    public Disponibilidad() {
    }

    public Disponibilidad(String disponibilidadId, String codigoSede, LocalDate fechaConsulta,
                          ConfiguracionDisponibilidad configuracion, String estado,
                          LocalDateTime fechaCreacion, LocalDateTime fechaActualizacion) {
        this.disponibilidadId = disponibilidadId;
        this.codigoSede = codigoSede;
        this.fechaConsulta = fechaConsulta;
        this.configuracion = configuracion;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
        this.fechaActualizacion = fechaActualizacion;
    }

    // Factory method
    public static Disponibilidad crear(String codigoSede, ConfiguracionDisponibilidad configuracion) {
        Disponibilidad disponibilidad = new Disponibilidad();
        disponibilidad.disponibilidadId = UUID.randomUUID().toString();
        disponibilidad.codigoSede = codigoSede;
        disponibilidad.configuracion = configuracion;
        disponibilidad.estado = "ACTIVO";
        disponibilidad.fechaCreacion = LocalDateTime.now();
        return disponibilidad;
    }

    // Métodos de negocio
    public void actualizarConfiguracion(ConfiguracionDisponibilidad nuevaConfiguracion) {
        this.configuracion = nuevaConfiguracion;
        this.fechaActualizacion = LocalDateTime.now();
    }

    public void activar() {
        this.estado = "ACTIVO";
        this.fechaActualizacion = LocalDateTime.now();
    }

    public void desactivar() {
        this.estado = "INACTIVO";
        this.fechaActualizacion = LocalDateTime.now();
    }

    public boolean estaVigente(LocalDate fecha) {
        if (configuracion == null) return false;
        LocalDate desde = configuracion.getFechaVigenciaDesde();
        LocalDate hasta = configuracion.getFechaVigenciaHasta();
        return !fecha.isBefore(desde) && !fecha.isAfter(hasta);
    }

    // Getters y setters
    public String getDisponibilidadId() {
        return disponibilidadId;
    }

    public void setDisponibilidadId(String disponibilidadId) {
        this.disponibilidadId = disponibilidadId;
    }

    public String getCodigoSede() {
        return codigoSede;
    }

    public void setCodigoSede(String codigoSede) {
        this.codigoSede = codigoSede;
    }

    public LocalDate getFechaConsulta() {
        return fechaConsulta;
    }

    public void setFechaConsulta(LocalDate fechaConsulta) {
        this.fechaConsulta = fechaConsulta;
    }

    public ConfiguracionDisponibilidad getConfiguracion() {
        return configuracion;
    }

    public void setConfiguracion(ConfiguracionDisponibilidad configuracion) {
        this.configuracion = configuracion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }
}
