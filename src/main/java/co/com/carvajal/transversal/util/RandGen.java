package co.com.carvajal.transversal.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * RandGen
 * 
 * @author Charles Edinson Gomez
 * since: 04-02-2024
 * 
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RandGen {

    public static int randNum() {
        double random = Math.random();
        double x = random * 100;
        return (int) x + 1;
    }
}
