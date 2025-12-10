package pe.gob.reniec.hechosVitales.domain.model;

import java.util.Objects;

/**
 * Value Object: CriterioBusqueda
 * 
 * Representa los criterios válidos para buscar un certificado.
 * Reemplaza al anémico RequestParams.
 */
public class CriterioBusqueda {
    
    private final String codigoEntidad;
    private final CertificadoId numeroCnv;
    private final TipoDocumento tipoDocumento;
    
    public CriterioBusqueda(String codigoEntidad, String numeroCnv, String tipoDocumento) {
        this.codigoEntidad = Objects.requireNonNull(codigoEntidad, "El código de entidad es obligatorio");
        if (codigoEntidad.length() != 11) {
            throw new IllegalArgumentException("El código de entidad debe tener 11 caracteres");
        }
        
        this.numeroCnv = new CertificadoId(numeroCnv);
        this.tipoDocumento = TipoDocumento.fromCodigo(tipoDocumento);
    }
    
    public String getCodigoEntidad() {
        return codigoEntidad;
    }
    
    public CertificadoId getNumeroCnv() {
        return numeroCnv;
    }
    
    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }
}
