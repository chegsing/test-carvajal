package co.com.carvajal.transversal.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonInclude;

import co.com.carvajal.transversal.constants.ConfigurationConstants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * UpdatePassword
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
public class UpdatePassword implements Serializable {

    @NotNull
    @NotBlank
    @Pattern(regexp = ConfigurationConstants.REGEX_EMAIL, message = "No es un correo")
    private String email;

    private static final long serialVersionUID = 8094153480314794704L;

}
