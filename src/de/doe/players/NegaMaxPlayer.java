package de.doe.players;

import java.util.Collections;
import java.util.List;

import de.doe.Board;
import de.doe.Move;
import de.doe.MoveGenerator;
import de.doe.Player;
import heuristics.BoardEvaluator;

public class NegaMaxPlayer extends AbstractPlayer {
	
	private final int timePerMove;
	private boolean timeout = false;
	
	/**
	 * @param player
	 * @param timePerMove
	 *            in seconds
	 */
	public NegaMaxPlayer(Player player, int timePerMove) {
		super(player);
		this.timePerMove = timePerMove;
	}
	
	@Override
	public Move getMove(Board board) {
		
		MoveGenerator generator = new MoveGenerator(board);
		List<Move> moves = generator.getAllMoves();
		Collections.shuffle(moves);
		
		int maxScore = Integer.MIN_VALUE;
		Move bestMove = null;
		timeout = false;
		
		Thread timer = new Thread(new Runnable() {
			
			@Override
			public void run() {
				long end = System.currentTimeMillis() + (timePerMove * 1000);
				while (!timeout) {
					timeout = end < System.currentTimeMillis();
				}
			}
		});
		timer.start();
		
		int depth = 2;
		while (!timeout) {
			for (Move move : moves) {
				int score = -negaMax(board.move(move), depth);
				if (score > maxScore) {
					maxScore = score;
					bestMove = move;
				}
			}
			depth++;
		}
		
		return bestMove;
	}
	
	protected int negaMax(Board board, int depth) {
		// TODO eventuell könnte man hier sobald ein king capture stattfindet
		// returnen
		
		if (timeout) {
			return Integer.MIN_VALUE;
		}
		MoveGenerator generator = new MoveGenerator(board);
		List<Move> moves = generator.getAllMoves();
		int result = Integer.MIN_VALUE;
		
		BoardEvaluator evaluator = new BoardEvaluator(board.getActivePlayer());
		
		if (depth <= 0 || moves.isEmpty()) {
			return evaluator.evaluate(board);
		}
		
		for (Move move : moves) {
			Board newBoard = board.move(move);
			int score = -negaMax(newBoard, depth - 1);
			result = Math.max(result, score);
		}
		
		return result;
		
	}
	
}
