package com.formation.toDoList.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.formation.toDoList.persistence.entity.Tache;


/**
 * @project: toDoList
 * @author: Jérémy, Mélody, Julie-Claire
 * @name: TacheRepository
 * @type: repository
 * @date: 26-02-2019
 */
public interface TacheRepository extends JpaRepository<Tache,Long>{
	
	@Query (value = "SELECT * FROM tache WHERE idUtilisateur=?1 AND etat = 0", nativeQuery = true)
	List<Tache> findTaskById(Long idUtilisateur);
	
	@Query (value = "SELECT * FROM tache WHERE id=?1 AND idUtilisateur=?2", nativeQuery = true)
	Optional<Tache> findTache(Long id, Long idUtilisateur);
	
	/*@Query (value = "SELECT * FROM tache", nativeQuery = true)
	List<Tache> findAll();
	
	@Query(value= "SELECT * FROM tache WHERE DATE_FORMAT(date_echeance, \"%Y-%m-%d\") = DATE_FORMAT(NOW(),\"%Y-%m-%d\")", nativeQuery = true)
	Optional<List<Tache>> findByDate();
	
	@Query(value= "SELECT * FROM tache WHERE DATE_FORMAT(date_echeance, \"%Y-%m-%d\") < DATE_FORMAT(NOW(),\"%Y-%m-%d\")", nativeQuery = true)
	Optional<List<Tache>> findLate();
	
	@Query(value= "SELECT * FROM tache WHERE DATE_FORMAT(date_echeance, \"%Y-%m-%d\") < (SELECT DATE_ADD(DATE_FORMAT(NOW(),\"%Y-%m-%d\"),"
			+ " INTERVAL 1 WEEK)) AND DATE_FORMAT(date_echeance, \"%Y-%m-%d\") >= DATE_FORMAT(NOW(),\"%Y-%m-%d\")", nativeQuery = true)
	Optional<List<Tache>> findWeek();*/
	
	
	
}
	
	

