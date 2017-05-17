package heuristics;

import java.util.List;

import de.doe.Board;
import de.doe.Coordinate;
import de.doe.MoveMode;
import de.doe.MoveScanner;
import de.doe.Player;
import de.doe.figures.Figure;

public class StateEvaluator {
	
	protected Player player;
	
	public StateEvaluator(Player player) {
		this.player = player;
	}
	
	
	public int evaluate(Board board){
		
		for (int x = 0; x < board.fields.length; x++) {
			
			for (int y = 0; y < board.fields[0].length; y++) {
				
				Figure figure = board.getField(x, y).figure;
				if (figure != null && figure.getPlayer() == board.activePlayer) {
					List<MoveMode> moveModes = figure.getAllMoveModes();
					int size = moveModes.size();
					for (int i = 0; i < size; i++) {
						MoveMode mode = moveModes.get(i);
						if (mode.symetric) {
							MoveScanner.symmscan(new Coordinate(x, y), mode, board, this::collectMoves);
						} else {
							MoveScanner.scan(new Coordinate(x, y), mode, board, this::collectMoves);
						}
						
					}
				}
				
			}
		
		
		return 0;
	}
	
}
