package pe.gob.reniec.dominio.parentesco.domain.model;

import java.time.LocalDate;

public class CiudadanoAnalizado {
    private String idCiudadano;
    private String nombreCompleto;
    private LocalDate fechaNacimiento;
    private String estadoCivil;
    private DatosAPD datosAPD;

    public CiudadanoAnalizado() {
    }

    public CiudadanoAnalizado(String idCiudadano, String nombreCompleto, LocalDate fechaNacimiento,
                             String estadoCivil, DatosAPD datosAPD) {
        this.idCiudadano = idCiudadano;
        this.nombreCompleto = nombreCompleto;
        this.fechaNacimiento = fechaNacimiento;
        this.estadoCivil = estadoCivil;
        this.datosAPD = datosAPD;
    }

    public String getIdCiudadano() {
        return idCiudadano;
    }

    public void setIdCiudadano(String idCiudadano) {
        this.idCiudadano = idCiudadano;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public DatosAPD getDatosAPD() {
        return datosAPD;
    }

    public void setDatosAPD(DatosAPD datosAPD) {
        this.datosAPD = datosAPD;
    }
}
