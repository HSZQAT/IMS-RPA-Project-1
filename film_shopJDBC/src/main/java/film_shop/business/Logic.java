package film_shop.business;

import film_shop.persistance.Customer;
import film_shop.persistance.CustomerManager;
import film_shop.persistance.OrderManager;
import film_shop.persistance.ProductManager;

public class Logic {

	private static CustomerManager cM = new CustomerManager();
	private static ProductManager pM = new ProductManager();
	private static OrderManager oM = new OrderManager();

	public void viewAccounts() {

		System.out.println(cM.read().toString().replaceAll("[\\[\\]]", " ").replaceAll(",", "\n") + "\n");

	}

	public void viewProducts() {

		System.out.println(pM.read().toString().replaceAll("[\\[\\]]", " ").replaceAll(",", "\n") + "\n");

	}

	public void viewOrders() {

		System.out.println(oM.read().toString().replaceAll("[\\[\\]]", " ").replaceAll(",", "\n") + "\n");

	}

	public void createAccount(int cID, String first_name, String last_name, String email, String address, String city,
			String postcode, int age, boolean loyalty) {

		Customer c1 = new Customer(cID, first_name, last_name, email, address, city, postcode, age, loyalty);
		cM.create(c1);
		System.out.println("New customer entry added!\n" + cM.read(c1.getcID()).toString());

	}

	public void checkAccount(int cID) {

		System.out.println(cM.read(cID).toString());

	}

	public void updateAccount(int choice, int cID) {

		System.out.println("What would you like to update?\n" + "1) Name\n" + "2) Email\n" + "3) Address\n"
				+ "4) Loyalty\n" + "5) Return to previous menu");

		switch (choice) {

		case 1:

			System.out.println("Please enter new first name & last name:\n");
			String first_name = "";
			String last_name = "";

			cM.update(cID, first_name, last_name);
			System.out.println("Name updated!" + cM.read(cID).toString());
			break;

		case 2:

			System.out.println("Please enter new email:\n");
			String email = "";

			cM.update(cID, email);
			System.out.println("Email updated!" + cM.read(cID).toString());
			break;

		case 3:

			System.out.println("Please enter new address, city & postcode:\n");
			String address = "";
			String city = "";
			String postcode = "";

			cM.update(cID, address, city, postcode);
			System.out.println("Address updated!" + cM.read(cID).toString());
			break;

		case 4:

			System.out.println("Please enter new loyalty status:\n");
			boolean loyalty = false;
			cM.update(cID, loyalty);
			System.out.println("Loyalty updated!" + cM.read(cID).toString());
			break;

		case 5:

			System.out.println("Returning to main menu...");
			break;

		}

	}

	public void deleteAccount(int cID) {

		System.out.println("Are you sure you want to delete customer account #" + cID + "?");
		String confirm = "";

		if (confirm == "Y") {
			cM.delete(cID);
			System.out.println("Customer account #" + cID + "deleted.");
		} else {
			System.out.println("Returning to main menu...");
		}

	}

}
