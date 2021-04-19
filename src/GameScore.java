import java.util.HashMap;
import java.util.Map;

public class GameScore {
    private final String description;
    private final Map<String, GameScore> nextPossibleScores = new HashMap<>();
    private final boolean isWinningScore;
    private final Player winningPlayer;

    public GameScore(String description) {
        this.description = description;
        this.isWinningScore = false;
        this.winningPlayer = null;
    }

    public GameScore(String description, Player winningPlayer) {
        this.description = description;
        this.isWinningScore = true;
        this.winningPlayer = winningPlayer;
    }

    public void addNextPossibleScore(Player player, GameScore nextScore) {
        nextPossibleScores.put(player.getName(), nextScore);
    }

    public GameScore getNextScore(String playerName) {
        return nextPossibleScores.get(playerName);
    }

    public Player getWinningPlayer() {
        return winningPlayer;
    }

    public boolean isWinningScore() {
        return isWinningScore;
    }

    @Override
    public String toString() {
        return description;
    }
}
