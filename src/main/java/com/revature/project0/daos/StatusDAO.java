package com.revature.project0.daos;

import java.util.ArrayList;

import com.revature.project0.models.Status;

public interface StatusDAO {
	
	public void createStatus(Status status);
	
	public ArrayList<Status> getAllStatuses();
	
	

}
