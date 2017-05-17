package de.doe.heuristics;

import static org.junit.Assert.*;

import org.junit.Test;

import de.doe.Board;
import de.doe.Player;
import de.doe.TestUtils;
import heuristics.StateEvaluator;

public class StateEvaluatorTest {


  @Test
  public void evaluationPawnVsKing() throws Exception {

    Board board = new Board(
        TestUtils.getMultilineString("1 W", ".K...", ".....", ".....", ".....", ".....", ".p..."));
    Board board1 = new Board(
        TestUtils.getMultilineString("1 W", ".k...", ".....", ".....", ".....", ".....", ".P..."));
    Board board2 = new Board(
        TestUtils.getMultilineString("1 B", ".K...", ".....", ".....", ".....", ".....", ".p..."));
    Board board3 = new Board(
        TestUtils.getMultilineString("1 B", ".k...", ".....", ".....", ".....", ".....", ".P..."));
    StateEvaluator evalW = new StateEvaluator(Player.WHITE);
    StateEvaluator evalB = new StateEvaluator(Player.BLACK);

    assertEquals(99, evalW.evaluate(board));
    assertEquals(-99, evalW.evaluate(board1));
    assertEquals(-99, evalB.evaluate(board2));
    assertEquals(99, evalB.evaluate(board3));
  }

  @Test
  public void evaluationPawnVsQueen() throws Exception {

    Board board = new Board(
        TestUtils.getMultilineString("1 W", ".Q...", ".....", ".....", ".....", ".....", ".p..."));
    Board board1 = new Board(
        TestUtils.getMultilineString("1 W", ".q...", ".....", ".....", ".....", ".....", ".P..."));
    Board board2 = new Board(
        TestUtils.getMultilineString("1 B", ".Q...", ".....", ".....", ".....", ".....", ".p..."));
    Board board3 = new Board(
        TestUtils.getMultilineString("1 B", ".q...", ".....", ".....", ".....", ".....", ".P..."));
    StateEvaluator evalW = new StateEvaluator(Player.WHITE);
    StateEvaluator evalB = new StateEvaluator(Player.BLACK);

    assertEquals(8, evalW.evaluate(board));
    assertEquals(-8, evalW.evaluate(board1));
    assertEquals(-8, evalB.evaluate(board2));
    assertEquals(8, evalB.evaluate(board3));
  }  
  
  @Test
  public void evaluationPawnVSBishop() throws Exception {

    Board board = new Board(
        TestUtils.getMultilineString("1 W", ".B...", ".....", ".....", ".....", ".....", ".p..."));
    Board board1 = new Board(
        TestUtils.getMultilineString("1 W", ".b...", ".....", ".....", ".....", ".....", ".P..."));
    Board board2 = new Board(
        TestUtils.getMultilineString("1 B", ".B...", ".....", ".....", ".....", ".....", ".p..."));
    Board board3 = new Board(
        TestUtils.getMultilineString("1 B", ".b...", ".....", ".....", ".....", ".....", ".P..."));
    StateEvaluator evalW = new StateEvaluator(Player.WHITE);
    StateEvaluator evalB = new StateEvaluator(Player.BLACK);

    assertEquals(2, evalW.evaluate(board));
    assertEquals(-2, evalW.evaluate(board1));
    assertEquals(-2, evalB.evaluate(board2));
    assertEquals(2, evalB.evaluate(board3));
  }
  
  @Test
  public void evaluationPawnVsKnight() throws Exception {

    Board board = new Board(
        TestUtils.getMultilineString("1 W", ".N...", ".....", ".....", ".....", ".....", ".p..."));
    Board board1 = new Board(
        TestUtils.getMultilineString("1 W", ".n...", ".....", ".....", ".....", ".....", ".P..."));
    Board board2 = new Board(
        TestUtils.getMultilineString("1 B", ".N...", ".....", ".....", ".....", ".....", ".p..."));
    Board board3 = new Board(
        TestUtils.getMultilineString("1 B", ".n...", ".....", ".....", ".....", ".....", ".P..."));
    StateEvaluator evalW = new StateEvaluator(Player.WHITE);
    StateEvaluator evalB = new StateEvaluator(Player.BLACK);

    assertEquals(2, evalW.evaluate(board));
    assertEquals(-2, evalW.evaluate(board1));
    assertEquals(-2, evalB.evaluate(board2));
    assertEquals(2, evalB.evaluate(board3));
  }
  
