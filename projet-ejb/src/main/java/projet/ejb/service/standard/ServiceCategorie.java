package projet.ejb.service.standard;

import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.inject.Inject;

import projet.commun.dto.DtoCategorie;
import projet.commun.exception.ExceptionValidation;
import projet.commun.service.IServiceCategorie;
import projet.ejb.dao.IDaoCategorie;
import projet.ejb.data.Categorie;
import projet.ejb.data.mapper.IMapperEjb;

@Stateless
@Remote
public class ServiceCategorie implements IServiceCategorie {

	// Champs
	@Inject
	private IMapperEjb mapper;
	@Inject
	private IDaoCategorie daoCategorie;

	// Actions

	@Override
	public int inserer(DtoCategorie dtoCategorie) throws ExceptionValidation {
		verifierValiditeDonnees(dtoCategorie);
		int id = daoCategorie.inserer(mapper.map(dtoCategorie));
		return id;
	}

	@Override
	public void modifier(DtoCategorie dtoCategorie) throws ExceptionValidation {
		verifierValiditeDonnees(dtoCategorie);
		daoCategorie.modifier(mapper.map(dtoCategorie));
	}

	@Override
	public void supprimer(int idCategorie) throws ExceptionValidation {
		daoCategorie.supprimer(idCategorie);
	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public DtoCategorie retrouver(int idCategorie) {
		return mapper.map(daoCategorie.retrouver(idCategorie));
	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public List<DtoCategorie> listerTout() {
		List<DtoCategorie> liste = new ArrayList<>();
		for (Categorie Categorie : daoCategorie.listerTout()) {
			liste.add(mapper.map(Categorie));
		}
		return liste;
	}

	// Méthodes auxiliaires

	private void verifierValiditeDonnees(DtoCategorie dtoCategorie) throws ExceptionValidation {

		StringBuilder message = new StringBuilder();

		if (dtoCategorie.getNomCategorie() == null || dtoCategorie.getNomCategorie().isEmpty()) {
			message.append("\nLe nom est absent.");
		}
		

		if (message.length() > 0) {
			throw new ExceptionValidation(message.toString().substring(1));
		}
	}

}
