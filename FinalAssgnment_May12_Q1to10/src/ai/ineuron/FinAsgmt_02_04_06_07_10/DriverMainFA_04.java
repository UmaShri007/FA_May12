package ai.ineuron.FinAsgmt_02_04_06_07_10;

// Problem/Solution::04
// A java program to simulate an Bank account, allowing user to withdraw,deposit and withdraw money

import java.util.Scanner;

class BankAccount {

	private double acctBalance;

	void deposit(double depositAmt) {

		if (depositAmt > 0) {

			acctBalance = acctBalance + depositAmt;
			System.out.println("Deposit successful,you deposited: " + depositAmt);
		} else
			System.out.println("Please enter an amount greater than zero");
	}

	void withdraw(double withdrawAmt)	{
		if(withdrawAmt>0) {
			if (withdrawAmt<=acctBalance) {

				acctBalance = acctBalance-withdrawAmt;
				System.out.println("Withdrawal of amount "+withdrawAmt+" successful.");
			}else
				System.out.println("Insufficient Balance");
	}else
		System.out.println("Please enter an amount greater than zero");
	}
	
	double viewBalance() {
		return this.acctBalance;
		
	}
}

public class DriverMainFA_04 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		BankAccount account = new BankAccount();
		
		System.out.println("Please enter an amount to be deposited");
		double depAmt = scan.nextDouble();
		account.deposit(depAmt);
		
		System.out.println("Please enter an amount to be withdrawn");
		double witdraAmt = scan.nextDouble();
		account.withdraw(witdraAmt);
		
		
		System.out.println("The current balance:: "+account.viewBalance());
	}

}
