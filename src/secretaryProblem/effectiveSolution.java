package secretaryProblem;

import java.util.Arrays;

public class effectiveSolution {
    customer[] cost;

    public effectiveSolution(customer[] cost) {
        Arrays.sort(cost);
        this.cost = cost;
    }

    public customer[] getBestTreatmentTime (){
        return this.cost;
    }

    public void printResult (){
        for (secretaryProblem.customer customer : this.cost) {
            System.out.println(customer);
        }
    }


    public static void main(String[] args) {
        customer a= new customer(10);
        customer b= new customer(1);
        customer c= new customer(8);
        customer[] arr = new customer[3];
        arr[0]= a;
        arr[1]= b;
        arr[2]= c;
        effectiveSolution f = new effectiveSolution(arr);
        f.printResult();
    }
}
