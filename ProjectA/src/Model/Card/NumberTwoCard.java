package Model.Card;

import javax.swing.ImageIcon;
import Model.Deck.Deck;
import Model.Pawn.Pawn;

/**
 * This class creates a new number 2 card.
 * @author 3964
 */
public class NumberTwoCard extends NumberCard {

	/**
	 * <Constructor> : Constructs a new number 2 card ,and 
	 * and sets card's number(2) , and it's image with command 
	 * super , to parent class NumberCard.
	 * @param ImageIcon image
	 */
	public NumberTwoCard(ImageIcon image) {
		super(2, image);
	}

}
