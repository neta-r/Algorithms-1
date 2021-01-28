package numbersGame;

public class evenOddStrategy {
    int[] arr;

    //Assuming the array has an even number of ints.
    public evenOddStrategy(int[] arr) {
        this.arr = arr;
        play();
    }

    public void play() {
        int sumOdd = 0, sumEven = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) sumEven += arr[i];
            else sumOdd += arr[i];
        }
        int playaA = 0, playaB = 0, start = 0, end = arr.length - 1;
        boolean even = false;
        if (sumEven > sumOdd) {
            even = true;
        }
        boolean A = true; //A's turn?
        while (start <= end) {
            if (A) {
                if ((start % 2 == 0 && even) || ((start % 2 == 1 && !even))) {
                    playaA += arr[start];
                    start++;
                    A=false;
                } else { //(end % 2 == 0 && even) || (end % 2 == 1 && !even)
                    playaA += arr[end];
                    end--;
                    A=false;
                }
            } else {
                int num = Math.max(arr[start], arr[end]);
                if (num == arr[start]) start++;
                else end--;
                playaB += num;
                A = true;
            }
        }
        if (playaA>playaB) System.out.println("player A wins! "+ playaA+ " compares to "+playaB+" to player B");
        else System.out.println("player B wins! "+ playaB+ " compares to "+playaA+" to player A");
    }
    public static void main(String[] args) {
        int [] arr= {9, 5, 2, 8, 1, 4};
        evenOddStrategy a = new evenOddStrategy(arr);
    }
}
