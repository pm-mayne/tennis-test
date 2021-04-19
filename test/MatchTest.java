import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class MatchTest {

    @Test
    public void testSimpleMatch() {

        List<String> aFewPoints = asList("foo", "bar", "foo", "bar", "foo");
        List<String> gameBar = asList("foo", "bar", "foo", "bar", "foo", "bar", "foo", "bar", "foo", "bar", "foo", "bar", "foo", "bar", "foo", "bar", "foo", "bar", "bar", "bar");
        List<String> barVictory = asList("bar", "bar", "bar", "bar",
                "bar", "bar", "bar", "bar",
                "bar", "bar", "bar", "bar",
                "bar", "bar", "bar", "bar",
                "bar", "bar", "bar", "bar",
               "bar", "bar", "foo", "foo", "bar", "foo", "foo", "foo");


        Match match = new Match("foo", "bar");
        playMatch(match, aFewPoints);
        assertEquals(0, match.getPlayer1Games());
        assertEquals(0, match.getPlayer2Games());
        assertEquals("foo 40-30 bar", match.getCurrentGameScore().toString());

        match = new Match("foo", "bar");
        playMatch(match, gameBar);
        assertEquals(0, match.getPlayer1Games());
        assertEquals(1, match.getPlayer2Games());
        assertEquals("foo 0-0 bar", match.getCurrentGameScore().toString());

        match = new Match("foo", "bar");
        playMatch(match, barVictory);
        assertEquals(1, match.getPlayer1Games());
        assertEquals(5, match.getPlayer2Games());
        assertEquals("foo 0-0 bar", match.getCurrentGameScore().toString());


    }

    private void playMatch(Match match, List<String> points) {
        match.init();
        for (String point : points) {
            match.incrementScoreFor(point);
        }
    }


}