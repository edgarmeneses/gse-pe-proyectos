package pe.gob.reniec.siirc.msadaptadorpki.domain.model;

/**
 * Value Object: Representa una solicitud para generar números de secuencia de certificados.
 * Agrupa toda la información necesaria del ciudadano para el proceso de registro.
 */
public class SolicitudNumerosSecuencia {
    private final Ciudadano ciudadano;
    private final ContactoCiudadano contacto;
    private final String codigoOficina;
    private final String lugarNacimiento;
    private final String nacionalidad;
    private final Sexo sexo;
    private final EstadoCivil estadoCivil;
    private final String observaciones;

    private SolicitudNumerosSecuencia(Ciudadano ciudadano, ContactoCiudadano contacto, String codigoOficina,
                                     String lugarNacimiento, String nacionalidad, Sexo sexo,
                                     EstadoCivil estadoCivil, String observaciones) {
        this.ciudadano = ciudadano;
        this.contacto = contacto;
        this.codigoOficina = codigoOficina;
        this.lugarNacimiento = lugarNacimiento;
        this.nacionalidad = nacionalidad != null ? nacionalidad : "PERUANA";
        this.sexo = sexo;
        this.estadoCivil = estadoCivil;
        this.observaciones = observaciones;
    }

    /**
     * Factory Method: Crea una solicitud de números de secuencia.
     */
    public static SolicitudNumerosSecuencia crear(Ciudadano ciudadano, ContactoCiudadano contacto,
                                                  String codigoOficina, String lugarNacimiento,
                                                  String nacionalidad, Sexo sexo,
                                                  EstadoCivil estadoCivil, String observaciones) {
        if (ciudadano == null) {
            throw new IllegalArgumentException("El ciudadano no puede ser nulo");
        }
        if (contacto == null) {
            throw new IllegalArgumentException("Los datos de contacto no pueden ser nulos");
        }
        if (codigoOficina == null || codigoOficina.trim().length() != 5) {
            throw new IllegalArgumentException("El código de oficina debe tener exactamente 5 caracteres");
        }
        
        return new SolicitudNumerosSecuencia(ciudadano, contacto, codigoOficina, lugarNacimiento,
                                            nacionalidad, sexo, estadoCivil, observaciones);
    }

    public Ciudadano getCiudadano() {
        return ciudadano;
    }

    public ContactoCiudadano getContacto() {
        return contacto;
    }

    public String getCodigoOficina() {
        return codigoOficina;
    }

    public String getLugarNacimiento() {
        return lugarNacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public String getObservaciones() {
        return observaciones;
    }
}
