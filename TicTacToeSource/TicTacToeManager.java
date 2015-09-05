package TicTacToe;

import java.util.Scanner;

public class TicTacToeManager  {
	Player player1;
	Player player2;
	Board board;
	private Player takePlayerInput(){
		Scanner s = new Scanner(System.in);
		System.out.println("Enter your name");
		String name=s.nextLine();
		System.out.println("Enter symbol");
		char symbol = s.next().charAt(0);
		return new Player(name,symbol);
		
	}
	public void start() {
		Scanner s = new Scanner(System.in);
		boolean isPlayer1Turn = true;
		while (board.gameStatus() == 3) {
			board.print();
			Player currentPlayer;
			if (isPlayer1Turn)
				currentPlayer = player1;
			else
				currentPlayer = player2;
			System.out.println(currentPlayer.name + " your turn!!!");
			System.out.println("Enter x");
			int x = s.nextInt();
			System.out.println("Enter y");
			int y = s.nextInt();
			board.move(currentPlayer.symbol, x, y);
			isPlayer1Turn = !isPlayer1Turn;
		}

		board.print();
		int status = board.gameStatus();
		if (status == 1) {
			System.out.println(player1.name + " Won!!!");
		} else if (status == 2) {
			System.out.println(player2.name + " Won!!!");
		} else {
			System.out.println("Draw!");
		}

	}
	public TicTacToeManager(){
		player1 = takePlayerInput();
		boolean done=false;
		while(!done){
			player2 = takePlayerInput();
			if(player1.symbol==player2.symbol){
				System.out.println("Cant take same symbol!!!");
			}
			else{
				done=true;
			}
		}
		board = new Board(player1.symbol,player2.symbol);
	}
	public static void main(String args[]) {
		TicTacToeManager t = new TicTacToeManager();
		t.start();
	}
}
