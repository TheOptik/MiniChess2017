package de.doe;

import java.io.IOException;

import de.doe.players.AbstractPlayer;
import de.doe.players.Client;
import de.doe.players.RandomPlayer;

public class MiniChessLauncher {
	
	public static void main(String[] args) {
		
		// playRandom();
		playOnline();
		
	}
	
	private static void playOnline() {
		
		String id = "12987";
		Board board = new Board();
		Move move;
		
		try {
			Client client = new Client("imcs.svcs.cs.pdx.edu", "3589", "doe", "123456");
			
			char color = client.accept(id, '?');
			Player remotePlayer = Player.fromChar(color);
			
			RandomPlayer bot = new RandomPlayer(remotePlayer.equals(Player.WHITE) ? Player.BLACK : Player.WHITE);
			
			if (remotePlayer.equals(Player.WHITE)) {
				move = new Move(client.getMove().trim(), remotePlayer);
				board = board.move(move);
			}
			
			while (true) {
				
				move = bot.getMove(board);
				board = board.move(move);
				client.sendMove(move.toChessString());
				
				System.out.println(board);
				
				move = new Move(client.getMove().trim(), remotePlayer);
				board = board.move(move);
				
				System.out.println(board);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void playRandom() {
		Board board = new Board();
		
		AbstractPlayer player1 = new RandomPlayer(Player.WHITE);
		AbstractPlayer player2 = new RandomPlayer(Player.BLACK);
		
		Move move;
		System.out.println(board);
		while (true) {
			
			move = player1.getMove(board);
			board = board.move(move);
			
			System.out.println(board);
			
			move = player2.getMove(board);
			board = board.move(move);
			
			System.out.println(board);
			
		}
	}
	
	public static String getMultilineString(String... strings) {
		StringBuilder resultBuilder = new StringBuilder();
		for (String s : strings) {
			resultBuilder.append(s).append(System.lineSeparator());
		}
		return resultBuilder.toString();
	}
	
}