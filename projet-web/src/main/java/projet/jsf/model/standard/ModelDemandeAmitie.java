package projet.jsf.model.standard;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import projet.commun.dto.DtoDemandeAmitie;
import projet.commun.exception.ExceptionValidation;
import projet.commun.service.IServiceCompte;
import projet.commun.service.IServiceDemandeAmitie;
import projet.jsf.data.DemandeAmitie;
import projet.jsf.data.Personne;
import projet.jsf.data.mapper.IMapper;
import projet.jsf.util.CompteActif;
import projet.jsf.util.UtilJsf;


@SuppressWarnings("serial")
@Named
@ViewScoped
public class ModelDemandeAmitie implements Serializable {

	
	// Champs
	
	private List<DemandeAmitie>	liste;
	
	private DemandeAmitie			courant;
	
	@EJB
	private IServiceDemandeAmitie	serviceDemandeAmitie;
	
	@EJB
	private IServiceCompte	serviceCompte;
	
	@Inject
	private IMapper			mapper;

	
	// Getters 
	
	public List<DemandeAmitie> getListe() {
		if ( liste == null ) {
			liste = new ArrayList<>();
			for ( DtoDemandeAmitie dto : serviceDemandeAmitie.listerTout() ) {
				liste.add( mapper.map( dto ) );
			}
		}
		return liste;
	}
	
		public DemandeAmitie getCourant() {
			if ( courant == null ) {
				courant = new DemandeAmitie();
			}
			return courant;
		}
	
	
	// Initialisaitons
	
	public String actualiserCourant() {
		if ( courant != null ) {
			DtoDemandeAmitie dto = serviceDemandeAmitie.retrouver( courant.getIdDemande() ); 
			if ( dto == null ) {
				UtilJsf.messageError( "Le DemandeAmitie demandé n'existe pas" );
				return "test/liste";
			} else {
				courant = mapper.map( dto );
			}
		}
		return null;
	}
	
	
	// Actions
	
	public String validerMiseAJour() {
		try {
			if ( courant.getIdDemande() == null) {
				serviceDemandeAmitie.inserer( mapper.map(courant) );
			} else {
				serviceDemandeAmitie.modifier( mapper.map(courant) );
			}
			UtilJsf.messageInfo( "Mise à jour effectuée avec succès." );
			return "liste";
		} catch (ExceptionValidation e) {
			UtilJsf.messageError(e);
			return null;
		}
	}
	
	public String supprimer( DemandeAmitie item ) {
		try {
			serviceDemandeAmitie.supprimer( item.getIdDemande() );
			liste.remove(item);
			UtilJsf.messageInfo( "Suppression effectuée avec succès." );
		} catch (ExceptionValidation e) {
			UtilJsf.messageError( e ); 
		}
		return null;
	}
	
	public String ajouter(CompteActif compteActif, Personne personne) {
		try {
			System.out.println(courant);
			serviceDemandeAmitie.insererDemandeAvecPersonnes(serviceCompte.retrouverParPseudo(compteActif.getPseudo()).getId(), mapper.map(personne) );
			UtilJsf.messageInfo( "Demande  envoyée avec succès." );
			return "liste";
		} catch (ExceptionValidation e) {
			UtilJsf.messageError(e);
			return null;
		}
	}
	
}
