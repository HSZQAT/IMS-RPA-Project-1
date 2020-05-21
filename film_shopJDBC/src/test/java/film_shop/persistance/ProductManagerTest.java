//package film_shop.persistance;
//
//import org.junit.AfterClass;
//import org.junit.BeforeClass;
//
//public class ProductManagerTest {
//
//	ProductManager pMTest = new ProductManager();
//	Product test = new Product(99, "test", "test", "test", "2000-01-01", "test", 99, 99.99f);
//	Product getOutTest = new Product(1, "Get Out", "Jordan Peele", "Horror", "2017-03-17", "English", 15, 8.99f);
//
//	@BeforeClass
//	public void setUp() {
//		JDBCDriver.connect();
//	}
//
////	@Test
////	public void testCreate() {
////
////		setUp();
////		Product emptyTest = new Product();
////		assertEquals("Product " + test.getpID() + " has been created.", pMTest.create(test));
////		assertEquals("Empty product entry cannot be added.", pMTest.create(emptyTest));
////		System.out.println(pMTest.read().toString());
//////		assertTrue(pMTest.read().contains(test));
////		pMTest.delete(99);
////		close();
////
////	}
//
////	@Test
////	void testRead() {
////		setUp();
////		assertNotNull(pMTest.read());
////		assertTrue(pMTest.read().contains(getOutTest));
////		System.out.println(test.toString());
////		assertTrue(pMTest.read().contains(test)); // checks for CID entry 99 added in create test.
////		close();
////	}
//
//	@AfterClass
//	public void close() {
//		JDBCDriver.close();
//	}
//
//}
