package com.formation.toDoList.dto;

import java.util.Date;

import com.formation.toDoList.persistence.entity.Projet;
import com.formation.toDoList.persistence.entity.Tache;

public class TacheItem {

	private Long id;
	private String contenu;
	private Date dateEcheance;
	private int priorite;
	private int etat;
	private Projet projet;
	private Long idUtilisateur;
	
	public TacheItem(Tache tache) {
		this.setId(tache.getId());
		this.setContenu(tache.getContenu());
		this.setDateEcheance(tache.getDateEcheance());
		this.setEtat(tache.getEtat());
		this.setPriorite(tache.getPriorite());
		this.setProjet(tache.getProjet());
		this.setIdUtilisateur(tache.getUtilisateur().getId());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public Date getDateEcheance() {
		return dateEcheance;
	}

	public void setDateEcheance(Date dateEcheance) {
		this.dateEcheance = dateEcheance;
	}

	public int getPriorite() {
		return priorite;
	}

	public void setPriorite(int priorite) {
		this.priorite = priorite;
	}

	public int getEtat() {
		return etat;
	}

	public void setEtat(int etat) {
		this.etat = etat;
	}

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	public Long getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(Long idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}
	
}
