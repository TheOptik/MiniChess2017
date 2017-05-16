package de.doe;

import java.util.function.Consumer;

public interface ScanInterface {

  void scan(Coordinate startPosition, MoveMode moveMode, Consumer<Move> callback );
}
