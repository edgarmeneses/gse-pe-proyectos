package pe.gob.reniec.agendamiento.msdatos.domain.ports.in;

import pe.gob.reniec.agendamiento.msdatos.domain.model.ConfiguracionDisponibilidad;
import java.time.LocalDateTime;

public interface ConfigurarDisponibilidadUseCase {
    
    public class ResultadoConfiguracion {
        private String sedeServicioId;
        private String codigoSede;
        private String nombreSede;
        private Integer capacidadDiariaMaxima;
        private Integer tiempoAtencionMinutos;
        private Integer horariosConfigurados;
        private Integer diasGenerados;
        private Integer franjasGeneradas;
        private LocalDateTime fechaConfiguracion;
        private String usuarioConfiguracion;

        public ResultadoConfiguracion() {
        }

        public ResultadoConfiguracion(String sedeServicioId, String codigoSede, String nombreSede,
                                      Integer capacidadDiariaMaxima, Integer tiempoAtencionMinutos,
                                      Integer horariosConfigurados, Integer diasGenerados,
                                      Integer franjasGeneradas, LocalDateTime fechaConfiguracion,
                                      String usuarioConfiguracion) {
            this.sedeServicioId = sedeServicioId;
            this.codigoSede = codigoSede;
            this.nombreSede = nombreSede;
            this.capacidadDiariaMaxima = capacidadDiariaMaxima;
            this.tiempoAtencionMinutos = tiempoAtencionMinutos;
            this.horariosConfigurados = horariosConfigurados;
            this.diasGenerados = diasGenerados;
            this.franjasGeneradas = franjasGeneradas;
            this.fechaConfiguracion = fechaConfiguracion;
            this.usuarioConfiguracion = usuarioConfiguracion;
        }

        public String getSedeServicioId() {
            return sedeServicioId;
        }

        public void setSedeServicioId(String sedeServicioId) {
            this.sedeServicioId = sedeServicioId;
        }

        public String getCodigoSede() {
            return codigoSede;
        }

        public void setCodigoSede(String codigoSede) {
            this.codigoSede = codigoSede;
        }

        public String getNombreSede() {
            return nombreSede;
        }

        public void setNombreSede(String nombreSede) {
            this.nombreSede = nombreSede;
        }

        public Integer getCapacidadDiariaMaxima() {
            return capacidadDiariaMaxima;
        }

        public void setCapacidadDiariaMaxima(Integer capacidadDiariaMaxima) {
            this.capacidadDiariaMaxima = capacidadDiariaMaxima;
        }

        public Integer getTiempoAtencionMinutos() {
            return tiempoAtencionMinutos;
        }

        public void setTiempoAtencionMinutos(Integer tiempoAtencionMinutos) {
            this.tiempoAtencionMinutos = tiempoAtencionMinutos;
        }

        public Integer getHorariosConfigurados() {
            return horariosConfigurados;
        }

        public void setHorariosConfigurados(Integer horariosConfigurados) {
            this.horariosConfigurados = horariosConfigurados;
        }

        public Integer getDiasGenerados() {
            return diasGenerados;
        }

        public void setDiasGenerados(Integer diasGenerados) {
            this.diasGenerados = diasGenerados;
        }

        public Integer getFranjasGeneradas() {
            return franjasGeneradas;
        }

        public void setFranjasGeneradas(Integer franjasGeneradas) {
            this.franjasGeneradas = franjasGeneradas;
        }

        public LocalDateTime getFechaConfiguracion() {
            return fechaConfiguracion;
        }

        public void setFechaConfiguracion(LocalDateTime fechaConfiguracion) {
            this.fechaConfiguracion = fechaConfiguracion;
        }

        public String getUsuarioConfiguracion() {
            return usuarioConfiguracion;
        }

        public void setUsuarioConfiguracion(String usuarioConfiguracion) {
            this.usuarioConfiguracion = usuarioConfiguracion;
        }
    }

    ResultadoConfiguracion configurar(ConfiguracionDisponibilidad configuracion, 
                                       Boolean generarDisponibilidadAutomatica);
}
