package de.doe;

public enum Player {
	BLACK, WHITE;
	
	public Player fromChar(char c) {
		if (c == 'w' || c == 'W') {
			return Player.WHITE;
		} else if (c == 'b' || c == 'B') {
			return Player.BLACK;
		}
		throw new IllegalArgumentException("Player identifier '" + c + "' is not valid.");
	}
}
