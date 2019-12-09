package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import Model.Card.Card;
import Model.Deck.Deck;
import Model.Pawn.Pawn;
import Model.Square.Square;


/**
 * This class is responsible for the initialization of the graphical environment of the game.
 * @author 3964
 */

public class Gui extends JFrame  {

	static JFrame win;
	
	static String path = "C:/Users/ΓΚΕΙ/Desktop/images/";
	static ImageIcon ic = new ImageIcon(path + "background.png");
	static ImageIcon Sorryic = new ImageIcon(path +"sorryImage.png");
	static ImageIcon rp1ic = new ImageIcon(path +"pawns/redPawn1.png");
	static ImageIcon rp2ic = new ImageIcon(path +"pawns/redPawn2.png");
	static ImageIcon yp1ic = new ImageIcon(path +"pawns/yellowPawn1.png");
	static ImageIcon yp2ic = new ImageIcon(path +"pawns/yellowPawn2.png");
	static ImageIcon hric = new ImageIcon(path +"slides/home.png");
	static ImageIcon startic = new ImageIcon(path +"slides/start.png");
	static ImageIcon butIc = new ImageIcon(path +"cards/backCard.png");
	
	static Image newSorryimg = (Sorryic.getImage()).getScaledInstance(45 * 6, 45 * 2, java.awt.Image.SCALE_SMOOTH);
	static Image newRp1ic = (rp1ic.getImage()).getScaledInstance(38, 38, java.awt.Image.SCALE_SMOOTH);
	static Image newRp2ic = (rp2ic.getImage()).getScaledInstance(38, 38, java.awt.Image.SCALE_SMOOTH);
	static Image newYp1ic = (yp1ic.getImage()).getScaledInstance(38, 38, java.awt.Image.SCALE_SMOOTH);
	static Image newYp2ic = (yp2ic.getImage()).getScaledInstance(38, 38, java.awt.Image.SCALE_SMOOTH);
    static Image newHric = (hric.getImage()).getScaledInstance(90, 45, java.awt.Image.SCALE_SMOOTH);
	static Image newStartic = (startic.getImage()).getScaledInstance(90, 45, java.awt.Image.SCALE_SMOOTH);
	static Image newImg = (butIc.getImage()).getScaledInstance(100, 140, java.awt.Image.SCALE_SMOOTH);
	
	static JLabel label;
	static JLabel sorry;
	static JLabel rc = new JLabel("Receive card");
	static JLabel cc = new JLabel("Current card");
	static JLabel homeRed = new JLabel();
	static JLabel homeYellow = new JLabel();
	static JLabel startRed = new JLabel();
	static JLabel startYellow = new JLabel();
	static JLabel[] brd = new JLabel[256];
	public JLabel curCard;
	static JTextArea info;

	public  JButton rp1;
	public  JButton rp2;
	public  JButton yp1;
	public  JButton yp2;
	
	public  JButton but;
	public  JButton butFold;
	
	static  Card c;
	static Square sqr, sqr2;
	static Deck board = new Deck();

	
	/**
	 * <Transformer> : creates the receive card button with the
	 * background card image.
	 * <Postcondition> : the receive card button has been created.
	 */
	void createReceiveCardButton() {

	}

	
	/**
	 * <Transformer> : creates the fold button painted with red background.
	 * <Postcondition> : the fold button has been created.
	 */
	void createFoldButton() {
		
	}

	
	/**
	 * <Transformer> : creates the "current card" label, underneath
	 * the current card
	 * <Postcondition> : "current card" label has been created.
	 */
	void createCurrCardLabel() {
		
	}

	

	/**
	 * <Transformer> : creates the board of the game with every square's image.
	 * Also, creates home and start squares .
	 * <Postcondition> : board has been created.
	 */
	void createBoard() {

	}
	
	/**
	 * <Transformer> : places pawns in start squares of each players
	 * <Postcondition> : pawns has been placed.
	 */
    void placePawns() {
    	
    }
	
	
	
    /**
     * <Transformer> : creates the basic label of the game. Above this label,
     * will places other labels like card button , pawns and squares.
     * <Postcondition> : basic label has been created.
     */
	void createLabel() {
		label = new JLabel(ic);

	}

	/**
	 * <Transformer> : creates the window of the game.
	 * <Postcondition> : window of the game has been created.
	 */
	void createWindow() {
		
	}
	
	
   /**
    * <Constructor> : calls the all the essentials methods,in order to create 
    * the graphical environment of the game
    * <Postcondition> : graphical environment has been created.
    */
	public Gui() {
	
	}
	
	
	

	
}
