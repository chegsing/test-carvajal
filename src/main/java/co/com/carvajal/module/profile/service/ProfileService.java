package co.com.carvajal.module.profile.service;

import java.util.List;

import org.springframework.stereotype.Service;

import co.com.carvajal.module.profile.dataprovider.IProfileDataProvider;
import co.com.carvajal.transversal.dto.Login;
import co.com.carvajal.transversal.dto.ProfileDTO;
import co.com.carvajal.transversal.dto.UpdatePassword;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

/**
 * ProfileService
 *
 * @author Charles Edinson Gomez
 * @since 04-02-2024
 *
 */
@Log4j2
@Service
@RequiredArgsConstructor
public class ProfileService {
  
  private final IProfileDataProvider profileDataProvider;
  
  public void createProfile(ProfileDTO profileDTO) {
    log.info("createProfile -> {}", profileDTO.getEmail());
    profileDataProvider.createProfile(profileDTO);    
  }

  public ProfileDTO getLogin(Login profile) {
    return profileDataProvider.findLogin(profile);
  }

  public void rememberPass(UpdatePassword updatePassword) {
	  profileDataProvider.rememberPass(updatePassword);
  }

  public List<ProfileDTO> findByHint(String hint) {
    return profileDataProvider.findByHint(hint);
  }

}