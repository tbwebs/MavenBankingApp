package com.revature.project0.controllers;

import com.revature.project0.daos.AccountsUsersDAO;

import io.javalin.Javalin;
import io.javalin.http.Handler;

public class AccountsUsersController {

	AccountsUsersDAO linkDAO;
	
	public AccountsUsersController(Javalin app) {
		
		app.get("/links/{accounts_users_id}", getHandler);
		app.post("/links/",	postHandler);
		app.put("/links/{accounts_users_id}", putHandler);
	}
	
	public Handler getHandler = ctx -> {
		 
		
	};
	
	public Handler postHandler = ctx -> {
		
		
	};
	
	public Handler putHandler = ctx -> {
		
		
	};
}
