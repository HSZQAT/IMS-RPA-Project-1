package film_shop.persistance;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

class CustomerManagerTest {

	CustomerManager cMTest = new CustomerManager();
	Customer test = new Customer(99, "test", "test", "test", "test", "test", "test", 99, false);
	Customer arnieTest = new Customer(1, "Arnold", "Schwartz", "gettothechopper@skynet.com", "15 Twins Lane",
			"California", "CA4 8FL", 72, true); // same as CID entry 1

	@BeforeClass
	public static void setUp() {
		JDBCDriver.connect();
	}

	@Test
	void testCreate() {
		setUp();
		assertEquals("Customer 99 has been created.", cMTest.create(test));
		Customer emptyTest = new Customer();
		assertEquals("Empty customer entry cannot be added.", cMTest.create(emptyTest));
		assertTrue(cMTest.read().contains(test));
		cMTest.delete(99);
		close();
	}

	@Test
	void testRead() {
		setUp();
		cMTest.create(test);
		assertNotNull(cMTest.read());
		assertTrue(cMTest.read().contains(arnieTest));
//		System.out.println(test.toString());
//		System.out.println(cMTest.read(99).toString());
		assertTrue(cMTest.read().contains(test)); // checks for CID entry 99 added in create test.
		cMTest.delete(99);
		close();
	}

	@Test
	void testReadInt() {
		setUp();
		cMTest.create(test);
		assertNotNull(cMTest.read(99));
		assertTrue(cMTest.read().contains(arnieTest));
		assertEquals(test, cMTest.read(99));
		cMTest.delete(99);
		close();
	}

	@Test
	void testDelete() {
		setUp();
		cMTest.create(test);
//		System.out.println(cMTest.read(99).toString());
		assertTrue(cMTest.read().contains(test));
		assertNotNull(cMTest.delete(99));
		assertFalse(cMTest.read().contains(test));
		close();
	}

	@AfterClass
	public static void close() {
		JDBCDriver.close();
	}

}
