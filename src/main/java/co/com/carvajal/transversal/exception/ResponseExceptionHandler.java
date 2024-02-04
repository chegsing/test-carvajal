package co.com.carvajal.transversal.exception;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import co.com.carvajal.transversal.util.ResponseEntityUtil;
import co.com.carvajal.transversal.validation.IRestResponse;
import co.com.carvajal.transversal.validation.ValidationError;
import lombok.extern.log4j.Log4j2;

/**
 * ResponseExceptionHandler
 * 
 * @author Charles Edinson Gomez
 * since: 04-02-2024
 * 
 */
@Log4j2
@RestController
@ControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(InvalidRequestException.class)
    public ResponseEntity<IRestResponse<List<ValidationError>>> invalidRegistrant(final InvalidRequestException ex) {
        final List<ValidationError> errors = ex.getErrors();
        return ResponseEntityUtil.createResponseValidationError(errors);
    }

    @ExceptionHandler({ Exception.class, NullPointerException.class })
    public ResponseEntity<Object> errorsGlobal(final Exception ex) {
        log.error(ex);
        return ResponseEntityUtil.createResponseError(ex);
    }

    @ExceptionHandler({ BadRequestException.class })
    public ResponseEntity<Object> badRequest(final Exception ex) {
        log.error(ex.getMessage());
        return ResponseEntityUtil.createBadResponse(ex);
    }

    @ExceptionHandler({ InternalServerException.class })
    public ResponseEntity<Object> internalServer(final Exception ex) {
        log.error(ex.getMessage());
        return ResponseEntityUtil.createInternalException(ex);
    }
}
