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
 * @name: Utilisateur
 * @type: entity
 * @date: 27-02-2019
 */

@Entity
@Table (name ="utilisateur")

public class Utilisateur {
	
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
	 * @var: login
	 * @type: String
	 * @desc: nom d'utilisateur
	 */
	@Column (name ="login", length = 40, nullable = false)
	private String login;
	
	/**
	 * @var: mdp
	 * @type: String
	 * @desc: mot de passe d'utilisateur
	 */
	@Column (name ="mdp", length = 64, nullable = false)
	private String mdp;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

}
