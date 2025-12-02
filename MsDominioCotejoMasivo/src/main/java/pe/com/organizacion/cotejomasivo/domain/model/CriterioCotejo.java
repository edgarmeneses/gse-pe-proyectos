package pe.com.organizacion.cotejomasivo.domain.model;

/**
 * Value Object: CriterioCotejo
 * Representa un criterio de cotejo con campo, operador y valor
 */
public class CriterioCotejo {
    
    private String campo;
    private String operador;
    private String valor;
    
    public CriterioCotejo() {
    }
    
    public CriterioCotejo(String campo, String operador, String valor) {
        this.campo = campo;
        this.operador = operador;
        this.valor = valor;
    }
    
    public String getCampo() {
        return campo;
    }
    
    public void setCampo(String campo) {
        this.campo = campo;
    }
    
    public String getOperador() {
        return operador;
    }
    
    public void setOperador(String operador) {
        this.operador = operador;
    }
    
    public String getValor() {
        return valor;
    }
    
    public void setValor(String valor) {
        this.valor = valor;
    }
}
