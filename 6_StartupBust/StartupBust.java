import java.util.ArrayList;

public class StartupBust {
    private GameHelper helper;
    private ArrayList<Startup> startups;
    private int numOfGuesses = 0;

    private void setupGame() {
        helper = new GameHelper();
        startups = new ArrayList<Startup>();
        startups.add(new Startup("poniez"));
        startups.add(new Startup("hacqi"));
        startups.add(new Startup("cabista"));
        for (Startup s : startups) {
            s.setLocationCells(helper.placeStartup(3));
        }

        System.out.println("Your goal is to sink three Startups.");
        System.out.println("poniez, hacqi, cabista");
        System.out.println("Try to sink them all in the fewest number of guesses");
    }

    private void startPlaying() {
        while (!startups.isEmpty()) {
            String userGuess = helper.getUserInput("Enter a guess");
            checkUserGuess(userGuess);
        }
        finishGame();
    }

    private void checkUserGuess(String userGuess) {
        numOfGuesses++;
        String result = "miss";

        for (Startup s : startups) {
            result = s.checkYourself(userGuess);

            if (result.equals("hit") || result.equals("already hit")) {
                break;
            } else if (result.equals("kill")) {
                startups.remove(s);
                break;
            }

        }

        System.out.println(result);

    }

    private void finishGame() {
        System.out.println("All Startups are dead! Your stock is now worthless");
        if (numOfGuesses <= 18) {
            System.out.println("It only took you " + numOfGuesses + " guesses.");
            System.out.println("You got out before your options sank.");
        } else {
            System.out.println("Took you long enough. " + numOfGuesses + " guesses.");
            System.out.println("Fish are dancing with your options");
        }
    }

    public static void main(String[] args) {
        StartupBust game = new StartupBust();
        game.setupGame();
        game.startPlaying();
    }

}