package pe.gob.reniec.msdatosciudadano.infrastructure.adapters.in.rest.mapper;

import pe.gob.reniec.msdatosciudadano.domain.model.*;
import pe.gob.reniec.msdatosciudadano.infrastructure.adapters.in.rest.dto.*;
import java.util.stream.Collectors;

public class CiudadanoDtoMapper {

    public static Ciudadano toDomain(CrearCiudadanoRequestDto dto) {
        if (dto == null) {
            return null;
        }
        
        Ciudadano ciudadano = new Ciudadano();
        ciudadano.setTipoDocumento(dto.tipoDocumento());
        ciudadano.setNumeroDocumento(dto.numeroDocumento());
        ciudadano.setPrimerNombre(dto.primerNombre());
        ciudadano.setSegundoNombre(dto.segundoNombre());
        ciudadano.setPrimerApellido(dto.primerApellido());
        ciudadano.setSegundoApellido(dto.segundoApellido());
        ciudadano.setFechaNacimiento(dto.fechaNacimiento());
        ciudadano.setSexo(dto.sexo());
        ciudadano.setEstadoCivil(dto.estadoCivil());
        ciudadano.setNacionalidad(dto.nacionalidad());
        ciudadano.setPaisNacimiento(dto.paisNacimiento());
        ciudadano.setDepartamentoNacimiento(dto.departamentoNacimiento());
        ciudadano.setProvinciaNacimiento(dto.provinciaNacimiento());
        ciudadano.setDistritoNacimiento(dto.distritoNacimiento());
        ciudadano.setGrupoSanguineo(dto.grupoSanguineo());
        ciudadano.setEstatura(dto.estatura());
        
        if (dto.informacionParental() != null) {
            ciudadano.setInformacionParental(toInformacionParental(dto.informacionParental()));
        }
        
        if (dto.direccionResidencia() != null) {
            ciudadano.setDireccionResidencia(toDireccionResidencia(dto.direccionResidencia()));
        }
        
        if (dto.contacto() != null) {
            ciudadano.setContacto(toContacto(dto.contacto()));
        }
        
        if (dto.informacionElectoral() != null) {
            ciudadano.setInformacionElectoral(toInformacionElectoral(dto.informacionElectoral()));
        }
        
        if (dto.datosBiometricos() != null) {
            ciudadano.setDatosBiometricos(toDatosBiometricos(dto.datosBiometricos()));
        }
        
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
        return new CiudadanoResponseDto(id, ciudadano.getFechaCreacion());
    }
}
