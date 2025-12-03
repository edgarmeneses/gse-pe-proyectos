package pe.gob.reniec.gse.agendamiento.data.domain.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

public class Disponibilidad {
    
    private String idDisponibilidad;
    private CodigoSede codigoSede;
    private LocalDate fecha;
    private DiaSemana diaSemana;
    private Boolean esHabil;
    private String motivoNoHabil;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private Integer capacidadTotal;
    private Integer capacidadOcupada;
    private String estado;
    private LocalDateTime fechaRegistro;
    private String usuarioRegistro;
    private LocalDateTime fechaActualizacion;
    private String usuarioActualizacion;
    
    public Disponibilidad() {
        this.capacidadOcupada = 0;
        this.esHabil = true;
    }
    
    public Disponibilidad(String idDisponibilidad, CodigoSede codigoSede, LocalDate fecha, DiaSemana diaSemana,
                         Boolean esHabil, String motivoNoHabil, LocalTime horaInicio, LocalTime horaFin,
                         Integer capacidadTotal, Integer capacidadOcupada,
                         String estado, LocalDateTime fechaRegistro, String usuarioRegistro,
                         LocalDateTime fechaActualizacion, String usuarioActualizacion) {
        this.idDisponibilidad = idDisponibilidad;
        this.codigoSede = codigoSede;
        this.fecha = fecha;
        this.diaSemana = diaSemana;
        this.esHabil = esHabil;
        this.motivoNoHabil = motivoNoHabil;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.capacidadTotal = capacidadTotal;
        this.capacidadOcupada = capacidadOcupada != null ? capacidadOcupada : 0;
        this.estado = estado;
        this.fechaRegistro = fechaRegistro;
        this.usuarioRegistro = usuarioRegistro;
        this.fechaActualizacion = fechaActualizacion;
        this.usuarioActualizacion = usuarioActualizacion;
    }
    
    public void configurar(CodigoSede codigoSede, LocalDate fecha, LocalTime horaInicio,
                          LocalTime horaFin, Integer capacidadTotal, String usuario) {
        validarDatosObligatorios(codigoSede, fecha, horaInicio, horaFin, capacidadTotal);
        
        if (fecha.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("No se puede configurar disponibilidad en el pasado");
        }
        
        if (horaFin.isBefore(horaInicio) || horaFin.equals(horaInicio)) {
            throw new IllegalArgumentException("La hora fin debe ser posterior a la hora inicio");
        }
        
        if (capacidadTotal <= 0) {
            throw new IllegalArgumentException("La capacidad total debe ser mayor a cero");
        }
        
        this.idDisponibilidad = UUID.randomUUID().toString();
        this.codigoSede = codigoSede;
        this.fecha = fecha;
        this.diaSemana = DiaSemana.desde(fecha);
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.capacidadTotal = capacidadTotal;
        this.capacidadOcupada = 0;
        this.esHabil = true;
        this.estado = "ACTIVA";
        this.fechaRegistro = LocalDateTime.now();
        this.usuarioRegistro = usuario;
    }
    
    public void ocuparCupo() {
        if (!estaDisponible()) {
            throw new IllegalStateException("No hay cupos disponibles");
        }
        
        if (!esHabil) {
            throw new IllegalStateException("La fecha no es hábil para agendar");
        }
        
        if (!estaActiva()) {
            throw new IllegalStateException("La disponibilidad no está activa");
        }
        
        this.capacidadOcupada++;
    }
    
    public void liberarCupo() {
        if (capacidadOcupada <= 0) {
            throw new IllegalStateException("No hay cupos ocupados para liberar");
        }
        
        this.capacidadOcupada--;
    }
    
    public void marcarComoNoHabil(String motivo, String usuario) {
        if (motivo == null || motivo.trim().isEmpty()) {
            throw new IllegalArgumentException("El motivo es requerido");
        }
        
        this.esHabil = false;
        this.motivoNoHabil = motivo.trim();
        this.fechaActualizacion = LocalDateTime.now();
        this.usuarioActualizacion = usuario;
    }
    
    public void marcarComoHabil(String usuario) {
        this.esHabil = true;
        this.motivoNoHabil = null;
        this.fechaActualizacion = LocalDateTime.now();
        this.usuarioActualizacion = usuario;
    }
    
    public void desactivar(String usuario) {
        this.estado = "INACTIVA";
        this.fechaActualizacion = LocalDateTime.now();
        this.usuarioActualizacion = usuario;
    }
    
    public void activar(String usuario) {
        this.estado = "ACTIVA";
        this.fechaActualizacion = LocalDateTime.now();
        this.usuarioActualizacion = usuario;
    }
    
    public void actualizarCapacidad(Integer nuevaCapacidad, String usuario) {
        if (nuevaCapacidad < capacidadOcupada) {
            throw new IllegalStateException("La nueva capacidad no puede ser menor a los cupos ocupados");
        }
        
        if (nuevaCapacidad <= 0) {
            throw new IllegalArgumentException("La capacidad debe ser mayor a cero");
        }
        
        this.capacidadTotal = nuevaCapacidad;
        this.fechaActualizacion = LocalDateTime.now();
        this.usuarioActualizacion = usuario;
    }
    
