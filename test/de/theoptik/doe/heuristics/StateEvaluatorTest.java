package de.theoptik.doe.heuristics;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.theoptik.doe.Board;
import de.theoptik.doe.Player;
import de.theoptik.doe.TestUtils;
import de.theoptik.doe.heuristics.BoardEvaluator;
import de.theoptik.doe.players.NegaMaxPlayer;

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
		
		assertEquals(215, evalW.evaluate(board));
		assertEquals(-215, evalW.evaluate(board1));
		assertEquals(-215, evalB.evaluate(board2));
		assertEquals(215, evalB.evaluate(board3));
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
		
		assertEquals(171, evalW.evaluate(board));
		assertEquals(-171, evalW.evaluate(board1));
		assertEquals(-171, evalB.evaluate(board2));
		assertEquals(171, evalB.evaluate(board3));
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
		
		assertEquals(41, evalW.evaluate(board));
		assertEquals(-41, evalW.evaluate(board1));
		assertEquals(-41, evalB.evaluate(board2));
		assertEquals(41, evalB.evaluate(board3));
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
		
		assertEquals(72, evalW.evaluate(board));
		assertEquals(-72, evalW.evaluate(board1));
		assertEquals(-72, evalB.evaluate(board2));
		assertEquals(72, evalB.evaluate(board3));
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
		
		assertEquals(84, evalW.evaluate(board));
		assertEquals(-84, evalW.evaluate(board1));
		assertEquals(-84, evalB.evaluate(board2));
		assertEquals(84, evalB.evaluate(board3));
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
		
		assertEquals(131, evalW.evaluate(board));
		assertEquals(-131, evalW.evaluate(board1));
		assertEquals(-131, evalB.evaluate(board2));
		assertEquals(131, evalB.evaluate(board3));
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
		
		assertEquals(87, evalW.evaluate(board));
		assertEquals(-87, evalW.evaluate(board1));
		assertEquals(-87, evalB.evaluate(board2));
		assertEquals(87, evalB.evaluate(board3));
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
		
		assertEquals(-43, evalW.evaluate(board));
		assertEquals(43, evalW.evaluate(board1));
		assertEquals(43, evalB.evaluate(board2));
		assertEquals(-43, evalB.evaluate(board3));
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
		
		assertEquals(-12, evalW.evaluate(board));
		assertEquals(12, evalW.evaluate(board1));
		assertEquals(12, evalB.evaluate(board2));
		assertEquals(-12, evalB.evaluate(board3));
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
		
		assertEquals(143, evalW.evaluate(board));
		assertEquals(-143, evalW.evaluate(board1));
		assertEquals(-143, evalB.evaluate(board2));
		assertEquals(143, evalB.evaluate(board3));
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
		
		assertEquals(99, evalW.evaluate(board));
		assertEquals(-99, evalW.evaluate(board1));
		assertEquals(-99, evalB.evaluate(board2));
		assertEquals(99, evalB.evaluate(board3));
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
		
		assertEquals(-31, evalW.evaluate(board));
		assertEquals(31, evalW.evaluate(board1));
		assertEquals(31, evalB.evaluate(board2));
		assertEquals(-31, evalB.evaluate(board3));
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
		
		assertEquals(174, evalW.evaluate(board));
		assertEquals(-174, evalW.evaluate(board1));
		assertEquals(-174, evalB.evaluate(board2));
		assertEquals(174, evalB.evaluate(board3));
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
		
		assertEquals(130, evalW.evaluate(board));
		assertEquals(-130, evalW.evaluate(board1));
		assertEquals(-130, evalB.evaluate(board2));
		assertEquals(130, evalB.evaluate(board3));
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
		
		assertEquals(44, evalW.evaluate(board));
		assertEquals(-44, evalW.evaluate(board1));
		assertEquals(-44, evalB.evaluate(board2));
		assertEquals(44, evalB.evaluate(board3));
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
		assertEquals(251, evalW.evaluate(board));
		assertEquals(-251, evalW.evaluate(board1));
		assertEquals(-251, evalB.evaluate(board));
		assertEquals(251, evalB.evaluate(board1));
	}
	
	@Test
	public void evaluationPawnAddQueen() throws Exception {
		Board board = new Board(
				TestUtils.getMultilineString("1 W", ".Q...", ".....", ".....", ".....", ".....", ".P..."));
		Board board1 = new Board(
				TestUtils.getMultilineString("1 W", ".q...", ".....", ".....", ".....", ".....", ".p..."));
		
		BoardEvaluator evalW = new BoardEvaluator(Player.WHITE);
		BoardEvaluator evalB = new BoardEvaluator(Player.BLACK);
		assertEquals(207, evalW.evaluate(board));
		assertEquals(-207, evalW.evaluate(board1));
		assertEquals(-207, evalB.evaluate(board));
		assertEquals(207, evalB.evaluate(board1));
	}
	
	@Test
	public void evaluationPawnAddBishop() throws Exception {
		
		Board board = new Board(
				TestUtils.getMultilineString("1 W", ".B...", ".....", ".....", ".....", ".....", ".P..."));
		Board board1 = new Board(
				TestUtils.getMultilineString("1 W", ".b...", ".....", ".....", ".....", ".....", ".p..."));
		
		BoardEvaluator evalW = new BoardEvaluator(Player.WHITE);
		BoardEvaluator evalB = new BoardEvaluator(Player.BLACK);
		assertEquals(77, evalW.evaluate(board));
		assertEquals(-77, evalW.evaluate(board1));
		assertEquals(-77, evalB.evaluate(board));
		assertEquals(77, evalB.evaluate(board1));
	}
	
	@Test
	public void evaluationPawnAddKnight() throws Exception {
		
		Board board = new Board(
				TestUtils.getMultilineString("1 W", ".N...", ".....", ".....", ".....", ".....", ".P..."));
		Board board1 = new Board(
				TestUtils.getMultilineString("1 W", ".n...", ".....", ".....", ".....", ".....", ".p..."));
		
		BoardEvaluator evalW = new BoardEvaluator(Player.WHITE);
		BoardEvaluator evalB = new BoardEvaluator(Player.BLACK);
		assertEquals(108, evalW.evaluate(board));
		assertEquals(-108, evalW.evaluate(board1));
		assertEquals(-108, evalB.evaluate(board));
		assertEquals(108, evalB.evaluate(board1));
	}
	
	@Test
	public void evaluationPawnAddRook() throws Exception {
		Board board = new Board(
				TestUtils.getMultilineString("1 W", ".R...", ".....", ".....", ".....", ".....", ".P..."));
		Board board1 = new Board(
				TestUtils.getMultilineString("1 W", ".r...", ".....", ".....", ".....", ".....", ".p..."));
		
		BoardEvaluator evalW = new BoardEvaluator(Player.WHITE);
		BoardEvaluator evalB = new BoardEvaluator(Player.BLACK);
		assertEquals(120, evalW.evaluate(board));
		assertEquals(-120, evalW.evaluate(board1));
		assertEquals(-120, evalB.evaluate(board));
		assertEquals(120, evalB.evaluate(board1));
	}
	
	@Test
	public void evaluationPawnAddPawn() throws Exception {
		
		Board board = new Board(
				TestUtils.getMultilineString("1 W", ".P...", ".....", ".....", ".....", ".....", ".P..."));
		Board board1 = new Board(
				TestUtils.getMultilineString("1 W", ".p...", ".....", ".....", ".....", ".....", ".p..."));
		
		BoardEvaluator evalW = new BoardEvaluator(Player.WHITE);
		BoardEvaluator evalB = new BoardEvaluator(Player.BLACK);
		assertEquals(36, evalW.evaluate(board));
		assertEquals(-36, evalW.evaluate(board1));
		assertEquals(-36, evalB.evaluate(board));
		assertEquals(36, evalB.evaluate(board1));
	}
	
	@Test
	public void evaluationRookAddKing() throws Exception {
		Board board = new Board(
				TestUtils.getMultilineString("1 W", ".K...", ".....", ".....", ".....", ".....", ".R..."));
		Board board1 = new Board(
				TestUtils.getMultilineString("1 W", ".k...", ".....", ".....", ".....", ".....", ".r..."));
		
		BoardEvaluator evalW = new BoardEvaluator(Player.WHITE);
		BoardEvaluator evalB = new BoardEvaluator(Player.BLACK);
		assertEquals(335, evalW.evaluate(board));
		assertEquals(-335, evalW.evaluate(board1));
		assertEquals(-335, evalB.evaluate(board));
		assertEquals(335, evalB.evaluate(board1));
	}
	
	@Test
	public void evaluationRookAddQueen() throws Exception {
		Board board = new Board(
				TestUtils.getMultilineString("1 W", ".Q...", ".....", ".....", ".....", ".....", ".R..."));
		Board board1 = new Board(
				TestUtils.getMultilineString("1 W", ".q...", ".....", ".....", ".....", ".....", ".r..."));
		
		BoardEvaluator evalW = new BoardEvaluator(Player.WHITE);
		BoardEvaluator evalB = new BoardEvaluator(Player.BLACK);
		assertEquals(291, evalW.evaluate(board));
		assertEquals(-291, evalW.evaluate(board1));
		assertEquals(-291, evalB.evaluate(board));
		assertEquals(291, evalB.evaluate(board1));
	}
	
	@Test
	public void evaluationRookAddBishop() throws Exception {
		Board board = new Board(
				TestUtils.getMultilineString("1 W", ".B...", ".....", ".....", ".....", ".....", ".R..."));
		Board board1 = new Board(
				TestUtils.getMultilineString("1 W", ".b...", ".....", ".....", ".....", ".....", ".r..."));
		
		BoardEvaluator evalW = new BoardEvaluator(Player.WHITE);
		BoardEvaluator evalB = new BoardEvaluator(Player.BLACK);
		assertEquals(161, evalW.evaluate(board));
		assertEquals(-161, evalW.evaluate(board1));
		assertEquals(-161, evalB.evaluate(board));
		assertEquals(161, evalB.evaluate(board1));
	}
	
	@Test
	public void evaluationRookAddKnight() throws Exception {
		Board board = new Board(
				TestUtils.getMultilineString("1 W", ".N...", ".....", ".....", ".....", ".....", ".R..."));
		Board board1 = new Board(
				TestUtils.getMultilineString("1 W", ".n...", ".....", ".....", ".....", ".....", ".r..."));
		
		BoardEvaluator evalW = new BoardEvaluator(Player.WHITE);
		BoardEvaluator evalB = new BoardEvaluator(Player.BLACK);
		assertEquals(192, evalW.evaluate(board));
		assertEquals(-192, evalW.evaluate(board1));
		assertEquals(-192, evalB.evaluate(board));
		assertEquals(192, evalB.evaluate(board1));
	}
	
	@Test
	public void evaluationRookAddRook() throws Exception {
		Board board = new Board(
				TestUtils.getMultilineString("1 W", ".R...", ".....", ".....", ".....", ".....", ".R..."));
		Board board1 = new Board(
				TestUtils.getMultilineString("1 W", ".r...", ".....", ".....", ".....", ".....", ".r..."));
		
		BoardEvaluator evalW = new BoardEvaluator(Player.WHITE);
		BoardEvaluator evalB = new BoardEvaluator(Player.BLACK);
		assertEquals(204, evalW.evaluate(board));
		assertEquals(-204, evalW.evaluate(board1));
		assertEquals(-204, evalB.evaluate(board));
		assertEquals(204, evalB.evaluate(board1));
	}
	
	@Test
	public void evaluationKnightAddKing() throws Exception {
		Board board = new Board(
				TestUtils.getMultilineString("1 W", ".K...", ".....", ".....", ".....", ".....", ".N..."));
		Board board1 = new Board(
				TestUtils.getMultilineString("1 W", ".k...", ".....", ".....", ".....", ".....", ".n..."));
		
		BoardEvaluator evalW = new BoardEvaluator(Player.WHITE);
		BoardEvaluator evalB = new BoardEvaluator(Player.BLACK);
		assertEquals(323, evalW.evaluate(board));
		assertEquals(-323, evalW.evaluate(board1));
		assertEquals(-323, evalB.evaluate(board));
		assertEquals(323, evalB.evaluate(board1));
	}
	
	@Test
	public void evaluationKnightAddQueen() throws Exception {
		Board board = new Board(
				TestUtils.getMultilineString("1 W", ".Q...", ".....", ".....", ".....", ".....", ".N..."));
		Board board1 = new Board(
				TestUtils.getMultilineString("1 W", ".q...", ".....", ".....", ".....", ".....", ".n..."));
		
		BoardEvaluator evalW = new BoardEvaluator(Player.WHITE);
		BoardEvaluator evalB = new BoardEvaluator(Player.BLACK);
		assertEquals(279, evalW.evaluate(board));
		assertEquals(-279, evalW.evaluate(board1));
		assertEquals(-279, evalB.evaluate(board));
		assertEquals(279, evalB.evaluate(board1));
	}
	
	@Test
	public void evaluationKnightAddBishop() throws Exception {
		Board board = new Board(
				TestUtils.getMultilineString("1 W", ".B...", ".....", ".....", ".....", ".....", ".N..."));
		Board board1 = new Board(
				TestUtils.getMultilineString("1 W", ".b...", ".....", ".....", ".....", ".....", ".n..."));
		
		BoardEvaluator evalW = new BoardEvaluator(Player.WHITE);
		BoardEvaluator evalB = new BoardEvaluator(Player.BLACK);
		assertEquals(149, evalW.evaluate(board));
		assertEquals(-149, evalW.evaluate(board1));
		assertEquals(-149, evalB.evaluate(board));
		assertEquals(149, evalB.evaluate(board1));
	}
	
	@Test
	public void evaluationKnightAddKnight() throws Exception {
		Board board = new Board(
				TestUtils.getMultilineString("1 W", ".N...", ".....", ".....", ".....", ".....", ".N..."));
		Board board1 = new Board(
				TestUtils.getMultilineString("1 W", ".n...", ".....", ".....", ".....", ".....", ".n..."));
		
		BoardEvaluator evalW = new BoardEvaluator(Player.WHITE);
		BoardEvaluator evalB = new BoardEvaluator(Player.BLACK);
		assertEquals(180, evalW.evaluate(board));
		assertEquals(-180, evalW.evaluate(board1));
		assertEquals(-180, evalB.evaluate(board));
		assertEquals(180, evalB.evaluate(board1));
	}
	
	@Test
	public void evaluationBishopAddKing() throws Exception {
		Board board = new Board(
				TestUtils.getMultilineString("1 W", ".K...", ".....", ".....", ".....", ".....", ".B..."));
		Board board1 = new Board(
				TestUtils.getMultilineString("1 W", ".k...", ".....", ".....", ".....", ".....", ".b..."));
		
		BoardEvaluator evalW = new BoardEvaluator(Player.WHITE);
		BoardEvaluator evalB = new BoardEvaluator(Player.BLACK);
		assertEquals(292, evalW.evaluate(board));
		assertEquals(-292, evalW.evaluate(board1));
		assertEquals(-292, evalB.evaluate(board));
		assertEquals(292, evalB.evaluate(board1));
	}
	
	@Test
	public void evaluationBishopAddQueen() throws Exception {
		Board board = new Board(
				TestUtils.getMultilineString("1 W", ".Q...", ".....", ".....", ".....", ".....", ".B..."));
		Board board1 = new Board(
				TestUtils.getMultilineString("1 W", ".q...", ".....", ".....", ".....", ".....", ".b..."));
		
		BoardEvaluator evalW = new BoardEvaluator(Player.WHITE);
		BoardEvaluator evalB = new BoardEvaluator(Player.BLACK);
		assertEquals(248, evalW.evaluate(board));
		assertEquals(-248, evalW.evaluate(board1));
		assertEquals(-248, evalB.evaluate(board));
		assertEquals(248, evalB.evaluate(board1));
	}
	
	@Test
	public void evaluationBishopAddBishop() throws Exception {
		Board board = new Board(
				TestUtils.getMultilineString("1 W", ".B...", ".....", ".....", ".....", ".....", ".B..."));
		Board board1 = new Board(
				TestUtils.getMultilineString("1 W", ".b...", ".....", ".....", ".....", ".....", ".b..."));
		
		BoardEvaluator evalW = new BoardEvaluator(Player.WHITE);
		BoardEvaluator evalB = new BoardEvaluator(Player.BLACK);
		assertEquals(118, evalW.evaluate(board));
		assertEquals(-118, evalW.evaluate(board1));
		assertEquals(-118, evalB.evaluate(board));
		assertEquals(118, evalB.evaluate(board1));
	}
	
	@Test
	public void evaluationQueenAddKing() throws Exception {
		Board board = new Board(
				TestUtils.getMultilineString("1 W", ".K...", ".....", ".....", ".....", ".....", ".Q..."));
		Board board1 = new Board(
				TestUtils.getMultilineString("1 W", ".k...", ".....", ".....", ".....", ".....", ".q..."));
		
		BoardEvaluator evalW = new BoardEvaluator(Player.WHITE);
		BoardEvaluator evalB = new BoardEvaluator(Player.BLACK);
		assertEquals(422, evalW.evaluate(board));
		assertEquals(-422, evalW.evaluate(board1));
		assertEquals(-422, evalB.evaluate(board));
		assertEquals(422, evalB.evaluate(board1));
	}
	
	@Test
	public void evaluationQueenAddQueen() throws Exception {
		Board board = new Board(
				TestUtils.getMultilineString("1 W", ".Q...", ".....", ".....", ".....", ".....", ".Q..."));
		Board board1 = new Board(
				TestUtils.getMultilineString("1 W", ".q...", ".....", ".....", ".....", ".....", ".q..."));
		
		BoardEvaluator evalW = new BoardEvaluator(Player.WHITE);
		BoardEvaluator evalB = new BoardEvaluator(Player.BLACK);
		assertEquals(378, evalW.evaluate(board));
		assertEquals(-378, evalW.evaluate(board1));
		assertEquals(-378, evalB.evaluate(board));
		assertEquals(378, evalB.evaluate(board1));
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
