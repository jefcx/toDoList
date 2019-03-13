package com.formation.toDoList.dto;

import java.util.Date;
import java.util.Optional;

import com.formation.toDoList.persistence.entity.Projet;

public class TacheLite {

	private String contenu;
	private Date dateEcheance;
	private int priorite;
	private Projet projet;
	private Optional<Long> id;
	
	public TacheLite() {}

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

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	public Optional<Long> getId() {
		return id;
	}

	public void setId(Optional<Long> id) {
		this.id = id;
	}
	
}
