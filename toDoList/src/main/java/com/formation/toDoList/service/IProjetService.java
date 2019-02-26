package com.formation.toDoList.service;

import com.formation.toDoList.dto.ProjetItem;
import com.formation.toDoList.persistence.entity.Projet;

public interface IProjetService {
	
	String deleteProjet(Long id);
	ProjetItem saveProjet(String libelle);
	ProjetItem modifyProjet(Projet projetToModify);
	 
	
}
