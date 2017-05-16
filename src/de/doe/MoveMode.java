package de.doe;

public class MoveMode {
	
	public static final int CAPUTRE_MODE_NO = 0;
	public static final int CAPUTRE_MODE_CAN = 1;
	public static final int CAPUTRE_MODE_MUST = 2;
	
	public int columnDirection;
	public int rowDirection;
	public boolean oneStep;
	public int catureMode;
	public boolean symetric;
	
	public MoveMode(int columnDirection, int rowDirection, boolean oneStep, int catureMode, boolean symetric) {
		super();
		this.columnDirection = columnDirection;
		this.rowDirection = rowDirection;
		this.oneStep = oneStep;
		this.catureMode = catureMode;
		this.symetric = symetric;
	}
	
}
