package com.formation.toDoList.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * @project: toDoList
 * @author: Jérémy, Mélody, Julie-Claire
 * @name: Projet
 * @type: entity
 * @date: 26-02-2019
 */

@Entity
@Table (name ="projet")

public class Projet {
	
	/**
	 * @var: id
	 * @type: Long
	 * @desc: clé primaire de la table
	 */
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "id", unique = true, nullable = false)
	private Long id;
	
	/**
	 * @var: Libellé
	 * @type: String
	 * @desc: Libellé du Projet
	 */
	@Column (name ="libellé", length = 140, nullable = false)
	private String libelle;
	

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getLibelle() {
		return libelle;
	}


	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


	public Projet() {
		// TODO Auto-generated constructor stub
	}

}
