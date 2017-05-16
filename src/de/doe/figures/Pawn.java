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
    moveModesBlack.add(new MoveMode(-1, -1, true, MoveMode.CAPUTRE_MODE_MUST,false));
    moveModesBlack.add(new MoveMode(0, -1, true, MoveMode.CAPUTRE_MODE_NO,false));
    moveModesBlack.add(new MoveMode(1, -1, true, MoveMode.CAPUTRE_MODE_MUST,false));
  
    moveModesWhite = new ArrayList<>();
    moveModesWhite.add(new MoveMode(-1, 1, true, MoveMode.CAPUTRE_MODE_MUST,false));
    moveModesWhite.add(new MoveMode(0, 1, true, MoveMode.CAPUTRE_MODE_NO,false));
    moveModesWhite.add(new MoveMode(1, 1, true, MoveMode.CAPUTRE_MODE_MUST,false));
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
