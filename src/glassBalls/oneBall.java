package glassBalls;

public class oneBall {
    char[] building;
    int counter=0;

    public oneBall(char[] building) {
        this.building = building;
        findFloor();
    }

    public void findFloor() {
        for (int i = 0; i < building.length; i++) {
            if (building[i] == 'V') {
                counter++;
                System.out.println("The ball broke at the " + (i+1) + "'s floor");
                System.out.println("Took "+counter+" steps");
                break;
            }
            else counter++;
        }
    }

    public static void main(String[] args) {
        char[] arr = {'X','X','X','X','X','V','V','V','V','V','V','V','V','V'};
        char[] arr2 = {'X','X','X','X','X','X','X','X','X','X','V','V','V','V'};
        oneBall a = new oneBall(arr);
        oneBall b = new oneBall(arr2);
    }
}
