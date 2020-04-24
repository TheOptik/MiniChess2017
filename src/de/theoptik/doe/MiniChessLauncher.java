package de.theoptik.doe;

import java.io.IOException;
import java.util.Random;

import de.theoptik.doe.players.AbstractPlayer;
import de.theoptik.doe.players.Client;
import de.theoptik.doe.players.HeuristicPlayer;
import de.theoptik.doe.players.NegaMaxPlayer;
import de.theoptik.doe.players.RandomPlayer;

public class MiniChessLauncher {

	public static void main(String[] args) throws InterruptedException {

//		playRandom();
		for (int i = 0; i < 10; i++) {
			playOnline(1, true);
		}
		// playRandomVSHeuristic();
		// playNegamaxVSNegaMax();

	}

	private static void playNegamaxVSNegaMax() {
		Board board = new Board();

		AbstractPlayer player1 = new NegaMaxPlayer(Player.WHITE, 1);
		AbstractPlayer player2 = new NegaMaxPlayer(Player.BLACK, 1);

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

	private static void playOnline(int count) {

		int win = 0;

		for (int i = 0; i < count; i++) {

			Board board = new Board();
			Move move;

			boolean playWell = new Random().nextBoolean();

			try {
				String username;
				String password;
				if (playWell) {
					username = "user";
					password = "password";
				} else {
					username = "cpu";
					password = "cpu";
				}
				Client client = new Client("192.168.0.161", "3589", username, password);
				char color;
				if (client.hasOfferings()) {
					String id = Integer.toString(client.getRandomGameId());
					color = client.accept(id, '?');
				} else {
					color = client.offer('?');
				}
				Player botPlayer = Player.fromChar(color);
				AbstractPlayer bot;
				if (playWell) {
					bot = new NegaMaxPlayer(botPlayer, 2);
				} else {
					bot = new RandomPlayer(botPlayer);
				}
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
				System.out.println(board.winner);
				if (botPlayer.equals(board.winner)) {
					System.out.println("we won! :)");
					win++;
				} else {
					System.out.println("the server won. :(");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println(((double) win / (i + 1)) * 100.0 + "%");
		}
		System.out.println(((double) win / count) * 100.0 + "%");

	}

	private static void playOnline(int count, boolean playWell) {

		int win = 0;

		for (int i = 0; i < count; i++) {

			Board board = new Board();
			Move move;

			try {
				String username;
				String password;
				if (playWell) {
					username = "user";
					password = "password";
				} else {
					username = "cpu";
					password = "cpu";
				}
				Client client = new Client("192.168.0.161", "3589", username, password);
				char color;
				if (playWell) {
					String id = Integer.toString(client.getRandomGameId());
					color = client.accept(id, '?');
				} else {
					color = client.offer('?');
				}
				Player botPlayer = Player.fromChar(color);
				AbstractPlayer bot;
				if (playWell) {
					bot = new NegaMaxPlayer(botPlayer, 2);
				} else {
					bot = new RandomPlayer(botPlayer);
				}
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
				System.out.println(board.winner);
				if (botPlayer.equals(board.winner)) {
					System.out.println("we won! :)");
					win++;
				} else {
					System.out.println("the server won. :(");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println(((double) win / (i + 1)) * 100.0 + "%");
		}
		System.out.println(((double) win / count) * 100.0 + "%");

		if (playWell) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
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
