package projet.ejb.service.standard;

import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.inject.Inject;

import projet.commun.dto.DtoOuvrage;
import projet.commun.exception.ExceptionValidation;
import projet.commun.service.IServiceOuvrage;
import projet.ejb.dao.IDaoOuvrage;
import projet.ejb.data.Ouvrage;
import projet.ejb.data.mapper.IMapperEjb;

@Stateless
@Remote
public class ServiceOuvrage implements IServiceOuvrage {

	// Champs
	@Inject
	private IMapperEjb mapper;
	@Inject
	private IDaoOuvrage daoOuvrage;

	// Actions

	@Override
	public int inserer(DtoOuvrage dtoOuvrage) throws ExceptionValidation {
		verifierValiditeDonnees(dtoOuvrage);
		int id = daoOuvrage.inserer(mapper.map(dtoOuvrage));
		return id;
	}

	@Override
	public void modifier(DtoOuvrage dtoOuvrage) throws ExceptionValidation {
		verifierValiditeDonnees(dtoOuvrage);
		daoOuvrage.modifier(mapper.map(dtoOuvrage));
	}

	@Override
	public void supprimer(int idOuvrage) throws ExceptionValidation {
		daoOuvrage.supprimer(idOuvrage);
	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public DtoOuvrage retrouver(int idOuvrage) {
		return mapper.map(daoOuvrage.retrouver(idOuvrage));
	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public List<DtoOuvrage> listerTout() {
		List<DtoOuvrage> liste = new ArrayList<>();
		for (Ouvrage Ouvrage : daoOuvrage.listerTout()) {
			liste.add(mapper.map(Ouvrage));
		}
		return liste;
	}

	// Méthodes auxiliaires

	private void verifierValiditeDonnees(DtoOuvrage dtoOuvrage) throws ExceptionValidation {

		StringBuilder message = new StringBuilder();

		if (dtoOuvrage.getTitre() == null || dtoOuvrage.getTitre().isEmpty()) {
			message.append("\nLe titre est absent.");
		}
		
		if (dtoOuvrage.getLangueLivre() == null || dtoOuvrage.getLangueLivre().isEmpty()) {
			message.append("\nLa langue lu livre  est absente.");
		}
		
		/* if (dtoOuvrage.getImageLivre() == null || dtoOuvrage.getImageLivre().isEmpty()) {
			message.append("\nL'image du livre est absente.");
		}
		
		if (dtoOuvrage.getDateAchat() == null || dtoOuvrage.getDateAchat().isEmpty()) {
			message.append("\nLa date d'achat est absente.");
		}
		
		if (dtoOuvrage.getDateParution() == null || dtoOuvrage.getDateParution().isEmpty()) {
			message.append("\nLa nom  de la personne est absente.");
		}
		
		if (dtoOuvrage.getPersonne().getNom() == null || dtoOuvrage.getPersonne().getNom().isEmpty()) {
			message.append("\nLa date de parution est absent.");
		} */
		
		if (dtoOuvrage.getAuteur().getNom() == null || dtoOuvrage.getAuteur().getNom().isEmpty()) {
			message.append("\nLe nom  de l'auteur est absent.");
		}
		
		if (dtoOuvrage.getCategorie().getNomCategorie() == null || dtoOuvrage.getCategorie().getNomCategorie().isEmpty()) {
			message.append("\nLe nom  de la catégorie est absent.");
		}
		
		if (dtoOuvrage.getAuteur().getNom() == null || dtoOuvrage.getAuteur().getNom().isEmpty()) {
			message.append("\nLe nom  de l'auteur est absent.");
		}
		

		if (message.length() > 0) {
			throw new ExceptionValidation(message.toString().substring(1));
		}
	}

}
