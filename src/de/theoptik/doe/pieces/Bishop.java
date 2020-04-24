package de.theoptik.doe.pieces;

import java.util.ArrayList;
import java.util.List;

import de.theoptik.doe.MoveMode;
import de.theoptik.doe.Player;

public class Bishop extends Figure {
	
	private static final List<MoveMode> moveModes;
	
	static {
		moveModes = new ArrayList<>();
		moveModes.add(new MoveMode(1, 1, false, MoveMode.CAPUTRE_MODE_CAN, true));
		moveModes.add(new MoveMode(0, 1, true, MoveMode.CAPUTRE_MODE_NO, true));
	}
	
	public Bishop(Player player,int value) {
		super(player,value);
	}
	
	@Override
	public List<MoveMode> getAllMoveModes() {
		return moveModes;
	}
	
	@Override
	public String toString() {
		return Character.toString(player.equals(Player.WHITE) ? Figure.WHITE_BISHOP_CODE : Figure.BLACK_BISHOP_CODE);
	}
	
}
