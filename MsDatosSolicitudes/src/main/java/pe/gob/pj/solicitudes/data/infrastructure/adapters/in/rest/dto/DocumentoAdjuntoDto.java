package pe.gob.pj.solicitudes.data.infrastructure.adapters.in.rest.dto;

public final class DocumentoAdjuntoDto {
    private final String tipo;
    private final String nombre;
    private final Long tamanioBytes;
    private final String mimeType;
    private final String checksum;

    public DocumentoAdjuntoDto(String tipo, String nombre, Long tamanioBytes, String mimeType, String checksum) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.tamanioBytes = tamanioBytes;
        this.mimeType = mimeType;
        this.checksum = checksum;
    }

    public String tipo() { return tipo; }
    public String nombre() { return nombre; }
    public Long tamanioBytes() { return tamanioBytes; }
    public String mimeType() { return mimeType; }
    public String checksum() { return checksum; }
}