  @Test
  public void evaluationPawnVsRook() throws Exception {

    Board board = new Board(
        TestUtils.getMultilineString("1 W", ".R...", ".....", ".....", ".....", ".....", ".p..."));
    Board board1 = new Board(
        TestUtils.getMultilineString("1 W", ".r...", ".....", ".....", ".....", ".....", ".P..."));
    Board board2 = new Board(
        TestUtils.getMultilineString("1 B", ".R...", ".....", ".....", ".....", ".....", ".p..."));
    Board board3 = new Board(
        TestUtils.getMultilineString("1 B", ".r...", ".....", ".....", ".....", ".....", ".P..."));
    StateEvaluator evalW = new StateEvaluator(Player.WHITE);
    StateEvaluator evalB = new StateEvaluator(Player.BLACK);

    assertEquals(4, evalW.evaluate(board));
    assertEquals(-4, evalW.evaluate(board1));
    assertEquals(-4, evalB.evaluate(board2));
    assertEquals(4, evalB.evaluate(board3));
  }

  @Test
  public void evaluationPawnVsPawn() throws Exception {

    Board board = new Board(
        TestUtils.getMultilineString("1 W", ".P...", ".....", ".....", ".....", ".....", ".p..."));
    Board board1 = new Board(
        TestUtils.getMultilineString("1 W", ".p...", ".....", ".....", ".....", ".....", ".P..."));
    Board board2 = new Board(
        TestUtils.getMultilineString("1 B", ".P...", ".....", ".....", ".....", ".....", ".p..."));
    Board board3 = new Board(
        TestUtils.getMultilineString("1 B", ".p...", ".....", ".....", ".....", ".....", ".P..."));
    StateEvaluator evalW = new StateEvaluator(Player.WHITE);
    StateEvaluator evalB = new StateEvaluator(Player.BLACK);

    assertEquals(0, evalW.evaluate(board));
    assertEquals(0, evalW.evaluate(board1));
    assertEquals(0, evalB.evaluate(board2));
    assertEquals(0, evalB.evaluate(board3));
  }
  
  @Test
  public void evaluationRookVsKing() throws Exception {
    Board board = new Board(
        TestUtils.getMultilineString("1 W", ".K...", ".....", ".....", ".....", ".....", ".r..."));
    Board board1 = new Board(
        TestUtils.getMultilineString("1 W", ".k...", ".....", ".....", ".....", ".....", ".R..."));
    Board board2 = new Board(
        TestUtils.getMultilineString("1 B", ".K...", ".....", ".....", ".....", ".....", ".r..."));
    Board board3 = new Board(
        TestUtils.getMultilineString("1 B", ".k...", ".....", ".....", ".....", ".....", ".R..."));
    StateEvaluator evalW = new StateEvaluator(Player.WHITE);
    StateEvaluator evalB = new StateEvaluator(Player.BLACK);

    assertEquals(95, evalW.evaluate(board));
    assertEquals(-95, evalW.evaluate(board1));
    assertEquals(-95, evalB.evaluate(board2));
    assertEquals(95, evalB.evaluate(board3));
  }
  
  @Test
  public void evaluationRookVsQueen() throws Exception {
    Board board = new Board(
        TestUtils.getMultilineString("1 W", ".Q...", ".....", ".....", ".....", ".....", ".r..."));
    Board board1 = new Board(
        TestUtils.getMultilineString("1 W", ".q...", ".....", ".....", ".....", ".....", ".R..."));
    Board board2 = new Board(
        TestUtils.getMultilineString("1 B", ".Q...", ".....", ".....", ".....", ".....", ".r..."));
    Board board3 = new Board(
        TestUtils.getMultilineString("1 B", ".q...", ".....", ".....", ".....", ".....", ".R..."));
    StateEvaluator evalW = new StateEvaluator(Player.WHITE);
    StateEvaluator evalB = new StateEvaluator(Player.BLACK);

    assertEquals(4, evalW.evaluate(board));
    assertEquals(-4, evalW.evaluate(board1));
    assertEquals(-4, evalB.evaluate(board2));
    assertEquals(4, evalB.evaluate(board3));
  }

