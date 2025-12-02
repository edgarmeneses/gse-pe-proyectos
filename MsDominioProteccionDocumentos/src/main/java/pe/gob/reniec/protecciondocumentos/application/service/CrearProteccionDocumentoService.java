package pe.gob.reniec.protecciondocumentos.application.service;

import pe.gob.reniec.protecciondocumentos.domain.model.ConfiguracionProteccion;
import pe.gob.reniec.protecciondocumentos.domain.model.ProteccionDocumento;
import pe.gob.reniec.protecciondocumentos.domain.model.SolicitudProteccion;
import pe.gob.reniec.protecciondocumentos.domain.ports.in.CrearProteccionDocumentoUseCase;
import pe.gob.reniec.protecciondocumentos.domain.ports.out.ConfiguracionDataPort;
import pe.gob.reniec.protecciondocumentos.domain.ports.out.GestorDocumentosDataPort;
import pe.gob.reniec.protecciondocumentos.domain.ports.out.ProteccionDocumentoDataPort;

public class CrearProteccionDocumentoService implements CrearProteccionDocumentoUseCase {

    private final ProteccionDocumentoDataPort proteccionDocumentoDataPort;
    private final ConfiguracionDataPort configuracionDataPort;
    private final GestorDocumentosDataPort gestorDocumentosDataPort;

    public CrearProteccionDocumentoService(ProteccionDocumentoDataPort proteccionDocumentoDataPort,
                                          ConfiguracionDataPort configuracionDataPort,
                                          GestorDocumentosDataPort gestorDocumentosDataPort) {
        this.proteccionDocumentoDataPort = proteccionDocumentoDataPort;
        this.configuracionDataPort = configuracionDataPort;
        this.gestorDocumentosDataPort = gestorDocumentosDataPort;
    }

    @Override
    public ProteccionDocumento crearProteccionDocumento(SolicitudProteccion solicitudProteccion) {
        // Validar si ya existe protección para esta solicitud
        if (proteccionDocumentoDataPort.existeProteccionPorSolicitudId(solicitudProteccion.getSolicitudId())) {
            throw new UnsupportedOperationException("Ya existe una protección para esta solicitud");
        }

        // Obtener o validar configuración
        ConfiguracionProteccion configuracion = solicitudProteccion.getConfiguracionProteccion();
        if (configuracion == null || Boolean.TRUE.equals(configuracion.getUsarConfiguracionPorDefecto())) {
            configuracion = configuracionDataPort.obtenerConfiguracionPorDefecto();
        } else {
            configuracion = configuracionDataPort.validarConfiguracion(configuracion);
        }

        // Obtener documento desde repositorio o base64
        obtenerDocumento(solicitudProteccion);

        // Aquí iría la lógica de compresión y protección con password
        // Por ahora, lanza UnsupportedOperationException ya que no hay implementación real
        throw new UnsupportedOperationException("Lógica de compresión y protección no implementada");
    }

    private byte[] obtenerDocumento(SolicitudProteccion solicitudProteccion) {
        if ("BASE64".equalsIgnoreCase(solicitudProteccion.getFuenteDocumento().getTipo())) {
            // Decodificar base64 (sin implementación real)
            throw new UnsupportedOperationException("Decodificación Base64 no implementada");
        } else if ("REPOSITORIO".equalsIgnoreCase(solicitudProteccion.getFuenteDocumento().getTipo())) {
            var referencia = solicitudProteccion.getFuenteDocumento().getReferenciaRepositorio();
            return gestorDocumentosDataPort.obtenerDocumento(
                referencia.getRepositorioId(),
                referencia.getDocumentoId(),
                referencia.getVersionId()
            );
        } else {
            throw new UnsupportedOperationException("Tipo de fuente no soportado: " + 
                solicitudProteccion.getFuenteDocumento().getTipo());
        }
    }
}
