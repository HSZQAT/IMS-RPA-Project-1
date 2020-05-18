package film_shop.business;

import film_shop.persistance.Customer;
import film_shop.persistance.CustomerManager;
import film_shop.persistance.Order;
import film_shop.persistance.OrderManager;
import film_shop.persistance.Product;
import film_shop.persistance.ProductManager;
import film_shop.user.Scan;

public class Logic {

	private static CustomerManager cM = new CustomerManager();
	private static ProductManager pM = new ProductManager();
	private static OrderManager oM = new OrderManager();

	public static void viewAccounts() {

		System.out.println(cM.read().toString().replaceAll("[\\[\\]]", " ").replaceAll(",", "\n") + "\n");

	}

	public static void viewProducts() {

		System.out.println(pM.read().toString().replaceAll("[\\[\\]]", " ").replaceAll(",", "\n") + "\n");

	}

	public static void viewOrders() {

		System.out.println(oM.read().toString().replaceAll("[\\[\\]]", " ").replaceAll(",", "\n") + "\n");

	}

	public static void createAccount() {

		System.out.println("Please enter your customer ID:");
		int cID = Scan.inputInt();
		System.out.println("Please enter your first name:");
		String first_name = Scan.input();
		System.out.println("Please enter your last name:");
		String last_name = Scan.input();
		System.out.println("Please enter your email:");
		String email = Scan.input();
		System.out.println("Please enter your address:");
		String address = Scan.input();
		System.out.println("Please enter your city:");
		String city = Scan.input();
		System.out.println("Please enter your postcode:");
		String postcode = Scan.input();
		System.out.println("Please enter your age:");
		int age = Scan.inputInt();
		System.out.println("Please enter your loyalty status (Y/N):");
		String loyalty = Scan.input();
		boolean loyalBool;
		if (loyalty == "Y") {
			loyalBool = true;
		} else {
			loyalBool = false;
		}

		Customer c1 = new Customer(cID, first_name, last_name, email, address, city, postcode, age, loyalBool);
		cM.create(c1);
		System.out.println("New customer entry added!\n" + cM.read(c1.getcID()).toString() + "\n");
		return;

	}

	public static void createProduct() {

		System.out.println("Please enter a new product ID:");
		int pID = Scan.inputInt();
		System.out.println("Please enter film name:");
		String name = Scan.input();
		System.out.println("Please enter film's director:");
		String director = Scan.input();
		System.out.println("Please enter film's genre:");
		String genre = Scan.input();
		System.out.println("Please enter film's release date (YYYY-MM-DD):");
		String release_date = Scan.input();
		System.out.println("Please enter film's language:");
		String language = Scan.input();
		System.out.println("Please enter film'ss age rating:");
		int age_rating = Scan.inputInt();
		System.out.println("Please enter film's price:");
		float price = Scan.inputFloat();

		Product p1 = new Product(pID, name, director, genre, release_date, language, age_rating, price);
		pM.create(p1);
		System.out.println("New product entry added!\n" + pM.read(p1.getpID()).toString() + "\n");
		return;

	}

	public static void createOrder() {

		System.out.println("Please enter a new order ID:");
		int oID = Scan.inputInt();
		System.out.println("Please enter your customer ID:");
		int cID = Scan.inputInt();
		System.out.println("Please enter the product ID you want to order:");
		int pID = Scan.inputInt();
		float total = returnPrice(pID);

		Order o1 = new Order(oID, cID, total);
		oM.create(o1);
		System.out.println("New order entry added!\n" + oM.read(o1.getoID()).toString() + "\n");
		return;

	}

	public static float returnPrice(int pID) {

		float price = pM.read(pID).getPrice();
		return price;

	}

	public static void checkAccount() {

		System.out.println("Please enter your customer ID:");
		int cID = Scan.inputInt();

		System.out.println(cM.read(cID).toString() + "\n");

	}

	public static void updateAccount() {

		System.out.println("Which account would you like to edit?");
		int cID = Scan.inputInt();

		boolean again = true;
		while (again) {
			again = false;

			System.out.println("What would you like to update?\n" + "1) Name\n" + "2) Email\n" + "3) Address\n"
					+ "4) Loyalty\n" + "To return to main menu type 'return'");

			String choice = Scan.input();

			switch (choice) {

			case "1":

				System.out.println("Please enter new first name:\n");
				String first_name = Scan.input();
				System.out.println("Please enter new last name:\n");
				String last_name = Scan.input();

				cM.update(cID, first_name, last_name);
				System.out.println("Name updated!\n" + cM.read(cID).toString() + "\n");
				return;

			case "2":

				System.out.println("Please enter new email:\n");
				String email = Scan.input();

				cM.update(cID, email);
				System.out.println("Email updated!" + cM.read(cID).toString() + "\n");
				return;

			case "3":

				System.out.println("Please enter new address:\n");
				String address = Scan.input();
				System.out.println("Please enter new city:\n");
				String city = Scan.input();
				System.out.println("Please enter new postcode:\n");
				String postcode = Scan.input();

				cM.update(cID, address, city, postcode);
				System.out.println("Address updated!" + cM.read(cID).toString() + "\n");
				return;

			case "4":

				System.out.println("Joined loyalty program? (Y/N): \n");
				String loyalty = Scan.input();
				boolean loyalBool;
				if (loyalty == "Y") {
					loyalBool = true;
				} else {
					loyalBool = false;
				}
				cM.update(cID, loyalBool);
				System.out.println("Loyalty updated!" + cM.read(cID).toString() + "\n");
				break;

			case "return":

				System.out.println("Returning to main menu...");
				break;

			default:

				again = true;
				System.out.println("Invalid option, try again.\n");

			}
		}

	}

	public static void deleteAccount() {

		System.out.println("Please enter your customer ID:");
		int cID = Scan.inputInt();

		System.out.println("Are you sure you want to delete customer account #" + cID + "?\n1) Yes\n2) No\n");

		int confirm = Scan.inputInt();

		if (confirm == 1) {
			cM.delete(cID);
			System.out.println("Customer account #" + cID + " deleted.");
		} else if (confirm == 2) {
			System.out.println("Returning to main menu...");
		} else {
			System.out.println("Cannot confirm input. Returning to main menu...");
		}

	}

	public static void deleteProduct() {

		System.out.println("Please enter the product ID:");
		int pID = Scan.inputInt();

		System.out.println("Are you sure you want to delete product #" + pID + "?\n1) Yes\n2) No\n");

		int confirm = Scan.inputInt();

		if (confirm == 1) {
			pM.delete(pID);
			System.out.println("Product #" + pID + " deleted.");
		} else if (confirm == 2) {
			System.out.println("Returning to main menu...");
		} else {
			System.out.println("Cannot confirm input. Returning to main menu...");
		}

	}

	public static void deleteOrder() {

		System.out.println("Please enter the order ID:");
		int oID = Scan.inputInt();

		System.out.println("Are you sure you want to delete order #" + oID + "?\n1) Yes\n2) No\n");

		int confirm = Scan.inputInt();

		if (confirm == 1) {
			oM.delete(oID);
			System.out.println("Order #" + oID + " deleted.");
		} else if (confirm == 2) {
			System.out.println("Returning to main menu...");
		} else {
			System.out.println("Cannot confirm input. Returning to main menu...");
		}

	}

}
