package co.com.carvajal.transversal.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.BindingResult;

import co.com.carvajal.transversal.exception.InvalidRequestException;
import co.com.carvajal.transversal.validation.ValidationError;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * ValidUtil
 * 
 * @author Charles Edinson Gomez
 * since: 04-02-2024
 * 
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ValidUtil {

    private static List<ValidationError> getListBindingResultErrors(final BindingResult bindingResult) {

        final List<ValidationError> errors = new ArrayList<>();

        if (bindingResult == null) {
            return errors;
        }

        bindingResult.getFieldErrors().forEach(error ->
            errors.add(ValidationError.builder()
                    .defaultMessage(error.getDefaultMessage())
                    .code(error.getCode())
                    .field(error.getField())
                    .build()));

        return errors;
    }

    public static void validateBindingResult(final BindingResult result) {
        final List<ValidationError> errors = ValidUtil.getListBindingResultErrors(result);
        if (!errors.isEmpty()) {
            throw new InvalidRequestException(errors);
        }
    }
}