  @Test
  public void evaluationRookVsBishop() throws Exception {
    Board board = new Board(
        TestUtils.getMultilineString("1 W", ".B...", ".....", ".....", ".....", ".....", ".r..."));
    Board board1 = new Board(
        TestUtils.getMultilineString("1 W", ".b...", ".....", ".....", ".....", ".....", ".R..."));
    Board board2 = new Board(
        TestUtils.getMultilineString("1 B", ".B...", ".....", ".....", ".....", ".....", ".r..."));
    Board board3 = new Board(
        TestUtils.getMultilineString("1 B", ".b...", ".....", ".....", ".....", ".....", ".R..."));
    StateEvaluator evalW = new StateEvaluator(Player.WHITE);
    StateEvaluator evalB = new StateEvaluator(Player.BLACK);

    assertEquals(-2, evalW.evaluate(board));
    assertEquals(2, evalW.evaluate(board1));
    assertEquals(2, evalB.evaluate(board2));
    assertEquals(-2, evalB.evaluate(board3));
  }

  @Test
  public void evaluationRookVsKnight() throws Exception {
    Board board = new Board(
        TestUtils.getMultilineString("1 W", ".N...", ".....", ".....", ".....", ".....", ".r..."));
    Board board1 = new Board(
        TestUtils.getMultilineString("1 W", ".n...", ".....", ".....", ".....", ".....", ".R..."));
    Board board2 = new Board(
        TestUtils.getMultilineString("1 B", ".N...", ".....", ".....", ".....", ".....", ".r..."));
    Board board3 = new Board(
        TestUtils.getMultilineString("1 B", ".n...", ".....", ".....", ".....", ".....", ".R..."));
    StateEvaluator evalW = new StateEvaluator(Player.WHITE);
    StateEvaluator evalB = new StateEvaluator(Player.BLACK);

    assertEquals(-2, evalW.evaluate(board));
    assertEquals(2, evalW.evaluate(board1));
    assertEquals(2, evalB.evaluate(board2));
    assertEquals(-2, evalB.evaluate(board3));
  }

  @Test
  public void evaluationRookVsRook() throws Exception {
    Board board = new Board(
        TestUtils.getMultilineString("1 W", ".R...", ".....", ".....", ".....", ".....", ".r..."));
    Board board1 = new Board(
        TestUtils.getMultilineString("1 W", ".r...", ".....", ".....", ".....", ".....", ".R..."));
    Board board2 = new Board(
        TestUtils.getMultilineString("1 B", ".R...", ".....", ".....", ".....", ".....", ".r..."));
    Board board3 = new Board(
        TestUtils.getMultilineString("1 B", ".r...", ".....", ".....", ".....", ".....", ".R..."));
    StateEvaluator evalW = new StateEvaluator(Player.WHITE);
    StateEvaluator evalB = new StateEvaluator(Player.BLACK);

    assertEquals(0, evalW.evaluate(board));
    assertEquals(0, evalW.evaluate(board1));
    assertEquals(0, evalB.evaluate(board2));
    assertEquals(0, evalB.evaluate(board3));
  }


  @Test
  public void evaluationKnightVsKing() throws Exception {
    Board board = new Board(
        TestUtils.getMultilineString("1 W", ".K...", ".....", ".....", ".....", ".....", ".n..."));
    Board board1 = new Board(
        TestUtils.getMultilineString("1 W", ".k...", ".....", ".....", ".....", ".....", ".N..."));
    Board board2 = new Board(
        TestUtils.getMultilineString("1 B", ".K...", ".....", ".....", ".....", ".....", ".n..."));
    Board board3 = new Board(
        TestUtils.getMultilineString("1 B", ".k...", ".....", ".....", ".....", ".....", ".N..."));
    StateEvaluator evalW = new StateEvaluator(Player.WHITE);
    StateEvaluator evalB = new StateEvaluator(Player.BLACK);

    assertEquals(97, evalW.evaluate(board));
    assertEquals(-97, evalW.evaluate(board1));
    assertEquals(-97, evalB.evaluate(board2));
    assertEquals(97, evalB.evaluate(board3));
  }

  @Test
  public void evaluationKnightVsQueen() throws Exception {
    Board board = new Board(
        TestUtils.getMultilineString("1 W", ".Q...", ".....", ".....", ".....", ".....", ".n..."));
    Board board1 = new Board(
        TestUtils.getMultilineString("1 W", ".q...", ".....", ".....", ".....", ".....", ".N..."));
    Board board2 = new Board(
        TestUtils.getMultilineString("1 B", ".Q...", ".....", ".....", ".....", ".....", ".n..."));
    Board board3 = new Board(
        TestUtils.getMultilineString("1 B", ".q...", ".....", ".....", ".....", ".....", ".N..."));
    StateEvaluator evalW = new StateEvaluator(Player.WHITE);
    StateEvaluator evalB = new StateEvaluator(Player.BLACK);

    assertEquals(6, evalW.evaluate(board));
    assertEquals(-6, evalW.evaluate(board1));
    assertEquals(-6, evalB.evaluate(board2));
    assertEquals(6, evalB.evaluate(board3));
  }
  
