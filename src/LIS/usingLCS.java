package LIS;

import LCS.dynamicSolution;

import java.util.Arrays;

public class usingLCS {
    int[] arr;
    int[] sortedArr;

    public usingLCS(int[] arr) {
        this.arr = arr;
        this.sortedArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            this.sortedArr[i] = arr[i];
        }
        Arrays.sort(sortedArr);
        findLIS();
    }

    public void findLIS() {
        String a = "", b = "";
        for (int i = 0; i < arr.length; i++) {
            a = a + arr[i];
            b = b + sortedArr[i];
        }
        LCS.dynamicSolution m = new dynamicSolution(a, b);
    }

    public static void main(String[] args) {
        int[] arr = {0, 8, 4, 12, 2, 10, 6, 14};
        usingLCS a = new usingLCS(arr);
    }
}
