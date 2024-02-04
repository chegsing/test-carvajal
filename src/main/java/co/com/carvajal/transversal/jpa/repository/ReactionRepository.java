package co.com.carvajal.transversal.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.carvajal.transversal.jpa.entity.Reaction;

/**
 * ReactionRepository
 * 
 * @author Charles Edinson Gomez
 * since: 04-02-2024
 * 
 */
@Repository
public interface ReactionRepository extends JpaRepository<Reaction, Long> {

}
