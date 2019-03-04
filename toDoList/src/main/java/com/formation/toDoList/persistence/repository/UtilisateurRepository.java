package com.formation.toDoList.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.formation.toDoList.persistence.entity.Utilisateur;

/**
 * @project: toDoList
 * @author: Jérémy, Mélody, Julie-Claire
 * @name: UtilisateurRepository
 * @type: repository
 * @date: 27-02-2019
 */
public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long>{
	
	@Query (value = "SELECT * FROM utilisateur WHERE login = ?1 AND mdp = ?2", nativeQuery = true)
	Utilisateur findByLibelle(String login, String mdp);

}
