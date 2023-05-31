package projet.commun.dto;

import java.io.Serializable;
import java.time.LocalDate;

@SuppressWarnings("serial")
public class DtoAuteur implements Serializable {
	
	// Champs
	
		private int			idAuteur;
		
		private String		nom;
		
		private String		prenom;
		
		private String		date_naissance;
		
		private String		nationalite;
		
		private String		sexe;

		public DtoAuteur() {
			super();
		}

		public DtoAuteur(int idAuteur, String nom, String sexe, String prenom, String date_naissance, String nationalite) {
			super();
			this.idAuteur = idAuteur;
			this.nom = nom;
			this.prenom = prenom;
			this.date_naissance = date_naissance;
			this.nationalite = nationalite;
			this.sexe = sexe;
		}

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
		
		
		
}