  @Test
  public void evaluationKnightVsBishop() throws Exception {
    Board board = new Board(
        TestUtils.getMultilineString("1 W", ".B...", ".....", ".....", ".....", ".....", ".n..."));
    Board board1 = new Board(
        TestUtils.getMultilineString("1 W", ".b...", ".....", ".....", ".....", ".....", ".N..."));
    Board board2 = new Board(
        TestUtils.getMultilineString("1 B", ".B...", ".....", ".....", ".....", ".....", ".n..."));
    Board board3 = new Board(
        TestUtils.getMultilineString("1 B", ".b...", ".....", ".....", ".....", ".....", ".N..."));
    StateEvaluator evalW = new StateEvaluator(Player.WHITE);
    StateEvaluator evalB = new StateEvaluator(Player.BLACK);

    assertEquals(0, evalW.evaluate(board));
    assertEquals(0, evalW.evaluate(board1));
    assertEquals(0, evalB.evaluate(board2));
    assertEquals(0, evalB.evaluate(board3));
  }
  
  @Test
  public void evaluationKnightVsKnight() throws Exception {
    Board board = new Board(
        TestUtils.getMultilineString("1 W", ".N...", ".....", ".....", ".....", ".....", ".n..."));
    Board board1 = new Board(
        TestUtils.getMultilineString("1 W", ".n...", ".....", ".....", ".....", ".....", ".N..."));
    Board board2 = new Board(
        TestUtils.getMultilineString("1 B", ".N...", ".....", ".....", ".....", ".....", ".n..."));
    Board board3 = new Board(
        TestUtils.getMultilineString("1 B", ".n...", ".....", ".....", ".....", ".....", ".N..."));
    StateEvaluator evalW = new StateEvaluator(Player.WHITE);
    StateEvaluator evalB = new StateEvaluator(Player.BLACK);

    assertEquals(0, evalW.evaluate(board));
    assertEquals(0, evalW.evaluate(board1));
    assertEquals(0, evalB.evaluate(board2));
    assertEquals(0, evalB.evaluate(board3));
  }

  @Test
  public void evaluationBishopVsKing() throws Exception {
    Board board = new Board(
        TestUtils.getMultilineString("1 W", ".K...", ".....", ".....", ".....", ".....", ".b..."));
    Board board1 = new Board(
        TestUtils.getMultilineString("1 W", ".k...", ".....", ".....", ".....", ".....", ".B..."));
    Board board2 = new Board(
        TestUtils.getMultilineString("1 B", ".K...", ".....", ".....", ".....", ".....", ".b..."));
    Board board3 = new Board(
        TestUtils.getMultilineString("1 B", ".k...", ".....", ".....", ".....", ".....", ".B..."));
    StateEvaluator evalW = new StateEvaluator(Player.WHITE);
    StateEvaluator evalB = new StateEvaluator(Player.BLACK);

    assertEquals(97, evalW.evaluate(board));
    assertEquals(-97, evalW.evaluate(board1));
    assertEquals(-97, evalB.evaluate(board2));
    assertEquals(97, evalB.evaluate(board3));
  }
  
  @Test
  public void evaluationBishopVsQueen() throws Exception {
    Board board = new Board(
        TestUtils.getMultilineString("1 W", ".Q...", ".....", ".....", ".....", ".....", ".b..."));
    Board board1 = new Board(
        TestUtils.getMultilineString("1 W", ".q...", ".....", ".....", ".....", ".....", ".B..."));
    Board board2 = new Board(
        TestUtils.getMultilineString("1 B", ".Q...", ".....", ".....", ".....", ".....", ".b..."));
    Board board3 = new Board(
        TestUtils.getMultilineString("1 B", ".q...", ".....", ".....", ".....", ".....", ".B..."));
    StateEvaluator evalW = new StateEvaluator(Player.WHITE);
    StateEvaluator evalB = new StateEvaluator(Player.BLACK);

    assertEquals(6, evalW.evaluate(board));
    assertEquals(-6, evalW.evaluate(board1));
    assertEquals(-6, evalB.evaluate(board2));
    assertEquals(6, evalB.evaluate(board3));
  }
  
