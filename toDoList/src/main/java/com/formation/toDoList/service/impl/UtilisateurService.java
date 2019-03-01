package com.formation.toDoList.service.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.toDoList.dto.ConnectUserItem;
import com.formation.toDoList.dto.UtilisateurItem;
import com.formation.toDoList.exception.NotFoundException;
import com.formation.toDoList.model.Token;
import com.formation.toDoList.persistence.entity.Utilisateur;
import com.formation.toDoList.persistence.repository.UtilisateurRepository;
import com.formation.toDoList.service.IUtilisateurService;

@Service
@Transactional
public class UtilisateurService implements IUtilisateurService{
	
	@Autowired
	private UtilisateurRepository utilisateurRepo;
	
	@Override
	public UtilisateurItem save(Utilisateur utilisateur) {
		
		// Cryptage du mdp
		utilisateur.setMdp(crypt(utilisateur.getMdp()));
		
		return new UtilisateurItem(utilisateurRepo.save(utilisateur));
	}
	
	@Override
	public String delete(Long id, String mdp) {
		
		// Recherche de l'utilisateur
		Optional<Utilisateur> opt = utilisateurRepo.findById(id);
		
		if(opt.isPresent()) {
			
			// On vérifie que le mdp transmis correspond bien au mdp en bdd
			boolean mdpOk = crypt(mdp).equals(opt.get().getMdp());
			if(mdpOk) {
				utilisateurRepo.deleteById(id);
				return "L'utilisateur est supprimé";
			} else throw new NotFoundException("Le mot de passe est incorrect. L'utilisateur n'est pas supprimé.");
		} else throw new NotFoundException("L'utilisateur n'existe pas.");
	}
	
	public String crypt(String mdp) {
		
		// Salage
		mdp+= "TeaTeam";
		
		// Utilisation du sah256
		String result = DigestUtils.sha256Hex(mdp);
		
		return result;
	}
	
	public String connect(ConnectUserItem utilisateur) {
		// Recherche de l'utilisateur
		Optional<Utilisateur> opt = utilisateurRepo.findByLibelle(utilisateur.getLogin(), crypt(utilisateur.getMdp()));
		
		if(opt.isPresent()) {
			
			Token myToken = new Token();
			myToken.setId(opt.get().getId().toString());
			myToken.setValue(crypt(opt.get().getId() + opt.get().getLogin()));
			myToken.setUser(opt.get().getLogin());
			
			return myToken.getId() + "." + myToken.getValue() + "." + myToken.getUser();
			
		} else throw new NotFoundException("L'utilisateur n'existe pas.");
	}
}
