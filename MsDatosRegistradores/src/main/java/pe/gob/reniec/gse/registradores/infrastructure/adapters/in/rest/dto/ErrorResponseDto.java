package pe.gob.reniec.gse.registradores.infrastructure.adapters.in.rest.dto;

import java.util.List;

/**
 * DTO: Error Response
 */
public class ErrorResponseDto {
    private ErrorDto error;

    public ErrorResponseDto() {
    }

    public ErrorResponseDto(ErrorDto error) {
        this.error = error;
    }

    public ErrorDto getError() {
        return error;
    }

    public void setError(ErrorDto error) {
        this.error = error;
    }
}
