package pe.gob.reniec.analisisbiometrico.domain.model;

import java.util.List;

/**
 * Aggregate Root: ResultadoAnalisis
 * Representa el resultado del análisis biométrico de un ciudadano
 */
public class ResultadoAnalisis {

    private String dni;
    private String identidadConfirmadaHuellas;
    private String identidadConfirmadaFotos;
    private List<String> observaciones;
    private List<IdentidadEncontradaConHuellas> identidadesEncontradasConHuellas;
    private List<IdentidadEncontradaConFotos> identidadesEncontradasConFotos;

    public ResultadoAnalisis() {
    }

    public ResultadoAnalisis(String dni, String identidadConfirmadaHuellas,
                            String identidadConfirmadaFotos, List<String> observaciones,
                            List<IdentidadEncontradaConHuellas> identidadesEncontradasConHuellas,
                            List<IdentidadEncontradaConFotos> identidadesEncontradasConFotos) {
        this.dni = dni;
        this.identidadConfirmadaHuellas = identidadConfirmadaHuellas;
        this.identidadConfirmadaFotos = identidadConfirmadaFotos;
        this.observaciones = observaciones;
        this.identidadesEncontradasConHuellas = identidadesEncontradasConHuellas;
        this.identidadesEncontradasConFotos = identidadesEncontradasConFotos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getIdentidadConfirmadaHuellas() {
        return identidadConfirmadaHuellas;
    }

    public void setIdentidadConfirmadaHuellas(String identidadConfirmadaHuellas) {
        this.identidadConfirmadaHuellas = identidadConfirmadaHuellas;
    }

    public String getIdentidadConfirmadaFotos() {
        return identidadConfirmadaFotos;
    }

    public void setIdentidadConfirmadaFotos(String identidadConfirmadaFotos) {
        this.identidadConfirmadaFotos = identidadConfirmadaFotos;
    }

    public List<String> getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(List<String> observaciones) {
        this.observaciones = observaciones;
    }

    public List<IdentidadEncontradaConHuellas> getIdentidadesEncontradasConHuellas() {
        return identidadesEncontradasConHuellas;
    }

    public void setIdentidadesEncontradasConHuellas(List<IdentidadEncontradaConHuellas> identidadesEncontradasConHuellas) {
        this.identidadesEncontradasConHuellas = identidadesEncontradasConHuellas;
    }

    public List<IdentidadEncontradaConFotos> getIdentidadesEncontradasConFotos() {
        return identidadesEncontradasConFotos;
    }

    public void setIdentidadesEncontradasConFotos(List<IdentidadEncontradaConFotos> identidadesEncontradasConFotos) {
        this.identidadesEncontradasConFotos = identidadesEncontradasConFotos;
    }
}
