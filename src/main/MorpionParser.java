import java.util.HashMap;
import java.util.Map;

public class MorpionParser implements Parser {

	private static final String DIMENSION_SEPARATOR = "x";

	private static Parser parser = new MorpionParser();

	private MorpionParser() {
	}

	public static Parser getInstance() {
		return parser;
	}

	@Override
	public char[][] createGame(String dimension) {
		String[] dimensions = dimension.split(DIMENSION_SEPARATOR);
		int dim = Integer.parseInt(dimensions[0]);
		char[][] game = new char[dim][dim];
		return game;
	}

	@Override
	public Map<String, Character> getPlayers(String... players_) {
		Map<String, Character> players = new HashMap<String, Character>();
		for (String player : players_) {
			String playerss[] = player.split(":");
			players.put(playerss[0], playerss[1].charAt(0));
		}
		return players;
	}

	public int[] getPositionGame(String position_) {
		String position[] = position_.split("x");
		int positionX = Integer.parseInt(position[0]);
		int positionY = Integer.parseInt(position[1]);
		return new int[] { positionX, positionY };
	}
}
