package pe.gob.reniec.siirc.msadaptadorpki.infrastructure.adapters.in.rest.dto;

public class GenerarCertificadoDigitalRequestDto {
    private String numeroCertificados;
    private CertificadoDigitalRequestDto certificadoAutenticacion;
    private CertificadoDigitalRequestDto certificadoFirma;
    private CertificadoDigitalRequestDto certificadoCifrado;
    private DatosAdicionalesDto datosAdicionales;

    public GenerarCertificadoDigitalRequestDto() {
    }

    public String getNumeroCertificados() {
        return numeroCertificados;
    }

    public void setNumeroCertificados(String numeroCertificados) {
        this.numeroCertificados = numeroCertificados;
    }

    public CertificadoDigitalRequestDto getCertificadoAutenticacion() {
        return certificadoAutenticacion;
    }

    public void setCertificadoAutenticacion(CertificadoDigitalRequestDto certificadoAutenticacion) {
        this.certificadoAutenticacion = certificadoAutenticacion;
    }

    public CertificadoDigitalRequestDto getCertificadoFirma() {
        return certificadoFirma;
    }

    public void setCertificadoFirma(CertificadoDigitalRequestDto certificadoFirma) {
        this.certificadoFirma = certificadoFirma;
    }

    public CertificadoDigitalRequestDto getCertificadoCifrado() {
        return certificadoCifrado;
    }

    public void setCertificadoCifrado(CertificadoDigitalRequestDto certificadoCifrado) {
        this.certificadoCifrado = certificadoCifrado;
    }

    public DatosAdicionalesDto getDatosAdicionales() {
        return datosAdicionales;
    }

    public void setDatosAdicionales(DatosAdicionalesDto datosAdicionales) {
        this.datosAdicionales = datosAdicionales;
    }
}
