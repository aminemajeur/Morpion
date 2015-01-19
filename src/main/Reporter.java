public class Reporter {

	private static final String SEPARATOR_ROW = "\n";
	private static final String SEPARATOR_COLUMN = "|";
	private static final String PLAYER1 = "player1";
	private static final String PLAYER2 = "player2";

	public String reportPlayer1Winn() {
		return reportPlayerWin(PLAYER1);
	}

	public String reportPlayer2Winn() {
		return reportPlayerWin(PLAYER2);
	}

	private String reportPlayerWin(String player) {
		return String.format("Game Over, %s is a winner", player);
	}

	public String reportEquality() {
		return "Game Over, equality";
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
}
