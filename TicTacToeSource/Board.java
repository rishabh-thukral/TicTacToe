package TicTacToe;

public class Board  {
	private char[][] board;
	private final char player1Symbol;
	private final char player2Symbol;
	private int gameStatus;//3 for game on
	private int count;
	public Board(char player1Symbol,char player2Symbol){
		board = new char[3][3];
		//for the purpose of printing
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				board[i][j]=' ';
			}
		}
		this.player1Symbol=player1Symbol;
		this.player2Symbol=player2Symbol;
		gameStatus=3;
		count=0;
	}
	
	public boolean move(char symbol,int x , int y){// boolean for invalid move or we can throw exception
		if(board[x][y]!=' '){
			return false;
		}
		if(symbol !=player1Symbol && symbol != player2Symbol){
			return false;
		}
		count++;
		board[x][y]=symbol;	
		if(board[x][0] == board[x][1] && board[x][0] == board[x][2]){
			gameStatus = (symbol == player1Symbol)?1:2;
		}
		else if(board[0][y] == board[1][y] && board[0][y] == board[2][y]){
			gameStatus = (symbol == player1Symbol)?1:2;
		}
		else if(board[0][0]!=' ' && board[0][0]== board[1][1] && board[0][0]==board[2][2]){
			gameStatus = (board[0][0] == player1Symbol)?1:2;
		}
		else if(board[2][0]!=' ' && board[2][0]== board[1][1] && board[2][0]==board[0][2]){
			gameStatus = (board[2][0] == player1Symbol)?1:2;
		}
		else{
			if(count==9){
				gameStatus=0;
			}
		}
		return true;
	}
	public void print(){
		for(int i=0;i<3;i++){
			System.out.println("-----------------");
			for(int j=0;j<3;j++){
				System.out.print("| "+board[i][j]+" |");
			}
			System.out.println();
			
		}
		System.out.println("-----------------");
	}
	public int gameStatus(){
		return gameStatus;
	}
}
