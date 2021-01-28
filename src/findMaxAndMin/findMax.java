package findMaxAndMin;

public class findMax {
    public static void naiveMethod(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
        }
        System.out.println("max is: " + max);
    }

    public static void minNmax(int[] arr) {
        int max = arr[0], min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
            else {
                if (arr[i] < min) min = arr[i];
            }
        }
        System.out.println("min is: " + min);
        System.out.println("max is: " + max);
    }

    public static void minNmax2(int[] arr) {
        int max = arr[1], min = arr[0], size=arr.length;
        boolean even = true;
        if (arr.length%2==1)  {
            size=arr.length-1;
            even=false;
        }
        if (arr[0] > arr[1]) {
            max = arr[0];
            min = arr[1];
        }
        for (int i = 2; i < size - 1; i += 2) {
            if (arr[i] > arr[i + 1]) {
                if (arr[i] > max) max = arr[i];
                if (arr[i + 1] < min) min = arr[i + 1];
            } else {
                if (arr[i + 1] > max) max = arr[i + 1];
                if (arr[i] < min) min = arr[i];
            }
        }
        if (!even){
            if (arr[size-1]>max) max=arr[size-1];
            else if (arr[size-1]<min) min=arr[size-1];
        }
        System.out.println("min is: " + min);
        System.out.println("max is: " + max);
    }

    public static void main(String[] args) {
        int [] arr = {1,5,84,54,3,7,0,8,1};
        naiveMethod(arr);
        System.out.println("---");
        minNmax(arr);
        System.out.println("---");
        minNmax2(arr);
        System.out.println("---");
        int [] arr2 = {1,5,84,85,54,3,7,0,8,1};
        minNmax2(arr2);
    }
}
