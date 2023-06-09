package projet.ejb.data.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import projet.commun.dto.DtoAmi;
import projet.commun.dto.DtoAuteur;
import projet.commun.dto.DtoCategorie;
import projet.commun.dto.DtoCompte;
import projet.commun.dto.DtoDemandeAmitie;
import projet.commun.dto.DtoOuvrage;
import projet.commun.dto.DtoPersonne;
import projet.ejb.data.Ami;
import projet.ejb.data.Auteur;
import projet.ejb.data.Categorie;
import projet.ejb.data.Compte;
import projet.ejb.data.DemandeAmitie;
import projet.ejb.data.Ouvrage;
import projet.ejb.data.Personne;

 
@Mapper( componentModel = "cdi" )
public interface IMapperEjb {  
	
	static final IMapperEjb INSTANCE = Mappers.getMapper( IMapperEjb.class );
	
	
	// Compte
	
	Compte map( DtoCompte source );
	
	DtoCompte map( Compte source );
	
	// Personne
	
	Personne map( DtoPersonne source );
	
	DtoPersonne map( Personne source );
	
	// Categorie
	
	Categorie map( DtoCategorie source );
	
	DtoCategorie map( Categorie source );
	
	// Auteur
	
	Auteur map( DtoAuteur source );
	
	DtoAuteur map( Auteur source );
	
	// Ouvrage
	
	Ouvrage map( DtoOuvrage source );
	
	DtoOuvrage map( Ouvrage source );
	
	// Ami
	
	Ami map( DtoAmi source );
	
	DtoAmi map( Ami source );
	
	// DemandeAmitie
	
	DemandeAmitie map( DtoDemandeAmitie source );
	
	DtoDemandeAmitie map( DemandeAmitie source );
}
