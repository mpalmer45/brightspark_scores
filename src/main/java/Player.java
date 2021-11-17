import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Player {
    public static final String FIRSTNAME = "firstname";
    public static final String LASTNAME = "lastname";
    public static final String DATE = "date";
    public static final String DIVISION = "division";
    public static final String POINTS = "points";
    public static final String SUMMARY = "summary";

    private String firstName;
    private String lastName;
    private String date;
    private int division;
    private int points;
    private String summary;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getDivision() {
        return division;
    }

    public void setDivision(int division) {
        this.division = division;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Player() {
    }

    public Player(String firstName, String lastName, String date, int division, int points, String summary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.date = date;
        this.division = division;
        this.points = points;
        this.summary = summary;
    }

    public static List<Player> getPlayersFromCSV(List<String[]> decodedCSV) {
        List<Player> playerList = new ArrayList<>();

        // if we've got not data, return an empty list
        if(decodedCSV.size() == 0)
            return playerList;

        // assume the first line is the column names of the CSV
        String[] headings = decodedCSV.get(0);

        // get the indices of each column into something easy to access
        int firstNameIndex = findInArray(Player.FIRSTNAME, headings);
        int lastNameIndex = findInArray(Player.LASTNAME, headings);
        int dateIndex = findInArray(Player.DATE, headings);
        int divisionIndex = findInArray(Player.DIVISION, headings);
        int pointsIndex = findInArray(Player.POINTS, headings);
        int summaryIndex = findInArray(Player.SUMMARY, headings);

        // get data as a player
        for(int i = 1; i < decodedCSV.size(); i++) {
            // get the decode csv line
            String[] csvLine = decodedCSV.get(i);

            // create a player with default values
            Player player = new Player("","", "", -1, -1, "");

            // using the indices gathered earlier, get CSV values and place in player using setters
            if(firstNameIndex != -1) {
                player.setFirstName(csvLine[firstNameIndex]);
            }

            if(lastNameIndex != -1) {
                player.setLastName(csvLine[lastNameIndex]);
            }

            if(dateIndex != -1) {
                player.setDate(csvLine[dateIndex]);
            }

            if(divisionIndex != -1) {
                try {
                    player.setDivision(Integer.parseInt(csvLine[divisionIndex]));
                } catch (Exception e) {
                    // leave as is
                }
            }

            if(pointsIndex != -1) {
                try {
                    player.setPoints(Integer.parseInt(csvLine[pointsIndex]));
                } catch (Exception e) {
                    // leave as is
                }
            }

            if(summaryIndex != -1) {
                player.setSummary(csvLine[summaryIndex]);
            }

            // place player in list
            playerList.add(player);
        }

        // return list of players
        return playerList;
    }

    // find a string match in array
    private static int findInArray(String searchString, String[] array) {
        for(int i = 0; i < array.length; i++) {
            String s = array[i];
            if(s.equals(searchString)) {
                return i;
            }
        }
        return -1;
    }

    // sort players
    public static List<Player> sortPlayers(List<Player> players) {
        List<Player> sortedPlayers = new ArrayList<>();

        if(players == null)
            return sortedPlayers;

        // sort by points
        players.sort(new Comparator<Player>() {
            @Override
            public int compare(Player p1, Player p2) {
                return Integer.compare(p2.getPoints(), p1.getPoints());
            }
        });

        // sort by division
        players.sort(new Comparator<Player>() {
            @Override
            public int compare(Player p1, Player p2) {
                return Integer.compare(p1.getDivision(), p2.getDivision());
            }
        });

        return players;
    }

    // get top three players
    public static List<Player> topTreePlayers(List<Player> players) {
        List<Player> topThreePlayers = new ArrayList<>();

        int count = 0;
        for(Player p : players) {
            if(count >= 3) {
                break;
            }

            topThreePlayers.add(p);
            count++;
        }

        return topThreePlayers;
    }

    @Override
    public String toString() {
        return "Player{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", date='" + date + '\'' +
                ", division=" + division +
                ", points=" + points +
                ", summary='" + summary + '\'' +
                '}';
    }
}
