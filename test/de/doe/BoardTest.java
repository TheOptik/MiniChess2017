package de.doe;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import de.doe.figures.Figure;

public class BoardTest {
	
	@Test
	public void boardDefaultLayoutTest() throws Exception {
		Board board = new Board();
		
		// Test Black Pieces
		assertEquals(board.getField(0, 0), Figure.BLACK_KING);
		assertEquals(board.getField(1, 0), Figure.BLACK_QUEEN);
		assertEquals(board.getField(2, 0), Figure.BLACK_BISHOP);
		assertEquals(board.getField(3, 0), Figure.BLACK_KNIGHT);
		assertEquals(board.getField(4, 0), Figure.BLACK_ROOK);
		for (int i = 0; i < 5; i++) {
			assertEquals(board.getField(i, 1), Figure.BLACK_PAWN);
		}
		
		// Test WhitePieces
		assertEquals(board.getField(0, 0), Figure.WHITE_KING);
		assertEquals(board.getField(1, 0), Figure.WHITE_QUEEN);
		assertEquals(board.getField(2, 0), Figure.WHITE_BISHOP);
		assertEquals(board.getField(3, 0), Figure.WHITE_KNIGHT);
		assertEquals(board.getField(4, 0), Figure.WHITE_ROOK);
		for (int i = 0; i < 5; i++) {
			assertEquals(board.getField(i, 1), Figure.WHITE_PAWN);
		}
	}
	
	@Ignore
	@Test
	public void readBoardLayoutTest() throws Exception {
		
		
		
		
	}
	
}
