package com.formation.toDoList.service.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.toDoList.dto.TacheItem;
import com.formation.toDoList.persistence.entity.Tache;
import com.formation.toDoList.persistence.repository.TacheRepository;
import com.formation.toDoList.service.ITacheService;

@Service
@Transactional
public class TacheService implements ITacheService{
	
	@Autowired
	private TacheRepository tacheRepo;
	
	@Override
	public TacheItem save(Tache tache) {
		
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
	public TacheItem modify(Tache tache) {
		
		TacheItem tacheItem = new TacheItem(tache);
		
		Optional<Tache> opt = tacheRepo.findById(tacheItem.getId());
		
		if(opt.isPresent()) {
			tacheRepo.save(tache);
			return tacheItem;
		}
		//TODO message d'erreur
		return null;
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
}
