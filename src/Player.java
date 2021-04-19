public class Player {
    private final String name;

    public Player(String player2) {
        name = player2;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
