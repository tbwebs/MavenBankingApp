package com.revature.project0.daos;

import java.util.List;

import com.revature.project0.models.Type;

public interface TypeDAO {
	
	public List<Type> getAllTypes();
	
	public void createType(Type type);
}
