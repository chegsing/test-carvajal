package co.com.carvajal.module.profile.dataprovider.impl;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import co.com.carvajal.module.notification.service.EmailService;
import co.com.carvajal.module.profile.dataprovider.IProfileDataProvider;
import co.com.carvajal.transversal.constants.ConfigurationConstants;
import co.com.carvajal.transversal.constants.Messages;
import co.com.carvajal.transversal.dto.Login;
import co.com.carvajal.transversal.dto.ProfileDTO;
import co.com.carvajal.transversal.dto.UpdatePassword;
import co.com.carvajal.transversal.exception.BadRequestException;
import co.com.carvajal.transversal.jpa.entity.Profile;
import co.com.carvajal.transversal.jpa.repository.ProfileRepository;
import co.com.carvajal.transversal.pattern.Translator;
import lombok.RequiredArgsConstructor;

/**
 * ProfileDataProviderImpl
 *
 * @author Charles Edinson Gomez
 * @since 04-02-2024
 *
 */
@Component
@RequiredArgsConstructor
public class ProfileDataProviderImpl implements IProfileDataProvider {

  private final Translator<ProfileDTO, Profile> profileDTOToProfile;
  private final Translator<Profile, ProfileDTO> profileToProfileDTO;
  private final ProfileRepository profileRepository;
  private final EmailService emailService;

  @Value(ConfigurationConstants.EMAIL_USER)
  private String emailFrom;

  @Override
  public void createProfile(ProfileDTO profileDTO) {
    Profile profileEsist = profileRepository.findByEmail(profileDTO.getEmail());
    if (profileEsist != null) {
      throw new BadRequestException("Email ya registrdo");
    }
    Profile profile = profileDTOToProfile.to(profileDTO);
    profile.setCreationDate(LocalDateTime.now());
    profile.setActive(true);
    profileRepository.save(profile);
  }

  @Override
  public ProfileDTO findLogin(Login profile) {
    return profileToProfileDTO.to(profileRepository.findByEmailAndPassword(
        profile.getEmail(),
        profile.getPassword()));
  }

  @Override
  public void rememberPass(UpdatePassword updatePassword) {
    Profile profile = profileRepository.findByEmail(updatePassword.getEmail());
    if (profile != null) {
      emailService.send(emailFrom,
          profile.getEmail(),
          Messages.SUBJECT,
          Messages.DETAIL +
          profile.getPassword());
    }
  }

  @Override
  public List<ProfileDTO> findByHint(String hint) {
    List<ProfileDTO> profileDTOs = new ArrayList<>();
    for (Profile profile : profileRepository.findByHint(hint.toLowerCase())) {
      profileDTOs.add(profileToProfileDTO.to(profile));
    }
    return profileDTOs;
  }

}
