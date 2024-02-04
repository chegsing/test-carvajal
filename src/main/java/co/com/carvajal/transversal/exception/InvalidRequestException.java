package co.com.carvajal.transversal.exception;

import java.util.List;

import co.com.carvajal.transversal.validation.ValidationError;

/**
 * InvalidRequestException
 * 
 * @author Charles Edinson Gomez
 * since: 04-02-2024
 * 
 */
public class InvalidRequestException extends RuntimeException {

    private static final long serialVersionUID = 5986087872673515973L;
    private final List<ValidationError> errors;

    public InvalidRequestException(final List<ValidationError> errors) {
        super("InvalidRequestException");
        this.errors = errors;
    }

    public List<ValidationError> getErrors() {
        return this.errors;
    }
}
