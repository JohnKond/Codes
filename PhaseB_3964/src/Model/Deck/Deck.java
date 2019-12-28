package Model.Deck;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.ImageIcon;

import Controller.Game;
import Model.Card.Card;
import Model.Card.NumberElevenCard;
import Model.Card.NumberFourCard;
import Model.Card.NumberOneCard;
import Model.Card.NumberSevenCard;
import Model.Card.NumberTenCard;
import Model.Card.NumberTwoCard;
import Model.Card.SimpleNumberCard;
import Model.Card.SorryCard;
import Model.Color.Color;
import Model.Pawn.Pawn;
import Model.Player.Player;
import Model.Square.EndSlideSquare;
import Model.Square.HomeSquare;
import Model.Square.SafetyZoneSquare;
import Model.Square.SimpleSquare;
import Model.Square.SlideSquare;
import Model.Square.Square;
import Model.Square.StartSlideSquare;
import Model.Square.StartSquare;


/**
 * This class is responsible for the initialization of the deck,the board,
 * the players and the pawns of the game.
 * @author 3964
 *
 */
public class Deck {
		
	public Square[][] board;
	public Player player1, player2, player3, player4;
	public Pawn redPawn1;
	public Pawn redPawn2;
	public Pawn yellowPawn1;
	public Pawn yellowPawn2;
	public int cardsNum = 44;
	private ArrayList<Card> deck = new ArrayList<Card>();
	public String path = "/home/kondo/Desktop/";
	private boolean fold = false;
	private boolean zero = false;
	private Square currentLocation;
	public Game g ;
	

	
	
/**
 * <Constructor> : constructs and calls the functions to initialize
 * the card deck , the board ,the players and the pawns.
 * <Postcondition> : initializes the deck,the board,2 players
 * and their pawns.
 */
	public Deck() {

		
		initializeDeck();
        initializeBoard();
        initializePlayersAndPawns();
	}
	
	
	/**
	 * <Transformer> : creates and initializes 2 players with names and color,
	 * and their pawns.
	 * <Postcondition> : Players and pawns their pawns has been initialized.
	 */
	public void initializePlayersAndPawns() {
		player1 = new Player("Giannis",Color.red,1);
		player1.initializePawns(Color.red,player1,board);
	    redPawn1 = player1.pawn1;
	    redPawn2 = player1.pawn2;
	    
	    player2 = new Player("Manos",Color.yellow,2);
	    player2.initializePawns(Color.yellow,player2,board);
	    yellowPawn1 = player2.pawn1;
	    yellowPawn2 = player2.pawn2;
	    
	}
	
	

