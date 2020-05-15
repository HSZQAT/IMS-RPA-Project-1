package film_shopJDBC;

public class App {

	public static void main(String[] args) {

		JDBCDriver.connect();
		CustomerManager cM = new CustomerManager();
		ProductManager pM = new ProductManager();
		OrderManager oM = new OrderManager();

//		cM.create(new Customer(6, "first_name", "last_name", "email", "address", "city", "postcode", 0, true));
//		pM.create(new Product(7, "name", "director", "genre", "2000-01-01", "language", 18, 99.99f));
//		oM.create(new Order(5, 5, 12.99f));

//		cM.delete(6);
//		pM.delete(7);
//		oM.delete(5);

//		cM.update(5, "Jeff", "Silverblum");
//		pM.update(5, 5.99f);

		System.out.println(cM.read().toString().replaceAll("[\\[\\]]", " ").replaceAll(",", "\n") + "\n");
		System.out.println(pM.read().toString().replaceAll("[\\[\\]]", " ").replaceAll(",", "\n") + "\n");
		System.out.println(oM.read().toString().replaceAll("[\\[\\]]", " ").replaceAll(",", "\n") + "\n");
//		System.out.println(oM.read(5).toString());

		JDBCDriver.close();

	}

}
