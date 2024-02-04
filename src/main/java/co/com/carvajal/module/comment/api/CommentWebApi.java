package co.com.carvajal.module.comment.api;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.carvajal.module.comment.service.CommentService;
import co.com.carvajal.transversal.constants.ConfigurationConstants;
import co.com.carvajal.transversal.dto.CommentDTO;
import co.com.carvajal.transversal.util.ValidUtil;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

/**
 * CommentWebApi
 * 
 * @author Charles Edinson Gomez
 * @since 04-02-2024
 * 
 */
@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping(
        value = ConfigurationConstants.REQUEST_COMMENT,
        produces = { MediaType.APPLICATION_JSON_VALUE })
public class CommentWebApi {

  private final CommentService controller;

  @ApiOperation(value = "",
      nickname = "",
      notes = "",
      response = ResponseEntity.class)
  @PostMapping()
  public ResponseEntity<Object> createProfile(
      @Valid final @RequestBody CommentDTO commentDTO,
      final BindingResult result) {
    ValidUtil.validateBindingResult(result);
    return ResponseEntity.ok(controller.createComment(commentDTO));
  }

}
