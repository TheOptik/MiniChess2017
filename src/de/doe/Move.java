package de.doe;

public class Move {
	
	Player player;
	Coordinate from;
	Coordinate to;
	
	public Move(String move, Player player) {
		move = move.toLowerCase();
		this.player = player;
		
		String[] parts = move.split("-");
		
		from = new Coordinate(5 - (parts[0].charAt(0) - 'a'), parts[0].charAt(1) - '1');
		to = new Coordinate(5 - (parts[1].charAt(0) - 'a'), parts[1].charAt(1) - '1');
		
	}
	
	@Override
	public String toString() {
		return "From: " + from.toString() + " To: " + to.toString();
	}
}
