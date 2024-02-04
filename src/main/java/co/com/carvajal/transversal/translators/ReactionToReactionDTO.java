package co.com.carvajal.transversal.translators;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import co.com.carvajal.transversal.dto.CommentDTO;
import co.com.carvajal.transversal.dto.ProfileDTO;
import co.com.carvajal.transversal.dto.ReactionDTO;
import co.com.carvajal.transversal.jpa.entity.Comment;
import co.com.carvajal.transversal.jpa.entity.Profile;
import co.com.carvajal.transversal.jpa.entity.Reaction;
import co.com.carvajal.transversal.pattern.Translator;
import lombok.RequiredArgsConstructor;

/**
 * ReactionToReactionDTO
 * 
 * @author Charles Edinson Gomez
 * since: 04-02-2024
 * 
 */
@Component
@RequiredArgsConstructor
@Qualifier("reactionToReactionDTO")
public class ReactionToReactionDTO implements Translator<Reaction, ReactionDTO> {

  @Qualifier("commentToCommentDTO")
  private final Translator<Comment, CommentDTO> commentToCommentDTO;
  @Qualifier("profileToProfileDTO")
  private final Translator<Profile, ProfileDTO> profileToProfileDTO;
  
  @Override
  public ReactionDTO to(Reaction input) {
    
    if (input == null) {
      return null;
    }
    
    List<CommentDTO> coments = new ArrayList<>();
    if (input.getComments() != null && !input.getComments().isEmpty()) {
      for (Comment comment : input.getComments()) {
        coments.add(commentToCommentDTO.to(comment));
      }
    }
    return ReactionDTO.builder()
        .reactionId(input.getReactionId())
        .comments(coments)
        .detailReaction(input.getDetailReaction())
        .profileReaction(profileToProfileDTO.to(input.getProfileReaction()))
        .build();
  }
}
