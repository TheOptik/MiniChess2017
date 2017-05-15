package de.doe.figures;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

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
		
		if (obj == this)
			return true;
		if (!(obj instanceof Figure)) {
			return false;
		}
		
		Figure figure = (Figure) obj;
		
		return new EqualsBuilder().append(this.getClass().getName(), figure.getClass().getName())
				.append(player, figure.player).isEquals();
	}
	
	@Override
	public String toString() {
		
		return this.player + " " + this.getClass().getName();
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(this.getClass().getName()).append(player).toHashCode();
	}
	
}
