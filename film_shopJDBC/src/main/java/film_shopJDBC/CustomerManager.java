package film_shopJDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerManager {

	private ArrayList<Customer> customers = new ArrayList<Customer>();

	public void initialise() {

		String query = "SELECT * FROM customer";
		ResultSet results = JDBCDriver.execQuery(query);

		try {
			while (results.next()) {

				this.customers.add(new Customer(results.getInt("CID"), results.getString("first_name"),
						results.getString("last_name"), results.getString("email"), results.getString("address"),
						results.getString("city"), results.getString("postcode"), results.getInt("age"),
						results.getBoolean("loyalty")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void create(Customer c) {

		this.customers.add(c);
		String query = "INSERT INTO customer VALUES (" + c.getcID() + ", \"" + c.getFirst_name() + "\", \""
				+ c.getLast_name() + "\", \"" + c.getEmail() + "\", \"" + c.getAddress() + "\", \"" + c.getCity()
				+ "\", \"" + c.getPostcode() + "\"," + c.getAge() + " , " + c.getLoyalty() + ")";

		JDBCDriver.execUpdate(query);
		System.out.println("New customer entry added!");
	}

	// public Customer read(int cID) {
//
//		String query = "SELECT * FROM customer WHERE CID = " + cID;
//
//		ResultSet results = JDBCDriver.execQuery(query);
//
//		Customer resultCustomer = new Customer();
//
//		try {
//			while (results.next()) {
//
//				resultCustomer.setcID(results.getInt("CID"));
//				resultCustomer.setFirst_name(results.getString("first_name"));
//				resultCustomer.setLast_name(results.getString("last_name"));
//				resultCustomer.setEmail(results.getString("email"));
//				resultCustomer.setAddress(results.getString("address"));
//				resultCustomer.setCity(results.getString("city"));
//				resultCustomer.setPostcode(results.getString("postcode"));
//				resultCustomer.setAge(results.getInt("age"));
//				resultCustomer.setLoyalty(results.getBoolean("loyalty"));
//
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return resultCustomer;
//	}

	public ArrayList<Customer> read() {
		return customers;
	}

	public Customer read(int cID) {

		for (Customer c : customers) {

			if (c.getcID() == cID) {

				return c;
			}
		}
		System.out.println("Customer ID doesn't exist.");
		return null;
	}

	public void update(int cID, String first_name, String last_name) {

		for (Customer c : customers) {
			if (c.getcID() == cID) {

				c.setFirst_name(first_name);
				c.setLast_name(last_name);
			}
		}

		String query = "UPDATE customer SET first_name = \"" + first_name + "\", last_name = \"" + last_name
				+ "\" WHERE CID = " + cID;
		JDBCDriver.execUpdate(query);
		System.out.println("Customer " + cID + "'s name has been updated.");

	}

	public void update(int cID, String email) {

		for (Customer c : customers) {
			if (c.getcID() == cID) {

				c.setEmail(email);

			}
		}

		String query = "UPDATE customer SET email = \"" + email + "\" WHERE CID = " + cID;
		JDBCDriver.execUpdate(query);
		System.out.println("Customer " + cID + "'s email has been updated.");

	}

	public void update(int cID, String address, String city, String postcode) {

		for (Customer c : customers) {
			if (c.getcID() == cID) {

				c.setAddress(address);
				c.setCity(city);
				c.setPostcode(postcode);

			}
		}

		String query = "UPDATE customer SET address = \"" + address + "\", city = \"" + city + "\", postcode = \""
				+ postcode + "\" WHERE CID = " + cID;
		JDBCDriver.execUpdate(query);
		System.out.println("Customer " + cID + "'s address has been updated.");

	}

	public void update(int cID, boolean loyalty) {

		int l = 0;
		if (loyalty) {
			l = 1;
		}

		for (Customer c : customers) {
			if (c.getcID() == cID) {

				c.setLoyalty(loyalty);

			}
		}

		String query = "UPDATE customer SET loyalty = " + l + " WHERE CID = " + cID;
		JDBCDriver.execUpdate(query);
		System.out.println("Customer " + cID + "'s loyalty has been updated.");

	}

	public void delete(int cID) {

		for (Customer c : customers) {
			if (c.getcID() == cID) {
				this.customers.remove(c);
			}
		}

		String query = "DELETE FROM customer WHERE CID = " + cID;
		JDBCDriver.execUpdate(query);
		System.out.println("Customer " + cID + " has been deleted.");

	}

}
