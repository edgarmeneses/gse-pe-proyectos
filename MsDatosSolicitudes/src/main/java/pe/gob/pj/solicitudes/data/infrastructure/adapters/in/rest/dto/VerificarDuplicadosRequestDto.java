package pe.gob.pj.solicitudes.data.infrastructure.adapters.in.rest.dto;

public final class VerificarDuplicadosRequestDto {
    private final String solicitudId;
    private final String fechaDesde;
    private final String fechaHasta;
    private final String tipoEvento;
    private final String usuarioId;
    private final Long limit;
    private final Long offset;
    private final String ordenamiento;
    private final Boolean incluirDatosDetallados;

    public VerificarDuplicadosRequestDto(String solicitudId, String fechaDesde, String fechaHasta, String tipoEvento, String usuarioId, Long limit, Long offset, String ordenamiento, Boolean incluirDatosDetallados) {
        this.solicitudId = solicitudId;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        this.tipoEvento = tipoEvento;
        this.usuarioId = usuarioId;
        this.limit = limit;
        this.offset = offset;
        this.ordenamiento = ordenamiento;
        this.incluirDatosDetallados = incluirDatosDetallados;
    }

    public String solicitudId() { return solicitudId; }
    public String fechaDesde() { return fechaDesde; }
    public String fechaHasta() { return fechaHasta; }
    public String tipoEvento() { return tipoEvento; }
    public String usuarioId() { return usuarioId; }
    public Long limit() { return limit; }
    public Long offset() { return offset; }
    public String ordenamiento() { return ordenamiento; }
    public Boolean incluirDatosDetallados() { return incluirDatosDetallados; }
}
