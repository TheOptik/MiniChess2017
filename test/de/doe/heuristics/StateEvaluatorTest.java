package de.doe.heuristics;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.doe.Board;
import de.doe.Player;
import de.doe.TestUtils;
import heuristics.BoardEvaluator;

public class StateEvaluatorTest {
	
	@Test
	public void evaluationPawnVsKing() throws Exception {
		
		Board board = new Board(
				TestUtils.getMultilineString("1 W", ".K...", ".....", ".....", ".....", ".....", ".p..."));
		Board board1 = new Board(
				TestUtils.getMultilineString("1 W", ".k...", ".....", ".....", ".....", ".....", ".P..."));
		Board board2 = new Board(
				TestUtils.getMultilineString("1 B", ".K...", ".....", ".....", ".....", ".....", ".p..."));
		Board board3 = new Board(
				TestUtils.getMultilineString("1 B", ".k...", ".....", ".....", ".....", ".....", ".P..."));
		BoardEvaluator evalW = new BoardEvaluator(Player.WHITE);
		BoardEvaluator evalB = new BoardEvaluator(Player.BLACK);
		
		assertEquals(99, evalW.evaluate(board));
		assertEquals(-99, evalW.evaluate(board1));
		assertEquals(-99, evalB.evaluate(board2));
		assertEquals(99, evalB.evaluate(board3));
	}
	
	@Test
	public void evaluationPawnVsQueen() throws Exception {
		
		Board board = new Board(
				TestUtils.getMultilineString("1 W", ".Q...", ".....", ".....", ".....", ".....", ".p..."));
		Board board1 = new Board(
				TestUtils.getMultilineString("1 W", ".q...", ".....", ".....", ".....", ".....", ".P..."));
		Board board2 = new Board(
				TestUtils.getMultilineString("1 B", ".Q...", ".....", ".....", ".....", ".....", ".p..."));
		Board board3 = new Board(
				TestUtils.getMultilineString("1 B", ".q...", ".....", ".....", ".....", ".....", ".P..."));
		BoardEvaluator evalW = new BoardEvaluator(Player.WHITE);
		BoardEvaluator evalB = new BoardEvaluator(Player.BLACK);
		
		assertEquals(8, evalW.evaluate(board));
		assertEquals(-8, evalW.evaluate(board1));
		assertEquals(-8, evalB.evaluate(board2));
		assertEquals(8, evalB.evaluate(board3));
	}
	
	@Test
	public void evaluationPawnVSBishop() throws Exception {
		
		Board board = new Board(
				TestUtils.getMultilineString("1 W", ".B...", ".....", ".....", ".....", ".....", ".p..."));
		Board board1 = new Board(
				TestUtils.getMultilineString("1 W", ".b...", ".....", ".....", ".....", ".....", ".P..."));
		Board board2 = new Board(
				TestUtils.getMultilineString("1 B", ".B...", ".....", ".....", ".....", ".....", ".p..."));
		Board board3 = new Board(
				TestUtils.getMultilineString("1 B", ".b...", ".....", ".....", ".....", ".....", ".P..."));
		BoardEvaluator evalW = new BoardEvaluator(Player.WHITE);
		BoardEvaluator evalB = new BoardEvaluator(Player.BLACK);
		
		assertEquals(2, evalW.evaluate(board));
		assertEquals(-2, evalW.evaluate(board1));
		assertEquals(-2, evalB.evaluate(board2));
		assertEquals(2, evalB.evaluate(board3));
	}
	
	@Test
	public void evaluationPawnVsKnight() throws Exception {
		
		Board board = new Board(
				TestUtils.getMultilineString("1 W", ".N...", ".....", ".....", ".....", ".....", ".p..."));
		Board board1 = new Board(
				TestUtils.getMultilineString("1 W", ".n...", ".....", ".....", ".....", ".....", ".P..."));
		Board board2 = new Board(
				TestUtils.getMultilineString("1 B", ".N...", ".....", ".....", ".....", ".....", ".p..."));
		Board board3 = new Board(
				TestUtils.getMultilineString("1 B", ".n...", ".....", ".....", ".....", ".....", ".P..."));
		BoardEvaluator evalW = new BoardEvaluator(Player.WHITE);
		BoardEvaluator evalB = new BoardEvaluator(Player.BLACK);
		
		assertEquals(2, evalW.evaluate(board));
		assertEquals(-2, evalW.evaluate(board1));
		assertEquals(-2, evalB.evaluate(board2));
		assertEquals(2, evalB.evaluate(board3));
	}
	
