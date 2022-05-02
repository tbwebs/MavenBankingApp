package com.revature.project0.controllers;

import com.revature.project0.daos.AccountDAOImpl;
import com.revature.project0.models.Account;

import io.javalin.Javalin;
import io.javalin.http.Handler;


public class AccountController {

	
	AccountDAOImpl accountDAO;
	
	public AccountController(Javalin app){
		
		accountDAO = new AccountDAOImpl();
		
//		app.get("/accounts/{accountNumber}", getHandler);
		app.post("/accounts/", postHandler);
		app.put("/accounts/{accountNumber}", putHandler);
	}
	
	//Figure out how to get the long value to run this.
//	public Handler getHandler = ctx ->{
//		
//		String accountNumber = ctx.pathParam("account_number");
//		Account account = accountDAO.getAccountByAccountNumber(accountNumber);
//		
//		ctx.json(account);
//	};
	
	//create 
	public Handler postHandler = ctx ->{
		
		Account account = ctx.bodyAsClass(Account.class);
		
		accountDAO.createAccount(account);
		
		ctx.status(201);
	};
	
	//update
	public Handler putHandler = ctx -> {
		
		Account account = ctx.bodyAsClass(Account.class);
		
		accountDAO.updateAccount(account);
		
		ctx.status(200);
	};
}
