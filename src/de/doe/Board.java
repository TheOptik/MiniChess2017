package de.doe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import de.doe.figures.Figure;

public class Board {
	
	protected Field[][] fields = new Field[6][5];
	protected Player activePlayer;
	protected int turn;
	
	public Board() {
		initalizeField();
		activePlayer = Player.WHITE;
		turn = 1;
		
		fields[0][0].figure = Figure.BLACK_KING;
		fields[0][1].figure = Figure.BLACK_QUEEN;
		fields[0][2].figure = Figure.BLACK_BISHOP;
		fields[0][3].figure = Figure.BLACK_KNIGHT;
		fields[0][4].figure = Figure.BLACK_ROOK;
		
		for (int i = 0; i <= 4; i++) {
			fields[1][i].figure = Figure.BLACK_PAWN;
			fields[4][i].figure = Figure.WHITE_PAWN;
		}
		
		fields[5][0].figure = Figure.WHITE_ROOK;
		fields[5][1].figure = Figure.WHITE_KNIGHT;
		fields[5][2].figure = Figure.WHITE_BISHOP;
		fields[5][3].figure = Figure.WHITE_QUEEN;
		fields[5][4].figure = Figure.WHITE_KING;
		
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
		for (int y = 0; y < fields.length; y++) {
			for (int x = 0; x < fields[0].length; x++) {
				fields[y][x] = new Field(null);
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
				case 'p':
					this.fields[i - 1][j].figure = Figure.BLACK_PAWN;
					break;
				case 'P':
					this.fields[i - 1][j].figure = Figure.WHITE_PAWN;
					break;
				case 'r':
					this.fields[i - 1][j].figure = Figure.BLACK_ROOK;
					break;
				case 'R':
					this.fields[i - 1][j].figure = Figure.WHITE_ROOK;
					break;
				case 'n':
					this.fields[i - 1][j].figure = Figure.BLACK_KNIGHT;
					break;
				case 'N':
					this.fields[i - 1][j].figure = Figure.WHITE_KNIGHT;
					break;
				case 'b':
					this.fields[i - 1][j].figure = Figure.BLACK_BISHOP;
					break;
				case 'B':
					this.fields[i - 1][j].figure = Figure.WHITE_BISHOP;
					break;
				case 'q':
					this.fields[i - 1][j].figure = Figure.BLACK_QUEEN;
					break;
				case 'Q':
					this.fields[i - 1][j].figure = Figure.WHITE_QUEEN;
					break;
				case 'k':
					this.fields[i - 1][j].figure = Figure.BLACK_KING;
					break;
				case 'K':
					this.fields[i - 1][j].figure = Figure.WHITE_KING;
					break;
				case '.':
					this.fields[i - 1][j].figure = null;
					break;
				default:
					this.fields[i - 1][j].figure = null;
				}
			}
			
		}
	}
	
	public Board move(Move move) {
		
		if (move.player.equals(activePlayer)) {
			Board result = new Board(this);
			Figure fig = result.fields[move.from.y][move.from.x].figure;
			result.fields[move.from.y][move.from.x].figure = null;
			result.fields[move.to.y][move.to.x].figure = fig;
			
			return result;
		} else {
			throw new IllegalArgumentException("It is not " + move.player + "'s turn!");
		}
	}
	
	@Override
	public String toString() {
		return Arrays.deepToString(fields);
	}
	
	public void print(PrintWriter writer) {
		writer.print(this.toString());
	}
	
	public Field getField(int x, int y) {
		
		return fields[y][x];
	}
}
