package secretaryProblem;

import java.util.ArrayList;
import java.util.List;

public class fullSearch {
    customer cost[];
    List<customer[]> arr;

    public fullSearch(customer[] cost) {
        this.cost=cost;
        this.arr = new ArrayList<>();
        permutations(cost, 0); //fills arr with all possible permutation of the customer
    }


    public customer[] getBestTreatmentTime (){
        int minIndex=0;
        double sum, min=Integer.MAX_VALUE, cumulativAmount=0;
        for (int i=0; i<this.arr.size(); i++){
            sum=0; cumulativAmount=0;
            for (int j=0; j<this.cost.length; j++){
                cumulativAmount+= this.arr.get(i)[j].t1;
                sum+=cumulativAmount;
            }
            if (sum< min){
                min=sum;
                minIndex=i;
            }
        }
        return this.arr.get(minIndex);
    }

    public void printResult () {
        customer res[] = this.getBestTreatmentTime();
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

    public void swap(customer[] cos, int currentIndex, int i){
        customer temp = cos[currentIndex];
        cos[currentIndex] = cos[i];
        cos[i] = temp;
    }

    public void permutations(customer[] cos, int currentIndex) {
        if (currentIndex == cost.length - 1) {
            customer[] temp = new customer[cos.length];
            for (int i=0; i< cost.length; i++){
                temp[i]= cos[i];
            }
            arr.add(temp);
        }

        for (int i = currentIndex; i < cost.length; i++)
        {
            swap(cos, currentIndex, i);
            permutations(cos, currentIndex + 1);
            swap(cos, currentIndex, i);
        }
    }
    public static void main(String[] args) {
        customer a = new customer(10);
        customer b = new customer(1);
        customer c = new customer(8);
        customer[] arr = new customer[3];
        arr[0] = a;
        arr[1] = b;
        arr[2] = c;
        fullSearch f = new fullSearch(arr);
        f.getBestTreatmentTime();
        f.printResult();
    }
}
