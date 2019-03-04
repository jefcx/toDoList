package com.formation.toDoList.controller;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.formation.toDoList.dto.TacheItem;
import com.formation.toDoList.dto.UtilisateurItem;
import com.formation.toDoList.persistence.entity.Utilisateur;
import com.formation.toDoList.service.IUtilisateurService;

/**
 * @project: toDoList
 * @author: Jérémy, Mélody, Julie-Claire
 * @name: UtilisateurController
 * @type: controller
 * @date: 27-02-2019
 */

@RestController
@RequestMapping(value="/api/private/user")
public class UtilisateurSecureController {
	
	@Autowired
	private IUtilisateurService utilisateurService;
	
	/**
	 * 
	 * @metho: delete
	 * @desc: Appelle la méthode service "delete", permet de supprimer un utilisateur
	 * @param: Long id, id d'un utilisateur - String mdp, mot de passe de l'utilisateur associé
	 * @type: DELETE
	 * @return: Retourne un message si tout s'est bien passé
	 * @throws NoSuchAlgorithmException 
	 */
	@DeleteMapping(value="/{id}/{mdp}")
	@ResponseBody
	public String delete(@PathVariable Long id, @PathVariable String mdp) throws Exception{
		
		return utilisateurService.delete(id, mdp);
	}
	
	//TODO pouvoir modifier le mdp et le login de l'utilisateur

	

	/**
	 * 
	 * @metho: findTaskById
	 * @desc: Appelle la méthode service "findTaskById", permet d'afficher les taches d'un utilisateur
	 * @param: Long id, id d'un utilisateur
	 * @type: GET
	 * @return: Retourne la liste des taches liées à l'utilisateur
	 * @throws NoSuchAlgorithmException 
	 */
	@GetMapping (value="/{id}/tache")
	@ResponseBody
	public List<TacheItem> findTaskById(@PathVariable Long idUtilisateur) {
		
		return utilisateurService.findTaskById(idUtilisateur);
	}

}
