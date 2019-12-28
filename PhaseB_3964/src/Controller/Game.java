package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import Model.Card.Card;
import Model.Color.Color;
import Model.Deck.Deck;
import Model.Pawn.Pawn;
import Model.Player.Player;
import Model.Square.EndSlideSquare;
import Model.Square.HomeSquare;
import Model.Square.SafetyZoneSquare;
import Model.Square.StartSlideSquare;
import Model.Square.StartSquare;
import View.Gui;

public class Game {

    private int start = 0; 
	private boolean swap;
	private Player currPlayer;
	private Pawn currPawn;
	private Pawn tempPawn;
	private Pawn sorryPawn;
	private Card currCard;
	private boolean canPickCard = true;
	private String update = "";
	private int counter = 0;
	private int number,numberTemp1,numberTemp2,n1,n2;
	private int sevenCount = 0;
	public static ActionListener act;
	public int prevCoorX;
	public int prevCoorY;
	
	
	Deck board;
	public Gui view;
	public Pawn redPawn1,redPawn2,yellowPawn1,yellowPawn2;
	
	
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
		 
		currPlayer = board.player1;
		update = "Turn: Player 1 (Red)\n";
		view.info.append(update); 
		
		
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
	    view.but.addActionListener(CardListener);
	    view.butFold.addActionListener(CardListener);
	    view.forw.addActionListener(CardListener);
	    view.back.addActionListener(CardListener);
	    view.enter.addActionListener(CardListener);
	    view.swap.addActionListener(CardListener);
	    view.move11.addActionListener(CardListener);
	    
	    view.sorryGuiPawn = new JButton();	
	    
