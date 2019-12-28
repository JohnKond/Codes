package Model.Card;

import javax.swing.ImageIcon;
import Model.Deck.Deck;
import Model.Pawn.Pawn;

/**
 * This class creates a new number 7 card.
 * @author 3964
 */

public class NumberSevenCard extends NumberCard {

	/**
	 * <Constructor> : Constructs a new number 7 card ,and 
	 * and sets card's number(7) , and it's image with command 
	 * super , to parent class NumberCard.
	 * @param ImageIcon image
	 */
	public NumberSevenCard(ImageIcon image) {
		super(7, image);
	}

	public String toString() {
		return "MUST either move ONE man FORWARD 7, OR split the move between ANY TWO men";
	}
}
