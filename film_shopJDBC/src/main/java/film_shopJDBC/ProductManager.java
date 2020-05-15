package film_shopJDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductManager {

	private ArrayList<Product> products = new ArrayList<Product>();

	public void initialise() {

		String query = "SELECT * FROM products";
		ResultSet results = JDBCDriver.execQuery(query);

		try {
			while (results.next()) {

				this.products.add(new Product(results.getInt("PID"), results.getString("name"),
						results.getString("director"), results.getString("genre"), results.getString("release_date"),
						results.getString("language"), results.getInt("age_rating"), results.getFloat("price")));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void create(Product p) {

		this.products.add(p);
		String query = "INSERT INTO products VALUES (" + p.getpID() + ", \"" + p.getName() + "\", \"" + p.getDirector()
				+ "\", \"" + p.getGenre() + "\", \"" + p.getRelease_date() + "\", \"" + p.getLanguage() + "\", \""
				+ p.getAge_rating() + "\"," + p.getPrice() + ")";

		JDBCDriver.execUpdate(query);
		System.out.println("New product entry added!");
	}

	public ArrayList<Product> read() {
		return products;
	}

	public Product read(int pID) {

		for (Product p : products) {

			if (p.getpID() == pID) {

				return p;
			}
		}
		System.out.println("Product ID doesn't exist.");
		return null;
	}

	public void update(int pID, String name, String director) {

		for (Product p : products) {
			if (p.getpID() == pID) {

				p.setName(name);
				p.setDirector(director);

			}
		}

		String query = "UPDATE products SET name = \"" + name + "\" , director = \"" + director + "\" WHERE PID = "
				+ pID;
		JDBCDriver.execUpdate(query);
		System.out.println("Product " + pID + "'s name & director has been updated.");

	}

	public void update(int pID, float price) {

		for (Product p : products) {
			if (p.getpID() == pID) {

				p.setPrice(price);

			}
		}

		String query = "UPDATE products SET price = " + price + " WHERE PID = " + pID;
		JDBCDriver.execUpdate(query);
		System.out.println("Product " + pID + "'s price has been updated.");

	}

	public void delete(int pID) {

		for (Product p : products) {
			if (p.getpID() == pID) {

				this.products.remove(p);

			}
		}

		String query = "DELETE FROM products WHERE PID = " + pID;
		JDBCDriver.execUpdate(query);
		System.out.println("Product " + pID + " has been deleted.");

	}

}
