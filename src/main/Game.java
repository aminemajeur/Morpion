public class Game {

	private Player player1;
	private Player player2;
	private int dimension;

	public Game(int dimension, Player player1, Player player2) {
		this.dimension = dimension;
		this.player1 = player1;
		this.player2 = player2;
	}

	public int getNumberGamesForPlayer(Player player) {
		return 0;
	}

	public boolean isGameOverWithWinner() {
		return false;
	}

	public boolean isGameOverWithEquality() {
		return false;
	}
	
	public String reportResult(){
		return "";
	}

}
