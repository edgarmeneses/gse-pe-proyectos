package pe.gob.reniec.agendamiento.msdatos.domain.ports.in;

import pe.gob.reniec.agendamiento.msdatos.domain.model.Disponibilidad;
import java.time.LocalDate;
import java.util.List;

public interface ConsultarDisponibilidadUseCase {
    
    public class ResultadoDisponibilidad {
        private String codigoSede;
        private String nombreSede;
        private String direccion;
        private Integer tiempoAtencionMinutos;
        private LocalDate fechaDesde;
        private LocalDate fechaHasta;
        private List<DisponibilidadDia> disponibilidad;
        private ResumenDisponibilidad resumen;

        public ResultadoDisponibilidad() {
        }

        public ResultadoDisponibilidad(String codigoSede, String nombreSede, String direccion,
                                       Integer tiempoAtencionMinutos, LocalDate fechaDesde,
                                       LocalDate fechaHasta, List<DisponibilidadDia> disponibilidad,
                                       ResumenDisponibilidad resumen) {
            this.codigoSede = codigoSede;
            this.nombreSede = nombreSede;
            this.direccion = direccion;
            this.tiempoAtencionMinutos = tiempoAtencionMinutos;
            this.fechaDesde = fechaDesde;
            this.fechaHasta = fechaHasta;
            this.disponibilidad = disponibilidad;
            this.resumen = resumen;
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

        public String getDireccion() {
            return direccion;
        }

        public void setDireccion(String direccion) {
            this.direccion = direccion;
        }

        public Integer getTiempoAtencionMinutos() {
            return tiempoAtencionMinutos;
        }

        public void setTiempoAtencionMinutos(Integer tiempoAtencionMinutos) {
            this.tiempoAtencionMinutos = tiempoAtencionMinutos;
        }

        public LocalDate getFechaDesde() {
            return fechaDesde;
        }

        public void setFechaDesde(LocalDate fechaDesde) {
            this.fechaDesde = fechaDesde;
        }

        public LocalDate getFechaHasta() {
            return fechaHasta;
        }

        public void setFechaHasta(LocalDate fechaHasta) {
            this.fechaHasta = fechaHasta;
        }

        public List<DisponibilidadDia> getDisponibilidad() {
            return disponibilidad;
        }

        public void setDisponibilidad(List<DisponibilidadDia> disponibilidad) {
            this.disponibilidad = disponibilidad;
        }

        public ResumenDisponibilidad getResumen() {
            return resumen;
        }

        public void setResumen(ResumenDisponibilidad resumen) {
            this.resumen = resumen;
        }
    }

    public class DisponibilidadDia {
        private LocalDate fecha;
        private String diaSemana;
        private Boolean esHabil;
        private String motivoNoHabil;
        private List<Disponibilidad> franjas;

        public DisponibilidadDia() {
        }

        public DisponibilidadDia(LocalDate fecha, String diaSemana, Boolean esHabil,
                                 String motivoNoHabil, List<Disponibilidad> franjas) {
            this.fecha = fecha;
            this.diaSemana = diaSemana;
            this.esHabil = esHabil;
            this.motivoNoHabil = motivoNoHabil;
            this.franjas = franjas;
        }

        public LocalDate getFecha() {
            return fecha;
        }

        public void setFecha(LocalDate fecha) {
            this.fecha = fecha;
        }

        public String getDiaSemana() {
            return diaSemana;
        }

        public void setDiaSemana(String diaSemana) {
            this.diaSemana = diaSemana;
        }

        public Boolean getEsHabil() {
            return esHabil;
        }

        public void setEsHabil(Boolean esHabil) {
            this.esHabil = esHabil;
        }

        public String getMotivoNoHabil() {
            return motivoNoHabil;
        }

        public void setMotivoNoHabil(String motivoNoHabil) {
            this.motivoNoHabil = motivoNoHabil;
        }

        public List<Disponibilidad> getFranjas() {
            return franjas;
        }

        public void setFranjas(List<Disponibilidad> franjas) {
            this.franjas = franjas;
        }
    }

    public class ResumenDisponibilidad {
        private Integer totalDias;
        private Integer diasHabiles;
        private Integer diasNoHabiles;
        private Integer totalFranjas;
        private Integer franjasDisponibles;
        private Integer franjasOcupadas;

        public ResumenDisponibilidad() {
        }

        public ResumenDisponibilidad(Integer totalDias, Integer diasHabiles, Integer diasNoHabiles,
                                     Integer totalFranjas, Integer franjasDisponibles,
                                     Integer franjasOcupadas) {
            this.totalDias = totalDias;
            this.diasHabiles = diasHabiles;
            this.diasNoHabiles = diasNoHabiles;
            this.totalFranjas = totalFranjas;
            this.franjasDisponibles = franjasDisponibles;
            this.franjasOcupadas = franjasOcupadas;
        }

        public Integer getTotalDias() {
            return totalDias;
        }

        public void setTotalDias(Integer totalDias) {
            this.totalDias = totalDias;
        }

        public Integer getDiasHabiles() {
            return diasHabiles;
        }

        public void setDiasHabiles(Integer diasHabiles) {
            this.diasHabiles = diasHabiles;
        }

        public Integer getDiasNoHabiles() {
            return diasNoHabiles;
        }

        public void setDiasNoHabiles(Integer diasNoHabiles) {
            this.diasNoHabiles = diasNoHabiles;
        }

        public Integer getTotalFranjas() {
            return totalFranjas;
        }

        public void setTotalFranjas(Integer totalFranjas) {
            this.totalFranjas = totalFranjas;
        }

        public Integer getFranjasDisponibles() {
            return franjasDisponibles;
        }

        public void setFranjasDisponibles(Integer franjasDisponibles) {
            this.franjasDisponibles = franjasDisponibles;
        }

        public Integer getFranjasOcupadas() {
            return franjasOcupadas;
        }

        public void setFranjasOcupadas(Integer franjasOcupadas) {
            this.franjasOcupadas = franjasOcupadas;
        }
    }

    ResultadoDisponibilidad consultar(String codigoSede, LocalDate fechaDesde, 
                                       LocalDate fechaHasta, Boolean soloDisponibles);
}
