package Model.Card;

import javax.swing.ImageIcon;

import Model.Deck.Deck;
import Model.Pawn.Pawn;

/**
 * This class creates a new number 1 card.
 * @author 3964
 */

public class NumberOneCard extends NumberCard {

	/**
	 * <Constructor> : Constructs a new number 1 card ,and 
	 * and sets card's number(1) , and it's image with command 
	 * super , to parent class NumberCard.
	 * @param ImageIcon image
	 */
	public NumberOneCard(ImageIcon image) {
		super(1, image);
	}

    public String toString() {
    	return "MUST either start a man out OR move ONE man FORWARD 1 square.";
    }
	
}
