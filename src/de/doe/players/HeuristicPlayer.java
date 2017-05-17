package de.doe.players;

import de.doe.Board;
import de.doe.Move;
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
		
		
		return null;
	}
	
}
