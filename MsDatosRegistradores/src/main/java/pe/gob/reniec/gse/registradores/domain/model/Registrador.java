package pe.gob.reniec.gse.registradores.domain.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Aggregate Root: Registrador
 * Representa un registrador civil en el sistema del RENIEC.
 * 
 * Responsabilidades:
 * - Gestionar la identidad del registrador
 * - Controlar el estado y asignaciones del registrador
 * - Validar operaciones sobre firma y sello
 * - Mantener el historial de periodos de asignación
 */
public class Registrador {
    
    // Identidad
    private final String idRegistrador;
    private final String numeroDni;
    
    // Información personal
    private String primerApellido;
    private String segundoApellido;
    private String prenombres;
    private String numeroImagen;
    
    // Información laboral
    private String codigoLocal;
    private String tipoRegistrador;
    private String observaciones;
    
    // Estado actual
    private EstadoRegistrador estado;
    
    // Elementos de autenticación
    private Firma firma;
    private Sello sello;
    
    // Historial de periodos (inmutable desde fuera)
    private final List<Periodo> periodos;
    
    // Auditoría
    private final LocalDateTime fechaCreacion;
    private final String usuarioCreacion;
    private LocalDateTime fechaModificacion;
    private String usuarioModificacion;
    
    /**
     * Constructor privado para reconstrucción desde persistencia
     */
    private Registrador(String idRegistrador, String numeroDni) {
        this.idRegistrador = Objects.requireNonNull(idRegistrador, "ID Registrador es obligatorio");
        this.numeroDni = Objects.requireNonNull(numeroDni, "Número DNI es obligatorio");
        this.periodos = new ArrayList<>();
        this.fechaCreacion = LocalDateTime.now();
        this.usuarioCreacion = null; // Se establecerá desde la capa de aplicación
    }
    
    /**
     * Crea un nuevo registrador civil.
     */
    public static Registrador crear(
            String idRegistrador,
            String numeroDni,
            String primerApellido,
            String segundoApellido,
            String prenombres,
            String codigoLocal,
            String tipoRegistrador,
            String observaciones) {
        
        validarDatosObligatorios(idRegistrador, numeroDni, primerApellido, prenombres, codigoLocal);
        
        Registrador registrador = new Registrador(idRegistrador, numeroDni);
        registrador.primerApellido = primerApellido;
        registrador.segundoApellido = segundoApellido;
        registrador.prenombres = prenombres;
        registrador.codigoLocal = codigoLocal;
        registrador.tipoRegistrador = tipoRegistrador;
        registrador.observaciones = observaciones;
        registrador.estado = EstadoRegistrador.ACTIVO;
        
        return registrador;
    }
    
    /**
     * Reconstruye un registrador desde persistencia.
     */
    public static Registrador reconstruir(
            String idRegistrador,
            String numeroDni,
            String primerApellido,
            String segundoApellido,
            String prenombres,
            String numeroImagen,
            String codigoLocal,
            String tipoRegistrador,
            String observaciones,
            EstadoRegistrador estado,
            Firma firma,
            Sello sello,
            List<Periodo> periodos,
            LocalDateTime fechaCreacion,
            String usuarioCreacion,
            LocalDateTime fechaModificacion,
            String usuarioModificacion) {
        
        Registrador registrador = new Registrador(idRegistrador, numeroDni);
        registrador.primerApellido = primerApellido;
        registrador.segundoApellido = segundoApellido;
        registrador.prenombres = prenombres;
        registrador.numeroImagen = numeroImagen;
        registrador.codigoLocal = codigoLocal;
        registrador.tipoRegistrador = tipoRegistrador;
        registrador.observaciones = observaciones;
        registrador.estado = estado != null ? estado : EstadoRegistrador.ACTIVO;
        registrador.firma = firma;
        registrador.sello = sello;
        if (periodos != null) {
            registrador.periodos.addAll(periodos);
        }
        
        return registrador;
    }
    
