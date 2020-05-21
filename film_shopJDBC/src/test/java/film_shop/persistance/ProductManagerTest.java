package film_shop.persistance;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {

	ProductManager pMTest = new ProductManager();
	private Product test = new Product(99, "test", "test", "test", "2000-01-01", "test", 99, 99.99f);

	@Before
	public void setUpCreate() {
		JDBCDriver.connect();
	}

	@Test
	public void testCreate() {

		setUpCreate();
		Product emptyTest = new Product();
		assertEquals("Product " + test.getpID() + " has been created.", pMTest.create(test));
		assertEquals("Empty product entry cannot be added.", pMTest.create(emptyTest));
		resetDatabaseCreate();

	}

	@After
	public void resetDatabaseCreate() {
		pMTest.delete(99);
		JDBCDriver.close();
	}

}
