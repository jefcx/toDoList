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
@RequestMapping(value="/api/public/user")
public class UtilisateurController {
	
	@Autowired
	private IUtilisateurService utilisateurService;
	
	/**
	 * 
	 * @metho: save
	 * @desc: Appelle la méthode service "save", permet de persister un utilisateur
	 * @param: Objet de type Utilisateur
	 * @type: POST
	 * @return: Retourne un objet de type UtilisateurItem
	 * @throws NoSuchAlgorithmException 
	 */
	@PostMapping
	@ResponseBody
	public UtilisateurItem save(@RequestBody Utilisateur utilisateur) throws Exception{
		return utilisateurService.save(utilisateur);
	}
	
	
	/*@PostMapping(value="/connect")
	@ResponseBody
	public String connect(@RequestBody ConnectUserItem utilisateur) throws Exception{
		/*System.out.println(headers.get("authorization"));
		, @RequestHeader HttpHeaders headers
		System.out.println(headers.get("authorization"));
		return utilisateurService.connect(utilisateur);
	}*/
}
