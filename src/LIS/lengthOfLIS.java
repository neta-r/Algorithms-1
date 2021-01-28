package LIS;


public class lengthOfLIS {
    int[] arr;
    int[] help;
    int len;

    public lengthOfLIS(int[] arr){
        this.arr=arr;
        this.help= new int[arr.length];
        this.len=0;
        findLength();
    }

    public void findLength(){
        len=1;
        help[0]=arr[0];
        for (int i=1; i<arr.length; i++){
            int j=binarySearchBetween(help,0, len, arr[i]);
            help[j]=arr[i];
            if (j>=len) len++;
        }
        System.out.println("The length of the LIS is: "+len);
    }

    public int binarySearchBetween (int[] arr, int start, int end, int a){
        while (start<=end){
            if (start==end) return start;
            if (arr[(end-start)/2]==a) return (end-start)/2;
            if (arr[(end-start)/2]>a) end=((end-start)/2)-1;
            else start=((end-start)/2)+1;
        }
        return start;
    }

    public static void main(String[] args) {
        int [] arr= {8, 4, 12, 2, 14, 10};
        lengthOfLIS a = new lengthOfLIS(arr);
    }
}
