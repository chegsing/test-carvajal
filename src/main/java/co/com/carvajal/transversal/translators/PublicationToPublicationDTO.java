package co.com.carvajal.transversal.translators;

import java.util.ArrayList;
import java.util.List;

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
 * PublicationToPublicationDTO
 * 
 * @author Charles Edinson Gomez
 * since: 04-02-2024
 * 
 */
@Component
@RequiredArgsConstructor
@Qualifier("publicationToPublicationDTO")
public class PublicationToPublicationDTO implements Translator<Publication, PublicationDTO> {


  @Qualifier("reactionToReactionDTO")
  private final Translator<Reaction, ReactionDTO> reactionDTOToReaction;
  
  @Qualifier("profileToProfileDTO")
  private final Translator<Profile, ProfileDTO> profileToProfileDTO;
  
  @Override
  public PublicationDTO to(Publication input) {
    
    if (input == null) {
      return null;
    }
    
    List<ReactionDTO> reactions = new ArrayList<>();
    if (input.getReactions() != null && !input.getReactions().isEmpty()) {
      for (Reaction reaction : input.getReactions()) {
        reactions.add(reactionDTOToReaction.to(reaction));
      }
    }
    return PublicationDTO.builder()
        .publicationId(input.getPublicationId())
        .reactions(reactions)
        .profile(profileToProfileDTO.to(input.getProfile()))
        .detailPublication(input.getDetailPublication())
        .creationDate(input.getCreationDate())
        .build();
  }
}