    // ========== COMPORTAMIENTO DE NEGOCIO ==========
    
    /**
     * Registra la firma del registrador.
     */
    public void registrarFirma(String hashFirma, String usuarioQueRegistra) {
        Objects.requireNonNull(hashFirma, "Hash de firma es obligatorio");
        validarEstadoActivo();
        
        this.firma = Firma.crear(hashFirma);
        actualizarModificacion(usuarioQueRegistra);
    }
    
    /**
     * Actualiza la firma existente del registrador.
     */
    public void actualizarFirma(String nuevoHashFirma, String usuarioQueActualiza) {
        Objects.requireNonNull(nuevoHashFirma, "Nuevo hash de firma es obligatorio");
        validarEstadoActivo();
        
        if (this.firma == null) {
            throw new IllegalStateException("No existe firma previa para actualizar");
        }
        
        this.firma = this.firma.actualizar(nuevoHashFirma);
        actualizarModificacion(usuarioQueActualiza);
    }
    
    /**
     * Registra el sello del registrador.
     */
    public void registrarSello(String hashSello, String usuarioQueRegistra) {
        Objects.requireNonNull(hashSello, "Hash de sello es obligatorio");
        validarEstadoActivo();
        
        this.sello = Sello.crear(hashSello);
        actualizarModificacion(usuarioQueRegistra);
    }
    
    /**
     * Actualiza el sello existente del registrador.
     */
    public void actualizarSello(String nuevoHashSello, String usuarioQueActualiza) {
        Objects.requireNonNull(nuevoHashSello, "Nuevo hash de sello es obligatorio");
        validarEstadoActivo();
        
        if (this.sello == null) {
            throw new IllegalStateException("No existe sello previo para actualizar");
        }
        
        this.sello = this.sello.actualizar(nuevoHashSello);
        actualizarModificacion(usuarioQueActualiza);
    }
    
    /**
     * Agrega un nuevo periodo de asignación.
     */
    public void agregarPeriodo(Periodo periodo) {
        Objects.requireNonNull(periodo, "Periodo es obligatorio");
        validarEstadoActivo();
        
        // Validar que no se solape con periodos existentes
        for (Periodo p : periodos) {
            if (p.seSuperpone(periodo)) {
                throw new IllegalStateException(
                    "El periodo se superpone con otro periodo existente"
                );
            }
        }
        
        this.periodos.add(periodo);
    }
    
    /**
     * Inactiva el registrador.
     */
    public void inactivar(String usuarioQueInactiva) {
        if (this.estado == EstadoRegistrador.INACTIVO) {
            throw new IllegalStateException("El registrador ya está inactivo");
        }
        
        this.estado = EstadoRegistrador.INACTIVO;
        actualizarModificacion(usuarioQueInactiva);
    }
    
    /**
     * Reactiva el registrador.
     */
    public void reactivar(String usuarioQueReactiva) {
        if (this.estado == EstadoRegistrador.ACTIVO) {
            throw new IllegalStateException("El registrador ya está activo");
        }
        
        this.estado = EstadoRegistrador.ACTIVO;
        actualizarModificacion(usuarioQueReactiva);
    }
    
    /**
     * Actualiza los datos personales del registrador.
     */
    public void actualizarDatosPersonales(
            String primerApellido,
            String segundoApellido,
            String prenombres,
            String usuarioQueActualiza) {
        
        Objects.requireNonNull(primerApellido, "Primer apellido es obligatorio");
        Objects.requireNonNull(prenombres, "Prenombres son obligatorios");
        
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.prenombres = prenombres;
        actualizarModificacion(usuarioQueActualiza);
    }
    
    // ========== CONSULTAS DE DOMINIO ==========
    
