package co.com.carvajal.module.reaction.dataprovider.impl;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import co.com.carvajal.module.reaction.dataprovider.IReactionDataProvider;
import co.com.carvajal.transversal.dto.ReactionDTO;
import co.com.carvajal.transversal.jpa.entity.Reaction;
import co.com.carvajal.transversal.jpa.repository.ReactionRepository;
import co.com.carvajal.transversal.pattern.Translator;
import lombok.RequiredArgsConstructor;

/**
 * ReactionDataProviderImpl
 *
 * @author Charles Edinson Gomez
 * @since 04-02-2024
 *
 */
@Component
@RequiredArgsConstructor
public class ReactionDataProviderImpl implements IReactionDataProvider {

  private final ReactionRepository reactionRepository;

  @Qualifier("reactionDTOToReaction")
  private final Translator<ReactionDTO, Reaction> reactionDTOToReaction;
  @Qualifier("reactionToReactionDTO")
  private final Translator<Reaction, ReactionDTO> reactionToReactionDTO;

  @Override
  public ReactionDTO createReaction(ReactionDTO reactionDTO) {
    return reactionToReactionDTO.to(reactionRepository.save(reactionDTOToReaction.to(reactionDTO)));
  }
}
