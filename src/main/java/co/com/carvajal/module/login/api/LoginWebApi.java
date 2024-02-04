package co.com.carvajal.module.login.api;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.carvajal.module.login.service.LoginService;
import co.com.carvajal.transversal.constants.ConfigurationConstants;
import co.com.carvajal.transversal.dto.Login;
import co.com.carvajal.transversal.dto.UpdatePassword;
import co.com.carvajal.transversal.util.ValidUtil;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

/**
 * LoginWebApi
 *
 * @author Charles Edinson Gomez
 * @since 04-02-2024
 *
 */
@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping(
        value = ConfigurationConstants.REQUEST_LOGIN,
        produces = { MediaType.APPLICATION_JSON_VALUE })
public class LoginWebApi {

  private final LoginService loginController;

  @ApiOperation(value = "",
                nickname = "",
                notes = "",
                response = ResponseEntity.class)
  @PostMapping()
  public ResponseEntity<Object> login(
      @Valid final @RequestBody Login login,
      final BindingResult result) {
    ValidUtil.validateBindingResult(result);
    return ResponseEntity.ok(loginController.loginProfile(login));
  }

  @ApiOperation(value = "",
      nickname = "",
      notes = "",
      response = ResponseEntity.class)
  @PostMapping("/remember-pass")
  public ResponseEntity<Object> rememberPass(
      @Valid final @RequestBody UpdatePassword updatePassword,
      final BindingResult result) {
    ValidUtil.validateBindingResult(result);
    loginController.rememberPass(updatePassword);
    return ResponseEntity.ok(null);
  }
  
  @ApiOperation(value = "",
      nickname = "",
      notes = "",
      response = ResponseEntity.class)
  @GetMapping("/token")
  public ResponseEntity<Object> generatetoken() {
    return ResponseEntity.ok(loginController.token());
  }
}
