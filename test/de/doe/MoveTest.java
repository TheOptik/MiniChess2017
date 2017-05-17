package de.doe;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MoveTest {
	
	@Test
	public void moveTest() throws Exception {
		for (int i = 0; i <= 5; i++) {
			for (int j = 0; j <= 4; j++) {
				Move move = new Move(Player.WHITE, j, i, j, i);
				assertEquals(move, new Move(move.toChessString(), Player.WHITE));
				
			}
		}
	}
	
}
