class Team {
    protected String name;
    protected int matchesPlayed;
    protected int wins;
    protected int draws;

    // Constructor
    Team(String name, int matchesPlayed, int wins, int draws) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.wins = wins;
        this.draws = draws;
    }

    // Method to be overridden
    int calculatePoints() {
        return 0;
    }

    @Override
    public String toString() {
        return "Team: " + name +
               "\nMatches Played: " + matchesPlayed +
               "\nWins: " + wins +
               "\nDraws: " + draws +
               "\nPoints: " + calculatePoints();
    }
}

// Cricket Team
class CricketTeam extends Team {

    CricketTeam(String name, int matchesPlayed, int wins, int draws) {
        super(name, matchesPlayed, wins, draws);
    }

    // Cricket: Win = 2 points, Draw = 1 point
    @Override
    int calculatePoints() {
        return (wins * 2) + (draws * 1);
    }
}

// Football Team
class FootballTeam extends Team {

    FootballTeam(String name, int matchesPlayed, int wins, int draws) {
        super(name, matchesPlayed, wins, draws);
    }

    // Football: Win = 3 points, Draw = 1 point
    @Override
    int calculatePoints() {
        return (wins * 3) + (draws * 1);
    }
}

// Main class
public class Main {
    public static void main(String[] args) {

        CricketTeam cricket = new CricketTeam(
            "Bhutan Cricket Team", 10, 6, 2
        );

        FootballTeam football = new FootballTeam(
            "Bhutan Football Team", 10, 5, 3
        );

        System.out.println("Cricket Team:");
        System.out.println(cricket);

        System.out.println("\nFootball Team:");
        System.out.println(football);
    }
}