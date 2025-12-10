package pe.gob.reniec.externo.MsAdaptadorIntegracionesExternas.domain.model.migraciones;

import pe.gob.reniec.externo.MsAdaptadorIntegracionesExternas.domain.model.common.ErrorResponse;
import pe.gob.reniec.externo.MsAdaptadorIntegracionesExternas.domain.model.common.Metadata;

public class RespuestaMigraciones {
    private RespuestaMigratoria respuestaMigratoria;
    private Metadata metadata;
    private ErrorResponse error;

    public RespuestaMigraciones() {}

    public RespuestaMigratoria getRespuestaMigratoria() { return respuestaMigratoria; }
    public void setRespuestaMigratoria(RespuestaMigratoria respuestaMigratoria) { this.respuestaMigratoria = respuestaMigratoria; }

    public Metadata getMetadata() { return metadata; }
    public void setMetadata(Metadata metadata) { this.metadata = metadata; }

    public ErrorResponse getError() { return error; }
    public void setError(ErrorResponse error) { this.error = error; }
}
