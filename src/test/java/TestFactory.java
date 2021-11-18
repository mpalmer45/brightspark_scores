import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TestFactory {
    // load a test csv file
    public List<String[]> getTestCSV(String fileName) {
        List<String[]> decodedCSV = new ArrayList<>();
        try {
            decodedCSV = CSVHelper.readCsv(new File(fileName));
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        return decodedCSV;
    }

    // check a player object is created correctly
    public List<Player> getPlayersFromCSV(String fileName) {
        List<String[]> decodedCSV = getTestCSV(fileName);
        return Player.getPlayersFromCSV(decodedCSV);
    }

    // get players with in the same division with different points
    public List<Player> getPlayersOnlyDifferentPoints(List<Integer> points) {
        List<Player> players = new ArrayList<>();

        for(Integer p : points) {
            players.add(new Player("FN"+p, "LN"+p, "2018-10-10", 0, p, "SUMMARY"+points));
        }

        return players;
    }

    // get players with the same points but with different divisions
    public List<Player> getPlayersOnlyDifferentDivisions(List<Integer> divisions) {
        List<Player> players = new ArrayList<>();

        for(Integer d : divisions) {
            players.add(new Player("FN"+d, "LN"+d, "2019-10-10", d, 50, "SUMMARY"+divisions));
        }

        return players;
    }

    // get players in different divisions with the same scores - one player has a different division
    public List<Player> getPlayersWithDiffPointsAndDivision() {
        List<Player> players = new ArrayList<>();

        players.add(new Player("Anne", "Elk", "2017-10-10", 0, 75, "Offence"));
        players.add(new Player("Fred", "Bloggs", "2017-10-10", 1, 75, "Defence"));
        players.add(new Player("Freda", "Frenchfry", "2017-10-10", 0, 100, "Offence"));
        players.add(new Player("Graeme", "Garden", "2017-10-10", 1, 110, "Defence"));
        players.add(new Player("Lois", "Lane", "2017-10-10", 0, 50, "Offence"));
        players.add(new Player("Myron", "Moone", "2017-10-10", 1, 40, "Defence"));

        return players;
    }

    // get records
    public List<Record> getRecords() {
        List<Player> players = getPlayersWithDiffPointsAndDivision();
        return Record.getRecordsFromPlayers(players);
    }
}
