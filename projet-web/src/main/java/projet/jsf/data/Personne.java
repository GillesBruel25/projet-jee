package projet.jsf.data;

import java.io.Serializable;
import java.util.Objects;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@SuppressWarnings("serial")
public class Personne implements Serializable {


	// Champs
	
	private Integer			idPersonne;
	
	@NotBlank( message = "Le nom doit être renseigné")
	@Size(max=25, message = "Valeur trop longue pour le nom : 25 car. maxi" )
	private String			nom;

	@NotBlank( message = "Le prénom doit être renseigné")
	@Size(max=25, message = "Valeur trop longue pour le prénom : 25 car. maxi" )
	private String			prenom;

	private Compte		compte;
	
	/*@NotNull( message = "La catégorie est obligatoire")
	private Categorie		categorie;

	private List<Telephone>	telephones = new ArrayList<>();*/

	
	// Constructeurs
	
	public Personne() {
	}

	public Personne(Integer id, String nom, String prenom, Compte compte) {
		super();
		this.idPersonne = id;
		this.nom = nom;
		this.prenom = prenom;
		this.compte = compte;
		// this.categorie = categorie;
	}
	
	
	// Getters & setters

	public Integer getIdPersonne() {
		return idPersonne;
	}

	public void setIdPersonne(Integer id) {
		this.idPersonne = id;
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
	
	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
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
	public int hashCode() {
		return Objects.hash(idPersonne);
	}

	@Override
	public String toString() {
		return "Personne [idPersonne=" + idPersonne + ", nom=" + nom + ", prenom=" + prenom + ", compte=" + compte
				+ "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		var other = (Personne) obj;
		return Objects.equals(idPersonne, other.idPersonne);
	}
	

}
