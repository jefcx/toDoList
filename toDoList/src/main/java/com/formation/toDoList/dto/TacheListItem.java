package com.formation.toDoList.dto;

import java.util.Date;

import com.formation.toDoList.persistence.entity.Projet;
import com.formation.toDoList.persistence.entity.Tache;

public class TacheListItem {

	private String contenu;
	private Date dateEcheance;
	private int priorite;
	private int etat;
	private Projet projet;
	
	public TacheListItem(Tache taches) {
		this.setContenu(taches.getContenu());
		this.setDateEcheance(taches.getDateEcheance());
		this.setPriorite(taches.getPriorite());
		this.setEtat(taches.getEtat());
		this.setProjet(taches.getProjet());
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

	
}
