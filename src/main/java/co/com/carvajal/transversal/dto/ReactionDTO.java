package co.com.carvajal.transversal.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ReactionDTO
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
public class ReactionDTO implements Serializable {

    private Long reactionId;
    private List<CommentDTO> comments;
    private ProfileDTO profileReaction;
    private String detailReaction;
    private PublicationDTO publication;

    private static final long serialVersionUID = 8094153480314794704L;

}
