package com.formation.toDoList.service;

import com.formation.toDoList.dto.ProjetItem;
import com.formation.toDoList.persistence.entity.Projet;

public interface IProjetService {
	
	/**
	 * 
	 * @metho: deleteProjet
	 * @desc: Permet de supprimer un projet
	 * @param: Long id, id d'un projet
	 */
	String deleteProjet(Long id);
	
	/**
	 * 
	 * @metho: saveProjet
	 * @desc: Permet de persister un projet
	 * @param: Objet de type String
	 */
	ProjetItem saveProjet(String libelle);
	

	/**
	 * 
	 * @metho: modifyProjet
	 * @desc: Permet de modifier un projet
	 * @param: Objet de type Projet
	 */
	ProjetItem modifyProjet(Projet projetToModify);
	 
	
}
