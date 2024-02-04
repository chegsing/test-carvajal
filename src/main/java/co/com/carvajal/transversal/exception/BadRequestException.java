package co.com.carvajal.transversal.exception;

/**
 * BadRequestException
 * 
 * @author Charles Edinson Gomez
 * since: 04-02-2024
 * 
 */
public class BadRequestException extends RuntimeException {

    private static final long serialVersionUID = -5372939932064008617L;

    public BadRequestException(String detail) {
        super(detail);
    }

}
