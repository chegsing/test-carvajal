package co.com.carvajal.transversal.translators;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import co.com.carvajal.transversal.dto.ProfileDTO;
import co.com.carvajal.transversal.dto.PublicationDTO;
import co.com.carvajal.transversal.dto.ReactionDTO;
import co.com.carvajal.transversal.jpa.entity.Profile;
import co.com.carvajal.transversal.jpa.entity.Publication;
import co.com.carvajal.transversal.jpa.entity.Reaction;
import co.com.carvajal.transversal.pattern.Translator;
import lombok.RequiredArgsConstructor;

/**
 * ReactionDTOToReaction
 * 
 * @author Charles Edinson Gomez
 * since: 04-02-2024
 * 
 */
@Component
@RequiredArgsConstructor
@Qualifier("reactionDTOToReaction")
public class ReactionDTOToReaction implements Translator<ReactionDTO, Reaction> {

  @Qualifier("profileDTOToProfile")
  private final Translator<ProfileDTO, Profile> profileDTOToProfile;
  @Qualifier("publicationDTOToPublication")
  private final Translator<PublicationDTO, Publication> publicationDTOToPublication;
  
  @Override
  public Reaction to(ReactionDTO input) {
    
    if (input == null) {
      return null;
    }

    return Reaction.builder()
        .reactionId(input.getReactionId())
        .detailReaction(input.getDetailReaction())
        .profileReaction(profileDTOToProfile.to(input.getProfileReaction()))
        .publication(publicationDTOToPublication.to(input.getPublication()))
        .build();
  }
}
