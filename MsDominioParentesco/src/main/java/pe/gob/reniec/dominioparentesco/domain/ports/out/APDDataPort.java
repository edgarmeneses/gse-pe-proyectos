package pe.gob.reniec.dominioparentesco.domain.ports.out;

import java.util.Map;

/**
 * Puerto de salida - Operaciones para validar ciudadanos contra APD vía MsSagaAPD.
 * Usa tipos primitivos para mantener independencia tecnológica.
 * No define el protocolo de comunicación (HTTP/SOAP/otros).
 */
public interface APDDataPort {
    
    /**
     * Valida y consulta los datos básicos de un ciudadano en el APD.
     * 
     * @param dni DNI del ciudadano
     * @return Map con datos: valido (Boolean), nombreCompleto (String), fechaNacimiento (LocalDate)
     */
    Map<String, Object> validarCiudadano(String dni);
}
