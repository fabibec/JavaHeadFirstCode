public class SimpleStartupGame {
    public static void main (String[] args) {
        SimpleStartup game = new SimpleStartup();
        GameHelper helper = new GameHelper();
        int numOfGuesses = 0;

        int[] startupLocations = new int[3];
        startupLocations[0] = (int)(Math.random() * 10);
        for (int i = 1; i < 3; i++) {
            startupLocations[i] = startupLocations[i-1] + 1;
        }
        game.setLocationCells(startupLocations);

        String result;
        int input;
        do {
            input = helper.getUserInput("enter a number");
            result = game.checkYourself(input);
            numOfGuesses++;
            if(result.equals("kill")){
                System.out.println("You took " + numOfGuesses + " guesses.");
                break;
            }
        } while (!result.equals("kill"));
    }
}