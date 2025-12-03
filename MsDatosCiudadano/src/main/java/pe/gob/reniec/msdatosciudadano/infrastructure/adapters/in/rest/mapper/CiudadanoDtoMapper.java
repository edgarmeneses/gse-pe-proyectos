package pe.gob.reniec.msdatosciudadano.infrastructure.adapters.in.rest.mapper;

import pe.gob.reniec.msdatosciudadano.domain.model.*;
import pe.gob.reniec.msdatosciudadano.infrastructure.adapters.in.rest.dto.*;
import java.util.stream.Collectors;
import java.util.List;
import java.util.ArrayList;

public class CiudadanoDtoMapper {

    public static Ciudadano toDomain(CrearCiudadanoRequestDto dto) {
        if (dto == null) {
            return null;
        }

        // CrearCiudadanoRequestDto contiene una lista de registros; mapeamos el primer registro a un Ciudadano mínimo.
        if (dto.registros() == null || dto.registros().isEmpty()) {
            return new Ciudadano();
        }

        RegistroDto registro = dto.registros().get(0);
        Ciudadano ciudadano = new Ciudadano();
        ciudadano.setTipoDocumento(registro.tipoDocumento());
        ciudadano.setNumeroDocumento(registro.numeroDocumento());
        // otros campos no vienen en este DTO de entrada masiva; se dejan nulos
        return ciudadano;
    }

    private static InformacionParental toInformacionParental(InformacionParentalDto dto) {
        return new InformacionParental(
            dto.primerNombrePaterno(),
            dto.segundoNombrePaterno(),
            dto.primerApellidoPaterno(),
            dto.segundoApellidoPaterno(),
            dto.primerNombreMaterno(),
            dto.segundoNombreMaterno(),
            dto.primerApellidoMaterno(),
            dto.segundoApellidoMaterno(),
            dto.tipoDocumentoPaterno(),
            dto.numeroDocumentoPaterno(),
            dto.tipoDocumentoMaterno(),
            dto.numeroDocumentoMaterno()
        );
    }

    private static DireccionResidencia toDireccionResidencia(DireccionResidenciaDto dto) {
        return new DireccionResidencia(
            dto.pais(),
            dto.departamento(),
            dto.provincia(),
            dto.distrito(),
            dto.centroPoblado(),
            dto.barrio(),
            dto.direccion(),
            dto.codigoPostal()
        );
    }

    private static Contacto toContacto(ContactoDto dto) {
        return new Contacto(
            dto.telefonoFijo(),
            dto.telefonoMovil(),
            dto.correoElectronico(),
            dto.correoAlternativo()
        );
    }

    private static InformacionElectoral toInformacionElectoral(InformacionElectoralDto dto) {
        return new InformacionElectoral(
            dto.inscritoVotacion(),
            dto.departamentoVotacion(),
            dto.provinciaVotacion(),
            dto.distritoVotacion(),
            dto.lugarVotacion()
        );
    }

    private static DatosBiometricos toDatosBiometricos(DatosBiometricosDto dto) {
        DatosBiometricos datos = new DatosBiometricos();
        datos.setFechaRegistro(dto.fechaRegistro());
        
        if (dto.huellasDactilares() != null) {
            datos.setHuellasDactilares(
                dto.huellasDactilares().stream()
                    .map(h -> new HuellaDactilar(h.nombreDedo(), h.formato(), h.valorBase64()))
                    .collect(Collectors.toList())
            );
        }
        
        if (dto.fotografia() != null) {
            datos.setFotografia(
                dto.fotografia().stream()
                    .map(f -> new Fotografia(f.formato(), f.valorBase64(), f.resolucion(), f.modoCaptura()))
                    .collect(Collectors.toList())
            );
        }
        
        if (dto.firmaDigital() != null) {
            datos.setFirmaDigital(
                dto.firmaDigital().stream()
                    .map(f -> new FirmaDigital(f.formato(), f.valorBase64(), f.dispositivoCaptura()))
                    .collect(Collectors.toList())
            );
        }
        
        return datos;
    }

    public static CiudadanoResponseDto toResponseDto(String id, Ciudadano ciudadano) {
        List<CiudadanoResponseDto.ResultadoDto> resultados = new ArrayList<>();
        String estadoProceso = ciudadano != null && ciudadano.getEstado() != null ? ciudadano.getEstado() : "PENDING";
        return new CiudadanoResponseDto(id, ciudadano != null ? ciudadano.getFechaCreacion() : null, estadoProceso, resultados);
    }

    public static CiudadanoDto toDto(Ciudadano ciudadano) {
        if (ciudadano == null) return null;
        return new CiudadanoDto(
            ciudadano.getId(),
            ciudadano.getTipoDocumento(),
            ciudadano.getNumeroDocumento(),
            ciudadano.getPrimerNombre() + (ciudadano.getSegundoNombre() != null ? " " + ciudadano.getSegundoNombre() : "") + " " + (ciudadano.getPrimerApellido() != null ? ciudadano.getPrimerApellido() : "") + (ciudadano.getSegundoApellido() != null ? " " + ciudadano.getSegundoApellido() : ""),
            ciudadano.getPrimerApellido(),
            ciudadano.getSegundoApellido(),
            (ciudadano.getPrimerNombre() != null ? ciudadano.getPrimerNombre() : "") + (ciudadano.getSegundoNombre() != null ? " " + ciudadano.getSegundoNombre() : ""),
            ciudadano.getFechaNacimiento(),
            null
        );
    }
}
