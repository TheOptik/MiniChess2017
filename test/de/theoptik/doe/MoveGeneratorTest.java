package de.theoptik.doe;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import de.theoptik.doe.Board;
import de.theoptik.doe.Move;
import de.theoptik.doe.MoveGenerator;
import de.theoptik.doe.Player;

public class MoveGeneratorTest {

  @Test
  public void generateAllWhitePawnMovesAndCheckSize() throws Exception {
    Board board = new Board(TestUtils.getMultilineString("1 W", ".....", ".....", "..P..", ".....", ".....", "....."));
    MoveGenerator generator = new MoveGenerator(board);
    List<Move> moves = generator.getAllMoves();

    assertEquals(1, moves.size());
  }
  
  @Test
  public void generateAndCheckAllWhitePawnMoves() throws Exception {
    Board board = new Board(TestUtils.getMultilineString("1 W", ".....", ".....", "..P..", ".....", ".....", "....."));
    MoveGenerator generator = new MoveGenerator(board);
    List<Move> moves = generator.getAllMoves();

    assertEquals(1, moves.size());
    
    assertTrue(moves.contains(new Move(Player.WHITE, 2, 2, 2, 1)));
  }

  public void generateAndCheckAllBlackPawnMoves() throws Exception {
    Board board = new Board(TestUtils.getMultilineString("1 B", ".....", ".....", "..p..", ".....", ".....", "....."));
    MoveGenerator generator = new MoveGenerator(board);
    List<Move> moves = generator.getAllMoves();

    assertEquals(1, moves.size());
    
    moves.forEach(System.out::println);
    
    assertTrue(moves.contains(new Move(Player.WHITE, 2, 2, 2, 3)));
  }  
  
  @Test
  public void generateAllRookMovesAndCheckSize() throws Exception {

    Board board = new Board(TestUtils.getMultilineString("1 W", ".....", "..R..", ".....", ".....", "....."));
    MoveGenerator generator = new MoveGenerator(board);
    List<Move> moves = generator.getAllMoves();

    assertEquals(9, moves.size());

  }

  @Test
  public void generateAndCheckAllRookMoves() throws Exception {

    Board board = new Board(TestUtils.getMultilineString("1 W", ".....", ".....", "..R..", ".....", "....."));
    MoveGenerator generator = new MoveGenerator(board);
    List<Move> moves = generator.getAllMoves();
    // TODO vielleicht noch mal überlegen ob es sinnvoll ist
    assertEquals(9, moves.size());

    assertTrue(moves.contains(new Move(Player.WHITE, 2, 2, 2, 5)));
    assertTrue(moves.contains(new Move(Player.WHITE, 2, 2, 2, 4)));
    assertTrue(moves.contains(new Move(Player.WHITE, 2, 2, 2, 3)));
    assertTrue(moves.contains(new Move(Player.WHITE, 2, 2, 0, 2)));
    assertTrue(moves.contains(new Move(Player.WHITE, 2, 2, 1, 2)));
    assertTrue(moves.contains(new Move(Player.WHITE, 2, 2, 3, 2)));
    assertTrue(moves.contains(new Move(Player.WHITE, 2, 2, 4, 2)));
    assertTrue(moves.contains(new Move(Player.WHITE, 2, 2, 2, 1)));
    assertTrue(moves.contains(new Move(Player.WHITE, 2, 2, 2, 0)));

  }

  @Test
  public void generateAllKnightMovesAndCheckSize() throws Exception {
    Board board = new Board(TestUtils.getMultilineString("1 W", ".....", ".....", "..N..", ".....", "....."));
    MoveGenerator generator = new MoveGenerator(board);
    List<Move> moves = generator.getAllMoves();

    assertEquals(8, moves.size());
  }

  @Test
  public void generateAndCheckAllKnightMoves() throws Exception {
    Board board = new Board(TestUtils.getMultilineString("1 W", ".....", ".....", "..N..", ".....", "....."));
    MoveGenerator generator = new MoveGenerator(board);
    List<Move> moves = generator.getAllMoves();

    assertEquals(8, moves.size());

    assertTrue(moves.contains(new Move(Player.WHITE, 2, 2, 1, 4)));
    assertTrue(moves.contains(new Move(Player.WHITE, 2, 2, 3, 4)));
    assertTrue(moves.contains(new Move(Player.WHITE, 2, 2, 0, 3)));
    assertTrue(moves.contains(new Move(Player.WHITE, 2, 2, 4, 3)));
    assertTrue(moves.contains(new Move(Player.WHITE, 2, 2, 0, 1)));
    assertTrue(moves.contains(new Move(Player.WHITE, 2, 2, 4, 1)));
    assertTrue(moves.contains(new Move(Player.WHITE, 2, 2, 1, 0)));
    assertTrue(moves.contains(new Move(Player.WHITE, 2, 2, 3, 0)));
  }

  @Test
  public void generateAllBishopMovesAndCheckSize() throws Exception {
    Board board = new Board(TestUtils.getMultilineString("1 W", ".....", ".....", "..B..", ".....", "....."));
    MoveGenerator generator = new MoveGenerator(board);
    List<Move> moves = generator.getAllMoves();

    assertEquals(12, moves.size());
  }

