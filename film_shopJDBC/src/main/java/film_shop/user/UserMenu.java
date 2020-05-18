package film_shop.user;

import film_shop.business.Logic;
import film_shop.persistance.JDBCDriver;

public class UserMenu {

	public static void run() {

		System.out.println("Welcome to Helena's Film Shop!");

		boolean again = true;
		while (again) {
			again = false;

			System.out.println(
					"Please select what user you are:\n1) Customer\n2) Admin\n(To exit application type 'exit')");
			String choice = Scan.input();

			switch (choice) {

			case "1":

				runCustomer();

			case "2":

				runAdmin();

			case "exit":

				System.out.println("Exiting application. Have a nice day!");
				JDBCDriver.close();
				System.exit(0);

			default:

				again = true;
				System.out.println("Invalid option, try again.\n");

			}

		}
	}

	public static void runCustomer() {

		System.out.println("Welcome customer!");

		boolean again = true;
		while (again) {

			System.out.println(
					"Please select a menu option:\n1) Create an account\n2) View your account\n3) Update your account\n4) Delete your account\n5) View all products\n6) Create an order\n7) Delete an order\n(To exit application type 'exit');");

			String choice = Scan.input();

			switch (choice) {

			case "1":

				Logic.createAccount();
				break;

			case "2":

				Logic.checkAccount();
				break;

			case "3":

				Logic.updateAccount();
				break;

			case "4":

				Logic.deleteAccount();
				break;

			case "5":
				Logic.viewProducts();
				break;

			case "6":
				Logic.createOrder();
				break;

			case "7":
				Logic.deleteOrder();
				break;

			case "exit":

				System.out.println("Exiting application. Have a nice day!");
				JDBCDriver.close();
				System.exit(0);

			default:

				System.out.println("Invalid option, try again.\n");

			}
		}
	}

	public static void runAdmin() {

		System.out.println("Welcome admin!");

		boolean again = true;
		while (again) {

			System.out.println(
					"Please select an admin menu option:\n1) View all customer accounts\n2) View all products\n3) View all orders\n4) Add a product\n5) Delete a product\n(To exit application type 'exit')");
			String adminChoice = Scan.input();
			switch (adminChoice) {

			case "1":
				Logic.viewAccounts();
				break;

			case "2":
				Logic.viewProducts();
				break;

			case "3":
				Logic.viewOrders();
				break;

			case "4":
				Logic.createProduct();
				break;

			case "5":
				Logic.deleteProduct();
				break;

			case "exit":
				System.out.println("Exiting application. Have a nice day!");
				JDBCDriver.close();
				System.exit(0);

			default:

				System.out.println("Invalid option, try again.");

			}
		}

	}

}
