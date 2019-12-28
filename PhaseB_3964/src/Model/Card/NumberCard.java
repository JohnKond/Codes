package Model.Card;

import java.awt.Image;

import javax.swing.ImageIcon;

import Model.Pawn.Pawn;
import Model.Square.Square;


/**
 * This class implements a Number card
 * @author 3964
 */

public class NumberCard implements Card {

	private int number;
	private int move;
	private boolean played = false;
	private boolean turn = false;
	private ImageIcon image = null;
	private Image img, newImg;

	
	/**
	 * <Constructor> 
	 * <Postcondition> : Creates a card , with a number(number) and an image(image).
	 * @param number
	 * @param Image
	 */
	public NumberCard(int number, ImageIcon Image) {
		this.number = number;
		this.image = Image;
	}

	/**
     * <Accessor> : moves a pawn to a square of the deck.
     * <Precondition> : the pawn must move, according to the current card.
     * <Postcondition> : the pawn has been moved.
     * @param Pawn p
     * @param Deck deck
	 * @return 
     */
	public boolean movePawn(Pawn c, Square deck) {
        return false;
	}

	/**
	 * <Transformer> : set the number of the card.
	 * <Postcondition> : card's number has been set.
	 * @param int number
	 */
	public void setNumber(int number) {
		this.number = number;
	}

	/**
	 * <Accessor> : returns the number of a card.
	 * <Postcondition> : card's number has been returned.
	 * @return int number
	 */
	public int getNumber() {
		return number;
	}
	
	
	/**
	 * <Postcondition> : card's String representation has been returned.
	 * @return String representation of a card
	 */
	public String toString() {
		return "MUST move ONE man FORWARD "+number+" spaces.";
	}

	
	/**
	 * <Accessor> : Returns true if card has been played, else false.
	 * <Postcondition> : we know if card has been played or not.
	 * @return boolean isPlayed
	 */
	public boolean isPlayed() {
		return played;
	}

	/**
	 * <Accessor> : set boolean isPlayed for a card
	 * <Postcondition> : 
	 * @param boolean played
	 */
	public void setPlayed(boolean played) {
		this.played = played;
	}

	/**
	 * <Accessor>: returns the image of a card. 
	 * <Postcondition> : card's image has been
	 * returned.
	 * @return image object
	 */
	public Image getImage() {
		img = image.getImage();
		newImg = img.getScaledInstance(100, 140, java.awt.Image.SCALE_SMOOTH);
		return newImg;
	}
	
}
