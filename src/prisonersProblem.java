import java.util.Arrays;
import java.util.Random;

public class prisonersProblem {
    boolean[] prisoners;
    boolean lamp; // false - off , true - on
    int numOfPr;

    public prisonersProblem(int n) {
        this.prisoners = new boolean[n];
        Arrays.fill(this.prisoners, false);
        this.prisoners[0] = true; //the representative prisoner is not counting himself
        this.lamp = false;
        this.numOfPr = 1; // num of prisoners that visited the room
        System.out.println("number of entrances to the room: " +runSimulation());
    }

    public int runSimulation() {
        Random rand = new Random();
        int count = 0;
        while (numOfPr != this.prisoners.length) {
            int ran = rand.nextInt(this.prisoners.length);
            if (ran == 0 && lamp) {
                lamp = false;
                numOfPr++;
                count++;
                System.out.println("prisoner number "+ran+" has entered the room");
                System.out.println("number of prisoners that the representative prisoner had counted is: "+numOfPr);
            }
            else if (!this.prisoners[ran] && !lamp) {
                lamp = true;
                this.prisoners[ran] = true;
                count++;
                System.out.println("prisoner number "+ran+" has entered the room");
            }
            else {
                count++;
                System.out.println("prisoner number "+ran+" has entered the room");
            }
        }
        System.out.println("all prisoners were in the room! Done!");
        return count;
    }


    public static void main(String[] args) {
        prisonersProblem a = new prisonersProblem(6);
    }
}