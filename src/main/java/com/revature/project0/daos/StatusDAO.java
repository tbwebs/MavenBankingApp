package com.revature.project0.daos;

import java.util.List;

import com.revature.project0.models.Status;

public interface StatusDAO {
	
	public List<Status> getAllStatuses();
	
	public void createStatus(Status status);

}
