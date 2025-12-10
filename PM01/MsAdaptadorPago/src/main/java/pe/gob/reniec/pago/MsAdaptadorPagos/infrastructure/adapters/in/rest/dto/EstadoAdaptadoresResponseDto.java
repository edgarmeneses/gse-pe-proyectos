package pe.gob.reniec.pago.MsAdaptadorPagos.infrastructure.adapters.in.rest.dto;

import java.util.List;

public class EstadoAdaptadoresResponseDto {
    private String timestamp;
    private String estadoGeneral;
    private List<AdaptadorInfoDto> adaptadores;

    public EstadoAdaptadoresResponseDto() {}

    public String getTimestamp() { return timestamp; }
    public void setTimestamp(String timestamp) { this.timestamp = timestamp; }

    public String getEstadoGeneral() { return estadoGeneral; }
    public void setEstadoGeneral(String estadoGeneral) { this.estadoGeneral = estadoGeneral; }

    public List<AdaptadorInfoDto> getAdaptadores() { return adaptadores; }
    public void setAdaptadores(List<AdaptadorInfoDto> adaptadores) { this.adaptadores = adaptadores; }
}
