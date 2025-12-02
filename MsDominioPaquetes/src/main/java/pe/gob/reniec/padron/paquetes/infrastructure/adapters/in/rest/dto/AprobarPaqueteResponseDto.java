package pe.gob.reniec.padron.paquetes.infrastructure.adapters.in.rest.dto;

public record AprobarPaqueteResponseDto(
    Boolean success,
    AprobacionDataDto data,
    MetadataDto metadata
) {
    public record AprobacionDataDto(
        String paqueteId,
        String codigoPaquete,
        String estadoAnterior,
        String estadoActual,
        AprobacionDto aprobacion,
        InformacionPublicacionDto informacionPublicacion,
        TrazabilidadDto trazabilidad,
        LinksDto links
    ) {
        public record LinksDto(
                String self,
                String paquete,
                String listaPaquetes
        ) {}
    }
}
