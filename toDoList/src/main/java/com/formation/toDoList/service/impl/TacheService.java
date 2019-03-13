package com.formation.toDoList.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.toDoList.dto.TacheItem;
import com.formation.toDoList.dto.TacheLite;
import com.formation.toDoList.exception.NotFoundException;
import com.formation.toDoList.persistence.entity.Projet;
import com.formation.toDoList.persistence.entity.Tache;
import com.formation.toDoList.persistence.repository.ProjetRepository;
import com.formation.toDoList.persistence.repository.TacheRepository;
import com.formation.toDoList.service.ITacheService;
import com.formation.toDoList.utils.AuthChecker;

@Service
@Transactional
public class TacheService implements ITacheService {

	@Autowired
	private TacheRepository tacheRepo;

	@Autowired
	private ProjetRepository projetRepo;

	@Autowired
	private AuthChecker authChecker;

	@Override
	public TacheItem save(TacheLite tacheLite) {

		// On vérifie que la tâche est bien liée à un projet
		// Si la tache n'est liée à aucun projet, on la lie à un projet fourre-tout
		if (tacheLite.getProjet().getLibelle() == null) {

			// On recherche dans la bdd si le projet fourre-tout "Boite de réception", sinon
			// on la créé
			Optional<Projet> opt = projetRepo.findByLibelle("Boite de réception");
			if (opt.isPresent()) {
				tacheLite.setProjet(opt.get());
			} else {

				// On créé le projet
				Projet projet = new Projet();

				projet.setLibelle("Boite de réception");
				projetRepo.save(projet);

				projet.setId(projetRepo.findByLibelle("Boite de réception").get().getId());

				tacheLite.setProjet(projet);
			}
		} else {
			Optional<Projet> opt = projetRepo.findByLibelle(tacheLite.getProjet().getLibelle());
			if (opt.isPresent()) {
				tacheLite.setProjet(opt.get());
			} else {
				Projet projet = new Projet();
				projet.setLibelle(tacheLite.getProjet().getLibelle());
				projetRepo.save(projet);
				projet.setId(projetRepo.findByLibelle(tacheLite.getProjet().getLibelle()).get().getId());
				tacheLite.setProjet(projet);
			}
		}
		
		Tache tache = new Tache();
		tache.setContenu(tacheLite.getContenu());
		tache.setDateEcheance(tacheLite.getDateEcheance());
		tache.setPriorite(tacheLite.getPriorite());
		tache.setProjet(tacheLite.getProjet());
		tache.setUtilisateur(authChecker.isUtilisateur());
		
		return new TacheItem(tacheRepo.save(tache));
	}

	@Override
	public void deleteById(Long id) {

		Optional<Tache> opt = tacheRepo.findTache(id, authChecker.isUtilisateur().getId());

		if (opt.isPresent()) {
			
			tacheRepo.deleteById(id);
		} else {
			
		}
	}

	@Override
	public TacheItem modify(TacheLite tacheToModify) throws NotFoundException {
		
		Long myId = tacheToModify.getId().get();
		
		Optional<Tache> opt = tacheRepo.findTache(myId, authChecker.isUtilisateur().getId());

		if (opt.isPresent()) {
			
			Optional<Projet> optProjet = projetRepo.findByLibelle(tacheToModify.getProjet().getLibelle());
			if (optProjet.isPresent()) {
				tacheToModify.setProjet(optProjet.get());
			} else {
				Projet projet = new Projet();
				projet.setLibelle(tacheToModify.getProjet().getLibelle());
				projetRepo.save(projet);
				projet.setId(projetRepo.findByLibelle(tacheToModify.getProjet().getLibelle()).get().getId());
				tacheToModify.setProjet(projet);
			}
			
			
			Tache tache = new Tache();
			tache.setContenu(tacheToModify.getContenu());
			tache.setDateEcheance(tacheToModify.getDateEcheance());
			tache.setPriorite(tacheToModify.getPriorite());
			tache.setProjet(tacheToModify.getProjet());
			tache.setUtilisateur(authChecker.isUtilisateur());
			tache.setId(myId);
			
			return new TacheItem(tacheRepo.save(tache));
		}
		// TODO message d'erreur
		else
			throw new NotFoundException("La tache n'existe pas");
	}

	@Override
	public TacheItem valide(Long id) {

		Optional<Tache> opt = tacheRepo.findTache(id, authChecker.isUtilisateur().getId());

		if (opt.isPresent()) {

			opt.get().setEtat(1);
			tacheRepo.save(opt.get());

			return new TacheItem(opt.get());
		}
		// TODO message d'erreur
		return null;
	}

	@Override
	public TacheItem lie(Long idTache, Long idProjet) {
		// On vérifie que l'id de la tache correspond bien à une tache en bdd
		Optional<Tache> optTache = tacheRepo.findTache(idTache, authChecker.isUtilisateur().getId());

		// On vérifie que l'id du projet correspond bien à un projet en bdd
		Optional<Projet> optProjet = projetRepo.findById(idProjet);

		if (optTache.isPresent() && optProjet.isPresent()) {
			optTache.get().setProjet(optProjet.get());
			return new TacheItem(tacheRepo.save(optTache.get()));
		} else
			throw new NotFoundException("La tache ou le projet n'existe pas.");
	}

	/*
	 * @Override public List<TacheItem> findByDate (){
	 * 
	 * 
	 * 
	 * Optional<List<Tache>> opt= tacheRepo.findByDate(); if(opt.isPresent()) {
	 * 
	 * return opt.get().stream().map(p -> new
	 * TacheItem(p)).collect(Collectors.toList()); } return null;
	 * 
	 * }
	 * 
	 * @Override public List<TacheItem> findWeek (){
	 * 
	 * 
	 * 
	 * Optional<List<Tache>> opt= tacheRepo.findWeek(); if(opt.isPresent()) {
	 * 
	 * return opt.get().stream().map(p -> new
	 * TacheItem(p)).collect(Collectors.toList()); } return null;
	 * 
	 * }
	 * 
	 * @Override public List<TacheItem> findLate(){ Optional<List<Tache>> opt=
	 * tacheRepo.findLate(); if(opt.isPresent()) {
	 * 
	 * return opt.get().stream().map(p -> new
	 * TacheItem(p)).collect(Collectors.toList()); } return null;
	 * 
	 * }
	 */

	@Override
	public List<TacheItem> findAllTaches() {
		Optional<List<Tache>> opt = tacheRepo.findAllTaches(authChecker.isUtilisateur().getId());

		if (opt.isPresent()) {
			return opt.get().stream().map(p -> new TacheItem(p)).collect(Collectors.toList());
		}

		return null;
	}

}
