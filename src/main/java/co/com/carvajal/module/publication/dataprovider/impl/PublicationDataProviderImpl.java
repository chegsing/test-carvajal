package co.com.carvajal.module.publication.dataprovider.impl;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import co.com.carvajal.module.publication.dataprovider.IPublicationDataProvider;
import co.com.carvajal.transversal.dto.PublicationDTO;
import co.com.carvajal.transversal.exception.BadRequestException;
import co.com.carvajal.transversal.jpa.entity.Publication;
import co.com.carvajal.transversal.jpa.repository.PublicationRepository;
import co.com.carvajal.transversal.pattern.Translator;
import lombok.RequiredArgsConstructor;

/**
 * PublicationDataProviderImpl
 *
 * @author Charles Edinson Gomez
 * @since 04-02-2024
 *
 */
@Component
@RequiredArgsConstructor
public class PublicationDataProviderImpl implements IPublicationDataProvider {

  private final PublicationRepository publicationRepository;
  @Qualifier("publicationDTOToPublication")
  private final Translator<PublicationDTO, Publication> publicationDTOToPublication;
  @Qualifier("publicationToPublicationDTO")
  private final Translator<Publication, PublicationDTO> publicationToPublicationDTO;  

  @Override
  public List<PublicationDTO> findPublicationsByProfile(Long idprofile) {
    List<PublicationDTO> publicationDtos = new ArrayList<>();
    for (Publication publication : publicationRepository.findPublicationsByProfilrId(idprofile)) {
      publicationDtos.add(publicationToPublicationDTO.to(publication));
    }
    return publicationDtos;
  }

  @Override
  public PublicationDTO createPublication(PublicationDTO publicationDTO) {
    Publication publication = publicationDTOToPublication.to(publicationDTO);
    publication.setCreationDate(LocalDateTime.now());
    return publicationToPublicationDTO.to(publicationRepository.save(publication));
  }

  @Override
  public PublicationDTO updatePublication(PublicationDTO publicationDTO) {
    Optional<Publication> publicationOp = publicationRepository.findById(publicationDTO.getPublicationId());
    if (publicationOp.isEmpty()) {
      throw new BadRequestException("Piblication is not found");
    }
    Publication publication = publicationOp.get();
    publication.setDetailPublication(publicationDTO.getDetailPublication());
    return publicationToPublicationDTO.to(publicationRepository.save(publication));
  }

  @Override
  public void deletePublication(Long idPubication) {
    Optional<Publication> publicationOp = publicationRepository.findById(idPubication);
    if (publicationOp.isEmpty()) {
      throw new BadRequestException("Piblication is not found");
    }
    Publication publication = publicationOp.get();
    publication.setActive(false);
    publicationToPublicationDTO.to(publicationRepository.save(publication));
  }


}
