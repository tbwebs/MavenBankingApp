package com.revature.project0.bankinterfaces;

//helper methods for cleaning strings
public interface InterStringCleaner {
	
	String cleanNames(String firstName, String lastName);
	
	double cleanDeposits(String input);
	
	// this will format birthday input into YYYY-MM-DD
	String cleanDates(String dateinput);

	String cleanPhoneNum(String inputPhoneNumber);
}
