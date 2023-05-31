package projet.ejb.service.standard;

import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.inject.Inject;

import projet.commun.dto.DtoPersonne;
import projet.commun.exception.ExceptionValidation;
import projet.commun.service.IServicePersonne;
import projet.ejb.dao.IDaoCompte;
import projet.ejb.dao.IDaoPersonne;
import projet.ejb.data.Personne;
import projet.ejb.data.mapper.IMapperEjb;

@Stateless
@Remote
public class ServicePersonne implements IServicePersonne {

	// Champs
	@Inject
	private IMapperEjb mapper;
	@Inject
	private IDaoPersonne daoPersonne;
	@Inject
	private IDaoCompte daoCompte;

	// Actions

	@Override
	public int inserer(DtoPersonne dtoPersonne) throws ExceptionValidation {
		verifierValiditeDonnees(dtoPersonne);
		int id = daoPersonne.inserer(mapper.map(dtoPersonne));
		// daoCompte.miseAJourCompteAvecPersonne(dtoPersonne.getCompte().getId(), id);
		return id;
	}

	@Override
	public void modifier(DtoPersonne dtoPersonne) throws ExceptionValidation {
		verifierValiditeDonnees(dtoPersonne);
		daoPersonne.modifier(mapper.map(dtoPersonne));
	}

	@Override
	public void supprimer(int idPersonne) throws ExceptionValidation {
		daoPersonne.supprimer(idPersonne);
	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public DtoPersonne retrouver(int idPersonne) {
		return mapper.map(daoPersonne.retrouver(idPersonne));
	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public List<DtoPersonne> listerTout() {
		List<DtoPersonne> liste = new ArrayList<>();
		for (Personne Personne : daoPersonne.listerTout()) {
			liste.add(mapper.map(Personne));
		}
		return liste;
	}

	// Méthodes auxiliaires

	private void verifierValiditeDonnees(DtoPersonne dtoPersonne) throws ExceptionValidation {

		StringBuilder message = new StringBuilder();

		if (dtoPersonne.getNom() == null || dtoPersonne.getNom().isEmpty()) {
			message.append("\nLe nom est absent.");
		}
		
		if (dtoPersonne.getPrenom() == null || dtoPersonne.getPrenom().isEmpty()) {
			message.append("\nLe prénom est absent.");
		}

		if (message.length() > 0) {
			throw new ExceptionValidation(message.toString().substring(1));
		}
	}

	@Override
	public DtoPersonne retrouverParCompte(int idCompte) {
		// TODO Auto-generated method stub
		return mapper.map(daoPersonne.retrouverParCompte(idCompte));
	}

}
