import java.util.Objects;

class Player implements Comparable<Player> {
    private String firstName;
    private String lastName;
    private int points;

    public Player(String firstName, String lastName, int points) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.points = points;
    }

    public String printInfo() {
        return lastName + " " + firstName + ";" + points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return points == player.points &&
                Objects.equals(firstName, player.firstName) &&
                Objects.equals(lastName, player.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, points);
    }

    @Override
    public int compareTo(Player p) {
        if (this.points > p.points)
            return 1;
        if (this.points < p.points)
            return -1;
        int lastNameCompare = this.lastName.compareTo(p.lastName);
        if (lastNameCompare != 0)
            return lastNameCompare;
        return this.firstName.compareTo(p.firstName);
    }

    @Override
    public String toString() {
        return "Player{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", points=" + points +
                '}';
    }
}


