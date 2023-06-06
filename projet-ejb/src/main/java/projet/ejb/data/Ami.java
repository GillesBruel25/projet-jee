package projet.ejb.data;

// import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.IDENTITY;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ami")
public class Ami {

	// Champs

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idami")
	private int idAmi;

	@Column(name = "date_anciennete")
	private String dateAnciennete;

	@ManyToOne
	@JoinColumn(name = "personne1")
	private Personne personne1;

	@ManyToOne
	@JoinColumn(name = "personne2")
	private Personne personne2;

	// Constructeurs

	public Ami() {
	}

	public Ami(int idAmi, String dateAnciennete, Personne personne1, Personne personne2) {
		super();
		this.idAmi = idAmi;
		this.dateAnciennete = dateAnciennete;
		this.personne1 = personne1;
		this.personne2 = personne2;
	}

	public int getIdAmi() {
		return idAmi;
	}

	public void setIdAmi(int idAmi) {
		this.idAmi = idAmi;
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

	@Override
	public String toString() {
		return "Ami [idAmi=" + idAmi + ", dateAnciennete=" + dateAnciennete + ", personne1=" + personne1
				+ ", personne2=" + personne2 + "]";
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
		Ami other = (Ami) obj;
		return idAmi == other.idAmi;
	}
	
	
}
