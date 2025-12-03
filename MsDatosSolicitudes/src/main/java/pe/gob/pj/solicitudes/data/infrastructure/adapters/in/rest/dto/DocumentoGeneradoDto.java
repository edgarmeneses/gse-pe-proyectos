package pe.gob.pj.solicitudes.data.infrastructure.adapters.in.rest.dto;

public final class DocumentoGeneradoDto {
    private final String tipoDocumento;
    private final String numeroOficio;
    private final String urlDocumento;
    private final Boolean firmadoDigitalmente;
    private final String hash;

    public DocumentoGeneradoDto(String tipoDocumento, String numeroOficio, String urlDocumento, Boolean firmadoDigitalmente, String hash) {
        this.tipoDocumento = tipoDocumento;
        this.numeroOficio = numeroOficio;
        this.urlDocumento = urlDocumento;
        this.firmadoDigitalmente = firmadoDigitalmente;
        this.hash = hash;
    }

    public String tipoDocumento() { return tipoDocumento; }
    public String numeroOficio() { return numeroOficio; }
    public String urlDocumento() { return urlDocumento; }
    public Boolean firmadoDigitalmente() { return firmadoDigitalmente; }
    public String hash() { return hash; }
}
