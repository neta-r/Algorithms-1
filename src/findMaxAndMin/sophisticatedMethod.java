package findMaxAndMin;

import java.util.Stack;

public class sophisticatedMethod {
    public static void find2max(int[] arr) {
        int size = arr.length, index = 0;
        boolean even = true;
        if (arr.length%2==1)  {
            size=arr.length-1;
            even=false;
        }
        container[] a = new container[size+1];
        for (int i = 0; i < size; i += 2) {
            if (arr[i] > arr[i + 1]) {
                container temp = new container(arr[i]);
                temp.s.add(arr[i + 1]);
                a[index] = temp;
                index++;
            } else {
                container temp = new container(arr[i + 1]);
                temp.s.add(arr[i]);
                a[index] = temp;
                index++;
            }
        }
        size /= 2;
        while (size>1){
            index=0;
            for (int i = 0; i < size; i += 2) {
                if (a[i].num > a[i + 1].num) {
                    a[i].s.add(a[i + 1].num);
                    a[index] = a[i];
                    index++;
                } else {
                    a[i+1].s.add(a[i].num);
                    a[index] = a[i+1];
                    index++;
                }
            }
            size /= 2;
        }
        if (!even){
            if(arr[arr.length-1]>a[0].num){
                container temp = new container(arr[arr.length-1]);
                temp.s.add(a[0].num);
                temp.s.addAll(a[0].s);
                a[0]=temp;
            }
            else {
                a[0].s.add(arr[arr.length-1]);
            }
        }
        System.out.println("max is: " + a[0].num);
        int max = a[0].s.get(0);
        for (int i = 1; i < a[0].s.size(); i++) {
            if (a[0].s.get(i) > max) max = a[0].s.get(i);
        }
        System.out.println("max is: " + max);
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 84, 54, 3, 7, 0, 8, 1};
        find2max(arr);
        System.out.println("---");
        int[] arr2 = {1, 5, 84, 54, 3, 7, 0, 8, 100};
        find2max(arr2);
    }
}

class container {
    int num;
    Stack<Integer> s;

    public container(int num) {
        this.num = num;
        this.s = new Stack<>();
    }
}
