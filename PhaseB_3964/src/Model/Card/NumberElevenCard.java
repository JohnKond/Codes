package Model.Card;

import javax.swing.ImageIcon;
import Model.Deck.Deck;
import Model.Pawn.Pawn;

/**
 * This class creates a new number 11 card.
 * @author 3964
 */

public class NumberElevenCard extends NumberCard {
	
	/**
	 * <Constructor> : Constructs a new number 11 card ,and 
	 * and sets card's number(11) , and it's image with command 
	 * super , to parent class NumberCard.
	 * @param ImageIcon image
	 */
	public NumberElevenCard(ImageIcon image) {
		super(11, image);
	}
	
	public String toString() {
		return "Move ONE man FORWARD 11 squares or ANY ONE of your margin men MAY change places with ONE margin man of ANY opponent.";
		
	}
	
}
