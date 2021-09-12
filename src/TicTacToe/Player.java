package TicTacToe;

class Player extends Players  {
	
	public Player(char token, boolean startsFirst) {
		super(token, startsFirst);
	}
	
	/**
	 * Function which "translates" a placement. Instead of writing, i.e., x,y coords, we can just write a number 1-9 regarding the template.
	 * @param pos : int : variable which represents the position we want for our token.
	 * @param board : char[][] : matrix which represents the game board.
	 */
	public void placeToken(int pos, char[][] board) {
		switch (pos) {
		case 1:
			board[0][0] = super.getToken();
			TicTacToe.displayBoard(board);
			TicTacToe.threeInARow(board, getToken());
			break;
		case 2:
			board[0][1] = super.getToken();
			TicTacToe.displayBoard(board);
			TicTacToe.threeInARow(board, getToken());
			break;
		case 3:
			board[0][2] = super.getToken();
			TicTacToe.displayBoard(board);
			TicTacToe.threeInARow(board, getToken());
			break;
		case 4:
			board[1][0] = super.getToken();
			TicTacToe.displayBoard(board);
			TicTacToe.threeInARow(board, getToken());
			break;
		case 5:
			board[1][1] = super.getToken();
			TicTacToe.displayBoard(board);
			TicTacToe.threeInARow(board, getToken());
			break;
		case 6:
			board[1][2] = super.getToken();
			TicTacToe.displayBoard(board);
			TicTacToe.threeInARow(board, getToken());
			break;
		case 7:
			board[2][0] = super.getToken();
			TicTacToe.displayBoard(board);
			TicTacToe.threeInARow(board, getToken());
			break;
		case 8:
			board[2][1] = super.getToken();
			TicTacToe.displayBoard(board);
			TicTacToe.threeInARow(board, getToken());
			break;
		case 9:
			board[2][2] = super.getToken();
			TicTacToe.displayBoard(board);
			TicTacToe.threeInARow(board, getToken());
			break;
		}
	}
}
