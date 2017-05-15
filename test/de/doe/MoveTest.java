package de.doe;

import org.junit.Test;

public class MoveTest {
	
	@Test
	public void testName() throws Exception {
		
		Move move = new Move("a1-b2", Player.BLACK);
		System.out.println(move);
		
	}
	
}
