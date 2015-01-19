import java.util.Map;

public interface Parser {

	char[][] createGame(String dimension);

	Map<String, Character> getPlayers(String ...players);

	int[] getPositionGame(String position);
}
