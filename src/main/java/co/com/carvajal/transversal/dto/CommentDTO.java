package co.com.carvajal.transversal.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * CommentDTO
 * 
 * @author Charles Edinson Gomez
 * since: 04-02-2024
 * 
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommentDTO implements Serializable {

    private Long commentId;
    private ProfileDTO profileComment;
    private String detailComment;
    private ReactionDTO reaction;

    private static final long serialVersionUID = 8094153480314794704L;

}
