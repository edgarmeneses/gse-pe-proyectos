package pe.gob.reniec.configuracion.domain.model;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Aggregate Root - Configuracion
 * Representa un parámetro de configuración del sistema
 */
public class Configuracion {

    private String clave;
    private Object valor;
    private String tipoDato;
    private String unidad;
    private String descripcion;
    private Contexto contexto;
    private Validacion validacion;
    private Seguridad seguridad;
    private Sincronizacion sincronizacion;
    private Cache cache;
    private Integer version;
    private String estado;

    public Configuracion() {
    }

    public Configuracion(String clave, Object valor, String tipoDato) {
        this.clave = clave;
        this.valor = valor;
        this.tipoDato = tipoDato;
    }

    // Getters y Setters
    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    public String getTipoDato() {
        return tipoDato;
    }

    public void setTipoDato(String tipoDato) {
        this.tipoDato = tipoDato;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Contexto getContexto() {
        return contexto;
    }

    public void setContexto(Contexto contexto) {
        this.contexto = contexto;
    }

    public Validacion getValidacion() {
        return validacion;
    }

    public void setValidacion(Validacion validacion) {
        this.validacion = validacion;
    }

    public Seguridad getSeguridad() {
        return seguridad;
    }

    public void setSeguridad(Seguridad seguridad) {
        this.seguridad = seguridad;
    }

    public Sincronizacion getSincronizacion() {
        return sincronizacion;
    }

    public void setSincronizacion(Sincronizacion sincronizacion) {
        this.sincronizacion = sincronizacion;
    }

    public Cache getCache() {
        return cache;
    }

    public void setCache(Cache cache) {
        this.cache = cache;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Value Object - Contexto
     */
    public static class Contexto {
        private String ambiente;
        private String oficina;
        private String alcance;
        private String tipoTramite;

        public Contexto() {
        }

        public String getAmbiente() {
            return ambiente;
        }

        public void setAmbiente(String ambiente) {
            this.ambiente = ambiente;
        }

        public String getOficina() {
            return oficina;
        }

        public void setOficina(String oficina) {
            this.oficina = oficina;
        }

        public String getAlcance() {
            return alcance;
        }

        public void setAlcance(String alcance) {
            this.alcance = alcance;
        }

        public String getTipoTramite() {
            return tipoTramite;
        }

        public void setTipoTramite(String tipoTramite) {
            this.tipoTramite = tipoTramite;
        }
    }

    /**
     * Value Object - Validacion
     */
    public static class Validacion {
        private String tipoDato;
        private Double valorMinimo;
        private Double valorMaximo;
        private Boolean esObligatorio;

        public Validacion() {
        }

        public String getTipoDato() {
            return tipoDato;
        }

        public void setTipoDato(String tipoDato) {
            this.tipoDato = tipoDato;
        }

        public Double getValorMinimo() {
            return valorMinimo;
        }

        public void setValorMinimo(Double valorMinimo) {
            this.valorMinimo = valorMinimo;
        }

        public Double getValorMaximo() {
            return valorMaximo;
        }

        public void setValorMaximo(Double valorMaximo) {
            this.valorMaximo = valorMaximo;
        }

        public Boolean getEsObligatorio() {
            return esObligatorio;
        }

        public void setEsObligatorio(Boolean esObligatorio) {
            this.esObligatorio = esObligatorio;
        }
    }

    /**
     * Value Object - Seguridad
     */
    public static class Seguridad {
        private Boolean esEncriptado;
        private String nivelAcceso;
        private List<String> rolesAutorizados;

        public Seguridad() {
        }

        public Boolean getEsEncriptado() {
            return esEncriptado;
        }

        public void setEsEncriptado(Boolean esEncriptado) {
            this.esEncriptado = esEncriptado;
        }

        public String getNivelAcceso() {
            return nivelAcceso;
        }

        public void setNivelAcceso(String nivelAcceso) {
            this.nivelAcceso = nivelAcceso;
        }

        public List<String> getRolesAutorizados() {
            return rolesAutorizados;
        }

        public void setRolesAutorizados(List<String> rolesAutorizados) {
            this.rolesAutorizados = rolesAutorizados;
        }
    }

    /**
     * Value Object - Sincronizacion
     */
    public static class Sincronizacion {
        private Boolean disponibleOffline;
        private Integer prioridad;
        private String frecuenciaSincronizacion;

        public Sincronizacion() {
        }

        public Boolean getDisponibleOffline() {
            return disponibleOffline;
        }

        public void setDisponibleOffline(Boolean disponibleOffline) {
            this.disponibleOffline = disponibleOffline;
        }

        public Integer getPrioridad() {
            return prioridad;
        }

        public void setPrioridad(Integer prioridad) {
            this.prioridad = prioridad;
        }

        public String getFrecuenciaSincronizacion() {
            return frecuenciaSincronizacion;
        }

        public void setFrecuenciaSincronizacion(String frecuenciaSincronizacion) {
            this.frecuenciaSincronizacion = frecuenciaSincronizacion;
        }
    }

    /**
     * Value Object - Cache
     */
    public static class Cache {
        private String fuenteDatos;
        private String ttl;
        private String ultimaActualizacionCache;

        public Cache() {
        }

        public String getFuenteDatos() {
            return fuenteDatos;
        }

        public void setFuenteDatos(String fuenteDatos) {
            this.fuenteDatos = fuenteDatos;
        }

        public String getTtl() {
            return ttl;
        }

        public void setTtl(String ttl) {
            this.ttl = ttl;
        }

        public String getUltimaActualizacionCache() {
            return ultimaActualizacionCache;
        }

        public void setUltimaActualizacionCache(String ultimaActualizacionCache) {
            this.ultimaActualizacionCache = ultimaActualizacionCache;
        }
    }
}
