package projet.commun.service;

import java.util.List;

import projet.commun.dto.DtoAmi;
import projet.commun.exception.ExceptionValidation;


public interface IServiceAmi {
	
	int				inserer( DtoAmi dtoAmi ) throws ExceptionValidation;

	void			modifier( DtoAmi dtoAmi ) throws ExceptionValidation; 

	void			supprimer( int idAmi ) throws ExceptionValidation;

	DtoAmi 		retrouver( int idAmi ) ;

	List<DtoAmi>	listerTout() ;

}
