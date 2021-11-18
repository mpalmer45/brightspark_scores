import java.util.ArrayList;
import java.util.List;

public class Record {
    private String name;
    private String details;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Record(String name, String details) {
        this.name = name;
        this.details = details;
    }

    @Override
    public String toString() {
        return "Record{" +
                "name='" + name + '\'' +
                ", details='" + details + '\'' +
                '}';
    }

    // get records from a list of players
    public static List<Record> getRecordsFromPlayers(List<Player> players) {
        List<Record> records = new ArrayList<>();
        if(players == null || players.size() == 0) {
            return records;
        }

        // conversion to records occurs here
        for(Player p : players) {
            Record r = new Record(
                    p.getFirstName() + " " + p.getLastName(),
                    "In division " + p.getDivision() + " from " + p.getDate() + " performing " + p.getSummary()
            );
            records.add(r);
        }

        return records;
    }
}
