package TicTacToe;
import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
public class TicTacToeUI extends JFrame implements ActionListener {
	
	Player player1;
	Player player2;
	Board board;

	private static final long serialVersionUID = 1L;
	JPanel[] row = new JPanel[4];
    JButton[] button = new JButton[9];
    String[] buttonString = {" "," "," ",
    						 " "," "," ",
    						 " "," "," "};
    Dimension displayDimension = new Dimension(290, 45);
    Dimension regularDimension = new Dimension(90, 90);
    JTextArea display = new JTextArea(2, 20);
    Font font = new Font("Times new Roman", Font.BOLD, 14);
    
    public TicTacToeUI(){
    	super("Naman");
    	 setDesign();
	     setSize(350, 400);
	     setResizable(false);
	     setDefaultCloseOperation(EXIT_ON_CLOSE);
	     GridLayout grid = new GridLayout(4,5);
	     setLayout(grid);
	     
	     FlowLayout f1 = new FlowLayout(FlowLayout.CENTER);
	        FlowLayout f2 = new FlowLayout(FlowLayout.CENTER,1,1);//gap in cells
	        for(int i = 0; i < 4; i++ )
	            row[i] = new JPanel();
	        row[0].setLayout(f1);
	        for(int i = 1; i < 4; i++)
	            row[i].setLayout(f2);
	        
	        for(int i = 0; i < 9; i++) {
	            button[i] = new JButton();
	            button[i].setText(buttonString[i]);
	            button[i].setBackground(Color.black);
	            button[i].setFont(font);
	            button[i].addActionListener(this);
	        }
	        
	        display.setFont(font);
	        display.setEditable(true);
	        display.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
	        display.setPreferredSize(displayDimension);
	        
	        for(int i = 0; i < 9; i++)
	            button[i].setPreferredSize(regularDimension);
	        
	        row[0].add(display);
	        add(row[0]);
	        
	        for(int i=1,k=0;i<4&&k<9;i++){
	        	for(int j=0;j<3;j++){
	        		row[i].add(button[k]);
	        		k++;
	        	}
	        	add(row[i]);
	        }
	        
	        setVisible(true);
	        manager();
    }
    
    
    public void manager() {
		// TODO Auto-generated method stub
     player1 = new Player("Player-1", 'X');
     player2 = new Player("Player-2", 'O');
     board = new Board('X', 'O');
     display.setText("Player 1 Your turn");
    	
	}


	public final void setDesign() {
        try {
            UIManager.setLookAndFeel(
                    "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch(Exception e) {   
        }
    }
 
	public void playMove(int x, int y ,Player currentPlayer,int buttonIndex){
		Player opposite = player2;
		if(currentPlayer.equals(player1)){
			opposite = player2;
		}
		else{
			opposite = player1;
		}
		int status = board.gameStatus();
		if (status == 1) {
			display.setText(player1.name + " Won");
		}
		else if (status == 2) {
			display.setText(player2.name + " Won");	
		}
		else if (status==3){
			if(board.move(currentPlayer.symbol, x, y)){
				button[buttonIndex].setText("" + currentPlayer.symbol);
				button[buttonIndex].setBackground(Color.WHITE);
				if(!checkEnd()){
					display.setText(opposite.name + " your turn");
				}
				
			}
			else{
				display.setText("Invalid Move Thus Skipped\n " + opposite.name  + " Your turn");
			}
		}
		
		else{
			display.setText("Draw");
		}
	}
	private boolean checkEnd() {
		int status = board.gameStatus();
		if (status == 1) {
			display.setText(player1.name + " Won");
			return true;
		}
		else if (status == 2) {
			display.setText(player2.name + " Won");	
			return true;
		}
		else if(status == 0){
			display.setText("Draw");
			return true;
		}
		return false;
	}
	private boolean playerTurn = true;
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		int x,y;
		
		Player turn = player1;
		if(ae.getSource()==button[0]){
			x=0;
			y=0;
			if(playerTurn){
				turn = player1;
			}
			else{
				turn = player2;
			}
			playMove(x,y,turn,0);
			playerTurn=!playerTurn;
		}
		else if(ae.getSource()==button[1]){
			x=0;
			y=1;
			if(playerTurn){
				turn = player1;
			}
			else{
				turn = player2;
			}
			playMove(x,y,turn,1);
			playerTurn=!playerTurn;
		}
		else if(ae.getSource()==button[2]){
			x=0;
			y=2;
			if(playerTurn){
				turn = player1;
			}
			else{
				turn = player2;
			}
			playMove(x,y,turn,2);
			playerTurn=!playerTurn;
			
		}
		else if(ae.getSource()==button[3]){
			x=1;
			y=0;
			if(playerTurn){
				turn = player1;
			}
			else{
				turn = player2;
			}
			playMove(x,y,turn,3);
			playerTurn=!playerTurn;
			
		}
		else if(ae.getSource()==button[4]){
			x=1;
			y=1;
			if(playerTurn){
				turn = player1;
			}
			else{
				turn = player2;
			}
			playMove(x,y,turn,4);
			playerTurn=!playerTurn;
		}
		else if(ae.getSource()==button[5]){
			x=1;
			y=2;
			if(playerTurn){
				turn = player1;
			}
			else{
				turn = player2;
			}
			playMove(x,y,turn,5);
			playerTurn=!playerTurn;
			
		}
		else if(ae.getSource()==button[6]){
			x=2;
			y=0;
			if(playerTurn){
				turn = player1;
			}
			else{
				turn = player2;
			}
			playMove(x,y,turn,6);
			playerTurn=!playerTurn;
			
		}
		else if(ae.getSource()==button[7]){
			x=2;
			y=1;
			if(playerTurn){
				turn = player1;
			}
			else{
				turn = player2;
			}
			playMove(x,y,turn,7);
			playerTurn=!playerTurn;
			
		}
		else if(ae.getSource()==button[8]){
			x=2;
			y=2;
			if(playerTurn){
				turn = player1;
			}
			else{
				turn = player2;
			}
			playMove(x,y,turn,8);
			playerTurn=!playerTurn;
				
		}
	}
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TicTacToeUI obj = new TicTacToeUI();
	}
	

}
