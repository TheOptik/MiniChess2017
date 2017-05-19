package de.doe.players;

import static org.junit.Assert.*;

import org.junit.Test;

import de.doe.Board;
import de.doe.Move;
import de.doe.Player;
import de.doe.TestUtils;

public class NegaMaxPlayerTest {
	
	@Test
	public void PawnCaptureKing() throws Exception {
		Board board = new Board(
				TestUtils.getMultilineString("1 W", ".k...", "..P..", ".....", ".....", ".....", "....."));
		Board expected = new Board(
				TestUtils.getMultilineString("2 B", ".P...", ".....", ".....", ".....", ".....", "....."));
		
		System.out.println(board);
		NegaMaxPlayer player1 = new NegaMaxPlayer(Player.WHITE, 1);
		Move move = player1.getMove(board);
		Board result = board.move(move);
		
		assertEquals(expected.toString(), result.toString());
	}
	
	@Test
	public void KingsEscape() throws Exception {
		Board board = new Board(
				TestUtils.getMultilineString("1 W", ".....", "r....", "..K..", "..p..", ".r...", "....."));
		System.out.println(board);
		Board expected = new Board(
				TestUtils.getMultilineString("2 B", ".....", "r....", ".....", "..K..", ".r...", "....."));
		
		Board expected2 = new Board(
				TestUtils.getMultilineString("2 B", ".....", "r....", ".....", "..pK.", ".r...", "....."));
		
		NegaMaxPlayer player1 = new NegaMaxPlayer(Player.WHITE, 1);
		Move move = player1.getMove(board);
		Board result = board.move(move);
		
		System.out.println(result);
		assertTrue(expected.toString().equals(result.toString()) || expected2.toString().equals(result.toString()));
	}
	
	@Test
	public void knightCaptureKing() throws Exception {
		
		Board board = new Board(
				TestUtils.getMultilineString("30 B", ".....", "p.pb.", "kp.pp", ".PNPP", "PnPB.", "RQ.K."));
		
		NegaMaxPlayer player1 = new NegaMaxPlayer(Player.BLACK, 3);
		System.out.println(board);
		Board result = board.move(player1.getMove(board));
		System.out.println(result);
		
	}
	
	@Test
	public void knightCaptureKingSmall() throws Exception {
		
		Board board = new Board(
				TestUtils.getMultilineString("30 B", ".....", ".....", "k....", ".PN..", ".n...", "...K."));
		
		NegaMaxPlayer player1 = new NegaMaxPlayer(Player.BLACK, 3);
		System.out.println(board);
		Board result = board.move(player1.getMove(board));
		System.out.println(result);
		
	}
	
	@Test
	public void howDoesTheKingMove() throws Exception {
		
		Board board = new Board(
				TestUtils.getMultilineString("1 B", ".....", "R....", "..k..", ".....", ".....", "...RB"));
		NegaMaxPlayer player = new NegaMaxPlayer(Player.BLACK, 3);
		System.out.println(board);
		Board result = board.move(player.getMove(board));
		System.out.println(result);
		
	}
	
	@Test
	public void checkDepthForNormalGameLength() throws Exception {
		
		NegaMaxPlayer player = new NegaMaxPlayer(Player.WHITE, 6);
		Move move = player.getMove(new Board());
		System.out.println(move.toChessString());
		System.out.println(player.getLastPlayDepth());
		assertTrue(6 < player.getLastPlayDepth());
	}
	
	@Test
    public void checkMoves() throws Exception {
      Board board = new Board(TestUtils.getMultilineString("23 W", "...n.", "..kbr", "..p.p", "R.P.P", ".P.P.", "..B.K"));
      NegaMaxPlayer player = new NegaMaxPlayer(Player.WHITE, 4);
      System.out.println(board);
      Board result = board.move(player.getMove(board));
      System.out.println(result);
    }
	
}
