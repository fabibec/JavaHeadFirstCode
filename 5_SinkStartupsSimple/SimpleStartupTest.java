public class SimpleStartupTest {
    public static void main(String[] args) {
        SimpleStartup TestGame = new SimpleStartup();
        int[] locations = {2,3,4};
        TestGame.setLocationCells(locations);

        testGuess(TestGame,2,"Test 1: Valid Guess -> ","hit");
        testGuess(TestGame,0,"Test 2: Invalid Guess -> ","miss");
        testGuess(TestGame,3,"Test 3: Another valid Guess -> ","hit");
        testGuess(TestGame,4,"Test 4: Kill -> ","kill");
    }

    public static void testGuess(SimpleStartup game, int guess, String testName, String expectedResult) {
        String result = game.checkYourself(guess);
        System.out.print(testName);
        if(result.equals(expectedResult)) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }
    }
}