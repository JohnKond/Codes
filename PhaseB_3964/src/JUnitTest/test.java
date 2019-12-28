package JUnitTest;

import static org.junit.Assert.assertEquals;

import javax.swing.ImageIcon;

import org.junit.Test;

import Controller.Game;
import Model.Card.Card;
import Model.Card.NumberOneCard;
import Model.Card.NumberTwoCard;
import View.Gui;

/**
 * This class is responsible for checking basic rules violations:
 * - Pawns move from start square only with card 1 and 2.
 * - Player cannot draw a card twice.
 * - Player can draw a card twice only if current card is 2.
 * - Player cannot move a pawn to a square occupied by one of his pawns.
 * @author 3964
 *
 */

public class test {
 
	Game game = new Game();
	Gui view = new Gui() ;
	
	
	/**
	 * test 0 asserts that all the pawns are in their position, so game is ready to start.
	 */
	@Test
	public void test0() {
		assertEquals(game.redPawn1.i , 1);
		assertEquals(game.redPawn1.j, 3);
		
		assertEquals(game.redPawn2.i , 1);
		assertEquals(game.redPawn2.j, 4);
		
		assertEquals(game.yellowPawn1.i , 14);
		assertEquals(game.yellowPawn1.j , 11);
		
		assertEquals(game.yellowPawn2.i , 14);
		assertEquals(game.yellowPawn2.j , 12);
	}
	
	
	
	/**
	 * test1 ensures that a pawn can only move from start square, with 
	 * a draw of card 1 or 2.  For instance, I set current card as 1 and first click
	 * redPawn1. As we see, redPawn1 moves ahead to board[0][4]. Then ,fold button is 
	 * clicked. I set current card as 1 again, and now click the yellowPawn1. As we see
	 * yellowPawn1 moves correctly ahead to board[15][11].
	 */
	@Test
	public void test1() {
		
		Card c1 = new NumberOneCard(new ImageIcon("images/cards/card1.png"));
		game.setCurrCard(c1);
		game.view.rp1.doClick();	
		assertEquals(game.redPawn1.i,0);
		assertEquals(game.redPawn1.j,4);
	
		
		game.view.butFold.doClick();
		
		
		Card c2 = new NumberOneCard(new ImageIcon("images/cards/card1.png"));
		game.setCurrCard(c2);
		game.view.yp1.doClick();
		assertEquals(game.yellowPawn1.i,15);
		assertEquals(game.yellowPawn1.j,11);
		
		game.view.butFold.doClick();
		
	}
	
	
	
	/**
	 * test2 ensures, that a pawn cannot move in a square occupied by a pawn of
	 * a same color. For instance, in test1 redPawn1 moved to board[0][4]. As result ,if
	 * redPawn2 is clicked, stays in same position (board[1][4]) 
	 */
	@Test
	public void test2() {
		test1();

		Card c1 = new NumberOneCard(new ImageIcon("images/cards/card1.png"));
		game.setCurrCard(c1);
		game.view.rp2.doClick();	
		assertEquals(game.redPawn2.i,1);
		assertEquals(game.redPawn2.j,4);
	}
	
	
	/**
	 * test 3 ensures that a player cannot draw two card in a row (except card 2).
	 */
	@Test (expected = UnsupportedOperationException.class) 
	public void test3() {
		test1();
		
        game.view.but.doClick();
        game.view.but.doClick();

	}
	
	
	/**
	 * test 4 ensures that, you draw card again, only if current card is 2.
	 */
	@Test
	public void test4() {
		test1();
		Card card = new NumberTwoCard(new ImageIcon(""));
	    
		game.view.but.doClick();
		game.setCurrCard(card);	
        game.view.rp1.doClick();
        game.view.but.doClick();
	}	

}
