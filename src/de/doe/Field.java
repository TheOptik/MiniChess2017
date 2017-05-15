package de.doe;

import de.doe.figures.Figure;

public class Field {
	
	protected Figure figure;
	protected FieldColor color;
	
	public Field(Figure figure, FieldColor color) {
		super();
		this.figure = figure;
		this.color = color;
	}
	
}
