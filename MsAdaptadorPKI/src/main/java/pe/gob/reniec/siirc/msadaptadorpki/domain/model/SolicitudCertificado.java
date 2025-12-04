package pe.gob.reniec.siirc.msadaptadorpki.domain.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Aggregate: Representa una solicitud completa de certificados digitales.
 * Agrupa los tres tipos de certificados (autenticación, firma, cifrado) con sus datos adicionales.
 * Contiene las reglas de negocio para la generación coordinada de certificados.
 */
public class SolicitudCertificado {
    private final String numeroCertificados;
    private final CertificadoDigital certificadoAutenticacion;
    private final CertificadoDigital certificadoFirma;
    private final CertificadoDigital certificadoCifrado;
    private final ContactoCiudadano contactoCiudadano;
    private final String observaciones;

    private SolicitudCertificado(String numeroCertificados, 
                                CertificadoDigital certificadoAutenticacion,
                                CertificadoDigital certificadoFirma, 
                                CertificadoDigital certificadoCifrado,
                                ContactoCiudadano contactoCiudadano,
                                String observaciones) {
        this.numeroCertificados = numeroCertificados;
        this.certificadoAutenticacion = certificadoAutenticacion;
        this.certificadoFirma = certificadoFirma;
        this.certificadoCifrado = certificadoCifrado;
        this.contactoCiudadano = contactoCiudadano;
        this.observaciones = observaciones;
    }

    /**
     * Factory Method: Crea una solicitud de certificados completa.
     * Regla de negocio: Deben proporcionarse los tres tipos de certificados.
     */
    public static SolicitudCertificado crear(String numeroCertificados,
                                            CertificadoDigital autenticacion,
                                            CertificadoDigital firma,
                                            CertificadoDigital cifrado,
                                            ContactoCiudadano contacto,
                                            String observaciones) {
        if (autenticacion == null || firma == null || cifrado == null) {
            throw new IllegalArgumentException("Deben proporcionarse los tres tipos de certificados");
        }
        
        // Validar que los certificados sean del tipo correcto
        if (autenticacion.getTipo() != TipoCertificado.AUTENTICACION) {
            throw new IllegalArgumentException("El certificado de autenticación no es del tipo correcto");
        }
        if (firma.getTipo() != TipoCertificado.FIRMA) {
            throw new IllegalArgumentException("El certificado de firma no es del tipo correcto");
        }
        if (cifrado.getTipo() != TipoCertificado.CIFRADO) {
            throw new IllegalArgumentException("El certificado de cifrado no es del tipo correcto");
        }
        
        // Validar que todos los certificados sean del mismo ciudadano
        if (!autenticacion.getCiudadano().equals(firma.getCiudadano()) ||
            !autenticacion.getCiudadano().equals(cifrado.getCiudadano())) {
            throw new IllegalArgumentException("Todos los certificados deben pertenecer al mismo ciudadano");
        }
        
        return new SolicitudCertificado(numeroCertificados, autenticacion, firma, cifrado, 
                                       contacto, observaciones);
    }

    /**
     * Obtiene todos los certificados de la solicitud en una lista.
     */
    public List<CertificadoDigital> obtenerTodosCertificados() {
        List<CertificadoDigital> certificados = new ArrayList<>();
        certificados.add(certificadoAutenticacion);
        certificados.add(certificadoFirma);
        certificados.add(certificadoCifrado);
        return Collections.unmodifiableList(certificados);
    }

    /**
     * Verifica si todos los certificados están vigentes.
     */
    public boolean todosVigentes() {
        return certificadoAutenticacion.estaVigente() &&
               certificadoFirma.estaVigente() &&
               certificadoCifrado.estaVigente();
    }

    /**
     * Verifica si algún certificado ha expirado.
     */
    public boolean algunoExpirado() {
        return certificadoAutenticacion.haExpirado() ||
               certificadoFirma.haExpirado() ||
               certificadoCifrado.haExpirado();
    }

    /**
     * Obtiene el ciudadano titular de los certificados.
     */
    public Ciudadano getCiudadano() {
        return certificadoAutenticacion.getCiudadano();
    }

    public String getNumeroCertificados() {
        return numeroCertificados;
    }

    public CertificadoDigital getCertificadoAutenticacion() {
        return certificadoAutenticacion;
    }

    public CertificadoDigital getCertificadoFirma() {
        return certificadoFirma;
    }

    public CertificadoDigital getCertificadoCifrado() {
        return certificadoCifrado;
    }

    public ContactoCiudadano getContactoCiudadano() {
        return contactoCiudadano;
    }

    public String getObservaciones() {
        return observaciones;
    }
}
