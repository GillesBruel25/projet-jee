package projet.commun.service;

import java.util.List;

import projet.commun.dto.DtoCompte;
import projet.commun.dto.DtoPersonne;
import projet.commun.exception.ExceptionValidation;


public interface IServiceCompte {
	
	int				inserer( DtoCompte dtoCompte ) throws ExceptionValidation;

	void			modifier( DtoCompte dtoCompte ) throws ExceptionValidation; 

	void			supprimer( int idCompte ) throws ExceptionValidation;

	DtoCompte 		retrouver( int idCompte ) ;
	
	DtoCompte 		retrouverParPseudo( String pseudo ) ;

	List<DtoCompte>	listerTout() ;

	void miseAJourCompteAvecPersonne(Integer idCompte, DtoPersonne idPersonne);

}
