package de.doe;

import static org.junit.Assert.*;

import org.junit.Test;

public class MoveTest {
	
	@Test
	public void moveTest() throws Exception {
		for(int i = 0; i <= 5; i++){
			for(int j = 0; j <= 4; j++ ){
				System.out.println(new Move(Player.WHITE, j, i, j, i).toChessString());
			}
		}
	}
	
}
