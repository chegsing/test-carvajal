package co.com.carvajal.module.comment.dataprovider;

import co.com.carvajal.transversal.dto.CommentDTO;

/**
 * ICommentDataProvider
 *
 * @author Charles Edinson Gomez
 * @since 04-02-2024
 *
 */

public interface ICommentDataProvider {

  public CommentDTO createComment(CommentDTO commentDTO);
 
}
