package projet.ejb.data;

// import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.IDENTITY;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table( name = "ouvrage" )
public class Ouvrage  {

	
	// Champs

	@Id
	@GeneratedValue( strategy = IDENTITY)
	@Column( name = "idOuvrage")
	private int			idOuvrage;
	
	@Column( name = "titre")
	private String		titre;
	
	@Column( name = "date_parution")
	private String		dateParution;	
	
	@Column( name = "date_achat")
	private String		dateAchat;
	
	@Column( name = "image_livre")
	private String		imageLivre;
	
	@Column( name = "langue_livre")
	private String		langueLivre;
	
	@ManyToOne
	@JoinColumn(name="idAuteur")
	private Auteur auteur;
	
	@OneToOne
	@JoinColumn(name="idPersonne")
	private Personne personne;
	
	@ManyToOne
	@JoinColumn(name="idCategorie")
	private Categorie categorie;
	
	// Constructeurs
	
	public Ouvrage() {
	}


	public Ouvrage(int idOuvrage, String titre, String dateParution, String dateAchat, String imageLivre,
			String langueLivre, Auteur auteur, Personne personne, Categorie categorie) {
		super();
		this.idOuvrage = idOuvrage;
		this.titre = titre;
		this.dateParution = dateParution;
		this.dateAchat = dateAchat;
		this.imageLivre = imageLivre;
		this.langueLivre = langueLivre;
		this.auteur = auteur;
		this.personne = personne;
		this.categorie = categorie;
	}

	
	public int getIdOuvrage() {
		return idOuvrage;
	}


	public void setIdOuvrage(int idOuvrage) {
		this.idOuvrage = idOuvrage;
	}


	public String getTitre() {
		return titre;
	}


	public void setTitre(String titre) {
		this.titre = titre;
	}


	public String getDateParution() {
		return dateParution;
	}


	public void setDateParution(String dateParution) {
		this.dateParution = dateParution;
	}


	public String getDateAchat() {
		return dateAchat;
	}


	public void setDateAchat(String dateAchat) {
		this.dateAchat = dateAchat;
	}


	public String getImageLivre() {
		return imageLivre;
	}


	public void setImageLivre(String imageLivre) {
		this.imageLivre = imageLivre;
	}


	public String getLangueLivre() {
		return langueLivre;
	}


	public void setLangueLivre(String langueLivre) {
		this.langueLivre = langueLivre;
	}


	public Auteur getAuteur() {
		return auteur;
	}


	public void setAuteur(Auteur auteur) {
		this.auteur = auteur;
	}


	public Personne getPersonne() {
		return personne;
	}


	public void setPersonne(Personne personne) {
		this.personne = personne;
	}


	public Categorie getCategorie() {
		return categorie;
	}


	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}


	// equals() et hashcode()
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idOuvrage;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ouvrage other = (Ouvrage) obj;
		if (idOuvrage != other.idOuvrage)
			return false;
		return true;
	}
	
}
