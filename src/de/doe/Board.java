package de.doe;

import java.io.BufferedReader;
import java.io.PrintWriter;

import de.doe.figures.Figure;

public class Board {
	
	protected Field[][] board = new Field[5][6];
	protected Player activePlayer;
	protected int turn = 1;
	
	public Board() {
		activePlayer = Player.WHITE;
		
		board[0][0].figure = Figure.BLACK_KING;
		board[0][1].figure = Figure.BLACK_QUEEN;
		board[0][2].figure = Figure.BLACK_BISHOP;
		board[0][3].figure = Figure.BLACK_KNIGHT;
		board[0][4].figure = Figure.BLACK_ROOK;
		
		for (int i = 0; i <= 4; i++) {
			board[1][i].figure = Figure.BLACK_PAWN;
			board[4][i].figure = Figure.WHITE_PAWN;
		}
		
		board[5][0].figure = Figure.WHITE_ROOK;
		board[5][1].figure = Figure.WHITE_KNIGHT;
		board[5][2].figure = Figure.WHITE_BISHOP;
		board[5][3].figure = Figure.WHITE_QUEEN;
		board[5][4].figure = Figure.WHITE_KING;
		
	}
	
	public Board(String board) {
		String[] lines = board.split(System.lineSeparator());
	}
	
	public Board(BufferedReader reader) {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	public void print(PrintWriter writer) {
		// TODO Auto-generated method stub
	}
	
	public Field getField(int x, int y) {
		
		return board[y][x];
	}
}
