package pe.gob.reniec.agendamiento.infrastructure.adapters.out.persistence.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

public class ExcepcionHorariaEntity {
    private String idExcepcion;
    private String codigoSede;
    private String nombreSede;
    private LocalDate fechaExcepcion;
    private String tipoExcepcion;
    private String descripcion;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private Long capacidadPorFranja;
    private Long cantidadCitasAfectadas;
    private String accionCitasAfectadas;
    private LocalDateTime fechaRegistro;
    private String usuarioRegistro;

    public ExcepcionHorariaEntity() {
    }

    public ExcepcionHorariaEntity(String idExcepcion, String codigoSede, String nombreSede, LocalDate fechaExcepcion,
                                  String tipoExcepcion, String descripcion, LocalTime horaInicio, LocalTime horaFin,
                                  Long capacidadPorFranja, Long cantidadCitasAfectadas, String accionCitasAfectadas,
                                  LocalDateTime fechaRegistro, String usuarioRegistro) {
        this.idExcepcion = idExcepcion;
        this.codigoSede = codigoSede;
        this.nombreSede = nombreSede;
        this.fechaExcepcion = fechaExcepcion;
        this.tipoExcepcion = tipoExcepcion;
        this.descripcion = descripcion;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.capacidadPorFranja = capacidadPorFranja;
        this.cantidadCitasAfectadas = cantidadCitasAfectadas;
        this.accionCitasAfectadas = accionCitasAfectadas;
        this.fechaRegistro = fechaRegistro;
        this.usuarioRegistro = usuarioRegistro;
    }

    public String getIdExcepcion() {
        return idExcepcion;
    }

    public void setIdExcepcion(String idExcepcion) {
        this.idExcepcion = idExcepcion;
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

    public LocalDate getFechaExcepcion() {
        return fechaExcepcion;
    }

    public void setFechaExcepcion(LocalDate fechaExcepcion) {
        this.fechaExcepcion = fechaExcepcion;
    }

    public String getTipoExcepcion() {
        return tipoExcepcion;
    }

    public void setTipoExcepcion(String tipoExcepcion) {
        this.tipoExcepcion = tipoExcepcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public Long getCapacidadPorFranja() {
        return capacidadPorFranja;
    }

    public void setCapacidadPorFranja(Long capacidadPorFranja) {
        this.capacidadPorFranja = capacidadPorFranja;
    }

    public Long getCantidadCitasAfectadas() {
        return cantidadCitasAfectadas;
    }

    public void setCantidadCitasAfectadas(Long cantidadCitasAfectadas) {
        this.cantidadCitasAfectadas = cantidadCitasAfectadas;
    }

    public String getAccionCitasAfectadas() {
        return accionCitasAfectadas;
    }

    public void setAccionCitasAfectadas(String accionCitasAfectadas) {
        this.accionCitasAfectadas = accionCitasAfectadas;
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
}
