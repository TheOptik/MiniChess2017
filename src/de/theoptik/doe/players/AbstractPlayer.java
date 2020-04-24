package de.theoptik.doe.players;

import de.theoptik.doe.Board;
import de.theoptik.doe.Move;
import de.theoptik.doe.Player;

public abstract class AbstractPlayer {
	
	protected final Player player;
	
	public AbstractPlayer(Player player) {
		this.player = player;
	}
	
	public abstract Move getMove(Board board);
	
	@Override
	public String toString() {
		return this.getClass().getName() + player.toString();
	}
	
}
