package plainProblem;

import java.util.ArrayList;
import java.util.List;

public class allCheapestPaths {
    node[][] mat;
    int teta ,c=0;
    List<node[]> paths;

    public allCheapestPaths(node[][] mat, int teta) {
        this.mat = mat;
        this.teta=teta;
        this.paths=new ArrayList<>();
        fillMatrix();
        traceBack();
        for (node[] a: paths){
            for (int i=0; i<a.length-1; i++){
                System.out.print(a[i]+ "-> ");
            }
            System.out.print(a[a.length-1]);
            System.out.println("\n");
        }

    }
    public void fillMatrix() {
        mat[0][0].setPrice(0);
        for (int i = 1; i < mat.length; i++) {
            mat[0][i].setPrice(mat[0][i - 1].price + mat[0][i - 1].costRight);
            mat[0][i].setnPaths(1);
            mat[i][0].setPrice(mat[i - 1][0].price + mat[i - 1][0].costDown);
            mat[i][0].setnPaths(1);
        }
        for (int i = 1; i < mat.length; i++) {
            for (int j = 1; j < mat.length; j++) {
                int a = mat[i - 1][j].price + mat[i - 1][j].costDown;
                int b = mat[i][j - 1].price + mat[i][j - 1].costRight;
                if (a>b){
                    mat[i][j].setPrice(b);
                    mat[i][j].setnPaths(mat[i][j - 1].nPaths);
                }
                if (a<b){
                    mat[i][j].setPrice(a);
                    mat[i][j].setnPaths(mat[i - 1][j].nPaths);
                }
                if (a==b){
                    mat[i][j].setPrice(a);
                    mat[i][j].setnPaths(mat[i - 1][j].nPaths+mat[i][j - 1].nPaths);
                }
            }
        }
    }
    public void traceBack() {
        ArrayList<node> a= new ArrayList();
        traceBack(a,  mat.length - 1,  mat.length - 1);
    }

    public void traceBack(ArrayList<node> ans, int ii,int jj) {
        int r=0, d=0;
        for (int i = ii, j = jj; ans.size() < mat.length; ) {
            if (j - 1 >= 0) {
                r = mat[i][j - 1].price + mat[i][j - 1].costRight;
            }
            if (i - 1 >= 0) {
                d = mat[i - 1][j].price + mat[i - 1][j].costDown;
            }

            if (mat[i][j].price == r && mat[i][j].price == d) { // go both
                mat[i][j].nPaths = mat[i - 1][j].nPaths;
                ArrayList<node> a = new ArrayList(); // go down
                a.addAll(ans);
                a.add(mat[i][j - 1]);
                traceBack(a, i, j - 1);
                ans.add(mat[i - 1][j]); // go right
                i--;

            } else if (mat[i][j].price == d) { // go right
                ans.add(mat[i - 1][j]);
                mat[i][j].nPaths = mat[i - 1][j].nPaths;
                i--;
            } else { // go down
                ans.add(mat[i][j - 1]);
                mat[i][j].nPaths = mat[i][j - 1].nPaths;
                j--;
            }
        }
        ans.add(mat[0][0]);
        ans.add(0, mat[mat.length - 1][mat.length - 1]);
        node[] a= new node[ans.size()];
        for (int i=0; i<ans.size(); i++){
            a[i]= ans.get(ans.size()-i-1);
        }
        c++;
        this.paths.add(a);
    }

    public static void main(String[] args) {
        node[][] mat2 = new node[3][3];
        node one = new node(0, 0, 1, 1);
        node two = new node(0, 1, 1, 1);
        node three = new node(0, 2, 1, false);
        node four = new node(1, 0, 1, 1);
        node five = new node(1, 1, 1, 1);
        node six = new node(1, 2, 1, false);
        node seven = new node(2, 0, 1, true);
        node eight = new node(2, 1, 1, true);
        node nine = new node(2, 2);
        mat2[0][0] = one;
        mat2[0][1] = two;
        mat2[0][2] = three;
        mat2[1][0] = four;
        mat2[1][1] = five;
        mat2[1][2] = six;
        mat2[2][0] = seven;
        mat2[2][1] = eight;
        mat2[2][2] = nine;
        allCheapestPaths n = new allCheapestPaths(mat2,10);
    }
}

