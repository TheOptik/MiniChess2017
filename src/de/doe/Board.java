package de.doe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import de.doe.figures.Figure;

public class Board {
	
	protected Field[][] fields = new Field[5][6];
	protected Player activePlayer;
	protected int turn;
	
	protected boolean isGameOver = false;
	protected boolean isDraw = false;
	protected Player winner;
	
	public Board() {
		initalizeField();
		activePlayer = Player.WHITE;
		turn = 1;
		
		fields[0][0].figure = Figure.BLACK_KING;
		fields[1][0].figure = Figure.BLACK_QUEEN;
		fields[2][0].figure = Figure.BLACK_BISHOP;
		fields[3][0].figure = Figure.BLACK_KNIGHT;
		fields[4][0].figure = Figure.BLACK_ROOK;
		
		for (int i = 0; i <= 4; i++) {
			fields[i][1].figure = Figure.BLACK_PAWN;
			fields[i][4].figure = Figure.WHITE_PAWN;
		}
		
		fields[0][5].figure = Figure.WHITE_ROOK;
		fields[1][5].figure = Figure.WHITE_KNIGHT;
		fields[2][5].figure = Figure.WHITE_BISHOP;
		fields[3][5].figure = Figure.WHITE_QUEEN;
		fields[4][5].figure = Figure.WHITE_KING;
		
	}
	
	public Board(String board) {
		initalizeField();
		initializeFigure(board);
	}
	
	public Board(BufferedReader reader) {
		initalizeField();
		StringBuilder board = new StringBuilder();
		String line;
		
		try {
			do {
				line = reader.readLine();
				if (line != null) {
					board.append(line).append(System.lineSeparator());
				}
			} while (reader.ready() && line != null);
			initializeFigure(board.toString().trim());
			
		} catch (IOException e) {
			org.apache.log4j.Logger.getRootLogger().fatal("Could not read board", e);
		}
	}
	
	private Board(Board board) {
		
		this.fields = Arrays.copyOf(board.fields, board.fields.length);
		this.activePlayer = board.activePlayer;
		this.turn = board.turn;
		
	}
	
	private void initalizeField() {
		for (int x = 0; x < fields.length; x++) {
			for (int y = 0; y < fields[0].length; y++) {
				fields[x][y] = new Field(null);
			}
		}
	}
	
	private void initializeFigure(String board) {
		String[] lines = board.split(System.lineSeparator());
		String[] firstLine = lines[0].split(" ");
		turn = Integer.parseInt(firstLine[0]);
		activePlayer = Player.fromChar(firstLine[1].charAt(0));
		
		for (int i = 1; i < lines.length; i++) {
			char[] charLine = lines[i].toCharArray();
			for (int j = 0; j < charLine.length; j++) {
				switch (charLine[j]) {
				case Figure.BLACK_PAWN_CODE:
					this.fields[j][i - 1].figure = Figure.BLACK_PAWN;
					break;
				case Figure.WHITE_PAWN_CODE:
					this.fields[j][i - 1].figure = Figure.WHITE_PAWN;
					break;
				case Figure.BLACK_ROOK_CODE:
					this.fields[j][i - 1].figure = Figure.BLACK_ROOK;
					break;
				case Figure.WHITE_ROOK_CODE:
					this.fields[j][i - 1].figure = Figure.WHITE_ROOK;
					break;
				case Figure.BLACK_KNIGHT_CODE:
					this.fields[j][i - 1].figure = Figure.BLACK_KNIGHT;
					break;
				case Figure.WHITE_KNIGHT_CODE:
					this.fields[j][i - 1].figure = Figure.WHITE_KNIGHT;
					break;
				case Figure.BLACK_BISHOP_CODE:
					this.fields[j][i - 1].figure = Figure.BLACK_BISHOP;
					break;
				case Figure.WHITE_BISHOP_CODE:
					this.fields[j][i - 1].figure = Figure.WHITE_BISHOP;
					break;
				case Figure.BLACK_QUEEN_CODE:
					this.fields[j][i - 1].figure = Figure.BLACK_QUEEN;
					break;
				case Figure.WHITE_QUEEN_CODE:
					this.fields[j][i - 1].figure = Figure.WHITE_QUEEN;
					break;
				case Figure.BLACK_KING_CODE:
					this.fields[j][i - 1].figure = Figure.BLACK_KING;
					break;
				case Figure.WHITE_KING_CODE:
					this.fields[j][i - 1].figure = Figure.WHITE_KING;
					break;
				case Figure.NONE_CODE:
					this.fields[j][i - 1].figure = null;
					break;
				default:
					this.fields[j][i - 1].figure = null;
				}
			}
			
		}
	}
	
	public Board move(Move move) {
		if (move == null) {
			isGameOver = true;
			winner = activePlayer.other();
			return this;
		}
		if (move.player.equals(activePlayer)) {
			Board result = new Board(this);
			Figure fig = result.fields[move.from.x][move.from.y].figure;
			result.fields[move.from.x][move.from.y].figure = null;
			if (result.fields[move.to.x][move.to.y].figure != null
					&& (result.fields[move.to.x][move.to.y].figure.equals(Figure.WHITE_KING)
							|| result.fields[move.to.x][move.to.y].figure.equals(Figure.BLACK_KING))) {
				result.isGameOver = true;
				result.winner = activePlayer;
			}
			result.fields[move.to.x][move.to.y].figure = fig;
			
			result.activePlayer = activePlayer.other();
			result.turn++;
			if (result.turn >= 40) {
				result.isDraw = true;
			}
			
			return result;
		} else {
			throw new IllegalArgumentException("It is not " + move.player + "'s turn!");
		}
	}
	
	@Override
	public String toString() {
		StringBuilder resultBuilder = new StringBuilder();
		
		resultBuilder.append(turn).append(" ").append(activePlayer.toChar()).append(System.lineSeparator());
		
		for (int y = 0; y < fields[0].length; y++) {
			for (int x = 0; x < fields.length; x++) {
				Field field = fields[x][y];
				if (field.figure != null) {
					resultBuilder.append(field.figure.toString());
				} else {
					resultBuilder.append('.');
				}
			}
			resultBuilder.append(System.lineSeparator());
		}
		
		return resultBuilder.toString();
	}
	
	public void print(PrintWriter writer) {
		writer.print(this.toString());
	}
	
	public Field getField(int x, int y) {
		
		return fields[x][y];
	}
	
	public boolean isGameOver() {
		return isGameOver;
	}
}
