package pe.gob.reniec.siirc.msadaptadorpki.infrastructure.adapters.in.rest.dto;

public class GenerarNumerosSolicitudResponseDto {
    private String resultado;
    private String mensaje;
    private NumerosSolicitudDto solicitudes;
    private MetadataRespuestaDto metadata;

    public GenerarNumerosSolicitudResponseDto() {
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public NumerosSolicitudDto getSolicitudes() {
        return solicitudes;
    }

    public void setSolicitudes(NumerosSolicitudDto solicitudes) {
        this.solicitudes = solicitudes;
    }

    public MetadataRespuestaDto getMetadata() {
        return metadata;
    }

    public void setMetadata(MetadataRespuestaDto metadata) {
        this.metadata = metadata;
    }
}
