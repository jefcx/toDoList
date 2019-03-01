package com.formation.toDoList.service.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.toDoList.model.Token;
import com.formation.toDoList.persistence.entity.Utilisateur;
import com.formation.toDoList.persistence.repository.UtilisateurRepository;
import com.formation.toDoList.service.IAuthService;

@Service
@Transactional
public class AuthService implements IAuthService{
	
	@Autowired
	UtilisateurRepository utilisateurRepo;
	
	@Autowired
	UtilisateurService utilisateurserv;
	
	public Boolean isUserToken(String token) {

		token = token.replace("[", "");
		token = token.replace("]", "");
		
		String[] parts = token.split("\\.");
		
		Token myToken = new Token();

		myToken.setId(parts[0]);
		myToken.setValue(parts[1]);
		myToken.setUser(parts[2]);
		
		Optional<Utilisateur> testId = utilisateurRepo.findById(Long.valueOf(myToken.getId()));

		if(testId.isPresent()) {
			
			if(myToken.getUser().equals(testId.get().getLogin())) {
				
				if(utilisateurserv.crypt(testId.get().getId() + testId.get().getLogin()).equals(myToken.getValue())) {
					return true;
				}
			}
		}
		return false;
	}
}
