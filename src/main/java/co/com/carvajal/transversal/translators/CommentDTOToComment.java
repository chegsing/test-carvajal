package co.com.carvajal.transversal.translators;

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
 * CommentDTOToComment
 * 
 * @author Charles Edinson Gomez
 * since: 04-02-2024
 * 
 */
@Component
@RequiredArgsConstructor
@Qualifier("commentDTOToComment")
public class CommentDTOToComment implements Translator<CommentDTO, Comment> {


  @Qualifier("profileDTOToProfile")
  private final Translator<ProfileDTO, Profile> profileDTOToProfile;
  @Qualifier("reactionDTOToReaction")
  private final Translator<ReactionDTO, Reaction> reactionDTOToReaction;
  
  @Override
  public Comment to(CommentDTO input) {
    return input != null ? Comment.builder()
        .commentId(input.getCommentId())
        .profileComment(profileDTOToProfile.to(input.getProfileComment()))
        .detailComment(input.getDetailComment())
        .reaction(reactionDTOToReaction.to(input.getReaction()))
        .build() : null;
  }
}
