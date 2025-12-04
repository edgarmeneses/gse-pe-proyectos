package pe.gob.reniec.dominioparentesco.domain.model;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Entity - Representa un vínculo de parentesco entre dos ciudadanos.
 * Encapsula las reglas de negocio sobre relaciones familiares.
 */
public class Vinculo {
    
    private final Ciudadano origen;
    private final Ciudadano destino;
    private final TipoVinculo tipo;
    private final LocalDateTime fechaEstablecimiento;
    private final String actaSustentoId;
    private final NivelConfianza nivelConfianza;
    private boolean requiereValidacionManual;
    private String observaciones;
    
    private Vinculo(Ciudadano origen, Ciudadano destino, TipoVinculo tipo,
                   LocalDateTime fechaEstablecimiento, String actaSustentoId,
                   NivelConfianza nivelConfianza) {
        this.origen = Objects.requireNonNull(origen, "El ciudadano origen no puede ser nulo");
        this.destino = Objects.requireNonNull(destino, "El ciudadano destino no puede ser nulo");
        this.tipo = Objects.requireNonNull(tipo, "El tipo de vínculo no puede ser nulo");
        this.fechaEstablecimiento = fechaEstablecimiento;
        this.actaSustentoId = actaSustentoId;
        this.nivelConfianza = Objects.requireNonNull(nivelConfianza, "El nivel de confianza no puede ser nulo");
        this.requiereValidacionManual = nivelConfianza.esConfianzaBaja();
        
        validarVinculo();
    }
    
    public static Vinculo establecer(Ciudadano origen, Ciudadano destino, 
                                    TipoVinculo tipo, String actaSustentoId) {
        return new Vinculo(origen, destino, tipo, LocalDateTime.now(), 
                          actaSustentoId, NivelConfianza.ALTO);
    }
    
    public static Vinculo establecerConConfianza(Ciudadano origen, Ciudadano destino,
                                                TipoVinculo tipo, String actaSustentoId,
                                                NivelConfianza confianza) {
        return new Vinculo(origen, destino, tipo, LocalDateTime.now(),
                          actaSustentoId, confianza);
    }
    
    private void validarVinculo() {
        // No puede haber vínculo de una persona consigo misma
        if (origen.equals(destino)) {
            throw new IllegalArgumentException("Un ciudadano no puede tener un vínculo consigo mismo");
        }
        
        // Validaciones específicas por tipo de vínculo
        if (tipo.esConsanguineo()) {
            validarVinculoConsanguineo();
        } else if (tipo.esAfinidad()) {
            validarVinculoAfinidad();
        }
    }
    
    private void validarVinculoConsanguineo() {
        // Un padre no puede ser menor que el hijo
        if ((tipo == TipoVinculo.PADRE || tipo == TipoVinculo.MADRE) &&
            origen.getFechaNacimiento().isAfter(destino.getFechaNacimiento())) {
            throw new IllegalArgumentException("El padre/madre no puede ser menor que el hijo");
        }
        
        // Validar diferencia de edad razonable
        int diferenciaEdad = Math.abs(origen.calcularEdad() - destino.calcularEdad());
        if (tipo.esPrimerGrado() && diferenciaEdad < 15) {
            marcarComoRequiereValidacionManual(
                "Diferencia de edad menor a 15 años para vínculo de primer grado");
        }
    }
    
    private void validarVinculoAfinidad() {
        // Para vínculos de afinidad, ambas personas deben ser mayores de edad
        if (tipo == TipoVinculo.CONYUGE) {
            if (!origen.esMayorDeEdad() || !destino.esMayorDeEdad()) {
                throw new IllegalArgumentException(
                    "Los cónyuges deben ser mayores de edad");
            }
        }
    }
    
    public void marcarComoRequiereValidacionManual(String razon) {
        this.requiereValidacionManual = true;
        this.observaciones = razon;
    }
    
    public void aprobarValidacionManual(String comentario) {
        this.requiereValidacionManual = false;
        this.observaciones = "VALIDADO: " + comentario;
    }
    
    public boolean esConsanguineo() {
        return tipo.esConsanguineo();
    }
    
    public boolean esAfinidad() {
        return tipo.esAfinidad();
    }
    
    public boolean esConfiable() {
        return nivelConfianza.esConfiable();
    }
    
    // Getters
    public Ciudadano getOrigen() { return origen; }
    public Ciudadano getDestino() { return destino; }
    public TipoVinculo getTipo() { return tipo; }
    public LocalDateTime getFechaEstablecimiento() { return fechaEstablecimiento; }
    public String getActaSustentoId() { return actaSustentoId; }
    public NivelConfianza getNivelConfianza() { return nivelConfianza; }
    public boolean requiereValidacionManual() { return requiereValidacionManual; }
    public String getObservaciones() { return observaciones; }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vinculo vinculo = (Vinculo) o;
        return Objects.equals(origen, vinculo.origen) &&
               Objects.equals(destino, vinculo.destino) &&
               Objects.equals(tipo, vinculo.tipo);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(origen, destino, tipo);
    }
    
    @Override
    public String toString() {
        return origen.getNombreCompleto() + " es " + 
               tipo.getDescripcion() + " de " + 
               destino.getNombreCompleto();
    }
}
