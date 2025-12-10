package pe.reniec.firma.infrastructure.adapters.in.rest.dto;

public class DetallesValidacionDto {
    private RevocacionDto revocacion;
    private CadenaConfianzaDto cadenaConfianza;

    public DetallesValidacionDto() {}

    public RevocacionDto getRevocacion() {
        return revocacion;
    }

    public void setRevocacion(RevocacionDto revocacion) {
        this.revocacion = revocacion;
    }

    public CadenaConfianzaDto getCadenaConfianza() {
        return cadenaConfianza;
    }

    public void setCadenaConfianza(CadenaConfianzaDto cadenaConfianza) {
        this.cadenaConfianza = cadenaConfianza;
    }

    public static class RevocacionDto {
        private String metodoVerificacion;
        private String urlOCSP;
        private String estadoCertificado;
        private String fechaVerificacion;

        public RevocacionDto() {}

        public String getMetodoVerificacion() {
            return metodoVerificacion;
        }

        public void setMetodoVerificacion(String metodoVerificacion) {
            this.metodoVerificacion = metodoVerificacion;
        }

        public String getUrlOCSP() {
            return urlOCSP;
        }

        public void setUrlOCSP(String urlOCSP) {
            this.urlOCSP = urlOCSP;
        }

        public String getEstadoCertificado() {
            return estadoCertificado;
        }

        public void setEstadoCertificado(String estadoCertificado) {
            this.estadoCertificado = estadoCertificado;
        }

        public String getFechaVerificacion() {
            return fechaVerificacion;
        }

        public void setFechaVerificacion(String fechaVerificacion) {
            this.fechaVerificacion = fechaVerificacion;
        }
    }

    public static class CadenaConfianzaDto {
        private Integer certificadosEnCadena;
        private String raizConfiable;
        private Boolean todosVerificados;

        public CadenaConfianzaDto() {}

        public Integer getCertificadosEnCadena() {
            return certificadosEnCadena;
        }

        public void setCertificadosEnCadena(Integer certificadosEnCadena) {
            this.certificadosEnCadena = certificadosEnCadena;
        }

        public String getRaizConfiable() {
            return raizConfiable;
        }

        public void setRaizConfiable(String raizConfiable) {
            this.raizConfiable = raizConfiable;
        }

        public Boolean getTodosVerificados() {
            return todosVerificados;
        }

        public void setTodosVerificados(Boolean todosVerificados) {
            this.todosVerificados = todosVerificados;
        }
    }
}
