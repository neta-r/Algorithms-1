package LIS;

public class dynamicSolution {
    int[] arr;
    int[][] mat;

    public dynamicSolution(int[] arr) {
        this.arr = arr;
        this.mat = new int[arr.length][arr.length];
        fillMat();
    }

    public void fillMat() {
        mat[0][0] = arr[0];
        int count = 1;
        int[] slant = new int[arr.length];
        slant[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int index = binarySearchBetween(slant, 0, count, arr[i]);
             mat[index][index] = arr[i];
            if (index > 0) {
                for (int j = 0; j < index; j++) {
                    mat[index][j] = mat[index - 1][j];
                }
            }
            slant[index] = arr[i];
            if (index>=count) count++;
        }
        System.out.print("The LIS is: " + mat[count-1][0]);
        for (int i = 1; i < count; i++) {
            System.out.print(", " + mat[count-1][i]);
        }
    }

    public int binarySearchBetween(int[] arr, int start, int end, int a) {
        while (start <= end) {
            if (start == end) return start;
            if (arr[start + (end - start) / 2] == a) return start + (end - start) / 2;
            if (arr[start + (end - start) / 2] > a) end = start + ((end - start) / 2);
            else start = start + ((end - start) / 2) + 1;
        }
        return start;
    }

    public static void main(String[] args) {
        int[] arr = {8, 4, 12, 2, 14, 10, 3, 5, 6, 7};
        dynamicSolution a = new dynamicSolution(arr);
    }
}
