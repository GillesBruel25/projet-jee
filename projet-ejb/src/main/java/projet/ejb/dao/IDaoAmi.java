package projet.ejb.dao;

import java.util.List;

import projet.ejb.data.Ami;

public interface IDaoAmi {
	
	int			inserer( Ami ami );

	void 		modifier( Ami ami );

	void 		supprimer( int idAmi );

	Ami 		retrouver( int idAmi );

	List<Ami> listerTout();

}
