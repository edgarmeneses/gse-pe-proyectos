package pe.gob.reniec.gse.registradores.infrastructure.adapters.out.persistence.entity;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Entity de persistencia: RegistradorEntity
 * Representa la estructura de datos para persistir un registrador.
 * NOTA: Sin anotaciones JPA - POJO puro.
 */
public class RegistradorEntity {
    
    private String idRegistrador;
    private String numeroDni;
    private String primerApellido;
    private String segundoApellido;
    private String prenombres;
    private String nombreCompleto;
    private String numeroImagen;
    private String codigoLocal;
    private String tipoRegistrador;
    private String observaciones;
    private String codigoEstadoRegistrador;
    private String descripcionLocal;
    private String descripcionEstado;
    
    // Firma
    private Boolean tieneFirmaRegistrada;
    private String hashFirma;
    private LocalDateTime fechaActualizacionFirma;
    
    // Sello
    private Boolean tieneSelloRegistrado;
    private String hashSello;
    private LocalDateTime fechaActualizacionSello;
    
    // Auditoría
    private String usuarioCreacion;
    private LocalDateTime fechaCreacion;
    private String usuarioModificacion;
    private LocalDateTime fechaModificacion;
    
    public RegistradorEntity() {
    }
    
    // Getters y Setters
    
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
    
    public String getTipoRegistrador() {
        return tipoRegistrador;
    }
    
    public void setTipoRegistrador(String tipoRegistrador) {
        this.tipoRegistrador = tipoRegistrador;
    }
    
    public String getObservaciones() {
        return observaciones;
    }
    
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
    public String getCodigoEstadoRegistrador() {
        return codigoEstadoRegistrador;
    }
    
    public void setCodigoEstadoRegistrador(String codigoEstadoRegistrador) {
        this.codigoEstadoRegistrador = codigoEstadoRegistrador;
    }
    
    public String getDescripcionLocal() {
        return descripcionLocal;
    }
    
    public void setDescripcionLocal(String descripcionLocal) {
        this.descripcionLocal = descripcionLocal;
    }
    
    public String getDescripcionEstado() {
        return descripcionEstado;
    }
    
    public void setDescripcionEstado(String descripcionEstado) {
        this.descripcionEstado = descripcionEstado;
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
    
    public LocalDateTime getFechaActualizacionFirma() {
        return fechaActualizacionFirma;
    }
    
    public void setFechaActualizacionFirma(LocalDateTime fechaActualizacionFirma) {
        this.fechaActualizacionFirma = fechaActualizacionFirma;
    }
    
    public Boolean getTieneSelloRegistrado() {
        return tieneSelloRegistrado;
    }
    
    public void setTieneSelloRegistrado(Boolean tieneSelloRegistrado) {
        this.tieneSelloRegistrado = tieneSelloRegistrado;
    }
    
    public String getHashSello() {
        return hashSello;
    }
    
    public void setHashSello(String hashSello) {
        this.hashSello = hashSello;
    }
    
    public LocalDateTime getFechaActualizacionSello() {
        return fechaActualizacionSello;
    }
    
    public void setFechaActualizacionSello(LocalDateTime fechaActualizacionSello) {
        this.fechaActualizacionSello = fechaActualizacionSello;
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
