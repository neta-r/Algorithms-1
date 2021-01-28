package arrayOfOnes;

public class greedySolution {
    int arr[];

    public greedySolution(int [] arr){
        this.arr = arr;
        findBiggerArray();
    }

    public void findBiggerArray(){
        int count=0;
        for (int i=0; i<arr.length; i++){
            if (arr[i]==1) count++;
            if (arr[i]==0&&count>0)break;
        }
        System.out.println("The biggest array out of one is built of: "+count+" ones!");
    }

    public static void main(String[] args) {
        int [] arr= {0,0,1,1,0,0,1,1,1,0,0,0};
        greedySolution a = new greedySolution(arr);
    }
}
