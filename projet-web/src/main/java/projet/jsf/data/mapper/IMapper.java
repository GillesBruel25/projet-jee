package projet.jsf.data.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import projet.commun.dto.DtoAmi;
import projet.commun.dto.DtoAuteur;
import projet.commun.dto.DtoCategorie;
import projet.commun.dto.DtoCompte;
import projet.commun.dto.DtoDemandeAmitie;
import projet.commun.dto.DtoOuvrage;
import projet.commun.dto.DtoPersonne;
import projet.jsf.data.Ami;
import projet.jsf.data.Auteur;
import projet.jsf.data.Categorie;
import projet.jsf.data.Compte;
import projet.jsf.data.DemandeAmitie;
import projet.jsf.data.Ouvrage;
import projet.jsf.data.Personne;

@Mapper(componentModel = "cdi")
public interface IMapper {

	// Compte

	Compte map(DtoCompte source);

	DtoCompte map(Compte source);

	Compte duplicate(Compte source);

	Compte update(@MappingTarget Compte target, Compte source);

	// Personne

	Personne map(DtoPersonne source);

	DtoPersonne map(Personne source);

	Personne duplicate(Personne source);

	Personne update(@MappingTarget Personne target, Personne source);

	// Categorie

	Categorie map(DtoCategorie source);

	DtoCategorie map(Categorie source);

	Categorie duplicate(Categorie source);

	Categorie update(@MappingTarget Categorie target, Categorie source);

	// Auteur

	Auteur map(DtoAuteur source);

	DtoAuteur map(Auteur source);

	Auteur duplicate(Auteur source);

	Auteur update(@MappingTarget Auteur target, Auteur source);

	// Ouvrage

	Ouvrage map(DtoOuvrage source);

	DtoOuvrage map(Ouvrage source);

	Ouvrage duplicate(Ouvrage source);

	Ouvrage update(@MappingTarget Ouvrage target, Ouvrage source);

	// Ami

	Ami map(DtoAmi source);

	DtoAmi map(Ami source);

	Ami duplicate(Ami source);

	Ami update(@MappingTarget Ami target, Ami source);

	// DemandeAmitie

	DemandeAmitie map(DtoDemandeAmitie source);

	DtoDemandeAmitie map(DemandeAmitie source);

	DemandeAmitie duplicate(DemandeAmitie source);

	DemandeAmitie update(@MappingTarget DemandeAmitie target, DemandeAmitie source);

}
