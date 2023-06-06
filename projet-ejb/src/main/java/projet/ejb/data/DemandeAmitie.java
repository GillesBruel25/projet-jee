package projet.ejb.data;

// import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.IDENTITY;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table( name = "demande_amitie" )
public class DemandeAmitie  {

	
	// Champs

	@Id
	@GeneratedValue( strategy = IDENTITY)
	@Column( name = "idDemande")
	private int			idDemande;
	
	@Column( name = "date_de_demande")
	private String		dateDemande;	
	
	@Column( name = "status")
	private String		status;
	
	@ManyToOne
	@JoinColumn(name = "destinataire")
	private Personne destinataire;

	@ManyToOne
	@JoinColumn(name = "emetteur")
	private Personne emetteur;
	
	// Constructeurs
	
	public DemandeAmitie() {
	}

	public DemandeAmitie(int idDemande, String dateDemande, String status, Personne destinataire, Personne emetteur) {
		super();
		this.idDemande = idDemande;
		this.dateDemande = dateDemande;
		this.status = status;
		this.destinataire = destinataire;
		this.emetteur = emetteur;
	}

	public int getIdDemande() {
		return idDemande;
	}

	public void setIdDemande(int idDemande) {
		this.idDemande = idDemande;
	}

	public String getDateDemande() {
		return dateDemande;
	}

	public void setDateDemande(String dateDemande) {
		this.dateDemande = dateDemande;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Personne getDestinataire() {
		return destinataire;
	}

	public void setDestinataire(Personne destinataire) {
		this.destinataire = destinataire;
	}

	public Personne getEmetteur() {
		return emetteur;
	}

	public void setEmetteur(Personne emetteur) {
		this.emetteur = emetteur;
	}

	@Override
	public String toString() {
		return "DemandeAmitie [idDemande=" + idDemande + ", dateDemande=" + dateDemande + ", status=" + status
				+ ", destinataire=" + destinataire + ", emetteur=" + emetteur + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idDemande);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DemandeAmitie other = (DemandeAmitie) obj;
		return idDemande == other.idDemande;
	}


	
	
}
