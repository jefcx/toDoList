package com.formation.toDoList.utils;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.formation.toDoList.persistence.entity.Utilisateur;

@Component
public class AuthChecker {

	public Utilisateur isUtilisateur() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		boolean isUser = SecurityContextHolder.getContext().getAuthentication().getAuthorities().contains(new SimpleGrantedAuthority("ROLE_USER"));
		if (principal != null && principal instanceof Utilisateur && isUser) {
			return (Utilisateur)principal;
		} else {
			return null;
		}
	}
}
