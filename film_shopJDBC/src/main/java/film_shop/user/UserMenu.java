package film_shop.user;

import film_shop.business.Logic;
import film_shop.persistance.JDBCDriver;

public class UserMenu {

	static Logic logic = new Logic();

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
					"Please select a menu option:\n1) Create an account\n2) View your account\n3) Update your account\n4) Delete your account\n5) View all products\n6) Create an order\n7) Delete an order\n(To return to previous menu type 'return')\n(To exit application type 'exit');");

			String choice = Scan.input();

			switch (choice) {

			case "1":

				System.out.println(logic.createAccount());
				break;

			case "2":

				System.out.println(logic.checkAccount());
				break;

			case "3":

				logic.updateAccount();
				break;

			case "4":

				System.out.println(logic.deleteAccount());
				break;

			case "5":
				System.out.println(logic.viewProducts());
				break;

			case "6":
				System.out.println(logic.createOrder());
				break;

			case "7":
				System.out.println(logic.deleteOrder());
				break;

			case "return":

				System.out.println("Returning to user menu...");
				run();

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
					"Please select an admin menu option:\n1) View all customer accounts\n2) View all products\n3) View all orders\n4) Add a product\n5) Delete a product\n(To return to previous menu type 'return')\n(To exit application type 'exit')");
			String adminChoice = Scan.input();
			switch (adminChoice) {

			case "1":
				System.out.println(logic.viewAccounts());
				break;

			case "2":
				System.out.println(logic.viewProducts());
				break;

			case "3":
				System.out.println(logic.viewOrders());
				break;

			case "4":
				System.out.println(logic.createProduct());
				break;

			case "5":
				System.out.println(logic.deleteProduct());
				break;

			case "return":
				System.out.println("Returning to user menu...");
				run();

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
