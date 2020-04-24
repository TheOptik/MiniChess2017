package de.theoptik.doe.players;

import java.util.List;

import de.theoptik.doe.Board;
import de.theoptik.doe.Move;
import de.theoptik.doe.MoveGenerator;
import de.theoptik.doe.Player;

public class RandomPlayer extends AbstractPlayer {
	
	public RandomPlayer(Player player) {
		super(player);
	}
	
	@Override
	public Move getMove(Board board) {
		
		MoveGenerator generator = new MoveGenerator(board);
		
		List<Move> moves = generator.getAllMoves();
		if (moves.size() > 0) {
			return moves.get((int) (Math.random() * moves.size()));
		} else {
			return null;
		}
	}
	
}
