package pe.gob.reniec.coreografia.cotejo.domain.model;

public class EntidadSolicitante {
    private String codigo;
    private String nombre;
    private String ruc;
    private RepresentanteLegal representanteLegal;
    private Contacto contacto;

    public EntidadSolicitante() {
    }

    public EntidadSolicitante(String codigo, String nombre, String ruc, RepresentanteLegal representanteLegal, Contacto contacto) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.ruc = ruc;
        this.representanteLegal = representanteLegal;
        this.contacto = contacto;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public RepresentanteLegal getRepresentanteLegal() {
        return representanteLegal;
    }

    public void setRepresentanteLegal(RepresentanteLegal representanteLegal) {
        this.representanteLegal = representanteLegal;
    }

    public Contacto getContacto() {
        return contacto;
    }

    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }
}
