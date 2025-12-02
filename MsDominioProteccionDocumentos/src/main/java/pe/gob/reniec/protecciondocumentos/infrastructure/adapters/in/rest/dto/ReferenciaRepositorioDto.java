package pe.gob.reniec.protecciondocumentos.infrastructure.adapters.in.rest.dto;

public record ReferenciaRepositorioDto(
    String repositorioId,
    String documentoId,
    String versionId
) {}
