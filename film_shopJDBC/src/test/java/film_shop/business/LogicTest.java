package film_shop.business;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import film_shop.persistance.CustomerManager;

class LogicTest {

	CustomerManager cM = new CustomerManager();
	Logic logic = new Logic();

	@Test
	void testViewAccounts() {
		fail("Not yet implemented");
//		JDBCDriver.connect();
//
//		assertEquals(
//				" 1 | Arnold Schwartz | gettothechopper@skynet.com | 15 Twins Lane | California | CA4 8FL | 72 | 1\n"
//						+ " 2 | Ricolas Cage | ricolasc1@bunnybox.com | 32 Wicker Street | Las Vegas | LV6 2IX | 56 | 0\n"
//						+ " 3 | Katie Winslot | queenoftheworld@titanic.co.uk | 2 Rose Avenue | London | LN9 8PD | 44 | 0\n"
//						+ " 4 | Adam Rickman | hans.gruber@nakatomi.com | 83 Snapes Road | Nottingham | NT4 4JA | 19 | 1\n"
//						+ " 5 | Jeff Silverblum | prof.fly@jpark.com | 11 Jazz Park | Isla Nublar | IN4 2RE | 67 | 0 \n",
//				logic.viewAccounts());
//
//		JDBCDriver.close();

	}

	@Test
	void testViewProducts() {
		fail("Not yet implemented");
	}

	@Test
	void testViewOrders() {
		fail("Not yet implemented");
	}

	@Test
	void testCreateAccount() {
		fail("Not yet implemented");

	}

	@Test
	void testCreateProduct() {
		fail("Not yet implemented");
	}

	@Test
	void testCreateOrder() {
		fail("Not yet implemented");
	}

	@Test
	void testReturnPrice() {
		fail("Not yet implemented");
	}

	@Test
	void testCheckAccount() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateAccount() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteAccount() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteProduct() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteOrder() {
		fail("Not yet implemented");
	}

}
