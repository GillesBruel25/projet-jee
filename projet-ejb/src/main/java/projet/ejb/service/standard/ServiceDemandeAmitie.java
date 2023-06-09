package projet.ejb.service.standard;

import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.inject.Inject;

import projet.commun.dto.DtoDemandeAmitie;
import projet.commun.dto.DtoPersonne;
import projet.commun.exception.ExceptionValidation;
import projet.commun.service.IServiceDemandeAmitie;
import projet.ejb.dao.IDaoDemandeAmitie;
import projet.ejb.dao.IDaoPersonne;
import projet.ejb.data.DemandeAmitie;
import projet.ejb.data.mapper.IMapperEjb;

@Stateless
@Remote
public class ServiceDemandeAmitie implements IServiceDemandeAmitie {

	// Champs
	@Inject
	private IMapperEjb mapper;
	@Inject
	private IDaoDemandeAmitie daoDemandeAmitie;
	@Inject
	private IDaoPersonne daoPersonne;

	// Actions

	@Override
	public int inserer(DtoDemandeAmitie dtoDemandeAmitie) throws ExceptionValidation {
		verifierValiditeDonnees(dtoDemandeAmitie);
		//int id = daoDemandeAmitie.inserer(mapper.map(dtoDemandeAmitie));
		int id = 1;
		return id;
	}
	
	@Override
	public int insererDemandeAvecPersonnes(Integer idCompte, DtoPersonne dtoPersonne) throws ExceptionValidation {
		//verifierValiditeDonnees(dtoDemandeAmitie);
		//int id = daoDemandeAmitie.insererDemandeAvecPersonnes(idCompte, mapper.map(dtoPersonne));
		
		int id = daoDemandeAmitie.insererDemandeAvecPersonnes(daoPersonne.retrouverParCompte(idCompte), daoPersonne.retrouver(dtoPersonne.getIdPersonne()));
		return id;
	}

	@Override
	public void modifier(DtoDemandeAmitie dtoDemandeAmitie) throws ExceptionValidation {
		verifierValiditeDonnees(dtoDemandeAmitie);
		daoDemandeAmitie.modifier(mapper.map(dtoDemandeAmitie));
	}

	@Override
	public void supprimer(int idDemandeAmitie) throws ExceptionValidation {
		daoDemandeAmitie.supprimer(idDemandeAmitie);
	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public DtoDemandeAmitie retrouver(int idDemandeAmitie) {
		return mapper.map(daoDemandeAmitie.retrouver(idDemandeAmitie));
	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public List<DtoDemandeAmitie> listerTout() {
		List<DtoDemandeAmitie> liste = new ArrayList<>();
		for (DemandeAmitie DemandeAmitie : daoDemandeAmitie.listerTout()) {
			liste.add(mapper.map(DemandeAmitie));
		}
		return liste;
	}

	// Méthodes auxiliaires

	private void verifierValiditeDonnees(DtoDemandeAmitie dtoDemandeAmitie) throws ExceptionValidation {

		StringBuilder message = new StringBuilder();

		if (dtoDemandeAmitie.getDateDemande() == null || dtoDemandeAmitie.getDateDemande().isEmpty()) {
			message.append("\nLa date de demande est absente.");
		}
		
		if (dtoDemandeAmitie.getStatus() == null || dtoDemandeAmitie.getStatus().isEmpty()) {
			message.append("\nLe status de demande est absent.");
		}
		
		if (dtoDemandeAmitie.getEmetteur() == null) {
			message.append("\nL'emetteur est absent.");
		}
		
		if (dtoDemandeAmitie.getDestinataire() == null) {
			message.append("\nLe destinataire est absent.");
		}

		if (message.length() > 0) {
			throw new ExceptionValidation(message.toString().substring(1));
		}
	}

}
