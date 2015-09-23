package tests.xzha;
import org.junit.Before;
import org.junit.Test;
import tests.xzha.implementation.ITableImpl;


import static org.junit.Assert.assertEquals;

/**
 * Unit test for simple RiskMatchTest.
 */
public class RiskMatchTestTest
{
	private ITableImpl table;

	@Before
	public void init() {
		table = new ITableImpl();
	}

	@Test
	public void genTest() {
		table.set("A1", 2);
		table.set("B1000000000", 3);
		assertEquals(table.get("A1"), 2L);
		assertEquals(table.get("B1"), 0L);
		assertEquals(table.sum("C1", "C1"), 0L);
		assertEquals(table.mult("C1", "C1"), 1L); //see https://en.wikipedia.org/wiki/Empty_product
		assertEquals(table.sum("A1", "A1"), 2L);
		assertEquals(table.sum("A1", "B3"), 2L);
		assertEquals(table.sum("A1", "B1000000000"), 5L);
		assertEquals(table.mult("B1000000000", "A1"), 6L);
		assertEquals(table.mult ("B100000000", "B1000000000"), 3L);
		table.set("B2", 5);
		assertEquals(table.sum("A1", "B1000000000"), 10L);
	}
}
