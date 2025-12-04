package pe.gob.onpe.dominio.paquetes.infrastructure.adapters.in.rest.controller;

import pe.gob.onpe.dominio.paquetes.domain.model.PaqueteElectoral;
import pe.gob.onpe.dominio.paquetes.domain.ports.in.ConsultarPaquetesUseCase;
import pe.gob.onpe.dominio.paquetes.domain.ports.in.AprobarPaqueteUseCase;
import pe.gob.onpe.dominio.paquetes.domain.ports.in.ConfirmarRevisionPaquetesUseCase;
import pe.gob.onpe.dominio.paquetes.infrastructure.adapters.in.rest.dto.*;
import pe.gob.onpe.dominio.paquetes.infrastructure.adapters.in.rest.mapper.PaqueteElectoralDtoMapper;
import java.util.List;

public class PaquetesElectoralesController {
    private final ConsultarPaquetesUseCase consultarPaquetesUseCase;
    private final AprobarPaqueteUseCase aprobarPaqueteUseCase;
    private final ConfirmarRevisionPaquetesUseCase confirmarRevisionPaquetesUseCase;

    public PaquetesElectoralesController(
            ConsultarPaquetesUseCase consultarPaquetesUseCase,
            AprobarPaqueteUseCase aprobarPaqueteUseCase,
            ConfirmarRevisionPaquetesUseCase confirmarRevisionPaquetesUseCase) {
        this.consultarPaquetesUseCase = consultarPaquetesUseCase;
        this.aprobarPaqueteUseCase = aprobarPaqueteUseCase;
        this.confirmarRevisionPaquetesUseCase = confirmarRevisionPaquetesUseCase;
    }

    public ConsultarPaquetesResponseDto consultarPaquetes(
            String idPadron,
            String tipoPadron,
            String codigoDepartamento,
            String codigoProvincia,
            String codigoDistrito,
            String estadoPaquete,
            Integer paginaActual,
            Integer registrosPorPagina) {
        
        List<PaqueteElectoral> paquetes = consultarPaquetesUseCase.consultar(
                idPadron,
                tipoPadron,
                codigoDepartamento,
                codigoProvincia,
                codigoDistrito,
                estadoPaquete,
                paginaActual,
                registrosPorPagina
        );
        
        return PaqueteElectoralDtoMapper.toConsultarPaquetesResponseDto(paquetes, paginaActual, registrosPorPagina);
    }

    public AprobarPaqueteResponseDto aprobarPaquete(
            String paqueteId,
            AprobarPaqueteRequestDto request) {
        
        InformacionPublicacionDto infoPublicacionDto = request.getInformacionPublicacion();
        
        PaqueteElectoral paquete = aprobarPaqueteUseCase.aprobar(
                paqueteId,
                infoPublicacionDto != null ? PaqueteElectoralDtoMapper.parseFecha(infoPublicacionDto.getFechaPublicacion()) : null,
                infoPublicacionDto != null ? infoPublicacionDto.getLugarPublicacion() : null,
                infoPublicacionDto != null ? infoPublicacionDto.getObservaciones() : null,
                request.getComentarioAprobacion(),
                request.getConfirmarIntegridad()
        );
        
        return PaqueteElectoralDtoMapper.toAprobarPaqueteResponseDto(paquete, infoPublicacionDto);
    }

    public ConfirmarRevisionResponseDto confirmarRevision(
            String idPadron,
            ConfirmarRevisionRequestDto request) {
        
        confirmarRevisionPaquetesUseCase.confirmarRevision(
                idPadron,
                request.getTipoPadron(),
                request.getComentarioConfirmacion(),
                request.getConfirmarRevisionCompleta()
        );
        
        return PaqueteElectoralDtoMapper.toConfirmarRevisionResponseDto(idPadron, request.getTipoPadron());
    }
}
