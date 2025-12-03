package pe.gob.reniec.agendamiento.msdatos.domain.ports.in;

import java.time.LocalDateTime;

public interface CancelarCitaUseCase {
    
    ResultadoCancelacion cancelar(String citaId, String tokenReagendamiento, 
                                  String motivoCancelacion, String observaciones);
    
    record ResultadoCancelacion(
        String citaId,
        String codigoCita,
        String estadoFinal,
        String motivoCancelacion,
        LocalDateTime fechaCancelacion,
        String usuarioCancelacion,
        Boolean permiteCancelar
    ) {}
}