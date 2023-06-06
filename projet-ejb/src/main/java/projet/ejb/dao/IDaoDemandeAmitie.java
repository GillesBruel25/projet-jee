package projet.ejb.dao;

import java.util.List;

import projet.commun.exception.ExceptionValidation;
import projet.ejb.data.DemandeAmitie;
import projet.ejb.data.Personne;

public interface IDaoDemandeAmitie {
	
	int			inserer( DemandeAmitie demandeAmitie );

	void 		modifier( DemandeAmitie demandeAmitie );

	void 		supprimer( int idDemandeAmitie );

	DemandeAmitie 		retrouver( int idDemandeAmitie );

	List<DemandeAmitie> listerTout();

	int	insererDemandeAvecPersonnes( Personne emetteur,  Personne personne ) throws ExceptionValidation;
}
