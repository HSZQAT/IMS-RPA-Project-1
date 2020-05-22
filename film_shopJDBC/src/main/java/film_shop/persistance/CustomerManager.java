package film_shop.persistance;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerManager {

	public String create(Customer c) {

		if (c.getcID() == 0) {
			return "Empty customer entry cannot be added.";
		} else {

			String query = "INSERT INTO customer VALUES (" + c.getcID() + ", \"" + c.getFirst_name() + "\", \""
					+ c.getLast_name() + "\", \"" + c.getEmail() + "\", \"" + c.getAddress() + "\", \"" + c.getCity()
					+ "\", \"" + c.getPostcode() + "\"," + c.getAge() + " , " + c.getLoyalty() + ")";

			JDBCDriver.execUpdate(query);
			return "Customer " + c.getcID() + " has been created.";
		}
	}

	public ArrayList<Customer> read() {

		ArrayList<Customer> customers = new ArrayList<Customer>();
		String query = "SELECT * FROM customer";
		ResultSet results = JDBCDriver.execQuery(query);

		try {
			while (results.next()) {

				customers.add(new Customer(results.getInt("CID"), results.getString("first_name"),
						results.getString("last_name"), results.getString("email"), results.getString("address"),
						results.getString("city"), results.getString("postcode"), results.getInt("age"),
						results.getBoolean("loyalty")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return customers;
	}

	public Customer read(int cID) {

		String query = "SELECT * FROM customer WHERE CID = " + cID;

		ResultSet results = JDBCDriver.execQuery(query);

		Customer resultCustomer = new Customer();

		try {
			while (results.next()) {

				resultCustomer.setcID(results.getInt("CID"));
				resultCustomer.setFirst_name(results.getString("first_name"));
				resultCustomer.setLast_name(results.getString("last_name"));
				resultCustomer.setEmail(results.getString("email"));
				resultCustomer.setAddress(results.getString("address"));
				resultCustomer.setCity(results.getString("city"));
				resultCustomer.setPostcode(results.getString("postcode"));
				resultCustomer.setAge(results.getInt("age"));
				resultCustomer.setLoyalty(results.getBoolean("loyalty"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultCustomer;
	}

	public void update(int cID, String first_name, String last_name) {

		String query = "UPDATE customer SET first_name = \"" + first_name + "\", last_name = \"" + last_name
				+ "\" WHERE CID = " + cID;
		JDBCDriver.execUpdate(query);
		System.out.println("Customer " + cID + "'s name has been updated.");

	}

	public void update(int cID, String email) {

		String query = "UPDATE customer SET email = \"" + email + "\" WHERE CID = " + cID;
		JDBCDriver.execUpdate(query);
		System.out.println("Customer " + cID + "'s email has been updated.");

	}

	public void update(int cID, String address, String city, String postcode) {

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

		String query = "UPDATE customer SET loyalty = " + l + " WHERE CID = " + cID;
		JDBCDriver.execUpdate(query);
		System.out.println("Customer " + cID + "'s loyalty has been updated.");

	}

	public String delete(int cID) {

		String query = "DELETE FROM customer WHERE CID = " + cID;
		JDBCDriver.execUpdate(query);
		return "Customer " + cID + " has been deleted.";

	}

}
