package com.revature.project0.bankproject;

import org.apache.logging.log4j.core.util.Assert;
import org.junit.Test;

import com.revature.project0.daos.UserDAOImpl;
import com.revature.project0.models.Account;
import com.revature.project0.models.Role;
import com.revature.project0.models.Status;
import com.revature.project0.models.Type;
import com.revature.project0.models.User;
import com.revature.project0.utilclasses.ProjectUtil;
import com.revature.project0.utilclasses.Transactions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;


public class AppTest
{
	Transactions trans = new Transactions();
	UserDAOImpl userDao = new UserDAOImpl();
	ProjectUtil pUtil = new ProjectUtil();
	Account testAccount = new Account(pUtil.generateAccountNumber(), pUtil.generateRoutingNumber(), 20.00, new Type(1, "personal"), new Status(1, "pending"));
	Account testAccount2 = new Account(pUtil.generateAccountNumber(), pUtil.generateRoutingNumber(), 30.00, new Type(2, "joint"), new Status(2, "open"));
	
	ArrayList<Account> testAccounts = new ArrayList<Account>();
	
	User treyAdmin = new User("twebs", "tpass", "Trey", "Weber", "twebs@gmail.com", new Role(3, "admin"));
	User chloe = new User("crg", "cpass", "Chloe", "Griffith", "cgrif@gmail.com", new Role(1, "customer"));
	User vic = new User("gryphon", "vpass", "Victor", "Griffin", "vgrif@gmail.com", new Role(1, "customer"));
	
	ArrayList<User> testUsers = new ArrayList<User>();
	
	
	
	
//	@Test
//	public void testWelcomeMenu() {
//		
//		assertEquals(pUtil.validWelcomeMenuInput(), 0);
//		assertEquals(pUtil.validWelcomeMenuInput(), 1);
//		assertEquals(pUtil.validWelcomeMenuInput(), 2);
//	
//	@Test
//	public void testCustomerMenu() {
//		assertEquals(pUtil.validCustomerMenuInput(), 0);
//		assertEquals(pUtil.validCustomerMenuInput(), 1);
//		assertEquals(pUtil.validCustomerMenuInput(), 2);
//		assertEquals(pUtil.validCustomerMenuInput(), 3);
//		assertEquals(pUtil.validCustomerMenuInput(), 4);
//		assertEquals(pUtil.validCustomerMenuInput(), 5);
//		
//	}
//	@Test
//	public void testEmployeeMenu() {
//		assertEquals(pUtil.validEmployeeMenuInput(), 0);
//		assertEquals(pUtil.validEmployeeMenuInput(), 1);
//		assertEquals(pUtil.validEmployeeMenuInput(), 2);
//		assertEquals(pUtil.validEmployeeMenuInput(), 3);
//		assertEquals(pUtil.validEmployeeMenuInput(), 4);
//	}
//	@Test
//	public void testAdminMenu() {
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
	
	@Test
	public void testDeposit() {
		
//		assertEquals(trans.deposit(testAccount), 30.00);
		
	}
	
	@Test
	public void testAccountStatus() {
		
		assertTrue(pUtil.checkAccountStatus(testAccount2));
		assertFalse(pUtil.checkAccountStatus(testAccount));

	}	
	
	@Test
	public void testCheckusername() {
		
		ArrayList<String> testUsernames = new ArrayList<String>();
		testUsernames.add(chloe.getUsername());
		testUsernames.add(vic.getUsername());
		
		assertTrue(pUtil.checkUsername(testUsernames, "gryphon"));
		assertFalse(pUtil.checkUsername(testUsernames, "mia"));
		
	}
	
	
	
	

	
    
}
