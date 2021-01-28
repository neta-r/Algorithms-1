package glassBalls;

public class dynamicSolution {

    public static int[] check2balls(int numOfFloors) {
        int[] arr = new int[numOfFloors + 1];
        if (numOfFloors>0) arr[0] = 0;
        if (numOfFloors>1) arr[1] = 1;
        if (numOfFloors>2) arr[2] = 2;
        int min;
        for (int i = 3; i < arr.length; i++) {
            min = arr.length;
            for (int j = 1; j < i-1; j++) {
                int a = Math.max(arr[i-j], j)+1;
                if (a < min) min = a;
            }
            arr[i] = min;
        }
        return arr;
    }
    public static int[] check3balls(int numOfFloors) {
        int[] arr3 = new int[numOfFloors + 1];
        if (numOfFloors>0) arr3[0] = 0;
        if (numOfFloors>1) arr3[1] = 1;
        if (numOfFloors>2) arr3[2] = 2;
        if (numOfFloors>3) arr3[3] = 3;
        int [] arr2 = check2balls(numOfFloors);
        int min;
        for (int i = 4; i < arr3.length; i++) {
            min = arr3.length;
            for (int j=1; j< i-1; j++){
                int a = Math.max(arr3[i-j], arr2[j-1])+1;
                if (a < min) min = a;
            }
            arr3[i] = min;
        }
        return arr3;
    }
    public static int[] check_n_balls(int numOfFloors, int numOfBalls) {
        if (numOfBalls==2) return check2balls(numOfFloors);
        if (numOfBalls==3) return check3balls(numOfFloors);
        int [][] mat = new int[numOfBalls+1][numOfFloors+1];
        for (int i=0; i< numOfFloors+1; i++){
            mat[0][i]=0;
            mat[1][i]=i;
        }
        mat[2]=check2balls(numOfFloors);
        mat[3]=check3balls(numOfFloors);
        int min;
        for (int k=4; k<numOfBalls+1; k++){
            mat[k][0]=0;
            mat[k][1]=1;
            mat[k][2]=2;
            for (int i = 3; i < numOfFloors+1; i++) {
                min = numOfFloors+1;
                for (int j=1; j< i-1; j++){
                    int a = Math.max(mat[k][i-j], mat[k-1][j-1])+1;
                    if (a < min) min = a;
                }
                mat[k][i] = min;
            }
        }
        return mat[numOfBalls];
    }



    public static void main(String[] args) {
        System.out.println(check2balls(30)[30]);
        System.out.println(check3balls(30)[30]);
        System.out.println(check_n_balls(10, 4)[10]);
    }
}