	@Test
	public void evaluationPawnVsRook() throws Exception {
		
		Board board = new Board(
				TestUtils.getMultilineString("1 W", ".R...", ".....", ".....", ".....", ".....", ".p..."));
		Board board1 = new Board(
				TestUtils.getMultilineString("1 W", ".r...", ".....", ".....", ".....", ".....", ".P..."));
		Board board2 = new Board(
				TestUtils.getMultilineString("1 B", ".R...", ".....", ".....", ".....", ".....", ".p..."));
		Board board3 = new Board(
				TestUtils.getMultilineString("1 B", ".r...", ".....", ".....", ".....", ".....", ".P..."));
		BoardEvaluator evalW = new BoardEvaluator(Player.WHITE);
		BoardEvaluator evalB = new BoardEvaluator(Player.BLACK);
		
		assertEquals(4, evalW.evaluate(board));
		assertEquals(-4, evalW.evaluate(board1));
		assertEquals(-4, evalB.evaluate(board2));
		assertEquals(4, evalB.evaluate(board3));
	}
	
	@Test
	public void evaluationPawnVsPawn() throws Exception {
		
		Board board = new Board(
				TestUtils.getMultilineString("1 W", ".P...", ".....", ".....", ".....", ".....", ".p..."));
		Board board1 = new Board(
				TestUtils.getMultilineString("1 W", ".p...", ".....", ".....", ".....", ".....", ".P..."));
		Board board2 = new Board(
				TestUtils.getMultilineString("1 B", ".P...", ".....", ".....", ".....", ".....", ".p..."));
		Board board3 = new Board(
				TestUtils.getMultilineString("1 B", ".p...", ".....", ".....", ".....", ".....", ".P..."));
		BoardEvaluator evalW = new BoardEvaluator(Player.WHITE);
		BoardEvaluator evalB = new BoardEvaluator(Player.BLACK);
		
		assertEquals(0, evalW.evaluate(board));
		assertEquals(0, evalW.evaluate(board1));
		assertEquals(0, evalB.evaluate(board2));
		assertEquals(0, evalB.evaluate(board3));
	}
	
	@Test
	public void evaluationRookVsKing() throws Exception {
		Board board = new Board(
				TestUtils.getMultilineString("1 W", ".K...", ".....", ".....", ".....", ".....", ".r..."));
		Board board1 = new Board(
				TestUtils.getMultilineString("1 W", ".k...", ".....", ".....", ".....", ".....", ".R..."));
		Board board2 = new Board(
				TestUtils.getMultilineString("1 B", ".K...", ".....", ".....", ".....", ".....", ".r..."));
		Board board3 = new Board(
				TestUtils.getMultilineString("1 B", ".k...", ".....", ".....", ".....", ".....", ".R..."));
		BoardEvaluator evalW = new BoardEvaluator(Player.WHITE);
		BoardEvaluator evalB = new BoardEvaluator(Player.BLACK);
		
		assertEquals(95, evalW.evaluate(board));
		assertEquals(-95, evalW.evaluate(board1));
		assertEquals(-95, evalB.evaluate(board2));
		assertEquals(95, evalB.evaluate(board3));
	}
	
	@Test
	public void evaluationRookVsQueen() throws Exception {
		Board board = new Board(
				TestUtils.getMultilineString("1 W", ".Q...", ".....", ".....", ".....", ".....", ".r..."));
		Board board1 = new Board(
				TestUtils.getMultilineString("1 W", ".q...", ".....", ".....", ".....", ".....", ".R..."));
		Board board2 = new Board(
				TestUtils.getMultilineString("1 B", ".Q...", ".....", ".....", ".....", ".....", ".r..."));
		Board board3 = new Board(
				TestUtils.getMultilineString("1 B", ".q...", ".....", ".....", ".....", ".....", ".R..."));
		BoardEvaluator evalW = new BoardEvaluator(Player.WHITE);
		BoardEvaluator evalB = new BoardEvaluator(Player.BLACK);
		
		assertEquals(4, evalW.evaluate(board));
		assertEquals(-4, evalW.evaluate(board1));
		assertEquals(-4, evalB.evaluate(board2));
		assertEquals(4, evalB.evaluate(board3));
	}
	
	@Test
	public void evaluationRookVsBishop() throws Exception {
		Board board = new Board(
				TestUtils.getMultilineString("1 W", ".B...", ".....", ".....", ".....", ".....", ".r..."));
		Board board1 = new Board(
				TestUtils.getMultilineString("1 W", ".b...", ".....", ".....", ".....", ".....", ".R..."));
		Board board2 = new Board(
				TestUtils.getMultilineString("1 B", ".B...", ".....", ".....", ".....", ".....", ".r..."));
		Board board3 = new Board(
				TestUtils.getMultilineString("1 B", ".b...", ".....", ".....", ".....", ".....", ".R..."));
		BoardEvaluator evalW = new BoardEvaluator(Player.WHITE);
		BoardEvaluator evalB = new BoardEvaluator(Player.BLACK);
		
		assertEquals(-2, evalW.evaluate(board));
		assertEquals(2, evalW.evaluate(board1));
		assertEquals(2, evalB.evaluate(board2));
		assertEquals(-2, evalB.evaluate(board3));
	}
	
