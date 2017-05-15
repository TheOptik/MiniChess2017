package de.doe;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

import de.doe.figures.Figure;

public class BoardTest {
	
	@Test
	public void boardDefaultLayoutTest() throws Exception {
		Board board = new Board();
		
		// Test Black Pieces
		assertEquals(board.getField(0, 0).figure, Figure.BLACK_KING);
		assertEquals(board.getField(1, 0).figure, Figure.BLACK_QUEEN);
		assertEquals(board.getField(2, 0).figure, Figure.BLACK_BISHOP);
		assertEquals(board.getField(3, 0).figure, Figure.BLACK_KNIGHT);
		assertEquals(board.getField(4, 0).figure, Figure.BLACK_ROOK);
		for (int i = 0; i < 5; i++) {
			assertEquals(board.getField(i, 1).figure, Figure.BLACK_PAWN);
		}
		
		// Test WhitePieces
		for (int i = 0; i < 5; i++) {
			assertEquals(board.getField(i, 4).figure, Figure.WHITE_PAWN);
		}
		assertEquals(board.getField(0, 5).figure, Figure.WHITE_KING);
		assertEquals(board.getField(1, 5).figure, Figure.WHITE_QUEEN);
		assertEquals(board.getField(2, 5).figure, Figure.WHITE_BISHOP);
		assertEquals(board.getField(3, 5).figure, Figure.WHITE_KNIGHT);
		assertEquals(board.getField(4, 5).figure, Figure.WHITE_ROOK);
		
		// Test all null pieces
		for (int x = 0; x < 5; x++) {
			for (int y = 2; y < 4; y++) {
				assertEquals(board.getField(x, y).figure, null);
			}
		}
		
	}
	
	@Ignore
	@Test
	public void readBoardLayoutTest() throws Exception {
		
	}
	
}
