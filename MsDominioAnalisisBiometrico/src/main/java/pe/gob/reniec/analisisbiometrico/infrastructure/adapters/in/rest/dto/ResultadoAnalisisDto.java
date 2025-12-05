package pe.gob.reniec.analisisbiometrico.infrastructure.adapters.in.rest.dto;

import java.util.List;

/**
 * DTO para resultado de análisis biométrico
 */
public class ResultadoAnalisisDto {

    private String dni;
    private String identidadConfirmadaHuellas;
    private String identidadConfirmadaFotos;
    private List<String> observaciones;
    private List<IdentidadEncontradaConHuellasDto> identidadesEncontradasConHuellas;
    private List<IdentidadEncontradaConFotosDto> identidadesEncontradasConFotos;

    public ResultadoAnalisisDto() {
    }

    public ResultadoAnalisisDto(String dni, String identidadConfirmadaHuellas,
                               String identidadConfirmadaFotos, List<String> observaciones,
                               List<IdentidadEncontradaConHuellasDto> identidadesEncontradasConHuellas,
                               List<IdentidadEncontradaConFotosDto> identidadesEncontradasConFotos) {
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

    public List<IdentidadEncontradaConHuellasDto> getIdentidadesEncontradasConHuellas() {
        return identidadesEncontradasConHuellas;
    }

    public void setIdentidadesEncontradasConHuellas(List<IdentidadEncontradaConHuellasDto> identidadesEncontradasConHuellas) {
        this.identidadesEncontradasConHuellas = identidadesEncontradasConHuellas;
    }

    public List<IdentidadEncontradaConFotosDto> getIdentidadesEncontradasConFotos() {
        return identidadesEncontradasConFotos;
    }

    public void setIdentidadesEncontradasConFotos(List<IdentidadEncontradaConFotosDto> identidadesEncontradasConFotos) {
        this.identidadesEncontradasConFotos = identidadesEncontradasConFotos;
    }
}
