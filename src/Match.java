public class Match {

    private final Player player1, player2;
    private int player1Games;
    private int player2Games;

    private GameScore currentGameScore = null;

    private GameScore point00;

    public Match(String player1, String player2) {
        this.player1 = new Player(player1);
        this.player2 = new Player(player2);
        player2Games = 0;
        player1Games = 0;
    }

    public void init() {
        GameScore winningP1 = new GameScore(player1 + " wins.", player1);
        GameScore winningP2 = new GameScore(player2 + " wins.", player2);
        GameScore advantageP1 = new GameScore("Advantage " + player1);
        GameScore advantageP2 = new GameScore("Advantage " + player2);
        GameScore deuce = new GameScore("DEUCE");
        GameScore point3040 = new GameScore(player1 + " 30-40 " + player2);
        GameScore point1540 = new GameScore(player1 + " 15-40 " + player2);
        GameScore point040 = new GameScore(player1 + " 0-40 " + player2);
        GameScore point4030 = new GameScore(player1 + " 40-30 " + player2);
        GameScore point3030 = new GameScore(player1 + " 30-30 " + player2);
        GameScore point1530 = new GameScore(player1 + " 15-30 " + player2);
        GameScore point030 = new GameScore(player1 + " 0-30 " + player2);
        GameScore point4015 = new GameScore(player1 + " 40-15 " + player2);
        GameScore point3015 = new GameScore(player1 + " 30-15 " + player2);
        GameScore point1515 = new GameScore(player1 + " 15-15 " + player2);
        GameScore point015 = new GameScore(player1 + " 0-15 " + player2);
        GameScore point400 = new GameScore(player1 + " 40-0 " + player2);
        GameScore point300 = new GameScore(player1 + " 30-0 " + player2);
        GameScore point150 = new GameScore(player1 + " 15-0 " + player2);
        point00 = new GameScore(player1 + " 0-0 " + player2);

        advantageP1.addNextPossibleScore(player1, winningP1);
        advantageP1.addNextPossibleScore(player2, deuce);

        advantageP2.addNextPossibleScore(player2, winningP2);
        advantageP2.addNextPossibleScore(player1, deuce);

        deuce.addNextPossibleScore(player1, advantageP1);
        deuce.addNextPossibleScore(player2, advantageP2);

        point3040.addNextPossibleScore(player2, winningP2);
        point3040.addNextPossibleScore(player1, deuce);

        point4030.addNextPossibleScore(player1, winningP1);
        point4030.addNextPossibleScore(player2, deuce);

        point1540.addNextPossibleScore(player1, point3040);
        point1540.addNextPossibleScore(player2, winningP2);

        point040.addNextPossibleScore(player1, point1540);
        point040.addNextPossibleScore(player2, winningP2);

        point4015.addNextPossibleScore(player1, winningP1);
        point4015.addNextPossibleScore(player2, point4030);

        point400.addNextPossibleScore(player1, winningP1);
        point400.addNextPossibleScore(player2, point4015);

        point3030.addNextPossibleScore(player1, point4030);
        point3030.addNextPossibleScore(player2, point3040);

        point1530.addNextPossibleScore(player1, point3030);
        point1530.addNextPossibleScore(player2, point1540);

        point030.addNextPossibleScore(player1, point1530);
        point030.addNextPossibleScore(player2, point040);

        point3015.addNextPossibleScore(player2, point3030);
        point3015.addNextPossibleScore(player1, point4015);

        point300.addNextPossibleScore(player2, point3015);
        point300.addNextPossibleScore(player1, point400);

        point1515.addNextPossibleScore(player1, point3015);
        point1515.addNextPossibleScore(player2, point1530);

        point015.addNextPossibleScore(player1, point1515);
        point015.addNextPossibleScore(player2, point030);

        point150.addNextPossibleScore(player2, point1515);
        point150.addNextPossibleScore(player1, point300);

        point00.addNextPossibleScore(player1, point150);
        point00.addNextPossibleScore(player2, point015);

        currentGameScore = point00;
    }

    public void incrementScoreFor(String playerName) {
        currentGameScore = currentGameScore.getNextScore(playerName);
        if (currentGameScore.isWinningScore()) {
            incrementGameCountFor(currentGameScore.getWinningPlayer());
            currentGameScore = point00;
        }
    }

    private void incrementGameCountFor(Player player) {
        if (player1.equals(player)) {
            player1Games++;
        } else {
            player2Games++;
        }
    }

    public void displayScore() {
        System.out.println("GAME SCORE:");
        System.out.println("** " + player1.getName() + " " + player1Games + "-" + player2Games + " " + player2.getName());
        System.out.println("** " + currentGameScore);
    }

    public int getPlayer1Games() {
        return player1Games;
    }

    public int getPlayer2Games() {
        return player2Games;
    }

    public GameScore getCurrentGameScore() {
        return currentGameScore;
    }
}
