package de.doe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import de.doe.figures.Figure;

public class Board {
	
	protected Field[][] fields = new Field[5][6];
	protected Player activePlayer;
	protected int numberOfMoves;
	
	protected boolean isGameOver = false; // save
	protected boolean isDraw = false; // save
	protected Player winner; // save
	
	protected List<Figure> whiteFigures = new ArrayList<>();
	protected List<Figure> blackFigures = new ArrayList<>();
	
	private Stack<BoardState> previousStates = new Stack<>(); // this is NOT
																// threadSafe
	
	public Board() {
		initalizeField();
		activePlayer = Player.WHITE;
		numberOfMoves = 1;
		
		fields[0][0].figure = Figure.BLACK_KING;
		blackFigures.add(Figure.BLACK_KING);
		fields[1][0].figure = Figure.BLACK_QUEEN;
		blackFigures.add(Figure.BLACK_QUEEN);
		fields[2][0].figure = Figure.BLACK_BISHOP;
		blackFigures.add(Figure.BLACK_BISHOP);
		fields[3][0].figure = Figure.BLACK_KNIGHT;
		blackFigures.add(Figure.BLACK_KNIGHT);
		fields[4][0].figure = Figure.BLACK_ROOK;
		blackFigures.add(Figure.BLACK_ROOK);
		
		for (int i = 0; i <= 4; i++) {
			fields[i][1].figure = Figure.BLACK_PAWN;
			blackFigures.add(Figure.BLACK_PAWN);
			fields[i][4].figure = Figure.WHITE_PAWN;
			whiteFigures.add(Figure.WHITE_PAWN);
		}
		
		fields[0][5].figure = Figure.WHITE_ROOK;
		whiteFigures.add(Figure.WHITE_ROOK);
		fields[1][5].figure = Figure.WHITE_KNIGHT;
		whiteFigures.add(Figure.WHITE_KNIGHT);
		fields[2][5].figure = Figure.WHITE_BISHOP;
		whiteFigures.add(Figure.WHITE_BISHOP);
		fields[3][5].figure = Figure.WHITE_QUEEN;
		whiteFigures.add(Figure.WHITE_QUEEN);
		fields[4][5].figure = Figure.WHITE_KING;
		whiteFigures.add(Figure.WHITE_KING);
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
		numberOfMoves = Integer.parseInt(firstLine[0]);
		activePlayer = Player.fromChar(firstLine[1].charAt(0));
		
		for (int i = 1; i < lines.length; i++) {
			char[] charLine = lines[i].toCharArray();
			for (int j = 0; j < charLine.length; j++) {
				switch (charLine[j]) {
				case Figure.BLACK_PAWN_CODE:
					this.fields[j][i - 1].figure = Figure.BLACK_PAWN;
					blackFigures.add(Figure.BLACK_PAWN);
					break;
				case Figure.WHITE_PAWN_CODE:
					this.fields[j][i - 1].figure = Figure.WHITE_PAWN;
					whiteFigures.add(Figure.WHITE_PAWN);
					break;
				case Figure.BLACK_ROOK_CODE:
					this.fields[j][i - 1].figure = Figure.BLACK_ROOK;
					blackFigures.add(Figure.BLACK_ROOK);
					break;
				case Figure.WHITE_ROOK_CODE:
					this.fields[j][i - 1].figure = Figure.WHITE_ROOK;
					whiteFigures.add(Figure.WHITE_ROOK);
					break;
				case Figure.BLACK_KNIGHT_CODE:
					this.fields[j][i - 1].figure = Figure.BLACK_KNIGHT;
					blackFigures.add(Figure.BLACK_KNIGHT);
					break;
				case Figure.WHITE_KNIGHT_CODE:
					this.fields[j][i - 1].figure = Figure.WHITE_KNIGHT;
					whiteFigures.add(Figure.WHITE_KNIGHT);
					break;
				case Figure.BLACK_BISHOP_CODE:
					this.fields[j][i - 1].figure = Figure.BLACK_BISHOP;
					blackFigures.add(Figure.BLACK_BISHOP);
					break;
				case Figure.WHITE_BISHOP_CODE:
					this.fields[j][i - 1].figure = Figure.WHITE_BISHOP;
					whiteFigures.add(Figure.WHITE_BISHOP);
					break;
				case Figure.BLACK_QUEEN_CODE:
					this.fields[j][i - 1].figure = Figure.BLACK_QUEEN;
					blackFigures.add(Figure.BLACK_QUEEN);
					break;
				case Figure.WHITE_QUEEN_CODE:
					this.fields[j][i - 1].figure = Figure.WHITE_QUEEN;
					whiteFigures.add(Figure.WHITE_QUEEN);
					break;
				case Figure.BLACK_KING_CODE:
					this.fields[j][i - 1].figure = Figure.BLACK_KING;
					blackFigures.add(Figure.BLACK_KING);
					break;
				case Figure.WHITE_KING_CODE:
					this.fields[j][i - 1].figure = Figure.WHITE_KING;
					whiteFigures.add(Figure.WHITE_KING);
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
			this.isGameOver = true;
			this.winner = activePlayer.other();
			return this;
		} else {
			previousStates.push(new BoardState(isGameOver, isDraw, winner, fields[move.to.x][move.to.y].figure));
		}
		
		if (move.player.equals(activePlayer)) {
			Figure fig = this.fields[move.from.x][move.from.y].figure;
			this.fields[move.from.x][move.from.y].figure = null;
			if (this.fields[move.to.x][move.to.y].figure != null
					&& (this.fields[move.to.x][move.to.y].figure.equals(Figure.WHITE_KING)
							|| this.fields[move.to.x][move.to.y].figure.equals(Figure.BLACK_KING))) {
				this.isGameOver = true;
				this.winner = activePlayer;
			}
			this.getAllFiguresForPlayer(activePlayer.other()).remove(this.fields[move.to.x][move.to.y].figure);
			this.fields[move.to.x][move.to.y].figure = fig;
			
			this.activePlayer = activePlayer.other();
			this.numberOfMoves++;
			if (this.numberOfMoves >= 80) {
				this.isDraw = true;
			}
			
			return this;
		} else {
			throw new IllegalArgumentException("It is not " + move.player + "'s turn!");
		}
	}
	
	public Board undoMove(Move move) {
		
		BoardState previousState = previousStates.pop();
		
		isGameOver = previousState.isGameOver;
		isDraw = previousState.isDraw;
		winner = previousState.winner;
		numberOfMoves--;
		activePlayer = activePlayer.other();
		
		fields[move.from.x][move.from.y].figure = fields[move.to.x][move.to.y].figure;
		fields[move.to.x][move.to.y].figure = previousState.capturedFigure;
		if (previousState.capturedFigure != null) {
			getAllFiguresForPlayer(previousState.capturedFigure.getPlayer()).add(previousState.capturedFigure);
		}
		
		return this;
		
	}
	
	@Override
	public String toString() {
		StringBuilder resultBuilder = new StringBuilder();
		
		resultBuilder.append(numberOfMoves).append(" ").append(activePlayer.toChar()).append(System.lineSeparator());
		
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
	
	public List<Figure> getAllFiguresForPlayer(Player player) {
		if (player.equals(Player.WHITE)) {
			return whiteFigures;
		} else {
			return blackFigures;
		}
	}
	
	public Field getField(int x, int y) {
		
		return fields[x][y];
	}
	
	public boolean isGameOver() {
		return isGameOver;
	}
	
	public Player getWinner() {
		return winner;
	}
	
	public Player getActivePlayer() {
		return activePlayer;
	}
	
	private class BoardState {
		boolean isGameOver;
		boolean isDraw;
		Player winner;
		Figure capturedFigure;
		
		public BoardState(boolean isGameOver, boolean isDraw, Player winner, Figure capturedFigure) {
			super();
			this.isGameOver = isGameOver;
			this.isDraw = isDraw;
			this.winner = winner;
			this.capturedFigure = capturedFigure;
		}
		
	}
	
}
