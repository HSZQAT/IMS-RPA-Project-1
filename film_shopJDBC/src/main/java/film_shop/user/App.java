package film_shop.user;

import film_shop.persistance.JDBCDriver;

public class App {

	public static void main(String[] args) {

		JDBCDriver.connect();
		UserMenu.run();
	}
}
