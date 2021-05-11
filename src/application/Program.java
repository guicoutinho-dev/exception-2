package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter account data");
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

		if (amount > acc.getWithdrawLimit()) {
			System.out.println("Erro de saque: A quantia excede o limite de saque");
		} else if (amount > acc.getBalance()) {
			System.out.println("Erro de saque: Saldo insuficiente!");
		} else {
			acc.withdraw(amount);
			System.out.printf("New balance: %.2f%n", acc.getBalance());
		}

		sc.close();

	}
}
