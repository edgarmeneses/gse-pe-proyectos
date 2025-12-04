package pe.gob.reniec.dominioparentesco.infrastructure.adapters.in.rest.dto;

/**
 * DTO para errores en la respuesta.
 */
public class ErrorResponseDto {
    private ErrorDto error;

    public ErrorResponseDto() {}

    public ErrorResponseDto(ErrorDto error) {
        this.error = error;
    }

    public ErrorDto getError() { return error; }
    public void setError(ErrorDto error) { this.error = error; }
}
