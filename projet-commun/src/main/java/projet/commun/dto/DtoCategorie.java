package projet.commun.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class DtoCategorie implements Serializable {
	
	// Champs
	
		private int			idCategorie;
		
		private String		nomCategorie;
		

		public DtoCategorie() {
			super();
		}

		public DtoCategorie(int idCategorie, String nomCategorie) {
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
		
		
}
