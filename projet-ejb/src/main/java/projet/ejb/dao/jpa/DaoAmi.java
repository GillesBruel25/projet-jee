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

import projet.ejb.dao.IDaoAmi;
import projet.ejb.data.Ami;


@Stateless
@Local
@TransactionAttribute( MANDATORY )
public class DaoAmi implements IDaoAmi {

	
	// Champs
	
	@PersistenceContext
	private EntityManager	em;
	
	
	// Actions
	
	@Override
	public int inserer(Ami ami) {
		em.persist(ami);
		em.flush();
		return ami.getIdAmi();
	}

	@Override
	public void modifier(Ami ami) {
		em.merge( ami );
	}

	@Override
	public void supprimer(int idAmi) {
		em.remove( retrouver(idAmi) );
	}

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public Ami retrouver(int idAmi) {
		return em.find( Ami.class, idAmi );
	}

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public List<Ami> listerTout() {
		em.clear();
		var jpql = "SELECT a FROM Ami a ORDER BY a.nom";
		var query = em.createQuery( jpql, Ami.class );
		return query.getResultList();
	}

	
}
