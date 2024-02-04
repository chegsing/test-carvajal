package co.com.carvajal.module.profile.dataprovider;

import java.util.List;

import co.com.carvajal.transversal.dto.Login;
import co.com.carvajal.transversal.dto.ProfileDTO;
import co.com.carvajal.transversal.dto.UpdatePassword;

/**
 * IProfileDataProvider
 *
 * @author Charles Edinson Gomez
 * @since 04-02-2024
 *
 */

public interface IProfileDataProvider {

  public void createProfile(ProfileDTO profileDTO);

  public ProfileDTO findLogin(Login profile);

  public void rememberPass(UpdatePassword updatePassword);

  public List<ProfileDTO> findByHint(String hint);
 
}