	@Test
	public void evaluationRookVsKnight() throws Exception {
		Board board = new Board(
				TestUtils.getMultilineString("1 W", ".N...", ".....", ".....", ".....", ".....", ".r..."));
		Board board1 = new Board(
				TestUtils.getMultilineString("1 W", ".n...", ".....", ".....", ".....", ".....", ".R..."));
		Board board2 = new Board(
				TestUtils.getMultilineString("1 B", ".N...", ".....", ".....", ".....", ".....", ".r..."));
		Board board3 = new Board(
				TestUtils.getMultilineString("1 B", ".n...", ".....", ".....", ".....", ".....", ".R..."));
		BoardEvaluator evalW = new BoardEvaluator(Player.WHITE);
		BoardEvaluator evalB = new BoardEvaluator(Player.BLACK);
		
		assertEquals(-2, evalW.evaluate(board));
		assertEquals(2, evalW.evaluate(board1));
		assertEquals(2, evalB.evaluate(board2));
		assertEquals(-2, evalB.evaluate(board3));
	}
	
	@Test
	public void evaluationRookVsRook() throws Exception {
		Board board = new Board(
				TestUtils.getMultilineString("1 W", ".R...", ".....", ".....", ".....", ".....", ".r..."));
		Board board1 = new Board(
				TestUtils.getMultilineString("1 W", ".r...", ".....", ".....", ".....", ".....", ".R..."));
		Board board2 = new Board(
				TestUtils.getMultilineString("1 B", ".R...", ".....", ".....", ".....", ".....", ".r..."));
		Board board3 = new Board(
				TestUtils.getMultilineString("1 B", ".r...", ".....", ".....", ".....", ".....", ".R..."));
		BoardEvaluator evalW = new BoardEvaluator(Player.WHITE);
		BoardEvaluator evalB = new BoardEvaluator(Player.BLACK);
		
		assertEquals(0, evalW.evaluate(board));
		assertEquals(0, evalW.evaluate(board1));
		assertEquals(0, evalB.evaluate(board2));
		assertEquals(0, evalB.evaluate(board3));
	}
	
	@Test
	public void evaluationKnightVsKing() throws Exception {
		Board board = new Board(
				TestUtils.getMultilineString("1 W", ".K...", ".....", ".....", ".....", ".....", ".n..."));
		Board board1 = new Board(
				TestUtils.getMultilineString("1 W", ".k...", ".....", ".....", ".....", ".....", ".N..."));
		Board board2 = new Board(
				TestUtils.getMultilineString("1 B", ".K...", ".....", ".....", ".....", ".....", ".n..."));
		Board board3 = new Board(
				TestUtils.getMultilineString("1 B", ".k...", ".....", ".....", ".....", ".....", ".N..."));
		BoardEvaluator evalW = new BoardEvaluator(Player.WHITE);
		BoardEvaluator evalB = new BoardEvaluator(Player.BLACK);
		
		assertEquals(97, evalW.evaluate(board));
		assertEquals(-97, evalW.evaluate(board1));
		assertEquals(-97, evalB.evaluate(board2));
		assertEquals(97, evalB.evaluate(board3));
	}
	
	@Test
	public void evaluationKnightVsQueen() throws Exception {
		Board board = new Board(
				TestUtils.getMultilineString("1 W", ".Q...", ".....", ".....", ".....", ".....", ".n..."));
		Board board1 = new Board(
				TestUtils.getMultilineString("1 W", ".q...", ".....", ".....", ".....", ".....", ".N..."));
		Board board2 = new Board(
				TestUtils.getMultilineString("1 B", ".Q...", ".....", ".....", ".....", ".....", ".n..."));
		Board board3 = new Board(
				TestUtils.getMultilineString("1 B", ".q...", ".....", ".....", ".....", ".....", ".N..."));
		BoardEvaluator evalW = new BoardEvaluator(Player.WHITE);
		BoardEvaluator evalB = new BoardEvaluator(Player.BLACK);
		
		assertEquals(6, evalW.evaluate(board));
		assertEquals(-6, evalW.evaluate(board1));
		assertEquals(-6, evalB.evaluate(board2));
		assertEquals(6, evalB.evaluate(board3));
	}
	
