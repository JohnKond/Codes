package Model.Pawn;

import javax.swing.ImageIcon;

import Model.Color.Color;
import Model.Player.Player;
import Model.Square.Square;


/**
 * This class implements a pawn of a player.
 * @author 3964
 *
 */


public class Pawn {

	private int number;
	public Square pawnPosition;
	private ImageIcon image;
	private Player player;
	private Color color;
	private boolean home = false;
	private boolean start = true;
	
	public int i;
	public int j;
	public int prevI,prevJ;

	/**
	 * <Constructor>  : constructs a new pawn in (pawnPosition) square, with number
	 * (number) of Player(player) with image (image).
	 * <Postcondition> :  a new pawn has been created. 
	 * @param Deck pawnPosition
	 * @param int number
	 * @param Player player
	 * @param ImageIcon image
	 */
	
	public Pawn(Square boardPos,int row,int column, Player player,Color color,int number, ImageIcon image) {
		this.i = row;
		this.j = column;
		this.color = color;
		this.pawnPosition = boardPos;
		this.player = player;
		this.number = number;
		this.image = image;
	}
	
	/**
	 * <Transformer> : sets the row number of the pawn,
	 * represented in the board.
	 * <Postcondition> : the row number of the pawn has been set.
	 * @param row
	 */
	public void setRow(int row) {
		this.i = row;
	}
	
	
	/**
	 * <Accessor> : returns the row of the pawn, in the board.
	 * <Postcondition> : the row of the pawn has been returned.
	 * @return i (row)
	 */
	public int getRow() {
		return i;
	}
	
	
	/**
	 * <Accessor> : sets the row number of the pawn,
	 * represented in the board.
	 * <Postcondition> : the row number of the pawn has been set.
	 * @param column
	 */
	public void setColumn(int column) {
		this.j = column;
	}
	
	
	/**
	 * <Accessor> : returns the column of the pawn, in the board.
	 * <Postcondition> : the column of the pawn has been returned.
	 * @return j (column)
	 */
	public int getColumn() {
		return j;
	}
	
	
	
	/**
	 * <Accessor> : returns the player that owns the pawn (pawn).
	 * <Postcondition> : player of the pawn, has been returned.  
	 */
	public Player getPlayer() {
		return player;
	}
	
	
	/**
	 * 
	 * @return color
	 */
	public Color getColor() {
		return color;
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
	 * <Accessor> : returns the number of the pawn.
	 * <Postcondition> : the number of the pawn has been returned.
	 * @return
	 */
	public int getNumber() {
		return number;
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

	/**
	 * <Transformer> : set home true if pawn is in home square
	 * <Postcondition> : home invariant has been set.
	 * @param boolean home
	 */
	public void setHome(boolean home) {
		this.home = home;
	}
}
