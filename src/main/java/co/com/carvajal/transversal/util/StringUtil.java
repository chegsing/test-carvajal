package co.com.carvajal.transversal.util;

import java.util.Objects;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * StringUtil
 * 
 * @author Charles Edinson Gomez
 * since: 04-02-2024
 * 
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class StringUtil {

    public static boolean isEmptyOrNull(final String string) {
        return Objects.isNull(string) || string.isBlank();
    }

}
