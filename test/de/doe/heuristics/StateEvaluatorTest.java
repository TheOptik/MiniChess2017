package de.doe.heuristics;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.doe.Board;
import de.doe.Player;
import de.doe.TestUtils;
import heuristics.StateEvaluator;

public class StateEvaluatorTest {
	
	
	@Test
	public void evaluationTest() throws Exception {
		
		Board board = new Board(TestUtils.getMultilineString("1 W",".K...",".....",".....",".....",".....",".p..."));
		StateEvaluator eval = new StateEvaluator(Player.WHITE);
		
		assertEquals(99, eval.evaluate(board));
		
		
	}
	
}
