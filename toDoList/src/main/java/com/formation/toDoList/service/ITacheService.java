package com.formation.toDoList.service;

import java.util.List;

import com.formation.toDoList.dto.TacheItem;
import com.formation.toDoList.dto.TacheLite;

/**
 * @project: toDoList
 * @author: Jérémy, Mélody, Julie-Claire
 * @name: ITacheService
 * @type: interface
 * @date: 26-02-2019
 */
public interface ITacheService {


	/**
	 * 
	 * @metho: modify
	 * @desc: Permet de modifier une tache
	 * @param: Objet de type Tache
	 */
	TacheItem modify(TacheLite tacheToModify);
	
	/**
	 * 
	 * @metho: valide
	 * @desc: Permet de valider (terminer) une tache
	 * @param: Long id, id d'une tache
	 */
	TacheItem valide(Long id);
	
	/**
	 * 
	 * @metho: lie
	 * @desc: Permet de lier une tache à un projet existant
	 * @param: Long idTache, id d'une tache - Long idProjet, id d'un projet
	 */
	TacheItem lie(Long idTache, Long idProjet);

	void deleteById(Long id);

	TacheItem save(TacheLite tache);
	
	/**
	 * 
	 * @metho: findAll
	 * @desc: Permet d'afficher toutes les taches
	 * @param: 
	 */
	List<TacheItem> findAllTaches();
	
	/**
	 * 
	 * @metho: findByDate
	 * @desc: Permet d'afficher toutes les taches pour une date donnée
	 * @param: 
	 */
	//List<TacheListItem> findByDate();
	
	/**
	 * 
	 * @metho: findLate
	 * @desc: Permet d'afficher toutes les taches en retard
	 * @param: 
	 */
	//List<TacheListItem> findLate();
	
	/**
	 * 
	 * @metho: findWeek
	 * @desc: Permet d'afficher toutes les taches des 7 prochains jours
	 * @param: 
	 */
	//List<TacheListItem> findWeek();
}
