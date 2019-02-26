package com.formation.toDoList.controller;

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
import com.formation.toDoList.persistence.entity.Tache;
import com.formation.toDoList.service.ITacheService;

/**
 * @project: toDoList
 * @author: Jérémy BLANC
 * @name: TacheController
 * @type: controller
 * @date: 26-02-2019
 */

@RestController
@RequestMapping(value="/api/tache")
public class TacheController {
	
	@Autowired
	private ITacheService tacheService;
	
	/**
	 * 
	 * @metho: save
	 * @desc: Appelle la méthode service "save", permet de persister une tache
	 * @param: Objet de type Tache
	 * @type: POST
	 * @return: Retourne un objet de type TacheItem
	 */
	@PostMapping
	@ResponseBody
	public TacheItem save(@RequestBody Tache tache){
		return tacheService.save(tache);
	}
	
	/**
	 * 
	 * @metho: delete
	 * @desc: Appelle la méthode service "delete", permet de supprimer une tache
	 * @param: Long id, id d'une tache
	 * @type: DELETE
	 * @return: Retourne un message si tout s'est bien passé
	 */
	@DeleteMapping(value="/{id}")
	@ResponseBody
	public String delete(@PathVariable Long id){
		return tacheService.deleteById(id);
	}
	
	/**
	 * 
	 * @metho: modify
	 * @desc: Appelle la méthode service "modify", permet de modifier une tache
	 * @param: Objet de type Tache
	 * @type: POST
	 * @return: Retourne un objet de type TacheItem
	 */
	@PostMapping(value="/modify")
	@ResponseBody
	public TacheItem modify(@RequestBody Tache tache){
		return tacheService.save(tache);
	}
	
	/**
	 * 
	 * @metho: valide
	 * @desc: Appelle la méthode service "valide", permet de valider (terminer) une tache
	 * @param: Long id, id d'une tache
	 * @type: GET
	 * @return: Retourne un objet de type TacheItem
	 */
	@GetMapping(value="/{id}")
	@ResponseBody
	public TacheItem valide(@PathVariable Long id){
		return tacheService.valide(id);
	}
	
}
