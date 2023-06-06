package projet.jsf.data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@SuppressWarnings("serial")
public class Ami implements Serializable {


	// Champs
	
	private Integer			idAmi;
	
	
	@NotBlank( message = "La date d'anciennete doit être renseigné")
	private String		dateAnciennete;
	
	@NotNull( message = "La personne1 est obligatoire")
	private Personne		personne1;
	
	@NotNull( message = "La personne2 est obligatoire")
	private Personne		personne2;

	/*@NotNull( message = "La catégorie est obligatoire")
	private Categorie		categorie;

	private List<Telephone>	telephones = new ArrayList<>();*/

	
	// Constructeurs
	
	public Ami() {
	}

	public Ami(Integer id, String dateAnciennete, Personne personne1, Personne personne2) {
		super();
		this.idAmi = id;
		this.dateAnciennete = dateAnciennete;
		this.personne1 = personne1;
		this.personne2 = personne2;
		// this.categorie = categorie;
	}
	
	
	// Getters & setters

	public Integer getIdAmi() {
		return idAmi;
	}

	public void setIdAmi(Integer id) {
		this.idAmi = id;
	}

	public String getDateAnciennete() {
		return dateAnciennete;
	}

	public void setDateAnciennete(String dateAnciennete) {
		this.dateAnciennete = dateAnciennete;
	}

	public Personne getPersonne1() {
		return personne1;
	}

	public void setPersonne1(Personne personne1) {
		this.personne1 = personne1;
	}

	public Personne getPersonne2() {
		return personne2;
	}

	public void setPersonne2(Personne personne2) {
		this.personne2 = personne2;
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
		return idAmi+"";
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(idAmi);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		var other = (Ami) obj;
		return Objects.equals(idAmi, other.idAmi);
	}

	
	

}
