package projet.ejb.dao;

import java.util.List;

import projet.ejb.data.Compte;
import projet.ejb.data.Personne;


public interface IDaoCompte {

	int			inserer( Compte compte );

	void 		modifier( Compte compte );

	void 		supprimer( int idCompte );

	Compte 		retrouver( int idCompte );

	List<Compte> listerTout();

	Compte 		validerAuthentification( String pseudo, String motDePasse );

	boolean 	verifierUnicitePseudo( String pseudo, int idCompte );

	Compte retrouverParPseudo(String pseudo);

	// void miseAJourCompteAvecPersonne(int idCompte, int personneId);

}
