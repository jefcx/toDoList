package com.formation.toDoList.service;

/**
 * @project: toDoList
 * @author: Jérémy, Mélody, Julie-Claire
 * @name: ITacheService
 * @type: interface
 * @date: 26-02-2019
 */
public interface IAuthService {
	
	Boolean isUserToken(String token);
}
