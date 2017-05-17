package de.doe.players;

import java.util.Collections;
import java.util.List;

import de.doe.Board;
import de.doe.Move;
import de.doe.MoveGenerator;
import de.doe.Player;
import heuristics.BoardEvaluator;

public class NegaMaxPlayer extends AbstractPlayer {

	private int depth;

	public NegaMaxPlayer(Player player, int depth) {
		super(player);
		this.depth = depth;
	}

	@Override
	public Move getMove(Board board) {

		MoveGenerator generator = new MoveGenerator(board);
		List<Move> moves = generator.getAllMoves();
		Collections.shuffle(moves);

		int maxScore = Integer.MIN_VALUE;
		Move bestMove = null;

		for (Move move : moves) {
			int score = negaMax(board.move(move), depth);
			if (score > maxScore) {
				maxScore = score;
				bestMove = move;
			}
		}

		return bestMove;
	}

	protected int negaMax(Board board, int depth) {
		// TODO eventuell könnte man hier sobald ein king capture stattfindet
		// returnen
		int result = Integer.MIN_VALUE;
		MoveGenerator generator = new MoveGenerator(board);
		List<Move> moves = generator.getAllMoves();

		BoardEvaluator evaluator = new BoardEvaluator(player);

		if (depth <= 0 || moves.isEmpty()) {
			return evaluator.evaluate(board);
		}
		for (Move move : moves) {// TODO test like in skript (without just doing
									// it in one loop)
			Board newBoard = board.move(move);
			int score = -(negaMax(newBoard, depth - 1));
			result = Math.max(result, score);
		}

		return result;

	}

}
