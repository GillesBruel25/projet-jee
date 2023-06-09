package projet.ejb.service.standard;

import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.inject.Inject;

import projet.commun.dto.DtoAmi;
import projet.commun.exception.ExceptionValidation;
import projet.commun.service.IServiceAmi;
import projet.ejb.dao.IDaoAmi;
import projet.ejb.data.Ami;
import projet.ejb.data.mapper.IMapperEjb;

@Stateless
@Remote
public class ServiceAmi implements IServiceAmi {

	// Champs
	@Inject
	private IMapperEjb mapper;
	@Inject
	private IDaoAmi daoAmi;

	// Actions

	@Override
	public int inserer(DtoAmi dtoAmi) throws ExceptionValidation {
		verifierValiditeDonnees(dtoAmi);
		int id = daoAmi.inserer(mapper.map(dtoAmi));
		return id;
	}

	@Override
	public void modifier(DtoAmi dtoAmi) throws ExceptionValidation {
		verifierValiditeDonnees(dtoAmi);
		daoAmi.modifier(mapper.map(dtoAmi));
	}

	@Override
	public void supprimer(int idAmi) throws ExceptionValidation {
		daoAmi.supprimer(idAmi);
	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public DtoAmi retrouver(int idAmi) {
		return mapper.map(daoAmi.retrouver(idAmi));
	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public List<DtoAmi> listerTout() {
		List<DtoAmi> liste = new ArrayList<>();
		for (Ami Ami : daoAmi.listerTout()) {
			liste.add(mapper.map(Ami));
		}
		return liste;
	}

	// Méthodes auxiliaires

	private void verifierValiditeDonnees(DtoAmi dtoAmi) throws ExceptionValidation {

		StringBuilder message = new StringBuilder();

		if (dtoAmi.getDateAnciennete() == null || dtoAmi.getDateAnciennete().isEmpty()) {
			message.append("\nLa date d'ancienneté est absente.");
		}
		
		if (dtoAmi.getPersonne1() == null) {
			message.append("\nLa personne 1 est absente.");
		}
		
		if (dtoAmi.getPersonne2() == null) {
			message.append("\nLa personne 2 est absente.");
		}

		if (message.length() > 0) {
			throw new ExceptionValidation(message.toString().substring(1));
		}
	}

}
