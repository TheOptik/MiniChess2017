package de.doe.figures;

import java.util.ArrayList;
import java.util.List;

import de.doe.MoveMode;
import de.doe.Player;

public class King extends Figure {

  private static final List<MoveMode> moveModes;

  static {
    moveModes = new ArrayList<>();
    moveModes.add(new MoveMode(1, 1, true, MoveMode.CAPUTRE_MODE_CAN,true));
    moveModes.add(new MoveMode(0, 1, true, MoveMode.CAPUTRE_MODE_CAN,true));
  }


  public King(Player player) {
    super(player);
  }

  @Override
  public List<MoveMode> getAllMoveModes() {
    return moveModes;
  }

}
