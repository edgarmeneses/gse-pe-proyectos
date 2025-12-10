package pe.reniec.firma.domain.model;

public class DetallesValidacion {
    private Revocacion revocacion;
    private CadenaConfianza cadenaConfianza;

    public DetallesValidacion() {}

    public Revocacion getRevocacion() {
        return revocacion;
    }

    public void setRevocacion(Revocacion revocacion) {
        this.revocacion = revocacion;
    }

    public CadenaConfianza getCadenaConfianza() {
        return cadenaConfianza;
    }

    public void setCadenaConfianza(CadenaConfianza cadenaConfianza) {
        this.cadenaConfianza = cadenaConfianza;
    }

    public static class Revocacion {
        private String metodoVerificacion;
        private String urlOCSP;
        private String estadoCertificado;
        private String fechaVerificacion;

        public Revocacion() {}

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

    public static class CadenaConfianza {
        private Integer certificadosEnCadena;
        private String raizConfiable;
        private Boolean todosVerificados;

        public CadenaConfianza() {}

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
