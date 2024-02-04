package co.com.carvajal.module.comment.service;

import org.springframework.stereotype.Service;

import co.com.carvajal.module.comment.dataprovider.ICommentDataProvider;
import co.com.carvajal.transversal.dto.CommentDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

/**
 * CommentService
 * 
 * @author Charles Edinson Gomez
 * @since 04-02-2024
 * 
 */
@Log4j2
@Service
@RequiredArgsConstructor
public class CommentService {
  
  private final ICommentDataProvider commentDataProvide;

  public CommentDTO createComment(CommentDTO commentDTO) {
    log.info("Inicia [createComment()]:");
    return commentDataProvide.createComment(commentDTO);    
  }

}