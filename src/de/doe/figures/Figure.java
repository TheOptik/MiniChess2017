package de.doe.figures;

import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import de.doe.MoveMode;
import de.doe.Player;

public abstract class Figure {
	
	public static final Figure WHITE_PAWN = new Pawn(Player.WHITE, 18);
	public static final Figure WHITE_ROOK = new Rook(Player.WHITE, 102);
	public static final Figure WHITE_KNIGHT = new Knight(Player.WHITE, 90);
	public static final Figure WHITE_BISHOP = new Bishop(Player.WHITE, 59);
	public static final Figure WHITE_QUEEN = new Queen(Player.WHITE, 189);
	public static final Figure WHITE_KING = new King(Player.WHITE, 233);
	
	public static final Figure BLACK_PAWN = new Pawn(Player.BLACK, 18);
	public static final Figure BLACK_ROOK = new Rook(Player.BLACK, 102);
	public static final Figure BLACK_KNIGHT = new Knight(Player.BLACK, 90);
	public static final Figure BLACK_BISHOP = new Bishop(Player.BLACK, 59);
	public static final Figure BLACK_QUEEN = new Queen(Player.BLACK, 189);
	public static final Figure BLACK_KING = new King(Player.BLACK, 233);
	
	public static final char WHITE_PAWN_CODE = 'P';
	public static final char WHITE_ROOK_CODE = 'R';
	public static final char WHITE_KNIGHT_CODE = 'N';
	public static final char WHITE_BISHOP_CODE = 'B';
	public static final char WHITE_QUEEN_CODE = 'Q';
	public static final char WHITE_KING_CODE = 'K';
	
	public static final char BLACK_PAWN_CODE = 'p';
	public static final char BLACK_ROOK_CODE = 'r';
	public static final char BLACK_KNIGHT_CODE = 'n';
	public static final char BLACK_BISHOP_CODE = 'b';
	public static final char BLACK_QUEEN_CODE = 'q';
	public static final char BLACK_KING_CODE = 'k';
	public static final char NONE_CODE = '.';
	
	protected Player player;
	protected int value;
	
	public Figure(Player player, int value) {
		this.player = player;
		this.value = value;
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
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(this.getClass().getName()).append(player).toHashCode();
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public abstract List<MoveMode> getAllMoveModes();
	
	public int getValue() {
		return value;
	}
	
}
