package LIS;

public class greedySolution {
    int [] arr;

    public greedySolution(int [] arr){
        this.arr=arr;
        findLIS();
    }

    public void findLIS(){
        int[] ans=new int[arr.length];
        int index=1, count=1;
        for (int i=1; i<arr.length; i++){
            if (arr[i-1]<arr[i]){
                ans[index]=arr[i];
                count++;
                index++;
                if (i==1){
                    ans[0]=arr[0];
                    count++;
                }
            }
            else if (arr[i-1]>=arr[i]&&count!=0) break;
        }
        System.out.print("The LIS is: "+ans[0]);
       for (int i=1; i<count-1; i++){
           System.out.print(", "+ans[i]);
       }
    }

    public static void main(String[] args) {
        int [] arr= {0, 8, 9, 12, 2, 10, 6, 14, 1, 9, 5 };
        greedySolution a = new greedySolution(arr);
    }
}
