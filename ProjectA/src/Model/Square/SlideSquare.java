package Model.Square;

import javax.swing.ImageIcon;

import Model.Player.Player;


/**
 * This class creates a new slide square of the board.
 * @author 3964
 */
public class SlideSquare extends Square {

	private boolean occupied;

	
	/**
	 * <Constructor> 
	 * <Postcondition> : creates a new slide square for player p and
	 * sets it's image, with command  super , to parent class Square.
	 * @param image
	 */
	public SlideSquare(Player p, ImageIcon image) {
		super(p, image);
	}

	
	/**
	 * <Transformer> : set the square as occupied.
	 * <Postcondition> : square's boolean occupied has been set.
	 * @param boolean occupied
	 */
	public void setOccupied(boolean occupied) {
		this.occupied = true;
	}

	/**
	 * <Accessor> : return true if there's a pawn in this square, else false.
	 * <Postcondition> : we know if square is occupied or not.
	 * @return boolean occupied
	 */
	public boolean isOccupied() {
		return occupied;
	}
}
