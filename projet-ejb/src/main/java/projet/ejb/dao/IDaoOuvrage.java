package projet.ejb.dao;

import java.util.List;

import projet.ejb.data.Ouvrage;

public interface IDaoOuvrage {
	
	int			inserer( Ouvrage Ouvrage );

	void 		modifier( Ouvrage Ouvrage );

	void 		supprimer( int idOuvrage );

	Ouvrage 		retrouver( int idOuvrage );

	List<Ouvrage> listerTout();

}
