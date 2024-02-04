package co.com.carvajal.module.publication.service;

import java.util.List;

import org.springframework.stereotype.Service;

import co.com.carvajal.module.publication.dataprovider.IPublicationDataProvider;
import co.com.carvajal.transversal.dto.PublicationDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

/**
 * PublicationService
 *
 * @author Charles Edinson Gomez
 * @since 04-02-2024
 *
 */
@Log4j2
@Service
@RequiredArgsConstructor
public class PublicationService {
  
  private final IPublicationDataProvider publicationDataProvider;
  
  public List<PublicationDTO> getPublicationsByProfile(Long idProfile) {
    log.info("getPublicationsByProfile");
    return publicationDataProvider.findPublicationsByProfile(idProfile);    
  }
  
  public PublicationDTO createPublications(PublicationDTO publicationDTO) {
    log.info("createPublications");
    return publicationDataProvider.createPublication(publicationDTO);    
  }
  
  public PublicationDTO updatePublications(PublicationDTO publicationDTO) {
    log.info("updatePublications");
    return publicationDataProvider.updatePublication(publicationDTO);    
  }
  
  public void deletePublications(Long publicationId) {
    log.info("deletePublications");
    publicationDataProvider.deletePublication(publicationId);    
  }

}