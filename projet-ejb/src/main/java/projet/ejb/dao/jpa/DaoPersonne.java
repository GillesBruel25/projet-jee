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

import projet.ejb.dao.IDaoPersonne;
import projet.ejb.data.Compte;
import projet.ejb.data.Personne;


@Stateless
@Local
@TransactionAttribute( MANDATORY )
public class DaoPersonne implements IDaoPersonne {

	
	// Champs
	
	@PersistenceContext
	private EntityManager	em;
	
	
	// Actions
	
	@Override
	public int inserer(Personne personne) {
		em.persist(personne);
		em.flush();
		return personne.getIdPersonne();
	}

	@Override
	public void modifier(Personne personne) {
		em.merge( personne );
	}

	@Override
	public void supprimer(int idPersonne) {
		em.remove( retrouver(idPersonne) );
	}

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public Personne retrouver(int idPersonne) {
		return em.find( Personne.class, idPersonne );
	}

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public List<Personne> listerTout() {
		em.clear();
		var jpql = "SELECT p FROM Personne p ORDER BY p.nom";
		var query = em.createQuery( jpql, Personne.class );
		return query.getResultList();
	}

	
	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public Personne retrouverParCompte(int idCompte) {
		em.clear();
		var jpql = "SELECT p FROM Personne p WHERE p.compte.id=:compte";
		var query = em.createQuery( jpql, Personne.class );
		query.setParameter("compte", idCompte);
		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
	
}
