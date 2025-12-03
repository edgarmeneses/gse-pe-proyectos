package pe.gob.reniec.coreog.validadordocumentos.domain.ports.out;

import pe.gob.reniec.coreog.validadordocumentos.domain.model.Registrador;

/**
 * Puerto de salida: Comunicación con MsDataRegistradores para consultar información de registradores
 * Este es un microservicio de DOMINIO, por lo que NO define RepositoryPort.
 * Define puertos de salida hacia MsData para consultar registradores y sus firmas/sellos.
 */
public interface RegistradorDataPort {
    
    /**
     * Consulta los datos de un registrador por su DNI
     * 
     * @param numeroDni Número de DNI del registrador
     * @return Registrador encontrado o null si no existe
     */
    Registrador consultarRegistradorPorDni(String numeroDni);
    
    /**
     * Consulta la imagen de firma de referencia de un registrador
     * 
     * @param numeroDni Número de DNI del registrador
     * @return Imagen en Base64 o null si no existe
     */
    String consultarFirmaReferencia(String numeroDni);
    
    /**
     * Consulta la imagen de sello de referencia de un registrador
     * 
     * @param numeroDni Número de DNI del registrador
     * @return Imagen en Base64 o null si no existe
     */
    String consultarSelloReferencia(String numeroDni);
    
    /**
     * Verifica si un registrador estaba habilitado en una fecha específica
     * 
     * @param numeroDni Número de DNI del registrador
     * @param fechaInscripcion Fecha de inscripción a verificar
     * @param codigoLocal Código del local donde se realizó la inscripción
     * @return true si estaba habilitado, false en caso contrario
     */
    Boolean verificarHabilitacionEnFecha(String numeroDni, java.time.LocalDateTime fechaInscripcion, String codigoLocal);
}
