package com.revature.project0.bankproject;

import org.junit.Test;

import com.revature.project0.models.Account;
import com.revature.project0.models.Status;
import com.revature.project0.models.Type;
import com.revature.project0.utilclasses.ProjectUtil;
import com.revature.project0.utilclasses.Transactions;

import static org.junit.Assert.assertEquals;


public class AppTest
{
	ProjectUtil pUtil = new ProjectUtil();
	Transactions transTest = new Transactions();
	Account testAccount = new Account(0, pUtil.generateAccountNumber(), pUtil.generateRoutingNumber(), 20.00, new Type(1, "personal"), new Status(1, "pending"));
	Account testAccount2 = new Account(1, pUtil.generateAccountNumber(), pUtil.generateRoutingNumber(), 30.00, new Type(2, "joint"), new Status(2, "open"));
	
	
	@Test
	public void testValidInts() {
		
		//will have to check new input methods with new loops
		
	}
	
	@Test
	public void testDeposit() {
		assertEquals(transTest.deposit(10.00, testAccount), 30.00, 0.001);
		assertEquals(transTest.deposit(0.30, testAccount), 20.30, 0.001);
		assertEquals(transTest.deposit(10.50, testAccount), 30.50, 0.001);
		assertEquals(transTest.deposit(10000, testAccount), 10020, 0.001);

	}
	
	@Test
	public void testWithdrawal() {
		assertEquals(transTest.withdraw(5, testAccount), 15, 0.001);
		assertEquals(transTest.withdraw(10, testAccount), 10, 0.001);
		assertEquals(transTest.withdraw(20, testAccount), 0, 0.001);
		assertEquals(transTest.withdraw(6.40, testAccount), 13.60 , 0.001);
	}
	
	@Test
	public void testTransfer() {
		assertEquals(transTest.transfer(5, testAccount, testAccount2), 35, 0.001);
		assertEquals(transTest.transfer(20, testAccount, testAccount2), 50, 0.001);
		assertEquals(transTest.transfer(10.25, testAccount, testAccount2), 40.25, 0.001);
		assertEquals(transTest.transfer(5, testAccount2, testAccount), 25, 0.001);
	}
	
	
    
}
