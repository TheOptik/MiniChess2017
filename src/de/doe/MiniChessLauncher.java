package de.doe;

import de.doe.players.AbstractPlayer;
import de.doe.players.RandomPlayer;

public class MiniChessLauncher {
	
	public static void main(String[] args) {
		
		Board board = new Board();
		System.out.println(board);
		
		AbstractPlayer player1 = new RandomPlayer(Player.WHITE);
		AbstractPlayer player2 = new RandomPlayer(Player.BLACK);
		
		Move move;
		while (true) {
			
			move = player1.getMove(board);
			board = board.move(move);
			
			System.out.println(board);
			
			move = player2.getMove(board);
			board = board.move(move);
			
			System.out.println(board);
			
		}
		
	}
	
}
