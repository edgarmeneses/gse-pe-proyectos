package pe.gob.onpe.datos.electoral.domain.ports.in;

import pe.gob.onpe.datos.electoral.domain.model.Analisis;

public interface RegistrarAnalisisUseCase {
    Analisis registrar(Analisis analisis);
}