	@Test
	public void evaluationKnightVsBishop() throws Exception {
		Board board = new Board(
				TestUtils.getMultilineString("1 W", ".B...", ".....", ".....", ".....", ".....", ".n..."));
		Board board1 = new Board(
				TestUtils.getMultilineString("1 W", ".b...", ".....", ".....", ".....", ".....", ".N..."));
		Board board2 = new Board(
				TestUtils.getMultilineString("1 B", ".B...", ".....", ".....", ".....", ".....", ".n..."));
		Board board3 = new Board(
				TestUtils.getMultilineString("1 B", ".b...", ".....", ".....", ".....", ".....", ".N..."));
		BoardEvaluator evalW = new BoardEvaluator(Player.WHITE);
		BoardEvaluator evalB = new BoardEvaluator(Player.BLACK);
		
		assertEquals(0, evalW.evaluate(board));
		assertEquals(0, evalW.evaluate(board1));
		assertEquals(0, evalB.evaluate(board2));
		assertEquals(0, evalB.evaluate(board3));
	}
	
	@Test
	public void evaluationKnightVsKnight() throws Exception {
		Board board = new Board(
				TestUtils.getMultilineString("1 W", ".N...", ".....", ".....", ".....", ".....", ".n..."));
		Board board1 = new Board(
				TestUtils.getMultilineString("1 W", ".n...", ".....", ".....", ".....", ".....", ".N..."));
		Board board2 = new Board(
				TestUtils.getMultilineString("1 B", ".N...", ".....", ".....", ".....", ".....", ".n..."));
		Board board3 = new Board(
				TestUtils.getMultilineString("1 B", ".n...", ".....", ".....", ".....", ".....", ".N..."));
		BoardEvaluator evalW = new BoardEvaluator(Player.WHITE);
		BoardEvaluator evalB = new BoardEvaluator(Player.BLACK);
		
		assertEquals(0, evalW.evaluate(board));
		assertEquals(0, evalW.evaluate(board1));
		assertEquals(0, evalB.evaluate(board2));
		assertEquals(0, evalB.evaluate(board3));
	}
	
	@Test
	public void evaluationBishopVsKing() throws Exception {
		Board board = new Board(
				TestUtils.getMultilineString("1 W", ".K...", ".....", ".....", ".....", ".....", ".b..."));
		Board board1 = new Board(
				TestUtils.getMultilineString("1 W", ".k...", ".....", ".....", ".....", ".....", ".B..."));
		Board board2 = new Board(
				TestUtils.getMultilineString("1 B", ".K...", ".....", ".....", ".....", ".....", ".b..."));
		Board board3 = new Board(
				TestUtils.getMultilineString("1 B", ".k...", ".....", ".....", ".....", ".....", ".B..."));
		BoardEvaluator evalW = new BoardEvaluator(Player.WHITE);
		BoardEvaluator evalB = new BoardEvaluator(Player.BLACK);
		
		assertEquals(97, evalW.evaluate(board));
		assertEquals(-97, evalW.evaluate(board1));
		assertEquals(-97, evalB.evaluate(board2));
		assertEquals(97, evalB.evaluate(board3));
	}
	
	@Test
	public void evaluationBishopVsQueen() throws Exception {
		Board board = new Board(
				TestUtils.getMultilineString("1 W", ".Q...", ".....", ".....", ".....", ".....", ".b..."));
		Board board1 = new Board(
				TestUtils.getMultilineString("1 W", ".q...", ".....", ".....", ".....", ".....", ".B..."));
		Board board2 = new Board(
				TestUtils.getMultilineString("1 B", ".Q...", ".....", ".....", ".....", ".....", ".b..."));
		Board board3 = new Board(
				TestUtils.getMultilineString("1 B", ".q...", ".....", ".....", ".....", ".....", ".B..."));
		BoardEvaluator evalW = new BoardEvaluator(Player.WHITE);
		BoardEvaluator evalB = new BoardEvaluator(Player.BLACK);
		
		assertEquals(6, evalW.evaluate(board));
		assertEquals(-6, evalW.evaluate(board1));
		assertEquals(-6, evalB.evaluate(board2));
		assertEquals(6, evalB.evaluate(board3));
	}
	
	@Test
	public void evaluationBishopVsBishop() throws Exception {
		Board board = new Board(
				TestUtils.getMultilineString("1 W", ".B...", ".....", ".....", ".....", ".....", ".b..."));
		Board board1 = new Board(
				TestUtils.getMultilineString("1 W", ".b...", ".....", ".....", ".....", ".....", ".B..."));
		Board board2 = new Board(
				TestUtils.getMultilineString("1 B", ".B...", ".....", ".....", ".....", ".....", ".b..."));
		Board board3 = new Board(
				TestUtils.getMultilineString("1 B", ".b...", ".....", ".....", ".....", ".....", ".B..."));
		BoardEvaluator evalW = new BoardEvaluator(Player.WHITE);
		BoardEvaluator evalB = new BoardEvaluator(Player.BLACK);
		
		assertEquals(0, evalW.evaluate(board));
		assertEquals(0, evalW.evaluate(board1));
		assertEquals(0, evalB.evaluate(board2));
		assertEquals(0, evalB.evaluate(board3));
	}
	
