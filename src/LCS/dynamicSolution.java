package LCS;

public class dynamicSolution {
    String a;
    String b;
    int [][] mat;

    public dynamicSolution(String a, String b){
        this.a=a;
        this.b=b;
        this.mat= new int[a.length()+1][b.length()+1];
        fillMax();
        System.out.println(traceBack());
    }

    public void fillMax(){
        for (int i=1; i<mat.length; i++){
            for (int j=1; j<mat[0].length; j++){
                if (a.charAt(i-1)==b.charAt(j-1)){
                    this.mat[i][j]=this.mat[i-1][j-1]+1;
                }
                else{
                    this.mat[i][j]=Math.max(mat[i-1][j], mat[i][j-1]);
                }
            }
        }
    }

    public String traceBack(){
        String ans = "";
        int i= mat.length-1, j= mat[0].length-1;
        while (i>0&&j>0){
            if (a.charAt(i-1)==b.charAt(j-1)){
                i--;
                j--;
                ans= a.charAt(i)+ans;
            }
            else if (mat[i][j]==mat[i-1][j]){
                i--;
            }
            else if  (mat[i][j]==mat[i][j-1]){
                j--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        dynamicSolution a= new dynamicSolution("abcbdab", "bdcaba");
    }

}
