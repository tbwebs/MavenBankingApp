package com.revature.project0.controllers;

import com.revature.project0.daos.AccountsUsersDAO;
import com.revature.project0.models.AccountsUsers;

import io.javalin.Javalin;
import io.javalin.http.Handler;

public class AccountsUsersController {

	AccountsUsersDAO linkDAO;
	
	public AccountsUsersController(Javalin app) {
		
//		app.get("/links/{accounts_users_id}", getHandler);
		app.post("/links/",	postHandler);
//		app.delete("/links/{accounts_users_id}", deleteHandler);
	}
	
//	Again with the int for primary key it doesn't want
//	public Handler getHandler = ctx -> {
//		 
//		
//	};
//	
	public Handler postHandler = ctx -> {
		
		AccountsUsers link = ctx.bodyAsClass(AccountsUsers.class);
		
		linkDAO.createAccountsUsersLink(link);
		
		ctx.status(200);
	};
	
// account number
//	public Handler deleteHandler = ctx -> {
//		
//		AccountsUsers link = ctx.bodyAsClass(AccountsUsers.class);
//		
//		linkDAO.deleteAccountsUsersByAccountNumber(accountNumber);
//		
//	};
}
