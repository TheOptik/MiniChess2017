package de.doe.players;

import de.doe.Board;
import de.doe.Move;
import de.doe.Player;

public abstract class AbstractPlayer {
	
	protected final Player player;
	
	public AbstractPlayer(Player player) {
	this.player = player;
	}
	
	public abstract Move getMove(Board board);
	
}
