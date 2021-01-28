package numbersGame;

public class improvedEvenOdd {
    int[] arr;

    //Assuming the array has an even number of ints.
    public improvedEvenOdd(int[] arr) {
        this.arr = arr;
        play();
    }

    public boolean calculateEven(int start, int end){
        int sumOdd = 0, sumEven = 0;
        for (int i = start; i <= end; i++) {
            if (i % 2 == 0) sumEven += arr[i];
            else sumOdd += arr[i];
        }
        if (sumEven>sumOdd) return true;
        return false;
    }

    public void play() {
        int playaA = 0, playaB = 0, start = 0, end = arr.length - 1;
        boolean A = true; //A's turn?
        while (start <= end) {
            if (A) {
                boolean even = calculateEven(start,end);
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
        int [] arr= {1, 3, 6, 1, 3 ,6};
        improvedEvenOdd a = new improvedEvenOdd(arr);
    }
}
