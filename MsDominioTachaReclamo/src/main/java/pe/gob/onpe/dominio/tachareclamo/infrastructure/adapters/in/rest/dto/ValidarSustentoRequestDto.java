package pe.gob.onpe.dominio.tachareclamo.infrastructure.adapters.in.rest.dto;

import java.util.List;

public class ValidarSustentoRequestDto {
    private Long tachaReclamoId;
    private String sustento;
    private List<String> documentos;

    public ValidarSustentoRequestDto() {
    }

    public Long getTachaReclamoId() {
        return tachaReclamoId;
    }

    public void setTachaReclamoId(Long tachaReclamoId) {
        this.tachaReclamoId = tachaReclamoId;
    }

    public String getSustento() {
        return sustento;
    }

    public void setSustento(String sustento) {
        this.sustento = sustento;
    }

    public List<String> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(List<String> documentos) {
        this.documentos = documentos;
    }
}
