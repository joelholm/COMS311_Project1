import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IntervalsTest {

	@Test
	void testIntervals() {
		Intervals itv = new Intervals();
		
		itv.intervalInsert(1, 2);
		itv.intervalInsert(1, 3);
		itv.intervalInsert(3, 8);
		itv.intervalInsert(3, 5);
		itv.intervalInsert(3, 10);
		itv.intervalInsert(9, 11);
		itv.intervalInsert(11, 13);
		
		
		int pom = itv.findPOM();
		
		assertEquals(pom, 3);
		
	}

}
