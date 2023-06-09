package projet.jsf.data;

import java.io.Serializable;
import java.util.Objects;

import javax.servlet.http.Part;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@SuppressWarnings("serial")
public class Ouvrage implements Serializable {


	// Champs
	
	private Integer			idOuvrage;

	@NotBlank( message = "Le titre doit être renseigné")
	@Size(max=25, message = "Valeur trop longue pour le titre : 25 car. maxi" )
	private String			titre;
	
	private String			dateParution;
	
	private String			dateAchat;
	
	private String			imageLivre;
	
	private String			langueLivre;

	@NotNull( message = "La catégorie est obligatoire")
	private Categorie		categorie;
	
	@NotNull( message = "L'auteur est obligatoire")
	private Auteur		auteur;
	
	@NotNull( message = "La personne est obligatoire")
	private Personne		personne;

	private String folder = "C:\\jsf-upload\\";
	
	private Part uploadedFile;
	// private List<Telephone>	telephones = new ArrayList<>();*/

	
	// Constructeurs
	
	public Ouvrage() {
	}

	public Ouvrage(Integer id, String titre, String dateParution,  String dateAchat,  String imageLivre,  String langueLivre, Categorie categorie, Personne personne, Auteur auteur) {
		super();
		this.idOuvrage = id;
		this.titre = titre;
		this.dateParution = dateParution;
		this.dateParution = dateParution;
		this.dateAchat = dateAchat;
		this.imageLivre = imageLivre;
		this.langueLivre = langueLivre;
		this.categorie = categorie;
		this.auteur = auteur;
		this.personne = personne;
	}
	
	
	// Getters & setters

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

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
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

	public Integer getIdOuvrage() {
		return idOuvrage;
	}

	public void setIdOuvrage(Integer id) {
		this.idOuvrage = id;
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

	public String getFolder() {
		return folder;
	}

	public void setFolder(String folder) {
		this.folder = folder;
	}

	public Part getUploadedFile() {
		return uploadedFile;
	}
	
	// hashCode() & equals()

	@Override
	public int hashCode() {
		return Objects.hash(idOuvrage);
	}

	

	public void setUploadedFile(Part uploadedFile) {
		this.uploadedFile = uploadedFile;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		var other = (Ouvrage) obj;
		return Objects.equals(idOuvrage, other.idOuvrage);
	}
	

}
