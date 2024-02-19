import java.util.ArrayList;

public class Startup {
    private String name;
    private ArrayList<String> locationCells;
    private ArrayList<String> hits;

    public Startup(String n){
        name = n;
    }

    public void setLocationCells(ArrayList<String> loc) {
        locationCells = loc;
        hits = new ArrayList<String>();
    }

    public void setName(String n) {
        name = n;
    }

    public String checkYourself(String userInput) {
        String result = "miss";
        int locationIndex = locationCells.indexOf(userInput);
        int hitIndex = hits.indexOf(userInput);

        if(hitIndex >= 0) {
            result = "already hit";
        } else if (locationIndex >= 0) {
            result = "hit";
            locationCells.remove(locationIndex);
            hits.add(userInput);
            if (locationCells.isEmpty()) {
                result = "kill";
                System.out.println("Ouch! You sunk " + name + " :( " );
            }
        }
        return result;
    }
}
