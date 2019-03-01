package com.formation.toDoList.service;

import java.util.List;

import com.formation.toDoList.dto.ProjetItem;
import com.formation.toDoList.dto.TacheItem;
import com.formation.toDoList.dto.UtilisateurItem;
import com.formation.toDoList.persistence.entity.Utilisateur;

/**
 * @project: toDoList
 * @author: Jérémy, Mélody, Julie-Claire
 * @name: IUtilisateurService
 * @type: interface
 * @date: 27-02-2019
 */
public interface IUtilisateurService {
	
	/**
	 * 
	 * @metho: save
	 * @desc: Permet de persister un utilisateur
	 * @param: Objet de type Utilisateur
	 */
	UtilisateurItem save(Utilisateur utilisateur);
	
	/**
	 * 
	 * @metho: delete
	 * @desc: Permet de supprimer un utilisateur
	 * @param: Long id, id d'un utilisateur - String mdp, mot de passe de l'utilisateur associé
	 */
	String delete(Long id, String mdp);
	
	/**
	 * 
	 * @metho: findTaskById
	 * @desc: Permet d'afficher les taches d'un utilisateur
	 * @param: Long id, id d'un utilisateur 
	 */
	

	List<TacheItem> findTaskById(Long id);

	
}
