package pe.gob.reniec.gse.agendamiento.data.domain.model;

import java.time.DayOfWeek;
import java.time.LocalDate;

public enum DiaSemana {
    
    LUNES("Lunes", DayOfWeek.MONDAY),
    MARTES("Martes", DayOfWeek.TUESDAY),
    MIERCOLES("Miércoles", DayOfWeek.WEDNESDAY),
    JUEVES("Jueves", DayOfWeek.THURSDAY),
    VIERNES("Viernes", DayOfWeek.FRIDAY),
    SABADO("Sábado", DayOfWeek.SATURDAY),
    DOMINGO("Domingo", DayOfWeek.SUNDAY);
    
    private final String nombre;
    private final DayOfWeek dayOfWeek;
    
    DiaSemana(String nombre, DayOfWeek dayOfWeek) {
        this.nombre = nombre;
        this.dayOfWeek = dayOfWeek;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }
    
    public boolean esFinDeSemana() {
        return this == SABADO || this == DOMINGO;
    }
    
    public boolean esLaborable() {
        return !esFinDeSemana();
    }
    
    public static DiaSemana desde(LocalDate fecha) {
        DayOfWeek dow = fecha.getDayOfWeek();
        for (DiaSemana dia : values()) {
            if (dia.dayOfWeek == dow) {
                return dia;
            }
        }
        throw new IllegalArgumentException("No se pudo determinar el día de la semana");
    }
    
    public static DiaSemana desde(DayOfWeek dayOfWeek) {
        for (DiaSemana dia : values()) {
            if (dia.dayOfWeek == dayOfWeek) {
                return dia;
            }
        }
        throw new IllegalArgumentException("No se pudo determinar el día de la semana");
    }
}
