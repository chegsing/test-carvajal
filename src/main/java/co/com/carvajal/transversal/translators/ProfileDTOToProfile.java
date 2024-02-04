package co.com.carvajal.transversal.translators;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import co.com.carvajal.transversal.dto.ProfileDTO;
import co.com.carvajal.transversal.jpa.entity.Profile;
import co.com.carvajal.transversal.pattern.Translator;

/**
 * ProfileDTOToProfile
 * 
 * @author Charles Edinson Gomez
 * since: 04-02-2024
 * 
 */
@Component
@Qualifier("profileDTOToProfile")
public class ProfileDTOToProfile implements Translator<ProfileDTO, Profile> {

  @Override
  public Profile to(ProfileDTO input) {
    return input != null ? Profile.builder()
        .profileId(input.getProfileId())
        .name(input.getName())
        .lastname(input.getLastname())
        .email(input.getEmail())
        .password(input.getPassword())
        .build() : null;
  }
}
