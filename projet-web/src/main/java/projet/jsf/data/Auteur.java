package projet.jsf.data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@SuppressWarnings("serial")
public class Auteur implements Serializable {


	// Champs
	
	private Integer			idAuteur;
	
	@NotBlank( message = "Le nom doit être renseigné")
	@Size(max=25, message = "Valeur trop longue pour le nom : 25 car. maxi" )
	private String			nom;

	@NotBlank( message = "Le prénom doit être renseigné")
	@Size(max=25, message = "Valeur trop longue pour le prénom : 25 car. maxi" )
	private String			prenom;
	
	@NotBlank( message = "La date de naissance doit être renseigné")
	private String		date_naissance;
	
	@NotBlank( message = "La nationalité doit être renseigné")
	@Size(max=50, message = "Valeur trop longue pour la nationalité : 25 car. maxi" )
	private String			nationalite;
	
	@NotBlank(message="Le statut doit être renseigné")
	@Pattern(regexp="[MFN]+")
	private String sexe;

	/*@NotNull( message = "La catégorie est obligatoire")
	private Categorie		categorie;

	private List<Telephone>	telephones = new ArrayList<>();*/

	
	// Constructeurs
	
	public Auteur() {
	}

	public Auteur(Integer id, String nom, String prenom, String date_naissance , String nationalite, String sexe) {
		super();
		this.idAuteur = id;
		this.nom = nom;
		this.prenom = prenom;
		this.date_naissance = date_naissance;
		this.nationalite = nationalite;
		this.sexe = sexe;
		// this.categorie = categorie;
	}
	
	
	// Getters & setters

	public Integer getIdAuteur() {
		return idAuteur;
	}

	public void setIdAuteur(Integer id) {
		this.idAuteur = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNationalite() {
		return nationalite;
	}

	public String getDate_naissance() {
		return date_naissance;
	}

	public void setDate_naissance(String date_naissance) {
		this.date_naissance = date_naissance;
	}

	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}

	
	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
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
		return nom;
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(idAuteur);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		var other = (Auteur) obj;
		return Objects.equals(idAuteur, other.idAuteur);
	}
	

}
