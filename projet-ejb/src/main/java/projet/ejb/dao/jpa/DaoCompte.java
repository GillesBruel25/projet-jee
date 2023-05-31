package projet.ejb.dao.jpa;

import static javax.ejb.TransactionAttributeType.MANDATORY;
import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import projet.ejb.dao.IDaoCompte;
import projet.ejb.data.Compte;
import projet.ejb.data.Personne;


@Stateless
@Local
@TransactionAttribute( MANDATORY )
public class DaoCompte implements IDaoCompte {

	
	// Champs
	
	@PersistenceContext
	private EntityManager	em;
	
	
	// Actions
	
	@Override
	public int inserer(Compte compte) {
		em.persist(compte);
		em.flush();
		return compte.getId();
	}

	@Override
	public void modifier(Compte compte) {
		em.merge( compte );
	}

	@Override
	public void supprimer(int idCompte) {
		em.remove( retrouver(idCompte) );
	}

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public Compte retrouver(int idCompte) {
		return em.find( Compte.class, idCompte );
	}

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public List<Compte> listerTout() {
		em.clear();
		var jpql = "SELECT c FROM Compte c ORDER BY c.pseudo";
		var query = em.createQuery( jpql, Compte.class );
		return query.getResultList();
	}
	
	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public Compte retrouverParPseudo(String pseudo) {
		em.clear();
		var jpql = "SELECT c FROM Compte c WHERE c.pseudo=:pseudo";
		var query = em.createQuery( jpql, Compte.class );
		query.setParameter("pseudo", pseudo);
		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
	
	@Override
	public void miseAJourCompteAvecPersonne(int idCompte, int personneId) {
		 em.clear();
		var jpql = "UPDATE Compte c SET c.personne.idPersonne=:personne WHERE c.id=:compte";
		var query = em.createQuery( jpql);
		query.setParameter("personne", personneId);
		query.setParameter("compte", idCompte);
		query.executeUpdate();
	}


	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public Compte validerAuthentification( String pseudo, String motDePasse )  {
	    var jpql = "SELECT c FROM Compte c WHERE c.pseudo=:pseudo AND c.motDePasse = :motDePasse ";
	    var query = em.createQuery( jpql, Compte.class );
	    query.setParameter( "pseudo", pseudo );
	    query.setParameter( "motDePasse", motDePasse );
	    try {
	        return query.getSingleResult();
	    } catch ( NoResultException e ) {
	        return null;
	    }
	}


	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public boolean verifierUnicitePseudo( String pseudo, int idCompte )  {
	    var jpql = "SELECT COUNT(c) FROM Compte c WHERE c.pseudo=:pseudo AND c.id <> :idCompte ";
	    var query = em.createQuery( jpql, Long.class );
	    query.setParameter( "pseudo", pseudo );
	    query.setParameter( "idCompte", idCompte );
        return query.getSingleResult() == 0;
	}
	
}
