package co.com.carvajal.module.notification.api;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.carvajal.module.notification.service.EmailService;
import co.com.carvajal.transversal.constants.ConfigurationConstants;
import co.com.carvajal.transversal.dto.Notification;
import co.com.carvajal.transversal.util.ValidUtil;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

/**
 * NotificationWebApi
 *
 * @author Charles Edinson Gomez
 * @since 04-02-2024
 *
 */
@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping(value = ConfigurationConstants.REQUEST_NOTIFICATION,
                produces = { MediaType.APPLICATION_JSON_VALUE })
public class NotificationWebApi {
  
  private final EmailService emailService;

  @ApiOperation(value = "",
                nickname = "",
                notes = "",
                response = ResponseEntity.class)
  @PostMapping(name = "")
  public ResponseEntity<Object> createCard(
      @Valid final @RequestBody Notification notification,
      final BindingResult result) {
    ValidUtil.validateBindingResult(result);
    emailService.send(notification.getFrom(),
                      notification.getTo(),
                      notification.getSubject(),
                      notification.getDetail());
    return ResponseEntity.status(HttpStatus.CREATED).body("");
  }
}