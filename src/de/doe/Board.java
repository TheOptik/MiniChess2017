package de.doe;

import java.io.BufferedReader;
import java.io.PrintWriter;

import de.doe.figures.Player;

public class Board {
	
	protected Field[][] board = new Field[5][6];
	protected Player activePlayer;
	
	public Board() {
		
	}
	
	public Board(String board) {
		// TODO Auto-generated constructor stub
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
	
	public Field getField(int x, int y){
    
	  return board[y][x];
	}
}
