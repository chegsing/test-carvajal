package co.com.carvajal.module.comment.dataprovider.impl;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import co.com.carvajal.module.comment.dataprovider.ICommentDataProvider;
import co.com.carvajal.transversal.dto.CommentDTO;
import co.com.carvajal.transversal.jpa.entity.Comment;
import co.com.carvajal.transversal.jpa.repository.CommentRepository;
import co.com.carvajal.transversal.pattern.Translator;
import lombok.RequiredArgsConstructor;

/**
 * CommentDataProviderImpl
 *
 * @author Charles Edinson Gomez
 * @since 04-02-2024
 *
 */
@Component
@RequiredArgsConstructor
public class CommentDataProviderImpl implements ICommentDataProvider {

  private final CommentRepository publicationRepository;

  @Qualifier("commentDTOToComment")
  private final Translator<CommentDTO, Comment> commentDTOToComment;
  @Qualifier("commentToCommentDTO")
  private final Translator<Comment, CommentDTO> commentToCommentDTO;

  @Override
  public CommentDTO createComment(CommentDTO commentDTO) {
    return commentToCommentDTO.to(publicationRepository.save(commentDTOToComment.to(commentDTO)));
  }
}