  @Test
  public void generateAndCheckAllBishopMoves() throws Exception {
    Board board = new Board(TestUtils.getMultilineString("1 W", ".....", ".....", "..B..", ".....", "....."));
    MoveGenerator generator = new MoveGenerator(board);
    List<Move> moves = generator.getAllMoves();

    assertEquals(12, moves.size());

    assertTrue(moves.contains(new Move(Player.WHITE, 2, 2, 0, 4)));
    assertTrue(moves.contains(new Move(Player.WHITE, 2, 2, 4, 4)));
    assertTrue(moves.contains(new Move(Player.WHITE, 2, 2, 1, 3)));
    assertTrue(moves.contains(new Move(Player.WHITE, 2, 2, 2, 3)));
    assertTrue(moves.contains(new Move(Player.WHITE, 2, 2, 3, 3)));
    assertTrue(moves.contains(new Move(Player.WHITE, 2, 2, 1, 2)));
    assertTrue(moves.contains(new Move(Player.WHITE, 2, 2, 3, 2)));
    assertTrue(moves.contains(new Move(Player.WHITE, 2, 2, 1, 1)));
    assertTrue(moves.contains(new Move(Player.WHITE, 2, 2, 2, 1)));
    assertTrue(moves.contains(new Move(Player.WHITE, 2, 2, 3, 1)));
    assertTrue(moves.contains(new Move(Player.WHITE, 2, 2, 0, 0)));
    assertTrue(moves.contains(new Move(Player.WHITE, 2, 2, 4, 0)));
  }

  @Test
  public void generateAllQueensMovesAndCheckSize() throws Exception {
    Board board = new Board(TestUtils.getMultilineString("1 W", ".....", ".....", "..Q..", ".....", "....."));
    MoveGenerator generator = new MoveGenerator(board);
    List<Move> moves = generator.getAllMoves();

    assertEquals(17, moves.size());
  }

  @Test
  public void generateAndCheckAllQueensMoves() throws Exception {
    Board board = new Board(TestUtils.getMultilineString("1 W", ".....", ".....", "..Q..", ".....", ".....","....."));
    MoveGenerator generator = new MoveGenerator(board);
    List<Move> moves = generator.getAllMoves();

    assertEquals(17, moves.size());

    assertTrue(moves.contains(new Move(Player.WHITE, 2, 2, 2, 5)));
    assertTrue(moves.contains(new Move(Player.WHITE, 2, 2, 0, 4)));
    assertTrue(moves.contains(new Move(Player.WHITE, 2, 2, 2, 4)));
    assertTrue(moves.contains(new Move(Player.WHITE, 2, 2, 4, 4)));
    assertTrue(moves.contains(new Move(Player.WHITE, 2, 2, 1, 3)));
    assertTrue(moves.contains(new Move(Player.WHITE, 2, 2, 2, 3)));
    assertTrue(moves.contains(new Move(Player.WHITE, 2, 2, 3, 3)));
    assertTrue(moves.contains(new Move(Player.WHITE, 2, 2, 0, 2)));
    assertTrue(moves.contains(new Move(Player.WHITE, 2, 2, 1, 2)));
    assertTrue(moves.contains(new Move(Player.WHITE, 2, 2, 3, 2)));
    assertTrue(moves.contains(new Move(Player.WHITE, 2, 2, 4, 2)));
    assertTrue(moves.contains(new Move(Player.WHITE, 2, 2, 1, 1)));
    assertTrue(moves.contains(new Move(Player.WHITE, 2, 2, 2, 1)));
    assertTrue(moves.contains(new Move(Player.WHITE, 2, 2, 3, 1)));
    assertTrue(moves.contains(new Move(Player.WHITE, 2, 2, 0, 0)));
    assertTrue(moves.contains(new Move(Player.WHITE, 2, 2, 2, 0)));
    assertTrue(moves.contains(new Move(Player.WHITE, 2, 2, 4, 0)));
  }

  @Test
  public void generateAllKingsMovesAndCheckSize() throws Exception {
    Board board = new Board(TestUtils.getMultilineString("1 W", ".....", ".....", "..K..", ".....", "....."));
    MoveGenerator generator = new MoveGenerator(board);
    List<Move> moves = generator.getAllMoves();

    assertEquals(8, moves.size());
  }

  @Test
  public void generateAndCheckAllKingsMoves() throws Exception {
    Board board = new Board(TestUtils.getMultilineString("1 W", ".....", ".....", "..K..", ".....", "....."));
    MoveGenerator generator = new MoveGenerator(board);
    List<Move> moves = generator.getAllMoves();

    assertEquals(8, moves.size());

    assertTrue(moves.contains(new Move(Player.WHITE, 2, 2, 1, 3)));
    assertTrue(moves.contains(new Move(Player.WHITE, 2, 2, 2, 3)));
    assertTrue(moves.contains(new Move(Player.WHITE, 2, 2, 3, 3)));
    assertTrue(moves.contains(new Move(Player.WHITE, 2, 2, 1, 2)));
    assertTrue(moves.contains(new Move(Player.WHITE, 2, 2, 3, 2)));
    assertTrue(moves.contains(new Move(Player.WHITE, 2, 2, 1, 1)));
    assertTrue(moves.contains(new Move(Player.WHITE, 2, 2, 2, 1)));
    assertTrue(moves.contains(new Move(Player.WHITE, 2, 2, 3, 1)));
  }
  
  @Test
  public void generateAllFiguresMovesAndCheckSize() throws Exception {
    Board board = new Board(TestUtils.getMultilineString("1 W", ".....", ".....", ".....", ".....", "PPPPP", "RNBQK"));
    MoveGenerator generator = new MoveGenerator(board);
    List<Move> moves = generator.getAllMoves();

    
    
    assertEquals(7, moves.size());
  }
  
  public void generateAllGameMovesAndCheckSize() throws Exception {
    Board board = new Board(TestUtils.getMultilineString("2 W", "kqbnr", "ppppp", ".....", ".P...", "PPPPP", "RNBQK"));
    MoveGenerator generator = new MoveGenerator(board);
    List<Move> moves = generator.getAllMoves();
 
    assertEquals(7, moves.size());
  }
}
