import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class Tests {
    private TestFactory factory = new TestFactory();

    // test csv decoder with a simple CSV
    @Test
    public void testCSV() {
        List<String[]> decodedCSV = factory.getTestCSV("test_data/one_entry.csv");

        Assert.assertEquals(2, decodedCSV.size());
        Assert.assertEquals("firstname", decodedCSV.get(0)[0]);
        Assert.assertEquals("John", decodedCSV.get(1)[0]);
    }

    // test csv to player object working as expected
    @Test
    public void testGenPlayer() {
        List<Player> players = factory.getPlayersFromCSV("test_data/one_entry.csv");

        Player player = players.get(0);

        Assert.assertEquals("Schmidt", player.getLastName());
        Assert.assertEquals(50, player.getPoints());
    }

    // test csv to player with no data
    @Test
    public void testGenPlayerWithNoData() {
        List<Player> players = factory.getPlayersFromCSV("test_data/empty_entry.csv");

        Assert.assertEquals(0, players.size());
    }

    // test csv to player with mistyped headings
    @Test
    public void testGenPlayerWithMistypedCSVHeadings() {
        List<Player> players = factory.getPlayersFromCSV("test_data/mistyped_entry.csv");

        Player player = players.get(0);

        Assert.assertEquals("", player.getLastName());
        Assert.assertEquals(-1, player.getPoints());
    }

    // test csv to player with just headings
    @Test
    public void testGenPlayersWithOnlyHeadings() {
        List<Player> players = factory.getPlayersFromCSV("test_data/only_heading.csv");

        Assert.assertEquals(0, players.size());
    }

    // TODO test sort by division

    // TODO test sort by points

    // TODO test sort by division and points

    // TODO test yaml output
}
