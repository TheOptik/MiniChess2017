package de.theoptik.doe.heuristics;

import java.util.List;

import de.theoptik.doe.Board;
import de.theoptik.doe.Player;
import de.theoptik.doe.pieces.Figure;

public class BoardEvaluator {
	
	protected Player player;
	
	public BoardEvaluator(Player player) {
		this.player = player;
	}
	
	public int evaluate(Board board) {
		int result = 0;
		List<Figure> figures = board.getAllFiguresForPlayer(player);
		for (Figure figure : figures) {
			result += figure.getValue();
		}
		
		figures = board.getAllFiguresForPlayer(player.other());
		for (Figure figure : figures) {
			result -= figure.getValue();
		}
		
		return result;
	}
	
}
