package pe.gob.reniec.padron.paquetes.infrastructure.adapters.in.rest.dto;

public record ConfirmarRevisionResponseDto(
    Boolean success,
    ConfirmacionDataDto data,
    MetadataDto metadata
) {
    public record ConfirmacionDataDto(
        String idPadron,
        String tipoPadron,
        String codigoCronogramaElectoral,
        String estadoRevisionAnterior,
        String estadoRevisionActual,
        ConfirmacionDto confirmacion,
        ResumenPaquetesDto resumenPaquetes,
        SiguientePasoDto siguientePaso,
        TrazabilidadDto trazabilidad,
        LinksDto links
    ) {
        public record LinksDto(
                String self,
                String padron,
                String paquetes,
                String generarDocuemnto
        ) {}
    }
}
