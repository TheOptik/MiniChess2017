package de.theoptik.doe.pieces;

import java.util.ArrayList;
import java.util.List;

import de.theoptik.doe.MoveMode;
import de.theoptik.doe.Player;

public class King extends Figure {
	
	private static final List<MoveMode> moveModes;
	
	static {
		moveModes = new ArrayList<>();
		moveModes.add(new MoveMode(1, 1, true, MoveMode.CAPUTRE_MODE_CAN, true));
		moveModes.add(new MoveMode(0, 1, true, MoveMode.CAPUTRE_MODE_CAN, true));
	}
	
	public King(Player player,int value) {
		super(player,value);
	}
	
	@Override
	public List<MoveMode> getAllMoveModes() {
		return moveModes;
	}
	
	@Override
	public String toString() {
		return Character.toString(player.equals(Player.WHITE) ? Figure.WHITE_KING_CODE : Figure.BLACK_KING_CODE);
	}
	
}
