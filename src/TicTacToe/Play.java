package TicTacToe;

import  java.util.Scanner;

class Play {
	private static char[][] board = {
			{'*', '*', '*'},
			{'*', '*', '*'},
			{'*', '*', '*'}
	};
	static Scanner sc;
	static Player player;
	static Cpu cpu;
	public static void main(String[] args) throws Exception {
		
		sc = new Scanner(System.in);
		
		System.out.println("WELCOME TO TIC TAC TOE!");
		TicTacToe.displayBoard(board);
		
		System.out.println("\nChoose your token! (x / o)");
		
		if(sc.nextLine().charAt(0) == 'x') {
			cpu = new Cpu('o', false);
			player = new Player('x', true);
		} else {
			cpu = new Cpu('x', true);
			player = new Player('o', false);
		}
		
			Thread.sleep(500);
		
		System.out.println("To place your token, you will need to choose a number (1-9). This is the template:");
		TicTacToe.printTemplate();
		System.out.println("\nIf you want to print it again, type '/template'");
		
			Thread.sleep(500);
		
		System.out.println("\nIf you want to finish the game, type '/end'");
		
			Thread.sleep(1000);
			
		while (!TicTacToe.gameOver(board, player.getToken(), cpu.getToken())) {
			System.out.println("\nWhere do you want to place your token?");
			String pInput = sc.nextLine().replaceAll(" ", "").toLowerCase();

			if(!pInput.startsWith("/")) {
				try {
					if(Integer.parseInt(pInput) < 1 || Integer.parseInt(pInput) > 9) {
//						throw new IllegalArgumentException("The value to place the token must be 1-9 ('/template' to show the template)");
						System.out.println("The value to place the token must be 1-9 ('/template' to show the template)");
					} else {
//						TicTacToe.play(player, cpu, Integer.parseInt(pInput), board);
//						player.placeToken(Integer.parseInt(pInput), board);
//						cpu.placeToken();
						
						if(player.getStartsFirst()) {
							player.placeToken(Integer.parseInt(pInput), board);
							cpu.placeToken(board);
						} else {
							cpu.placeToken(board);
							player.placeToken(Integer.parseInt(pInput), board);
						}
					}
				} catch (Exception e) {
//					System.out.println("Ha habido un error en la entrada del usuario.\nERROR: " + e.getMessage());
					e.printStackTrace();
				}
			} else {
				if(pInput.equals("/template")) {
					TicTacToe.printTemplate();
				} else if(pInput.equals("/end")) {
					System.out.println("Game Over!");
					System.exit(0);
				} else {
					System.out.println("\nSorry, this command couldn't be recognized.");
				}
			}
		}
		sc.close();
	}
}