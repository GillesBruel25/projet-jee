package projet.jsf.data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@SuppressWarnings("serial")
public class DemandeAmitie implements Serializable {


	// Champs
	
	private Integer			idDemande;
	
	@NotBlank( message = "La date de demande doit être renseigné")
	private String		dateDemande;
	
	
	@NotBlank( message = "Le status doit être renseigné")
	private String		status;
	
	@NotNull( message = "L'emetteur est obligatoire")
	private Personne		emetteur;
	
	@NotNull( message = "Le destinataire est obligatoire")
	private Personne		destinataire;

	/*@NotNull( message = "La catégorie est obligatoire")
	private Categorie		categorie;

	private List<Telephone>	telephones = new ArrayList<>();*/

	
	// Constructeurs
	
	public DemandeAmitie() {
	}


	public DemandeAmitie(Integer id, String dateDemande, String status, Personne destinataire, Personne emetteur) {
		super();
		this.idDemande = id;
		this.status = status;
		this.dateDemande = dateDemande;
		this.emetteur = emetteur;
		this.destinataire = destinataire;
		// this.categorie = categorie;
	}
	
	
	// Getters & setters


	public Integer getIdDemande() {
		return idDemande;
	}


	public void setIdDemande(Integer idDemande) {
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


	public Personne getEmetteur() {
		return emetteur;
	}


	public void setEmetteur(Personne emetteur) {
		this.emetteur = emetteur;
	}


	public Personne getDestinataire() {
		return destinataire;
	}


	public void setDestinataire(Personne destinataire) {
		this.destinataire = destinataire;
	}
	
	/* public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public List<Telephone> getTelephones() {
		return telephones;
	}

	public void setTelephones(List<Telephone> telephones) {
		this.telephones = telephones;
	} */

	
	// hashCode() & equals()

	@Override
	public String toString() {
		return idDemande+"";
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
		var other = (DemandeAmitie) obj;
		return Objects.equals(idDemande, other.idDemande);
	}


	

}
