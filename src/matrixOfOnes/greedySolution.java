package matrixOfOnes;

public class greedySolution {
    int[][] mat;

    public greedySolution(int[][] mat) {
        this.mat = mat;
        findBiggerArray();
    }

    public void findBiggerArray() {
        int count = 0;
        boolean flag = true;
        for (int i = 0; i < mat.length && flag; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) count++;
                if (mat[i][j] == 0 && count > 0){
                    flag = false;
                    break;
                }
            }

        }
        System.out.println("The biggest matrix out of one is built of: " + count + " ones!");
    }

    public static void main(String[] args) {
        int[][] mat = {{0, 0, 1, 0, 0},
                        {1, 1, 1, 1, 0},
                        {0, 1, 1, 1, 1},
                        {1, 1, 1, 1, 0},
                        {1, 1, 0, 0, 1}};
        greedySolution a = new greedySolution(mat);
    }
}
