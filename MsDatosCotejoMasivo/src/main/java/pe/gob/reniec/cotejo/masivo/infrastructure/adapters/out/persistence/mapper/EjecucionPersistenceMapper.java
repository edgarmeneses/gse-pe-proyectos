package pe.gob.reniec.cotejo.masivo.infrastructure.adapters.out.persistence.mapper;

import pe.gob.reniec.cotejo.masivo.domain.model.Ejecucion;
import pe.gob.reniec.cotejo.masivo.domain.model.ResumenResultados;
import pe.gob.reniec.cotejo.masivo.infrastructure.adapters.out.persistence.entity.EjecucionEntity;

public class EjecucionPersistenceMapper {

    public static EjecucionEntity toEntity(Ejecucion ejecucion) {
        EjecucionEntity entity = new EjecucionEntity();
        entity.setEjecucionId(ejecucion.getEjecucionId());
        entity.setSolicitudId(ejecucion.getSolicitudId());
        entity.setCodigoOrganizacion(ejecucion.getCodigoOrganizacion());
        entity.setNombreOrganizacion(ejecucion.getNombreOrganizacion());
        entity.setCodigoEnvio(ejecucion.getCodigoEnvio());
        entity.setNumeroLote(ejecucion.getNumeroLote());
        entity.setCodigoEstado(ejecucion.getCodigoEstado());
        entity.setDescripcionEstado(ejecucion.getDescripcionEstado());
        entity.setTotalRegistrosEntrada(ejecucion.getTotalRegistrosEntrada());
        entity.setTotalRegistrosProcesados(ejecucion.getTotalRegistrosProcesados());
        entity.setTotalRegistrosCorrectos(ejecucion.getTotalRegistrosCorrectos());
        entity.setTotalRegistrosIncorrectos(ejecucion.getTotalRegistrosIncorrectos());
        entity.setFechaInicioProceso(ejecucion.getFechaInicioProceso());
        entity.setFechaFinProceso(ejecucion.getFechaFinProceso());
        entity.setDocumentoSustento(ejecucion.getDocumentoSustento());
        entity.setObservaciones(ejecucion.getObservaciones());
        entity.setUrlReporteGenerado(ejecucion.getUrlReporteGenerado());
        entity.setIndicadorDomicilio(ejecucion.getIndicadorDomicilio());
        entity.setCodigoPrograma(ejecucion.getCodigoPrograma());
        entity.setFechaCreacion(ejecucion.getFechaCreacion());
        entity.setUsuarioCreacion(ejecucion.getUsuarioCreacion());
        entity.setFechaModificacion(ejecucion.getFechaModificacion());
        entity.setUsuarioModificacion(ejecucion.getUsuarioModificacion());
        
        if (ejecucion.getResumenResultados() != null) {
            entity.setTotalCorrectos(ejecucion.getResumenResultados().getTotalCorrectos());
            entity.setTotalIncorrectos(ejecucion.getResumenResultados().getTotalIncorrectos());
            entity.setTotalNoEncontrados(ejecucion.getResumenResultados().getTotalNoEncontrados());
            entity.setTotalFallecidos(ejecucion.getResumenResultados().getTotalFallecidos());
            entity.setTotalRestringidos(ejecucion.getResumenResultados().getTotalRestringidos());
            entity.setTotalCaducados(ejecucion.getResumenResultados().getTotalCaducados());
            entity.setTotalErrores(ejecucion.getResumenResultados().getTotalErrores());
        }
        
        return entity;
    }

    public static Ejecucion toDomain(EjecucionEntity entity) {
        Ejecucion ejecucion = new Ejecucion();
        ejecucion.setEjecucionId(entity.getEjecucionId());
        ejecucion.setSolicitudId(entity.getSolicitudId());
        ejecucion.setCodigoOrganizacion(entity.getCodigoOrganizacion());
        ejecucion.setNombreOrganizacion(entity.getNombreOrganizacion());
        ejecucion.setCodigoEnvio(entity.getCodigoEnvio());
        ejecucion.setNumeroLote(entity.getNumeroLote());
        ejecucion.setCodigoEstado(entity.getCodigoEstado());
        ejecucion.setDescripcionEstado(entity.getDescripcionEstado());
        ejecucion.setTotalRegistrosEntrada(entity.getTotalRegistrosEntrada());
        ejecucion.setTotalRegistrosProcesados(entity.getTotalRegistrosProcesados());
        ejecucion.setTotalRegistrosCorrectos(entity.getTotalRegistrosCorrectos());
        ejecucion.setTotalRegistrosIncorrectos(entity.getTotalRegistrosIncorrectos());
        ejecucion.setFechaInicioProceso(entity.getFechaInicioProceso());
        ejecucion.setFechaFinProceso(entity.getFechaFinProceso());
        ejecucion.setDocumentoSustento(entity.getDocumentoSustento());
        ejecucion.setObservaciones(entity.getObservaciones());
        ejecucion.setUrlReporteGenerado(entity.getUrlReporteGenerado());
        ejecucion.setIndicadorDomicilio(entity.getIndicadorDomicilio());
        ejecucion.setCodigoPrograma(entity.getCodigoPrograma());
        ejecucion.setFechaCreacion(entity.getFechaCreacion());
        ejecucion.setUsuarioCreacion(entity.getUsuarioCreacion());
        ejecucion.setFechaModificacion(entity.getFechaModificacion());
        ejecucion.setUsuarioModificacion(entity.getUsuarioModificacion());
        
        ResumenResultados resumen = new ResumenResultados();
        resumen.setTotalCorrectos(entity.getTotalCorrectos());
        resumen.setTotalIncorrectos(entity.getTotalIncorrectos());
        resumen.setTotalNoEncontrados(entity.getTotalNoEncontrados());
        resumen.setTotalFallecidos(entity.getTotalFallecidos());
        resumen.setTotalRestringidos(entity.getTotalRestringidos());
        resumen.setTotalCaducados(entity.getTotalCaducados());
        resumen.setTotalErrores(entity.getTotalErrores());
        ejecucion.setResumenResultados(resumen);
        
        return ejecucion;
    }
}
