package co.com.carvajal.transversal.translators;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import co.com.carvajal.transversal.dto.ProfileDTO;
import co.com.carvajal.transversal.jpa.entity.Profile;
import co.com.carvajal.transversal.pattern.Translator;

/**
 * ProfileToProfileDTO
 * 
 * @author Charles Edinson Gomez
 * since: 04-02-2024
 * 
 */
@Component
@Qualifier("profileToProfileDTO")
public class ProfileToProfileDTO implements Translator<Profile, ProfileDTO> {

  @Override
  public ProfileDTO to(Profile input) {
    return input != null ? ProfileDTO.builder()
        .profileId(input.getProfileId())
        .name(input.getName())
        .lastname(input.getLastname())
        .email(input.getEmail())
        .creationDate(input.getCreationDate())
        .build() : null;
  }
}
