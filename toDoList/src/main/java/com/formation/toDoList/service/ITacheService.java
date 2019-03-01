package com.formation.toDoList.service;

import java.util.List;

import com.formation.toDoList.dto.TacheItem;
import com.formation.toDoList.dto.TacheListItem;
import com.formation.toDoList.persistence.entity.Tache;

/**
 * @project: toDoList
 * @author: Jérémy, Mélody, Julie-Claire
 * @name: ITacheService
 * @type: interface
 * @date: 26-02-2019
 */
public interface ITacheService {

	List<TacheListItem> findAll();

	TacheItem lie(Long idTache, Long idProjet);

	List<TacheListItem> findByDate();

	TacheItem valide(Long id);

	String deleteById(Long id);

	TacheItem modify(Tache tache);

	TacheItem save(Tache tache);
	
	
}