	@Test
	public void evaluationQueenVsKing() throws Exception {
		Board board = new Board(
				TestUtils.getMultilineString("1 W", ".K...", ".....", ".....", ".....", ".....", ".q..."));
		Board board1 = new Board(
				TestUtils.getMultilineString("1 W", ".k...", ".....", ".....", ".....", ".....", ".Q..."));
		Board board2 = new Board(
				TestUtils.getMultilineString("1 B", ".K...", ".....", ".....", ".....", ".....", ".q..."));
		Board board3 = new Board(
				TestUtils.getMultilineString("1 B", ".k...", ".....", ".....", ".....", ".....", ".Q..."));
		BoardEvaluator evalW = new BoardEvaluator(Player.WHITE);
		BoardEvaluator evalB = new BoardEvaluator(Player.BLACK);
		
		assertEquals(91, evalW.evaluate(board));
		assertEquals(-91, evalW.evaluate(board1));
		assertEquals(-91, evalB.evaluate(board2));
		assertEquals(91, evalB.evaluate(board3));
	}
	
	@Test
	public void evaluationQueenVsQueen() throws Exception {
		Board board = new Board(
				TestUtils.getMultilineString("1 W", ".Q...", ".....", ".....", ".....", ".....", ".q..."));
		Board board1 = new Board(
				TestUtils.getMultilineString("1 W", ".q...", ".....", ".....", ".....", ".....", ".Q..."));
		Board board2 = new Board(
				TestUtils.getMultilineString("1 B", ".Q...", ".....", ".....", ".....", ".....", ".q..."));
		Board board3 = new Board(
				TestUtils.getMultilineString("1 B", ".q...", ".....", ".....", ".....", ".....", ".Q..."));
		BoardEvaluator evalW = new BoardEvaluator(Player.WHITE);
		BoardEvaluator evalB = new BoardEvaluator(Player.BLACK);
		
		assertEquals(0, evalW.evaluate(board));
		assertEquals(0, evalW.evaluate(board1));
		assertEquals(0, evalB.evaluate(board2));
		assertEquals(0, evalB.evaluate(board3));
	}
	
	@Test
	public void evaluationKingVsKing() throws Exception {
		Board board = new Board(
				TestUtils.getMultilineString("1 W", ".K...", ".....", ".....", ".....", ".....", ".k..."));
		Board board1 = new Board(
				TestUtils.getMultilineString("1 W", ".k...", ".....", ".....", ".....", ".....", ".K..."));
		Board board2 = new Board(
				TestUtils.getMultilineString("1 B", ".K...", ".....", ".....", ".....", ".....", ".k..."));
		Board board3 = new Board(
				TestUtils.getMultilineString("1 B", ".k...", ".....", ".....", ".....", ".....", ".K..."));
		BoardEvaluator evalW = new BoardEvaluator(Player.WHITE);
		BoardEvaluator evalB = new BoardEvaluator(Player.BLACK);
		
		assertEquals(0, evalW.evaluate(board));
		assertEquals(0, evalW.evaluate(board1));
		assertEquals(0, evalB.evaluate(board2));
		assertEquals(0, evalB.evaluate(board3));
	}
	
	@Test
	public void evaluationPawnAddKing() throws Exception {
		Board board = new Board(
				TestUtils.getMultilineString("1 W", ".K...", ".....", ".....", ".....", ".....", ".P..."));
		Board board1 = new Board(
				TestUtils.getMultilineString("1 W", ".k...", ".....", ".....", ".....", ".....", ".p..."));
		
		BoardEvaluator evalW = new BoardEvaluator(Player.WHITE);
		BoardEvaluator evalB = new BoardEvaluator(Player.BLACK);
		assertEquals(101, evalW.evaluate(board));
		assertEquals(-101, evalW.evaluate(board1));
		assertEquals(-101, evalB.evaluate(board));
		assertEquals(101, evalB.evaluate(board1));
	}
	
	@Test
	public void evaluationPawnAddQueen() throws Exception {
		Board board = new Board(
				TestUtils.getMultilineString("1 W", ".Q...", ".....", ".....", ".....", ".....", ".P..."));
		Board board1 = new Board(
				TestUtils.getMultilineString("1 W", ".q...", ".....", ".....", ".....", ".....", ".p..."));
		
		BoardEvaluator evalW = new BoardEvaluator(Player.WHITE);
		BoardEvaluator evalB = new BoardEvaluator(Player.BLACK);
		assertEquals(10, evalW.evaluate(board));
		assertEquals(-10, evalW.evaluate(board1));
		assertEquals(-10, evalB.evaluate(board));
		assertEquals(10, evalB.evaluate(board1));
	}
	
