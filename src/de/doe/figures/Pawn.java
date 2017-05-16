package de.doe.figures;

import java.util.ArrayList;
import java.util.List;

import de.doe.MoveMode;
import de.doe.Player;

public class Pawn extends Figure {

  private static final List<MoveMode> moveModesBlack;
  private static final List<MoveMode> moveModesWhite;

  static {
    moveModesBlack = new ArrayList<>();
    moveModesBlack.add(new MoveMode(-1, -1, true, MoveMode.CAPUTRE_MODE_MUST));
    moveModesBlack.add(new MoveMode(0, -1, true, MoveMode.CAPUTRE_MODE_NO));
    moveModesBlack.add(new MoveMode(1, -1, true, MoveMode.CAPUTRE_MODE_MUST));
  
    moveModesWhite = new ArrayList<>();
    moveModesWhite.add(new MoveMode(-1, 1, true, MoveMode.CAPUTRE_MODE_MUST));
    moveModesWhite.add(new MoveMode(0, 1, true, MoveMode.CAPUTRE_MODE_NO));
    moveModesWhite.add(new MoveMode(1, 1, true, MoveMode.CAPUTRE_MODE_MUST));
  }


  public Pawn(Player player) {
    super(player);
  }


  @Override
  public List<MoveMode> getAllMoveModes() {
    if (player == Player.WHITE) {
      return moveModesWhite;
    }
    return moveModesBlack;
  }

}
