package pe.gob.reniec.circunscripciones.domain.ports.in;

import pe.gob.reniec.circunscripciones.domain.model.MigracionDomiciliaria;
import java.util.List;

public interface ConsultarMigracionesDomiciliariasUseCase {

    List<MigracionDomiciliaria> consultarMigraciones(String dni, String ubigeoOrigen,
                                                     String ubigeoDestino, String fechaDesde,
                                                     String fechaHasta, String tipoMovimiento,
                                                     Boolean incluirVerificados, Integer page,
                                                     Integer pageSize);
}
