package co.com.carvajal.module.publication.dataprovider;

import java.util.List;

import co.com.carvajal.transversal.dto.PublicationDTO;

/**
 * IPublicationDataProvider
 *
 * @author Charles Edinson Gomez
 * @since 04-02-2024
 *
 */

public interface IPublicationDataProvider {

  public List<PublicationDTO> findPublicationsByProfile(Long idprofile);
  public PublicationDTO createPublication(PublicationDTO publicationDTO);
  public PublicationDTO updatePublication(PublicationDTO publicationDTO);
  public void deletePublication(Long idPubication);
 
}
