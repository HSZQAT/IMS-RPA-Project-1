package film_shop.persistance;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ProductManagerTest {

	ProductManager pMTest = new ProductManager();
	Product test = new Product(99, "test", "test", "test", "2000-01-01", "test", 99, 99.99f);
	Product getOutTest = new Product(1, "Get Out", "Jordan Peele", "Horror", "2017-03-17", "English", 15, 8.99f);

	@BeforeClass
	public static void setUp() {
		JDBCDriver.connect();
	}

	@Test
	public void testCreate() {
		setUp();
		assertEquals("Product 99 has been created.",
				pMTest.create(new Product(99, "test", "test", "test", "2000-01-01", "test", 99, 99.99f)));
		Product emptyTest = new Product();
		assertEquals("Empty product entry cannot be added.", pMTest.create(emptyTest));
		assertTrue(pMTest.read().toString()
				.contains("1 | Get Out | Jordan Peele | Horror | 2017-03-17 | English | 15 |  £8.99 |  £8.09"));
		assertTrue(pMTest.read().toString()
				.contains("99 | test | test | test | 2000-01-01 | test | 99 |  £99.99 |  £89.99"));
		pMTest.delete(99);
		close();
	}

	@Test
	public void testRead() {
		setUp();
		pMTest.create(test);
		assertNotNull(pMTest.read());
		assertTrue(pMTest.read().toString()
				.contains("1 | Get Out | Jordan Peele | Horror | 2017-03-17 | English | 15 |  £8.99 |  £8.09"));

		assertTrue(pMTest.read().toString()
				.contains("99 | test | test | test | 2000-01-01 | test | 99 |  £99.99 |  £89.99")); // checks for CID
																									// entry 99 added in
																									// create test.
		pMTest.delete(99);
		close();
	}

	@Test
	public void testReadInt() {
		setUp();
		pMTest.create(test);
		assertNotNull(pMTest.read(test.getpID()));
		assertTrue(pMTest.read(1).toString()
				.contains("1 | Get Out | Jordan Peele | Horror | 2017-03-17 | English | 15 |  £8.99 |  £8.09"));
		assertTrue(pMTest.read(99).toString()
				.contains("99 | test | test | test | 2000-01-01 | test | 99 |  £99.99 |  £89.99"));
		pMTest.delete(99);
		close();
	}

	@Test
	public void testDelete() {
		setUp();
		pMTest.create(test);
		assertTrue(pMTest.read().toString()
				.contains("99 | test | test | test | 2000-01-01 | test | 99 |  £99.99 |  £89.99"));
		assertNotNull(pMTest.delete(99));
		assertFalse(pMTest.read().toString()
				.contains("99 | test | test | test | 2000-01-01 | test | 99 |  £99.99 |  £89.99"));
		close();
	}

	@AfterClass
	public static void close() {
		JDBCDriver.close();
	}

}
