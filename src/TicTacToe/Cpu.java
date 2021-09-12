package TicTacToe;

import java.security.SecureRandom;

class Cpu extends Players {
	private static SecureRandom random;
	
	public Cpu(char token, boolean startsFirst) {
		super(token, startsFirst);
	}
	
	public void placeToken(char[][] board) {
		random = new SecureRandom();
		
		try {
			Thread.sleep(200);
		} catch (Exception e) {
			//nothing to do here
		}
		System.out.print("\nCPU looking for the best action");
		for(int i = 0; i <= 2; i++) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				//nothing to do here
				e.printStackTrace();
			}
			System.out.print(".");
		}
		System.out.println();
		
		if(super.getStartsFirst()) {
			board[random.nextInt(3)][random.nextInt(3)] = super.getToken();
		} else {
			if (board[random.nextInt(3)][random.nextInt(3)] == '*') {
				board[random.nextInt(3)][random.nextInt(3)] = super.getToken();
			} else {
				board[random.nextInt(3)][random.nextInt(3)] = super.getToken();
			}
		}
		
		TicTacToe.displayBoard(board);
		TicTacToe.threeInARow(board, getToken());
		
		random = null;
	}
}
