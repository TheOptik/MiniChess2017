package de.doe.players;

import java.util.List;

import de.doe.Board;
import de.doe.Move;
import de.doe.MoveGenerator;
import de.doe.Player;
import heuristics.StateEvaluator;

public class HeuristicPlayer extends AbstractPlayer {
	
	StateEvaluator evaluator;
	
	public HeuristicPlayer(Player player) {
		super(player);
		evaluator = new StateEvaluator(player);
	}
	
	@Override
	public Move getMove(Board board) {
		
		List<Move> moves = new MoveGenerator(board).getAllMoves();
		int best = Integer.MIN_VALUE;
		Move bestMove = null;
		for (Move move : moves) {
			Board newBoard = board.move(move);
			int newBoardValue = evaluator.evaluate(newBoard);
			if (best < newBoardValue) {
				best = newBoardValue;
				bestMove = move;
			}
		}
		System.out.println(best + " " + bestMove);
		return bestMove;
	}
	
}
