package projet.ejb.data;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "categorie")
public class Categorie {

	@Id
	@GeneratedValue( strategy = IDENTITY)
	@Column(name = "IdCategorie")
	private int idCategorie;
	
	@Column(name = "nom_categorie")
	private String nomCategorie;
	
	@OneToMany
	@JoinColumn(name="IdOuvrage")
	private List<Ouvrage> listeOuvrage = new ArrayList<Ouvrage>();

	public Categorie() {
		super();
	}

	public Categorie(int idCategorie, String nomCategorie) {
		super();
		this.idCategorie = idCategorie;
		this.nomCategorie = nomCategorie;
	}

	public int getIdCategorie() {
		return idCategorie;
	}

	public void setIdCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}

	public String getNomCategorie() {
		return nomCategorie;
	}

	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}
	
	// equals() et hashcode()

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + idCategorie;
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
			Categorie other = (Categorie) obj;
			if (idCategorie != other.idCategorie)
				return false;
			return true;
		}
}
