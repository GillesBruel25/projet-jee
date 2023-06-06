package projet.commun.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class DtoDemandeAmitie implements Serializable {
	
	// Champs
	
		private int			idDemande;
		
		private DtoPersonne		destinataire;
		
		private String		dateDemande;
		
		private String		status;
		
		private DtoPersonne		emetteur;

		public DtoDemandeAmitie() {
			super();
		}

		public DtoDemandeAmitie(int idDemande, DtoPersonne destinataire, String dateDemande, String status,
				DtoPersonne emetteur) {
			super();
			this.idDemande = idDemande;
			this.destinataire = destinataire;
			this.dateDemande = dateDemande;
			this.status = status;
			this.emetteur = emetteur;
		}

		public int getIdDemande() {
			return idDemande;
		}

		public void setIdDemande(int idDemande) {
			this.idDemande = idDemande;
		}

		public DtoPersonne getDestinataire() {
			return destinataire;
		}

		public void setDestinataire(DtoPersonne destinataire) {
			this.destinataire = destinataire;
		}

		public String getDateDemande() {
			return dateDemande;
		}

		public void setDateDemande(String dateDemande) {
			this.dateDemande = dateDemande;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public DtoPersonne getEmetteur() {
			return emetteur;
		}

		public void setEmetteur(DtoPersonne emetteur) {
			this.emetteur = emetteur;
		}

				
		
}
