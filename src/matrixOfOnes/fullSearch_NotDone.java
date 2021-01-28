package matrixOfOnes;

import java.util.ArrayList;
import java.util.List;

public class fullSearch_NotDone {

    int mat[][];
    List<int[][]> combo;

    public fullSearch_NotDone(int[][] mat) {
        this.mat = mat;
        this.combo = new ArrayList<>();
        findAllCombo();
        System.out.println();
        //findBiggerArray();
    }

    public void findAllCombo() {
//        for (int i = 0; i < this.mat.length; i++) {
//            for (int k = 0; k < this.mat.length; k++) {
//
//                int[][] a = new int[this.mat.length - k][this.mat.length - k];
//                for (int j = i, indexi = 0; j < this.mat.length - k; j++, indexi++) {
//                    for (int m = k, indexj = 0; m < this.mat.length; m++, indexj++) {
//                        a[indexi][indexj] = mat[j][m];
//                    }
//                }
//                this.combo.add(a);
//            }
//
//        }
        int size = mat.length;
        int k;
        while (size > 0) {
            k = 0;
            while (k < mat.length - size + 1) {
                int[][] a = new int[size][size];
                for (int i = 0, indexi = 0; indexi < size; i++, indexi++) {
                    for (int j = 0, indexj = 0; indexj < size; j++, indexj++) {
                        a[indexi][indexj] = mat[i][j];
                    }
                }
                this.combo.add(a);
                k++;
            }
            size--;
        }
    }

    //
//    public void findBiggerArray(){
//        int max=0, count=0;
//        for (int [] a: this.combo){
//            count=0;
//            for (int i=0; i<a.length; i++){
//                if (a[i]==1) count++;
//                else if (a[i]==0 && count>0) break;
//            }
//            if (count>max) max=count;
//        }
//        System.out.println("The biggest array out of one is built of: "+max+" ones!");
//    }
    public static void main(String[] args) {
        int[][] mat = {{0, 0, 1},
                {1, 1, 1},
                {0, 1, 1}};
        fullSearch_NotDone a = new fullSearch_NotDone(mat);
    }
}
