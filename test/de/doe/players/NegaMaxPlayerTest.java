package de.doe.players;

import static org.junit.Assert.assertEquals;

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

		NegaMaxPlayer player1 = new NegaMaxPlayer(Player.WHITE, 1);
		Move move = player1.getMove(board);
		Board result = board.move(move);

		assertEquals(expected.toString(), result.toString());
	}

	@Test
	public void KingsEscape() throws Exception {
		Board board = new Board(
				TestUtils.getMultilineString("1 W", ".....", "r....", "..K.", "..p..", ".r...", "....."));
		Board expected = new Board(
				TestUtils.getMultilineString("2 B", ".....", "r....", ".....", "..K..", ".r...", "....."));

		NegaMaxPlayer player1 = new NegaMaxPlayer(Player.WHITE, 1);
		Move move = player1.getMove(board);
		Board result = board.move(move);

		assertEquals(expected.toString(), result.toString());
	}

}
