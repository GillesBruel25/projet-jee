package projet.commun.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class DtoPersonne implements Serializable {
	
	// Champs
	
		private int			idPersonne;
		
		private String		nom;
		
		private String		prenom;

		private DtoCompte		compte;
		
		public DtoPersonne() {
			super();
		}

		public DtoPersonne(int idPersonne, String nom, String prenom, DtoCompte compte) {
			super();
			this.idPersonne = idPersonne;
			this.nom = nom;
			this.prenom = prenom;
			this.compte = compte;
		}

		public int getIdPersonne() {
			return idPersonne;
		}

		public void setIdPersonne(int idPersonne) {
			this.idPersonne = idPersonne;
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

		public DtoCompte getCompte() {
			return compte;
		}

		public void setCompte(DtoCompte compte) {
			this.compte = compte;
		}

		@Override
		public String toString() {
			return "DtoPersonne [idPersonne=" + idPersonne + ", nom=" + nom + ", prenom=" + prenom + ", compte="
					+ compte + "]";
		}
		
		
		
		
}