    /**
     * Obtiene el nombre completo construido.
     */
    public String obtenerNombreCompleto() {
        StringBuilder nombre = new StringBuilder();
        if (prenombres != null && !prenombres.isEmpty()) {
            nombre.append(prenombres);
        }
        if (primerApellido != null && !primerApellido.isEmpty()) {
            if (nombre.length() > 0) nombre.append(" ");
            nombre.append(primerApellido);
        }
        if (segundoApellido != null && !segundoApellido.isEmpty()) {
            if (nombre.length() > 0) nombre.append(" ");
            nombre.append(segundoApellido);
        }
        return nombre.toString();
    }
    
    /**
     * Verifica si el registrador tiene firma registrada.
     */
    public boolean tieneFirmaRegistrada() {
        return firma != null && firma.estaRegistrada();
    }
    
    /**
     * Verifica si el registrador tiene sello registrado.
     */
    public boolean tieneSelloRegistrado() {
        return sello != null && sello.estaRegistrado();
    }
    
    /**
     * Verifica si el registrador está activo.
     */
    public boolean estaActivo() {
        return estado == EstadoRegistrador.ACTIVO;
    }
    
    /**
     * Obtiene la lista inmutable de periodos.
     */
    public List<Periodo> obtenerPeriodos() {
        return Collections.unmodifiableList(periodos);
    }
    
    // ========== VALIDACIONES PRIVADAS ==========
    
    private static void validarDatosObligatorios(
            String idRegistrador,
            String numeroDni,
            String primerApellido,
            String prenombres,
            String codigoLocal) {
        
        if (idRegistrador == null || idRegistrador.trim().isEmpty()) {
            throw new IllegalArgumentException("ID Registrador es obligatorio");
        }
        if (numeroDni == null || numeroDni.trim().isEmpty()) {
            throw new IllegalArgumentException("Número DNI es obligatorio");
        }
        if (numeroDni.length() != 8) {
            throw new IllegalArgumentException("Número DNI debe tener 8 dígitos");
        }
        if (primerApellido == null || primerApellido.trim().isEmpty()) {
            throw new IllegalArgumentException("Primer apellido es obligatorio");
        }
        if (prenombres == null || prenombres.trim().isEmpty()) {
            throw new IllegalArgumentException("Prenombres son obligatorios");
        }
        if (codigoLocal == null || codigoLocal.trim().isEmpty()) {
            throw new IllegalArgumentException("Código local es obligatorio");
        }
        if (codigoLocal.length() != 6) {
            throw new IllegalArgumentException("Código local debe tener 6 caracteres");
        }
    }
    
    private void validarEstadoActivo() {
        if (estado != EstadoRegistrador.ACTIVO) {
            throw new IllegalStateException(
                "La operación solo es permitida para registradores activos"
            );
        }
    }
    
    private void actualizarModificacion(String usuario) {
        this.fechaModificacion = LocalDateTime.now();
        this.usuarioModificacion = usuario;
    }
    
    // ========== GETTERS (solo para lectura) ==========
    
    public String getIdRegistrador() {
        return idRegistrador;
    }
    
    public String getNumeroDni() {
        return numeroDni;
    }
    
    public String getPrimerApellido() {
        return primerApellido;
    }
    
    public String getSegundoApellido() {
        return segundoApellido;
    }
    
    public String getPrenombres() {
        return prenombres;
    }
    
    public String getNumeroImagen() {
        return numeroImagen;
    }
    
    public String getCodigoLocal() {
        return codigoLocal;
    }
    
    public String getTipoRegistrador() {
        return tipoRegistrador;
    }
    
    public String getObservaciones() {
        return observaciones;
    }
    
    public EstadoRegistrador getEstado() {
        return estado;
    }
    
    public Firma getFirma() {
        return firma;
    }
    
    public Sello getSello() {
        return sello;
    }
    
    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }
    
    public String getUsuarioCreacion() {
        return usuarioCreacion;
    }
    
    public LocalDateTime getFechaModificacion() {
        return fechaModificacion;
    }
    
    public String getUsuarioModificacion() {
        return usuarioModificacion;
    }
    
    public void setNumeroImagen(String numeroImagen) {
        this.numeroImagen = numeroImagen;
    }
}
