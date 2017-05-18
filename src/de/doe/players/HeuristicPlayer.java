package de.doe.players;

import java.util.List;

import de.doe.Board;
import de.doe.Move;
import de.doe.MoveGenerator;
import de.doe.Player;
import heuristics.BoardEvaluator;

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