	/**
	 * <Transformer> : creates and initializes all the cards, with their images
	 * and puts them into a list,called deck.
	 * <Postcondition> : cards have been initializes and added into the deck list.
	 * @return Card deck
	 */
	public ArrayList<Card> initializeDeck() {
		Card c1 = new NumberOneCard(new ImageIcon( path + "images/cards/card1.png"));
		Card c2 = new NumberOneCard(new ImageIcon( path + "images/cards/card1.png"));
		Card c3 = new NumberOneCard(new ImageIcon( path + "images/cards/card1.png"));
		Card c4 = new NumberOneCard(new ImageIcon( path + "images/cards/card1.png"));

		Card c5 = new NumberTwoCard(new ImageIcon( path + "images/cards/card2.png"));
		Card c6 = new NumberTwoCard(new ImageIcon( path + "images/cards/card2.png"));
		Card c7 = new NumberTwoCard(new ImageIcon( path + "images/cards/card2.png"));
		Card c8 = new NumberTwoCard(new ImageIcon( path + "images/cards/card2.png"));

		Card c9 = new SimpleNumberCard(3, new ImageIcon( path + "images/cards/card3.png"));
		Card c10 = new SimpleNumberCard(3, new ImageIcon( path + "images/cards/card3.png"));
		Card c11 = new SimpleNumberCard(3, new ImageIcon( path + "images/cards/card3.png"));
		Card c12 = new SimpleNumberCard(3, new ImageIcon( path + "images/cards/card3.png"));

		Card c13 = new NumberFourCard(new ImageIcon( path + "images/cards/card4.png"));
		Card c14 = new NumberFourCard(new ImageIcon( path + "images/cards/card4.png"));
		Card c15 = new NumberFourCard(new ImageIcon( path + "images/cards/card4.png"));
		Card c16 = new NumberFourCard(new ImageIcon( path + "images/cards/card4.png"));

		Card c17 = new SimpleNumberCard(5, new ImageIcon( path + "images/cards/card5.png"));
		Card c18 = new SimpleNumberCard(5, new ImageIcon( path + "images/cards/card5.png"));
		Card c19 = new SimpleNumberCard(5, new ImageIcon( path + "images/cards/card5.png"));
		Card c20 = new SimpleNumberCard(5, new ImageIcon( path + "images/cards/card5.png"));

		Card c21 = new NumberSevenCard(new ImageIcon( path + "images/cards/card7.png"));
		Card c22 = new NumberSevenCard(new ImageIcon( path + "images/cards/card7.png"));
		Card c23 = new NumberSevenCard(new ImageIcon( path + "images/cards/card7.png"));
		Card c24 = new NumberSevenCard(new ImageIcon( path + "images/cards/card7.png"));

		Card c25 = new SimpleNumberCard(8, new ImageIcon( path + "images/cards/card8.png"));
		Card c26 = new SimpleNumberCard(8, new ImageIcon( path + "images/cards/card8.png"));
		Card c27 = new SimpleNumberCard(8, new ImageIcon( path + "images/cards/card8.png"));
		Card c28 = new SimpleNumberCard(8, new ImageIcon( path + "images/cards/card8.png"));

		Card c29 = new NumberTenCard(new ImageIcon( path + "images/cards/card10.png"));
		Card c30 = new NumberTenCard(new ImageIcon( path + "images/cards/card10.png"));
		Card c31 = new NumberTenCard(new ImageIcon( path + "images/cards/card10.png"));
		Card c32 = new NumberTenCard(new ImageIcon( path + "images/cards/card10.png"));

		Card c33 = new NumberElevenCard(new ImageIcon( path + "images/cards/card11.png"));
		Card c34 = new NumberElevenCard(new ImageIcon( path + "images/cards/card11.png"));
		Card c35 = new NumberElevenCard(new ImageIcon( path + "images/cards/card11.png"));
		Card c36 = new NumberElevenCard(new ImageIcon( path + "images/cards/card11.png"));

		Card c37 = new SimpleNumberCard(12, new ImageIcon( path + "images/cards/card12.png"));
		Card c38 = new SimpleNumberCard(12, new ImageIcon( path + "images/cards/card12.png"));
		Card c39 = new SimpleNumberCard(12, new ImageIcon( path + "images/cards/card12.png"));
		Card c40 = new SimpleNumberCard(12, new ImageIcon( path + "images/cards/card12.png"));

		Card c41 = new SorryCard( new ImageIcon( path + "images/cards/cardSorry.png"));
		Card c42 = new SorryCard( new ImageIcon( path + "images/cards/cardSorry.png"));
		Card c43 = new SorryCard( new ImageIcon( path + "images/cards/cardSorry.png"));
		Card c44 = new SorryCard( new ImageIcon( path + "images/cards/cardSorry.png"));

		deck.add(c1);
		deck.add(c2);
		deck.add(c3);
		deck.add(c4);
		deck.add(c5);
		deck.add(c6);
		deck.add(c7);
		deck.add(c8);
		deck.add(c9);
		deck.add(c10);
		deck.add(c11);
		deck.add(c12);
		deck.add(c13);
		deck.add(c14);
		deck.add(c15);
		deck.add(c16);
		deck.add(c17);
		deck.add(c18);
		deck.add(c19);
		deck.add(c20);
		deck.add(c21);
		deck.add(c22);
		deck.add(c23);
		deck.add(c24);
		deck.add(c25);
		deck.add(c26);
		deck.add(c27);
		deck.add(c28);
		deck.add(c29);
		deck.add(c30);
		deck.add(c31);
		deck.add(c32);
		deck.add(c33);
		deck.add(c34);
		deck.add(c35);
		deck.add(c36);
		deck.add(c37);
		deck.add(c38);
		deck.add(c39);
		deck.add(c40);
		deck.add(c41);
		deck.add(c42);
		deck.add(c43);
		deck.add(c44);
		return deck;

	}
	
	
	
	
    /**
     * <Transformer> : creates and initializes the board of the game with 
     * squares with their images.
     * <Postocondition>: board of the game has been initialized.
     */
	public void initializeBoard() {
		board = new Square[16][16];

		board[0][0] = new SimpleSquare(new ImageIcon( path + "images/slides/simpleSquare.png"));
		board[1][0] = new SimpleSquare(new ImageIcon( path + "images/slides/simpleSquare.png"));
		board[2][0] = new EndSlideSquare(Color.green, new ImageIcon( path + "images/slides/greenSlideEnd.png"));
		board[3][0] = new SlideSquare(Color.green, new ImageIcon( path + "images/slides/greenSlideMedium.png"));
		board[4][0] = new SlideSquare(Color.green, new ImageIcon( path + "images/slides/greenSlideMedium.png"));
		board[5][0] = new SlideSquare(Color.green, new ImageIcon( path + "images/slides/greenSlideMedium.png"));
		board[6][0] = new StartSlideSquare(Color.green,
				new ImageIcon( path + "images/slides/greenSlideStart.png"));
		board[7][0] = new SimpleSquare(new ImageIcon( path + "images/slides/simpleSquare.png"));
		board[8][0] = new SimpleSquare(new ImageIcon( path + "images/slides/simpleSquare.png"));
		board[9][0] = new SimpleSquare(new ImageIcon( path + "images/slides/simpleSquare.png"));
		board[10][0] = new SimpleSquare(new ImageIcon( path + "images/slides/simpleSquare.png"));
		board[11][0] = new EndSlideSquare(Color.green, new ImageIcon( path + "images/slides/greenSlideEnd.png"));
		board[12][0] = new SlideSquare(Color.green, new ImageIcon( path + "images/slides/greenSlideMedium.png"));
		board[13][0] = new SlideSquare(Color.green, new ImageIcon( path + "images/slides/greenSlideMedium.png"));
		board[14][0] = new StartSlideSquare(Color.green,
				new ImageIcon( path + "images/slides/greenSlideStart.png"));
		board[15][0] = new SimpleSquare(new ImageIcon( path + "images/slides/simpleSquare.png"));

		board[15][1] = new SimpleSquare(new ImageIcon( path + "images/slides/simpleSquare.png"));
		board[15][2] = new EndSlideSquare(Color.yellow, new ImageIcon( path + "images/slides/yellowSlideEnd.png"));
		board[15][3] = new SlideSquare(Color.yellow, new ImageIcon( path + "images/slides/yellowSlideMedium.png"));
		board[15][4] = new SlideSquare(Color.yellow, new ImageIcon( path + "images/slides/yellowSlideMedium.png"));
		board[15][5] = new SlideSquare(Color.yellow, new ImageIcon( path + "images/slides/yellowSlideMedium.png"));
		board[15][6] = new StartSlideSquare(Color.yellow,
				new ImageIcon( path + "images/slides/yellowSlideStart.png"));
		board[15][7] = new SimpleSquare(new ImageIcon( path + "images/slides/simpleSquare.png"));
		board[15][8] = new SimpleSquare(new ImageIcon( path + "images/slides/simpleSquare.png"));
		board[15][9] = new SimpleSquare(new ImageIcon( path + "images/slides/simpleSquare.png"));
		board[15][10] = new SimpleSquare(new ImageIcon( path + "images/slides/simpleSquare.png"));
		board[15][11] = new EndSlideSquare(Color.yellow, new ImageIcon( path + "images/slides/yellowSlideEnd.png"));
		board[15][12] = new SlideSquare(Color.yellow, new ImageIcon( path + "images/slides/yellowSlideMedium.png"));
		board[15][13] = new SlideSquare(Color.yellow, new ImageIcon( path + "images/slides/yellowSlideMedium.png"));
		board[15][14] = new StartSlideSquare(Color.yellow,
				new ImageIcon( path + "images/slides/yellowSlideStart.png"));
		board[15][15] = new SimpleSquare(new ImageIcon( path + "images/slides/simpleSquare.png"));

		board[14][15] = new SimpleSquare(new ImageIcon( path + "images/slides/simpleSquare.png"));
		board[13][15] = new EndSlideSquare(Color.blue, new ImageIcon( path + "images/slides/blueSlideEnd.png"));
		board[12][15] = new SlideSquare(Color.blue, new ImageIcon( path + "images/slides/blueSlideMedium.png"));
		board[11][15] = new SlideSquare(Color.blue, new ImageIcon( path + "images/slides/blueSlideMedium.png"));
		board[10][15] = new SlideSquare(Color.blue, new ImageIcon( path + "images/slides/blueSlideMedium.png"));
		board[9][15] = new StartSlideSquare(Color.blue,
				new ImageIcon( path + "images/slides/blueSlideStart.png"));
		board[8][15] = new SimpleSquare(new ImageIcon( path + "images/slides/simpleSquare.png"));
		board[7][15] = new SimpleSquare(new ImageIcon( path + "images/slides/simpleSquare.png"));
		board[6][15] = new SimpleSquare(new ImageIcon( path + "images/slides/simpleSquare.png"));
		board[5][15] = new SimpleSquare(new ImageIcon( path + "images/slides/simpleSquare.png"));
		board[4][15] = new EndSlideSquare(Color.blue, new ImageIcon( path + "images/slides/blueSlideEnd.png"));
		board[3][15] = new SlideSquare(Color.blue, new ImageIcon( path + "images/slides/blueSlideMedium.png"));
		board[2][15] = new StartSlideSquare(Color.blue,
				new ImageIcon( path + "images/slides/blueSlideStart.png"));
		board[1][15] = new SimpleSquare(new ImageIcon( path + "images/slides/simpleSquare.png"));

		board[0][15] = new SimpleSquare(new ImageIcon( path + "images/slides/simpleSquare.png"));
		board[0][14] = new SimpleSquare(new ImageIcon( path + "images/slides/simpleSquare.png"));
		board[0][13] = new EndSlideSquare(Color.red, new ImageIcon( path + "images/slides/redSlideEnd.png"));
		board[0][12] = new SlideSquare(Color.red, new ImageIcon( path + "images/slides/redSlideMedium.png"));
		board[0][11] = new SlideSquare(Color.red, new ImageIcon( path + "images/slides/redSlideMedium.png"));
		board[0][10] = new SlideSquare(Color.red, new ImageIcon( path + "images/slides/redSlideMedium.png"));
		board[0][9] = new StartSlideSquare(Color.red, new ImageIcon( path + "images/slides/redSlideStart.png"));
		board[0][8] = new SimpleSquare(new ImageIcon( path + "images/slides/simpleSquare.png"));
		board[0][7] = new SimpleSquare(new ImageIcon( path + "images/slides/simpleSquare.png"));
		board[0][6] = new SimpleSquare(new ImageIcon( path + "images/slides/simpleSquare.png"));
		board[0][5] = new SimpleSquare(new ImageIcon( path + "images/slides/simpleSquare.png"));
		board[0][4] = new EndSlideSquare(Color.red, new ImageIcon( path + "images/slides/redSlideEnd.png"));
		board[0][3] = new SlideSquare(Color.red, new ImageIcon( path + "images/slides/redSlideMedium.png"));
		board[0][2] = new SlideSquare(Color.red, new ImageIcon( path + "images/slides/redSlideMedium.png"));
		board[0][1] = new StartSlideSquare(Color.red, new ImageIcon( path + "images/slides/redSlideStart.png"));

		board[1][2] = new SafetyZoneSquare(Color.red, new ImageIcon( path + "images/slides/redSquare.png"));
		board[2][2] = new SafetyZoneSquare(Color.red, new ImageIcon( path + "images/slides/redSquare.png"));
		board[3][2] = new SafetyZoneSquare(Color.red, new ImageIcon( path + "images/slides/redSquare.png"));
		board[4][2] = new SafetyZoneSquare(Color.red, new ImageIcon( path + "images/slides/redSquare.png"));
		board[5][2] = new SafetyZoneSquare(Color.red, new ImageIcon( path + "images/slides/redSquare.png"));
		board[6][2] = new HomeSquare(Color.red, new ImageIcon( path + "images/slides/simpleSquare.png"));
		board[6][3] = new HomeSquare(Color.red, new ImageIcon( path + "images/slides/simpleSquare.png"));
		board[7][2] = new HomeSquare(Color.red, new ImageIcon( path + "images/slides/simpleSquare.png"));
		board[7][3] = new HomeSquare(Color.red, new ImageIcon( path + "images/slides/simpleSquare.png"));

		board[1][3] = new StartSquare(Color.red, new ImageIcon( path + "images/slides/simpleSquare.png"));
		board[1][4] = new StartSquare(Color.red, new ImageIcon( path + "images/slides/simpleSquare.png"));
		board[2][3] = new StartSquare(Color.red, new ImageIcon( path + "images/slides/simpleSquare.png"));
		board[2][4] = new StartSquare(Color.red, new ImageIcon( path + "images/slides/simpleSquare.png"));

		board[14][13] = new SafetyZoneSquare(Color.yellow, new ImageIcon( path + "images/slides/yellowSquare.png"));
		board[13][13] = new SafetyZoneSquare(Color.yellow, new ImageIcon( path + "images/slides/yellowSquare.png"));
		board[12][13] = new SafetyZoneSquare(Color.yellow, new ImageIcon( path + "images/slides/yellowSquare.png"));
		board[11][13] = new SafetyZoneSquare(Color.yellow, new ImageIcon( path + "images/slides/yellowSquare.png"));
		board[10][13] = new SafetyZoneSquare(Color.yellow, new ImageIcon( path + "images/slides/yellowSquare.png"));
		board[9][12] = new HomeSquare(Color.yellow, new ImageIcon( path + "images/slides/simpleSquare.png"));
		board[9][13] = new HomeSquare(Color.yellow, new ImageIcon( path + "images/slides/simpleSquare.png"));
		board[8][12] = new HomeSquare(Color.yellow, new ImageIcon( path + "images/slides/simpleSquare.png"));
		board[8][13] = new HomeSquare(Color.yellow, new ImageIcon( path + "images/slides/simpleSquare.png"));

		board[14][12] = new StartSquare(Color.yellow, new ImageIcon( path + "images/slides/simpleSquare.png"));
		board[14][11] = new StartSquare(Color.yellow, new ImageIcon( path + "images/slides/simpleSquare.png"));
		board[13][11] = new StartSquare(Color.yellow, new ImageIcon( path + "images/slides/simpleSquare.png"));
		board[13][12] = new StartSquare(Color.yellow, new ImageIcon( path + "images/slides/simpleSquare.png"));

	}