  @Test
  public void evaluationBishopVsBishop() throws Exception {
    Board board = new Board(
        TestUtils.getMultilineString("1 W", ".B...", ".....", ".....", ".....", ".....", ".b..."));
    Board board1 = new Board(
        TestUtils.getMultilineString("1 W", ".b...", ".....", ".....", ".....", ".....", ".B..."));
    Board board2 = new Board(
        TestUtils.getMultilineString("1 B", ".B...", ".....", ".....", ".....", ".....", ".b..."));
    Board board3 = new Board(
        TestUtils.getMultilineString("1 B", ".b...", ".....", ".....", ".....", ".....", ".B..."));
    StateEvaluator evalW = new StateEvaluator(Player.WHITE);
    StateEvaluator evalB = new StateEvaluator(Player.BLACK);

    assertEquals(0, evalW.evaluate(board));
    assertEquals(0, evalW.evaluate(board1));
    assertEquals(0, evalB.evaluate(board2));
    assertEquals(0, evalB.evaluate(board3));
  }
  
  @Test
  public void evaluationQueenVsKing() throws Exception {
    Board board = new Board(
        TestUtils.getMultilineString("1 W", ".K...", ".....", ".....", ".....", ".....", ".q..."));
    Board board1 = new Board(
        TestUtils.getMultilineString("1 W", ".k...", ".....", ".....", ".....", ".....", ".Q..."));
    Board board2 = new Board(
        TestUtils.getMultilineString("1 B", ".K...", ".....", ".....", ".....", ".....", ".q..."));
    Board board3 = new Board(
        TestUtils.getMultilineString("1 B", ".k...", ".....", ".....", ".....", ".....", ".Q..."));
    StateEvaluator evalW = new StateEvaluator(Player.WHITE);
    StateEvaluator evalB = new StateEvaluator(Player.BLACK);

    assertEquals(91, evalW.evaluate(board));
    assertEquals(-91, evalW.evaluate(board1));
    assertEquals(-91, evalB.evaluate(board2));
    assertEquals(91, evalB.evaluate(board3));
  }
  
  @Test
  public void evaluationQueenVsQueen() throws Exception {
    Board board = new Board(
        TestUtils.getMultilineString("1 W", ".Q...", ".....", ".....", ".....", ".....", ".q..."));
    Board board1 = new Board(
        TestUtils.getMultilineString("1 W", ".q...", ".....", ".....", ".....", ".....", ".Q..."));
    Board board2 = new Board(
        TestUtils.getMultilineString("1 B", ".Q...", ".....", ".....", ".....", ".....", ".q..."));
    Board board3 = new Board(
        TestUtils.getMultilineString("1 B", ".q...", ".....", ".....", ".....", ".....", ".Q..."));
    StateEvaluator evalW = new StateEvaluator(Player.WHITE);
    StateEvaluator evalB = new StateEvaluator(Player.BLACK);

    assertEquals(0, evalW.evaluate(board));
    assertEquals(0, evalW.evaluate(board1));
    assertEquals(0, evalB.evaluate(board2));
    assertEquals(0, evalB.evaluate(board3));
  }
  
  @Test
  public void evaluationKingVsKing() throws Exception {
    Board board = new Board(
        TestUtils.getMultilineString("1 W", ".K...", ".....", ".....", ".....", ".....", ".k..."));
    Board board1 = new Board(
        TestUtils.getMultilineString("1 W", ".k...", ".....", ".....", ".....", ".....", ".K..."));
    Board board2 = new Board(
        TestUtils.getMultilineString("1 B", ".K...", ".....", ".....", ".....", ".....", ".k..."));
    Board board3 = new Board(
        TestUtils.getMultilineString("1 B", ".k...", ".....", ".....", ".....", ".....", ".K..."));
    StateEvaluator evalW = new StateEvaluator(Player.WHITE);
    StateEvaluator evalB = new StateEvaluator(Player.BLACK);

    assertEquals(0, evalW.evaluate(board));
    assertEquals(0, evalW.evaluate(board1));
    assertEquals(0, evalB.evaluate(board2));
    assertEquals(0, evalB.evaluate(board3));
  }
}
