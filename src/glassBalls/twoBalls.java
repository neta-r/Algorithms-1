package glassBalls;

public class twoBalls {
    char[] building;

    public twoBalls(char[] building) {
        this.building = building;
        divideToTwo();
        divideToSqrt();
        divideToTriangularNumbers();
        adaptiveAlgorithm();
    }

    public void findFloorWithOneBall(int start, int end) {
        for (int i = start; i < end; i++) {
            if (building[i] == 'V') {
                System.out.println("The ball broke at the " + (i+1) + "'s floor");
                break;
            }
        }
    }


    public void divideToTwo() {
        int middle = building.length / 2, start = 0,  d= middle;
        while (d < building.length) {
            if (building[d] == 'V') {
                findFloorWithOneBall(start, d+1);
                break;
            } else {
                start = middle;
                middle /= 2;
                d =d +middle;
            }
        }
    }

    public void divideToSqrt() {
        int sqrt ,start = 0;
        if (Math.sqrt(building.length) % 1 == 0) sqrt = (int) Math.sqrt(building.length);
        else sqrt = (int) Math.sqrt(building.length)+1;
        int d= sqrt-1;
        while (d <building.length) {
            if (building[d] == 'V') {
                findFloorWithOneBall(start, d+1);
                break;
            } else {
                start = d;
                d = d+sqrt;
            }
        }
    }

    public void divideToTriangularNumbers() {
        int tr[] = findTriangularNumber(building.length);
        int t = tr[0], count=tr[1], start=0 , d = count-1;
        while (d <building.length) {
            if (building[d] == 'V') {
                findFloorWithOneBall(start, d+1);
                break;
            } else {
                start = d;
                count--;
                d = d+count;
            }
        }
    }

    public int[] findTriangularNumber(int num){
        int count = 1, res =1;
        while (num-count>0){
            num=num-count;
            count++;
            res=res+count;
        }
        int r [] = new int[2];
        r[0]=res;
        r[1]=count;
        return r;
    }

    public void adaptiveAlgorithm(){
        int sqrt ,start = 0, size = building.length;
        if (Math.sqrt(size) % 1 == 0) sqrt = (int) Math.sqrt(building.length);
        else sqrt = (int) Math.sqrt(size)+1;
        int d= sqrt-1;
        while (d <building.length) {
            if (building[d] == 'V') {
                findFloorWithOneBall(start, d+1);
                break;
            } else {
                start = d;
                size-=sqrt;
                if (Math.sqrt(size) % 1 == 0) sqrt = (int) Math.sqrt(building.length);
                else sqrt = (int) Math.sqrt(size)+1;
                d = d+sqrt;
            }
        }
    }

    public static void main(String[] args) {
        char[] arr = {'X', 'X', 'X', 'X', 'X', 'V', 'V', 'V', 'V', 'V', 'V', 'V', 'V', 'V'};
        char[] arr2 = {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'V', 'V', 'V', 'V'};
        char[] arr3 = {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'V', 'V'};
        twoBalls a = new twoBalls(arr);
        System.out.println("---");
        twoBalls b = new twoBalls(arr2);
        System.out.println("---");
        twoBalls c = new twoBalls(arr3);
    }
}
