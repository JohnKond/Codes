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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.text.DefaultCaret;

import Model.Card.Card;
import Model.Deck.Deck;
import Model.Square.Square;

public class Gui extends JFrame  {

	
	
    private static String path = "/home/kondo/Desktop/";
	static JFrame win;
	static ImageIcon ic = new ImageIcon(path +"images/background.png");
	static ImageIcon Sorryic = new ImageIcon(path+"images/sorryImage.png");
	static Image newSorryimg = (Sorryic.getImage()).getScaledInstance(45 * 6, 45 * 2, java.awt.Image.SCALE_SMOOTH);
	static JLabel sorry;
	static JLabel rc = new JLabel("Receive card");
	static JLabel cc = new JLabel("Current card");
	static JLabel[] brd = new JLabel[256];
	static JLabel label;
	public static JLabel p1Seven;
	public static JLabel p2Seven;

	static JLabel homeRed = new JLabel();
	static JLabel homeYellow = new JLabel();
	static JLabel startRed = new JLabel();
	static JLabel startYellow = new JLabel();

	static ImageIcon hric = new ImageIcon(path+"images/slides/home.png");
	static Image newHric = (hric.getImage()).getScaledInstance(90, 45, java.awt.Image.SCALE_SMOOTH);

	static ImageIcon startic = new ImageIcon(path+"images/slides/start.png");
	static Image newStartic = (startic.getImage()).getScaledInstance(90, 45, java.awt.Image.SCALE_SMOOTH);

	public  JButton rp1;
	public  JButton rp2;
	public  JButton yp1;
	public  JButton yp2;
	public JButton currGuiPawn;
	public JButton tempGuiPawn;
	public JButton sorryGuiPawn = new JButton();
	public JButton forw,back,enter;
	public JButton swap,move11;
	
	static ImageIcon rp1ic = new ImageIcon(path+"images/pawns/redPawn1.png");
	static ImageIcon rp2ic = new ImageIcon(path+"images/pawns/redPawn2.png");
	static ImageIcon yp1ic = new ImageIcon(path+"images/pawns/yellowPawn1.png");
	static ImageIcon yp2ic = new ImageIcon(path+"images/pawns/yellowPawn2.png");

	static Image newRp1ic = (rp1ic.getImage()).getScaledInstance(38, 38, java.awt.Image.SCALE_SMOOTH);
	static Image newRp2ic = (rp2ic.getImage()).getScaledInstance(38, 38, java.awt.Image.SCALE_SMOOTH);
	static Image newYp1ic = (yp1ic.getImage()).getScaledInstance(38, 38, java.awt.Image.SCALE_SMOOTH);
	static Image newYp2ic = (yp2ic.getImage()).getScaledInstance(38, 38, java.awt.Image.SCALE_SMOOTH);

	public static JTextArea info,p1Move,p2Move;
	static JScrollPane scroll;
	
	public JLabel curCard;
	public  JButton but;
	public  JButton butFold;
	static ImageIcon butIc = new ImageIcon(path+"images/cards/backCard.png");
	static Image img = butIc.getImage();
	static Image newImg = img.getScaledInstance(100, 140, java.awt.Image.SCALE_SMOOTH);
	public  ImageIcon image;
	public  Card c;
	static Square sqr, sqr2;
	static Deck board = new Deck();

	void createReceiveCardButton() {

		but = new JButton();
		butIc = new ImageIcon(newImg);
		but.setIcon(butIc);
		but.setSize(100, 140);
		but.setBounds(780, 200, 100, 140);
		
		

		rc.setSize(100, 140);
		rc.setBounds(790, 350, 100, 40);
	}

	void createFoldButton() {
		butFold = new JButton();
		butFold.setBackground(Color.RED);
		butFold.setText("Fold Button");
		butFold.setSize(30, 200);
		butFold.setBounds(780, 400, 230, 40);
		
	}

