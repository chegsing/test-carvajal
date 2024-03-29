package co.com.carvajal.transversal.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import co.com.carvajal.transversal.constants.ConfigurationConstants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ProfileDTO
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
public class ProfileDTO implements Serializable {

    private Long profileId;
    @NotNull
    @NotBlank
    private String name;
    @NotNull
    @NotBlank
    private String lastname;
    @NotNull
    @NotBlank
    @Pattern(regexp = ConfigurationConstants.REGEX_EMAIL, message = "No es un correo")
    private String email;
    @NotNull
    @NotBlank
    @Pattern(regexp = ConfigurationConstants.REGEX_PASS, message = "Pasword inseguro")
    private String password;
    private String token;
    @JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime creationDate;

    private static final long serialVersionUID = 8094153480314794704L;

}
