package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import Model.Card.Card;
import Model.Deck.Deck;
import Model.Pawn.Pawn;
import Model.Player.Player;
import Model.Square.SimpleSquare;
import Model.Square.Square;
import Model.Square.StartSquare;
import View.Gui;

public class Game {

	private boolean turn = false;;
	private boolean start = false;
	private boolean move = false;
	private Player currPlayer;
	private Pawn currPawn;
	private Pawn tempPawn;
	private Card currCard;
	private Square currentLocation;
	private Square destinationLocation;
	private int pawnsOfEachPlayer;
	
	Deck board;
	Gui view;
	Pawn redPawn1,redPawn2,yellowPawn1,yellowPawn2;
	
	
	
	/**
	 * <Constructor> : creates a new instance of Deck, and a new instance of Gui.Also corresponds
	 * the pawns of each player.
	 * <Postcondition> : deck and graphic environment has been created and pawns have been
	 * corresponded.
	 */
	public Game() {
		board = new Deck();
		view = new Gui();
		addListeners();
		 
		this.redPawn1 = board.redPawn1;
		this.redPawn2 = board.redPawn2;
		this.yellowPawn1 = board.yellowPawn1;
		this.yellowPawn2 = board.yellowPawn2;		
	}
	
	
	
	/**
	 * <Transformer> : adds ActionListeners to all the buttons. Card buttons(but and 
	 * butfold) and Pawn button ( rp1,rp2,rp3,rp4).
	 * <Postcondition> : if a button is pushed, an action will follow ,according to 
	 * the methods bellow.
	 */
	public void addListeners() {
		
	    ActionListener CardListener = new CardListener();
	   
	    ActionListener PawnListener = new PawnListener();
	    
	    
	}
	
	
	/**
	 * <Accessor> : returns true if board ,cards and pawns are correct,
	 * so the game is ready to start, else false.
	 * <Postcondition> : board, cards and pawns are all ready, and the game
	 * is ready to start.
	 * @return boolean start
	 */
	public boolean readyToStart() {
		return start;
	}

	
	/**
	 * <Transformer> : if the player has made his move , we change the turn 
	 * via method hasPlayer() in Model.Player.
	 * <PostCondition> : turn of round has been updated.
	 */
	public void turn() {
		if (currPlayer.hasPlayed()) {
			
		}
	}
		
	
	/**
	 * <Accessor> : changes the turn if current player has made his move.
	 * <Postcondition> : turn has changed, and the other player is ready to make
	 * his move.
	 * @return boolean turn
	 */
	public boolean isTurn() {
		return turn;
	}

	
	/**
	 * <Transformer> : if player can't make any other move,goes fold.
	 * <Precondition> : all essential moves must be checked via
	 * method isFold() in Model.Deck.
	 */
	public void setFold() {
		
	}
	
	
	/**
	 * <Transformer> : moves the pawn (pawn) in a different square (board),
	 * according to the current card rules (c) and the player's (p) turn.
	 * <Precondition> : move of the pawn in the board must be valid.
	 * <Postcondition> : pawn has been moved.
	 * @param Square board
	 * @param Card c
	 * @param Pawn pawn
	 * @param Player p
	 */
	public void movePawn(Square board,Card c,Pawn pawn,Player p) {
        if (c.movePawn(pawn, board)) {
       	 /**
       	  * a player makes his move
       	  */
        	move = true;
        }
	}

	
   /**
    * <Accessor> : returns true if a pawn has made his move,else true.
    * <Postcondition> : boolean move has bee update to true.
    * @return boolean move
    */
	public boolean pawnMoved() {
		return move;
	}

	
	
	/**
	 * <Transformer> : moves the pawns from the start of the slide to the end.
	 * <Precondition> : slide and player's color must be different and ,
	 * can be used if only a pawn arrives at the start square of the slide,
	 * and only in start square( if the pawn arrives in an inside slide square),
	 * slide can not be used.
	 * <Postcondition> : pawn moves from the start slide square to the end 
	 * slide square.
	 * @param Pawn pawn
	 * @param Square start
	 * @param Square end
	 */
	public void slide(Pawn pawn,Square start, Square end) {
		
	}

	
	/**
	 * <Transformer> : pawn1 takes the place of pawn2 , and pawn2 moves to
	 * the start square.
	 * <Precondition> : pawns must have different colors.
	 * <Postcondition> : pawn1 takes the place of pawn2 , and pawn2 moves to
	 * the start square.
	 * @param Pawn pawn1
	 * @param Pawn pawn2
	 */
	public void collision(Pawn pawn1, Pawn pawn2) {

	}

	
    /**
     * class CardListener implements the ActionListener
     * card buttons ( new card button and fold button),
     * and makes the essential actions if a button is pushed
     */
	 private class CardListener implements ActionListener {


		 /**
		  * <Transformer> : Makes the necessary actions if the receive card button 
		  * is being pressed.
		  * <Postcondition> : Makes the necessary actions if the receive card button 
		  * is being pressed.
		  */
		@Override
		public void actionPerformed(ActionEvent e) {
		
			Object source = e.getSource();
			
	    }
	 }
		
		
	 
	 
     /**
      * class PawnListener implements the ActionListener for
      * pawn buttons ( redPawn1,redPawn2,yellowPawn3,yellowPawn4),
      * and makes the essential actions if a button is pushed.
      */	
		private class PawnListener implements ActionListener {

			
			/**
			  * <Transformer> : Makes the necessary actions if a pawn button 
			  * is being pressed.
			  * <Postcondition> : Makes the necessary actions if a pawn button 
			  * is being pressed.
			  */
			@Override
			public void actionPerformed(ActionEvent e) {		
				Object source = e.getSource();
		
		    }
			
			
		
		}	 
		
		public static void main(String[] args) {
			Game game = new Game();
		}
	
}
