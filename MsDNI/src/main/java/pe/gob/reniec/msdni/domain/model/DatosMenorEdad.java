package pe.gob.reniec.msdni.domain.model;

import java.time.LocalDate;

public class DatosMenorEdad {
    private String cui;
    private String nombresApellidos;
    private LocalDate fechaNacimiento;
    private String lugarNacimiento;
    private String sexo;
    private String fotografia;
    private String domicilio;
    private Progenitor madre;
    private Progenitor padre;

    public DatosMenorEdad() {
    }

    public DatosMenorEdad(String cui, String nombresApellidos, LocalDate fechaNacimiento,
                          String lugarNacimiento, String sexo, String fotografia,
                          String domicilio, Progenitor madre, Progenitor padre) {
        this.cui = cui;
        this.nombresApellidos = nombresApellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.lugarNacimiento = lugarNacimiento;
        this.sexo = sexo;
        this.fotografia = fotografia;
        this.domicilio = domicilio;
        this.madre = madre;
        this.padre = padre;
    }

    public String getCui() {
        return cui;
    }

    public void setCui(String cui) {
        this.cui = cui;
    }

    public String getNombresApellidos() {
        return nombresApellidos;
    }

    public void setNombresApellidos(String nombresApellidos) {
        this.nombresApellidos = nombresApellidos;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getLugarNacimiento() {
        return lugarNacimiento;
    }

    public void setLugarNacimiento(String lugarNacimiento) {
        this.lugarNacimiento = lugarNacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getFotografia() {
        return fotografia;
    }

    public void setFotografia(String fotografia) {
        this.fotografia = fotografia;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public Progenitor getMadre() {
        return madre;
    }

    public void setMadre(Progenitor madre) {
        this.madre = madre;
    }

    public Progenitor getPadre() {
        return padre;
    }

    public void setPadre(Progenitor padre) {
        this.padre = padre;
    }

    public static class Progenitor {
        private String cui;
        private String nombresApellidos;

        public Progenitor() {
        }

        public Progenitor(String cui, String nombresApellidos) {
            this.cui = cui;
            this.nombresApellidos = nombresApellidos;
        }

        public String getCui() {
            return cui;
        }

        public void setCui(String cui) {
            this.cui = cui;
        }

        public String getNombresApellidos() {
            return nombresApellidos;
        }

        public void setNombresApellidos(String nombresApellidos) {
            this.nombresApellidos = nombresApellidos;
        }
    }
}
