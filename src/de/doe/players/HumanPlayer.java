package de.doe.players;

import java.util.List;
import java.util.Scanner;

import de.doe.Board;
import de.doe.Move;
import de.doe.MoveGenerator;
import de.doe.Player;

public class HumanPlayer extends AbstractPlayer {

	private Scanner scanner;

	public HumanPlayer(Player player) {
		super(player);
		scanner = new Scanner(System.in);
	}

	@Override
	public Move getMove(Board board) {

		MoveGenerator generator = new MoveGenerator(board);
		List<Move> moves = generator.getAllMoves();

		System.out.println("Please make a move for example: " + moves.get(0));
		try {
			Move move = new Move(scanner.nextLine(), player);
			if (moves.contains(move)) {
				return move;
			} else {
				return getMove(board);
			}
		} catch (IllegalArgumentException e) {
			return getMove(board);
		}
	}

}
