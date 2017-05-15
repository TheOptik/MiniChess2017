package de.doe;

import java.io.BufferedReader;
import java.io.PrintWriter;

import de.doe.figures.Figure;

public class Board {

  protected Field[][] board = new Field[6][5];
  protected Player activePlayer;
  protected int turn;

  public Board() {
    initalizeField();
    activePlayer = Player.WHITE;
    turn = 1;


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

  private void initalizeField() {
    for (int y = 0; y < board.length; y++) {
      for (int x = 0; x < board[0].length; x++) {
        board[y][x] = new Field(null);
      }
    }
  }

  public Board(String board) {
    initalizeField();
    String[] lines = board.split(System.lineSeparator());
    String[] firstLine = lines[0].split("/s");
    turn = Integer.parseInt(firstLine[0]);
    activePlayer = Player.fromChar(firstLine[1].charAt(0));

    for (int i = 1; i < lines.length; i++) {
      char[] charLine = lines[i].toCharArray();
      for (int j = 0; j < charLine.length; j++) {
        switch (charLine[j]) {
          case 'p': this.board[i - 1][j].figure = Figure.BLACK_PAWN; break;
          case 'P': this.board[i - 1][j].figure = Figure.WHITE_PAWN; break;
          case 'r': this.board[i - 1][j].figure = Figure.BLACK_ROOK; break;
          case 'R': this.board[i - 1][j].figure = Figure.WHITE_ROOK; break;
          case 'n': this.board[i - 1][j].figure = Figure.BLACK_KNIGHT; break;
          case 'N': this.board[i - 1][j].figure = Figure.WHITE_KNIGHT; break;
          case 'b': this.board[i - 1][j].figure = Figure.BLACK_BISHOP; break;
          case 'B': this.board[i - 1][j].figure = Figure.WHITE_BISHOP; break;
          case 'q': this.board[i - 1][j].figure = Figure.BLACK_QUEEN; break;
          case 'Q': this.board[i - 1][j].figure = Figure.WHITE_QUEEN; break;
          case 'k': this.board[i - 1][j].figure = Figure.BLACK_KING; break;
          case 'K': this.board[i - 1][j].figure = Figure.WHITE_KING; break;
        }
      }

    }
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
