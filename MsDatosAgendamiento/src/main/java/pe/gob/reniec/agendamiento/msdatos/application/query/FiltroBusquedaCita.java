package pe.gob.reniec.agendamiento.msdatos.application.query;

import java.time.LocalDate;

/**
 * FiltroBusquedaCita - Query Object (Application Layer)
 * Representa los criterios de búsqueda para listar citas.
 * No es parte del dominio, es un concepto de aplicación para consultas.
 */
public class FiltroBusquedaCita {
    private String codigoSede;
    private String estado;
    private String dniSolicitante;
    private String numeroTramite;
    private String idTecnico;
    private LocalDate fechaDesde;
    private LocalDate fechaHasta;
    private Integer pagina;
    private Integer tamanoPagina;
    private String ordenarPor;
    private String direccionOrden; // ASC, DESC

    public FiltroBusquedaCita() {
    }

    public String getCodigoSede() {
        return codigoSede;
    }

    public void setCodigoSede(String codigoSede) {
        this.codigoSede = codigoSede;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDniSolicitante() {
        return dniSolicitante;
    }

    public void setDniSolicitante(String dniSolicitante) {
        this.dniSolicitante = dniSolicitante;
    }

    public String getNumeroTramite() {
        return numeroTramite;
    }

    public void setNumeroTramite(String numeroTramite) {
        this.numeroTramite = numeroTramite;
    }

    public String getIdTecnico() {
        return idTecnico;
    }

    public void setIdTecnico(String idTecnico) {
        this.idTecnico = idTecnico;
    }

    public LocalDate getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(LocalDate fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public LocalDate getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(LocalDate fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public Integer getPagina() {
        return pagina;
    }

    public void setPagina(Integer pagina) {
        this.pagina = pagina;
    }

    public Integer getTamanoPagina() {
        return tamanoPagina;
    }

    public void setTamanoPagina(Integer tamanoPagina) {
        this.tamanoPagina = tamanoPagina;
    }

    public String getOrdenarPor() {
        return ordenarPor;
    }

    public void setOrdenarPor(String ordenarPor) {
        this.ordenarPor = ordenarPor;
    }

    public String getDireccionOrden() {
        return direccionOrden;
    }

    public void setDireccionOrden(String direccionOrden) {
        this.direccionOrden = direccionOrden;
    }
}
