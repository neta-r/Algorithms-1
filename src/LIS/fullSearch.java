package LIS;

import java.util.ArrayList;
import java.util.List;

public class fullSearch {
    int [] arr;
    List<int[]> l;

    public fullSearch(int [] arr){
        this.arr=arr;
        this.l= new ArrayList<>();
        findAllCombo();
        findLIS();
    }

    public void findAllCombo(){
        int num=1;
        String t="1";
        while (t.length()-1!=arr.length){
            t=t+0;
        }
        while (Integer.parseInt(t)!=num){
            l.add(translateToMiniArr(num, arr));
            num=plusOne(num);
        }
    }

    public int plusOne(int num){
        int count=0;
        if (num%10==0){
            num+=1;
        }
        else {
            while (num%10!=0){
                count++;
                num/=10;
            }
            num+=1;
            while (count!=0){
                num*=10;
                count--;
            }
        }
        return num;
    }

    public int[] translateToMiniArr(int num, int [] arr){
        int n=num, c=0, count=arr.length-1;
        while (n>0){
            if (n%10==1)c++;
            n/=10;
        }
        int [] res = new int[c];
        int index=c-1;
        while (num>0){
            int last= num%10;
            if (last==1){
                res[index]= arr[count];
                index--;
            }
            num/=10;
            count--;
        }
        return res;
    }

    public void findLIS(){
        int count=0, max=0;
        int [] ans= new int[arr.length];
        for (int i=0; i<l.size(); i++){
            int [] a= l.get(i);
            count=1;
            for(int j=1; j<a.length; j++){
                if (a[j-1]<a[j]) count++;
                if (a[j-1]>=a[j]&&count>0) break;
            }
            if (count>max) {
                max = count;
                ans = a;
            }
        }
        System.out.print("The LIS is: "+ans[0]);
        for (int i=1; i<max; i++){
            System.out.print(", "+ans[i]);
        }

    }
    public static void main(String[] args) {
        int [] arr= {0, 8, 4, 12, 2, 10, 6, 14};
        fullSearch a = new fullSearch(arr);
    }

}
