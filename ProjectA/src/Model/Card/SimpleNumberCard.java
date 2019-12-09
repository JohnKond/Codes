package Model.Card;

import javax.swing.ImageIcon;

import Model.Deck.Deck;
import Model.Pawn.Pawn;

/**
 *  This class creates new cards with simple 
 *  forward steps : 3,5,8,12
 *  @author 3964
 */


public class SimpleNumberCard extends NumberCard {

	/**
	 * <Constructor> : Constructs a new simple number card ,and 
	 * and sets card's number (3 or 5 or 8 or 12) , and it's image with command 
	 * super , to parent class NumberCard.
	 * @param int number
	 * @param ImageIcon image
	 */
	public SimpleNumberCard(int number, ImageIcon image) {
		super(number, image);
	}
	
}
