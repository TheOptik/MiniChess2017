package de.doe.figures;

import java.util.ArrayList;
import java.util.List;

import de.doe.MoveMode;
import de.doe.Player;

public class Rook extends Figure {
	
	private static final List<MoveMode> moveModes;
	
	static {
		moveModes = new ArrayList<>();
		moveModes.add(new MoveMode(0, 1, false, MoveMode.CAPUTRE_MODE_CAN, true));
	}
	
	public Rook(Player player) {
		super(player);
	}
	
	@Override
	public List<MoveMode> getAllMoveModes() {
		return moveModes;
	}
	
	@Override
	public String toString() {
		return Character.toString(player.equals(Player.WHITE) ? Figure.WHITE_ROOK_CODE : Figure.BLACK_ROOK_CODE);
	}
	
}
