package com.formation.toDoList.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.formation.toDoList.dto.ProjetItem;
import com.formation.toDoList.exception.NotFoundException;
import com.formation.toDoList.persistence.entity.Projet;
import com.formation.toDoList.service.IProjetService;
import com.formation.toDoList.service.impl.AuthService;


/**
 * @project: toDoList
 * @author: Jérémy, Mélody, Julie-Claire
 * @name: TacheController
 * @type: controller
 * @date: 26-02-2019
 */

@RestController
@RequestMapping(value="/api/projet")

public class ProjetController {
	
	@Autowired
	IProjetService projetServ;
	
	@Autowired
	private AuthService authService;
	
	/**
	 * 
	 * @metho: save
	 * @desc: Appelle la méthode service "save", permet de persister un projet
	 * @param: Objet de type String
	 * @type: POST
	 * @return: Retourne un objet de type ProjetItem
	 */
	@GetMapping(value="/{libelle}")
	@ResponseBody
	public ProjetItem saveProjet(@PathVariable String libelle, @RequestHeader HttpHeaders auth){
		if(auth.containsKey("Authorization") && auth.get("Authorization") != null) {

			if(authService.isUserToken(auth.get("Authorization").toString())) {
				
				return projetServ.saveProjet(libelle);
			}
		} throw new NotFoundException("Acces refused");
	}
	
	/**
	 * 
	 * @metho: delete
	 * @desc: Appelle la méthode service "delete", permet de supprimer un projet
	 * @param: Long id, id d'une projet
	 * @type: DELETE
	 * @return: Retourne un message si tout s'est bien passé
	 */
	@DeleteMapping(value="/{id}")
	@ResponseBody
	public String deleteProjet(@PathVariable Long id, @RequestHeader HttpHeaders auth){
		//TODO gérer parse exception
		if(auth.containsKey("Authorization") && auth.get("Authorization") != null) {

			if(authService.isUserToken(auth.get("Authorization").toString())) {
				
				return projetServ.deleteProjet(id);
			}
		} throw new NotFoundException("Acces refused");
	}

	/**
	 * 
	 * @metho: modify
	 * @desc: Appelle la méthode service "modify", permet de mettre à jour un projet
	 * @param: Objet de type Projet
	 * @type: PUT
	 * @return: Retourne un objet de type ProjetItem
	 */
	@PutMapping
	@ResponseBody
	public ProjetItem modify(@RequestBody Projet projetToModify, @RequestHeader HttpHeaders auth){
		if(auth.containsKey("Authorization") && auth.get("Authorization") != null) {

			if(authService.isUserToken(auth.get("Authorization").toString())) {
				
				return projetServ.modifyProjet(projetToModify);
			}
		} throw new NotFoundException("Acces refused");
	}
	
	
}
