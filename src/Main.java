import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        try (BufferedReader bf = new BufferedReader(new FileReader("resources/match1.txt"))) {
            List<String> ballWinners = bf.lines().collect(Collectors.toList());
            List<String> players = ballWinners.stream().distinct().collect(Collectors.toList());
            if (players.size() > 2) {
                System.err.println("Input file has too many players: ");
                players.stream()
                        .peek(playerName -> System.err.print(playerName + " "))
                        .count();
                System.exit(1);
            }
            if (players.size() == 1) {
                players.add("Opponent of " + players.get(0));
            }

            Match match = new Match(players.get(0), players.get(1));
            match.init();
            for (String ballWinner : ballWinners) {
                match.incrementScoreFor(ballWinner);
            }
            match.displayScore();
        } catch (final IOException e) {
            System.err.println(e.getMessage());
            System.exit(2);
        }
    }
}
