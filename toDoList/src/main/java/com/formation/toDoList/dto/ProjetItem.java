package com.formation.toDoList.dto;

import com.formation.toDoList.persistence.entity.Projet;

public class ProjetItem {

	private Long id;
	
	private String libelle;
	
public ProjetItem() {
		
	}

public ProjetItem(Projet projet) {
	
	this.setId(projet.getId());
	this.setLibelle(projet.getLibelle());
	
	}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getLibelle() {
	return libelle;
}

public void setLibelle(String libelle) {
	this.libelle = libelle;
}

}
