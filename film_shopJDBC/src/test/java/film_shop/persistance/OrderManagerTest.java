package film_shop.persistance;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class OrderManagerTest {

	OrderManager oMTest = new OrderManager();
	CustomerManager cMTest = new CustomerManager();
	Customer cTest = new Customer(99, "test", "test", "test", "test", "test", "test", 99, false);
	Order firstOrderTest = new Order(1, cTest.getcID(), 12.99f);
	Order test = new Order(99, 99, 99.99f);

	@BeforeClass
	public static void setUp() {
		JDBCDriver.connect();
	}

	@Test
	public void testCreate() {
		setUp();
		cMTest.create(cTest);
		assertEquals("New order entry 99 added!", oMTest.create(new Order(99, cTest.getcID(), 99.99f)));
		Order emptyTest = new Order();
		assertEquals("Empty order entry cannot be added.", oMTest.create(emptyTest));
		assertTrue(oMTest.read().toString().contains("1 | 1 |  £12.99"));
		assertTrue(oMTest.read().toString().contains("99 | 99 |  £99.99"));
		oMTest.delete(99);
		cMTest.delete(99);
		close();
	}

	@Test
	public void testRead() {
		setUp();
		cMTest.create(cTest);
		oMTest.create(test);
		assertNotNull(oMTest.read());
		assertTrue(oMTest.read().toString().contains("1 | 1 |  £12.99"));
		assertTrue(oMTest.read().toString().contains("99 | 99 |  £99.99")); // checks for OID
																			// entry 99 added in
																			// create test.
		oMTest.delete(99);
		cMTest.delete(99);
		close();
	}

	@Test
	public void testReadInt() {
		setUp();
		cMTest.create(cTest);
		oMTest.create(test);
		assertNotNull(oMTest.read(test.getoID()));
		assertTrue(oMTest.read(1).toString().contains("1 | 1 |  £12.99"));
		assertTrue(oMTest.read(99).toString().contains("99 | 99 |  £99.99"));
		oMTest.delete(99);
		cMTest.delete(99);
		close();
	}

	@Test
	public void testDelete() {
		setUp();
		cMTest.create(cTest);
		oMTest.create(test);
		assertTrue(oMTest.read().toString().contains("99 | 99 |  £99.99"));
		assertNotNull(oMTest.delete(99));
		assertFalse(oMTest.read().toString().contains("99 | 99 |  £99.99"));
		cMTest.delete(99);
		close();
	}

	@AfterClass
	public static void close() {
		JDBCDriver.close();
	}

}
