package co.com.carvajal.transversal.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import co.com.carvajal.transversal.constants.ConfigurationConstants;
import co.com.carvajal.transversal.enums.ResponseStatusCodes;
import co.com.carvajal.transversal.validation.IRestResponse;
import co.com.carvajal.transversal.validation.ResponseStatus;
import co.com.carvajal.transversal.validation.ResponseStatusCode;
import co.com.carvajal.transversal.validation.RestResponse;
import co.com.carvajal.transversal.validation.ValidationError;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * ResponseEntityUtil
 * 
 * @author Charles Edinson Gomez
 * since: 04-02-2024
 * 
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ResponseEntityUtil {

    public static <T> ResponseEntity<IRestResponse<T>> createResponseEntity(final IRestResponse<T> response) {
        return ResponseEntity
                .status(HttpStatus.valueOf(response.getHttpStatusCode()))
                .body(response);
    }

    public static ResponseEntity<IRestResponse<List<ValidationError>>> createResponseValidationError(
            final List<ValidationError> errors) {
        
        final RestResponse<List<ValidationError>> fullResponse = new RestResponse<>();
        if (errors != null && !errors.isEmpty()) {
            final ResponseStatus status = getErrorResponseStatus("Validation error");
            fullResponse.setResponse(errors);
            fullResponse.setResponseStatus(status);
            fullResponse.setHttpStatusCode(HttpStatus.BAD_REQUEST.value());
        } else {
            fullResponse.setResponseStatus(ResponseStatus.builder()
                    .codigo(ResponseStatusCode.ERROR.toString())
                    .build());
            fullResponse.setHttpStatusCode(HttpStatus.BAD_REQUEST.value());
        }
        return createResponseEntity(fullResponse);
    }

    public static <T> ResponseEntity<IRestResponse<T>> createSuccessfulResponse(
            final String message,
            final int httpStatusCode,
            final T response) {
        final ResponseStatus status = getSuccessResponseStatus(message);
        final RestResponse<T> fullResponse = new RestResponse<>();
        fullResponse.setResponseStatus(status);
        fullResponse.setHttpStatusCode(httpStatusCode);
        fullResponse.setResponse(response);
        return createResponseEntity(fullResponse);
    }

    public static ResponseEntity<Object> createResponseError(Exception ex) {
        Map<String, Object> response = new HashMap<>();
        response.put(ConfigurationConstants.RESPONSE_STATUS,
                ResponseStatus.builder()
                .codigo(ResponseStatusCode.ERROR.toString())
                .mensaje(ex.getMessage())
                .build());
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(response);
    }

    public static ResponseEntity<Object> createBadResponse(Exception ex) {
        ResponseStatusCodes responseStatus = ResponseStatusCodes.getCodeStatus(ex.getMessage());
        Map<String, Object> response = new HashMap<>();
        response.put(ConfigurationConstants.RESPONSE_STATUS,
                ResponseStatus.builder()
                .codigo(responseStatus == null ? ResponseStatusCode.ERROR.toString() : responseStatus.getResponseCode())
                .mensaje(ex.getMessage())
                .build());
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(response);
    }

    private static ResponseStatus getErrorResponseStatus(final String message) {
        return ResponseStatus.builder()
                .mensaje(message)
                .codigo(ResponseStatusCode.ERROR.toString())
                .build();
    }

    private static ResponseStatus getSuccessResponseStatus(final String message) {
        return ResponseStatus.builder()
                .mensaje(message)
                .codigo(ResponseStatusCode.OK.toString())
                .build();
    }

    public static ResponseEntity<Object> createInternalException(Exception ex) {
        Map<String, Object> response = new HashMap<>();
        ResponseStatusCodes responseStatus = ResponseStatusCodes.getCodeStatus(ex.getMessage());
        response.put(ConfigurationConstants.RESPONSE_STATUS,
                ResponseStatus.builder()
                .codigo(responseStatus == null ? ResponseStatusCode.ERROR.toString() : responseStatus.getResponseCode())
                .mensaje(ex.getMessage())
                .build());
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(response);
    }

    public static ResponseEntity<Object> createBadResponseTransaction(Exception ex) {
        ResponseStatusCodes responseStatus = ResponseStatusCodes.getCodeStatus(ex.getMessage());
        Map<String, Object> response = new HashMap<>();
        response.put(ConfigurationConstants.RESPONSE_STATUS,
                ResponseStatus.builder()
                .codigo(responseStatus == null ? ResponseStatusCode.ERROR.toString() : responseStatus.getResponseCode())
                .mensaje(ex.getMessage())
                .estadoTransaccion(ResponseStatusCodes.REJECT.getResponseDetail())
                .build());
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(response);
    }
}
