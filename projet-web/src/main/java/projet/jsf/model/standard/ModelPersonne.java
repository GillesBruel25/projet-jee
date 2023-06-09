package projet.jsf.model.standard;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import projet.commun.dto.DtoPersonne;
import projet.commun.exception.ExceptionValidation;
import projet.commun.service.IServiceCompte;
import projet.commun.service.IServicePersonne;
import projet.jsf.data.Compte;
import projet.jsf.data.Personne;
import projet.jsf.data.mapper.IMapper;
import projet.jsf.util.CompteActif;
import projet.jsf.util.UtilJsf;


@SuppressWarnings("serial")
@Named
@ViewScoped
public class ModelPersonne implements Serializable {

	
	// Champs
	
	private List<Personne>	liste;
	
	private Personne			courant;
	
	@EJB
	private IServicePersonne	servicePersonne;
	
	@EJB
	private IServiceCompte	serviceCompte;
	
	@Inject
	private IMapper			mapper;

	
	// Getters 
	
	public List<Personne> getListe() {
		if ( liste == null ) {
			liste = new ArrayList<>();
			for ( DtoPersonne dto : servicePersonne.listerTout() ) {
				liste.add( mapper.map( dto ) );
			}
		}
		return liste;
	}
	
		public Personne getCourant() {
			if ( courant == null ) {
				courant = new Personne();
			}
			return courant;
		}
	
	
	// Initialisaitons
	
	public String actualiserCourant() {
		if ( courant != null ) {
			DtoPersonne dto = servicePersonne.retrouver( courant.getIdPersonne() ); 
			if ( dto == null ) {
				UtilJsf.messageError( "Le Personne demandé n'existe pas" );
				return "test/liste";
			} else {
				courant = mapper.map( dto );
			}
		}
		return null;
	}
	
	public List<Personne> getPersonneParCompte(CompteActif compteActif) {
		if ( liste == null ) {
			liste = new ArrayList<>();
			//System.out.println(serviceCompte.retrouverParPseudo(compteActif.getPseudo()).getId());
			liste.add( mapper.map( servicePersonne.retrouverParCompte(serviceCompte.retrouverParPseudo(compteActif.getPseudo()).getId())) );
		}
		return liste;
	}
	
	public List<Personne> getListePersonnesRestantes(CompteActif compteActif) {
		if ( liste == null ) {
			liste = new ArrayList<>();
			//System.out.println(serviceCompte.retrouverParPseudo(compteActif.getPseudo()).getId());
			//liste.add( mapper.map( servicePersonne.retrouverPersonnesRestantesParCompte(serviceCompte.retrouverParPseudo(compteActif.getPseudo()).getId())) );
			for ( DtoPersonne dto :  servicePersonne.retrouverPersonnesRestantesParCompte(serviceCompte.retrouverParPseudo(compteActif.getPseudo()).getId()) ) {
				liste.add( mapper.map( dto ) );
			}
		}
		return liste;
	}
	
	// Actions
	
	public String validerMiseAJour() {
		try {
			if ( courant.getIdPersonne() == null) {
				//courant.setCompte(serviceCompte.retrouverParPseudo(courant.getCompte().getPseudo()));
				// System.out.println("giles "+ courant);
				servicePersonne.inserer( mapper.map(courant) );
				// serviceCompte.miseAJourCompteAvecPersonne(courant.getCompte().getId(), servicePersonne.retrouver(id) );
			} else {
				servicePersonne.modifier( mapper.map(courant) );
			}
			UtilJsf.messageInfo( "Mise à jour effectuée avec succès." );
			return "liste";
		} catch (ExceptionValidation e) {
			UtilJsf.messageError(e);
			return null;
		}
	}
	
	public String supprimer( Personne item ) {
		try {
			servicePersonne.supprimer( item.getIdPersonne() );
			liste.remove(item);
			UtilJsf.messageInfo( "Suppression effectuée avec succès." );
		} catch (ExceptionValidation e) {
			UtilJsf.messageError( e ); 
		}
		return null;
	}
	
}
