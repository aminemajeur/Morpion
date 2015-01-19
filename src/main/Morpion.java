import java.util.Iterator;
import java.util.Map;

public class Morpion {

	private char[][] game;
	private Map<String, Character> players;

	public static final String LINE_SEPARATOR = System.getProperty("line.separator");

	public Morpion(String dim, String play1, String play2) {
		Parser parser = MorpionParser.getInstance();
		game = parser.createGame(dim);
		players = parser.getPlayers(play1, play2);
	}

	public void play(String string, String string2) {
		Parser parser = MorpionParser.getInstance();
		char player = players.get(string);
		int[] positionGame = parser.getPositionGame(string2);
		checkIfBoxAlreadySelected(positionGame[0], positionGame[1]);
		game[positionGame[0]][positionGame[1]] = player;
	}

	public String report() {
		Reporter reporter = new Reporter();
		Iterator<String> playerss = players.keySet().iterator();
		String player1 = playerss.next();
		String player2 = playerss.next();
		reporter.reportRemingGame(player1, 0, player2, 0);
		
		if (isGameOver())
			return reporter.reportEquality();

		return CheckAWinner(reporter);

	}

	private String CheckAWinner(Reporter reporter) {
		for (String player : players.keySet()) {
			if (isWinner(players.get(player))) {
				return reporter.reportPlayerWin(player);
			}
		}
		return "";
	}

	public String display() {
		Reporter reporter = new Reporter();
		return reporter.reportResultGame(game);
	}

	private boolean isWinner(char player) {
		boolean winInAllCase = false;
		winInAllCase = checkIfIsWinnerInRow(player) || checkIfIsWinnerInColumn(player)
				|| checkIfIsWinnerInDiagonal(player);

		return winInAllCase;
	}

	private boolean isGameOver() {
		for (int i = 0; i < game.length; i++) {
			for (int j = 0; j < game.length - 1; j++) {
				if (game[i][j] == '\0') {
					return false;
				}
			}
		}
		return true;
	}

	private boolean checkIfIsWinnerInDiagonal(char player) {
		boolean win = true;
		for (int i = 0; i < game.length; i++) {
			if (game[i][i] == game[i][i] && game[i][i] == player) {
				win &= true;
			} else
				win &= false;
		}
		return win;
	}

	private boolean checkIfIsWinnerInColumn(char player) {
		boolean win = true;
		for (int i = 0; i < game.length; i++) {
			for (int j = 0; j < game.length - 1; j++) {
				if (game[j][i] == game[j + 1][i] && game[j][i] == player) {
					win &= true;
				} else
					win &= false;
			}
		}
		return win;
	}

	private boolean checkIfIsWinnerInRow(char player) {
		boolean win = true;
		for (int i = 0; i < game.length; i++) {
			for (int j = 0; j < game.length - 1; j++) {
				if (game[i][j] == game[i][j + 1] && game[i][j] == player) {
					win &= true;
				} else
					win &= false;
			}
		}
		return win;
	}

	private void checkIfBoxAlreadySelected(int x, int y) {
		if (game[x][y] != '\0')
			throw new BoxAlreadySelectedException();
	}
}