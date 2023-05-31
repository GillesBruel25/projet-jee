package projet.ejb.dao;

import java.util.List;

import projet.ejb.data.Categorie;

public interface IDaoCategorie {
	
	int			inserer( Categorie Categorie );

	void 		modifier( Categorie Categorie );

	void 		supprimer( int idCategorie );

	Categorie 		retrouver( int idCategorie );

	List<Categorie> listerTout();

}
