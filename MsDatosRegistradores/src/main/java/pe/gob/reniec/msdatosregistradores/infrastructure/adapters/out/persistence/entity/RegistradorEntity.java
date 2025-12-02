package pe.gob.reniec.msdatosregistradores.infrastructure.adapters.out.persistence.entity;

import java.time.LocalDateTime;
import java.util.List;

public class RegistradorEntity {
    private String idRegistrador;
    private String numeroDni;
    private String primerApellido;
    private String segundoApellido;
    private String prenombres;
    private String nombreCompleto;
    private String numeroImagen;
    private String codigoLocal;
    private String descripcionLocal;
    private String codigoEstadoRegistrador;
    private String descripcionEstado;
    private LocalDateTime fechaAsignacion;
    private Boolean tieneFirmaRegistrada;
    private String hashFirma;
    private LocalDateTime fechaUltimaActualizacionFirma;
    private Boolean tieneSellosRegistrado;
    private String hashSello;
    private LocalDateTime fechaUltimaActualizacionSello;
    private String usuarioCreacion;
    private LocalDateTime fechaCreacion;
    private String usuarioModificacion;
    private LocalDateTime fechaModificacion;

    public RegistradorEntity() {
    }

    public String getIdRegistrador() {
        return idRegistrador;
    }

    public void setIdRegistrador(String idRegistrador) {
        this.idRegistrador = idRegistrador;
    }

    public String getNumeroDni() {
        return numeroDni;
    }

    public void setNumeroDni(String numeroDni) {
        this.numeroDni = numeroDni;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getPrenombres() {
        return prenombres;
    }

    public void setPrenombres(String prenombres) {
        this.prenombres = prenombres;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getNumeroImagen() {
        return numeroImagen;
    }

    public void setNumeroImagen(String numeroImagen) {
        this.numeroImagen = numeroImagen;
    }

    public String getCodigoLocal() {
        return codigoLocal;
    }

    public void setCodigoLocal(String codigoLocal) {
        this.codigoLocal = codigoLocal;
    }

    public String getDescripcionLocal() {
        return descripcionLocal;
    }

    public void setDescripcionLocal(String descripcionLocal) {
        this.descripcionLocal = descripcionLocal;
    }

    public String getCodigoEstadoRegistrador() {
        return codigoEstadoRegistrador;
    }

    public void setCodigoEstadoRegistrador(String codigoEstadoRegistrador) {
        this.codigoEstadoRegistrador = codigoEstadoRegistrador;
    }

    public String getDescripcionEstado() {
        return descripcionEstado;
    }

    public void setDescripcionEstado(String descripcionEstado) {
        this.descripcionEstado = descripcionEstado;
    }

    public LocalDateTime getFechaAsignacion() {
        return fechaAsignacion;
    }

    public void setFechaAsignacion(LocalDateTime fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }

    public Boolean getTieneFirmaRegistrada() {
        return tieneFirmaRegistrada;
    }

    public void setTieneFirmaRegistrada(Boolean tieneFirmaRegistrada) {
        this.tieneFirmaRegistrada = tieneFirmaRegistrada;
    }

    public String getHashFirma() {
        return hashFirma;
    }

    public void setHashFirma(String hashFirma) {
        this.hashFirma = hashFirma;
    }

    public LocalDateTime getFechaUltimaActualizacionFirma() {
        return fechaUltimaActualizacionFirma;
    }

    public void setFechaUltimaActualizacionFirma(LocalDateTime fechaUltimaActualizacionFirma) {
        this.fechaUltimaActualizacionFirma = fechaUltimaActualizacionFirma;
    }

    public Boolean getTieneSellosRegistrado() {
        return tieneSellosRegistrado;
    }

    public void setTieneSellosRegistrado(Boolean tieneSellosRegistrado) {
        this.tieneSellosRegistrado = tieneSellosRegistrado;
    }

    public String getHashSello() {
        return hashSello;
    }

    public void setHashSello(String hashSello) {
        this.hashSello = hashSello;
    }

    public LocalDateTime getFechaUltimaActualizacionSello() {
        return fechaUltimaActualizacionSello;
    }

    public void setFechaUltimaActualizacionSello(LocalDateTime fechaUltimaActualizacionSello) {
        this.fechaUltimaActualizacionSello = fechaUltimaActualizacionSello;
    }

    public String getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getUsuarioModificacion() {
        return usuarioModificacion;
    }

    public void setUsuarioModificacion(String usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }

    public LocalDateTime getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(LocalDateTime fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }
}
