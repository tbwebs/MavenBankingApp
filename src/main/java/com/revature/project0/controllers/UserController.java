package com.revature.project0.controllers;

import com.revature.project0.daos.UserDAOImpl;
import com.revature.project0.models.User;

import io.javalin.Javalin;
import io.javalin.http.Handler;


public class UserController {
	
	UserDAOImpl userDAO;
	
	public UserController(Javalin app) {
		
		userDAO = new UserDAOImpl();
		
		app.get("/user/{username}", getHandler);
		app.post("/user/", postHandler);
		app.put("/user/{username}", putHandler);

	}
	
	public Handler getHandler = ctx -> {
		
		String username = ctx.pathParam("username");
		
		User user = userDAO.getUserByUsername(username);
		
		ctx.json(user);
	};
	
	public Handler postHandler = ctx -> {
		
		User user = ctx.bodyAsClass(User.class);
		
		userDAO.createUser(user);
		
		ctx.status(200);
	};
	
	public Handler putHandler = ctx -> {
		
		User user = ctx.bodyAsClass(User.class);
		
		userDAO.updateUser(user);
		
		ctx.status(200);
	};
}
