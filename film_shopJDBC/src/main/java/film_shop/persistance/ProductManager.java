package film_shop.persistance;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductManager {

	public void create(Product p) {

		String query = "INSERT INTO products VALUES (" + p.getpID() + ", \"" + p.getName() + "\", \"" + p.getDirector()
				+ "\", \"" + p.getGenre() + "\", \"" + p.getRelease_date() + "\", \"" + p.getLanguage() + "\", \""
				+ p.getAge_rating() + "\"," + p.getPrice() + "," + p.getLoyalty_price() + ")";

		JDBCDriver.execUpdate(query);
	}

	public ArrayList<Product> read() {
		ArrayList<Product> products = new ArrayList<Product>();
		String query = "SELECT * FROM products";
		ResultSet results = JDBCDriver.execQuery(query);

		try {
			while (results.next()) {

				products.add(new Product(results.getInt("PID"), results.getString("name"),
						results.getString("director"), results.getString("genre"), results.getString("release_date"),
						results.getString("language"), results.getInt("age_rating"), results.getFloat("price"),
						results.getFloat("loyalty_price")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return products;
	}

	public Product read(int pID) {

		String query = "SELECT * FROM products WHERE PID = " + pID;

		ResultSet results = JDBCDriver.execQuery(query);

		Product resultProduct = new Product();

		try {
			while (results.next()) {

				resultProduct.setpID(results.getInt("PID"));
				resultProduct.setName(results.getString("name"));
				resultProduct.setDirector(results.getString("director"));
				resultProduct.setGenre(results.getString("genre"));
				resultProduct.setRelease_date(results.getString("release_date"));
				resultProduct.setLanguage(results.getString("language"));
				resultProduct.setAge_rating(results.getInt("age_rating"));
				resultProduct.setPrice(results.getFloat("price"));
				resultProduct.setLoyalty_price(results.getFloat("loyalty_price"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultProduct;
	}

	public void update(int pID, String name, String director) {

		String query = "UPDATE products SET name = \"" + name + "\" , director = \"" + director + "\" WHERE PID = "
				+ pID;
		JDBCDriver.execUpdate(query);
		System.out.println("Product " + pID + "'s name & director has been updated.");

	}

	public void update(int pID, float price) {

		float loyalty_price = (price * 0.9f);
		String query = "UPDATE products SET price = " + price + ", loyalty_price = " + loyalty_price + " WHERE PID = "
				+ pID;
		JDBCDriver.execUpdate(query);
		System.out.println("Product " + pID + "'s price has been updated.");

	}

	public void delete(int pID) {

		String query = "DELETE FROM products WHERE PID = " + pID;
		JDBCDriver.execUpdate(query);
		System.out.println("Product " + pID + " has been deleted.");

	}

}
