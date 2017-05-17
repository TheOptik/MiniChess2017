package de.doe;

import java.io.IOException;

import de.doe.players.AbstractPlayer;
import de.doe.players.Client;
import de.doe.players.HeuristicPlayer;
import de.doe.players.RandomPlayer;

public class MiniChessLauncher {
	
	public static void main(String[] args) throws InterruptedException {
		
		//playRandom();
		// playOnline();
		playRandomVSHeuristic();
		
	}
	
	private static void playRandomVSHeuristic() {
		
		Board board = new Board();
		
		AbstractPlayer player1 = new HeuristicPlayer(Player.WHITE);
		AbstractPlayer player2 = new RandomPlayer(Player.BLACK);
		
		Move move;
		System.out.println(board);
		while (!board.isGameOver() && !board.isDraw) {
			
			move = player1.getMove(board);
			board = board.move(move);
			
			System.out.println(board);
			if (board.isGameOver() || board.isDraw) {
				break;
			}
			
			move = player2.getMove(board);
			board = board.move(move);
			
			System.out.println(board);
			
		}
		System.out.println(board.winner + " won.");
		
	}
	
	private static void playOnline() throws InterruptedException {
		
		String id = "13444";
		
		Board board = new Board();
		Move move;
		
		try {
			Client client = new Client("imcs.svcs.cs.pdx.edu", "3589", "doe", "123456");
			
			char color = client.accept(id, '?');
			Player botPlayer = Player.fromChar(color);
			RandomPlayer bot = new RandomPlayer(botPlayer);
			Player remotePlayer = botPlayer.other();
			
			System.out.println("REMOTE: " + remotePlayer);
			System.out.println("ME: " + botPlayer);
			
			if (remotePlayer.equals(Player.WHITE)) {
				move = new Move(client.getMove().trim(), remotePlayer);
				board = board.move(move);
			}
			
			while (!board.isGameOver() && !board.isDraw) {
				
				move = bot.getMove(board);
				System.out.println("sending move: " + move.toChessString());
				System.out.println("for board:" + System.lineSeparator() + board);
				board = board.move(move);
				System.out.println("after the move the board was:" + System.lineSeparator() + board);
				System.out.println("______________________________________");
				client.sendMove(move.toChessString());
				
				if (board.isGameOver() || board.isDraw) {
					break;
				}
				
				move = new Move(client.getMove().trim(), remotePlayer);
				System.out.println("BOT MOVE:" + move);
				System.out.println("______________________________________");
				board = board.move(move);
				
			}
			System.out.println(board.winner + " won.");
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
		while (!board.isGameOver() && !board.isDraw) {
			
			move = player1.getMove(board);
			board = board.move(move);
			
			System.out.println(board);
			if (board.isGameOver() || board.isDraw) {
				break;
			}
			
			move = player2.getMove(board);
			board = board.move(move);
			
			System.out.println(board);
			
		}
		System.out.println(board.winner + " won.");
	}
	
	public static String getMultilineString(String... strings) {
		StringBuilder resultBuilder = new StringBuilder();
		for (String s : strings) {
			resultBuilder.append(s).append(System.lineSeparator());
		}
		return resultBuilder.toString();
	}
	
}