	void createCurrCardLabel() {
		curCard = new JLabel();
		curCard.setSize(100, 140);
		curCard.setBounds(900, 200, 100, 140);

		cc.setSize(100, 140);
		cc.setBounds(910, 350, 100, 40);
	}

	

	void createBoard() {

		int x = 0;
		int y = 0;
		int lab = 0;
		int width = 45;
		int height = 45;
		ImageIcon imageSq;
		this.getContentPane().setLayout(new FlowLayout());
		Border border = BorderFactory.createLineBorder(Color.BLACK, 3);

		for (int i = 0; i <= 15; i++) {

			if (board.board[0][i] != null) {

				brd[lab] = new JLabel();
				brd[lab].setBorder(border);
				sqr = board.board[0][i];
				imageSq = new ImageIcon(sqr.getImage());
				brd[lab].setIcon(imageSq);
				brd[lab].setBounds(x, y, width, height);
				label.add(brd[lab]);
				x += 45;
			}
		}

		x = 0;
		for (int i = 0; i <= 15; i++) {
			if (board.board[i][0] != null) {
				brd[lab] = new JLabel();
				brd[lab].setBorder(border);
				sqr = board.board[i][0];
				imageSq = new ImageIcon(sqr.getImage());
				brd[lab].setIcon(imageSq);
				brd[lab].setBounds(x, y, width, height);
				label.add(brd[lab]);
				y += 45;
			}
		}

		x = 0;
		y -= 45;

		for (int i = 0; i <= 15; i++) {

			if (board.board[15][i] != null) {
				brd[lab] = new JLabel();
				brd[lab].setBorder(border);
				sqr = board.board[15][i];
				imageSq = new ImageIcon(sqr.getImage());
				brd[lab].setIcon(imageSq);
				brd[lab].setBounds(x, y, width, height);
				label.add(brd[lab]);
				x += 45;
			}
		}

		x = 720 - 45;
		y = 0;

		for (int i = 0; i <= 15; i++) {
			if (board.board[i][15] != null) {
				brd[lab] = new JLabel();
				brd[lab].setBorder(border);
				sqr = board.board[i][15];
				imageSq = new ImageIcon(sqr.getImage());
				brd[lab].setIcon(imageSq);
				brd[lab].setBounds(x, y, width, height);
				label.add(brd[lab]);
				y += 45;
			}
		}

		x = 90;
		y = 45;

		for (int i = 1; i <= 5; i++) {
			if (board.board[i][2] != null) {
				brd[lab] = new JLabel();
				brd[lab].setBorder(border);
				sqr = board.board[i][2];
				imageSq = new ImageIcon(sqr.getImage());
				brd[lab].setIcon(imageSq);
				brd[lab].setBounds(x, y, width, height);
				label.add(brd[lab]);
				y += 45;
			}
		}

		x = 585;
		y = 450;

		for (int i = 10; i <= 14; i++) {
			if (board.board[i][13] != null) {
				brd[lab] = new JLabel();
				brd[lab].setBorder(border);
				sqr = board.board[i][13];
				imageSq = new ImageIcon(sqr.getImage());
				brd[lab].setIcon(imageSq);
				brd[lab].setBounds(x, y, width, height);
				label.add(brd[lab]);
				y += 45;
			}
		}

		/**
		 * Red Home Square
		 */

		brd[lab] = new JLabel();
		brd[lab].setBorder(BorderFactory.createMatteBorder(4, 4, 0, 0, Color.RED));
		brd[lab].setIcon(new ImageIcon(board.board[6][2].getImage()));
		brd[lab].setBounds(67, 270, width, height);
		label.add(brd[lab]);

		brd[lab] = new JLabel();
		brd[lab].setBorder(BorderFactory.createMatteBorder(4, 0, 0, 4, Color.RED));
		brd[lab].setIcon(new ImageIcon(board.board[6][3].getImage()));
		brd[lab].setBounds(67 + 45, 270, width, height);
		label.add(brd[lab]);

		hric = new ImageIcon(newHric);
		homeRed = new JLabel(hric);
		homeRed.setBorder(BorderFactory.createMatteBorder(0, 4, 4, 4, Color.RED));
		homeRed.setBounds(67, 7 * 45, 90, 45);

		label.add(homeRed);
		
		/* Red Start Square */

		brd[lab] = new JLabel();
		brd[lab].setBorder(BorderFactory.createMatteBorder(4, 4, 0, 0, Color.RED));
		brd[lab].setIcon(new ImageIcon(board.board[1][3].getImage()));
		brd[lab].setBounds(45 * 3 + 22, 45, width, height);
		label.add(brd[lab]);

		brd[lab] = new JLabel();
		brd[lab].setBorder(BorderFactory.createMatteBorder(4, 0, 0, 4, Color.RED));
		brd[lab].setIcon(new ImageIcon(board.board[1][4].getImage()));
		brd[lab].setLayout(new BorderLayout());
		brd[lab].setBounds(45 * 4 + 22, 45, width, height);
		
		
		
		label.add(brd[lab]);
	

		startic = new ImageIcon(newStartic);
		startRed = new JLabel(startic);
		startRed.setBorder(BorderFactory.createMatteBorder(0, 4, 4, 4, Color.RED));
		startRed.setBounds(45 * 3 + 22, 90, 90, 45);
		
		label.add(startRed);

		/**
		 * Yellow Home Square
		 */

		brd[lab] = new JLabel();
		brd[lab].setBorder(BorderFactory.createMatteBorder(0, 4, 4, 0, Color.YELLOW));
		brd[lab].setIcon(new ImageIcon(board.board[9][12].getImage()));
		brd[lab].setBounds(562, 360 + 45, width, height);
		label.add(brd[lab]);

		brd[lab] = new JLabel();
		brd[lab].setBorder(BorderFactory.createMatteBorder(0, 0, 4, 4, Color.YELLOW));
		brd[lab].setIcon(new ImageIcon(board.board[9][13].getImage()));
		brd[lab].setBounds(562 + 45, 360 + 45, width, height);
		label.add(brd[lab]);

		homeYellow = new JLabel(hric);
		homeYellow.setBorder(BorderFactory.createMatteBorder(4, 4, 0, 4, Color.YELLOW));
		homeYellow.setBounds(562, 8 * 45, 90, 45);
		
		label.add(homeYellow);

		/* Yellow Start Square */

		brd[lab] = new JLabel();
		brd[lab].setBorder(BorderFactory.createMatteBorder(0, 4, 4, 0, Color.YELLOW));
		brd[lab].setIcon(new ImageIcon(board.board[14][11].getImage()));
		brd[lab].setBounds(10 * 45 + 22, 14 * 45, width, height);
		label.add(brd[lab]);

		brd[lab] = new JLabel();
		brd[lab].setBorder(BorderFactory.createMatteBorder(0, 0, 4, 4, Color.YELLOW));
		brd[lab].setIcon(new ImageIcon(board.board[14][12].getImage()));
		brd[lab].setBounds(11 * 45 + 22, 14 * 45, width, height);
		label.add(brd[lab]);

		startYellow = new JLabel(startic);
		startYellow.setBorder(BorderFactory.createMatteBorder(4, 4, 0, 4, Color.YELLOW));
		startYellow.setBounds(10 * 45 + 22, 13 * 45, 90, 45);

		label.add(startYellow);
		/** 
		 * Add pawns to home square 
		 */

		rp1 = new JButton();
		rp1.setIcon(new ImageIcon(newRp1ic));
		rp1.setBorder(border);
		rp1.setBounds(45*3+22, 52, 38, 38);
		
		
		
		rp2 = new JButton();
		rp2.setIcon(new ImageIcon(newRp2ic));
		rp2.setBorder(border);
		rp2.setBounds(45*4+22, 52, 38, 38);
	
		
		yp1 = new JButton();
		yp1.setIcon(new ImageIcon(newYp1ic));
		yp1.setBorder(border);
		yp1.setBounds(45*10+22, 14*45+7 , 38, 38);
		
		
		yp2 = new JButton();
		yp2.setIcon(new ImageIcon(newYp2ic));
		yp2.setBorder(border);
		yp2.setBounds(45*11+22,  14*45+7 , 38, 38);
	
		
		
		
		/**
		 * Sorry Image
		 */

		Sorryic = new ImageIcon(newSorryimg);
		sorry = new JLabel(Sorryic);
		sorry.setBounds(360 - 45 * 3, 360, 45 * 6, 45 * 2);

	}
	
	
	void createTextArea() {
		info = new JTextArea(230,140);
		info.setText("  Info Box \n\n");
		DefaultCaret caret = (DefaultCaret) info.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);	
		info.setEditable(false);
		
