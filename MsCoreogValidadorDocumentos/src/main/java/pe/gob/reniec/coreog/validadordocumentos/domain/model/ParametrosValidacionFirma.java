package pe.gob.reniec.coreog.validadordocumentos.domain.model;

/**
 * Objeto de valor que representa parámetros de validación de firma
 */
public class ParametrosValidacionFirma {
    private Boolean validarContraBDRegistradores;
    private Boolean validarPeriodoVigencia;
    private Boolean validarCertificadoDigital;

    public ParametrosValidacionFirma() {
    }

    public ParametrosValidacionFirma(Boolean validarContraBDRegistradores, 
                                     Boolean validarPeriodoVigencia, 
                                     Boolean validarCertificadoDigital) {
        this.validarContraBDRegistradores = validarContraBDRegistradores;
        this.validarPeriodoVigencia = validarPeriodoVigencia;
        this.validarCertificadoDigital = validarCertificadoDigital;
    }

    public Boolean getValidarContraBDRegistradores() {
        return validarContraBDRegistradores;
    }

    public void setValidarContraBDRegistradores(Boolean validarContraBDRegistradores) {
        this.validarContraBDRegistradores = validarContraBDRegistradores;
    }

    public Boolean getValidarPeriodoVigencia() {
        return validarPeriodoVigencia;
    }

    public void setValidarPeriodoVigencia(Boolean validarPeriodoVigencia) {
        this.validarPeriodoVigencia = validarPeriodoVigencia;
    }

    public Boolean getValidarCertificadoDigital() {
        return validarCertificadoDigital;
    }

    public void setValidarCertificadoDigital(Boolean validarCertificadoDigital) {
        this.validarCertificadoDigital = validarCertificadoDigital;
    }
}
