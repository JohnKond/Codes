package Model.Card;

import javax.swing.ImageIcon;
import Model.Deck.Deck;
import Model.Pawn.Pawn;


/**
 * This class creates a new number 10 card.
 * @author 3964
 */

public class NumberTenCard extends NumberCard {
	
	/**
	 * <Constructor> : Constructs a new number 10 card ,and 
	 * and sets card's number(10) , and it's image with command 
	 * super , to parent class NumberCard.
	 * @param ImageIcon image
	 */
	public NumberTenCard(ImageIcon image) {
		super(10, image);
	}
	
	public String toString() {
		return "MUST either move ONE man FORWARD 10 squares OR move ONE man BACKWARD 1 square";
	}

}
