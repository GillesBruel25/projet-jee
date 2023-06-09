package projet.commun.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class DtoAmi implements Serializable {
	
	// Champs
	
		private int			idAmi;
		
		private String		dateAnciennete;
		
		private DtoPersonne		personne1;
		
		private DtoPersonne		personne2;

		public DtoAmi() {
			super();
		}

		public DtoAmi(int idAmi, String dateAnciennete, DtoPersonne personne1, DtoPersonne personne2) {
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

		public DtoPersonne getPersonne1() {
			return personne1;
		}

		public void setPersonne1(DtoPersonne personne1) {
			this.personne1 = personne1;
		}

		public DtoPersonne getPersonne2() {
			return personne2;
		}

		public void setPersonne2(DtoPersonne personne2) {
			this.personne2 = personne2;
		}

		
		
}
