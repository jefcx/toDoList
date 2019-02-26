package com.formation.toDoList.persistence.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @project: toDoList
 * @author: Jérémy BLANC
 * @name: Tache
 * @type: entity
 * @date: 26-02-2019
 */

@Entity
@Table (name ="tache")
public class Tache {

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
	 * @var: contenu
	 * @type: String
	 * @desc: Intitulé de la tâche
	 */
	@Column (name ="contenu", length = 140, nullable = false)
	private String contenu;
	
	/**
	 * @var: dateEcheance
	 * @type: Date
	 * @desc: Date à la quelle la tâche doit être executée par l'utilisateur, peut être optionnelle
	 */
	@Column (name = "date_echeance")
	private Date dateEcheance;
	
	/**
	 * @var: priorite
	 * @type: int
	 * @desc: Indique l'importance de la tâche, peut être optionnelle
	 * empty ou 0 = pas de priorité
	 * 1 = priorité normale
	 * 2 = priorité importante
	 * 3 = priorité urgente,
	 * ...
	 */
	@Column (name = "priorite")
	private int priorite;
	
	/**
	 * @var: etat
	 * @type: int
	 * @desc: Détermine l'état de la tâche
	 * 0 = tâche en cours
	 * 1 = tâche terminée
	 */
	@Column (name = "etat", nullable =false)
	private int etat;
	
	@ManyToOne
	@JoinColumn(name = "idProjet", referencedColumnName = "id")
	private Projet projet;

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
	
}

