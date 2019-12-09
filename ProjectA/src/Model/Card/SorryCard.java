package Model.Card;

import java.awt.Image;

import javax.swing.ImageIcon;

import Model.Pawn.Pawn;
import Model.Square.Square;

/**
 * This class implements a Sorry card.
 * @author 3964
 *
 */

public class SorryCard implements Card {
	

	private ImageIcon image = null;
	private boolean played = false;
	private Image img, newImg;

	
	/**
	 * <Constructor> 
	 * <Postcondition> : Creates a sorry card , with an image(image).
	 * @param number
	 * @param Image
	 */
	public SorryCard(ImageIcon image) {
		this.image = image;
	}

	/**
     * <Accessor> : moves a pawn to a square of the deck.
     * <Precondition> : the pawn must move, according to the current card.
     * <Postcondition> : the pawn has been moved.
     * @param Pawn p
     * @param Deck deck
     */
	public boolean movePawn(Pawn p, Square deck) {
        return false;
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
	 * <Transformer> : set the number of the card.
	 * <Postcondition> : card's number has been set.
	 * @param int number
	 */
	public void setNumber(int number) {

	}

	
	/**
	 * <Accessor> : returns the number of a card.
	 * <Postcondition> : card's number has been returned.
	 * @return int number
	 */
	public int getNumber() {
		return 0;
	}

    /**
     * <Accessor> : returns true if p1 can switch place with p2, 
     * and p2 , can transfered to start square,else false.
     * <Postcondition> : switch is valid , or invalid
     * @param Pawn p1
     * @param Pawn p2
     * @param Square deck
     * @return boolean
     */
	public boolean switchPlaces(Pawn p1, Pawn p2,Square deck) {
		return true;
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
