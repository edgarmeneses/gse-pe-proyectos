package pe.gob.reniec.siirc.msadaptadorpki.domain.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Aggregate Root: Representa un certificado digital del DNI Electrónico.
 * Contiene la lógica de negocio relacionada con el ciclo de vida del certificado.
 */
public class CertificadoDigital {
    private final TipoCertificado tipo;
    private final NumeroSolicitud numeroSolicitud;
    private NumeroCertificado numeroCertificado;
    private final Ciudadano ciudadano;
    private final String codigoOficina;
    private final String numeroSerie;
    private PeriodoValidez periodoValidez;
    private EstadoCertificado estado;
    private MotivoRevocacion motivoRevocacion;
    private final ClavePublica clavePublica;
    private String certificadoPEM;

    private CertificadoDigital(TipoCertificado tipo, NumeroSolicitud numeroSolicitud, Ciudadano ciudadano,
                              String codigoOficina, String numeroSerie, ClavePublica clavePublica) {
        this.tipo = tipo;
        this.numeroSolicitud = numeroSolicitud;
        this.ciudadano = ciudadano;
        this.codigoOficina = codigoOficina;
        this.numeroSerie = numeroSerie;
        this.clavePublica = clavePublica;
        this.estado = EstadoCertificado.PENDIENTE;
    }

    /**
     * Factory Method: Crea un nuevo certificado en estado pendiente.
     */
    public static CertificadoDigital crear(TipoCertificado tipo, NumeroSolicitud numeroSolicitud,
                                          Ciudadano ciudadano, String codigoOficina, 
                                          String numeroSerie, ClavePublica clavePublica) {
        if (tipo == null || numeroSolicitud == null || ciudadano == null) {
            throw new IllegalArgumentException("Los datos obligatorios del certificado no pueden ser nulos");
        }
        return new CertificadoDigital(tipo, numeroSolicitud, ciudadano, codigoOficina, numeroSerie, clavePublica);
    }

    /**
     * Emite el certificado con número y período de validez.
     * Regla de negocio: Solo se puede emitir un certificado pendiente.
     */
    public void emitir(NumeroCertificado numeroCertificado, LocalDateTime fechaEmision, 
                      LocalDateTime fechaExpiracion, String certificadoPEM) {
        if (this.estado != EstadoCertificado.PENDIENTE) {
            throw new IllegalStateException("Solo se puede emitir un certificado en estado PENDIENTE");
        }
        if (fechaExpiracion.isBefore(fechaEmision)) {
            throw new IllegalArgumentException("La fecha de expiración debe ser posterior a la fecha de emisión");
        }
        
        this.numeroCertificado = numeroCertificado;
        this.periodoValidez = new PeriodoValidez(fechaEmision, fechaExpiracion);
        this.certificadoPEM = certificadoPEM;
        this.estado = EstadoCertificado.VIGENTE;
    }

    /**
     * Revoca el certificado por un motivo específico.
     * Regla de negocio: Solo se puede revocar un certificado vigente.
     */
    public void revocar(MotivoRevocacion motivo) {
        if (this.estado != EstadoCertificado.VIGENTE) {
            throw new IllegalStateException("Solo se puede revocar un certificado VIGENTE");
        }
        if (motivo == null) {
            throw new IllegalArgumentException("Debe especificar un motivo de revocación");
        }
        
        this.motivoRevocacion = motivo;
        this.estado = EstadoCertificado.REVOCADO;
    }

    /**
     * Verifica si el certificado está vigente.
     * Regla de negocio: Un certificado está vigente si su estado es VIGENTE y no ha expirado.
     */
    public boolean estaVigente() {
        if (this.estado != EstadoCertificado.VIGENTE) {
            return false;
        }
        if (this.periodoValidez == null) {
            return false;
        }
        return this.periodoValidez.estaVigente();
    }

    /**
     * Verifica si el certificado ha expirado.
     */
    public boolean haExpirado() {
        if (this.periodoValidez == null) {
            return false;
        }
        return this.periodoValidez.haExpirado();
    }

    /**
     * Marca el certificado como expirado si la fecha actual supera la fecha de expiración.
     */
    public void verificarExpiracion() {
        if (this.estado == EstadoCertificado.VIGENTE && haExpirado()) {
            this.estado = EstadoCertificado.EXPIRADO;
        }
    }

    /**
     * Obtiene los días restantes de validez del certificado.
     */
    public long diasRestantesValidez() {
        if (this.periodoValidez == null || this.estado != EstadoCertificado.VIGENTE) {
            return 0;
        }
        return this.periodoValidez.diasRestantes();
    }

    // Getters de solo lectura (inmutabilidad de agregados)
    public TipoCertificado getTipo() {
        return tipo;
    }

    public NumeroSolicitud getNumeroSolicitud() {
        return numeroSolicitud;
    }

    public NumeroCertificado getNumeroCertificado() {
        return numeroCertificado;
    }

    public Ciudadano getCiudadano() {
        return ciudadano;
    }

    public String getCodigoOficina() {
        return codigoOficina;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public PeriodoValidez getPeriodoValidez() {
        return periodoValidez;
    }

    public EstadoCertificado getEstado() {
        return estado;
    }

    public MotivoRevocacion getMotivoRevocacion() {
        return motivoRevocacion;
    }

    public ClavePublica getClavePublica() {
        return clavePublica;
    }

    public String getCertificadoPEM() {
        return certificadoPEM;
    }
}
