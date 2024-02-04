package co.com.carvajal.transversal.validation;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ResponseStatus
 * 
 * @author Charles Edinson Gomez
 * since: 04-02-2024
 * 
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseStatus {

    private String codigo;
    private String mensaje;
    private String estadoTransaccion;
}
