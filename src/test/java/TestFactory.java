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

    // TODO get players with in the same division with different scores

    // TODO get players in different divisions with the same scores - one player has a different division

    // TODO get players in different divisions and different scores

    // TODO get a yaml output from test players
}
