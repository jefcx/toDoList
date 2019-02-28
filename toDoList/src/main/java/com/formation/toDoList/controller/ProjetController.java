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

import com.formation.toDoList.dto.ProjetItem;
import com.formation.toDoList.persistence.entity.Projet;
import com.formation.toDoList.service.IProjetService;




@RestController
@RequestMapping(value="/api/projet")

public class ProjetController {
	
	@Autowired
	IProjetService projetServ;
	

	@GetMapping(value="/{libelle}")
	@ResponseBody
	public ProjetItem saveProjet(@PathVariable String libelle){
		return projetServ.saveProjet(libelle);
	}
	

	@DeleteMapping(value="/{id}")
	@ResponseBody
	public String deleteProjet(@PathVariable Long id){
		//TODO gérer parse exception
		return projetServ.deleteProjet(id);
	}

	@PostMapping(value="/modify")
	@ResponseBody
	public ProjetItem modify(@RequestBody Projet projetToModify){
		return projetServ.modifyProjet(projetToModify);
	}
	
	
}
