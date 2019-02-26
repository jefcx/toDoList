package com.formation.toDoList.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formation.toDoList.persistence.entity.Tache;

/**
 * @project: toDoList
 * @author: Jérémy BLANC
 * @name: TacheRepository
 * @type: repository
 * @date: 26-02-2019
 */
public interface TacheRepository extends JpaRepository<Tache,Long>{
	
}
