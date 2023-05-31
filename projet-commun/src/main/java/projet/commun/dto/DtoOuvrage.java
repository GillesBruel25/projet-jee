package projet.commun.dto;

import java.io.Serializable;


@SuppressWarnings("serial")
public class DtoOuvrage implements Serializable {
	
	// Champs
	
		private int			idOuvrage;
		
		private String		titre;
		
		private String		dateParution;

		private String		dateAchat;
		
		private String		imageLivre;
		
		private String		langueLivre;
		
		private DtoPersonne personne;
		
		private DtoAuteur auteur;
		
		private DtoCategorie categorie;
		
		public DtoOuvrage() {
			super();
		}

		public DtoOuvrage(int idOuvrage, String titre, String dateParution, String dateAchat, String imageLivre,
				String langueLivre, DtoPersonne personne, DtoAuteur auteur, DtoCategorie categorie) {
			super();
			this.idOuvrage = idOuvrage;
			this.titre = titre;
			this.dateParution = dateParution;
			this.dateAchat = dateAchat;
			this.imageLivre = imageLivre;
			this.langueLivre = langueLivre;
			this.personne = personne;
			this.auteur = auteur;
			this.categorie = categorie;
		}

		public int getIdOuvrage() {
			return idOuvrage;
		}

		public void setIdOuvrage(int idOuvrage) {
			this.idOuvrage = idOuvrage;
		}

		public String getTitre() {
			return titre;
		}

		public void setTitre(String titre) {
			this.titre = titre;
		}

		public String getDateParution() {
			return dateParution;
		}

		public void setDateParution(String dateParution) {
			this.dateParution = dateParution;
		}

		public String getDateAchat() {
			return dateAchat;
		}

		public void setDateAchat(String dateAchat) {
			this.dateAchat = dateAchat;
		}

		public String getImageLivre() {
			return imageLivre;
		}

		public void setImageLivre(String imageLivre) {
			this.imageLivre = imageLivre;
		}

		public String getLangueLivre() {
			return langueLivre;
		}

		public void setLangueLivre(String langueLivre) {
			this.langueLivre = langueLivre;
		}

		public DtoPersonne getPersonne() {
			return personne;
		}

		public void setPersonne(DtoPersonne personne) {
			this.personne = personne;
		}

		public DtoAuteur getAuteur() {
			return auteur;
		}

		public void setAuteur(DtoAuteur auteur) {
			this.auteur = auteur;
		}

		public DtoCategorie getCategorie() {
			return categorie;
		}

		public void setCategorie(DtoCategorie categorie) {
			this.categorie = categorie;
		}

		
		
		
}
