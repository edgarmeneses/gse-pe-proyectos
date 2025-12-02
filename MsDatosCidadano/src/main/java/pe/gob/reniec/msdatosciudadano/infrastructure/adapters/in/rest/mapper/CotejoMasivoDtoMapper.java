package pe.gob.reniec.msdatosciudadano.infrastructure.adapters.in.rest.mapper;

import pe.gob.reniec.msdatosciudadano.domain.model.*;
import pe.gob.reniec.msdatosciudadano.infrastructure.adapters.in.rest.dto.*;
import java.util.stream.Collectors;

public class CotejoMasivoDtoMapper {

    public static CotejoMasivo toDomain(ConsultaMasivaRequestDto dto) {
        if (dto == null) {
            return null;
        }
        
        CotejoMasivo cotejo = new CotejoMasivo();
        cotejo.setSolicitudId(dto.solicitudId());
        
        if (dto.entidadSolicitante() != null) {
            EntidadSolicitante entidad = new EntidadSolicitante(
                dto.entidadSolicitante().ruc(),
                dto.entidadSolicitante().razonSocial(),
                dto.entidadSolicitante().tipoEntidad()
            );
            cotejo.setEntidadSolicitante(entidad);
        }
        
        if (dto.configuracionCotejo() != null) {
            ConfiguracionCotejo config = new ConfiguracionCotejo(
                dto.configuracionCotejo().camposACotejar(),
                dto.configuracionCotejo().toleranciaCoincidencia(),
                dto.configuracionCotejo().generarReporteDetallado()
            );
            cotejo.setConfiguracionCotejo(config);
        }
        
        if (dto.registros() != null) {
            cotejo.setRegistros(
                dto.registros().stream()
                    .map(CotejoMasivoDtoMapper::toRegistroCotejo)
                    .collect(Collectors.toList())
            );
        }
        
        return cotejo;
    }

    private static RegistroCotejo toRegistroCotejo(RegistroCotejoDto dto) {
        RegistroCotejo registro = new RegistroCotejo();
        registro.setNumeroSecuencia(dto.numeroSecuencia());
        registro.setTipoDocumento(dto.tipoDocumento());
        registro.setNumeroDocumento(dto.numeroDocumento());
        registro.setPrimerApellido(dto.primerApellido());
        registro.setSegundoApellido(dto.segundoApellido());
        registro.setPrenombres(dto.prenombres());
        registro.setFechaNacimiento(dto.fechaNacimiento());
        registro.setSexo(dto.sexo());
        registro.setEstadoCivil(dto.estadoCivil());
        registro.setUbigeo(dto.ubigeo());
        registro.setDireccion(dto.direccion());
        return registro;
    }
}
