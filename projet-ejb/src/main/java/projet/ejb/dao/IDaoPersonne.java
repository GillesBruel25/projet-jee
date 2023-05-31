package projet.ejb.dao;

import java.util.List;

import projet.ejb.data.Personne;

public interface IDaoPersonne {
	
	int			inserer( Personne Personne );

	void 		modifier( Personne Personne );

	void 		supprimer( int idPersonne );

	Personne 		retrouver( int idPersonne );

	List<Personne> listerTout();

	Personne retrouverParCompte(int idCompte);

}
