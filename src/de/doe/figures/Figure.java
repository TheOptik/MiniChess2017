package de.doe.figures;

import de.doe.Player;

public abstract class Figure {
	
	public static final Figure WHITE_PAWN = new Pawn(Player.WHITE);
	public static final Figure WHITE_ROOK = new Rook(Player.WHITE);
	public static final Figure WHITE_KNIGHT = new Knight(Player.WHITE);
	public static final Figure WHITE_BISHOP = new Bishop(Player.WHITE);
	public static final Figure WHITE_QUEEN = new Queen(Player.WHITE);
	public static final Figure WHITE_KING = new King(Player.WHITE);
	
	public static final Figure BLACK_PAWN = new Pawn(Player.BLACK);
	public static final Figure BLACK_ROOK = new Rook(Player.BLACK);
	public static final Figure BLACK_KNIGHT = new Knight(Player.BLACK);
	public static final Figure BLACK_BISHOP = new Bishop(Player.BLACK);
	public static final Figure BLACK_QUEEN = new Queen(Player.BLACK);
	public static final Figure BLACK_KING = new King(Player.BLACK);
	
	protected Player player;
	
	public Figure(Player player) {
		this.player = player;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj.getClass().getName() == this.getClass().getName()) {
			Figure temp = (Figure) obj;
			if (temp.player == this.player) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		
		return this.player + " " + this.getClass().getName();
	}
}
