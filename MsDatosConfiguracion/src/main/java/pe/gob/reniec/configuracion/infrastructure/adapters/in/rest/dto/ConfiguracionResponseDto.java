package pe.gob.reniec.configuracion.infrastructure.adapters.in.rest.dto;

import java.util.List;

/**
 * DTO de respuesta - Configuración
 * Endpoint: GET /api/v1/configuracion/MsDatosConfiguracion
 */
public class ConfiguracionResponseDto {

    private String clave;
    private Object valor;
    private String tipoDato;
    private String unidad;
    private String descripcion;
    private ContextoDto contexto;
    private ValidacionDto validacion;
    private SeguridadDto seguridad;
    private SincronizacionDto sincronizacion;
    private CacheDto cache;

    public ConfiguracionResponseDto() {
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

    public ContextoDto getContexto() {
        return contexto;
    }

    public void setContexto(ContextoDto contexto) {
        this.contexto = contexto;
    }

    public ValidacionDto getValidacion() {
        return validacion;
    }

    public void setValidacion(ValidacionDto validacion) {
        this.validacion = validacion;
    }

    public SeguridadDto getSeguridad() {
        return seguridad;
    }

    public void setSeguridad(SeguridadDto seguridad) {
        this.seguridad = seguridad;
    }

    public SincronizacionDto getSincronizacion() {
        return sincronizacion;
    }

    public void setSincronizacion(SincronizacionDto sincronizacion) {
        this.sincronizacion = sincronizacion;
    }

    public CacheDto getCache() {
        return cache;
    }

    public void setCache(CacheDto cache) {
        this.cache = cache;
    }

    public static class ContextoDto {
        private String ambiente;
        private String oficina;
        private String alcance;
        private String tipoTramite;

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

    public static class ValidacionDto {
        private String tipoDato;
        private Double valorMinimo;
        private Double valorMaximo;
        private Boolean esObligatorio;

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

    public static class SeguridadDto {
        private Boolean esEncriptado;
        private String nivelAcceso;
        private List<String> rolesAutorizados;

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

    public static class SincronizacionDto {
        private Boolean disponibleOffline;
        private Integer prioridad;
        private String frecuenciaSincronizacion;

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

    public static class CacheDto {
        private String fuenteDatos;
        private String ttl;
        private String ultimaActualizacionCache;

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
