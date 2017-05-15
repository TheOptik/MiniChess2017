package de.doe;

public class Move {

  Field from;
  Field to;
  
  public Move(String move){
    move = move.toLowerCase();
    
  }
  
  @Override
  public String toString() {
    return "From: " + from + " To: " + to;
  }
}
