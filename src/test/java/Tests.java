import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
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

    // sort by points
    @Test
    public void testSortByPoints() {
        List<Integer> points = new ArrayList<>();
        points.add(50);
        points.add(100);
        points.add(75);

        List<Player> players = factory.getPlayersOnlyDifferentPoints(points);
        List<Player> sortedPlayers = Player.sortPlayers(players);

        Assert.assertEquals(100, sortedPlayers.get(0).getPoints());
        Assert.assertEquals(75, sortedPlayers.get(1).getPoints());
        Assert.assertEquals(50, sortedPlayers.get(2).getPoints());
    }

    // test sort by division
    @Test
    public void testSortByDivision() {
        List<Integer> divisions = new ArrayList<>();
        divisions.add(0);
        divisions.add(2);
        divisions.add(1);

        List<Player> players = factory.getPlayersOnlyDifferentDivisions(divisions);
        List<Player> sortedPlayers = Player.sortPlayers(players);

        Assert.assertEquals(0, sortedPlayers.get(0).getDivision());
        Assert.assertEquals(1, sortedPlayers.get(1).getDivision());
        Assert.assertEquals(2, sortedPlayers.get(2).getDivision());
    }

    // test sort by division and points
    @Test
    public void testGeneralSort() {
        List<Player> players = factory.getPlayersWithDiffPointsAndDivision();
        List<Player> sortedPlayers = Player.sortPlayers(players);

        Assert.assertEquals(0, sortedPlayers.get(0).getDivision());
        Assert.assertEquals(0, sortedPlayers.get(1).getDivision());
        Assert.assertEquals(100, sortedPlayers.get(0).getPoints());
        Assert.assertEquals(75, sortedPlayers.get(1).getPoints());

        Assert.assertEquals(1, sortedPlayers.get(3).getDivision());
        Assert.assertEquals(1, sortedPlayers.get(4).getDivision());
        Assert.assertEquals(110, sortedPlayers.get(3).getPoints());
        Assert.assertEquals(75, sortedPlayers.get(4).getPoints());
    }

    // test three results
    @Test
    public void testThreeResults() {
        List<Player> players = factory.getPlayersWithDiffPointsAndDivision();
        List<Player> sortedPlayers = Player.topTreePlayers(Player.sortPlayers(players));

        Assert.assertEquals(3, sortedPlayers.size());

        Assert.assertEquals(0, sortedPlayers.get(0).getDivision());
        Assert.assertEquals(0, sortedPlayers.get(1).getDivision());
        Assert.assertEquals(100, sortedPlayers.get(0).getPoints());
        Assert.assertEquals(75, sortedPlayers.get(1).getPoints());
    }

    // test record generation
    @Test
    public void testRecordGeneration() {
        List<Record> records = factory.getRecords();

        Assert.assertEquals("Anne Elk", records.get(0).getName());
        Assert.assertEquals("In division 1 from 2017-10-10 performing Defence", records.get(1).getDetails());
    }

    // test YAML output
    @Test
    public void testYAMLOutput() {
        List<Record> records = factory.getRecords();
        List<Record> oneRecords = new ArrayList<>();
        oneRecords.add(records.get(0));

        try {
            String yamlString = YAMLHelper.generateYAML(oneRecords);
            Assert.assertEquals("- name: \"Anne Elk\"\n" +
                    "  details: \"In division 0 from 2017-10-10 performing Offence\"\n", yamlString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            Assert.fail("There was an exception when converting to a YAML string");
        }
    }

    // TODO test yaml output
}
