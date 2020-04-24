package de.theoptik.doe.players;

import java.io.IOException;
import java.io.StringReader;
import java.util.Scanner;

import de.theoptik.doe.Board;
import de.theoptik.doe.Move;
import de.theoptik.doe.Player;

public class ServerPlayer extends AbstractPlayer {

	private Client client;

	public ServerPlayer(Player player) {
		super(player);
		try {
			client = new Client("imcs.svcs.cs.pdx.edu", "3589", "doe", "123456");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String getMove() {
		try {
			return client.getMove();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public String listAllAvailableGames() {
		client.send("list", false);
		try {
			Thread.sleep(800);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		StringBuilder resultBuilder = new StringBuilder();
		try {
			while (client.in.ready()) {

				resultBuilder.append(client.in.readLine()).append(System.lineSeparator());

			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return resultBuilder.toString();

	}

	public String getIdOfFirstFreeGame() {
		Scanner scanner = new Scanner(new StringReader(listAllAvailableGames().split(System.lineSeparator())[1]));
		int result = scanner.nextInt();
		scanner.close();
		return Integer.toString(result);
	}

	public void accept(String id, char color) {
		try {
			client.accept(id, color);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Move getMove(Board board) {
		// TODO Auto-generated method stub
		return null;
	}

}
