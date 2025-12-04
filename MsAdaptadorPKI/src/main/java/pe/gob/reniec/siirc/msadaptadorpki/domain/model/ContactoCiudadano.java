package pe.gob.reniec.siirc.msadaptadorpki.domain.model;

import java.util.Objects;
import java.util.regex.Pattern;

/**
 * Value Object: Representa la información de contacto de un ciudadano.
 * Encapsula las reglas de validación de email y teléfono.
 */
public class ContactoCiudadano {
    private final Email email;
    private final String telefono;
    private final String direccion;
    private final String usuarioRegistro;

    private ContactoCiudadano(Email email, String telefono, String direccion, String usuarioRegistro) {
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
        this.usuarioRegistro = usuarioRegistro;
    }

    public static ContactoCiudadano de(String emailStr, String telefono, String direccion, String usuarioRegistro) {
        Email email = Email.de(emailStr);
        return new ContactoCiudadano(email, telefono, direccion, usuarioRegistro);
    }

    public Email getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getUsuarioRegistro() {
        return usuarioRegistro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactoCiudadano that = (ContactoCiudadano) o;
        return Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}
