package com.formation.toDoList.persistence.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.formation.toDoList.persistence.entity.Projet;



/**
 * @project: toDoList
 * @author: Jérémy, Mélody, Julie-Claire
 * @name: TacheRepository
 * @type: repository
 * @date: 26-02-2019
 */
public interface ProjetRepository extends JpaRepository<Projet,Long>{
	@Query (value = "SELECT * FROM projet WHERE libelle =?1 ", nativeQuery = true)
	Optional<Projet> findByLibelle(String libelle);
	
}
