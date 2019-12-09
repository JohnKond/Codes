package Model.Pawn;

import javax.swing.ImageIcon;

import Model.Deck.Deck;
import Model.Player.Player;
import Model.Square.Square;


/**
 * This class implements a pawn of a player.
 * @author 3964
 *
 */


public class Pawn {

	private int number;
	private Square pawnPosition;
	private ImageIcon image;
	private Player player;
	private boolean home = false;
	private boolean start = true;

	/**
	 * <Constructor>  : constructs a new pawn in (pawnPosition) square, with number
	 * (number) of Player(player) with image (image).
	 * <Postcondition> :  a new pawn has been created. 
	 * @param Deck pawnPosition
	 * @param int number
	 * @param Player player
	 * @param ImageIcon image
	 */
	
	public Pawn(Square boardPos, Player player,int number, ImageIcon image) {
		this.pawnPosition = boardPos;
		this.player = player;
		this.number = number;
		this.image = image;
	}
	
	/**
	 * <Accessor> : returns the player that owns the pawn (pawn).
	 * <Postcondition> : player of the pawn, has been returned.  
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * <Transformer> : sets the position of the pawn 
	 * <Precondition> : card allow you to move
	 * and position must be available
	 * <Postcondition> : 
	 * @param Deck pawnPosition
	 */
	public void setPawnPosition(Square square) {
		this.pawnPosition = square;
		
	}
	
	/**
	 * <Accessor> : return the position of the pawn in the board.
	 * <Postcondition> : position of the pawn has been returned.
	 * @return Deck pawnPosition
	 */
	public Square getPawnPosition() {
		return pawnPosition;
	}
	
	/**
	 * <Accessor> : returns true if pawn is in start position,else false
	 * <postcondition> : we know if pawn is in start position or not.
	 * @return boolean start
	 */
    public boolean isStart() {
    	return start;
    }
	
    
    /**
	 * <Accessor> : returns true if pawn is in home position,else false
	 * <postcondition> : we know if pawn is in home position or not.
	 * @return boolean home
	 */
	public boolean isHome() {
		return home;
	}

	
}
