package projet.jsf.data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@SuppressWarnings("serial")
public class Categorie implements Serializable {

	
	// Champs

    private Integer        	idCategorie;
    
	@NotBlank( message = "Le nom doit être renseigné")
	@Size(max=25, message = "Valeur trop longue pour le libellé : 25 car. maxi" )
    private String      	nomCategorie;
	
    
    
    // Constructeurs
    
    public Categorie() {
	}

    public Categorie(Integer id, String nomCategorie) {
		super();
		this.idCategorie = id;
		this.nomCategorie = nomCategorie;
	}
    
    
    // Getters & setters

	public Integer getIdCategorie() {
		return idCategorie;
	}

	public void setIdCategorie(Integer idCategorie) {
		this.idCategorie = idCategorie;
	}

	public String getNomCategorie() {
		return nomCategorie;
	}

	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}
	
	
	
	// hashCode() & equals()

	@Override
	public String toString() {
		return  nomCategorie;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idCategorie);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		var other = (Categorie) obj;
		return Objects.equals(idCategorie, other.idCategorie);
	}

}
