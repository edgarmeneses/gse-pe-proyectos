package pe.gob.reniec.protecciondocumentos.infrastructure.adapters.in.rest.dto;

import java.time.LocalDateTime;
import java.util.List;

public class SolicitudProteccionRequestDto {
    private String solicitudId;
    private String tipoOperacion;
    private LocalDateTime fechaSolicitud;
    private FuenteDocumentoDto fuente;
    private List<MetadatosDocumentoDto> documentos;
    private ConfiguracionProteccionDto configuracion;
    private List<DestinatarioDto> destinatarios;

    public SolicitudProteccionRequestDto() {
    }

    public String getSolicitudId() {
        return solicitudId;
    }

    public void setSolicitudId(String solicitudId) {
        this.solicitudId = solicitudId;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public LocalDateTime getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(LocalDateTime fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public FuenteDocumentoDto getFuente() {
        return fuente;
    }

    public void setFuente(FuenteDocumentoDto fuente) {
        this.fuente = fuente;
    }

    public List<MetadatosDocumentoDto> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(List<MetadatosDocumentoDto> documentos) {
        this.documentos = documentos;
    }

    public ConfiguracionProteccionDto getConfiguracion() {
        return configuracion;
    }

    public void setConfiguracion(ConfiguracionProteccionDto configuracion) {
        this.configuracion = configuracion;
    }

    public List<DestinatarioDto> getDestinatarios() {
        return destinatarios;
    }

    public void setDestinatarios(List<DestinatarioDto> destinatarios) {
        this.destinatarios = destinatarios;
    }

    public static class FuenteDocumentoDto {
        private String tipo;
        private String origen;
        private ReferenciaRepositorioDto referencia;

        public FuenteDocumentoDto() {
        }

        public String getTipo() {
            return tipo;
        }

        public void setTipo(String tipo) {
            this.tipo = tipo;
        }

        public String getOrigen() {
            return origen;
        }

        public void setOrigen(String origen) {
            this.origen = origen;
        }

        public ReferenciaRepositorioDto getReferencia() {
            return referencia;
        }

        public void setReferencia(ReferenciaRepositorioDto referencia) {
            this.referencia = referencia;
        }
    }

    public static class ReferenciaRepositorioDto {
        private String sistema;
        private String transaccionId;
        private String codigoSeguimiento;

        public ReferenciaRepositorioDto() {
        }

        public String getSistema() {
            return sistema;
        }

        public void setSistema(String sistema) {
            this.sistema = sistema;
        }

        public String getTransaccionId() {
            return transaccionId;
        }

        public void setTransaccionId(String transaccionId) {
            this.transaccionId = transaccionId;
        }

        public String getCodigoSeguimiento() {
            return codigoSeguimiento;
        }

        public void setCodigoSeguimiento(String codigoSeguimiento) {
            this.codigoSeguimiento = codigoSeguimiento;
        }
    }

    public static class MetadatosDocumentoDto {
        private String documentoId;
        private String nombre;
        private String tipo;
        private Long tamanioBytes;
        private String formatoOriginal;
        private DatosMetadatosDto metadatos;

        public MetadatosDocumentoDto() {
        }

        public String getDocumentoId() {
            return documentoId;
        }

        public void setDocumentoId(String documentoId) {
            this.documentoId = documentoId;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getTipo() {
            return tipo;
        }

        public void setTipo(String tipo) {
            this.tipo = tipo;
        }

        public Long getTamanioBytes() {
            return tamanioBytes;
        }

        public void setTamanioBytes(Long tamanioBytes) {
            this.tamanioBytes = tamanioBytes;
        }

        public String getFormatoOriginal() {
            return formatoOriginal;
        }

        public void setFormatoOriginal(String formatoOriginal) {
            this.formatoOriginal = formatoOriginal;
        }

        public DatosMetadatosDto getMetadatos() {
            return metadatos;
        }

        public void setMetadatos(DatosMetadatosDto metadatos) {
            this.metadatos = metadatos;
        }
    }

    public static class DatosMetadatosDto {
        private String titulo;
        private String descripcion;
        private String autor;
        private LocalDateTime fechaCreacion;
        private String clasificacion;
        private List<String> palabrasClave;

        public DatosMetadatosDto() {
        }

        public String getTitulo() {
            return titulo;
        }

        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }

        public String getAutor() {
            return autor;
        }

        public void setAutor(String autor) {
            this.autor = autor;
        }

        public LocalDateTime getFechaCreacion() {
            return fechaCreacion;
        }

        public void setFechaCreacion(LocalDateTime fechaCreacion) {
            this.fechaCreacion = fechaCreacion;
        }

        public String getClasificacion() {
            return clasificacion;
        }

        public void setClasificacion(String clasificacion) {
            this.clasificacion = clasificacion;
        }

        public List<String> getPalabrasClave() {
            return palabrasClave;
        }

        public void setPalabrasClave(List<String> palabrasClave) {
            this.palabrasClave = palabrasClave;
        }
    }

    public static class ConfiguracionProteccionDto {
        private String nivelCompresion;
        private String algoritmoCifrado;
        private String clavePublica;
        private Boolean incluirMetadatos;
        private Boolean protegerConPassword;
        private String passwordHash;

        public ConfiguracionProteccionDto() {
        }

        public String getNivelCompresion() {
            return nivelCompresion;
        }

        public void setNivelCompresion(String nivelCompresion) {
            this.nivelCompresion = nivelCompresion;
        }

        public String getAlgoritmoCifrado() {
            return algoritmoCifrado;
        }

        public void setAlgoritmoCifrado(String algoritmoCifrado) {
            this.algoritmoCifrado = algoritmoCifrado;
        }

        public String getClavePublica() {
            return clavePublica;
        }

        public void setClavePublica(String clavePublica) {
            this.clavePublica = clavePublica;
        }

        public Boolean getIncluirMetadatos() {
            return incluirMetadatos;
        }

        public void setIncluirMetadatos(Boolean incluirMetadatos) {
            this.incluirMetadatos = incluirMetadatos;
        }

        public Boolean getProtegerConPassword() {
            return protegerConPassword;
        }

        public void setProtegerConPassword(Boolean protegerConPassword) {
            this.protegerConPassword = protegerConPassword;
        }

        public String getPasswordHash() {
            return passwordHash;
        }

        public void setPasswordHash(String passwordHash) {
            this.passwordHash = passwordHash;
        }
    }

    public static class DestinatarioDto {
        private String destinatarioId;
        private String tipo;
        private String nivelAcceso;
        private List<String> permisos;

        public DestinatarioDto() {
        }

        public String getDestinatarioId() {
            return destinatarioId;
        }

        public void setDestinatarioId(String destinatarioId) {
            this.destinatarioId = destinatarioId;
        }

        public String getTipo() {
            return tipo;
        }

        public void setTipo(String tipo) {
            this.tipo = tipo;
        }

        public String getNivelAcceso() {
            return nivelAcceso;
        }

        public void setNivelAcceso(String nivelAcceso) {
            this.nivelAcceso = nivelAcceso;
        }

        public List<String> getPermisos() {
            return permisos;
        }

        public void setPermisos(List<String> permisos) {
            this.permisos = permisos;
        }
    }
}
