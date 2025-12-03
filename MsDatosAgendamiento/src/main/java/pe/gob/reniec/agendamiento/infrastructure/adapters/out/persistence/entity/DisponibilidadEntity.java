package pe.gob.reniec.agendamiento.infrastructure.adapters.out.persistence.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

public class DisponibilidadEntity {
    private String idDisponibilidad;
    private String codigoSede;
    private String nombreSede;
    private String direccionSede;
    private String telefonoSede;
    private Long capacidadDiariaMaxima;
    private Long tiempoAtencionMinutos;
    private LocalDate fecha;
    private String diaSemana;
    private Boolean esHabil;
    private String motivoNoHabil;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private Long capacidadTotal;
    private Long capacidadOcupada;
    private Long capacidadDisponible;
    private String estado;
    private LocalDateTime fechaRegistro;
    private String usuarioRegistro;
    private LocalDateTime fechaActualizacion;
    private String usuarioActualizacion;

    public DisponibilidadEntity() {
    }

    public DisponibilidadEntity(String idDisponibilidad, String codigoSede, String nombreSede, String direccionSede,
                                String telefonoSede, Long capacidadDiariaMaxima, Long tiempoAtencionMinutos,
                                LocalDate fecha, String diaSemana, Boolean esHabil, String motivoNoHabil,
                                LocalTime horaInicio, LocalTime horaFin, Long capacidadTotal, Long capacidadOcupada,
                                Long capacidadDisponible, String estado, LocalDateTime fechaRegistro,
                                String usuarioRegistro, LocalDateTime fechaActualizacion, String usuarioActualizacion) {
        this.idDisponibilidad = idDisponibilidad;
        this.codigoSede = codigoSede;
        this.nombreSede = nombreSede;
        this.direccionSede = direccionSede;
        this.telefonoSede = telefonoSede;
        this.capacidadDiariaMaxima = capacidadDiariaMaxima;
        this.tiempoAtencionMinutos = tiempoAtencionMinutos;
        this.fecha = fecha;
        this.diaSemana = diaSemana;
        this.esHabil = esHabil;
        this.motivoNoHabil = motivoNoHabil;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.capacidadTotal = capacidadTotal;
        this.capacidadOcupada = capacidadOcupada;
        this.capacidadDisponible = capacidadDisponible;
        this.estado = estado;
        this.fechaRegistro = fechaRegistro;
        this.usuarioRegistro = usuarioRegistro;
        this.fechaActualizacion = fechaActualizacion;
        this.usuarioActualizacion = usuarioActualizacion;
    }

    public String getIdDisponibilidad() {
        return idDisponibilidad;
    }

    public void setIdDisponibilidad(String idDisponibilidad) {
        this.idDisponibilidad = idDisponibilidad;
    }

    public String getCodigoSede() {
        return codigoSede;
    }

    public void setCodigoSede(String codigoSede) {
        this.codigoSede = codigoSede;
    }

    public String getNombreSede() {
        return nombreSede;
    }

    public void setNombreSede(String nombreSede) {
        this.nombreSede = nombreSede;
    }

    public String getDireccionSede() {
        return direccionSede;
    }

    public void setDireccionSede(String direccionSede) {
        this.direccionSede = direccionSede;
    }

    public String getTelefonoSede() {
        return telefonoSede;
    }

    public void setTelefonoSede(String telefonoSede) {
        this.telefonoSede = telefonoSede;
    }

    public Long getCapacidadDiariaMaxima() {
        return capacidadDiariaMaxima;
    }

    public void setCapacidadDiariaMaxima(Long capacidadDiariaMaxima) {
        this.capacidadDiariaMaxima = capacidadDiariaMaxima;
    }

    public Long getTiempoAtencionMinutos() {
        return tiempoAtencionMinutos;
    }

    public void setTiempoAtencionMinutos(Long tiempoAtencionMinutos) {
        this.tiempoAtencionMinutos = tiempoAtencionMinutos;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
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

    public Long getCapacidadTotal() {
        return capacidadTotal;
    }

    public void setCapacidadTotal(Long capacidadTotal) {
        this.capacidadTotal = capacidadTotal;
    }

    public Long getCapacidadOcupada() {
        return capacidadOcupada;
    }

    public void setCapacidadOcupada(Long capacidadOcupada) {
        this.capacidadOcupada = capacidadOcupada;
    }

    public Long getCapacidadDisponible() {
        return capacidadDisponible;
    }

    public void setCapacidadDisponible(Long capacidadDisponible) {
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
