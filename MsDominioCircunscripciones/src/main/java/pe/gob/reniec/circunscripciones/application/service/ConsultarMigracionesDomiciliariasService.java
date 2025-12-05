package pe.gob.reniec.circunscripciones.application.service;

import pe.gob.reniec.circunscripciones.domain.model.MigracionDomiciliaria;
import pe.gob.reniec.circunscripciones.domain.ports.in.ConsultarMigracionesDomiciliariasUseCase;
import pe.gob.reniec.circunscripciones.domain.ports.out.MigracionDataPort;
import java.util.List;

public class ConsultarMigracionesDomiciliariasService implements ConsultarMigracionesDomiciliariasUseCase {

    private final MigracionDataPort migracionDataPort;

    public ConsultarMigracionesDomiciliariasService(MigracionDataPort migracionDataPort) {
        this.migracionDataPort = migracionDataPort;
    }

    @Override
    public List<MigracionDomiciliaria> consultarMigraciones(String dni, String ubigeoOrigen,
                                                            String ubigeoDestino, String fechaDesde,
                                                            String fechaHasta, String tipoMovimiento,
                                                            Boolean incluirVerificados, Integer page,
                                                            Integer pageSize) {
        throw new UnsupportedOperationException("Implementación pendiente");
    }
}