	@Test
	public void evaluationPawnAddBishop() throws Exception {
		
		Board board = new Board(
				TestUtils.getMultilineString("1 W", ".B...", ".....", ".....", ".....", ".....", ".P..."));
		Board board1 = new Board(
				TestUtils.getMultilineString("1 W", ".b...", ".....", ".....", ".....", ".....", ".p..."));
		
		BoardEvaluator evalW = new BoardEvaluator(Player.WHITE);
		BoardEvaluator evalB = new BoardEvaluator(Player.BLACK);
		assertEquals(4, evalW.evaluate(board));
		assertEquals(-4, evalW.evaluate(board1));
		assertEquals(-4, evalB.evaluate(board));
		assertEquals(4, evalB.evaluate(board1));
	}
	
	@Test
	public void evaluationPawnAddKnight() throws Exception {
		
		Board board = new Board(
				TestUtils.getMultilineString("1 W", ".N...", ".....", ".....", ".....", ".....", ".P..."));
		Board board1 = new Board(
				TestUtils.getMultilineString("1 W", ".n...", ".....", ".....", ".....", ".....", ".p..."));
		
		BoardEvaluator evalW = new BoardEvaluator(Player.WHITE);
		BoardEvaluator evalB = new BoardEvaluator(Player.BLACK);
		assertEquals(4, evalW.evaluate(board));
		assertEquals(-4, evalW.evaluate(board1));
		assertEquals(-4, evalB.evaluate(board));
		assertEquals(4, evalB.evaluate(board1));
	}
	
	@Test
	public void evaluationPawnAddRook() throws Exception {
		Board board = new Board(
				TestUtils.getMultilineString("1 W", ".R...", ".....", ".....", ".....", ".....", ".P..."));
		Board board1 = new Board(
				TestUtils.getMultilineString("1 W", ".r...", ".....", ".....", ".....", ".....", ".p..."));
		
		BoardEvaluator evalW = new BoardEvaluator(Player.WHITE);
		BoardEvaluator evalB = new BoardEvaluator(Player.BLACK);
		assertEquals(6, evalW.evaluate(board));
		assertEquals(-6, evalW.evaluate(board1));
		assertEquals(-6, evalB.evaluate(board));
		assertEquals(6, evalB.evaluate(board1));
	}
	
	@Test
	public void evaluationPawnAddPawn() throws Exception {
		
		Board board = new Board(
				TestUtils.getMultilineString("1 W", ".P...", ".....", ".....", ".....", ".....", ".P..."));
		Board board1 = new Board(
				TestUtils.getMultilineString("1 W", ".p...", ".....", ".....", ".....", ".....", ".p..."));
		
		BoardEvaluator evalW = new BoardEvaluator(Player.WHITE);
		BoardEvaluator evalB = new BoardEvaluator(Player.BLACK);
		assertEquals(2, evalW.evaluate(board));
		assertEquals(-2, evalW.evaluate(board1));
		assertEquals(-2, evalB.evaluate(board));
		assertEquals(2, evalB.evaluate(board1));
	}
	
	@Test
	public void evaluationRookAddKing() throws Exception {
		Board board = new Board(
				TestUtils.getMultilineString("1 W", ".K...", ".....", ".....", ".....", ".....", ".R..."));
		Board board1 = new Board(
				TestUtils.getMultilineString("1 W", ".k...", ".....", ".....", ".....", ".....", ".r..."));
		
		BoardEvaluator evalW = new BoardEvaluator(Player.WHITE);
		BoardEvaluator evalB = new BoardEvaluator(Player.BLACK);
		assertEquals(105, evalW.evaluate(board));
		assertEquals(-105, evalW.evaluate(board1));
		assertEquals(-105, evalB.evaluate(board));
		assertEquals(105, evalB.evaluate(board1));
	}
	
	@Test
	public void evaluationRookAddQueen() throws Exception {
		Board board = new Board(
				TestUtils.getMultilineString("1 W", ".Q...", ".....", ".....", ".....", ".....", ".R..."));
		Board board1 = new Board(
				TestUtils.getMultilineString("1 W", ".q...", ".....", ".....", ".....", ".....", ".r..."));
		
		BoardEvaluator evalW = new BoardEvaluator(Player.WHITE);
		BoardEvaluator evalB = new BoardEvaluator(Player.BLACK);
		assertEquals(14, evalW.evaluate(board));
		assertEquals(-14, evalW.evaluate(board1));
		assertEquals(-14, evalB.evaluate(board));
		assertEquals(14, evalB.evaluate(board1));
	}
	
