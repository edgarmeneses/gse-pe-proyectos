package pe.gob.reniec.gse.registradores.infrastructure.adapters.in.rest.dto;

import java.util.List;

/**
 * DTO Response: Lista de Registradores
 */
public class ListaRegistradoresResponseDto {
    private List<RegistradorListadoDto> registradores;
    private PaginacionDto paginacion;

    public ListaRegistradoresResponseDto() {
    }

    public ListaRegistradoresResponseDto(List<RegistradorListadoDto> registradores, PaginacionDto paginacion) {
        this.registradores = registradores;
        this.paginacion = paginacion;
    }

    public List<RegistradorListadoDto> getRegistradores() {
        return registradores;
    }

    public void setRegistradores(List<RegistradorListadoDto> registradores) {
        this.registradores = registradores;
    }

    public PaginacionDto getPaginacion() {
        return paginacion;
    }

    public void setPaginacion(PaginacionDto paginacion) {
        this.paginacion = paginacion;
    }
}
