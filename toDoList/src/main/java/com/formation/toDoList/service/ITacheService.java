package com.formation.toDoList.service;

import com.formation.toDoList.dto.TacheItem;
import com.formation.toDoList.persistence.entity.Tache;

/**
 * @project: toDoList
 * @author: Jérémy BLANC
 * @name: ITacheService
 * @type: interface
 * @date: 26-02-2019
 */
public interface ITacheService {
	
	/**
	 * 
	 * @metho: save
	 * @desc: Permet de persister une tache
	 * @param: Objet de type Tache
	 */
	TacheItem save(Tache tache);
	
	/**
	 * 
	 * @metho: delete
	 * @desc: Permet de supprimer une tache
	 * @param: Long id, id d'une tache
	 */
	String deleteById(Long id);
	
	/**
	 * 
	 * @metho: modify
	 * @desc: Permet de modifier une tache
	 * @param: Objet de type Tache
	 */
	TacheItem modify(Tache tache);
	
	/**
	 * 
	 * @metho: valide
	 * @desc: Permet de valider (terminer) une tache
	 * @param: Long id, id d'une tache
	 */
	TacheItem valide(Long id);
	
}
