package numbersGame;

import java.util.Arrays;

public class dynamicSolution {
    int[] arr;
    int[][] mat;

    public dynamicSolution(int[] arr) {
        this.arr = arr;
        this.mat = new int[arr.length][arr.length];
        fillMatrix();
        int [] res = traceBack();
        System.out.println("This is how the game went: ");
        boolean A= true;
        for (int i=0; i<res.length; i++){
            if (A){
                System.out.println("Player A took: "+res[i]);
                A=false;
            }
            else {
                System.out.println("Player B took: " + res[i]);
                A = true;
            }
        }
    }

    public void fillMatrix() {
        for (int i = 0; i < mat.length; i++) {
            mat[i][i] = this.arr[i];
        }
        for (int k = 1; k <= mat.length - 1; k++) {
            for (int i = mat.length - 1 - k, j = mat.length - 1; i >= 0; i--, j--) {
                mat[i][j] = Math.max(arr[i] - mat[i + 1][j], arr[j] - mat[i][j - 1]);
            }
        }
    }

    public int[] traceBack() {
        int sumA=0, sumB=0;
        boolean A= true;
        int [] res = new int[arr.length];
        int index= 0;
        for (int i=0, j= mat.length-1; i<mat.length && j>0;){
            if (mat[i][j]==arr[j] - mat[i][j-1]){
                if (A) {
                    sumA+=arr[j];
                    A=false;
                }
                if (!A){
                    sumB+=arr[j];
                    A=true;
                }
                res[index]=arr[j];
                index++;
                j--;
            }
            else {
                if (A) {
                    sumA+=arr[i];
                    A=false;
                }
                if (!A){
                    sumB+=arr[i];
                    A=true;
                }
                res[index]=arr[i];
                index++;
                i++;
            }
        }
        if (sumA>sumB) System.out.println("player A wins! "+ sumA+ " compares to "+sumB+" to player B");
        else System.out.println("player B wins! "+ sumB+ " compares to "+sumA+" to player A");
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 6, 1, 3, 6};
        dynamicSolution a = new dynamicSolution(arr);
    }
}
