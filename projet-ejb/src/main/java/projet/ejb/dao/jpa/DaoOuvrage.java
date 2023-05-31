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

import projet.ejb.dao.IDaoOuvrage;
import projet.ejb.data.Ouvrage;


@Stateless
@Local
@TransactionAttribute( MANDATORY )
public class DaoOuvrage implements IDaoOuvrage {

	
	// Champs
	
	@PersistenceContext
	private EntityManager	em;
	
	
	// Actions
	
	@Override
	public int inserer(Ouvrage personne) {
		em.persist(personne);
		em.flush();
		return personne.getIdOuvrage();
	}

	@Override
	public void modifier(Ouvrage personne) {
		em.merge( personne );
	}

	@Override
	public void supprimer(int idOuvrage) {
		em.remove( retrouver(idOuvrage) );
	}

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public Ouvrage retrouver(int idOuvrage) {
		return em.find( Ouvrage.class, idOuvrage );
	}

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public List<Ouvrage> listerTout() {
		em.clear();
		var jpql = "SELECT o FROM Ouvrage o ORDER BY o.titre";
		var query = em.createQuery( jpql, Ouvrage.class );
		return query.getResultList();
	}

	
}
