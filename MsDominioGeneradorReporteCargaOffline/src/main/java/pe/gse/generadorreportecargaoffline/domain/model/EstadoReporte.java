package pe.gse.generadorreportecargaoffline.domain.model;

import java.util.List;

/**
 * Value Object: EstadoReporte
 * Representa el estado del reporte generado (firmado o no firmado).
 */
public class EstadoReporte {

    private String tipo;
    private List<String> valor;

    public EstadoReporte() {
    }

    public EstadoReporte(String tipo, List<String> valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<String> getValor() {
        return valor;
    }

    public void setValor(List<String> valor) {
        this.valor = valor;
    }
}
