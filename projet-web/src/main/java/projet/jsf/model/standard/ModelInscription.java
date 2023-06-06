package projet.jsf.model.standard;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import projet.commun.dto.DtoCompte;
import projet.commun.exception.ExceptionValidation;
import projet.commun.service.IServiceCompte;
import projet.jsf.data.Compte;
import projet.jsf.data.mapper.IMapper;
import projet.jsf.util.CompteActif;
import projet.jsf.util.UtilJsf;


@SuppressWarnings("serial")
@Named
@ViewScoped
public class ModelInscription implements Serializable {

	
	// Champs
	
	private List<Compte>	liste;
	
	private Compte			courant;
	
	@EJB
	private IServiceCompte	serviceCompte;
	
	@Inject
	private IMapper			mapper;

	
	// Getters 
	
	
	public List<Compte> getListe() {
		if ( liste == null ) {
			liste = new ArrayList<>();
			for ( DtoCompte dto : serviceCompte.listerTout() ) {
				liste.add( mapper.map( dto ) );
			}
		}
		return liste;
	}

	// Initialisaitons
	public Compte getCourant() {
		if ( courant == null ) {
			courant = new Compte();
		}
		return courant;
	}
	
	// Actions
	
	public String validerMiseAJour() {
		System.out.println(courant.getId());
		try {
			if ( courant.getId() == null) {
				serviceCompte.inserer( mapper.map(courant) );
			} 
			UtilJsf.messageInfo( "Compte crée avec succès" );
			return "connexion";
			
		} catch (ExceptionValidation e) {
			UtilJsf.messageError(e);
			return null;
		}
	}
	
}
