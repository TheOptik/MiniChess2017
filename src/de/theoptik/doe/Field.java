package de.theoptik.doe;

import de.theoptik.doe.pieces.Figure;

public class Field {

  protected Figure figure;

  public Field(Figure figure) {
    super();
    this.figure = figure;
  }

  @Override
  public String toString() {
    if (figure != null) {
      return "<" + figure.toString() + ">";
    } else {
      return "<null>";
    }
  }

  public Figure getFigure() {
    return figure;
  }

  public void setFigure(Figure figure) {
    this.figure = figure;
  }

}
