package Model.Square;

import java.awt.Image;

import javax.swing.ImageIcon;

import Model.Color.Color;
import Model.Pawn.Pawn;
import Model.Player.Player;

/**
 * This class implements the squares of the board.
 * @author 3964
 */
public class Square {

	private Pawn p;
	private Color color;
	private ImageIcon image;
	private Image img, newImg;
	private boolean occupied;

	/**
	 * <Constructor> (1)
	 * <Postcondition> : creates a square in the board ,which belongs to 
	 * the player p
	 * @param Player p
	 * @param ImageIcon image
	 */
	public Square(Color color, ImageIcon image) {
		this.color = color;
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
	 * <Accessor> : returns the color of the chosen square.
	 * <Postcondition> : Color of the chosen square has been returned.
	 * @return Color color
	 */
	public Color getColor() {
		return color;
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
