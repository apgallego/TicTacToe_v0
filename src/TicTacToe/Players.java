package TicTacToe;

public abstract class Players {
	private char token;
	private boolean startsFirst;
	
	public Players(char token, boolean startsFirst) {
		this.token = token;
		this.startsFirst = startsFirst;
	}
	
	//getters and setters
	public char getToken() {
		return token;
	}

	public void setToken(char token) {
		this.token = token;
	}

	public boolean getStartsFirst() {
		return startsFirst;
	}

	public void setStartsFirst(boolean startsFirst) {
		this.startsFirst = startsFirst;
	}
}