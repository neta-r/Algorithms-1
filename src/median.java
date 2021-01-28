import java.util.Arrays;

public class median {

    public static int naiveMethode(int[] arr){
        Arrays.sort(arr);
        if (arr.length%2==0) return (arr[arr.length/2]+arr[(arr.length/2)-1])/2;
        return arr[arr.length/2];
    }

    public static int naiveMethode2(int[] arr){
        int max=0;
        for (int i=0; i<arr.length; i++){
            if (arr[i]>max)max=arr[i];
        }
        return max;
    }

    public static int optimal(int[] arr){
        int max=0;
        int size = Math.min(arr.length, 64);
        for (int i=0; i<size; i++){
            if (arr[i]>max)max=arr[i];
        }
        return max;
    }

    public static void main(String[] args) {
        int [] arr = {23,3,8,6,12,77,1};
        int [] arr2= {23,3,6,12,77,1};
        System.out.println(naiveMethode(arr));
        System.out.println(naiveMethode2(arr2));
    }
}
