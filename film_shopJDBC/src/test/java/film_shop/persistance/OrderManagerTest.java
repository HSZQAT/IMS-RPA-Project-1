package film_shop.persistance;

class OrderManagerTest {

	OrderManager oMTest = new OrderManager();
	Order firstOrderTest = new Order(1, 1, 12.99f);

//	@Before
//	public static void setUp() {
//		JDBCDriver.connect();
//	}

//	@Test
//	void testCreate() {
//		JDBCDriver.connect();
//
//		Order test = new Order(99, 99, 99.99f);
//		oMTest.create(test);
//		assertEquals("New order entry 99 added!", oMTest.create(test));
//		System.out.println(oMTest.read(test.getoID()).toString());
//
//		JDBCDriver.close();
//	}

//	@Test
//	void testRead() {
//		setUp();
//
//		assertNotNull(oMTest.read());
//		assertEquals(firstOrderTest.toString(), oMTest.read().get(0).toString());
//
//		close();
//	}

//	@Test
//	void testReadInt() {
//		setUp();
//
//		assertNotNull(oMTest.read(1));
//		assertEquals(firstOrderTest.toString(), oMTest.read(1).toString());
//		oMTest.create(test);
//		assertEquals(test.toString(), oMTest.read(99).toString());
//
//		close();
//	}

//	@Test
//	void testReadMy() {
//		fail("Not yet implemented");
//	}

//	@Test
//	void testDelete() {
//		setUp();
//
//		assertEquals("Order 99 has been deleted.", oMTest.delete(99));
//
//		close();
//	}

//	@After
//	public static void close() {
//		JDBCDriver.close();
//	}

}
