package film_shop.persistance;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderManager {

	public String create(Order o) {

		if (o.getoID() == 0) {
			return "Empty order entry cannot be added.";
		} else {

			String query = "INSERT INTO orders VALUES ( " + o.getoID() + ", " + o.getcID() + ", " + o.getTotal() + " )";

			JDBCDriver.execUpdate(query);
			return "New order entry " + o.getoID() + " added!";
		}
	}

	public ArrayList<Order> read() {

		ArrayList<Order> orders = new ArrayList<Order>();
		String query = "SELECT * FROM orders";
		ResultSet results = JDBCDriver.execQuery(query);

		try {
			while (results.next()) {

				orders.add(new Order(results.getInt("OID"), results.getInt("CID"), results.getFloat("total")));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orders;
	}

	public Order read(int oID) {

		String query = "SELECT * FROM orders WHERE OID = " + oID;

		ResultSet results = JDBCDriver.execQuery(query);

		Order resultOrder = new Order();

		try {
			while (results.next()) {

				resultOrder.setoID(results.getInt("OID"));
				resultOrder.setcID(results.getInt("CID"));
				resultOrder.setTotal(results.getFloat("total"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultOrder;
	}

	public ArrayList<Order> readMy(int cID) {

		ArrayList<Order> orders = new ArrayList<Order>();
		String query = "SELECT * FROM orders WHERE CID = " + cID;
		ResultSet results = JDBCDriver.execQuery(query);

		try {
			while (results.next()) {

				orders.add(new Order(results.getInt("OID"), results.getInt("CID"), results.getFloat("total")));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orders;
	}

	public void update(int oID, float total) {

		String query = "UPDATE orders SET total = " + total + " WHERE OID = " + oID;
		JDBCDriver.execUpdate(query);
		System.out.println("Order " + oID + "'s total has been updated.");

	}

	public String delete(int oID) {

		String query = "DELETE FROM orders WHERE OID = " + oID;
		JDBCDriver.execUpdate(query);
		return "Order " + oID + " has been deleted.";

	}

}
