package co.com.carvajal.module.reaction.service;

import org.springframework.stereotype.Service;

import co.com.carvajal.module.reaction.dataprovider.IReactionDataProvider;
import co.com.carvajal.transversal.dto.ReactionDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

/**
 * ReactionService
 *
 * @author Charles Edinson Gomez
 * @since 04-02-2024
 *
 */
@Log4j2
@Service
@RequiredArgsConstructor
public class ReactionService {
  
  private final IReactionDataProvider reactionDataProvider;

  public ReactionDTO createReaction(ReactionDTO reactionDTO) {
    log.info("createReaction");
    return reactionDataProvider.createReaction(reactionDTO);    
  }

}