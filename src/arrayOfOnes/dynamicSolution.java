package arrayOfOnes;

public class dynamicSolution {
    int[] arr;
    int [] help;

    public dynamicSolution(int [] arr){
        this.arr=arr;
        this.help= new int[arr.length];
        findBiggerArray();
    }

    public void findBiggerArray(){
        int count=0, max=0;
        if (arr[0]==1) {
            help[0]++;
            count++;
        }
        for (int i=1; i<arr.length; i++){
            if (arr[i]==1){
                help[i]=help[i-1]+1;
                count++;
            }
            else {
                if (count>max) max=count;
                count=0;
            }
        }
        if (count>max) max=count;
        System.out.println("The biggest array out of one is built of: "+max+" ones!");
    }
    public static void main(String[] args) {
        int [] arr= {0,1,0,0,1,1};
        dynamicSolution a = new dynamicSolution(arr);
    }
}
