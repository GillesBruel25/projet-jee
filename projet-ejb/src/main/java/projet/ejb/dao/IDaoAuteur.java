package projet.ejb.dao;

import java.util.List;

import projet.ejb.data.Auteur;

public interface IDaoAuteur {
	
	int			inserer( Auteur Auteur );

	void 		modifier( Auteur Auteur );

	void 		supprimer( int idAuteur );

	Auteur 		retrouver( int idAuteur );

	List<Auteur> listerTout();

}
