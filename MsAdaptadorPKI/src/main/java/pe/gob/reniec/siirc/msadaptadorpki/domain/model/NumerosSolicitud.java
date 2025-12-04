package pe.gob.reniec.siirc.msadaptadorpki.domain.model;

import java.util.Objects;

/**
 * Value Object: Representa el conjunto de números de solicitud generados
 * para los tres tipos de certificados (autenticación, firma, cifrado).
 */
public class NumerosSolicitud {
    private final NumeroSolicitud numeroSolicitudAutenticacion;
    private final NumeroSolicitud numeroSolicitudFirma;
    private final NumeroSolicitud numeroSolicitudCifrado;

    private NumerosSolicitud(NumeroSolicitud autenticacion, NumeroSolicitud firma, NumeroSolicitud cifrado) {
        this.numeroSolicitudAutenticacion = autenticacion;
        this.numeroSolicitudFirma = firma;
        this.numeroSolicitudCifrado = cifrado;
    }

    public static NumerosSolicitud de(String autenticacion, String firma, String cifrado) {
        return new NumerosSolicitud(
            NumeroSolicitud.de(autenticacion),
            NumeroSolicitud.de(firma),
            NumeroSolicitud.de(cifrado)
        );
    }

    public NumeroSolicitud getNumeroSolicitudAutenticacion() {
        return numeroSolicitudAutenticacion;
    }

    public NumeroSolicitud getNumeroSolicitudFirma() {
        return numeroSolicitudFirma;
    }

    public NumeroSolicitud getNumeroSolicitudCifrado() {
        return numeroSolicitudCifrado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NumerosSolicitud that = (NumerosSolicitud) o;
        return Objects.equals(numeroSolicitudAutenticacion, that.numeroSolicitudAutenticacion) &&
               Objects.equals(numeroSolicitudFirma, that.numeroSolicitudFirma) &&
               Objects.equals(numeroSolicitudCifrado, that.numeroSolicitudCifrado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroSolicitudAutenticacion, numeroSolicitudFirma, numeroSolicitudCifrado);
    }
}
