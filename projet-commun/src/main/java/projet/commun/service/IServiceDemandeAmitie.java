package projet.commun.service;

import java.util.List;

import projet.commun.dto.DtoDemandeAmitie;
import projet.commun.dto.DtoPersonne;
import projet.commun.exception.ExceptionValidation;


public interface IServiceDemandeAmitie {
	
	int				inserer( DtoDemandeAmitie dtoDemandeAmitie ) throws ExceptionValidation;

	void			modifier( DtoDemandeAmitie dtoDemandeAmitie ) throws ExceptionValidation; 

	void			supprimer( int idDemandeAmitie ) throws ExceptionValidation;

	DtoDemandeAmitie 		retrouver( int idDemandeAmitie ) ;

	List<DtoDemandeAmitie>	listerTout() ;

	int	insererDemandeAvecPersonnes( Integer idComtpe,  DtoPersonne dtoPersonne ) throws ExceptionValidation;
}