	    ActionListener PawnListener = new PawnListener();
	    view.rp1.addActionListener(PawnListener);
	    view.rp2.addActionListener(PawnListener);
	    view.yp1.addActionListener(PawnListener);
	    view.yp2.addActionListener(PawnListener);
	    
	    
	    
	}
	
	/**
	 * <Accessor> Function to check the game initialization.
	 * <Precondition> Pawns and squares must all be set.
	 * <Postocondition> Game is ready to start.  
	 * @return boolean start
	 */
	public boolean readyToStart() {
		
		if (redPawn1.getRow() == 1   &&  redPawn1.getColumn()  == 3) {
			if (redPawn2.getRow()== 1  && redPawn2.getColumn()  == 4) {
				if (yellowPawn1.getRow()== 14  &&  yellowPawn1.getColumn()  == 11) {
					if (yellowPawn2.getRow() == 14  &&  yellowPawn2.getRow ()== 12) {
						update +="Game is ready to start !";
						return true;
				    }
		     	}
		    }
		}
		
		return false;
	}
	

	/**
	 * <Transformer> : if the player has made his move , we change the turn 
	 * via method hasPlayer() in Model.Player.
	 * <PostCondition> : turn of round has been updated.
	 */
	public void changeTurn() {
		
		

		
		if (currPlayer == board.player1) {
			currPlayer = board.player2;
			update = "\nTurn: Player 2 (Yellow)\n";
		} else {
			currPlayer = board.player1;
			update = "\nTurn: Player 1 (Red)\n";
		}
	
		
		currPlayer.play(false);
	}

	
	/**
	 * <Accessor> : returns the current player.
	 * <Postcondition> : current player has been returned.
	 * @return boolean turn
	 */
	public Player isTurn() {
		return currPlayer;
	}


	
	
	/**
	 * Function that will be used only for JUnit Tests
	 * <Transformer> : sets current card as parameter card
	 * <Postcondition> : card has been set.
	 * @param Card card
	 */
	public void setCurrCard(Card card) {
		currCard = card;
	}

	


	 /**
	  * <Transformer> : Makes the necessary actions if the receive card button 
	  * is being pressed.
	  * <Postcondition> : A new card has been pulled.
	  */
	 private class CardListener implements ActionListener {

				
		@Override
		public void actionPerformed(ActionEvent e)  {
		
			Object source = e.getSource();
			
			
			
			if (source == view.but) {
				if (canPickCard) {
				update += "Cards Left :" + board.cardsNum + "\n";
				view.forw.setVisible(false);
				view.back.setVisible(false);
				view.p1Move.setVisible(false);
				view.p1Seven.setVisible(false);
				view.p2Move.setVisible(false);
				view.p2Seven.setVisible(false);
				view.enter.setVisible(false);
				view.swap.setVisible(false);
				view.move11.setVisible(false);
				
				currCard = board.PickCard();
				
				number = currCard.getNumber();
				view.curCard.setIcon(new ImageIcon(currCard.getImage()));
				update += "You picked card :" + currCard.getNumber() +"\n";
				update += currCard.toString();
				view.info.append(update+"\n");
				view.info.setCaretPosition(view.info.getDocument().getLength());
				canPickCard = false;
				
				
				if (currCard.getNumber() == 10) {
					view.forw.setVisible(true);
					view.back.setVisible(true);
				}
				
				if (currCard.getNumber() == 7) {
					view.p1Move.setVisible(true);
					view.p1Seven.setVisible(true);
					view.p2Move.setVisible(true);
					view.p2Seven.setVisible(true);
					view.enter.setVisible(true);
				}
				
				
				if (currCard.getNumber() == 11) {
					view.swap.setVisible(true);
					view.move11.setVisible(true);
				}
				
				if (counter == 1) {
					currPlayer.play(false);
					counter = 0;
				}
				
			}else {
				throw new UnsupportedOperationException("Cannot pick card.");
			}
	   }
			
			if (source == view.butFold) {
				changeTurn();
				canPickCard = true;
				swap = false;
				counter = 0;
				sevenCount = 0;
				
			}
			
			if (source == view.forw) {
				number = 10;
			}
			
			if (source == view.back) {
				number = -1;
			}
			
			if (source == view.enter) {
				
				
				
				n1 = Integer.parseInt(view.p1Move.getText());
				n2 = Integer.parseInt(view.p2Move.getText());
				
				if (n1>=0 && n1<=7 && n2>=0 && n2<=7){
					
					if (n1 + n2 != 7) {
						update = "Wrong input.Try again.";
						view.info.append(update+"\n");
						view.info.setCaretPosition(view.info.getDocument().getLength());
						n1=0;
						n2=0;
						currPlayer.play(true);
						return;
					}
					else
					{
						System.out.println("Right\n");
						numberTemp1 = n1;
						numberTemp2 = n2;
						currPlayer.play(false);
					}
				} else {
					update = "Wrong input.Try again.";
					view.info.append(update+"\n");
					view.info.setCaretPosition(view.info.getDocument().getLength());
					currPlayer.play(true);
					n1=0;
					n2=0;
					return;
				}
			}
			
			
			if (source == view.swap) {
				swap = true;
				System.out.println("Swap true");
			}else {
				swap = false;
			}
	  }
	 }
		
		
	 /**
	  * <Transformer> : class PawnListener implements the ActionListener for
      * pawn buttons ( redPawn1,redPawn2,yellowPawn3,yellowPawn4),
      * and makes the essential actions if a button is pushed.	
	  * <Postcondition> : Makes the necessary actions if the pawn button 
	  * is being pressed.
	  */
		private class PawnListener implements ActionListener {


			private int newX ; 
			private int newY ;
			private int sorryPawnX;
			private int sorryPawnY;
			private int tempX,tempY,tempCurrX,tempCurrY;
			private boolean sorry = false;
			int curri,curry,sorryi,sorryy;
			int steps = 0;
			
			
			
			
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
			public void slide(Pawn pawn) {
				
				currPawn.prevI = currPawn.i;
				currPawn.prevJ = currPawn.j;
				
				
				while(!(pawn.pawnPosition instanceof EndSlideSquare)){
					if (newX == 678) {
						newY = newY + 45;
						pawn.i++;
						pawn.setPawnPosition(board.board[pawn.i][pawn.j]);
						view.currGuiPawn.setLocation(newX, newY);
					}else if(newY == 684) {
						newX = newX - 45;
						pawn.j--;
						pawn.setPawnPosition(board.board[pawn.i][pawn.j]);
						view.currGuiPawn.setLocation(newX, newY);
					}
					else if(newX == 3) {
						newY = newY - 45;
						pawn.i--;
						pawn.setPawnPosition(board.board[pawn.i][pawn.j]);
						view.currGuiPawn.setLocation(newX, newY);
					}else if (newY == 9) {
						newX = newX + 45;
						pawn.j++;
						pawn.setPawnPosition(board.board[pawn.i][pawn.j]);
						view.currGuiPawn.setLocation(newX, newY);
					}
					
					
					
					if (board.board[currPawn.i][currPawn.j].isOccupied()) {
						tempPawn = board.board[currPawn.i][currPawn.j].getPawn();
						collision(currPawn,tempPawn);
					}
					
				
					board.board[pawn.prevI][pawn.prevJ].setOccuped(false);
				}
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
			public void collision(Pawn currPawn, Pawn tempPawn) {
				if (tempPawn.getColor() == Color.red) {
					
				  if (tempPawn.getNumber() == 1) {
				     tempPawn.i = 1;
				     tempPawn.j = 3;
				     tempX = 157;
				     tempY = 52;
				     view.tempGuiPawn = view.rp1;
				  }else {
					tempPawn.i = 1;
					tempPawn.j = 4;
				     tempX = 202;
				     tempY = 52;
				     view.tempGuiPawn = view.rp2;
				  }
				}else {
					if (tempPawn.getNumber() == 1) {
					tempPawn.i = 14;
					tempPawn.j = 11;
					tempX = 472;
					tempY = 637;
					view.tempGuiPawn = view.yp1;
				     }else {
					tempPawn.i = 14;
					tempPawn.j = 12;
				    tempX = 517;
				    tempY = 637;
				    view.tempGuiPawn = view.yp2;
				 }
				}
				
				
				
				tempPawn.setPawnPosition(board.board[tempPawn.i][tempPawn.j]);
				view.tempGuiPawn.setLocation(tempX, tempY);
				
				
			}
			
			/**
			 * <Transformer> : moves the pawn (pawn) in a different square ,
			 * according to the current card rules and the player's turn.
			 * <Precondition> : move of the pawn in the board must be valid.
			 * <Postcondition> : pawn has been moved.
			 * @param Pawn pawn
			 */
			public void movePawn(Pawn currPawn) {
				
				
				currPawn.setPawnPosition(board.board[currPawn.i][currPawn.j]);
				board.board[currPawn.prevI][currPawn.prevJ].setOccuped(false);
				board.board[currPawn.i][currPawn.j].setOccuped(true);
				board.board[currPawn.i][currPawn.j].setPawn(currPawn);
				view.currGuiPawn.setLocation(newX, newY);
				
			}
			
			
			/**
			 * <Transformer> : pawn1 takes the place of pawn2 , and pawn2 takes place
			 * pawn 1.
			 * <Precondition> : pawns must have different colors, and mist not occupie a 
			 * safety zone,start or a home square.
			 * <Postcondition> : pawn1 and pawn2 swap places
			 * @param Pawn currPawn
			 * @param Pawn sorryPawn
			 */
			public void swap(Pawn currPawn,Pawn sorryPawn) {
				tempX = sorryPawnX;
				tempY = sorryPawnY;
				tempCurrX = newX;
				tempCurrY = newY;
				
				
				curri = currPawn.i;
				curry = currPawn.j;
				sorryi = sorryPawn.i;
				sorryy = sorryPawn.j;
				
				sorryPawn.i = currPawn.i;
				sorryPawn.j = currPawn.j;
				currPawn.i  = sorryi;
				currPawn.j  = sorryy;
				
				
				
					
				currPawn.setPawnPosition(board.board[sorryi][sorryy]);
				board.board[sorryi][sorryy].setPawn(currPawn);
				view.currGuiPawn.setLocation(tempX, tempY);
				
				sorryPawn.setPawnPosition(board.board[curri][curry]);
				board.board[curri][curry].setPawn(sorryPawn);
				view.sorryGuiPawn.setLocation(tempCurrX, tempCurrY);
			}
			
			
			
			/**
			 * <Transformer> : Every time a pawn is being clicked, 
			 */
			@Override
			public void actionPerformed(ActionEvent e)  {
				
				Object source = e.getSource();
				Object sorrySource = e.getSource();
				
				
				
				if (!sorry) {
				
				if (source == view.rp1) {
				    currPawn = redPawn1;
				    newX = view.rp1.getX();
				    newY = view.rp1.getY();
				    view.currGuiPawn = view.rp1;
				} else if (source == view.rp2) {
					currPawn = redPawn2;
				    newX = view.rp2.getX();
				    newY = view.rp2.getY();
				    view.currGuiPawn = view.rp2;
				} else if (source == view.yp1) {
					currPawn = yellowPawn1;
				    newX = view.yp1.getX();
				    newY = view.yp1.getY();
				    view.currGuiPawn = view.yp1;
				} else if (source == view.yp2) {
					currPawn = yellowPawn2;
				    newX = view.yp2.getX();
				    newY = view.yp2.getY();
				    view.currGuiPawn = view.yp2;
				} 
				
				} else {
				if (sorrySource == view.rp1) {
				    sorryPawn = redPawn1;
				    sorryPawn.i = redPawn1.i;
				    sorryPawn.j = redPawn1.j;
				    sorryPawnX = view.rp1.getX();
				    sorryPawnY = view.rp1.getY();
				    view.sorryGuiPawn = view.rp1;
				} else if (sorrySource == view.rp2) {
					sorryPawn = redPawn2;
				    sorryPawn.i = redPawn2.i;
				    sorryPawn.j = redPawn2.j;
					sorryPawnX = view.rp2.getX();
					sorryPawnY = view.rp2.getY();
				    view.sorryGuiPawn= view.rp2;
				} else if (sorrySource == view.yp1) {
					sorryPawn = yellowPawn1;
				    sorryPawn.i = yellowPawn1.i;
				    sorryPawn.j = yellowPawn1.j;
					sorryPawnX = view.yp1.getX();
					sorryPawnY = view.yp1.getY();
				    view.sorryGuiPawn = view.yp1;
				} else if (sorrySource == view.yp2) {
					sorryPawn = yellowPawn2;
				    sorryPawn.i = yellowPawn2.i;
				    sorryPawn.j = yellowPawn2.j;
					sorryPawnX = view.yp2.getX();
					sorryPawnY = view.yp2.getY();
				    view.sorryGuiPawn = view.yp2;
				}			
				}
			
	       
			
				
				
				
				
				
				if ( currPlayer == currPawn.getPlayer() && !currPawn.getPlayer().hasPlayed() && !currPawn.isHome()) {
					
			
					if ( currPawn.pawnPosition instanceof StartSquare ){
						if( currCard.getNumber() == 1  ||  currCard.getNumber() == 2){ 
						   
					       

						
					       if (currPawn == redPawn1) {
					           newX = newX + 26;
					           newY = newY - 43;
					           currPawn.i=0;
					           currPawn.j=4;
								currPawn.prevI = 1;
								currPawn.prevJ = 3;
					       } else if (currPawn == redPawn2){
					    	   newX = newX - 19;
						       newY = newY - 43;
						       currPawn.i=0;
						       currPawn.j=4;
								currPawn.prevI = 1;
								currPawn.prevJ = 4;
					       } else if (currPawn == yellowPawn1) {
					    	   newX = newX + 26;
					    	   newY = newY + 47; 
					    	   currPawn.i = 15;
					    	   currPawn.j = 11;		
								currPawn.prevI = 14;
								currPawn.prevJ = 11;
					       }else if (currPawn == yellowPawn2) {
					    	   newX = newX -19;
					    	   newY = newY + 47; 
					    	   currPawn.i = 15;
					    	   currPawn.j = 11;
								currPawn.prevI = 14;
								currPawn.prevJ = 12;
					       }
					       
					       
							
								
					       
					       
					       
					       
						 } else if (currCard.getNumber() == 0) {
													
							    if (!sorry) {
							    	sorry = true;
							    	return;
							    }
	
							if ((!(sorryPawn.pawnPosition instanceof StartSquare)) 
							  &&(!(sorryPawn.pawnPosition instanceof SafetyZoneSquare)) 
							    &&(!(sorryPawn.pawnPosition instanceof HomeSquare)) 
							       &&(sorryPawn.getColor() != currPawn.getColor())){   	
							    
							            newX = sorryPawnX;
							            newY = sorryPawnY;
							            currPawn.i = sorryPawn.i;
							            currPawn.j = sorryPawn.j;
							            sorry = false;
							      
					      }else return;
						 }
						
						

						
						
					   
					} else {
						
						currPawn.prevI = currPawn.i;
						currPawn.prevJ = currPawn.j;
						prevCoorX = newX;
						prevCoorY = newY;
						
						
						
						
						
						if (currCard.getNumber() == 4) {
							number = -4;
						}
						
						
						if (currCard.getNumber() == 7) {
							if (currPawn.getNumber() == 1) {
								number = numberTemp1;
							}else {
								number = numberTemp2;
							}
							sevenCount++;
						}
						
						
						
						if (currCard.getNumber() == 11 && swap) {
							    if (!sorry) {
							    	sorry = true;
							    	return;
							    }
	
							if ((!(sorryPawn.pawnPosition instanceof StartSquare)) 
							  &&(!(sorryPawn.pawnPosition instanceof SafetyZoneSquare)) 
							    &&(!(sorryPawn.pawnPosition instanceof HomeSquare)) 
							       &&(sorryPawn.getColor() != currPawn.getColor())){   	
							    
								
								
								        swap(currPawn,sorryPawn);
							            sorry = false;
							           
							      
					      }else return;
						 } else {
						
						
						
						if ((view.currGuiPawn.getX() >= 0 && view.currGuiPawn.getX() < 45*15 && view.currGuiPawn.getY() == 9) || (currPawn.pawnPosition instanceof SafetyZoneSquare  && currPawn.getColor() ==Color.red)){ 
							steps = 0;
							while(steps < Math.abs(number)) {
								
								

							
								
								if (newX == 93 && (number-steps <= 6 - currPawn.i) && (currPawn.prevJ <= currPawn.j) && (currPawn.getColor() == Color.red))  {
									
									
								       if (number-steps == 6 - currPawn.i ){

								    	   currPawn.setHome(true);
								    	   currPlayer.reduceActivePawns();
								    	   newY = 6*45 + 9 ;
								    	   if(currPawn.getNumber() == 1) {
								    		   currPawn.i = 6;
								    		   currPawn.j = 2;
								    		   newX = newX - 22;
								    	   }else {
								    		   currPawn.i = 6;
								    		   currPawn.j = 3;
								    		   newX = newX + 22;
								    	   }  
								    	   break;
								       }
								       else {
								    	   
                                         if (number < 0) {
                                        	 if (newY == 9) {
                                        		 currPawn.j--;
                                        		 newX = newX - 45;
                                        	 }else {
                                        	 currPawn.i--;
                                        	 newY = newY - 45;
                                        	 }
								    	   }else {
								    	   
								    	   newY = newY + 45;
									       currPawn.i++;
								        }
								       }
									
									
									
								} else {
								
									if ((currPawn.pawnPosition instanceof SafetyZoneSquare) && (number>0)) 
										break;
									
								
									
									
								
								if (newX != 678) {
									if (number>0) {
							            newX = newX + 45;
							            currPawn.j++;
									}else {
										if (newX == 3) {
											newY = newY + 45;
											currPawn.i++;
											currPawn.j=0;
										} else {
										newX = newX - 45;
										currPawn.j--;
										}
										
									}
								}else {
									if(number>0) {
							            newY = newY +45;
							            currPawn.i++;
									}else {
										
										newY = newY-45;
										currPawn.i--;
									}
								}
							
							 }
								steps ++;
							}
							
						}else 
						
						if ((view.currGuiPawn.getX() == 678) && (view.currGuiPawn.getY() < 684)) {
							
							steps = 0 ;
							
							while(steps < Math.abs(number)) {
								
								
								
								if (newX == 588 && (number - steps <= currPawn.i - 9)  && (currPawn.getColor() == Color.yellow))  {
									
								       if (number - steps == currPawn.i - 9){
								    	   currPawn.setHome(true);
								    	   currPlayer.reduceActivePawns();
								    	   newY = 9*45 + 9 ;
								    	   if(currPawn.getNumber() == 1) {
								    		   currPawn.i = 9;
								    		   currPawn.j = 13;
								    		   newX = newX - 22;
								    	   }else {
								    		   currPawn.i = 9;
								    		   currPawn.j = 12;
								    		   newX = newX + 22;
								    	   }  
								    	   break;
								       }
								       else {
								    	   
								    	   if (number < 0) {
								    		   
								    	   }else {
								    	   
								    	    newY = newY - 45;
									        currPawn.i--;
								    	   }
								        }
								
							}else {
								
							    if (newY != 684){
							    	if (number > 0) {
							            newY = newY + 45;
							            currPawn.i++;
							    	}else {
							    		
										  if (newY == 9) {
											  newX = newX - 45;
											  currPawn.j--;
											  
										  }else {
							    		
							    		newY = newY - 45;
							    		currPawn.i--;
										  }
							    	}
							}else {
							  if (number > 0) {
								  newX = newX - 45;
								  currPawn.j--;	
							  }else {
								  
								  newY = newY + 45;
								  currPawn.j++;
								  }
							  
							  }
							    
							}
							    steps++;
							}
						} else
							
							
							
						
						if ((view.currGuiPawn.getY() == 684 && (view.currGuiPawn.getX() >45)) || (currPawn.pawnPosition instanceof SafetyZoneSquare  && currPawn.getColor() ==Color.yellow)) {	
							steps = 0;
							while(steps < Math.abs(number)) {
								
								
								if (newX == 588 && (number-steps <=currPawn.i - 9) && (currPawn.prevJ >= currPawn.j)&& (currPawn.getColor() == Color.yellow))  {
									
								       if (number - steps == currPawn.i - 9 ){
								    	   currPawn.setHome(true);
								    	   currPlayer.reduceActivePawns();
								    	   newY = 9*45  ;
								    	   if(currPawn.getNumber() == 1) {
								    		   currPawn.i = 9;
								    		   currPawn.j = 13;
								    		   newX = newX - 22;
								    	   }else {
								    		   currPawn.i = 9;
								    		   currPawn.j = 12;
								    		   newX = newX + 22;
								    	   }  
								    	   break;
								       }
								       else {
								    	   
								    	   if (number < 0) {
								    		   if (newY == 684) {
								    			   newX = newX + 45;
								    			   currPawn.j++;
								    		   }else {
								    			   newY = newY + 45;
								    			   currPawn.i++;
								    		   }
								    		   
								    	   }else {
								    	   newY = newY - 45;
									       currPawn.i--;
								    	   }
								        }
							
								}else {
								
								
									if ((currPawn.pawnPosition instanceof SafetyZoneSquare) && (number > 0)) break;	
									
								if (newX != 3) {
									
									if (number < 0) {
										
										if (newX == 678) {
											newY = newY - 45;
											currPawn.i--;
										}else {
									   newX = newX + 45;
									   currPawn.j++;
										}
									}else {
							newX = newX - 45;
							currPawn.j--;	
									}
								} else {
									newY = newY-45;
									currPawn.i--;
								}
							}
							steps ++;
							}
						}
						
						
						
						
						else
							
							if(view.currGuiPawn.getX() == 3 && view.currGuiPawn.getY()>45) {
								
								
								 steps = 0;
								while ( steps < Math.abs(number)) {
									
									
									
									if (newX == 93 && (number-steps <= 6 - currPawn.i) && currPawn.getColor() == Color.red)  {

									       if (number-steps == 6 - currPawn.i ){
									    	   currPawn.setHome(true);
									    	   currPlayer.reduceActivePawns();
									    	   newY = 6*45 + 9 ;
									    	   if(currPawn.getNumber() == 1) {
									    		   currPawn.i = 6;
									    		   currPawn.j = 2;
									    		   newX = newX - 22;
									    	   }else {
									    		   currPawn.i = 6;
									    		   currPawn.j = 3;
									    		   newX = newX + 22;
									    	   }  
									    	   break;
									       }
									       else {
									    	  
									    	   if (number < 0) {
									    		   if (newX == 93) {
		                                        		 currPawn.j--;
		                                        		 newX = newX - 45;
		                                        	 }else {
		                                        	 currPawn.i--;
		                                        	 newY = newY - 45;
		                                        	 }
									    	   }else {
									    	   newY = newY + 45;
										       currPawn.i++;
									    	    }
									    	   }
										
									} else {
										
									
								  if (newY != 9) {
									  
									  if (number < 0) {
									     if (newY == 684) {
										     newX = newX + 45;
										     currPawn.j++;
									   }else {
										   newY = newY + 45;
										   currPawn.i++;
									   }
									  } else {
									newY = newY - 45;
									currPawn.i--;
									 }
								  } else {
									  newX = newX +45;
									  currPawn.j++;
								  }
									}
									steps++;
								}

							}		
							
								
						        
						
				      }
				
					
					}
					
					
					if (!swap) {
					
						
					if (board.board[currPawn.i][currPawn.j].isOccupied() ) {		
						System.out.println("Board "+ currPawn.i+ currPawn.j+ " " + "is occupied!");
						tempPawn = board.board[currPawn.i][currPawn.j].getPawn();
						if (tempPawn.getColor() != currPawn.getColor()) {
						 collision(currPawn,tempPawn);	
						 movePawn(currPawn);
						 currPawn.getPlayer().play(true);
						} else {
							currPawn.i = currPawn.prevI;
							currPawn.j= currPawn.prevJ;	
						}
					} else {
						movePawn(currPawn);
						currPawn.getPlayer().play(true);
					}
					
					}
					

					
                    if (currPawn.pawnPosition instanceof StartSlideSquare && currPawn.pawnPosition.getColor()!=currPawn.getColor()) {
                        slide(currPawn);
                    	movePawn(currPawn);
                    	currPawn.getPlayer().play(true);
		         }
                    
                    
			        if (currCard.getNumber() == 2 && counter == 0)  {
			        	currPawn.getPlayer().play(true);
			        	canPickCard = true;
			        	counter = 1;
			        }
			        
			        
			       
			        
			        
			        if (currCard.getNumber() == 7) {
			        	
			        	if (sevenCount == 1)
			        	currPlayer.play(false); 
			        	else currPlayer.play(true); 
			        	return;
			        }

			        
			       
			        if (currPlayer.getActivePawns() == 0) {
			        	update = ("Congratulations player "+currPawn.getNumber() +"! You are the winner!");
			        	view.info.append(update+"\n");
						view.info.setCaretPosition(view.info.getDocument().getLength());
			        }
			        
			  }
			
		   }
      
		}
   
		
		 
		
		public static void main(String[] args) {
			Game game = new Game();
		}
	
}
