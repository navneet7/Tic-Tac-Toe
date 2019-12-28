import java.util.Scanner;

public class TicTacToe {
	
	
	public static void main(String[] args) {
		
		System.out.println("::Information::");
		System.out.println("This is a mutiplayer index based game. Indexing start with 1.");
		System.out.println("All Valid moves are - ");
		System.out.println("(1 1),(1 2),(1 3),(2 1),(2 2),(2 3),(3 1),(3 2),(3 3)");
		System.out.println("Game is over if all moves are exausted or someone has made a winning move.");
		System.out.println();
		System.out.println("Happy playing");
		System.out.println("\n");
		
		//Creating board
		char board[][] = new char[3][3];
		
		//Populating board with _
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				board[i][j] = '_';
			}
		}
		
		//Printing Board
		printBoard(board);
		System.out.println();
		
		Scanner scan = new Scanner(System.in);
		
		int row = 0;
		int column = 0;	
		//Making x as default player
		char player = 'x';
		
		//Iterating the loop till any move left
		while(hasMoveLeft(board)){
			
			System.out.println(player+" move : ");
			
			row = scan.nextInt();
			column = scan.nextInt();
			
			//Move validation
			while(row <= 0 || row > 3 || column <= 0 || column > 3 || !validMove(board,row,column)){
				System.out.println("::Invalid Move::");
				System.out.println(player+" move : ");
				row = scan.nextInt();
				column = scan.nextInt();
			}
			
			//Replacing _ with x or o, if move is valid
			board[row-1][column-1] = player;
			
			//After putting x or o, displaying board
			printBoard(board);
			System.out.println();
			
			//Checking whether this move is winning move
			if(hasWinTheMatch(board,player))
			{
				System.out.println(player + " has won the match");
				break;
			}
			
			//Switching player
			if(player == 'x')
				player = 'o';
			else
				player = 'x';
		}
		
		
	}

	private static boolean hasWinTheMatch(char[][] board,char player) {
		
		for(int i = 0; i < 3; i++){
			int count = 0;
			for(int j = 0; j < 3; j++){
				if(board[i][j] == player){
					count++;
				}
				if(count == 3){
					return true;
				}
			}
		}
		
		for(int i = 0; i < 3; i++){
			int count = 0;
			for(int j = 0; j < 3; j++){
				if(board[j][i] == player){
					count++;
				}
				if(count == 3){
					return true;
				}
			}
		}
		
		int countD = 0;
		
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				if(i == j){
					if(board[i][j] == player){
						countD++;
					}
					if(countD == 3){
						return true;
					}
				}
			}
		}
		
		int i = 0;
		int j = 2;
		int count = 0;
		while(i != 3){
			if(board[i][j] == player){
				count++;
			}
			i++;
			j--;
		}
		
		if(count == 3){
			return true;
		}
		
		return false;
		
	}

	private static boolean validMove(char[][] board, int row, int column) {
		if(board[row-1][column-1] == '_')
			return true;
		else
			return false;
	}

	private static void printBoard(char[][] board) {
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				System.out.print(board[i][j]+"  ");
			}
			System.out.println();
		}
		
	}

	private static boolean hasMoveLeft(char[][] board) {
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				if(board[i][j] == '_'){
					return true;
				}
			}
		}
		System.out.println("No Move left.");
		return false;
	}
	
}
