package co.com.carvajal.transversal.translators;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import co.com.carvajal.transversal.dto.CommentDTO;
import co.com.carvajal.transversal.dto.ProfileDTO;
import co.com.carvajal.transversal.jpa.entity.Comment;
import co.com.carvajal.transversal.jpa.entity.Profile;
import co.com.carvajal.transversal.pattern.Translator;
import lombok.RequiredArgsConstructor;

/**
 * CommentToCommentDTO
 * 
 * @author Charles Edinson Gomez
 * since: 04-02-2024
 * 
 */
@Component
@RequiredArgsConstructor
@Qualifier("commentDTOToComment")
public class CommentToCommentDTO implements Translator<Comment, CommentDTO> {


  @Qualifier("profileToCommentDTO")
  private final Translator<Profile, ProfileDTO> profileToCommentDTO;
  
  @Override
  public CommentDTO to(Comment input) {
    return input != null ? CommentDTO.builder()
        .commentId(input.getCommentId())
        .profileComment(profileToCommentDTO.to(input.getProfileComment()))
        .detailComment(input.getDetailComment())
        .build() : null;
  }
}
