public class fibonacci {
    public static int recursive(int n){
        if (n==1||n==2) return 1;
        return recursive(n-1)+recursive(n-2);
    }

    public static int loopNmatrix(int n){
        int [][] mat= {{1,1},{1,0}};
        int [][] res = {{1,1},{1,0}};
        if (n==1||n==2) return 1;
        for (int i=0; i<n-2; i++){
            res=mul(res,mat);
        }
        return res[0][0];
    }

    public static int recNmatrix(int n){
        int [][] mat= {{1,1},{1,0}};
        return recNmatrix(n, mat);
    }

    public static int recNmatrix(int n, int[][] res){
        if (n==2) return res[0][0];
        int [][] mat= {{1,1},{1,0}};
        res=mul(res, mat);
        return recNmatrix(n-1, res);
    }

    private static int[][] mul(int[][] one, int[][] two){
        int [][] res= new int[2][2];
        res[0][0]=one[0][0]*two[0][0]+one[0][1]*two[1][0];
        res[0][1]=one[0][0]*two[0][1]+one[0][1]*two[1][1];
        res[1][0]=one[1][0]*two[0][0]+one[1][1]*two[1][0];
        res[1][1]=one[1][0]*two[0][1]+one[1][1]*two[1][1];
        return res;
    }

    public static void main(String[] args) {
        System.out.println(recursive(7));
        System.out.println(loopNmatrix(7));
        System.out.println(recNmatrix(7));
    }
}
