package exercicio_01.application;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import exercicio_01.model.entities.Account;
import exercicio_01.model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		try {
			
			System.out.println("Enter account data");
			System.out.print("Number: ");
			int number = sc.nextInt();
			System.out.print("Holder: ");
			sc.nextLine();
			String holder = sc.nextLine();
			System.out.print("Initial balance: ");
			double balance = sc.nextDouble();
			System.out.print("Withdraw limit: ");
			double withdrawLimit = sc.nextDouble();
			
			Account acc1 = new Account(number, holder, balance, withdrawLimit);
			
			System.out.print("\nEnter amount for withdraw: ");
			acc1.withdraw(sc.nextDouble());
			System.out.printf("New balance: %.2f", acc1.getBalance());
			
		}
		catch(InputMismatchException e) {
			System.out.println("Invalid input");
		}
		catch(DomainException e) {
			System.out.println("Withdraw error: " + e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Unexpected error");
		}
		
		sc.close();

	}

}
