package com.revature.project0.utilclasses;

import com.revature.project0.bankinterfaces.InterStringCleaner;

// some helper methods to specifically handle cleaning strings
public class StringCleaner implements InterStringCleaner{

	@Override
	public String cleanNames(String firstName, String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String cleanUsername(String username) {
	
	    char[] chars = username.toCharArray();
	    String cleanUsername = "";
	    
	    for (int i = 0; i < chars.length; i++) {
	    	  
            if (!Character.isDigit(chars[i])) {
                cleanUsername = cleanUsername + chars[i];
            }
        }
		return cleanUsername;
	}

}