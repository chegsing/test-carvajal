package co.com.carvajal.transversal.pattern;

/**
 * Translator
 * 
 * @author Charles Edinson Gomez
 * since: 04-02-2024
 * 
 */

@FunctionalInterface
public interface Translator<I, O> {

    O to(final I input);

}
