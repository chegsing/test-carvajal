package co.com.carvajal.module.reaction.dataprovider;

import co.com.carvajal.transversal.dto.ReactionDTO;

/**
 * IReactionDataProvider
 *
 * @author Charles Edinson Gomez
 * @since 04-02-2024
 *
 */

public interface IReactionDataProvider {

  public ReactionDTO createReaction(ReactionDTO reactionDTO);
 
}