	@Test
	public void evaluationRookAddBishop() throws Exception {
		Board board = new Board(
				TestUtils.getMultilineString("1 W", ".B...", ".....", ".....", ".....", ".....", ".R..."));
		Board board1 = new Board(
				TestUtils.getMultilineString("1 W", ".b...", ".....", ".....", ".....", ".....", ".r..."));
		
		BoardEvaluator evalW = new BoardEvaluator(Player.WHITE);
		BoardEvaluator evalB = new BoardEvaluator(Player.BLACK);
		assertEquals(8, evalW.evaluate(board));
		assertEquals(-8, evalW.evaluate(board1));
		assertEquals(-8, evalB.evaluate(board));
		assertEquals(8, evalB.evaluate(board1));
	}
	
	@Test
	public void evaluationRookAddKnight() throws Exception {
		Board board = new Board(
				TestUtils.getMultilineString("1 W", ".N...", ".....", ".....", ".....", ".....", ".R..."));
		Board board1 = new Board(
				TestUtils.getMultilineString("1 W", ".n...", ".....", ".....", ".....", ".....", ".r..."));
		
		BoardEvaluator evalW = new BoardEvaluator(Player.WHITE);
		BoardEvaluator evalB = new BoardEvaluator(Player.BLACK);
		assertEquals(8, evalW.evaluate(board));
		assertEquals(-8, evalW.evaluate(board1));
		assertEquals(-8, evalB.evaluate(board));
		assertEquals(8, evalB.evaluate(board1));
	}
	
	@Test
	public void evaluationRookAddRook() throws Exception {
		Board board = new Board(
				TestUtils.getMultilineString("1 W", ".R...", ".....", ".....", ".....", ".....", ".R..."));
		Board board1 = new Board(
				TestUtils.getMultilineString("1 W", ".r...", ".....", ".....", ".....", ".....", ".r..."));
		
		BoardEvaluator evalW = new BoardEvaluator(Player.WHITE);
		BoardEvaluator evalB = new BoardEvaluator(Player.BLACK);
		assertEquals(10, evalW.evaluate(board));
		assertEquals(-10, evalW.evaluate(board1));
		assertEquals(-10, evalB.evaluate(board));
		assertEquals(10, evalB.evaluate(board1));
	}
	
	@Test
	public void evaluationKnightAddKing() throws Exception {
		Board board = new Board(
				TestUtils.getMultilineString("1 W", ".K...", ".....", ".....", ".....", ".....", ".N..."));
		Board board1 = new Board(
				TestUtils.getMultilineString("1 W", ".k...", ".....", ".....", ".....", ".....", ".n..."));
		
		BoardEvaluator evalW = new BoardEvaluator(Player.WHITE);
		BoardEvaluator evalB = new BoardEvaluator(Player.BLACK);
		assertEquals(103, evalW.evaluate(board));
		assertEquals(-103, evalW.evaluate(board1));
		assertEquals(-103, evalB.evaluate(board));
		assertEquals(103, evalB.evaluate(board1));
	}
	
	@Test
	public void evaluationKnightAddQueen() throws Exception {
		Board board = new Board(
				TestUtils.getMultilineString("1 W", ".Q...", ".....", ".....", ".....", ".....", ".N..."));
		Board board1 = new Board(
				TestUtils.getMultilineString("1 W", ".q...", ".....", ".....", ".....", ".....", ".n..."));
		
		BoardEvaluator evalW = new BoardEvaluator(Player.WHITE);
		BoardEvaluator evalB = new BoardEvaluator(Player.BLACK);
		assertEquals(12, evalW.evaluate(board));
		assertEquals(-12, evalW.evaluate(board1));
		assertEquals(-12, evalB.evaluate(board));
		assertEquals(12, evalB.evaluate(board1));
	}
	
	@Test
	public void evaluationKnightAddBishop() throws Exception {
		Board board = new Board(
				TestUtils.getMultilineString("1 W", ".B...", ".....", ".....", ".....", ".....", ".N..."));
		Board board1 = new Board(
				TestUtils.getMultilineString("1 W", ".b...", ".....", ".....", ".....", ".....", ".n..."));
		
		BoardEvaluator evalW = new BoardEvaluator(Player.WHITE);
		BoardEvaluator evalB = new BoardEvaluator(Player.BLACK);
		assertEquals(6, evalW.evaluate(board));
		assertEquals(-6, evalW.evaluate(board1));
		assertEquals(-6, evalB.evaluate(board));
		assertEquals(6, evalB.evaluate(board1));
	}
	
