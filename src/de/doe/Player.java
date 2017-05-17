package de.doe;

public enum Player {
	BLACK, WHITE;
	
	public static Player fromChar(char c) {
		if (c == 'w' || c == 'W') {
			return Player.WHITE;
		} else if (c == 'b' || c == 'B') {
			return Player.BLACK;
		}
		throw new IllegalArgumentException("Player identifier '" + c + "' is not valid.");
	}
	
	public char toChar() {
		return this.equals(WHITE) ? 'W' : 'B';
	}
	
	public Player other() {
		if (this.equals(WHITE)) {
			return Player.BLACK;
		} else {
			return Player.WHITE;
		}
	}
}
