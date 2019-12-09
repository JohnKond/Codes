package Model.Card;

/**
 * Card interface contains methods and 
 * signatures we need for the implementation 
 * of a card in board game Sorry
 * @author 3964
 */

import java.awt.Image;
import Model.Deck.Deck;
import Model.Pawn.Pawn;
import Model.Square.Square;

public interface Card {
    /**
     * <Accessor> :check if a pawn can move to a square of the deck.
     * <Precondition> : the pawn must move, according to the current card.
     * <Postcondition> : the pawn can move.
     * @param Pawn p
     * @param Square deck
     */
	public boolean movePawn(Pawn p, Square deck);

	
	/**
	 * <Transformer> : set the number of the card.
	 * <Postcondition> : card's number has been set.
	 * @param int number
	 */
	public void setNumber(int number);

	/**
	 * <Accessor> : returns the number of a card.
	 * <Postcondition> : card's number has been returned.
	 * @return int number
	 */
	public int getNumber();

	
	/**
	 * <Accessor> : card's String representation.
	 * <Postcondition> : card's String representation has been returned.
	 * @return String representation of a card
	 */
	public String toString();

	
	/**
	 * <Accessor> : Returns true if card has been played, else false.
	 * <Postcondition> : we know if card has been played or not.
	 * @return boolean isPlayed
	 */
	public boolean isPlayed();

	
	/**
	 * <Transformer> : set boolean isPlayed for a card
	 * <Postcondition> : 
	 * @param boolean played
	 */
	public void setPlayed(boolean played);


	
	/**
	 * <Accessor>: returns the image of a card. 
	 * <Postcondition> : card's image has been
	 * returned.
	 * @return image object
	 */
	public Image getImage();
	
	
	
}
