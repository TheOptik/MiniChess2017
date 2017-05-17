package heuristics;

import java.util.List;

import de.doe.Board;
import de.doe.Player;
import de.doe.figures.Figure;

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
