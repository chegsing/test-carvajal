package co.com.carvajal.transversal.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import co.com.carvajal.transversal.jpa.entity.Profile;

/**
 * ProfileRepository
 * 
 * @author Charles Edinson Gomez
 * since: 04-02-2024
 * 
 */
@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
  @Transactional(readOnly = true, isolation = Isolation.READ_UNCOMMITTED)
  Profile findByEmailAndPassword(String email, String password);
  
  @Transactional(readOnly = true, isolation = Isolation.READ_UNCOMMITTED)
  Profile findByEmail(String email);
  
  @Transactional(readOnly = true, isolation = Isolation.READ_UNCOMMITTED)
  @Query(value = "SELECT p FROM Profile p "
      + "WHERE LOWER(p.email) LIKE %:hint% "
      + "OR LOWER(p.lastname) LIKE %:hint% "
      + "OR LOWER(p.name) LIKE %:hint% ")
  List<Profile> findByHint(@Param("hint") String hint);

}
