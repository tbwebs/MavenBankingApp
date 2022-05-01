package com.revature.project0.bankproject;

import org.junit.Test;

import com.revature.project0.models.Account;
import com.revature.project0.models.Role;
import com.revature.project0.models.Status;
import com.revature.project0.models.Type;
import com.revature.project0.models.User;
import com.revature.project0.utilclasses.ProjectUtil;
import com.revature.project0.utilclasses.Transactions;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;


public class AppTest
{
	ProjectUtil pUtil = new ProjectUtil();
	Transactions transTest = new Transactions();
	Account testAccount = new Account(pUtil.generateAccountNumber(), pUtil.generateRoutingNumber(), 20.00, new Type(1, "personal"), new Status(1, "pending"));
	Account testAccount2 = new Account(pUtil.generateAccountNumber(), pUtil.generateRoutingNumber(), 30.00, new Type(2, "joint"), new Status(2, "open"));
	
	
//	@Test
//	public void testValidMenus() {
//		
//		assertEquals(pUtil.validWelcomeMenuInput(), 0);
//		assertEquals(pUtil.validWelcomeMenuInput(), 1);
//		assertEquals(pUtil.validWelcomeMenuInput(), 2);
		
//		assertEquals(pUtil.validCustomerMenuInput(), 0);
//		assertEquals(pUtil.validCustomerMenuInput(), 1);
//		assertEquals(pUtil.validCustomerMenuInput(), 2);
//		assertEquals(pUtil.validCustomerMenuInput(), 3);
//		assertEquals(pUtil.validCustomerMenuInput(), 4);
//		assertEquals(pUtil.validCustomerMenuInput(), 5);
		
//		assertEquals(pUtil.validEmployeeMenuInput(), 0);
//		assertEquals(pUtil.validEmployeeMenuInput(), 1);
//		assertEquals(pUtil.validEmployeeMenuInput(), 2);
//		assertEquals(pUtil.validEmployeeMenuInput(), 3);
//		assertEquals(pUtil.validEmployeeMenuInput(), 4);
//
//		assertEquals(pUtil.validAdminMenuInput(), 0);
//		assertEquals(pUtil.validAdminMenuInput(), 1);
//		assertEquals(pUtil.validAdminMenuInput(), 2);
//		assertEquals(pUtil.validAdminMenuInput(), 3);
//		assertEquals(pUtil.validAdminMenuInput(), 4);
//		assertEquals(pUtil.validAdminMenuInput(), 5);
//		assertEquals(pUtil.validAdminMenuInput(), 6);
//		assertEquals(pUtil.validAdminMenuInput(), 7);
//		assertEquals(pUtil.validAdminMenuInput(), 8);

//	}
	
	@Test
	public void testCleanName() {
		assertEquals("Trey", pUtil.cleanName("trey"));
		assertEquals("Lafdjk", pUtil.cleanName("Lafdjk"));
	}
	
	

	
    
}
