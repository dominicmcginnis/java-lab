package org.irishhombre.ds.mongo;

import org.junit.*;
import org.irishhombre.ds.mongo.MongoDbConnectionManager;

import com.mongodb.DB;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MongoDBConnectionManagerTest {

	@BeforeClass
	public static void setup() {
	
	}

	@AfterClass
	public static void tearDown() {

	}

	@Test @Ignore
	public void testConnection() throws Exception {
		List<String> names = MongoDbConnectionManager.getInstance().getMongo().getDatabaseNames();	
		assertNotNull(names);
	}
}
