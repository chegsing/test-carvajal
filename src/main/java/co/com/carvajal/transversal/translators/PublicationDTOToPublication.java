package co.com.carvajal.transversal.translators;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import co.com.carvajal.transversal.dto.ProfileDTO;
import co.com.carvajal.transversal.dto.PublicationDTO;
import co.com.carvajal.transversal.jpa.entity.Profile;
import co.com.carvajal.transversal.jpa.entity.Publication;
import co.com.carvajal.transversal.pattern.Translator;
import lombok.RequiredArgsConstructor;

/**
 * PublicationDTOToPublication
 * 
 * @author Charles Edinson Gomez
 * since: 04-02-2024
 * 
 */
@Component
@RequiredArgsConstructor
@Qualifier("publicationDTOToPublication")
public class PublicationDTOToPublication implements Translator<PublicationDTO, Publication> {

  @Qualifier("profileDTOToProfile")
  private final Translator<ProfileDTO, Profile> profileDTOToProfile;
  
  @Override
  public Publication to(PublicationDTO input) {
    
    if (input == null) {
      return null;
    }

    return Publication.builder()
        .publicationId(input.getPublicationId())
        .profile(profileDTOToProfile.to(input.getProfile()))
        .detailPublication(input.getDetailPublication())
        .active(true)
        .build();
  }
}
