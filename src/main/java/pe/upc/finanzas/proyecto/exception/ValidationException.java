package pe.upc.finanzas.proyecto.exception;

public class ValidationException extends  RuntimeException{
    public ValidationException() {
    }

    public ValidationException(String message) {
        super(message);
    }
}