package com.formation.toDoList.dto;

import com.formation.toDoList.persistence.entity.Utilisateur;

public class UtilisateurItem {

	private Long id;
	private String login;
	private String mdp;
	
	public UtilisateurItem(Utilisateur utilisateur) {
		this.setId(utilisateur.getId());
		this.setLogin(utilisateur.getLogin());
		this.setMdp(utilisateur.getMdp());
	}

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
