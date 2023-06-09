package projet.ejb.dao.jpa;

import static javax.ejb.TransactionAttributeType.MANDATORY;
import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import projet.ejb.dao.IDaoDemandeAmitie;
import projet.ejb.data.DemandeAmitie;
import projet.ejb.data.Personne;


@Stateless
@Local
@TransactionAttribute( MANDATORY )
public class DaoDemandeAmitie implements IDaoDemandeAmitie {

	
	// Champs
	
	@PersistenceContext
	private EntityManager	em;
	
	
	// Actions
	
	@Override
	public int inserer(DemandeAmitie demandeAmitie) {
		em.persist(demandeAmitie);
		em.flush();
		return demandeAmitie.getIdDemande();
	}

	@Override
	public void modifier(DemandeAmitie demandeAmitie) {
		em.merge( demandeAmitie );
	}

	@Override
	public void supprimer(int idDemandeAmitie) {
		em.remove( retrouver(idDemandeAmitie) );
	}

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public DemandeAmitie retrouver(int idDemandeAmitie) {
		return em.find( DemandeAmitie.class, idDemandeAmitie );
	}

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public List<DemandeAmitie> listerTout() {
		em.clear();
		var jpql = "SELECT d FROM DemandeAmitie d";
		var query = em.createQuery( jpql, DemandeAmitie.class );
		return query.getResultList();
	}

	@Override
	public int insererDemandeAvecPersonnes(Personne emetteur, Personne personne) {
		 em.clear();
		/*var jpql = "INSERT INTO DemandeAmitie(status, date_demande, emetteur, destinataire) VALUES (:status, :date_demande, :emetteur, :destinataire)";
		var query = em.createQuery( jpql);
		query.setParameter("status", "Envoyé");
		query.setParameter("date_demande", LocalDate.now()+"");
		query.setParameter("emetteur", emetteur.getIdPersonne());
		query.setParameter("destinataire", personne.getIdPersonne());

		int row = query.executeUpdate(); */
		 
		 DemandeAmitie demandeAmitie = new DemandeAmitie();
		 demandeAmitie.setDateDemande(LocalDate.now()+"");
		 demandeAmitie.setStatus("En attente");
		 demandeAmitie.setEmetteur(emetteur);
		 demandeAmitie.setDestinataire(personne);
		 
		 em.persist(demandeAmitie);
		 em.flush();
			return demandeAmitie.getIdDemande();
	}
	
}
