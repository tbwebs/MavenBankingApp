package com.revature.project0.app;

import com.revature.project0.models.Account;
import com.revature.project0.models.Status;
import com.revature.project0.models.Type;
import com.revature.project0.utilclasses.ProjectUtil;
import com.revature.project0.utilclasses.Transactions;

public class TestDriver {

	public static void main(String[] args) {
		
		ProjectUtil pUtil = new ProjectUtil();
		Transactions trans = new Transactions();
		
		Account testAccount = new Account(0, pUtil.generateAccountNumber(), pUtil.generateRoutingNumber(), 20.00, new Type(1, "personal"), new Status(1, "pending"));
		Account testAccount2 = new Account(1, pUtil.generateAccountNumber(), pUtil.generateRoutingNumber(), 30.00, new Type(2, "joint"), new Status(2, "open"));

		double balance = trans.transfer(testAccount, testAccount2);
		
		System.out.print(balance);
	}

}
