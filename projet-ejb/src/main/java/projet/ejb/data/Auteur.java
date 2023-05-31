package projet.ejb.data;

// import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.IDENTITY;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table( name = "auteur" )
public class Auteur  {

	
	// Champs

	@Id
	@GeneratedValue( strategy = IDENTITY)
	@Column( name = "idAuteur")
	private int			idAuteur;
	
	@Column( name = "nom")
	private String		nom;
	
	@Column( name = "prenom")
	private String		prenom;	
	
	@Column( name = "date_naissance")
	private String		date_naissance;
	
	@Column( name = "nationalite")
	private String		nationalite;	
	
	@Column( name = "sexe")
	private String		sexe;
	
	// Constructeurs
	
	public Auteur() {
	}

		

	public Auteur(int idAuteur, String nom, String prenom, String date_naissance, String nationalite, String sexe) {
		super();
		this.idAuteur = idAuteur;
		this.nom = nom;
		this.prenom = prenom;
		this.date_naissance = date_naissance;
		this.nationalite = nationalite;
		this.sexe = sexe;
	}




	// Getters & setters
	



	public int getIdAuteur() {
		return idAuteur;
	}


	public void setIdAuteur(int idAuteur) {
		this.idAuteur = idAuteur;
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


	public String getDate_naissance() {
		return date_naissance;
	}



	public void setDate_naissance(String date_naissance) {
		this.date_naissance = date_naissance;
	}



	public String getNationalite() {
		return nationalite;
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

    
	// equals() et hashcode()

	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idAuteur;
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
		Auteur other = (Auteur) obj;
		if (idAuteur != other.idAuteur)
			return false;
		return true;
	}
	
}
