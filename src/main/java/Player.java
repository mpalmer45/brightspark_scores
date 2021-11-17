public class Player {
    private String firstName;
    private String lastName;
    private String date;
    private int division;
    private int points;
    private String summary;

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
