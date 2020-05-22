package film_shop.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import film_shop.persistance.CustomerManager;
import film_shop.persistance.JDBCDriver;

class LogicTest {

	CustomerManager cM = new CustomerManager();
	Logic logic = new Logic();

	@BeforeClass
	public static void setUp() {
		JDBCDriver.connect();
	}

	@Test
	void testViewAccounts() {
		setUp();
//		assertEquals(
//				" 1 | Arnold Schwartz | gettothechopper@skynet.com | 15 Twins Lane | California | CA4 8FL | 72 | 1\n"
//						+ " 2 | Ricolas Cage | ricolasc1@bunnybox.com | 32 Wicker Street | Las Vegas | LV6 2IX | 56 | 0\n"
//						+ " 3 | Katie Winslot | queenoftheworld@titanic.co.uk | 2 Rose Avenue | London | LN9 8PD | 44 | 0\n"
//						+ " 4 | Adam Rickman | hans.gruber@nakatomi.com | 83 Snapes Road | Nottingham | NT4 4JA | 19 | 1\n"
//						+ " 5 | Jeff Silverblum | prof.fly@jpark.com | 11 Jazz Park | Isla Nublar | IN4 2RE | 67 | 0 \n",
//				logic.viewAccounts()); // Tests for customers up to 5

		assertTrue(logic.viewAccounts().contains(
				"1 | Arnold Schwartz | gettothechopper@skynet.com | 15 Twins Lane | California | CA4 8FL | 72 | 1"));
		assertTrue(logic.viewAccounts().contains(
				"2 | Ricolas Cage | ricolasc1@bunnybox.com | 32 Wicker Street | Las Vegas | LV6 2IX | 56 | 0"));

		close();
	}

	@Test
	void testViewProducts() {
		setUp();
//		assertEquals(" 1 | Get Out | Jordan Peele | Horror | 2017-03-17 | English | 15 |  £8.99 |  £8.09\n"
//				+ " 2 | Midsommar | Ari Aster | Horror | 2019-07-05 | English | 18 |  £10.99 |  £9.89\n"
//				+ " 3 | Parasite | Bong Joon-Ho | Thriller | 2020-02-07 | Korean | 15 |  £12.99 |  £11.69\n"
//				+ " 4 | Titanic | James Cameron | Romance | 1998-01-23 | English | 12 |  £5.99 |  £5.39\n"
//				+ " 5 | Con Air | Jerry Bruckheimer | Action | 1997-06-06 | English | 15 |  £5.99 |  £5.39\n"
//				+ " 6 | Ladybird | Greta Gerwig | Comedy/Drama | 2018-02-16 | English | 15 |  £9.99 |  £8.99\n"
//				+ " 7 | The Room | Tommy Wiseau | Romantic Drama | 2003-06-27 | English | 15 |  £99.99 |  £89.99 \n",
//				logic.viewProducts()); // Tests for products up to 7
		assertTrue(logic.viewProducts()
				.contains("1 | Get Out | Jordan Peele | Horror | 2017-03-17 | English | 15 |  £8.99 |  £8.09"));
		assertTrue(logic.viewProducts()
				.contains("2 | Midsommar | Ari Aster | Horror | 2019-07-05 | English | 18 |  £10.99 |  £9.89"));
		close();
	}

	@Test
	void testViewOrders() {
		setUp();
//		assertEquals(" 1 | 1 |  £12.99\n" + " 2 | 2 |  £5.99\n" + " 3 | 4 |  £8.99\n" + " 4 | 1 |  £5.39\n"
//				+ " 5 | 5 |  £99.99 \n", logic.viewOrders()); // Tests for orders up to 5
		assertTrue(logic.viewOrders().contains("1 | 1 |  £12.99"));
		assertTrue(logic.viewOrders().contains("2 | 2 |  £5.99"));
		close();
	}

	@Test
	void testCreateAccount() {
		setUp();
		assertNotNull(logic.createAccount());
//		assertEquals("New customer entry added!\n" + cM.read().toString() + "\n", logic.createAccount());
		close();
	}

	@Test
	void testCreateProduct() {
		setUp();
		assertNotNull(logic.createProduct());
		close();
	}

	@Test
	void testCreateOrder() {
		setUp();
		assertNotNull(logic.createOrder());
		close();
	}

	@Test
	void testReturnPrice() {
		setUp();
		assertEquals(8.09, logic.returnPrice(1, 1), 0.5); // loyalty price
		assertEquals(10.99, logic.returnPrice(2, 2), 0.5); // standard price
		close();
	}

	@Test
	void testCalculateTotal() {
		setUp();
		assertEquals(18.38, logic.calculateTotal(1), 0.5);
		close();
	}

	@Test
	void testCheckAccount() {
		setUp();
		assertEquals("Total order(s) cost: £18.38\n", logic.checkAccount());
		close();
	}

	@Test
	void testUpdateAccount() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteAccount() {
		setUp();
		assertEquals("Customer account #6 deleted.", logic.deleteAccount());// Select account 6 on scanner. (one created
																			// for test)
		close();
	}

	@Test
	void testDeleteProduct() {
		setUp();
		assertEquals("Product #8 deleted.", logic.deleteProduct());// Select account 8 on scanner. (one created for
																	// test)
		close();
	}

	@Test
	void testDeleteOrder() {
		setUp();
		assertEquals("Order #6 deleted.", logic.deleteOrder());// Select account 6 on scanner. (one created for test)
		close();
	}

	@AfterClass
	public static void close() {
		JDBCDriver.close();
	}
}