		scroll = new JScrollPane(info);
		scroll.setBounds(780,460,230,140);		
	}
	
	
	void numberTenButtons() {
		forw = new JButton();
		back = new JButton();
		
		
		forw.setBackground(Color.GRAY);
		forw.setText("<html>10 squares<br> &nbsp; forward </html>");
		forw.setSize(100, 50);
		forw.setBounds(780, 100, 100, 50);
		forw.setVisible(false);
		
		back.setBackground(Color.GRAY);
		back.setText("<html>1 square <br>  backwards </html>");
		back.setSize(100, 50);
		back.setBounds(900, 100, 100, 50);
		back.setVisible(false);
	}
	
	void numberSevenButtons() {
		p1Move = new JTextArea();
		p1Move.setBounds(780,100,80,30);
		p1Move.setVisible(false);
		p1Seven = new JLabel("Pawn 1:");
		p1Seven.setBounds(780,70,80,30);
		p1Seven.setVisible(false);
		
		p2Move = new JTextArea();
		p2Move.setBounds(900,100,80,30);
		p2Move.setVisible(false);
		p2Seven = new JLabel("Pawn2 :");
		p2Seven.setBounds(900,70,80,30);
		p2Seven.setVisible(false);
		
		enter = new JButton("Enter");
		enter.setBounds(780+60,150,85,30);
		enter.setVisible(false);
	}
	
	void numberElevenButtons() {
		swap = new JButton();
		swap.setBackground(Color.CYAN);
		swap.setText("<html> Swap positions </html>");
		swap.setBounds(780, 100, 100, 50);
		swap.setVisible(false);
		
		
		move11 = new JButton();
		move11.setBackground(Color.CYAN);
		move11.setText("<html>11 squares<br> &nbsp; forward </html>");
		move11.setBounds(900, 100, 100, 50);
		move11.setVisible(false);
	}
	
	

	void createLabel() {
		label = new JLabel(ic);

	}

	void createWindow() {
		win = new JFrame("Sorry Game");
		win.setVisible(true);
		win.setLayout(new FlowLayout());
		win.setSize(1040, 810);
		//win.setSize(WIDTH,HEIGHT);
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	

	
	

	public Gui() {
		createLabel();
		createReceiveCardButton();
		createFoldButton();
		createCurrCardLabel();
		createBoard();
		createTextArea(); 
		numberTenButtons();
		numberSevenButtons();
		numberElevenButtons();
		createWindow();
	
		label.add(but);
		label.add(rc);
		label.add(butFold);
		label.add(curCard);
		label.add(cc);
		label.add(sorry);
		label.add(forw);
		label.add(back);
		label.add(p1Move);
		label.add(p1Seven);
		label.add(p2Seven);
		label.add(p2Move);
		label.add(enter);
		label.add(swap);
		label.add(move11);
		label.add(scroll);
		
		
		
	    JLayeredPane pane = win.getLayeredPane();
		pane.add(label);
		pane.add(rp1);
		pane.add(rp2);
		pane.add(yp1);
		pane.add(yp2);
		
	

		win.add(label);
	}
	
	
}
