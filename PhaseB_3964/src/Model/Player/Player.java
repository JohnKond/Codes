package Model.Player;

import javax.swing.ImageIcon;

import Model.Color.Color;
import Model.Pawn.Pawn;
import Model.Square.Square;


/**
 * This class implements the player of the game.
 * @author 3964
 *
 */

public class Player {

	private Color color;
	private String name;
	private int number;
	private boolean hasPlayed = false;
	public Pawn pawn1;
	public Pawn pawn2;
	private int activePawns = 2;

	
	/**
	 * <Constructor> : constructs a new player with the given name(name) and color (color).
	 * <PostCondition> : creates a new player with name(name) and color (color). Also, initializes
	 * some 
	 * @param String name
	 * @param Color color
	 */
	public Player(String name, Color color,int number) {
		this.name = name;
		this.color = color;
		this.number = number;
		hasPlayed = false;
	}

	/**
	 * <Transformer> : sets the name of a player.
	 * <Postcondition> : name of the player has been set.
	 * @param String name
	 */
	public void setName(String name) {

	}

	/**
	 * <Accessor> : returns the name of name of a player
	 * <Postcondition> : the name of the player has been returned.
	 * @return String name
	 */
	public String getName() {
		return name;
	}
	
	
	/**
	 * <Transformer> : sets the color of a player.
	 * <Postcondition> : the color of the player has been set.
	 * @param Color color
	 */
	public void setColor(Player p,Color color) {
       p.color = color;
	}

	
	/**
	 * <Accessor> : returns the color of the given Player(p).
	 * <Postcondition> : the color of the Player(p) has been returned.
	 * @param Player p
	 * @return
	 */
	public Color getColor(Player p) {
		return p.color;
	}
	
	
	
	public int getNumber() {
		return number;
	}
	

	/**
	 * <Transformer> : Creates and initializes the pawns of each player,based on the color
	 * <Postcondition> : If the color is red, set red pawns in red start position
	 * on the board,else set yellow pawns in yellow start position 
	 * @param Color color
	 */
	public void initializePawns(Color color,Player player,Square square[][]) {
		if (color == Color.red) {
			pawn1 = new Pawn(square[1][3],1,3,player,Color.red,1,new ImageIcon("C:/Users/ΓΚΕΙ/Desktop/images/pawns/redPawn1.png"));
			pawn2 = new Pawn(square[1][4],1,4,player,Color.red,2,new ImageIcon("C:/Users/ΓΚΕΙ/Desktop/images/pawns/redPawn2.png"));
		}else {
			pawn1 = new Pawn(square[14][11],14,11,player,Color.yellow,1,new ImageIcon("C:/Users/ΓΚΕΙ/Desktop/images/pawns/yellowPawn1.png"));
			pawn2 = new Pawn(square[14][12],14,12,player,Color.yellow,2,new ImageIcon("C:/Users/ΓΚΕΙ/Desktop/images/pawns/yellowPawn2.png"));
		}
	}


	 public void reduceActivePawns() {
	    	activePawns --;
	    }
	    
	    public int getActivePawns() {
	    	return activePawns;
	    }
	    
	
	
	public void play(boolean hasPlayed) {
		this.hasPlayed = hasPlayed;
	}
	
	
	
  /**
   * <Accessor> : returns true if the player has made has played his turn, else false.
   * <Postcondition> : returns true if the player has made has played his turn, else false.
   * @return boolean hasPlayed
   */
	public boolean hasPlayed() {
		return hasPlayed;
	}

	
	/**
	 * <Accessor> : returns true if the player has won the game.
	 * <Precondition> : all of the player's pawns must be in home position.
	 * <Postcondition> : returns true if the player has won the game.
	 * @return
	 */
	public boolean hasWon() {
		return false;
	}

}