    public void actualizarHorario(LocalTime nuevaHoraInicio, LocalTime nuevaHoraFin, String usuario) {
        if (nuevaHoraFin.isBefore(nuevaHoraInicio) || nuevaHoraFin.equals(nuevaHoraInicio)) {
            throw new IllegalArgumentException("La hora fin debe ser posterior a la hora inicio");
        }
        
        this.horaInicio = nuevaHoraInicio;
        this.horaFin = nuevaHoraFin;
        this.fechaActualizacion = LocalDateTime.now();
        this.usuarioActualizacion = usuario;
    }
    
    public boolean estaDisponible() {
        return capacidadOcupada < capacidadTotal;
    }
    
    public boolean estaCompleta() {
        return capacidadOcupada >= capacidadTotal;
    }
    
    public boolean estaActiva() {
        return "ACTIVA".equals(estado);
    }
    
    public Integer getCapacidadDisponible() {
        return capacidadTotal - capacidadOcupada;
    }
    
    public boolean esDelDia(LocalDate fecha) {
        return this.fecha.equals(fecha);
    }
    
    public boolean esDeLaSede(CodigoSede codigoSede) {
        return this.codigoSede.equals(codigoSede);
    }
    
    public boolean estaEnRangoHorario(LocalTime hora) {
        return !hora.isBefore(horaInicio) && !hora.isAfter(horaFin);
    }
    
    private void validarDatosObligatorios(CodigoSede codigoSede, LocalDate fecha,
                                         LocalTime horaInicio, LocalTime horaFin,
                                         Integer capacidadTotal) {
        if (codigoSede == null) {
            throw new IllegalArgumentException("El código de sede es requerido");
        }
        if (fecha == null) {
            throw new IllegalArgumentException("La fecha es requerida");
        }
        if (horaInicio == null) {
            throw new IllegalArgumentException("La hora de inicio es requerida");
        }
        if (horaFin == null) {
            throw new IllegalArgumentException("La hora de fin es requerida");
        }
        if (capacidadTotal == null) {
            throw new IllegalArgumentException("La capacidad total es requerida");
        }
    }
    
    // Getters y Setters
    
    public String getIdDisponibilidad() {
        return idDisponibilidad;
    }
    
    public void setIdDisponibilidad(String idDisponibilidad) {
        this.idDisponibilidad = idDisponibilidad;
    }
    
    public CodigoSede getCodigoSede() {
        return codigoSede;
    }
    
    public void setCodigoSede(CodigoSede codigoSede) {
        this.codigoSede = codigoSede;
    }
    
    public LocalDate getFecha() {
        return fecha;
    }
    
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    
    public DiaSemana getDiaSemana() {
        return diaSemana;
    }
    
    public void setDiaSemana(DiaSemana diaSemana) {
        this.diaSemana = diaSemana;
    }
    
    public Boolean getEsHabil() {
        return esHabil;
    }
    
    public void setEsHabil(Boolean esHabil) {
        this.esHabil = esHabil;
    }
    
    public String getMotivoNoHabil() {
        return motivoNoHabil;
    }
    
    public void setMotivoNoHabil(String motivoNoHabil) {
        this.motivoNoHabil = motivoNoHabil;
    }
    
    public LocalTime getHoraInicio() {
        return horaInicio;
    }
    
    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }
    
    public LocalTime getHoraFin() {
        return horaFin;
    }
    
    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }
    
    public Integer getCapacidadTotal() {
        return capacidadTotal;
    }
    
    public void setCapacidadTotal(Integer capacidadTotal) {
        this.capacidadTotal = capacidadTotal;
    }
    
    public Integer getCapacidadOcupada() {
        return capacidadOcupada;
    }
    
    public void setCapacidadOcupada(Integer capacidadOcupada) {
        this.capacidadOcupada = capacidadOcupada;
    }
    
    public String getEstado() {
        return estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }
    
    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    
    public String getUsuarioRegistro() {
        return usuarioRegistro;
    }
    
    public void setUsuarioRegistro(String usuarioRegistro) {
        this.usuarioRegistro = usuarioRegistro;
    }
    
    public LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }
    
    public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }
    
    public String getUsuarioActualizacion() {
        return usuarioActualizacion;
    }
    
    public void setUsuarioActualizacion(String usuarioActualizacion) {
        this.usuarioActualizacion = usuarioActualizacion;
    }
}

        return horaInicio;
    }
    
    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }
    
    public LocalTime getHoraFin() {
        return horaFin;
    }
    
    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }
    
    public Integer getCapacidadTotal() {
        return capacidadTotal;
    }
    
    public void setCapacidadTotal(Integer capacidadTotal) {
        this.capacidadTotal = capacidadTotal;
    }
    
    public Integer getCapacidadOcupada() {
        return capacidadOcupada;
    }
    
    public void setCapacidadOcupada(Integer capacidadOcupada) {
        this.capacidadOcupada = capacidadOcupada;
    }
    
    public Integer getCapacidadDisponible() {
        return capacidadDisponible;
    }
    
    public void setCapacidadDisponible(Integer capacidadDisponible) {
        this.capacidadDisponible = capacidadDisponible;
    }
    
    public String getEstado() {
        return estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }
    
    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    
    public String getUsuarioRegistro() {
        return usuarioRegistro;
    }
    
    public void setUsuarioRegistro(String usuarioRegistro) {
        this.usuarioRegistro = usuarioRegistro;
    }
    
    public LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }
    
    public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }
    
    public String getUsuarioActualizacion() {
        return usuarioActualizacion;
    }
    
    public void setUsuarioActualizacion(String usuarioActualizacion) {
        this.usuarioActualizacion = usuarioActualizacion;
    }
}
