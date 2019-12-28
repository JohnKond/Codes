package Model.Square;

import javax.swing.ImageIcon;

import Model.Pawn.Pawn;


/**
 * This class creates a new simple square of the board.
 * @author 3964
 */
public class SimpleSquare extends Square {

	private boolean occupied;
	private Pawn p;

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
	 * <Transformer> : set the square as occupied.
	 * <Postcondition> : square's boolean occupied has been set.
	 * @param boolean occupied
	 */
	public void setOccuped(boolean occupied) {
		this.occupied = occupied;
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
	 * <Transformer> : sets a pawn to the chosen square.
	 * <Postcondition> : pawn moves to the chosen square.
	 * @param Pawn p
	 */
	public void setPawn(Pawn p) {
		this.p = p;
	}
	
	/**
	 * <Accessor> : returns the pawn of the chosen square.
	 * <Precondition> : square must be occupied by a pawn.
	 * <Postcondition> : pawn of the chosen square has been returned.
	 * @return Pawn p
	 */
	public Pawn getPawn() {
		return p;
	}

}
