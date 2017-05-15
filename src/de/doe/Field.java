package de.doe;

import de.doe.figures.Figure;

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
}
