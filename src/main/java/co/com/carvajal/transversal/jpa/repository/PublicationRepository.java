package co.com.carvajal.transversal.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import co.com.carvajal.transversal.jpa.entity.Publication;

/**
 * PublicationRepository
 * 
 * @author Charles Edinson Gomez
 * since: 04-02-2024
 * 
 */
@Repository
public interface PublicationRepository extends JpaRepository<Publication, Long> {
  
  @Transactional(readOnly = true, isolation = Isolation.READ_UNCOMMITTED)
  @Query("SELECT p FROM Publication p JOIN p.profile pf "
       + "WHERE pf.profileId = ?1 AND p.active = true ORDER BY p.publicationId DESC")
  List<Publication> findPublicationsByProfilrId(Long idProfile);

}
