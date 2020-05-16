package film_shop.persistance;

public class OrderProductManager {

	public void create(int oID, int pID) {

		String query = "INSERT INTO orders_products VALUES ( " + oID + ", " + pID + " )";

		JDBCDriver.execUpdate(query);
		System.out.println("New order_product entry added!");

	}

	public void delete(int pID, int oID) {

		String query = "DELETE FROM orders_products WHERE PID = " + pID;
		JDBCDriver.execUpdate(query);
		System.out.println("Product " + pID + " has been deleted from order " + oID + ".");

	}

	public void delete(int oID) {

		String query = "DELETE FROM orders_products WHERE OID = " + oID;
		JDBCDriver.execUpdate(query);
		System.out.println("Order " + oID + " has been deleted.");

	}

}
