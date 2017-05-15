package de.doe;

import org.junit.Test;

import de.doe.figures.Figure;

public class BoardTest {
	
	@Test
	public void boardDefaultLayoutTest() throws Exception {
		Board board = new Board();
		
		// Test board parameter
		assertEquals(board.activePlayer, Player.WHITE);
		assertEquals(board.turn, 1);
		
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
		assertEquals(board.getField(4, 5).figure, Figure.WHITE_KING);
		assertEquals(board.getField(3, 5).figure, Figure.WHITE_QUEEN);
		assertEquals(board.getField(2, 5).figure, Figure.WHITE_BISHOP);
		assertEquals(board.getField(1, 5).figure, Figure.WHITE_KNIGHT);
		assertEquals(board.getField(0, 5).figure, Figure.WHITE_ROOK);
		
		// Test null Pieces
		for (int x = 0; x < 5; x++) {
			for (int y = 2; y < 4; y++) {
				assertEquals(board.getField(x, y).figure, null);
			}
		}
		
	}
	
	@Test
	public void readBoardLayoutTest() throws Exception {
		
		Board board = new Board(getMultilineString("20 B", "ppKP.", "QNnRp", ".....", ".....", ".....", "....."));
		
		// Test board parameter
		assertEquals(board.turn, 20);
		assertEquals(board.activePlayer, Player.BLACK);
		
		// Test Black Pieces
		assertEquals(board.getField(0, 0).figure, Figure.BLACK_PAWN);
		assertEquals(board.getField(1, 0).figure, Figure.BLACK_PAWN);
		assertEquals(board.getField(2, 1).figure, Figure.BLACK_KNIGHT);
		
		// Test White Pieces
		assertEquals(board.getField(2, 0).figure, Figure.WHITE_KING);
		assertEquals(board.getField(3, 0).figure, Figure.WHITE_PAWN);
		assertEquals(board.getField(0, 1).figure, Figure.WHITE_QUEEN);
		assertEquals(board.getField(1, 1).figure, Figure.WHITE_KNIGHT);
		assertEquals(board.getField(3, 1).figure, Figure.WHITE_ROOK);
		
		// Test null Pieces
		
		assertEquals(board.getField(4, 0).figure, null);
		for (int x = 0; x < 5; x++) {
			for (int y = 2; y < 6; y++) {
				assertEquals(board.getField(x, y).figure, null);
			}
		}
	}
	
	private String getMultilineString(String... strings) {
		StringBuilder resultBuilder = new StringBuilder();
		for (String s : strings) {
			resultBuilder.append(s).append(System.lineSeparator());
		}
		return resultBuilder.toString();
	}
	
	/**
	 * this method is to turn around the arguments for the JUnit-Assertion
	 * because i consistently do it wrong (i like it better this way anyways).
	 * 
	 * @param actual
	 * @param expected
	 */
	private void assertEquals(Object actual, Object expected) {
		org.junit.Assert.assertEquals(expected, actual);
	}
	
}
