package pe.reniec.firma.infrastructure.adapters.in.rest.dto;

public class ConfiguracionFirmaDto {
    private String tipoCertificado;
    private String proveedorFirma;
    private Boolean incluyeGrafo;
    private PosicionGrafoDto posicionGrafo;
    private String razonFirma;
    private String ubicacionFirma;
    private Boolean validarVigenciaCertificado;
    private Boolean procesarEnParalelo;
    private Integer maximoParalelo;

    public ConfiguracionFirmaDto() {}

    public String getTipoCertificado() {
        return tipoCertificado;
    }

    public void setTipoCertificado(String tipoCertificado) {
        this.tipoCertificado = tipoCertificado;
    }

    public String getProveedorFirma() {
        return proveedorFirma;
    }

    public void setProveedorFirma(String proveedorFirma) {
        this.proveedorFirma = proveedorFirma;
    }

    public Boolean getIncluyeGrafo() {
        return incluyeGrafo;
    }

    public void setIncluyeGrafo(Boolean incluyeGrafo) {
        this.incluyeGrafo = incluyeGrafo;
    }

    public PosicionGrafoDto getPosicionGrafo() {
        return posicionGrafo;
    }

    public void setPosicionGrafo(PosicionGrafoDto posicionGrafo) {
        this.posicionGrafo = posicionGrafo;
    }

    public String getRazonFirma() {
        return razonFirma;
    }

    public void setRazonFirma(String razonFirma) {
        this.razonFirma = razonFirma;
    }

    public String getUbicacionFirma() {
        return ubicacionFirma;
    }

    public void setUbicacionFirma(String ubicacionFirma) {
        this.ubicacionFirma = ubicacionFirma;
    }

    public Boolean getValidarVigenciaCertificado() {
        return validarVigenciaCertificado;
    }

    public void setValidarVigenciaCertificado(Boolean validarVigenciaCertificado) {
        this.validarVigenciaCertificado = validarVigenciaCertificado;
    }

    public Boolean getProcesarEnParalelo() {
        return procesarEnParalelo;
    }

    public void setProcesarEnParalelo(Boolean procesarEnParalelo) {
        this.procesarEnParalelo = procesarEnParalelo;
    }

    public Integer getMaximoParalelo() {
        return maximoParalelo;
    }

    public void setMaximoParalelo(Integer maximoParalelo) {
        this.maximoParalelo = maximoParalelo;
    }

    public static class PosicionGrafoDto {
        private Integer pagina;
        private Integer coordenadaX;
        private Integer coordenadaY;
        private Integer ancho;
        private Integer alto;

        public PosicionGrafoDto() {}

        public Integer getPagina() {
            return pagina;
        }

        public void setPagina(Integer pagina) {
            this.pagina = pagina;
        }

        public Integer getCoordenadaX() {
            return coordenadaX;
        }

        public void setCoordenadaX(Integer coordenadaX) {
            this.coordenadaX = coordenadaX;
        }

        public Integer getCoordenadaY() {
            return coordenadaY;
        }

        public void setCoordenadaY(Integer coordenadaY) {
            this.coordenadaY = coordenadaY;
        }

        public Integer getAncho() {
            return ancho;
        }

        public void setAncho(Integer ancho) {
            this.ancho = ancho;
        }

        public Integer getAlto() {
            return alto;
        }

        public void setAlto(Integer alto) {
            this.alto = alto;
        }
    }
}
