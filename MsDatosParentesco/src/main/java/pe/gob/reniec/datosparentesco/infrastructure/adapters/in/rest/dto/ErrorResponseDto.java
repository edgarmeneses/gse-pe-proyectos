package pe.gob.reniec.datosparentesco.infrastructure.adapters.in.rest.dto;

/**
 * DTO de response para errores.
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
