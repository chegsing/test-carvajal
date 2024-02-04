package co.com.carvajal.module.reaction.api;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.carvajal.module.reaction.service.ReactionService;
import co.com.carvajal.transversal.constants.ConfigurationConstants;
import co.com.carvajal.transversal.dto.ReactionDTO;
import co.com.carvajal.transversal.util.ValidUtil;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

/**
 * ReactionWebApi
 *
 * @author Charles Edinson Gomez
 * @since 04-02-2024
 *
 */
@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping(
        value = ConfigurationConstants.REQUEST_REACTION,
        produces = { MediaType.APPLICATION_JSON_VALUE })
public class ReactionWebApi {

  private final ReactionService reactionService;

  @ApiOperation(value = "",
      nickname = "",
      notes = "",
      response = ResponseEntity.class)
  @PostMapping()
  public ResponseEntity<Object> createProfile(
      @Valid final @RequestBody ReactionDTO reactionDTO,
      final BindingResult result) {
    ValidUtil.validateBindingResult(result);
    return ResponseEntity.ok(reactionService.createReaction(reactionDTO));
  }

}
