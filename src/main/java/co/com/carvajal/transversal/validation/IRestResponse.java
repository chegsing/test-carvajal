package co.com.carvajal.transversal.validation;

/**
 * IRestResponse
 * 
 * @author Charles Edinson Gomez
 * since: 04-02-2024
 * 
 */
public interface IRestResponse<T> {

    ResponseStatus getResponseStatus();

    T getResponse();

    int getHttpStatusCode();
}
