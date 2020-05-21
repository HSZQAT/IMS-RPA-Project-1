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

	public String viewAccounts() {

//		System.out.println(cM.read().toString().replaceAll("[\\[\\]]", " ").replaceAll(",", "\n") + "\n");
		return cM.read().toString().replaceAll("[\\[\\]]", " ").replaceAll(",", "\n") + "\n";

	}

	public String viewProducts() {

//		System.out.println(pM.read().toString().replaceAll("[\\[\\]]", " ").replaceAll(",", "\n") + "\n");
		return pM.read().toString().replaceAll("[\\[\\]]", " ").replaceAll(",", "\n") + "\n";

	}

	public String viewOrders() {

//		System.out.println(oM.read().toString().replaceAll("[\\[\\]]", " ").replaceAll(",", "\n") + "\n");
		return oM.read().toString().replaceAll("[\\[\\]]", " ").replaceAll(",", "\n") + "\n";

	}

	public String createAccount() {

		int cID = (cM.read().get(cM.read().size() - 1).getcID() + 1);

		System.out.println("Customer ID #" + cID + ":");
		System.out.println("Please enter your first name:");
		String first_name = Scan.input();
		System.out.println("Please enter your last name:");
		String last_name = Scan.input();
		System.out.println("Please enter your email:");
		String email = Scan.input();
		for (Customer c : cM.read()) {
			if (email.equals(c.getEmail())) {
				System.out.println("Email already in use, please enter a new email.");
				email = Scan.input();
			}
		}
		System.out.println("Please enter your address:");
		String address = Scan.input();
		System.out.println("Please enter your city:");
		String city = Scan.input();
		System.out.println("Please enter your postcode:");
		String postcode = Scan.input();
		System.out.println("Please enter your age:");
		int age = Scan.inputInt();
		boolean loyalBool = false;
		boolean again = true;
		while (again) {
			again = false;
			System.out
					.println("Would you like to sign up to our loyalty scheme? (Receive 10% discount)\n1) Yes!\n2) No");
			int loyalty = Scan.inputInt();
			if (loyalty == 1) {
				loyalBool = true;
			} else if (loyalty == 2) {
				loyalBool = false;
			} else {
				again = true;
				System.out.println("Invalid selection. Please try again.");
			}
		}
		Customer c1 = new Customer(cID, first_name, last_name, email, address, city, postcode, age, loyalBool);
		cM.create(c1);
		return "New customer entry added!\n" + cM.read(c1.getcID()).toString() + "\n";

	}

	public void createProduct() {

		int pID = (pM.read().get(pM.read().size() - 1).getpID() + 1);

		System.out.println("Product ID #" + pID + ":");
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
		System.out.println("Please enter film's age rating:");
		int age_rating = Scan.inputInt();
		System.out.println("Please enter film's price:");
		float price = Scan.inputFloat();
		float loyalty_price = (price * 0.9f);

		Product p1 = new Product(pID, name, director, genre, release_date, language, age_rating, price, loyalty_price);
		pM.create(p1);
		System.out.println("New product entry added!\n" + pM.read(p1.getpID()).toString() + "\n");
		return;

	}

	public void createOrder() {

		int oID = (oM.read().get(oM.read().size() - 1).getoID() + 1);

		System.out.println("Order ID #" + oID + ":");
		System.out.println("Please enter your customer ID:");
		int cID = Scan.inputInt();
		System.out.println(pM.read().toString().replaceAll("[\\[\\]]", " ").replaceAll(",", "\n") + "\n");
		System.out.println("Please enter the product ID you want to order:");
		int pID = Scan.inputInt();
		float total = returnPrice(cID, pID);

		Order o1 = new Order(oID, cID, total);
		oM.create(o1);
		System.out.println("New order entry added!\n" + oM.read(o1.getoID()).toString() + "\n");
		return;

	}

	public float returnPrice(int cID, int pID) {

		int loyalty = cM.read(cID).getLoyalty();
		float price;
		if (loyalty == 1) {
			price = pM.read(pID).getLoyalty_price();
		} else {
			price = pM.read(pID).getPrice();
		}
		return price;
	}

	public float calculateTotal(int cID) {

		float total = 0.0f;
		for (Order o : oM.read()) {
			if (o.getcID() == cID) {
				total = total + o.getTotal();
			}
		}
		return total;
	}

	public void checkAccount() {

		System.out.println("Please enter your customer ID:");
		int cID = Scan.inputInt();

		System.out.println(cM.read(cID).toString() + "\n");
		System.out.println("Your orders:");
		for (Order o : oM.read()) {
			if (o.getcID() == cID) {
				System.out.println(oM.read(o.getoID()).toString());
			}
		}
		System.out.println("");
		System.out.println("Total order(s) cost: £" + calculateTotal(cID) + "\n");
	}

	public void updateAccount() {

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
				System.out.println("Email updated!\n" + cM.read(cID).toString() + "\n");
				return;

			case "3":

				System.out.println("Please enter new address:\n");
				String address = Scan.input();
				System.out.println("Please enter new city:\n");
				String city = Scan.input();
				System.out.println("Please enter new postcode:\n");
				String postcode = Scan.input();

				cM.update(cID, address, city, postcode);
				System.out.println("Address updated!\n" + cM.read(cID).toString() + "\n");
				return;

			case "4":

				Customer c = cM.read(cID);
				boolean loyalBool;
				if (c.getLoyalty() == 1) {
					boolean againUnsub = true;
					while (againUnsub) {
						againUnsub = false;
						System.out.println(
								"Unsubscribe from loyalty scheme?:\n1) Unsubscribe\n2) No, keep my 10% discount!");
						int loyalty = Scan.inputInt();
						if (loyalty == 1) {
							loyalBool = false;
							cM.update(cID, loyalBool);
						} else if (loyalty == 2) {
							loyalBool = true;
							cM.update(cID, loyalBool);
						} else {
							againUnsub = true;
							System.out.println("Invalid choice, please try again.");
						}
					}
				} else {
					boolean againSub = true;
					while (againSub) {
						againSub = false;
						System.out.println(
								"Subscribe to loyalty scheme? (10% discount on products):\n1) Subscribe!\n2) No thanks");
						int loyalty = Scan.inputInt();
						if (loyalty == 1) {
							loyalBool = true;
							cM.update(cID, loyalBool);
						} else if (loyalty == 2) {
							loyalBool = false;
							cM.update(cID, loyalBool);
						} else {
							againSub = true;
							System.out.println("Invalid choice, please try again.");
						}
					}
				}

				System.out.println("Loyalty updated!\n" + cM.read(cID).toString() + "\n");
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

	public void deleteAccount() {

		boolean again = true;
		while (again) {
			again = false;
			System.out.println("Please enter your customer ID:");
			int cID = Scan.inputInt();
			for (Customer c : cM.read()) {
				if (c.getcID() == cID) {
					boolean again2 = true;
					while (again2) {
						again2 = false;
						System.out.println(
								"Are you sure you want to delete customer account #" + cID + "?\n1) Yes\n2) No\n");
						int confirm = Scan.inputInt();
						if (confirm == 1) {
//							List<Order> toDeleteOrders = new ArrayList<Order>();
//							for (Order o : oM.read()) {
//								if (o.getcID() == cID) {
//									toDeleteOrders.add(o);
//								}
//							}
							cM.delete(cID);
							System.out.println("Customer account #" + cID + " deleted.");
							return;
						} else if (confirm == 2) {
							System.out.println("Returning to main menu...");
							return;
						} else {
							again2 = true;
							System.out.println("Cannot confirm deletion. Please try again.");
						}
					}
				}
			}
			again = true;
			System.out.println("Invalid Customer ID. Please try again.");
		}

	}

	public void deleteProduct() {

		boolean again = true;
		while (again) {
			again = false;
			System.out.println("Please enter product ID:");
			int pID = Scan.inputInt();
			for (Product p : pM.read()) {
				if (p.getpID() == pID) {
					System.out.println("Are you sure you want to delete product #" + pID + "?\n1) Yes\n2) No\n");

					boolean again2 = true;
					while (again2) {
						again2 = false;
						int confirm = Scan.inputInt();
						if (confirm == 1) {
							pM.delete(pID);
							System.out.println("Product #" + pID + " deleted.");
							return;
						} else if (confirm == 2) {
							System.out.println("Returning to main menu...");
							return;
						} else {
							again2 = true;
							System.out.println("Cannot confirm deletion. Please try again.");
						}
					}
				}
			}
			again = true;
			System.out.println("Invalid Product ID. Please try again.");
		}
	}

	public void deleteOrder() {

		boolean again = true;
		while (again) {
			again = false;
			System.out.println("Please enter order ID:");
			int oID = Scan.inputInt();
			for (Order o : oM.read()) {
				if (o.getoID() == oID) {
					System.out.println("Are you sure you want to delete order #" + oID + "?\n1) Yes\n2) No\n");

					boolean again2 = true;
					while (again2) {
						again2 = false;
						int confirm = Scan.inputInt();
						if (confirm == 1) {
							oM.delete(oID);
							System.out.println("Order #" + oID + " deleted.");
							return;
						} else if (confirm == 2) {
							System.out.println("Returning to main menu...");
							return;
						} else {
							again2 = true;
							System.out.println("Cannot confirm deletion. Please try again.");
						}
					}
				}
			}
			again = true;
			System.out.println("Invalid Order ID. Please try again.");
		}

	}

}
