package de.doe.players;

import java.util.List;

import de.doe.Board;
import de.doe.Move;
import de.doe.MoveGenerator;
import de.doe.Player;

public class RandomPlayer extends AbstractPlayer {
	
	public RandomPlayer(Player player) {
		super(player);
	}
	
	@Override
	public Move getMove(Board board) {
		
		MoveGenerator generator = new MoveGenerator(board);
		
		List<Move> moves = generator.getAllMoves();
		
		return moves.get((int) (Math.random() * moves.size()));
	}
	
}
