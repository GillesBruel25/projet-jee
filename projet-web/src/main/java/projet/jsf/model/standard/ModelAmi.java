package projet.jsf.model.standard;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import projet.commun.dto.DtoAmi;
import projet.commun.exception.ExceptionValidation;
import projet.commun.service.IServiceAmi;
import projet.jsf.data.Ami;
import projet.jsf.data.mapper.IMapper;
import projet.jsf.util.UtilJsf;


@SuppressWarnings("serial")
@Named
@ViewScoped
public class ModelAmi implements Serializable {

	
	// Champs
	
	private List<Ami>	liste;
	
	private Ami			courant;
	
	@EJB
	private IServiceAmi	serviceAmi;
	
	@Inject
	private IMapper			mapper;

	
	// Getters 
	
	public List<Ami> getListe() {
		if ( liste == null ) {
			liste = new ArrayList<>();
			for ( DtoAmi dto : serviceAmi.listerTout() ) {
				liste.add( mapper.map( dto ) );
			}
		}
		return liste;
	}
	
		public Ami getCourant() {
			if ( courant == null ) {
				courant = new Ami();
			}
			return courant;
		}
	
	
	// Initialisaitons
	
	public String actualiserCourant() {
		if ( courant != null ) {
			DtoAmi dto = serviceAmi.retrouver( courant.getIdAmi() ); 
			if ( dto == null ) {
				UtilJsf.messageError( "Le Ami demandé n'existe pas" );
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
			if ( courant.getIdAmi() == null) {
				serviceAmi.inserer( mapper.map(courant) );
			} else {
				serviceAmi.modifier( mapper.map(courant) );
			}
			UtilJsf.messageInfo( "Mise à jour effectuée avec succès." );
			return "liste";
		} catch (ExceptionValidation e) {
			UtilJsf.messageError(e);
			return null;
		}
	}
	
	public String supprimer( Ami item ) {
		try {
			serviceAmi.supprimer( item.getIdAmi() );
			liste.remove(item);
			UtilJsf.messageInfo( "Suppression effectuée avec succès." );
		} catch (ExceptionValidation e) {
			UtilJsf.messageError( e ); 
		}
		return null;
	}
	
}
