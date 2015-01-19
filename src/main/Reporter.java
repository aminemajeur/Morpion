public class Reporter {

	private static final String SEPARATOR_ROW = "\r\n";
	private static final String SEPARATOR_COLUMN = "|";

	private StringBuilder builder = new StringBuilder();
	
	public void reportPlayerWin(String player) {
		builder.append(String.format("Game Over, %s is a winner", player));
	}

	public void reportEquality() {
		builder.append("Game Over, equality");
	}

	public String reportResultGame(char[][] game) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < game.length; i++) {
			for (int j = 0; j < game.length; j++) {
				builder.append(game[i][j]);
				builder.append(SEPARATOR_COLUMN);
			}
			builder.deleteCharAt(builder.length() - 1);
			builder.append(SEPARATOR_ROW);
		}
		return builder.toString();
	}

	public void reportRemingGame(String player1, int numberGamePlayer1, String player2, int numberGamePlayer2) {
		builder.append("%d games for %s, %d games for %s");
	}
	
	public String reportAll(){
		return builder.toString();
	}
}
