package com.formation.toDoList.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.formation.toDoList.dto.ProjetItem;
import com.formation.toDoList.persistence.entity.Projet;
import com.formation.toDoList.service.IProjetService;


/**
 * @project: toDoList
 * @author: Jérémy, Mélody, Julie-Claire
 * @name: TacheController
 * @type: controller
 * @date: 26-02-2019
 */

@RestController
@RequestMapping(value="/api/projet")

public class ProjetSecureController {
	
	@Autowired
	IProjetService projetServ;
	
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
	public ProjetItem saveProjet(@PathVariable String libelle){
		return projetServ.saveProjet(libelle);
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
	public String deleteProjet(@PathVariable Long id){
		//TODO gérer parse exception
		return projetServ.deleteProjet(id);
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
	public ProjetItem modify(@RequestBody Projet projetToModify){
		return projetServ.modifyProjet(projetToModify);
	}
	
	
}
