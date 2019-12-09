package Model.Square;

import java.awt.Image;

import javax.swing.ImageIcon;

import Model.Pawn.Pawn;
import Model.Player.Player;


/**
 * This class implements the squares of the board.
 * @author 3964
 */
public class Square {

	private boolean occupied = true;
	private Pawn pawn;
	private Player p;
	private ImageIcon image;
	private Image img, newImg;

	/**
	 * <Constructor> (1)
	 * <Postcondition> : creates a square in the board ,which belongs to 
	 * the player p
	 * @param Player p
	 * @param ImageIcon image
	 */
	public Square(Player p, ImageIcon image) {
		this.p = p;
		this.image = image;
	}
	
	
	/**
	 * <Constructor> (2)
	 * <Postcondition> : creates a simple square in the board 
	 * @param Player p
	 * @param ImageIcon image
	 */
	public Square(ImageIcon image) {
		this.image = image;
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
		this.occupied = occupied;
	}
	

	/**
	 * <Accessor>: returns the image of the square. 
	 * <Postcondition> : square's image has been
	 * returned.
	 * @return Image object
	 */
	public Image getImage() {
		img = image.getImage();
		newImg = img.getScaledInstance(45, 45, java.awt.Image.SCALE_SMOOTH);
		return newImg;
	}

}
