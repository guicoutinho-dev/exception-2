package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter account data \n");
		System.out.print("Number: ");
		int number = sc.nextInt();
		System.out.print("Holder: ");
		sc.nextLine();
		String holder = sc.next();
		System.out.print("Initial balance: ");
		double initialBalance = sc.nextDouble();
		System.out.print("Withdraw limit: ");
		double limit = sc.nextDouble();

		Account acc = new Account(number, holder, initialBalance, limit);

		System.out.print("Enter amount for withdraw: ");
		double amount = sc.nextDouble();
	
		 try {
			acc.withdraw(amount);
			System.out.printf("New balance: %.2f%n", acc.getBalance());
		}
		 catch (DomainException e) {
			 System.out.println(e.getMessage());
		 }

		sc.close();

	}
}
