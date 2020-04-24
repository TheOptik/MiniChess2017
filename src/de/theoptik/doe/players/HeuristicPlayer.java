package de.theoptik.doe.players;

import java.util.List;

import de.theoptik.doe.Board;
import de.theoptik.doe.Move;
import de.theoptik.doe.MoveGenerator;
import de.theoptik.doe.Player;
import de.theoptik.doe.heuristics.BoardEvaluator;

public class HeuristicPlayer extends AbstractPlayer {
	
	BoardEvaluator evaluator;
	
	public HeuristicPlayer(Player player) {
		super(player);
		evaluator = new BoardEvaluator(player);
	}
	
	@Override
	public Move getMove(Board board) {
		
		List<Move> moves = new MoveGenerator(board).getAllMoves();
		int best = Integer.MIN_VALUE;
		Move bestMove = null;
		for (Move move : moves) {
			board.move(move);
			int newBoardValue = evaluator.evaluate(board);
			board.undoMove(move);
			if (best < newBoardValue) {
				best = newBoardValue;
				bestMove = move;
			}
		}
		return bestMove;
	}
	
}
