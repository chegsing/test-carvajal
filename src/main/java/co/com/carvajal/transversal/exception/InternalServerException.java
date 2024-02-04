package co.com.carvajal.transversal.exception;

/**
 * InternalServerException
 * 
 * @author Charles Edinson Gomez
 * since: 04-02-2024
 * 
 */
public class InternalServerException extends RuntimeException {

    private static final long serialVersionUID = -5372939932164008617L;

    public InternalServerException(String detail) {
        super(detail);
    }

}
