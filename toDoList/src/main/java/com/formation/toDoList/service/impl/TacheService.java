package com.formation.toDoList.service.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.toDoList.dto.TacheItem;
import com.formation.toDoList.exception.NotFoundException;
import com.formation.toDoList.persistence.entity.Projet;
import com.formation.toDoList.persistence.entity.Tache;
import com.formation.toDoList.persistence.repository.ProjetRepository;
import com.formation.toDoList.persistence.repository.TacheRepository;
import com.formation.toDoList.service.ITacheService;

@Service
@Transactional
public class TacheService implements ITacheService{
	
	@Autowired
	private TacheRepository tacheRepo;
	
	@Autowired
	private ProjetRepository projetRepo;
	
	@Override
	public TacheItem save(Tache tache) {
		
		// On vérifie que la tâche est bien liée à un projet
		// Si la tache n'est liée à aucun projet, on la lie à un projet fourre-tout
		if(tache.getProjet() == null) {

			// On recherche dans la bdd si le projet fourre-tout "Boite de réception", sinon on la créé
			Optional<Projet> opt = projetRepo.findByLibelle("Boite de réception");
			if(opt.isPresent()) {
				tache.setProjet(opt.get());
			} else {
				
				// On créé le projet
				Projet projet = new Projet();
				
				projet.setLibelle("Boite de réception");
				projetRepo.save(projet);
				
				projet.setId(projetRepo.findByLibelle("Boite de réception").get().getId());
				
				tache.setProjet(projet);
			}
		}
		return new TacheItem(tacheRepo.save(tache));
	}
	
	@Override
	public String deleteById(Long id) {
		
		if(tacheRepo.findById(id).isPresent()) {
			tacheRepo.deleteById(id);
			return "La tache id: " + id + " a été supprimée.";
		} else {
			return "La tache id: " + id + " n'existe pas.";
		}		
	}
	
	
	@Override
	public TacheItem modify(Tache tacheToModify) throws NotFoundException  {
		Optional<Tache> opt= tacheRepo.findById(tacheToModify.getId());
		if(opt.isPresent()) {
			
			return new TacheItem(tacheRepo.save(tacheToModify));
		} 
		//TODO message d'erreur
		else throw new NotFoundException("La tache n'existe pas");
	}
	
	
	@Override
	public TacheItem valide(Long id) {
		
		Optional<Tache> opt = tacheRepo.findById(id);
		
		if(opt.isPresent()) {
			
			opt.get().setEtat(1);
			tacheRepo.save(opt.get());
			
			return new TacheItem(opt.get());
		}
		//TODO message d'erreur
		return null;
	}
	
	@Override
	public TacheItem lie(Long idTache, Long idProjet) {
		// On vérifie que l'id de la tache correspond bien à une tache en bdd
		Optional<Tache> optTache = tacheRepo.findById(idTache);
		
		// On vérifie que l'id du projet correspond bien à un projet en bdd
		Optional<Projet> optProjet = projetRepo.findById(idProjet);
		
		if(optTache.isPresent() && optProjet.isPresent()) {
			optTache.get().setProjet(optProjet.get());
			return new TacheItem(tacheRepo.save(optTache.get()));
		} else throw new NotFoundException("La tache ou le projet n'existe pas.");
	}
	
	/*@Override
	public List<TacheItem> findByDate (){
		
		

		Optional<List<Tache>> opt= tacheRepo.findByDate();
		if(opt.isPresent()) {
			
			return opt.get().stream().map(p -> new TacheItem(p)).collect(Collectors.toList());
		}
		return null;
		
	}
	
	@Override
	public List<TacheItem> findWeek (){
		
		

		Optional<List<Tache>> opt= tacheRepo.findWeek();
		if(opt.isPresent()) {
			
			return opt.get().stream().map(p -> new TacheItem(p)).collect(Collectors.toList());
		}
		return null;
		
	}
	
	@Override
	public List<TacheItem> findLate(){
		Optional<List<Tache>> opt= tacheRepo.findLate();
		if(opt.isPresent()) {
			
			return opt.get().stream().map(p -> new TacheItem(p)).collect(Collectors.toList());
		}
		return null;
		
	}
	
	@Override
	public List<TacheItem> findAll() {
		List<Tache> taches = tacheRepo.findAll();
		return taches.stream().map(p -> new TacheItem(p)).collect(Collectors.toList());
	}
	*/
	
}
