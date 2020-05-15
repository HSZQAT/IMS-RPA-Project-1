package film_shopJDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderManager {

	private ArrayList<Order> orders = new ArrayList<Order>();

	public void initialise() {

		String query = "SELECT * FROM orders";
		ResultSet results = JDBCDriver.execQuery(query);

		try {
			while (results.next()) {

				this.orders.add(new Order(results.getInt("OID"), results.getInt("CID"), results.getFloat("total")));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void create(Order o) {

		this.orders.add(o);
		String query = "INSERT INTO orders VALUES ( " + o.getoID() + ", " + o.getcID() + ", " + o.getTotal() + " )";

		JDBCDriver.execUpdate(query);
		System.out.println("New order entry added!");
	}

	public ArrayList<Order> read() {
		return orders;
	}

	public Order read(int oID) {

		for (Order o : orders) {

			if (o.getoID() == oID) {

				return o;
			}
		}
		System.out.println("Order ID doesn't exist.");
		return null;
	}

	public void delete(int oID) {

		for (Order o : orders) {
			if (o.getoID() == oID) {

				this.orders.remove(o);

			}
		}

		String query = "DELETE FROM orders WHERE OID = " + oID;
		JDBCDriver.execUpdate(query);
		System.out.println("Order " + oID + " has been deleted.");

	}

}
