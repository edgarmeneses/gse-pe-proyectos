package pe.gob.onpe.dominio.tachareclamo.application.service;

import pe.gob.onpe.dominio.tachareclamo.domain.model.Ciudadano;
import pe.gob.onpe.dominio.tachareclamo.domain.ports.in.RegistrarCiudadanoUseCase;

import java.time.LocalDateTime;

public class RegistrarCiudadanoService implements RegistrarCiudadanoUseCase {

    @Override
    public Ciudadano registrar(Ciudadano ciudadano) {
        // Validar DNI (8 dígitos)
        if (ciudadano.getDni() == null || !ciudadano.getDni().matches("\\d{8}")) {
            throw new IllegalArgumentException("DNI debe tener 8 dígitos");
        }

        // Validar nombres y apellidos obligatorios
        if (ciudadano.getNombres() == null || ciudadano.getNombres().trim().isEmpty()) {
            throw new IllegalArgumentException("Nombres son obligatorios");
        }
        if (ciudadano.getApellidoPaterno() == null || ciudadano.getApellidoPaterno().trim().isEmpty()) {
            throw new IllegalArgumentException("Apellido Paterno es obligatorio");
        }
        if (ciudadano.getApellidoMaterno() == null || ciudadano.getApellidoMaterno().trim().isEmpty()) {
            throw new IllegalArgumentException("Apellido Materno es obligatorio");
        }

        // Validar fecha de nacimiento
        if (ciudadano.getFechaNacimiento() == null || 
            !ciudadano.getFechaNacimiento().isBefore(java.time.LocalDate.now())) {
            throw new IllegalArgumentException("Fecha de nacimiento debe ser anterior a hoy");
        }

        // Establecer fecha de registro
        ciudadano.setFechaRegistro(LocalDateTime.now());

        // En un escenario real, aquí se invocaría un puerto de salida para persistir
        // Por ahora solo retornamos el ciudadano validado
        return ciudadano;
    }
}
