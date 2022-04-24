package com.revature.project0.bankproject;

import org.junit.Test;

import com.revature.project0.utilclasses.ProjectUtil;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;


public class AppTest
{
	ProjectUtil pUtil = new ProjectUtil();
	
	@Test
	public void testValidInts() {
		
		assertEquals(pUtil.validWelcomeMenuInt(1), true);
		assertEquals(pUtil.validWelcomeMenuInt(4), false);
		assertEquals(pUtil.validCustomerMenuInt(5), true);
		assertEquals(pUtil.validCustomerMenuInt(7), false);
		assertEquals(pUtil.validEmployeeMenuInt(3), true);
		assertEquals(pUtil.validEmployeeMenuInt(0), false);
		assertEquals(pUtil.validAdminMenuInt(8), true);
		assertEquals(pUtil.validAdminMenuInt(10), false);
		
	}
	
    
}
