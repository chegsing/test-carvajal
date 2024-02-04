package co.com.carvajal.transversal.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;

import co.com.carvajal.transversal.constants.ConfigurationConstants;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Notification
 * 
 * @author Charles Edinson Gomez
 * since: 04-02-2024
 * 
 */
@Data
@JsonRootName(value = "Orders")
@JsonPropertyOrder({ "header", "summary", "detailsItem" })
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Notification implements Serializable {

  @Pattern(regexp = ConfigurationConstants.REGEX_EMAIL, message = "No es un correo")
  private String from;
  @Pattern(regexp = ConfigurationConstants.REGEX_EMAIL, message = "No es un correo")
  private String to;
  @NotNull
  private String subject;
  @NotNull
  private String detail;

  private static final long serialVersionUID = -8275830010026398227L;
}
