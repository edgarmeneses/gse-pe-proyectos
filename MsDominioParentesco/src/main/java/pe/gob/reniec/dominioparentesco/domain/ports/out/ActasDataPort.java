package pe.gob.reniec.dominioparentesco.domain.ports.out;

/**
 * Puerto de salida - Operaciones para validar actas civiles vía MsDatosActas.
 * Usa tipos primitivos para mantener independencia tecnológica.
 * No define el protocolo de comunicación (HTTP/SOAP/otros).
 */
public interface ActasDataPort {
    
    /**
     * Valida la existencia del acta de nacimiento de un ciudadano.
     * 
     * @param dni DNI del ciudadano
     * @return true si el acta existe y es válida, false en caso contrario
     */
    boolean validarActaNacimiento(String dni);
}
