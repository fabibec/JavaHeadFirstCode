public class SimpleStartup {
    private int[] locationCells;
    private int[] hits;
    private int numOfHits;

    public void setLocationCells(int[] locs) {
        locationCells = locs;
        hits = new int[locs.length];
        for (int i = 0; i < locs.length; i++) {
            hits[i] = -1;
        }
    }

    private boolean isAlreadyHit(int guess) {
        for (int hit : hits) {
            if (guess == hit) {
                return true;
            }
        }
        hits[numOfHits] = guess;
        return false;
    }

    public String checkYourself(int guess) {
        String result = "miss";

        for (int cell : locationCells) {
            if (guess == cell) {
                if (isAlreadyHit(guess)) {
                    result = "hit";
                    break;
                }

                numOfHits++;
                if (numOfHits == locationCells.length) {
                    result = "kill";
                } else {
                    result = "hit";
                }
                break;
            }

        }

        System.out.println(result);
        return result;
    }
}