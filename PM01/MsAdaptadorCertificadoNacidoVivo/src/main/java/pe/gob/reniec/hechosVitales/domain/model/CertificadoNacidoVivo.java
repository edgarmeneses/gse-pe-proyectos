package pe.gob.reniec.hechosVitales.domain.model;

import java.util.Objects;

/**
 * Aggregate Root: CertificadoNacidoVivo
 * 
 * Representa un Certificado de Nacido Vivo como concepto de dominio,
 * encapsulando sus reglas de negocio y garantizando la integridad de sus datos.
 */
public class CertificadoNacidoVivo {
    
    private final CertificadoId id;
    private final Madre madre;
    private final Nacimiento nacimiento;
    private final Sexo sexo;
    private final String codigoRespuesta;
    private final String descripcionRespuesta;
    
    public CertificadoNacidoVivo(CertificadoId id, Madre madre, Nacimiento nacimiento, Sexo sexo, String codigoRespuesta, String descripcionRespuesta) {
        this.id = Objects.requireNonNull(id, "El ID del certificado es obligatorio");
        this.madre = Objects.requireNonNull(madre, "Los datos de la madre son obligatorios");
        this.nacimiento = Objects.requireNonNull(nacimiento, "Los datos de nacimiento son obligatorios");
        this.sexo = Objects.requireNonNull(sexo, "El sexo es obligatorio");
        this.codigoRespuesta = codigoRespuesta;
        this.descripcionRespuesta = descripcionRespuesta;
    }
    
    public CertificadoId getId() {
        return id;
    }
    
    public Madre getMadre() {
        return madre;
    }
    
    public Nacimiento getNacimiento() {
        return nacimiento;
    }
    
    public Sexo getSexo() {
        return sexo;
    }

    public String getCodigoRespuesta() {
        return codigoRespuesta;
    }

    public String getDescripcionRespuesta() {
        return descripcionRespuesta;
    }
}
