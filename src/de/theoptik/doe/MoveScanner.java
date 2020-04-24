package de.theoptik.doe;

import java.util.function.Consumer;

import de.theoptik.doe.pieces.Figure;

public class MoveScanner {
	
	public static void scan(Coordinate startPosition, MoveMode moveMode, Board board, Consumer<Move> callback) {
		int x = startPosition.x;
		int y = startPosition.y;
		
		Player player = board.getField(x, y).figure.getPlayer();
		Figure figure;
		
		do {
			x += moveMode.rowDirection;
			y += moveMode.columnDirection;
			
			if (x < 0 || x > 4 || y < 0 || y > 5) {
				break;
			}
			
			figure = board.getField(x, y).figure;
			if (figure != null) {
				if (figure.getPlayer() == player) {
					break;
				}
				if (moveMode.catureMode == MoveMode.CAPUTRE_MODE_NO) {
					break;
				}
				moveMode.oneStep = true;
			} else if (moveMode.catureMode == MoveMode.CAPUTRE_MODE_MUST) {
				break;
			}
			callback.accept(new Move(player, startPosition.x, startPosition.y, x, y));
		} while (!moveMode.oneStep);
		
	}
	
	public static void symmscan(Coordinate startPosition, MoveMode moveMode, Board board, Consumer<Move> callback) {
		
		MoveMode mode = new MoveMode(moveMode.columnDirection, moveMode.rowDirection, moveMode.oneStep,
				moveMode.catureMode, moveMode.symetric);
		
		int temp;
		
		for (int i = 1; i <= 4; i++) {
			scan(startPosition, mode, board, callback);
			
			temp = mode.rowDirection;
			mode.rowDirection = mode.columnDirection;
			mode.columnDirection = -temp;
		}
	}
}
