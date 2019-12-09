package Model.Square;

import javax.swing.ImageIcon;

/**
 * This class creates a new simple square of the board.
 * @author 3964
 */
public class SimpleSquare extends Square {

	boolean occupied = false;
	
	/**
	 * <Constructor> 
	 * <Postcondition> : creates a new simple square and
	 * sets it's image, with command  super ,
	 * to parent class Square.
	 * @param image
	 */
	public SimpleSquare(ImageIcon image) {
		super(image);
	}

	/**
	 * <Accessor> : return true if there's a pawn in this square, else false.
	 * <Postcondition> : we know if square is occupied or not.
	 * @return boolean occupied
	 */
	public boolean isOccupied() {
	   return occupied;
	}
	
	
	/**
	 * <Transformer> : set the square as occupied.
	 * <Postcondition> : square's boolean occupied has been set.
	 * @param boolean occupied
	 */
	public void setOccupied(boolean occupied) {
		
	}
}
