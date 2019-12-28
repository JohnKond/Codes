package Model.Card;


import javax.swing.ImageIcon;
import Model.Deck.Deck;
import Model.Pawn.Pawn;
import Model.Square.Square;


/**
 * This class creates a new number 4 card.
 * @author 3964
 */

public class NumberFourCard extends NumberCard {

	
	/**
	 * <Constructor> : Constructs a new number 4 card ,and 
	 * and sets card's number(4) , and it's image with command 
	 * super , to parent class NumberCard.
	 * @param ImageIcon image
	 */
	public NumberFourCard(ImageIcon image) {
		super(4, image);
	}
	
	public String toString() {
		return "Must move one man backwards 4 squares";
	}
	
}
