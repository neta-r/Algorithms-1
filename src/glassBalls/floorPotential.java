package glassBalls;

import java.util.Random;

public class floorPotential {
    int building;
    int ballPotential;
    int[] potential;

    public floorPotential(int building, int ballPotential) {
        this.building = building;
        this.potential = new int[building];
        this.ballPotential = ballPotential;
        randomizePotential();
        findFloor();

    }

    public void randomizePotential(){
        Random rd = new Random();
        potential[0]=rd.nextInt(ballPotential+10);
        for (int i=1; i<potential.length; i++){
            int rad = rd.nextInt(ballPotential+potential[i-1]);
            while (rad<potential[i-1]){
                rad=rd.nextInt(ballPotential+potential[i-1]);
            }
            potential[i]=rad;
        }
    }

    public void findFloor(){
        for (int i=0; i<potential.length; i++){
            if (potential[i]>ballPotential) {
                System.out.println("The ball will break at the "+i+"'s floor!");
                System.out.println("The floor potential is: "+potential[i]);
                break;
            }
        }
    }


    public static void main(String[] args) {
        floorPotential a = new floorPotential(14,19);
        System.out.println("---");
        floorPotential b = new floorPotential(8,5);
        System.out.println("---");
        floorPotential c = new floorPotential(10,8);
    }
}