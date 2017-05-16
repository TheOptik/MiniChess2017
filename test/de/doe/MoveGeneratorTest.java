package de.doe;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

public class MoveGeneratorTest {
	
	@Test
	public void generateAllRookMovesAndCheckSize() throws Exception {
		
		Board board = new Board(TestUtils.getMultilineString("1 W", ".....", ".....", "..R..", ".....", "....."));
		MoveGenerator generator = new MoveGenerator(board);
		List<Move> moves = generator.getAllMoves();
		
		assertEquals(9, moves.size());
		
	}
	
	@Test
	public void generateAndCheckAllRookMoves() throws Exception {
		
		Board board = new Board(TestUtils.getMultilineString("1 W", ".....", ".....", "..R..", ".....", "....."));
		MoveGenerator generator = new MoveGenerator(board);
		List<Move> moves = generator.getAllMoves();
		
		assertEquals(9, moves.size());
		
		assertTrue(moves.contains(new Move(Player.WHITE, 2, 2, 2, 5)));
		assertTrue(moves.contains(new Move(Player.WHITE, 2, 2, 2, 4)));
		assertTrue(moves.contains(new Move(Player.WHITE, 2, 2, 2, 3)));
		assertTrue(moves.contains(new Move(Player.WHITE, 2, 2, 0, 2)));
		assertTrue(moves.contains(new Move(Player.WHITE, 2, 2, 1, 2)));
		assertTrue(moves.contains(new Move(Player.WHITE, 2, 2, 3, 2)));
		assertTrue(moves.contains(new Move(Player.WHITE, 2, 2, 4, 2)));
		assertTrue(moves.contains(new Move(Player.WHITE, 2, 2, 2, 1)));
		assertTrue(moves.contains(new Move(Player.WHITE, 2, 2, 2, 0)));
		
	}
	
}
