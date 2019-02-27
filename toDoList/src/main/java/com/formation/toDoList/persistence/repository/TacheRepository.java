package com.formation.toDoList.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.formation.toDoList.persistence.entity.Tache;


/**
 * @project: toDoList
 * @author: Jérémy BLANC
 * @name: TacheRepository
 * @type: repository
 * @date: 26-02-2019
 */
public interface TacheRepository extends JpaRepository<Tache,Long>{
	
	@Query (value = "SELECT * FROM tache", nativeQuery = true)
	List<Tache> findAll();
	

	@Query(value= "SELECT * FROM tache WHERE DATE_FORMAT(date_echeance, \"%Y-%m-%d\") = DATE_FORMAT(NOW(),\"%Y-%m-%d\")", nativeQuery = true)
	Optional<List<Tache>> findByDate();
		
}
