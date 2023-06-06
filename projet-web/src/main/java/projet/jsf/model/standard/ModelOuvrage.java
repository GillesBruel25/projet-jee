package projet.jsf.model.standard;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Part;

import projet.commun.dto.DtoOuvrage;
import projet.commun.exception.ExceptionValidation;
import projet.commun.service.IServiceOuvrage;
import projet.jsf.data.Ouvrage;
import projet.jsf.data.mapper.IMapper;
import projet.jsf.util.UtilJsf;


@SuppressWarnings("serial")
@Named
@ViewScoped
public class ModelOuvrage implements Serializable {

	
	// Champs
	
	private List<Ouvrage>	liste;
	
	private Ouvrage			courant;
	
	@EJB
	private IServiceOuvrage	serviceOuvrage;
	
	@Inject
	private IMapper			mapper;

	
	private String folder = "C:\\jsf-upload\\";
	// private String folder = "C:\\Projet-JEE\\projet\\projet-web\\src\\main\\webapp\\WEB-INF\\resources\\images";
	
	// Getters 
	
	public List<Ouvrage> getListe() {
		if ( liste == null ) {
			liste = new ArrayList<>();
			for ( DtoOuvrage dto : serviceOuvrage.listerTout() ) {
				liste.add( mapper.map( dto ) );
			}
		}
		return liste;
	}
	
		public Ouvrage getCourant() {
			if ( courant == null ) {
				courant = new Ouvrage();
			}
			return courant;
		}
	
	
	// Initialisaitons
	
	public String actualiserCourant() {
		if ( courant != null ) {
			DtoOuvrage dto = serviceOuvrage.retrouver( courant.getIdOuvrage() ); 
			if ( dto == null ) {
				UtilJsf.messageError( "Le Ouvrage demandé n'existe pas" );
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
			if ( courant.getIdOuvrage() == null) {
				saveFile();
				courant.setImageLivre(String.valueOf(getFileName(courant.getUploadedFile())));
				serviceOuvrage.inserer( mapper.map(courant) );
			} else {
				courant.setImageLivre(String.valueOf(getFileName(courant.getUploadedFile())));
				serviceOuvrage.modifier( mapper.map(courant) );
			}
			UtilJsf.messageInfo( "Mise à jour effectuée avec succès." );
			return "liste";
		} catch (ExceptionValidation e) {
			UtilJsf.messageError(e);
			return null;
		}
	}
	
	public String supprimer( Ouvrage item ) {
		try {
			serviceOuvrage.supprimer( item.getIdOuvrage() );
			liste.remove(item);
			UtilJsf.messageInfo( "Suppression effectuée avec succès." );
		} catch (ExceptionValidation e) {
			UtilJsf.messageError( e ); 
		}
		return null;
	}
	
	//Liste langues
	
	public List<String> getListeLangues() {
		List<String> liste = new ArrayList<>();
		liste.add("Français");
		liste.add("Anglais");
		liste.add("Autre");
		
		return liste;
	}
	
	public void saveFile() {
		System.out.println("SaveFile method invoked ..");
		
		String fileName = "";
		
		try {
			fileName = getFileName(courant.getUploadedFile());
			System.out.println("fileName" + fileName);
			courant.getUploadedFile().write(folder+fileName);
		}catch(IOException ex) {
			System.out.println(ex);
			UtilJsf.messageError( ex );
		}
	}
	
	private static String getFileName(Part part) {
		for(String cd: part.getHeader("content-disposition").split(";")) {
			if(cd.trim().startsWith("filename")) {
				String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
				return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1);
			}
		}
		
		return null;
	}
}
