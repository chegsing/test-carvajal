package co.com.carvajal.module.publication.api;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.com.carvajal.module.publication.service.PublicationService;
import co.com.carvajal.transversal.constants.ConfigurationConstants;
import co.com.carvajal.transversal.dto.PublicationDTO;
import co.com.carvajal.transversal.util.ValidUtil;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

/**
 * PublicationWebApi
 *
 * @author Charles Edinson Gomez
 * @since 04-02-2024
 *
 */
@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping(
        value = ConfigurationConstants.REQUEST_PUBLICATION,
        produces = { MediaType.APPLICATION_JSON_VALUE })
public class PublicationWebApi {

  private final PublicationService controller;

  @ApiOperation(value = "",
                nickname = "",
                notes = "",
                response = ResponseEntity.class)
  @GetMapping()
  public ResponseEntity<Object> getPublicationsProfile(
      final @RequestParam Long idProfile) {
    return ResponseEntity.ok(controller.getPublicationsByProfile(idProfile));
  }

  @ApiOperation(value = "",
      nickname = "",
      notes = "",
      response = ResponseEntity.class)
  @PostMapping()
  public ResponseEntity<Object> createProfile(
      @Valid final @RequestBody PublicationDTO publicationDTO,
      final BindingResult result) {
    ValidUtil.validateBindingResult(result);
    return ResponseEntity.ok(controller.createPublications(publicationDTO));
  }
  
  @ApiOperation(value = "",
      nickname = "",
      notes = "",
      response = ResponseEntity.class)
  @PutMapping()
  public ResponseEntity<Object> updateProfile(
      @Valid final @RequestBody PublicationDTO publicationDTO,
      final BindingResult result) {
    ValidUtil.validateBindingResult(result);
    return ResponseEntity.ok(controller.updatePublications(publicationDTO));
  }
  
  @ApiOperation(value = "",
      nickname = "",
      notes = "",
      response = ResponseEntity.class)
  @DeleteMapping("/{id}")
  public ResponseEntity<Object> deleteProfile(@PathVariable("id") Long itemId) {
    controller.deletePublications(itemId);
    return ResponseEntity.ok(null);
  }
}
