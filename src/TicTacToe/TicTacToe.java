package TicTacToe;

class TicTacToe {
	// we need at least 2 variables: one for the token and another one (matrix) to represent the board.
//	private static char token;
//	private static boolean _3inARow = false;
//	private static char[][] board = {
//			{'*', '*', '*'},
//			{'*', '*', '*'},
//			{'*', '*', '*'}
//	};
	
	/**
	 * Function which prints a matrix (which represents the board) full of "*" (to represent its nodes as empty).
	 */
	public static void displayBoard(char[][] board) {
		for(char[] row : board) {
			System.out.println();
			for(char c : row) {
				System.out.format("%5c", c);
			}
		}
		System.out.println();
	}
	
	/**
	 * Function that prints a syso-formated matrix (BUT NOT A MATRIX) of numbers which represents the possible placements for a token.
	 */
	public static void printTemplate() {
		int inx = 1;
		
		for (int i = 0; i <= 2; i++) {
			System.out.println();
			
			for (int j = 0; j <= 2; j++) {
				System.out.format("%5d", inx++);
			}
		}
		
		System.out.println();
	}

//	public static void play(Player player, Cpu cpu, int pos, char[][] board) {
//		if(player.getStartsFirst()) {
//			player.placeToken(pos, board);
//			threeInARow(board, player.getToken());
//			
//			cpu.placeToken(board);
//			threeInARow(board, cpu.getToken());
//		}
//	}
	
	/**
	 * Function that manages the placement of the token and, if 3 tokens match, it will return a true statement.
	 * @return _3 : boolean : variable which says if a "three in a row" has taken place.
	 */
	public static boolean threeInARow(char[][] board, char token) {
		boolean _3inARow = false;
		for (int i = 0; i <= board.length - 1; i++) {
			for (int j = 0; j <= board[i].length - 1; j++) {
				if ((board[0][0] == token && board[0][1] == token && board[0][2] == token)
						|| (board[1][0] == token && board[1][1] == token && board[1][2] == token)
						|| (board[2][0] == token && board[2][1] == token && board[2][2] == token)) {
					_3inARow = true;
				} else if ((board[0][0] == token && board[1][0] == token && board[2][0] == token)
						|| (board[0][1] == token && board[1][1] == token && board[2][1] == token)
						|| (board[0][2] == token && board[1][2] == token && board[2][2] == token)) {
					_3inARow = true;
				} else if ((board[0][0] == token && board[1][1] == token && board[2][2] == token)
						|| (board[0][2] == token && board[1][1] == token && board[2][0] == token)) {
					_3inARow = true;
				} else {
					_3inARow = false;
				}
			}
		}
		return _3inARow;
	}
	
	/**
	 * Function which manages the several situations in which the game could finish (and returns true if any of these occurs).
	 * @return gameOver : boolean : variable to decide if the game finishes or not.
	 */
	
	public static boolean gameOver(char[][] board, char playerToken, char cpuToken) {
		boolean gameOver = false;
		int inx = 0;
		
		if(threeInARow(board, playerToken) || threeInARow(board, cpuToken)) {
			gameOver = true;
			if(playerToken == 'x') {
				System.out.println("\nYOU WIN! #1");
			} else {
				System.out.println("\nCPU Wins.");
			}
		} else {
			for(int i = 0; i <= board.length - 1; i++) {
				for(int j = 0; j <= board[i].length - 1; j++) {
					if(board[i][j] != '*') {
						inx++;
					}
					
					if(inx == 9 && (!threeInARow(board, playerToken) || !threeInARow(board, cpuToken))) { //aqui hay fallo
						System.out.println("\nDRAW! Restart to play again!");
						gameOver = true;
					}
				}
			}
		}
		return gameOver;
	}
}
