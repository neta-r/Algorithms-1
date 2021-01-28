package matrixOfOnes;

public class dynamicSolution {
    int[][] mat;
    int[][] help;

    public dynamicSolution(int [][] mat){
        this.mat=mat;
        this.help=new int[mat.length][mat.length];
        fillNfind();
    }

    public void fillNfind(){
        for (int i=0; i<mat.length; i++){
            this.help[i][0]=mat[i][0];
            this.help[0][i]=mat[0][i];
        }
        int max=0;
        for (int i=1; i<mat.length; i++){
            for (int j=1; j< mat.length; j++){
                if (this.mat[i][j]==1) {
                    int min= Math.min(help[i-1][j-1],help[i-1][j]);
                    min = Math.min(min,help[i][j-1]);
                    this.help[i][j] = min+1;
                    if (min+1>max) max=min+1;
                }
            }
        }
        System.out.println("The matrix array out of one is built of: "+max+" ones!");
    }

    public static void main(String[] args) {
        int[][] mat = {{0, 0, 1, 0, 0},
                {1, 1, 1, 1, 0},
                {0, 1, 1, 1, 1},
                {1, 1, 1, 1, 0},
                {1, 1, 0, 0, 1}};
        dynamicSolution a = new dynamicSolution(mat);
    }
}