package com.formation.toDoList.service.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.toDoList.dto.ProjetItem;
import com.formation.toDoList.persistence.entity.Projet;
import com.formation.toDoList.persistence.repository.ProjetRepository;
import com.formation.toDoList.service.IProjetService;


@Service
@Transactional
public class ProjetService implements IProjetService {

	@Autowired
	private ProjetRepository projetRepo;
	
	@Autowired
	private Projet projet;
	
	
	
	@Override
	public String deleteProjet(Long id) {
		Optional<Projet> opt= projetRepo.findById(projet.getId());
		if(opt.isPresent()) { 
			projetRepo.deleteById(id);
			return "Le projet a bien été supprimé";
			}
		else return null;
	
	}
	
	@Override
	public ProjetItem saveProjet(String libelle) {
				
		projet.setLibelle(libelle);
		
		return new ProjetItem(projetRepo.save(projet));
	}
	
	@Override
	public ProjetItem modifyProjet(Projet projetToModify) {
		Optional<Projet> opt= projetRepo.findById(projetToModify.getId());
		if(opt.isPresent()) {
			
			return new ProjetItem(projetRepo.save(projetToModify));
		} 
		//TODO message d'erreur
		else return null;
	}
	
	
	
}

