package co.com.carvajal.module.profile.api;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.com.carvajal.module.profile.service.ProfileService;
import co.com.carvajal.transversal.constants.ConfigurationConstants;
import co.com.carvajal.transversal.dto.ProfileDTO;
import co.com.carvajal.transversal.util.ValidUtil;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

/**
 * ProfileService
 *
 * @author Charles Edinson Gomez
 * @since 04-02-2024
 *
 */
@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping(
        value = ConfigurationConstants.REQUEST_PROFILE,
        produces = { MediaType.APPLICATION_JSON_VALUE })
public class ProfileWebApi {

  private final ProfileService profileService;

  @ApiOperation(value = "",
                nickname = "",
                notes = "",
                response = ResponseEntity.class)
  @PostMapping(name = "")
  public ResponseEntity<Object> createProfile(
      @Valid final @RequestBody ProfileDTO profileDTO,
      final BindingResult result) {
    ValidUtil.validateBindingResult(result);
    profileService.createProfile(profileDTO);
    return ResponseEntity.ok(null);
  }
  
  @ApiOperation(value = "",
      nickname = "",
      notes = "",
      response = ResponseEntity.class)
  @GetMapping(name = "")
  public ResponseEntity<Object> findByHint(final @RequestParam String hint) {
    return ResponseEntity.ok(profileService.findByHint(hint));
  }
}
