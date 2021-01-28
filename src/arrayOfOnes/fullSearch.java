package arrayOfOnes;

import java.util.ArrayList;
import java.util.List;

public class fullSearch {
    int arr[];
    List <int[]> combo;

    public fullSearch(int [] arr){
        this.arr=arr;
        combo = new ArrayList<>();
        findAllCombo();
        findBiggerArray();
    }

    public void findAllCombo(){
        for (int i=0; i < this.arr.length; i++){
            int [] a = new int[this.arr.length-i];
            for (int j=i, index=0; j< this.arr.length; j++, index++){
                a[index]=arr[j];
            }
            this.combo.add(a);
        }
    }


    public void findBiggerArray(){
        int max=0, count=0;
        for (int [] a: this.combo){
            count=0;
            for (int i=0; i<a.length; i++){
                if (a[i]==1) count++;
                else if (a[i]==0 && count>0) break;
            }
            if (count>max) max=count;
        }
        System.out.println("The biggest array out of one is built of: "+max+" ones!");
    }


    public static void main(String[] args) {
        int [] arr= {0,1,0,0,1,1};
        fullSearch a = new fullSearch(arr);
    }
}
