package com.revature.project0.daos;

import java.util.ArrayList;
import java.util.List;

import com.revature.project0.models.Type;

public interface TypeDAO {
	
	public void createType(Type type);
	
	public ArrayList<Type> getAllTypes();
}