	/**
	 * <Accessor> : returns a random card that has not been played.
	 * If the card is returned, setPlayed is set is true.
	 * <Postcondition> : Player pick a random card of the deck.
	 * @return Card card
	 */
	public Card PickCard() {
		Card c;
		int randomIndex;

		
		if (cardsNum == 0) {
			System.out.println("Let's mix the cards again!");
			initializeDeck();
			cardsNum = 44;
		} else
			System.out.println("Cards left: " + cardsNum);

		while (true) {
			Random rand = new Random(43);
			randomIndex = ThreadLocalRandom.current().nextInt(0, deck.size());
			c = deck.get(randomIndex);
			if (c.isPlayed() == false) {
				break;
			}
		}
		c.setPlayed(true);
		cardsNum--;
		return c;
	}
	
	
	
	/**
	 * <Observer> : checks if the player can not do any move in order
	 * to go fold.
	 * <Postcondition> : Player go fold and the turn changes.
	 * @return boolean fold
	 */
	public boolean canFold() {
		return fold;
	}

	
	/**
	 * <Observer>: If the deck has 0 cards,returns true ,else false.
	 * <Postcondition> : the deck is empty, so cards must be shuffled again.
	 * @return boolean zero
	 */
	public boolean isZeroCards() {
		return zero;
	}

}
