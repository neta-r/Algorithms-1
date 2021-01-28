package numbersGame;

public class greedySolution {
    int [] arr;

    public greedySolution(int [] arr){
        this.arr= arr;
        play();
    }

    public void play(){
        int playaA=0, playaB=0, start=0, end=arr.length-1;
        boolean A= true; //A's turn?
        while (start<=end){
            int num= Math.max(arr[start],arr[end]);
            if (num==arr[start]) start++;
            else end--;
            if (A) {
                playaA+=num;
                A=false;
            }
            else {
                playaB+=num;
                A=true;
            }
        }
        if (playaA>playaB) System.out.println("player A wins! "+ playaA+ " compares to "+playaB+" to player B");
        else System.out.println("player B wins! "+ playaB+ " compares to "+playaA+" to player A");
    }

    public static void main(String[] args) {
        int [] arr= {1, 5, 2, 99, 1, 4};
        greedySolution a = new greedySolution(arr);
    }
}
