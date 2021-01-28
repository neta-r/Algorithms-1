package findMaxAndMin;

public class find2max {
    public static void naiveMethod(int[] arr) {
        int max = arr[0], max2 = arr[1];
        if (max < max2) {
            max = arr[1];
            max2 = arr[0];
        }
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] > max) {
                max2 = max;
                max = arr[i];
            } else if (arr[i] > max2) max2 = arr[i];
        }
        System.out.println("min is: " + max);
        System.out.println("other max is: " + max2);
    }

    public static void twoMax(int[] arr) {
        int max = arr[0], max2 = arr[1];
        if (max < max2) {
            max = arr[1];
            max2 = arr[0];
        }
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] > max2) {
                if (arr[i] > max) {
                    max2 = max;
                    max = arr[i];
                } else max2 = arr[i];
            }
        }
        System.out.println("min is: " + max);
        System.out.println("other max is: " + max2);
    }

    public static void twoMax2(int[] arr) {
        int max = arr[0], max2 = arr[1],  size=arr.length;
        boolean even = true;
        if (arr.length%2==1)  {
            size=arr.length-1;
            even=false;
        }
        if (max < max2) {
            max = arr[1];
            max2 = arr[0];
        }
        for (int i = 2; i < size-1; i+=2) {
            if (arr[i]>arr[i+1]){
                if (arr[i]>max){
                    max2=max;
                    max=arr[i];
                    if (arr[i+1]>max2) max2=arr[i+1];
                }
                else {
                    if (arr[i]>max2) max2=arr[i];
                }
            }
            else {
                if (arr[i+1]>max){
                    max2=max;
                    max=arr[i+1];
                    if (arr[i]>max2) max2=arr[i];
                }
                else {
                    if (arr[i+1]>max2) max2=arr[i+1];
                }
            }
        }
        if (!even){
            if (arr[size-1]>max){
                max2=max;
                max=arr[size-1];
            }
            else if (arr[size-1]>max2) max2=arr[size-1];
        }
        System.out.println("min is: " + max);
        System.out.println("other max is: " + max2);
    }
    public static void main(String[] args) {
        int [] arr = {1,5,84,54,3,7,0,8,1};
        naiveMethod(arr);
        System.out.println("---");
        twoMax(arr);
        System.out.println("---");
        twoMax2(arr);
        System.out.println("---");
        int [] arr2 = {1,5,84,85,54,3,7,0,8,1};
        twoMax2(arr2);
    }
}