	@Test
	public void evaluationKnightAddKnight() throws Exception {
		Board board = new Board(
				TestUtils.getMultilineString("1 W", ".N...", ".....", ".....", ".....", ".....", ".N..."));
		Board board1 = new Board(
				TestUtils.getMultilineString("1 W", ".n...", ".....", ".....", ".....", ".....", ".n..."));
		
		BoardEvaluator evalW = new BoardEvaluator(Player.WHITE);
		BoardEvaluator evalB = new BoardEvaluator(Player.BLACK);
		assertEquals(6, evalW.evaluate(board));
		assertEquals(-6, evalW.evaluate(board1));
		assertEquals(-6, evalB.evaluate(board));
		assertEquals(6, evalB.evaluate(board1));
	}
	
	@Test
	public void evaluationBishopAddKing() throws Exception {
		Board board = new Board(
				TestUtils.getMultilineString("1 W", ".K...", ".....", ".....", ".....", ".....", ".B..."));
		Board board1 = new Board(
				TestUtils.getMultilineString("1 W", ".k...", ".....", ".....", ".....", ".....", ".b..."));
		
		BoardEvaluator evalW = new BoardEvaluator(Player.WHITE);
		BoardEvaluator evalB = new BoardEvaluator(Player.BLACK);
		assertEquals(103, evalW.evaluate(board));
		assertEquals(-103, evalW.evaluate(board1));
		assertEquals(-103, evalB.evaluate(board));
		assertEquals(103, evalB.evaluate(board1));
	}
	
	@Test
	public void evaluationBishopAddQueen() throws Exception {
		Board board = new Board(
				TestUtils.getMultilineString("1 W", ".Q...", ".....", ".....", ".....", ".....", ".B..."));
		Board board1 = new Board(
				TestUtils.getMultilineString("1 W", ".q...", ".....", ".....", ".....", ".....", ".b..."));
		
		BoardEvaluator evalW = new BoardEvaluator(Player.WHITE);
		BoardEvaluator evalB = new BoardEvaluator(Player.BLACK);
		assertEquals(12, evalW.evaluate(board));
		assertEquals(-12, evalW.evaluate(board1));
		assertEquals(-12, evalB.evaluate(board));
		assertEquals(12, evalB.evaluate(board1));
	}
	
	@Test
	public void evaluationBishopAddBishop() throws Exception {
		Board board = new Board(
				TestUtils.getMultilineString("1 W", ".B...", ".....", ".....", ".....", ".....", ".B..."));
		Board board1 = new Board(
				TestUtils.getMultilineString("1 W", ".b...", ".....", ".....", ".....", ".....", ".b..."));
		
		BoardEvaluator evalW = new BoardEvaluator(Player.WHITE);
		BoardEvaluator evalB = new BoardEvaluator(Player.BLACK);
		assertEquals(6, evalW.evaluate(board));
		assertEquals(-6, evalW.evaluate(board1));
		assertEquals(-6, evalB.evaluate(board));
		assertEquals(6, evalB.evaluate(board1));
	}
	
	@Test
	public void evaluationQueenAddKing() throws Exception {
		Board board = new Board(
				TestUtils.getMultilineString("1 W", ".K...", ".....", ".....", ".....", ".....", ".Q..."));
		Board board1 = new Board(
				TestUtils.getMultilineString("1 W", ".k...", ".....", ".....", ".....", ".....", ".q..."));
		
		BoardEvaluator evalW = new BoardEvaluator(Player.WHITE);
		BoardEvaluator evalB = new BoardEvaluator(Player.BLACK);
		assertEquals(109, evalW.evaluate(board));
		assertEquals(-109, evalW.evaluate(board1));
		assertEquals(-109, evalB.evaluate(board));
		assertEquals(109, evalB.evaluate(board1));
	}
	
	@Test
	public void evaluationQueenAddQueen() throws Exception {
		Board board = new Board(
				TestUtils.getMultilineString("1 W", ".Q...", ".....", ".....", ".....", ".....", ".Q..."));
		Board board1 = new Board(
				TestUtils.getMultilineString("1 W", ".q...", ".....", ".....", ".....", ".....", ".q..."));
		
		BoardEvaluator evalW = new BoardEvaluator(Player.WHITE);
		BoardEvaluator evalB = new BoardEvaluator(Player.BLACK);
		assertEquals(18, evalW.evaluate(board));
		assertEquals(-18, evalW.evaluate(board1));
		assertEquals(-18, evalB.evaluate(board));
		assertEquals(18, evalB.evaluate(board1));
	}
	
	@Test
	public void evaluationFullField() throws Exception {
		Board board = new Board(
				TestUtils.getMultilineString("1 W", "kqbnr", "ppppp", ".....", ".....", "PPPPP", "RNBQK"));
		
		BoardEvaluator evalW = new BoardEvaluator(Player.WHITE);
		BoardEvaluator evalB = new BoardEvaluator(Player.BLACK);
		assertEquals(0, evalW.evaluate(board));
		assertEquals(0, evalB.evaluate(board));
	}
}
