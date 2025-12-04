package pe.gob.reniec.siirc.msadaptadorpki.infrastructure.adapters.in.rest.dto;

public class CertificadoDigitalResponseDto {
    private String tipo;
    private String numeroSolicitud;
    private String numeroCertificado;
    private String estadoCertificado;
    private String fechaEmision;
    private String fechaExpiracion;
    private String certificadoPEM;

    public CertificadoDigitalResponseDto() {
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNumeroSolicitud() {
        return numeroSolicitud;
    }

    public void setNumeroSolicitud(String numeroSolicitud) {
        this.numeroSolicitud = numeroSolicitud;
    }

    public String getNumeroCertificado() {
        return numeroCertificado;
    }

    public void setNumeroCertificado(String numeroCertificado) {
        this.numeroCertificado = numeroCertificado;
    }

    public String getEstadoCertificado() {
        return estadoCertificado;
    }

    public void setEstadoCertificado(String estadoCertificado) {
        this.estadoCertificado = estadoCertificado;
    }

    public String getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(String fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public String getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(String fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public String getCertificadoPEM() {
        return certificadoPEM;
    }

    public void setCertificadoPEM(String certificadoPEM) {
        this.certificadoPEM = certificadoPEM;
    }
}
